using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using System;
using System.Text;
using System.Collections.Generic;
using System.IO;
using SeuProjeto.Generated;

namespace SeuProjeto
{
    public class PicoErrorListener : BaseErrorListener
    {
        public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol,
            int line, int charPositionInLine, string msg, RecognitionException e)
        {
            throw new Exception($"Erro sintático na linha {line}:{charPositionInLine} - {msg}");
        }
    }

    public class PicoVisit : PICOBaseVisitor<string>
    {
        private readonly StringBuilder _output = new();
        private int _indentLevel = 0;
        private readonly Stack<HashSet<string>> _scopes = new();
        private readonly List<string> _errors = new();

        public PicoVisit()
        {
            _scopes.Push(new HashSet<string>());
        }

        public IEnumerable<string> GetErrors() => _errors;

        public override string VisitProgram(PICOParser.ProgramContext context)
        {
            _output.AppendLine("using System;");
            _output.AppendLine("class Program {");
            _output.AppendLine("static int SafeDivide(int a, int b) => b == 0 ? 0 : a / b;");
            _output.AppendLine("static void Main() {");

            foreach (var stmt in context.statement())
            {
                Visit(stmt);
            }

            _output.AppendLine("}}");
            return _output.ToString();
        }

        private void PushScope() => _scopes.Push(new HashSet<string>());
        private void PopScope() => _scopes.Pop();

        private bool IsDeclared(string varName)
        {
            foreach (var scope in _scopes)
            {
                if (scope.Contains(varName)) return true;
            }
            return false;
        }

        private void DeclareVariable(string varName)
        {
            if (IsDeclared(varName))
            {
                _errors.Add($"Variável '{varName}' já declarada neste escopo");
            }
            _scopes.Peek().Add(varName);
        }

        public override string VisitRead_stmt(PICOParser.Read_stmtContext context)
        {
            var varName = context.ID().GetText();
            AddLine($"int {varName} = int.Parse(Console.ReadLine());");
            DeclareVariable(varName);
            return null;
        }

        public override string VisitPrint_stmt(PICOParser.Print_stmtContext context)
        {
            var value = Visit(context.expression());
            AddLine($"Console.WriteLine({value});");
            return null;
        }

        public override string VisitAssign_stmt(PICOParser.Assign_stmtContext context)
        {
            var varName = context.ID().GetText();
            var expr = Visit(context.expression());

            if (!IsDeclared(varName))
            {
                AddLine($"int {varName} = {expr};");
                DeclareVariable(varName);
            }
            else
            {
                AddLine($"{varName} = {expr};");
            }
            return null;
        }

        public override string VisitIf_stmt(PICOParser.If_stmtContext context)
        {
            var cond = Visit(context.condition());
            AddLine($"if ({cond}) {{");
            _indentLevel++;
            PushScope();

            foreach (var stmt in context.thenBlock.statement())
            {
                Visit(stmt);
            }

            PopScope();
            _indentLevel--;

            if (context.elseBlock != null)
            {
                AddLine("} else {");
                _indentLevel++;
                PushScope();

                foreach (var stmt in context.elseBlock.statement())
                {
                    Visit(stmt);
                }

                PopScope();
                _indentLevel--;
            }
            AddLine("}");
            return null;
        }

        public override string VisitWhile_stmt(PICOParser.While_stmtContext context)
        {
            var cond = Visit(context.condition());
            AddLine($"while ({cond}) {{");
            _indentLevel++;
            PushScope();

            foreach (var stmt in context.statements().statement())
            {
                Visit(stmt);
            }

            PopScope();
            _indentLevel--;
            AddLine("}");
            return null;
        }

        public override string VisitExpression(PICOParser.ExpressionContext context)
        {
            var terms = context.term();
            var result = Visit(terms[0]);

            for (int i = 1; i < terms.Length; i++)
            {
                var op = context.GetChild(2 * i - 1).GetText();
                var term = Visit(terms[i]);
                result = $"{result} {op} {term}";
            }
            return result;
        }

        public override string VisitTerm(PICOParser.TermContext context)
        {
            var factors = context.factor();
            var result = Visit(factors[0]);

            for (int i = 1; i < factors.Length; i++)
            {
                var op = context.GetChild(2 * i - 1).GetText();
                var factor = Visit(factors[i]);

                if (op == "/")
                {
                    result = $"SafeDivide({result}, {factor})";
                }
                else
                {
                    result = $"{result} {op} {factor}";
                }
            }
            return result;
        }

        public override string VisitFactor(PICOParser.FactorContext context)
        {
            if (context.NUMBER() != null) return context.NUMBER().GetText();
            if (context.ID() != null)
            {
                if (!IsDeclared(context.ID().GetText()))
                {
                    _errors.Add($"Variável '{context.ID().GetText()}' não declarada");
                }
                return context.ID().GetText();
            }
            return $"({Visit(context.expression())})";
        }

        public override string VisitCondition(PICOParser.ConditionContext context)
        {
            var left = Visit(context.expression(0));
            var right = Visit(context.expression(1));
            return $"{left} {context.rel_op().GetText()} {right}";
        }

        private void AddLine(string line)
        {
            _output.AppendLine($"{new string(' ', _indentLevel * 4)}{line}");
        }
    }
}