using System;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using SeuProjeto.Generated;
namespace SeuProjeto;

class Program
{
    static void Main(string[] args)
    {
        try
        {
            var input = File.ReadAllText("program.pico");
            var stream = CharStreams.fromString(input);
            var lexer = new PICOLexer(stream);
            var tokens = new CommonTokenStream(lexer);
            var parser = new PICOParser(tokens);
            parser.RemoveErrorListeners();
            parser.AddErrorListener(new PicoErrorListener());
            var tree = parser.program();
            var translator = new PicoVisit();
            var csharpCode = translator.Visit(tree);

            File.WriteAllText("Execution.cs", csharpCode);
            
            Console.WriteLine("Tradução concluída com sucesso!");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro: {ex.Message}");
        }
    }
}