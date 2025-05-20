// Generated from c:/Users/forof/OneDrive - Universidade da Madeira/Desktop/ProjetoTlc/SeuProjeto/PICO.g4 by ANTLR 4.13.1

namespace SeuProjeto.Generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PICOLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, ID=23, NUMBER=24, WS=25, 
		COMMENT=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "ID", "NUMBER", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'read'", "';'", "'print'", "'='", "'if'", "'then'", "'else'", 
			"'end'", "'while'", "'do'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"NUMBER", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PICOLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PICO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001a\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0005\u0016}\b\u0016"+
		"\n\u0016\f\u0016\u0080\t\u0016\u0001\u0017\u0004\u0017\u0083\b\u0017\u000b"+
		"\u0017\f\u0017\u0084\u0001\u0018\u0004\u0018\u0088\b\u0018\u000b\u0018"+
		"\f\u0018\u0089\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0092\b\u0019\n\u0019\f\u0019\u0095\t\u0019\u0001"+
		"\u0019\u0001\u0019\u0000\u0000\u001a\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a\u0001\u0000"+
		"\u0005\u0002\u0000AZaz\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n"+
		"\r\r  \u0002\u0000\n\n\r\r\u009b\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001\u0000\u0000\u0000"+
		"\u0003:\u0001\u0000\u0000\u0000\u0005<\u0001\u0000\u0000\u0000\u0007B"+
		"\u0001\u0000\u0000\u0000\tD\u0001\u0000\u0000\u0000\u000bG\u0001\u0000"+
		"\u0000\u0000\rL\u0001\u0000\u0000\u0000\u000fQ\u0001\u0000\u0000\u0000"+
		"\u0011U\u0001\u0000\u0000\u0000\u0013[\u0001\u0000\u0000\u0000\u0015^"+
		"\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019d\u0001\u0000"+
		"\u0000\u0000\u001bf\u0001\u0000\u0000\u0000\u001dh\u0001\u0000\u0000\u0000"+
		"\u001fk\u0001\u0000\u0000\u0000!n\u0001\u0000\u0000\u0000#p\u0001\u0000"+
		"\u0000\u0000%r\u0001\u0000\u0000\u0000\'t\u0001\u0000\u0000\u0000)v\u0001"+
		"\u0000\u0000\u0000+x\u0001\u0000\u0000\u0000-z\u0001\u0000\u0000\u0000"+
		"/\u0082\u0001\u0000\u0000\u00001\u0087\u0001\u0000\u0000\u00003\u008d"+
		"\u0001\u0000\u0000\u000056\u0005r\u0000\u000067\u0005e\u0000\u000078\u0005"+
		"a\u0000\u000089\u0005d\u0000\u00009\u0002\u0001\u0000\u0000\u0000:;\u0005"+
		";\u0000\u0000;\u0004\u0001\u0000\u0000\u0000<=\u0005p\u0000\u0000=>\u0005"+
		"r\u0000\u0000>?\u0005i\u0000\u0000?@\u0005n\u0000\u0000@A\u0005t\u0000"+
		"\u0000A\u0006\u0001\u0000\u0000\u0000BC\u0005=\u0000\u0000C\b\u0001\u0000"+
		"\u0000\u0000DE\u0005i\u0000\u0000EF\u0005f\u0000\u0000F\n\u0001\u0000"+
		"\u0000\u0000GH\u0005t\u0000\u0000HI\u0005h\u0000\u0000IJ\u0005e\u0000"+
		"\u0000JK\u0005n\u0000\u0000K\f\u0001\u0000\u0000\u0000LM\u0005e\u0000"+
		"\u0000MN\u0005l\u0000\u0000NO\u0005s\u0000\u0000OP\u0005e\u0000\u0000"+
		"P\u000e\u0001\u0000\u0000\u0000QR\u0005e\u0000\u0000RS\u0005n\u0000\u0000"+
		"ST\u0005d\u0000\u0000T\u0010\u0001\u0000\u0000\u0000UV\u0005w\u0000\u0000"+
		"VW\u0005h\u0000\u0000WX\u0005i\u0000\u0000XY\u0005l\u0000\u0000YZ\u0005"+
		"e\u0000\u0000Z\u0012\u0001\u0000\u0000\u0000[\\\u0005d\u0000\u0000\\]"+
		"\u0005o\u0000\u0000]\u0014\u0001\u0000\u0000\u0000^_\u0005=\u0000\u0000"+
		"_`\u0005=\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005!\u0000\u0000"+
		"bc\u0005=\u0000\u0000c\u0018\u0001\u0000\u0000\u0000de\u0005>\u0000\u0000"+
		"e\u001a\u0001\u0000\u0000\u0000fg\u0005<\u0000\u0000g\u001c\u0001\u0000"+
		"\u0000\u0000hi\u0005>\u0000\u0000ij\u0005=\u0000\u0000j\u001e\u0001\u0000"+
		"\u0000\u0000kl\u0005<\u0000\u0000lm\u0005=\u0000\u0000m \u0001\u0000\u0000"+
		"\u0000no\u0005+\u0000\u0000o\"\u0001\u0000\u0000\u0000pq\u0005-\u0000"+
		"\u0000q$\u0001\u0000\u0000\u0000rs\u0005*\u0000\u0000s&\u0001\u0000\u0000"+
		"\u0000tu\u0005/\u0000\u0000u(\u0001\u0000\u0000\u0000vw\u0005(\u0000\u0000"+
		"w*\u0001\u0000\u0000\u0000xy\u0005)\u0000\u0000y,\u0001\u0000\u0000\u0000"+
		"z~\u0007\u0000\u0000\u0000{}\u0007\u0001\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f.\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0081\u0083\u0007\u0002\u0000\u0000\u0082\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u00850\u0001\u0000\u0000"+
		"\u0000\u0086\u0088\u0007\u0003\u0000\u0000\u0087\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0006\u0018\u0000\u0000\u008c2\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005/\u0000\u0000\u008e\u008f\u0005/\u0000\u0000\u008f\u0093"+
		"\u0001\u0000\u0000\u0000\u0090\u0092\b\u0004\u0000\u0000\u0091\u0090\u0001"+
		"\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096\u0001"+
		"\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0097\u0006"+
		"\u0019\u0000\u0000\u00974\u0001\u0000\u0000\u0000\u0005\u0000~\u0084\u0089"+
		"\u0093\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}