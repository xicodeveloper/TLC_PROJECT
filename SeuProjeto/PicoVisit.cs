using Antlr4.Runtime.Misc;
using System.Text;
using System.Linq;
using SeuProjeto.Generated;
using System.Collections.Generic;

namespace SeuProjeto
{
        public class PicoVisit : PICOBaseVisitor<string>
    {
        private readonly StringBuilder _output = new();
        private int _indentLevel = 0;
        private readonly HashSet<string> _variables = new();

        public override string VisitProgram(PICOParser.ProgramContext context)
        {
            _output.AppendLine("using System;");
            _output.AppendLine("class Program {");
            _output.AppendLine("static void Main() {");
            
            foreach (var stmt in context.statement())
            {
                Visit(stmt);
            }
            
            _output.AppendLine("}}");
            return _output.ToString();
        }

        // Implementações específicas para cada regra
        public override string VisitRead_stmt(PICOParser.Read_stmtContext context)
        {
            var varName = context.ID().GetText();
            AddLine($"int {varName} = int.Parse(Console.ReadLine());");
            _variables.Add(varName);
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
            
            if (!_variables.Contains(varName))
            {
                AddLine($"int {varName} = {expr};");
                _variables.Add(varName);
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
            
            foreach (var stmt in context.thenBlock.statement())
            {
                Visit(stmt);
            }
            
            _indentLevel--;
            if (context.elseBlock != null)
            {
                AddLine("} else {");
                _indentLevel++;
                
                foreach (var stmt in context.elseBlock.statement())
                {
                    Visit(stmt);
                }
                
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
            
            foreach (var stmt in context.statements().statement())
            {
                Visit(stmt);
            }
            
            _indentLevel--;
            AddLine("}");
            return null;
        }

        // Implementações para expressões
public override string VisitExpression(PICOParser.ExpressionContext context)
{
    var terms = context.term();
    if (terms.Length == 0) return "0"; // Fallback seguro
    
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
    if (factors.Length == 0) return "1"; // Fallback seguro
    
    var result = Visit(factors[0]);
    for (int i = 1; i < factors.Length; i++)
    {
        var op = context.GetChild(2 * i - 1).GetText();
        var factor = Visit(factors[i]);
        result = $"{result} {op} {factor}";
    }
    return result;
}

        public override string VisitFactor(PICOParser.FactorContext context)
        {
            if (context.NUMBER() != null) return context.NUMBER().GetText();
            if (context.ID() != null) return context.ID().GetText();
            if (context.expression() != null) return $"({Visit(context.expression())})";
            throw new System.NotSupportedException("Fator inválido");
        }

        public override string VisitCondition(PICOParser.ConditionContext context)
        {
            var left = Visit(context.expression(0));
            var right = Visit(context.expression(1));
            return $"{left} {context.rel_op().GetText()} {right}";
        }

        private void AddLine(string line)
        {
            _output.AppendLine(new string(' ', _indentLevel * 4) + line);
        }
    }
}