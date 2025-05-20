using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System;
namespace SeuProjeto.Calculator;
public class Calculator : CalculatorBaseVisitor<double> 
{
    public override double VisitComputation(CalculatorParser.ComputationContext context)
    {
        return Visit(context.expression());
    }

    public override double VisitExpression(CalculatorParser.ExpressionContext context)
    {
        if (context.ChildCount == 1)
        {
            return Visit(context.term());
        }
        
        var left = Visit(context.expression());
        var right = Visit(context.term());
        
        return context.GetChild(1).GetText() switch
        {
            "+" => left + right,
            "-" => left - right,
            _ => throw new NotSupportedException()
        };
    }

    public override double VisitTerm(CalculatorParser.TermContext context)
    {
        if (context.ChildCount == 1)
        {
            return Visit(context.factor());
        }
        
        var left = Visit(context.term());
        var right = Visit(context.factor());
        
        return context.GetChild(1).GetText() switch
        {
            "*" => left * right,
            "/" => left / right,
            _ => throw new NotSupportedException()
        };
    }

    public override double VisitFactor(CalculatorParser.FactorContext context)
    {
        if (context.NUMBER() != null)
        {
            return double.Parse(context.NUMBER().GetText());
        }
        return Visit(context.expression());
    }
}