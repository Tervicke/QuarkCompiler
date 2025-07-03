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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, TYPE=16, ID=17, 
		INT=18, NEWLINE=19, WS=20, STRING=21, LineComment=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "TYPE", "ID", "INT", 
			"NEWLINE", "WS", "STRING", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'('", "')'", "'{'", "'}'", "'='", "'print'", "'=='", "'!='", 
			"'+'", "'-'", "'*'", "'/'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TYPE", "ID", "INT", "NEWLINE", "WS", "STRING", 
			"LineComment"
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
		"\u0004\u0000\u0016\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f`\b\u000f\u0001\u0010\u0004\u0010c\b\u0010\u000b\u0010\f\u0010"+
		"d\u0001\u0011\u0004\u0011h\b\u0011\u000b\u0011\f\u0011i\u0001\u0012\u0003"+
		"\u0012m\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013r\b\u0013"+
		"\u000b\u0013\f\u0013s\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014|\b\u0014\n\u0014\f\u0014\u007f\t"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0087\b\u0015\n\u0015\f\u0015\u008a\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0005\u0002\u0000"+
		"AZaz\u0001\u000009\u0002\u0000\t\t  \u0002\u0000\"\"\\\\\u0002\u0000\n"+
		"\n\r\r\u0097\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000"+
		"\u0000\u00030\u0001\u0000\u0000\u0000\u00052\u0001\u0000\u0000\u0000\u0007"+
		"4\u0001\u0000\u0000\u0000\t6\u0001\u0000\u0000\u0000\u000b8\u0001\u0000"+
		"\u0000\u0000\r:\u0001\u0000\u0000\u0000\u000f@\u0001\u0000\u0000\u0000"+
		"\u0011C\u0001\u0000\u0000\u0000\u0013F\u0001\u0000\u0000\u0000\u0015H"+
		"\u0001\u0000\u0000\u0000\u0017J\u0001\u0000\u0000\u0000\u0019L\u0001\u0000"+
		"\u0000\u0000\u001bN\u0001\u0000\u0000\u0000\u001dP\u0001\u0000\u0000\u0000"+
		"\u001f_\u0001\u0000\u0000\u0000!b\u0001\u0000\u0000\u0000#g\u0001\u0000"+
		"\u0000\u0000%l\u0001\u0000\u0000\u0000\'q\u0001\u0000\u0000\u0000)w\u0001"+
		"\u0000\u0000\u0000+\u0082\u0001\u0000\u0000\u0000-.\u0005i\u0000\u0000"+
		"./\u0005f\u0000\u0000/\u0002\u0001\u0000\u0000\u000001\u0005(\u0000\u0000"+
		"1\u0004\u0001\u0000\u0000\u000023\u0005)\u0000\u00003\u0006\u0001\u0000"+
		"\u0000\u000045\u0005{\u0000\u00005\b\u0001\u0000\u0000\u000067\u0005}"+
		"\u0000\u00007\n\u0001\u0000\u0000\u000089\u0005=\u0000\u00009\f\u0001"+
		"\u0000\u0000\u0000:;\u0005p\u0000\u0000;<\u0005r\u0000\u0000<=\u0005i"+
		"\u0000\u0000=>\u0005n\u0000\u0000>?\u0005t\u0000\u0000?\u000e\u0001\u0000"+
		"\u0000\u0000@A\u0005=\u0000\u0000AB\u0005=\u0000\u0000B\u0010\u0001\u0000"+
		"\u0000\u0000CD\u0005!\u0000\u0000DE\u0005=\u0000\u0000E\u0012\u0001\u0000"+
		"\u0000\u0000FG\u0005+\u0000\u0000G\u0014\u0001\u0000\u0000\u0000HI\u0005"+
		"-\u0000\u0000I\u0016\u0001\u0000\u0000\u0000JK\u0005*\u0000\u0000K\u0018"+
		"\u0001\u0000\u0000\u0000LM\u0005/\u0000\u0000M\u001a\u0001\u0000\u0000"+
		"\u0000NO\u0005[\u0000\u0000O\u001c\u0001\u0000\u0000\u0000PQ\u0005]\u0000"+
		"\u0000Q\u001e\u0001\u0000\u0000\u0000RS\u0005i\u0000\u0000ST\u0005n\u0000"+
		"\u0000T`\u0005t\u0000\u0000UV\u0005s\u0000\u0000VW\u0005t\u0000\u0000"+
		"WX\u0005r\u0000\u0000XY\u0005i\u0000\u0000YZ\u0005n\u0000\u0000Z`\u0005"+
		"g\u0000\u0000[\\\u0005b\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005o\u0000"+
		"\u0000^`\u0005l\u0000\u0000_R\u0001\u0000\u0000\u0000_U\u0001\u0000\u0000"+
		"\u0000_[\u0001\u0000\u0000\u0000` \u0001\u0000\u0000\u0000ac\u0007\u0000"+
		"\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\"\u0001\u0000\u0000\u0000"+
		"fh\u0007\u0001\u0000\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j$\u0001\u0000"+
		"\u0000\u0000km\u0005\r\u0000\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000o&\u0001\u0000"+
		"\u0000\u0000pr\u0007\u0002\u0000\u0000qp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uv\u0006\u0013\u0000\u0000v(\u0001\u0000\u0000"+
		"\u0000w}\u0005\"\u0000\u0000x|\b\u0003\u0000\u0000yz\u0005\\\u0000\u0000"+
		"z|\t\u0000\u0000\u0000{x\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\"\u0000\u0000\u0081*\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005/\u0000\u0000\u0083\u0084\u0005/\u0000\u0000\u0084\u0088\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\b\u0004\u0000\u0000\u0086\u0085\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0003%\u0012"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0006\u0015\u0000"+
		"\u0000\u008e,\u0001\u0000\u0000\u0000\t\u0000_dils{}\u0088\u0001\u0006"+
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