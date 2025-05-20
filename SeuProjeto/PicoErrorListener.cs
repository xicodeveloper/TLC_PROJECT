namespace SeuProjeto
{
    public class PicoErrorListener : BaseErrorListener
    {
        public override void SyntaxError(
            TextWriter output,
            IRecognizer recognizer,
            IToken offendingSymbol,
            int line,
            int charPositionInLine,
            string msg,
            RecognitionException ex)
        {
            throw new Exception($"Erro na linha {line}:{charPositionInLine} - {msg}");
        }
    }

}
var parser = new PICOParser(tokens);
parser.RemoveErrorListeners();
parser.AddErrorListener(new PicoErrorListener());