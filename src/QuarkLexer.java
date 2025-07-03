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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TYPE=19, ID=20, INT=21, NEWLINE=22, WS=23, STRING=24, LineComment=25;
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
			"T__17", "TYPE", "ID", "INT", "NEWLINE", "WS", "STRING", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'('", "')'", "'{'", "'}'", "'='", "'print'", "'=='", "'!='", 
			"'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TYPE", "ID", "INT", "NEWLINE", 
			"WS", "STRING", "LineComment"
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
		"\u0004\u0000\u0019\u009f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012n\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0005\u0013r\b\u0013\n\u0013\f\u0013u\t\u0013\u0001\u0014\u0004\u0014"+
		"x\b\u0014\u000b\u0014\f\u0014y\u0001\u0015\u0003\u0015}\b\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0004\u0016\u0082\b\u0016\u000b\u0016\f"+
		"\u0016\u0083\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u008c\b\u0017\n\u0017\f\u0017\u008f\t\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0097\b\u0018\n\u0018\f\u0018\u009a\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000"+
		"\u0006\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000"+
		"\t\t  \u0002\u0000\"\"\\\\\u0002\u0000\n\n\r\r\u00a7\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00036"+
		"\u0001\u0000\u0000\u0000\u00058\u0001\u0000\u0000\u0000\u0007:\u0001\u0000"+
		"\u0000\u0000\t<\u0001\u0000\u0000\u0000\u000b>\u0001\u0000\u0000\u0000"+
		"\r@\u0001\u0000\u0000\u0000\u000fF\u0001\u0000\u0000\u0000\u0011I\u0001"+
		"\u0000\u0000\u0000\u0013L\u0001\u0000\u0000\u0000\u0015N\u0001\u0000\u0000"+
		"\u0000\u0017Q\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001b"+
		"V\u0001\u0000\u0000\u0000\u001dX\u0001\u0000\u0000\u0000\u001fZ\u0001"+
		"\u0000\u0000\u0000!\\\u0001\u0000\u0000\u0000#^\u0001\u0000\u0000\u0000"+
		"%m\u0001\u0000\u0000\u0000\'o\u0001\u0000\u0000\u0000)w\u0001\u0000\u0000"+
		"\u0000+|\u0001\u0000\u0000\u0000-\u0081\u0001\u0000\u0000\u0000/\u0087"+
		"\u0001\u0000\u0000\u00001\u0092\u0001\u0000\u0000\u000034\u0005i\u0000"+
		"\u000045\u0005f\u0000\u00005\u0002\u0001\u0000\u0000\u000067\u0005(\u0000"+
		"\u00007\u0004\u0001\u0000\u0000\u000089\u0005)\u0000\u00009\u0006\u0001"+
		"\u0000\u0000\u0000:;\u0005{\u0000\u0000;\b\u0001\u0000\u0000\u0000<=\u0005"+
		"}\u0000\u0000=\n\u0001\u0000\u0000\u0000>?\u0005=\u0000\u0000?\f\u0001"+
		"\u0000\u0000\u0000@A\u0005p\u0000\u0000AB\u0005r\u0000\u0000BC\u0005i"+
		"\u0000\u0000CD\u0005n\u0000\u0000DE\u0005t\u0000\u0000E\u000e\u0001\u0000"+
		"\u0000\u0000FG\u0005=\u0000\u0000GH\u0005=\u0000\u0000H\u0010\u0001\u0000"+
		"\u0000\u0000IJ\u0005!\u0000\u0000JK\u0005=\u0000\u0000K\u0012\u0001\u0000"+
		"\u0000\u0000LM\u0005<\u0000\u0000M\u0014\u0001\u0000\u0000\u0000NO\u0005"+
		"<\u0000\u0000OP\u0005=\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QR\u0005"+
		">\u0000\u0000R\u0018\u0001\u0000\u0000\u0000ST\u0005>\u0000\u0000TU\u0005"+
		"=\u0000\u0000U\u001a\u0001\u0000\u0000\u0000VW\u0005+\u0000\u0000W\u001c"+
		"\u0001\u0000\u0000\u0000XY\u0005-\u0000\u0000Y\u001e\u0001\u0000\u0000"+
		"\u0000Z[\u0005*\u0000\u0000[ \u0001\u0000\u0000\u0000\\]\u0005/\u0000"+
		"\u0000]\"\u0001\u0000\u0000\u0000^_\u0005%\u0000\u0000_$\u0001\u0000\u0000"+
		"\u0000`a\u0005i\u0000\u0000ab\u0005n\u0000\u0000bn\u0005t\u0000\u0000"+
		"cd\u0005s\u0000\u0000de\u0005t\u0000\u0000ef\u0005r\u0000\u0000fg\u0005"+
		"i\u0000\u0000gh\u0005n\u0000\u0000hn\u0005g\u0000\u0000ij\u0005b\u0000"+
		"\u0000jk\u0005o\u0000\u0000kl\u0005o\u0000\u0000ln\u0005l\u0000\u0000"+
		"m`\u0001\u0000\u0000\u0000mc\u0001\u0000\u0000\u0000mi\u0001\u0000\u0000"+
		"\u0000n&\u0001\u0000\u0000\u0000os\u0007\u0000\u0000\u0000pr\u0007\u0001"+
		"\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t(\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vx\u0007\u0002\u0000\u0000wv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000z*\u0001\u0000\u0000\u0000{}\u0005\r\u0000\u0000|{\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005\n\u0000\u0000\u007f,\u0001\u0000\u0000\u0000\u0080\u0082\u0007"+
		"\u0003\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0006"+
		"\u0016\u0000\u0000\u0086.\u0001\u0000\u0000\u0000\u0087\u008d\u0005\""+
		"\u0000\u0000\u0088\u008c\b\u0004\u0000\u0000\u0089\u008a\u0005\\\u0000"+
		"\u0000\u008a\u008c\t\u0000\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000"+
		"\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\"\u0000\u0000\u00910\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005/\u0000\u0000\u0093\u0094\u0005/\u0000\u0000\u0094\u0098\u0001"+
		"\u0000\u0000\u0000\u0095\u0097\b\u0005\u0000\u0000\u0096\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000"+
		"\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0003+\u0015"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0006\u0018\u0000"+
		"\u0000\u009e2\u0001\u0000\u0000\u0000\t\u0000msy|\u0083\u008b\u008d\u0098"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}