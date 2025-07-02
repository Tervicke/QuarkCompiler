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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, TYPE=15, ID=16, INT=17, 
		NEWLINE=18, WS=19, STRING=20, LineComment=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "TYPE", "ID", "INT", "NEWLINE", 
			"WS", "STRING", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'print'", "'('", "')'", "'=='", "'!='", "'+'", "'-'", "'*'", 
			"'/'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TYPE", "ID", "INT", "NEWLINE", "WS", "STRING", "LineComment"
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
		"\u0004\u0000\u0015\u008a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e[\b\u000e\u0001\u000f\u0004\u000f"+
		"^\b\u000f\u000b\u000f\f\u000f_\u0001\u0010\u0004\u0010c\b\u0010\u000b"+
		"\u0010\f\u0010d\u0001\u0011\u0003\u0011h\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0004\u0012m\b\u0012\u000b\u0012\f\u0012n\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013w\b"+
		"\u0013\n\u0013\f\u0013z\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0082\b\u0014\n\u0014\f\u0014"+
		"\u0085\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000"+
		"\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000"+
		"\u0005\u0002\u0000AZaz\u0001\u000009\u0002\u0000\t\t  \u0002\u0000\"\""+
		"\\\\\u0002\u0000\n\n\r\r\u0092\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003-"+
		"\u0001\u0000\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u00075\u0001\u0000"+
		"\u0000\u0000\t7\u0001\u0000\u0000\u0000\u000b:\u0001\u0000\u0000\u0000"+
		"\r=\u0001\u0000\u0000\u0000\u000f?\u0001\u0000\u0000\u0000\u0011A\u0001"+
		"\u0000\u0000\u0000\u0013C\u0001\u0000\u0000\u0000\u0015E\u0001\u0000\u0000"+
		"\u0000\u0017G\u0001\u0000\u0000\u0000\u0019I\u0001\u0000\u0000\u0000\u001b"+
		"K\u0001\u0000\u0000\u0000\u001dZ\u0001\u0000\u0000\u0000\u001f]\u0001"+
		"\u0000\u0000\u0000!b\u0001\u0000\u0000\u0000#g\u0001\u0000\u0000\u0000"+
		"%l\u0001\u0000\u0000\u0000\'r\u0001\u0000\u0000\u0000)}\u0001\u0000\u0000"+
		"\u0000+,\u0005=\u0000\u0000,\u0002\u0001\u0000\u0000\u0000-.\u0005p\u0000"+
		"\u0000./\u0005r\u0000\u0000/0\u0005i\u0000\u000001\u0005n\u0000\u0000"+
		"12\u0005t\u0000\u00002\u0004\u0001\u0000\u0000\u000034\u0005(\u0000\u0000"+
		"4\u0006\u0001\u0000\u0000\u000056\u0005)\u0000\u00006\b\u0001\u0000\u0000"+
		"\u000078\u0005=\u0000\u000089\u0005=\u0000\u00009\n\u0001\u0000\u0000"+
		"\u0000:;\u0005!\u0000\u0000;<\u0005=\u0000\u0000<\f\u0001\u0000\u0000"+
		"\u0000=>\u0005+\u0000\u0000>\u000e\u0001\u0000\u0000\u0000?@\u0005-\u0000"+
		"\u0000@\u0010\u0001\u0000\u0000\u0000AB\u0005*\u0000\u0000B\u0012\u0001"+
		"\u0000\u0000\u0000CD\u0005/\u0000\u0000D\u0014\u0001\u0000\u0000\u0000"+
		"EF\u0005[\u0000\u0000F\u0016\u0001\u0000\u0000\u0000GH\u0005]\u0000\u0000"+
		"H\u0018\u0001\u0000\u0000\u0000IJ\u0005{\u0000\u0000J\u001a\u0001\u0000"+
		"\u0000\u0000KL\u0005}\u0000\u0000L\u001c\u0001\u0000\u0000\u0000MN\u0005"+
		"i\u0000\u0000NO\u0005n\u0000\u0000O[\u0005t\u0000\u0000PQ\u0005s\u0000"+
		"\u0000QR\u0005t\u0000\u0000RS\u0005r\u0000\u0000ST\u0005i\u0000\u0000"+
		"TU\u0005n\u0000\u0000U[\u0005g\u0000\u0000VW\u0005b\u0000\u0000WX\u0005"+
		"o\u0000\u0000XY\u0005o\u0000\u0000Y[\u0005l\u0000\u0000ZM\u0001\u0000"+
		"\u0000\u0000ZP\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000[\u001e"+
		"\u0001\u0000\u0000\u0000\\^\u0007\u0000\u0000\u0000]\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000` \u0001\u0000\u0000\u0000ac\u0007\u0001\u0000\u0000ba\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000e\"\u0001\u0000\u0000\u0000fh\u0005\r\u0000"+
		"\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ij\u0005\n\u0000\u0000j$\u0001\u0000\u0000\u0000km\u0007\u0002"+
		"\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pq\u0006\u0012\u0000\u0000q&\u0001\u0000\u0000\u0000rx\u0005\"\u0000\u0000"+
		"sw\b\u0003\u0000\u0000tu\u0005\\\u0000\u0000uw\t\u0000\u0000\u0000vs\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{|\u0005\"\u0000\u0000|(\u0001\u0000\u0000"+
		"\u0000}~\u0005/\u0000\u0000~\u007f\u0005/\u0000\u0000\u007f\u0083\u0001"+
		"\u0000\u0000\u0000\u0080\u0082\b\u0004\u0000\u0000\u0081\u0080\u0001\u0000"+
		"\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087\u0003#\u0011"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0006\u0014\u0000"+
		"\u0000\u0089*\u0001\u0000\u0000\u0000\t\u0000Z_dgnvx\u0083\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}