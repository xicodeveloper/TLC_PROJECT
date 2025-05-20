using Antlr4.Runtime;
using SeuProjeto.Generated; 

using System;
using Antlr4.Runtime.Tree;

namespace SeuProjeto.Generator;
    public class Generator : CalculatorBaseVisitor<string>
    {
        public void Dump(ParserRuleContext context, string indent = "")
        {
            var name = context.GetType().Name;
            Console.WriteLine($"{indent}{name}");
        
            foreach (var child in context.children)
            {
                if (child is ParserRuleContext ctx)
                {
                    Dump(ctx, indent + "  ");
                }
            }
        }

        public override string VisitChildren(IRuleNode node)
        {
            if (node is ParserRuleContext context)
            {
                Dump(context);
            }
            return base.VisitChildren(node);
        }
    }
