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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, TYPE=28, TRUE=29, FALSE=30, ID=31, DOUBLE=32, 
		INT=33, NEWLINE=34, WS=35, STRING=36, LineComment=37;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_funcdefn = 2, RULE_paramlist = 3, RULE_param = 4, 
		RULE_funccall = 5, RULE_arglist = 6, RULE_returnstat = 7, RULE_importstat = 8, 
		RULE_definestructstat = 9, RULE_structstats = 10, RULE_structfield = 11, 
		RULE_declarestruct = 12, RULE_ifstatement = 13, RULE_block = 14, RULE_whilestat = 15, 
		RULE_assigstat = 16, RULE_printstat = 17, RULE_expr = 18, RULE_equalityexpr = 19, 
		RULE_relationalexpr = 20, RULE_addexpr = 21, RULE_mulexpr = 22, RULE_fieldaccess = 23, 
		RULE_access = 24, RULE_unaryExpr = 25, RULE_atom = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "funcdefn", "paramlist", "param", "funccall", "arglist", 
			"returnstat", "importstat", "definestructstat", "structstats", "structfield", 
			"declarestruct", "ifstatement", "block", "whilestat", "assigstat", "printstat", 
			"expr", "equalityexpr", "relationalexpr", "addexpr", "mulexpr", "fieldaccess", 
			"access", "unaryExpr", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fn'", "'('", "')'", "'->'", "','", "'.'", "'return'", "'import'", 
			"'struct'", "'{'", "'}'", "'if'", "'else'", "'while'", "'='", "'print'", 
			"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TYPE", "TRUE", "FALSE", "ID", "DOUBLE", "INT", 
			"NEWLINE", "WS", "STRING", "LineComment"
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
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				stat();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 157034828674L) != 0 );
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
		public FuncdefnContext funcdefn() {
			return getRuleContext(FuncdefnContext.class,0);
		}
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public ReturnstatContext returnstat() {
			return getRuleContext(ReturnstatContext.class,0);
		}
		public ImportstatContext importstat() {
			return getRuleContext(ImportstatContext.class,0);
		}
		public DefinestructstatContext definestructstat() {
			return getRuleContext(DefinestructstatContext.class,0);
		}
		public DeclarestructContext declarestruct() {
			return getRuleContext(DeclarestructContext.class,0);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((StatContext)_localctx).assig = assigstat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((StatContext)_localctx).print = printstat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				ifstatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				whilestat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				funcdefn();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				funccall();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				returnstat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				importstat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(67);
				definestructstat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(68);
				declarestruct();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(69);
				match(LineComment);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(70);
				match(NEWLINE);
				}
				break;
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
	public static class FuncdefnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(QuarkParser.TYPE, 0); }
		public FuncdefnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterFuncdefn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitFuncdefn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitFuncdefn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefnContext funcdefn() throws RecognitionException {
		FuncdefnContext _localctx = new FuncdefnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcdefn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__0);
			setState(74);
			match(ID);
			setState(75);
			match(T__1);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(76);
				paramlist();
				}
			}

			setState(79);
			match(T__2);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(80);
				match(T__3);
				setState(81);
				match(TYPE);
				}
			}

			setState(84);
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
	public static class ParamlistContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterParamlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitParamlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitParamlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamlistContext paramlist() throws RecognitionException {
		ParamlistContext _localctx = new ParamlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			param();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(87);
				match(T__4);
				setState(88);
				param();
				}
				}
				setState(93);
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
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(QuarkParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(TYPE);
			setState(95);
			match(ID);
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
	public static class FunccallContext extends ParserRuleContext {
		public Token modulename;
		public Token functionname;
		public List<TerminalNode> ID() { return getTokens(QuarkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuarkParser.ID, i);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitFunccall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funccall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(97);
				((FunccallContext)_localctx).modulename = match(ID);
				setState(98);
				match(T__5);
				}
				break;
			}
			setState(101);
			((FunccallContext)_localctx).functionname = match(ID);
			setState(102);
			match(T__1);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 85387640836L) != 0) {
				{
				setState(103);
				arglist();
				}
			}

			setState(106);
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
	public static class ArglistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitArglist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			expr();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(109);
				match(T__4);
				setState(110);
				expr();
				}
				}
				setState(115);
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
	public static class ReturnstatContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(QuarkParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterReturnstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitReturnstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitReturnstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnstatContext returnstat() throws RecognitionException {
		ReturnstatContext _localctx = new ReturnstatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__6);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 85387640836L) != 0) {
				{
				setState(117);
				expr();
				}
			}

			setState(120);
			match(NEWLINE);
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
	public static class ImportstatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public ImportstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterImportstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitImportstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitImportstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportstatContext importstat() throws RecognitionException {
		ImportstatContext _localctx = new ImportstatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__7);
			setState(123);
			match(ID);
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
	public static class DefinestructstatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public StructstatsContext structstats() {
			return getRuleContext(StructstatsContext.class,0);
		}
		public DefinestructstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definestructstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterDefinestructstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitDefinestructstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitDefinestructstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinestructstatContext definestructstat() throws RecognitionException {
		DefinestructstatContext _localctx = new DefinestructstatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_definestructstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__8);
			setState(126);
			match(ID);
			setState(127);
			match(T__9);
			setState(128);
			structstats();
			setState(129);
			match(T__10);
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
	public static class StructstatsContext extends ParserRuleContext {
		public List<StructfieldContext> structfield() {
			return getRuleContexts(StructfieldContext.class);
		}
		public StructfieldContext structfield(int i) {
			return getRuleContext(StructfieldContext.class,i);
		}
		public StructstatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structstats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterStructstats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitStructstats(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitStructstats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructstatsContext structstats() throws RecognitionException {
		StructstatsContext _localctx = new StructstatsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_structstats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(131);
				structfield();
				}
				}
				setState(136);
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
	public static class StructfieldContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(QuarkParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public StructfieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structfield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterStructfield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitStructfield(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitStructfield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructfieldContext structfield() throws RecognitionException {
		StructfieldContext _localctx = new StructfieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_structfield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(TYPE);
			setState(138);
			match(ID);
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
	public static class DeclarestructContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(QuarkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuarkParser.ID, i);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public DeclarestructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarestruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterDeclarestruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitDeclarestruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitDeclarestruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarestructContext declarestruct() throws RecognitionException {
		DeclarestructContext _localctx = new DeclarestructContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarestruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);
			setState(141);
			match(ID);
			setState(142);
			match(T__1);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 85387640836L) != 0) {
				{
				setState(143);
				arglist();
				}
			}

			setState(146);
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
		enterRule(_localctx, 26, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__11);
			setState(149);
			match(T__1);
			setState(150);
			expr();
			setState(151);
			match(T__2);
			setState(152);
			block();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(153);
				match(T__12);
				setState(154);
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
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__9);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 157034828674L) != 0) {
				{
				{
				setState(158);
				stat();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			match(T__10);
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
		enterRule(_localctx, 30, RULE_whilestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__13);
			setState(167);
			match(T__1);
			setState(168);
			expr();
			setState(169);
			match(T__2);
			setState(170);
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
		enterRule(_localctx, 32, RULE_assigstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(172);
				match(TYPE);
				}
			}

			setState(175);
			match(ID);
			setState(176);
			match(T__14);
			{
			setState(177);
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
		enterRule(_localctx, 34, RULE_printstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__15);
			setState(180);
			match(T__1);
			{
			setState(181);
			expr();
			}
			setState(182);
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
		enterRule(_localctx, 36, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 38, RULE_equalityexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			relationalexpr();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				{
				setState(187);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				relationalexpr();
				}
				}
				setState(193);
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
		enterRule(_localctx, 40, RULE_relationalexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			addexpr(0);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0) {
				{
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				addexpr(0);
				}
				}
				setState(201);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_addexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(203);
			mulexpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexpr);
					setState(205);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(206);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(207);
					mulexpr();
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public List<FieldaccessContext> fieldaccess() {
			return getRuleContexts(FieldaccessContext.class);
		}
		public FieldaccessContext fieldaccess(int i) {
			return getRuleContext(FieldaccessContext.class,i);
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
		MulexprContext _localctx = new MulexprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulexpr);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				fieldaccess();
				setState(214);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				fieldaccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				fieldaccess();
				}
				break;
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
	public static class FieldaccessContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public FieldaccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldaccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterFieldaccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitFieldaccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitFieldaccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldaccessContext fieldaccess() throws RecognitionException {
		FieldaccessContext _localctx = new FieldaccessContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldaccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			unaryExpr();
			setState(221);
			access();
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
	public static class AccessContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(QuarkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuarkParser.ID, i);
		}
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_access);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					match(T__5);
					setState(224);
					match(ID);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class UnaryExprContext extends ParserRuleContext {
		public Token neg;
		public Token pos;
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryExpr);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				((UnaryExprContext)_localctx).neg = match(T__23);
				setState(231);
				unaryExpr();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				((UnaryExprContext)_localctx).pos = match(T__22);
				setState(233);
				unaryExpr();
				}
				break;
			case T__1:
			case TRUE:
			case FALSE:
			case ID:
			case DOUBLE:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				atom();
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
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuarkParser.INT, 0); }
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public TerminalNode DOUBLE() { return getToken(QuarkParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(QuarkParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(QuarkParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(QuarkParser.FALSE, 0); }
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
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
		enterRule(_localctx, 52, RULE_atom);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(DOUBLE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(240);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				match(FALSE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(243);
				funccall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(244);
				match(T__1);
				setState(245);
				expr();
				setState(246);
				match(T__2);
				}
				break;
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
		case 21:
			return addexpr_sempred((AddexprContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\u0004\u0001%\u00fb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0004\u0000"+
		"8\b\u0000\u000b\u0000\f\u00009\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001H\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002N\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002S\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005d\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005i\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"p\b\u0006\n\u0006\f\u0006s\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"w\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0005\n\u0085\b\n\n\n\f\n\u0088"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0091\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u009c\b\r\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00a0\b\u000e\n\u000e\f\u000e\u00a3\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0003\u0010\u00ae\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00be"+
		"\b\u0013\n\u0013\f\u0013\u00c1\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u00c6\b\u0014\n\u0014\f\u0014\u00c9\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00d1"+
		"\b\u0015\n\u0015\f\u0015\u00d4\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00db\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u00e2\b\u0018\n\u0018"+
		"\f\u0018\u00e5\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u00ec\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u00f9\b\u001a\u0001\u001a\u0000\u0001"+
		"*\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.024\u0000\u0004\u0001\u0000\u0011\u0012\u0001"+
		"\u0000\u0013\u0016\u0001\u0000\u0017\u0018\u0001\u0000\u0019\u001b\u0105"+
		"\u00007\u0001\u0000\u0000\u0000\u0002G\u0001\u0000\u0000\u0000\u0004I"+
		"\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\b^\u0001\u0000"+
		"\u0000\u0000\nc\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000e"+
		"t\u0001\u0000\u0000\u0000\u0010z\u0001\u0000\u0000\u0000\u0012}\u0001"+
		"\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u0089\u0001"+
		"\u0000\u0000\u0000\u0018\u008c\u0001\u0000\u0000\u0000\u001a\u0094\u0001"+
		"\u0000\u0000\u0000\u001c\u009d\u0001\u0000\u0000\u0000\u001e\u00a6\u0001"+
		"\u0000\u0000\u0000 \u00ad\u0001\u0000\u0000\u0000\"\u00b3\u0001\u0000"+
		"\u0000\u0000$\u00b8\u0001\u0000\u0000\u0000&\u00ba\u0001\u0000\u0000\u0000"+
		"(\u00c2\u0001\u0000\u0000\u0000*\u00ca\u0001\u0000\u0000\u0000,\u00da"+
		"\u0001\u0000\u0000\u0000.\u00dc\u0001\u0000\u0000\u00000\u00e3\u0001\u0000"+
		"\u0000\u00002\u00eb\u0001\u0000\u0000\u00004\u00f8\u0001\u0000\u0000\u0000"+
		"68\u0003\u0002\u0001\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:\u0001\u0001"+
		"\u0000\u0000\u0000;H\u0003 \u0010\u0000<H\u0003\"\u0011\u0000=H\u0003"+
		"\u001a\r\u0000>H\u0003\u001e\u000f\u0000?H\u0003\u0004\u0002\u0000@H\u0003"+
		"\n\u0005\u0000AH\u0003\u000e\u0007\u0000BH\u0003\u0010\b\u0000CH\u0003"+
		"\u0012\t\u0000DH\u0003\u0018\f\u0000EH\u0005%\u0000\u0000FH\u0005\"\u0000"+
		"\u0000G;\u0001\u0000\u0000\u0000G<\u0001\u0000\u0000\u0000G=\u0001\u0000"+
		"\u0000\u0000G>\u0001\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000G@\u0001"+
		"\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GB\u0001\u0000\u0000\u0000"+
		"GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GF\u0001\u0000\u0000\u0000H\u0003\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0001\u0000\u0000JK\u0005\u001f\u0000\u0000KM\u0005\u0002\u0000\u0000"+
		"LN\u0003\u0006\u0003\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OR\u0005\u0003\u0000\u0000PQ\u0005\u0004"+
		"\u0000\u0000QS\u0005\u001c\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0003\u001c\u000e\u0000"+
		"U\u0005\u0001\u0000\u0000\u0000V[\u0003\b\u0004\u0000WX\u0005\u0005\u0000"+
		"\u0000XZ\u0003\b\u0004\u0000YW\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0007\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u001c\u0000\u0000"+
		"_`\u0005\u001f\u0000\u0000`\t\u0001\u0000\u0000\u0000ab\u0005\u001f\u0000"+
		"\u0000bd\u0005\u0006\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0005\u001f\u0000\u0000fh\u0005"+
		"\u0002\u0000\u0000gi\u0003\f\u0006\u0000hg\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0005\u0003\u0000\u0000"+
		"k\u000b\u0001\u0000\u0000\u0000lq\u0003$\u0012\u0000mn\u0005\u0005\u0000"+
		"\u0000np\u0003$\u0012\u0000om\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\r\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0005\u0007\u0000\u0000uw\u0003"+
		"$\u0012\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0005\"\u0000\u0000y\u000f\u0001\u0000\u0000\u0000"+
		"z{\u0005\b\u0000\u0000{|\u0005\u001f\u0000\u0000|\u0011\u0001\u0000\u0000"+
		"\u0000}~\u0005\t\u0000\u0000~\u007f\u0005\u001f\u0000\u0000\u007f\u0080"+
		"\u0005\n\u0000\u0000\u0080\u0081\u0003\u0014\n\u0000\u0081\u0082\u0005"+
		"\u000b\u0000\u0000\u0082\u0013\u0001\u0000\u0000\u0000\u0083\u0085\u0003"+
		"\u0016\u000b\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0015\u0001\u0000\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\u001c\u0000\u0000\u008a\u008b\u0005"+
		"\u001f\u0000\u0000\u008b\u0017\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\u001f\u0000\u0000\u008d\u008e\u0005\u001f\u0000\u0000\u008e\u0090\u0005"+
		"\u0002\u0000\u0000\u008f\u0091\u0003\f\u0006\u0000\u0090\u008f\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\u0003\u0000\u0000\u0093\u0019\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0005\f\u0000\u0000\u0095\u0096\u0005\u0002\u0000"+
		"\u0000\u0096\u0097\u0003$\u0012\u0000\u0097\u0098\u0005\u0003\u0000\u0000"+
		"\u0098\u009b\u0003\u001c\u000e\u0000\u0099\u009a\u0005\r\u0000\u0000\u009a"+
		"\u009c\u0003\u001c\u000e\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0001\u0000\u0000\u0000\u009c\u001b\u0001\u0000\u0000\u0000\u009d"+
		"\u00a1\u0005\n\u0000\u0000\u009e\u00a0\u0003\u0002\u0001\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0005\u000b\u0000\u0000\u00a5\u001d\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\u000e\u0000\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00a9"+
		"\u0003$\u0012\u0000\u00a9\u00aa\u0005\u0003\u0000\u0000\u00aa\u00ab\u0003"+
		"\u001c\u000e\u0000\u00ab\u001f\u0001\u0000\u0000\u0000\u00ac\u00ae\u0005"+
		"\u001c\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\u001f\u0000\u0000\u00b0\u00b1\u0005\u000f\u0000\u0000\u00b1\u00b2\u0003"+
		"$\u0012\u0000\u00b2!\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0010\u0000"+
		"\u0000\u00b4\u00b5\u0005\u0002\u0000\u0000\u00b5\u00b6\u0003$\u0012\u0000"+
		"\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7#\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0003&\u0013\u0000\u00b9%\u0001\u0000\u0000\u0000\u00ba\u00bf\u0003"+
		"(\u0014\u0000\u00bb\u00bc\u0007\u0000\u0000\u0000\u00bc\u00be\u0003(\u0014"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\'\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c7\u0003*\u0015\u0000\u00c3\u00c4\u0007\u0001\u0000\u0000\u00c4"+
		"\u00c6\u0003*\u0015\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8)\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0006\u0015\uffff\uffff\u0000\u00cb\u00cc"+
		"\u0003,\u0016\u0000\u00cc\u00d2\u0001\u0000\u0000\u0000\u00cd\u00ce\n"+
		"\u0002\u0000\u0000\u00ce\u00cf\u0007\u0002\u0000\u0000\u00cf\u00d1\u0003"+
		",\u0016\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3+\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0003.\u0017\u0000\u00d6\u00d7\u0007\u0003\u0000\u0000"+
		"\u00d7\u00d8\u0003.\u0017\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00db\u0003.\u0017\u0000\u00da\u00d5\u0001\u0000\u0000\u0000\u00da\u00d9"+
		"\u0001\u0000\u0000\u0000\u00db-\u0001\u0000\u0000\u0000\u00dc\u00dd\u0003"+
		"2\u0019\u0000\u00dd\u00de\u00030\u0018\u0000\u00de/\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\u0006\u0000\u0000\u00e0\u00e2\u0005\u001f\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e41\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005\u0018\u0000\u0000\u00e7\u00ec\u00032\u0019\u0000\u00e8"+
		"\u00e9\u0005\u0017\u0000\u0000\u00e9\u00ec\u00032\u0019\u0000\u00ea\u00ec"+
		"\u00034\u001a\u0000\u00eb\u00e6\u0001\u0000\u0000\u0000\u00eb\u00e8\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec3\u0001\u0000"+
		"\u0000\u0000\u00ed\u00f9\u0005!\u0000\u0000\u00ee\u00f9\u0005\u001f\u0000"+
		"\u0000\u00ef\u00f9\u0005 \u0000\u0000\u00f0\u00f9\u0005$\u0000\u0000\u00f1"+
		"\u00f9\u0005\u001d\u0000\u0000\u00f2\u00f9\u0005\u001e\u0000\u0000\u00f3"+
		"\u00f9\u0003\n\u0005\u0000\u00f4\u00f5\u0005\u0002\u0000\u0000\u00f5\u00f6"+
		"\u0003$\u0012\u0000\u00f6\u00f7\u0005\u0003\u0000\u0000\u00f7\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f8\u00ed\u0001\u0000\u0000\u0000\u00f8\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f8\u00ef\u0001\u0000\u0000\u0000\u00f8\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f1\u0001\u0000\u0000\u0000\u00f8\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f3\u0001\u0000\u0000\u0000\u00f8\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f95\u0001\u0000\u0000\u0000\u00159GMR[chqv\u0086"+
		"\u0090\u009b\u00a1\u00ad\u00bf\u00c7\u00d2\u00da\u00e3\u00eb\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}