// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuarkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TYPE=13, ID=14, INT=15, NEWLINE=16, WS=17, 
		STRING=18, LineComment=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "TYPE", "ID", "INT", "NEWLINE", "WS", "STRING", 
			"LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'print'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'['", 
			"']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TYPE", "ID", "INT", "NEWLINE", "WS", "STRING", "LineComment"
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


	public QuarkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Quark.g4"; }

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
		"\u0004\u0000\u0013|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\fM\b\f\u0001\r\u0004"+
		"\rP\b\r\u000b\r\f\rQ\u0001\u000e\u0004\u000eU\b\u000e\u000b\u000e\f\u000e"+
		"V\u0001\u000f\u0003\u000fZ\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0004\u0010_\b\u0010\u000b\u0010\f\u0010`\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011i\b\u0011\n\u0011"+
		"\f\u0011l\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012t\b\u0012\n\u0012\f\u0012w\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000\u0005\u0002\u0000AZaz\u0001"+
		"\u000009\u0002\u0000\t\t  \u0002\u0000\"\"\\\\\u0002\u0000\n\n\r\r\u0083"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003)\u0001\u0000\u0000\u0000"+
		"\u0005/\u0001\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t3\u0001"+
		"\u0000\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000"+
		"\u0000\u000f9\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000\u0000\u0013"+
		"=\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000\u0000\u0017A\u0001"+
		"\u0000\u0000\u0000\u0019L\u0001\u0000\u0000\u0000\u001bO\u0001\u0000\u0000"+
		"\u0000\u001dT\u0001\u0000\u0000\u0000\u001fY\u0001\u0000\u0000\u0000!"+
		"^\u0001\u0000\u0000\u0000#d\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000"+
		"\u0000\'(\u0005=\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005p\u0000"+
		"\u0000*+\u0005r\u0000\u0000+,\u0005i\u0000\u0000,-\u0005n\u0000\u0000"+
		"-.\u0005t\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005(\u0000\u0000"+
		"0\u0006\u0001\u0000\u0000\u000012\u0005)\u0000\u00002\b\u0001\u0000\u0000"+
		"\u000034\u0005+\u0000\u00004\n\u0001\u0000\u0000\u000056\u0005-\u0000"+
		"\u00006\f\u0001\u0000\u0000\u000078\u0005*\u0000\u00008\u000e\u0001\u0000"+
		"\u0000\u00009:\u0005/\u0000\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0005"+
		"[\u0000\u0000<\u0012\u0001\u0000\u0000\u0000=>\u0005]\u0000\u0000>\u0014"+
		"\u0001\u0000\u0000\u0000?@\u0005{\u0000\u0000@\u0016\u0001\u0000\u0000"+
		"\u0000AB\u0005}\u0000\u0000B\u0018\u0001\u0000\u0000\u0000CD\u0005i\u0000"+
		"\u0000DE\u0005n\u0000\u0000EM\u0005t\u0000\u0000FG\u0005s\u0000\u0000"+
		"GH\u0005t\u0000\u0000HI\u0005r\u0000\u0000IJ\u0005i\u0000\u0000JK\u0005"+
		"n\u0000\u0000KM\u0005g\u0000\u0000LC\u0001\u0000\u0000\u0000LF\u0001\u0000"+
		"\u0000\u0000M\u001a\u0001\u0000\u0000\u0000NP\u0007\u0000\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000R\u001c\u0001\u0000\u0000\u0000SU\u0007"+
		"\u0001\u0000\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u001e\u0001\u0000"+
		"\u0000\u0000XZ\u0005\r\u0000\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005\n\u0000\u0000\\ \u0001"+
		"\u0000\u0000\u0000]_\u0007\u0002\u0000\u0000^]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bc\u0006\u0010\u0000\u0000c\"\u0001\u0000"+
		"\u0000\u0000dj\u0005\"\u0000\u0000ei\b\u0003\u0000\u0000fg\u0005\\\u0000"+
		"\u0000gi\t\u0000\u0000\u0000he\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005"+
		"\"\u0000\u0000n$\u0001\u0000\u0000\u0000op\u0005/\u0000\u0000pq\u0005"+
		"/\u0000\u0000qu\u0001\u0000\u0000\u0000rt\b\u0004\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000xy\u0003\u001f\u000f\u0000yz\u0001\u0000\u0000\u0000z{\u0006\u0012"+
		"\u0000\u0000{&\u0001\u0000\u0000\u0000\t\u0000LQVY`hju\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}