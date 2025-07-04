// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuarkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TYPE=21, TRUE=22, FALSE=23, ID=24, INT=25, 
		NEWLINE=26, WS=27, STRING=28, LineComment=29;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_ifstatement = 2, RULE_block = 3, RULE_whilestat = 4, 
		RULE_assigstat = 5, RULE_printstat = 6, RULE_expr = 7, RULE_equalityexpr = 8, 
		RULE_relationalexpr = 9, RULE_addexpr = 10, RULE_mulexpr = 11, RULE_atom = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "ifstatement", "block", "whilestat", "assigstat", "printstat", 
			"expr", "equalityexpr", "relationalexpr", "addexpr", "mulexpr", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'('", "')'", "'else'", "'{'", "'}'", "'while'", "'='", 
			"'print'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TYPE", "TRUE", 
			"FALSE", "ID", "INT", "NEWLINE", "WS", "STRING", "LineComment"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuarkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				stat();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 622854786L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public AssigstatContext assig;
		public PrintstatContext print;
		public AssigstatContext assigstat() {
			return getRuleContext(AssigstatContext.class,0);
		}
		public PrintstatContext printstat() {
			return getRuleContext(PrintstatContext.class,0);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public WhilestatContext whilestat() {
			return getRuleContext(WhilestatContext.class,0);
		}
		public TerminalNode LineComment() { return getToken(QuarkParser.LineComment, 0); }
		public TerminalNode NEWLINE() { return getToken(QuarkParser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((StatContext)_localctx).assig = assigstat();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				((StatContext)_localctx).print = printstat();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				ifstatement();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				whilestat();
				}
				break;
			case LineComment:
				enterOuterAlt(_localctx, 5);
				{
				setState(35);
				match(LineComment);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 6);
				{
				setState(36);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			match(T__1);
			setState(41);
			expr();
			setState(42);
			match(T__2);
			setState(43);
			block();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(44);
				match(T__3);
				setState(45);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__4);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 622854786L) != 0) {
				{
				{
				setState(49);
				stat();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhilestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterWhilestat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitWhilestat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitWhilestat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatContext whilestat() throws RecognitionException {
		WhilestatContext _localctx = new WhilestatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whilestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__6);
			setState(58);
			match(T__1);
			setState(59);
			expr();
			setState(60);
			match(T__2);
			setState(61);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssigstatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(QuarkParser.TYPE, 0); }
		public AssigstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterAssigstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitAssigstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitAssigstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssigstatContext assigstat() throws RecognitionException {
		AssigstatContext _localctx = new AssigstatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assigstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(63);
				match(TYPE);
				}
			}

			setState(66);
			match(ID);
			setState(67);
			match(T__7);
			{
			setState(68);
			expr();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintstatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterPrintstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitPrintstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitPrintstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstatContext printstat() throws RecognitionException {
		PrintstatContext _localctx = new PrintstatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__8);
			setState(71);
			match(T__1);
			{
			setState(72);
			expr();
			}
			setState(73);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public EqualityexprContext equalityexpr() {
			return getRuleContext(EqualityexprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			equalityexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityexprContext extends ParserRuleContext {
		public List<RelationalexprContext> relationalexpr() {
			return getRuleContexts(RelationalexprContext.class);
		}
		public RelationalexprContext relationalexpr(int i) {
			return getRuleContext(RelationalexprContext.class,i);
		}
		public EqualityexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterEqualityexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitEqualityexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitEqualityexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityexprContext equalityexpr() throws RecognitionException {
		EqualityexprContext _localctx = new EqualityexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_equalityexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			relationalexpr();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(78);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(79);
				relationalexpr();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalexprContext extends ParserRuleContext {
		public List<AddexprContext> addexpr() {
			return getRuleContexts(AddexprContext.class);
		}
		public AddexprContext addexpr(int i) {
			return getRuleContext(AddexprContext.class,i);
		}
		public RelationalexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterRelationalexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitRelationalexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitRelationalexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalexprContext relationalexpr() throws RecognitionException {
		RelationalexprContext _localctx = new RelationalexprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relationalexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			addexpr(0);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0) {
				{
				{
				setState(86);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				addexpr(0);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddexprContext extends ParserRuleContext {
		public MulexprContext mulexpr() {
			return getRuleContext(MulexprContext.class,0);
		}
		public AddexprContext addexpr() {
			return getRuleContext(AddexprContext.class,0);
		}
		public AddexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterAddexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitAddexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitAddexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexprContext addexpr() throws RecognitionException {
		return addexpr(0);
	}

	private AddexprContext addexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddexprContext _localctx = new AddexprContext(_ctx, _parentState);
		AddexprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_addexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(94);
			mulexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexpr);
					setState(96);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(97);
					_la = _input.LA(1);
					if ( !(_la==T__15 || _la==T__16) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(98);
					mulexpr(0);
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulexprContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public MulexprContext mulexpr() {
			return getRuleContext(MulexprContext.class,0);
		}
		public MulexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterMulexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitMulexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitMulexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexprContext mulexpr() throws RecognitionException {
		return mulexpr(0);
	}

	private MulexprContext mulexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulexprContext _localctx = new MulexprContext(_ctx, _parentState);
		MulexprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_mulexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(105);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulexpr);
					setState(107);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(108);
					_la = _input.LA(1);
					if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(109);
					atom();
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuarkParser.INT, 0); }
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QuarkParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(QuarkParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(QuarkParser.FALSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(ID);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(STRING);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				match(FALSE);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 6);
				{
				setState(120);
				match(T__1);
				setState(121);
				expr();
				setState(122);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return addexpr_sempred((AddexprContext)_localctx, predIndex);
		case 11:
			return mulexpr_sempred((MulexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addexpr_sempred(AddexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulexpr_sempred(MulexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u007f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000"+
		"\u001d\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002/\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0005\u00033\b\u0003\n\u0003\f\u00036\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0003\u0005A\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\bQ\b\b\n\b\f\bT\t\b\u0001\t\u0001\t\u0001\t\u0005\tY\b\t\n\t\f\t\\\t"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\nd\b\n\n\n\f"+
		"\ng\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000bo\b\u000b\n\u000b\f\u000br\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f}\b\f\u0001"+
		"\f\u0000\u0002\u0014\u0016\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0004\u0001\u0000\n\u000b\u0001\u0000\f"+
		"\u000f\u0001\u0000\u0010\u0011\u0001\u0000\u0012\u0014\u0083\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004\'\u0001"+
		"\u0000\u0000\u0000\u00060\u0001\u0000\u0000\u0000\b9\u0001\u0000\u0000"+
		"\u0000\n@\u0001\u0000\u0000\u0000\fF\u0001\u0000\u0000\u0000\u000eK\u0001"+
		"\u0000\u0000\u0000\u0010M\u0001\u0000\u0000\u0000\u0012U\u0001\u0000\u0000"+
		"\u0000\u0014]\u0001\u0000\u0000\u0000\u0016h\u0001\u0000\u0000\u0000\u0018"+
		"|\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0001"+
		"\u0001\u0000\u0000\u0000\u001f&\u0003\n\u0005\u0000 &\u0003\f\u0006\u0000"+
		"!&\u0003\u0004\u0002\u0000\"&\u0003\b\u0004\u0000#&\u0005\u001d\u0000"+
		"\u0000$&\u0005\u001a\u0000\u0000%\u001f\u0001\u0000\u0000\u0000% \u0001"+
		"\u0000\u0000\u0000%!\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0005\u0002\u0000\u0000)*\u0003"+
		"\u000e\u0007\u0000*+\u0005\u0003\u0000\u0000+.\u0003\u0006\u0003\u0000"+
		",-\u0005\u0004\u0000\u0000-/\u0003\u0006\u0003\u0000.,\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/\u0005\u0001\u0000\u0000\u000004\u0005"+
		"\u0005\u0000\u000013\u0003\u0002\u0001\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005\u0006"+
		"\u0000\u00008\u0007\u0001\u0000\u0000\u00009:\u0005\u0007\u0000\u0000"+
		":;\u0005\u0002\u0000\u0000;<\u0003\u000e\u0007\u0000<=\u0005\u0003\u0000"+
		"\u0000=>\u0003\u0006\u0003\u0000>\t\u0001\u0000\u0000\u0000?A\u0005\u0015"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0018\u0000\u0000CD\u0005\b\u0000\u0000DE\u0003"+
		"\u000e\u0007\u0000E\u000b\u0001\u0000\u0000\u0000FG\u0005\t\u0000\u0000"+
		"GH\u0005\u0002\u0000\u0000HI\u0003\u000e\u0007\u0000IJ\u0005\u0003\u0000"+
		"\u0000J\r\u0001\u0000\u0000\u0000KL\u0003\u0010\b\u0000L\u000f\u0001\u0000"+
		"\u0000\u0000MR\u0003\u0012\t\u0000NO\u0007\u0000\u0000\u0000OQ\u0003\u0012"+
		"\t\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000S\u0011\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000UZ\u0003\u0014\n\u0000VW\u0007\u0001\u0000\u0000"+
		"WY\u0003\u0014\n\u0000XV\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u0013\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0006\n\uffff\uffff\u0000"+
		"^_\u0003\u0016\u000b\u0000_e\u0001\u0000\u0000\u0000`a\n\u0002\u0000\u0000"+
		"ab\u0007\u0002\u0000\u0000bd\u0003\u0016\u000b\u0000c`\u0001\u0000\u0000"+
		"\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000f\u0015\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"hi\u0006\u000b\uffff\uffff\u0000ij\u0003\u0018\f\u0000jp\u0001\u0000\u0000"+
		"\u0000kl\n\u0002\u0000\u0000lm\u0007\u0003\u0000\u0000mo\u0003\u0018\f"+
		"\u0000nk\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000q\u0017\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000s}\u0005\u0019\u0000\u0000t}\u0005\u0018\u0000"+
		"\u0000u}\u0005\u001c\u0000\u0000v}\u0005\u0016\u0000\u0000w}\u0005\u0017"+
		"\u0000\u0000xy\u0005\u0002\u0000\u0000yz\u0003\u000e\u0007\u0000z{\u0005"+
		"\u0003\u0000\u0000{}\u0001\u0000\u0000\u0000|s\u0001\u0000\u0000\u0000"+
		"|t\u0001\u0000\u0000\u0000|u\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000"+
		"\u0000|w\u0001\u0000\u0000\u0000|x\u0001\u0000\u0000\u0000}\u0019\u0001"+
		"\u0000\u0000\u0000\n\u001d%.4@RZep|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}