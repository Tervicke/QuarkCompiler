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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, TYPE=37, TRUE=38, FALSE=39, 
		ID=40, DOUBLE=41, INT=42, NEWLINE=43, WS=44, STRING=45, LineComment=46;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_funcdefn = 2, RULE_paramlist = 3, RULE_param = 4, 
		RULE_funccall = 5, RULE_arglist = 6, RULE_returnstat = 7, RULE_importstat = 8, 
		RULE_definestructstat = 9, RULE_structstats = 10, RULE_structfield = 11, 
		RULE_declarestruct = 12, RULE_destructstat = 13, RULE_idlist = 14, RULE_ifstatement = 15, 
		RULE_block = 16, RULE_continuestatement = 17, RULE_breakstatement = 18, 
		RULE_whilestat = 19, RULE_patternmatchstat = 20, RULE_matcharms = 21, 
		RULE_matchbody = 22, RULE_pattern = 23, RULE_assigstat = 24, RULE_printstat = 25, 
		RULE_expr = 26, RULE_equalityexpr = 27, RULE_relationalexpr = 28, RULE_addexpr = 29, 
		RULE_mulexpr = 30, RULE_fieldaccess = 31, RULE_access = 32, RULE_unaryExpr = 33, 
		RULE_atom = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "funcdefn", "paramlist", "param", "funccall", "arglist", 
			"returnstat", "importstat", "definestructstat", "structstats", "structfield", 
			"declarestruct", "destructstat", "idlist", "ifstatement", "block", "continuestatement", 
			"breakstatement", "whilestat", "patternmatchstat", "matcharms", "matchbody", 
			"pattern", "assigstat", "printstat", "expr", "equalityexpr", "relationalexpr", 
			"addexpr", "mulexpr", "fieldaccess", "access", "unaryExpr", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fn'", "'('", "')'", "'->'", "','", "'.'", "'return'", "'import'", 
			"'struct'", "'{'", "'}'", "'let'", "'['", "']'", "'='", "'if'", "'else'", 
			"'continue'", "'break'", "'while'", "'match'", "'=>'", "'@'", "'_'", 
			"'print'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TYPE", "TRUE", "FALSE", "ID", "DOUBLE", "INT", "NEWLINE", "WS", 
			"STRING", "LineComment"
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
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				stat();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 80401825338242L) != 0 );
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
		public ContinuestatementContext continuestatement() {
			return getRuleContext(ContinuestatementContext.class,0);
		}
		public BreakstatementContext breakstatement() {
			return getRuleContext(BreakstatementContext.class,0);
		}
		public PatternmatchstatContext patternmatchstat() {
			return getRuleContext(PatternmatchstatContext.class,0);
		}
		public DestructstatContext destructstat() {
			return getRuleContext(DestructstatContext.class,0);
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
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((StatContext)_localctx).assig = assigstat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				((StatContext)_localctx).print = printstat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				ifstatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				whilestat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				funcdefn();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				funccall();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				returnstat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				importstat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(83);
				definestructstat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(84);
				declarestruct();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(85);
				continuestatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(86);
				breakstatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(87);
				patternmatchstat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(88);
				destructstat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(89);
				match(LineComment);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(90);
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
			setState(93);
			match(T__0);
			setState(94);
			match(ID);
			setState(95);
			match(T__1);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(96);
				paramlist();
				}
			}

			setState(99);
			match(T__2);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(100);
				match(T__3);
				setState(101);
				match(TYPE);
				}
			}

			setState(104);
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
			setState(106);
			param();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(107);
				match(T__4);
				setState(108);
				param();
				}
				}
				setState(113);
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
			setState(114);
			match(TYPE);
			setState(115);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(117);
				((FunccallContext)_localctx).modulename = match(ID);
				setState(118);
				match(T__5);
				}
				break;
			}
			setState(121);
			((FunccallContext)_localctx).functionname = match(ID);
			setState(122);
			match(T__1);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 43718472105988L) != 0) {
				{
				setState(123);
				arglist();
				}
			}

			setState(126);
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
			setState(128);
			expr();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(129);
				match(T__4);
				setState(130);
				expr();
				}
				}
				setState(135);
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
			setState(136);
			match(T__6);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 43718472105988L) != 0) {
				{
				setState(137);
				expr();
				}
			}

			setState(140);
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
			setState(142);
			match(T__7);
			setState(143);
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
			setState(145);
			match(T__8);
			setState(146);
			match(ID);
			setState(147);
			match(T__9);
			setState(148);
			structstats();
			setState(149);
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
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(151);
				structfield();
				}
				}
				setState(156);
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
			setState(157);
			match(TYPE);
			setState(158);
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
			setState(160);
			match(ID);
			setState(161);
			match(ID);
			setState(162);
			match(T__1);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 43718472105988L) != 0) {
				{
				setState(163);
				arglist();
				}
			}

			setState(166);
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
	public static class DestructstatContext extends ParserRuleContext {
		public IdlistContext idlist() {
			return getRuleContext(IdlistContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public DestructstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterDestructstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitDestructstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitDestructstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestructstatContext destructstat() throws RecognitionException {
		DestructstatContext _localctx = new DestructstatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_destructstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__11);
			setState(169);
			match(T__12);
			setState(170);
			idlist();
			setState(171);
			match(T__13);
			setState(172);
			match(T__14);
			setState(173);
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
	public static class IdlistContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(QuarkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuarkParser.ID, i);
		}
		public IdlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterIdlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitIdlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitIdlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdlistContext idlist() throws RecognitionException {
		IdlistContext _localctx = new IdlistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_idlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(ID);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(176);
				match(T__4);
				setState(177);
				match(ID);
				}
				}
				setState(182);
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
		enterRule(_localctx, 30, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__15);
			setState(184);
			match(T__1);
			setState(185);
			expr();
			setState(186);
			match(T__2);
			setState(187);
			block();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(188);
				match(T__16);
				setState(189);
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
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__9);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 80401825338242L) != 0) {
				{
				{
				setState(193);
				stat();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
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
	public static class ContinuestatementContext extends ParserRuleContext {
		public ContinuestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continuestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterContinuestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitContinuestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitContinuestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinuestatementContext continuestatement() throws RecognitionException {
		ContinuestatementContext _localctx = new ContinuestatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continuestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__17);
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
	public static class BreakstatementContext extends ParserRuleContext {
		public BreakstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterBreakstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitBreakstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitBreakstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakstatementContext breakstatement() throws RecognitionException {
		BreakstatementContext _localctx = new BreakstatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__18);
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
		enterRule(_localctx, 38, RULE_whilestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__19);
			setState(206);
			match(T__1);
			setState(207);
			expr();
			setState(208);
			match(T__2);
			setState(209);
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
	public static class PatternmatchstatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public List<MatcharmsContext> matcharms() {
			return getRuleContexts(MatcharmsContext.class);
		}
		public MatcharmsContext matcharms(int i) {
			return getRuleContext(MatcharmsContext.class,i);
		}
		public PatternmatchstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternmatchstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterPatternmatchstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitPatternmatchstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitPatternmatchstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternmatchstatContext patternmatchstat() throws RecognitionException {
		PatternmatchstatContext _localctx = new PatternmatchstatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_patternmatchstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__20);
			setState(212);
			match(ID);
			setState(213);
			match(T__9);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 43705612369924L) != 0) {
				{
				{
				setState(214);
				matcharms();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
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
	public static class MatcharmsContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public MatchbodyContext matchbody() {
			return getRuleContext(MatchbodyContext.class,0);
		}
		public MatcharmsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matcharms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterMatcharms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitMatcharms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitMatcharms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatcharmsContext matcharms() throws RecognitionException {
		MatcharmsContext _localctx = new MatcharmsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_matcharms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			pattern();
			setState(223);
			match(T__21);
			setState(224);
			matchbody();
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
	public static class MatchbodyContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public MatchbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterMatchbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitMatchbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitMatchbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchbodyContext matchbody() throws RecognitionException {
		MatchbodyContext _localctx = new MatchbodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_matchbody);
		int _la;
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__8:
			case T__11:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__24:
			case TYPE:
			case ID:
			case NEWLINE:
			case LineComment:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				stat();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(T__9);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 80401825338242L) != 0) {
					{
					{
					setState(228);
					stat();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234);
				match(T__10);
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
	public static class PatternContext extends ParserRuleContext {
		public AtomContext isatom;
		public Token istruct;
		public Token iswildcard;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuarkParser.ID, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuarkListener ) ((QuarkListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuarkVisitor ) return ((QuarkVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pattern);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case TRUE:
			case FALSE:
			case ID:
			case DOUBLE:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				((PatternContext)_localctx).isatom = atom();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				((PatternContext)_localctx).istruct = match(T__22);
				setState(239);
				match(ID);
				setState(240);
				match(T__1);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 43718472105988L) != 0) {
					{
					setState(241);
					arglist();
					}
				}

				setState(244);
				match(T__2);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				((PatternContext)_localctx).iswildcard = match(T__23);
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
		enterRule(_localctx, 48, RULE_assigstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(248);
				match(TYPE);
				}
			}

			setState(251);
			match(ID);
			setState(252);
			match(T__14);
			{
			setState(253);
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
		enterRule(_localctx, 50, RULE_printstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__24);
			setState(256);
			match(T__1);
			{
			setState(257);
			expr();
			}
			setState(258);
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
		enterRule(_localctx, 52, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		enterRule(_localctx, 54, RULE_equalityexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			relationalexpr();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25 || _la==T__26) {
				{
				{
				setState(263);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(264);
				relationalexpr();
				}
				}
				setState(269);
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
		enterRule(_localctx, 56, RULE_relationalexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			addexpr(0);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0) {
				{
				{
				setState(271);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(272);
				addexpr(0);
				}
				}
				setState(277);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_addexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(279);
			mulexpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexpr);
					setState(281);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(282);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(283);
					mulexpr();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 60, RULE_mulexpr);
		int _la;
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				fieldaccess();
				setState(290);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 120259084288L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291);
				fieldaccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
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
		enterRule(_localctx, 62, RULE_fieldaccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			unaryExpr();
			setState(297);
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
		enterRule(_localctx, 64, RULE_access);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(299);
					match(T__5);
					setState(300);
					match(ID);
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 66, RULE_unaryExpr);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				((UnaryExprContext)_localctx).neg = match(T__32);
				setState(307);
				unaryExpr();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				((UnaryExprContext)_localctx).pos = match(T__31);
				setState(309);
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
				setState(310);
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
		enterRule(_localctx, 68, RULE_atom);
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				match(DOUBLE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(318);
				match(FALSE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(319);
				funccall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(320);
				match(T__1);
				setState(321);
				expr();
				setState(322);
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
		case 29:
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
		"\u0004\u0001.\u0147\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0004\u0000H\b\u0000\u000b\u0000\f\u0000I\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\\\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002b\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003n\b\u0003\n\u0003\f\u0003q\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005"+
		"x\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005}\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0084"+
		"\b\u0006\n\u0006\f\u0006\u0087\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u008b\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0005\n\u0099\b\n\n\n"+
		"\f\n\u009c\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00a5\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00b3\b\u000e\n\u000e\f\u000e\u00b6\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00bf"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00c3\b\u0010\n\u0010\f\u0010"+
		"\u00c6\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u00d8\b\u0014\n\u0014\f\u0014\u00db\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u00e6\b\u0016\n\u0016\f\u0016\u00e9\t\u0016\u0001\u0016"+
		"\u0003\u0016\u00ec\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u00f3\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u00f7\b\u0017\u0001\u0018\u0003\u0018\u00fa\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u010a\b\u001b\n\u001b\f\u001b\u010d\t\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u0112\b\u001c\n\u001c\f\u001c\u0115"+
		"\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0005\u001d\u011d\b\u001d\n\u001d\f\u001d\u0120\t\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0127\b\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0005 \u012e\b \n "+
		"\f \u0131\t \u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u0138\b!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u0145\b\"\u0001\"\u0000\u0001:#\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BD\u0000\u0004\u0001\u0000\u001a\u001b\u0001\u0000\u001c\u001f"+
		"\u0001\u0000 !\u0001\u0000\"$\u0154\u0000G\u0001\u0000\u0000\u0000\u0002"+
		"[\u0001\u0000\u0000\u0000\u0004]\u0001\u0000\u0000\u0000\u0006j\u0001"+
		"\u0000\u0000\u0000\br\u0001\u0000\u0000\u0000\nw\u0001\u0000\u0000\u0000"+
		"\f\u0080\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000\u0000\u0000\u0010"+
		"\u008e\u0001\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000\u0014"+
		"\u009a\u0001\u0000\u0000\u0000\u0016\u009d\u0001\u0000\u0000\u0000\u0018"+
		"\u00a0\u0001\u0000\u0000\u0000\u001a\u00a8\u0001\u0000\u0000\u0000\u001c"+
		"\u00af\u0001\u0000\u0000\u0000\u001e\u00b7\u0001\u0000\u0000\u0000 \u00c0"+
		"\u0001\u0000\u0000\u0000\"\u00c9\u0001\u0000\u0000\u0000$\u00cb\u0001"+
		"\u0000\u0000\u0000&\u00cd\u0001\u0000\u0000\u0000(\u00d3\u0001\u0000\u0000"+
		"\u0000*\u00de\u0001\u0000\u0000\u0000,\u00eb\u0001\u0000\u0000\u0000."+
		"\u00f6\u0001\u0000\u0000\u00000\u00f9\u0001\u0000\u0000\u00002\u00ff\u0001"+
		"\u0000\u0000\u00004\u0104\u0001\u0000\u0000\u00006\u0106\u0001\u0000\u0000"+
		"\u00008\u010e\u0001\u0000\u0000\u0000:\u0116\u0001\u0000\u0000\u0000<"+
		"\u0126\u0001\u0000\u0000\u0000>\u0128\u0001\u0000\u0000\u0000@\u012f\u0001"+
		"\u0000\u0000\u0000B\u0137\u0001\u0000\u0000\u0000D\u0144\u0001\u0000\u0000"+
		"\u0000FH\u0003\u0002\u0001\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0001"+
		"\u0001\u0000\u0000\u0000K\\\u00030\u0018\u0000L\\\u00032\u0019\u0000M"+
		"\\\u0003\u001e\u000f\u0000N\\\u0003&\u0013\u0000O\\\u0003\u0004\u0002"+
		"\u0000P\\\u0003\n\u0005\u0000Q\\\u0003\u000e\u0007\u0000R\\\u0003\u0010"+
		"\b\u0000S\\\u0003\u0012\t\u0000T\\\u0003\u0018\f\u0000U\\\u0003\"\u0011"+
		"\u0000V\\\u0003$\u0012\u0000W\\\u0003(\u0014\u0000X\\\u0003\u001a\r\u0000"+
		"Y\\\u0005.\u0000\u0000Z\\\u0005+\u0000\u0000[K\u0001\u0000\u0000\u0000"+
		"[L\u0001\u0000\u0000\u0000[M\u0001\u0000\u0000\u0000[N\u0001\u0000\u0000"+
		"\u0000[O\u0001\u0000\u0000\u0000[P\u0001\u0000\u0000\u0000[Q\u0001\u0000"+
		"\u0000\u0000[R\u0001\u0000\u0000\u0000[S\u0001\u0000\u0000\u0000[T\u0001"+
		"\u0000\u0000\u0000[U\u0001\u0000\u0000\u0000[V\u0001\u0000\u0000\u0000"+
		"[W\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[Z\u0001\u0000\u0000\u0000\\\u0003\u0001\u0000\u0000\u0000]^\u0005"+
		"\u0001\u0000\u0000^_\u0005(\u0000\u0000_a\u0005\u0002\u0000\u0000`b\u0003"+
		"\u0006\u0003\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000cf\u0005\u0003\u0000\u0000de\u0005\u0004\u0000"+
		"\u0000eg\u0005%\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hi\u0003 \u0010\u0000i\u0005\u0001\u0000"+
		"\u0000\u0000jo\u0003\b\u0004\u0000kl\u0005\u0005\u0000\u0000ln\u0003\b"+
		"\u0004\u0000mk\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u0007\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000rs\u0005%\u0000\u0000st\u0005(\u0000\u0000"+
		"t\t\u0001\u0000\u0000\u0000uv\u0005(\u0000\u0000vx\u0005\u0006\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0005(\u0000\u0000z|\u0005\u0002\u0000\u0000{}\u0003\f\u0006"+
		"\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\u0003\u0000\u0000\u007f\u000b\u0001\u0000\u0000"+
		"\u0000\u0080\u0085\u00034\u001a\u0000\u0081\u0082\u0005\u0005\u0000\u0000"+
		"\u0082\u0084\u00034\u001a\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\r\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0088\u008a\u0005\u0007\u0000\u0000\u0089\u008b"+
		"\u00034\u001a\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"+\u0000\u0000\u008d\u000f\u0001\u0000\u0000\u0000\u008e\u008f\u0005\b"+
		"\u0000\u0000\u008f\u0090\u0005(\u0000\u0000\u0090\u0011\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\t\u0000\u0000\u0092\u0093\u0005(\u0000\u0000"+
		"\u0093\u0094\u0005\n\u0000\u0000\u0094\u0095\u0003\u0014\n\u0000\u0095"+
		"\u0096\u0005\u000b\u0000\u0000\u0096\u0013\u0001\u0000\u0000\u0000\u0097"+
		"\u0099\u0003\u0016\u000b\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005%\u0000\u0000\u009e\u009f"+
		"\u0005(\u0000\u0000\u009f\u0017\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"(\u0000\u0000\u00a1\u00a2\u0005(\u0000\u0000\u00a2\u00a4\u0005\u0002\u0000"+
		"\u0000\u00a3\u00a5\u0003\f\u0006\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\u0003\u0000\u0000\u00a7\u0019\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0005\f\u0000\u0000\u00a9\u00aa\u0005\r\u0000\u0000\u00aa"+
		"\u00ab\u0003\u001c\u000e\u0000\u00ab\u00ac\u0005\u000e\u0000\u0000\u00ac"+
		"\u00ad\u0005\u000f\u0000\u0000\u00ad\u00ae\u0005(\u0000\u0000\u00ae\u001b"+
		"\u0001\u0000\u0000\u0000\u00af\u00b4\u0005(\u0000\u0000\u00b0\u00b1\u0005"+
		"\u0005\u0000\u0000\u00b1\u00b3\u0005(\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u001d\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0010"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00ba\u00034\u001a"+
		"\u0000\u00ba\u00bb\u0005\u0003\u0000\u0000\u00bb\u00be\u0003 \u0010\u0000"+
		"\u00bc\u00bd\u0005\u0011\u0000\u0000\u00bd\u00bf\u0003 \u0010\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf"+
		"\u001f\u0001\u0000\u0000\u0000\u00c0\u00c4\u0005\n\u0000\u0000\u00c1\u00c3"+
		"\u0003\u0002\u0001\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u000b\u0000\u0000\u00c8!\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005\u0012\u0000\u0000\u00ca#\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0005\u0013\u0000\u0000\u00cc%\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0005\u0014\u0000\u0000\u00ce\u00cf\u0005\u0002\u0000"+
		"\u0000\u00cf\u00d0\u00034\u001a\u0000\u00d0\u00d1\u0005\u0003\u0000\u0000"+
		"\u00d1\u00d2\u0003 \u0010\u0000\u00d2\'\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0005\u0015\u0000\u0000\u00d4\u00d5\u0005(\u0000\u0000\u00d5\u00d9"+
		"\u0005\n\u0000\u0000\u00d6\u00d8\u0003*\u0015\u0000\u00d7\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dc\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\u000b\u0000\u0000\u00dd)\u0001\u0000\u0000\u0000\u00de\u00df\u0003.\u0017"+
		"\u0000\u00df\u00e0\u0005\u0016\u0000\u0000\u00e0\u00e1\u0003,\u0016\u0000"+
		"\u00e1+\u0001\u0000\u0000\u0000\u00e2\u00ec\u0003\u0002\u0001\u0000\u00e3"+
		"\u00e7\u0005\n\u0000\u0000\u00e4\u00e6\u0003\u0002\u0001\u0000\u00e5\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00ea"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00ec"+
		"\u0005\u000b\u0000\u0000\u00eb\u00e2\u0001\u0000\u0000\u0000\u00eb\u00e3"+
		"\u0001\u0000\u0000\u0000\u00ec-\u0001\u0000\u0000\u0000\u00ed\u00f7\u0003"+
		"D\"\u0000\u00ee\u00ef\u0005\u0017\u0000\u0000\u00ef\u00f0\u0005(\u0000"+
		"\u0000\u00f0\u00f2\u0005\u0002\u0000\u0000\u00f1\u00f3\u0003\f\u0006\u0000"+
		"\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f7\u0005\u0003\u0000\u0000"+
		"\u00f5\u00f7\u0005\u0018\u0000\u0000\u00f6\u00ed\u0001\u0000\u0000\u0000"+
		"\u00f6\u00ee\u0001\u0000\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f7/\u0001\u0000\u0000\u0000\u00f8\u00fa\u0005%\u0000\u0000\u00f9\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005(\u0000\u0000\u00fc\u00fd\u0005"+
		"\u000f\u0000\u0000\u00fd\u00fe\u00034\u001a\u0000\u00fe1\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0005\u0019\u0000\u0000\u0100\u0101\u0005\u0002\u0000"+
		"\u0000\u0101\u0102\u00034\u001a\u0000\u0102\u0103\u0005\u0003\u0000\u0000"+
		"\u01033\u0001\u0000\u0000\u0000\u0104\u0105\u00036\u001b\u0000\u01055"+
		"\u0001\u0000\u0000\u0000\u0106\u010b\u00038\u001c\u0000\u0107\u0108\u0007"+
		"\u0000\u0000\u0000\u0108\u010a\u00038\u001c\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c7\u0001\u0000\u0000"+
		"\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0113\u0003:\u001d\u0000"+
		"\u010f\u0110\u0007\u0001\u0000\u0000\u0110\u0112\u0003:\u001d\u0000\u0111"+
		"\u010f\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113"+
		"\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114"+
		"9\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0006\u001d\uffff\uffff\u0000\u0117\u0118\u0003<\u001e\u0000\u0118\u011e"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\n\u0002\u0000\u0000\u011a\u011b\u0007"+
		"\u0002\u0000\u0000\u011b\u011d\u0003<\u001e\u0000\u011c\u0119\u0001\u0000"+
		"\u0000\u0000\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f;\u0001\u0000\u0000"+
		"\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0121\u0122\u0003>\u001f\u0000"+
		"\u0122\u0123\u0007\u0003\u0000\u0000\u0123\u0124\u0003>\u001f\u0000\u0124"+
		"\u0127\u0001\u0000\u0000\u0000\u0125\u0127\u0003>\u001f\u0000\u0126\u0121"+
		"\u0001\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0127=\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0003B!\u0000\u0129\u012a\u0003@ \u0000"+
		"\u012a?\u0001\u0000\u0000\u0000\u012b\u012c\u0005\u0006\u0000\u0000\u012c"+
		"\u012e\u0005(\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u0131"+
		"\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130"+
		"\u0001\u0000\u0000\u0000\u0130A\u0001\u0000\u0000\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0132\u0133\u0005!\u0000\u0000\u0133\u0138\u0003B!"+
		"\u0000\u0134\u0135\u0005 \u0000\u0000\u0135\u0138\u0003B!\u0000\u0136"+
		"\u0138\u0003D\"\u0000\u0137\u0132\u0001\u0000\u0000\u0000\u0137\u0134"+
		"\u0001\u0000\u0000\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0138C\u0001"+
		"\u0000\u0000\u0000\u0139\u0145\u0005*\u0000\u0000\u013a\u0145\u0005(\u0000"+
		"\u0000\u013b\u0145\u0005)\u0000\u0000\u013c\u0145\u0005-\u0000\u0000\u013d"+
		"\u0145\u0005&\u0000\u0000\u013e\u0145\u0005\'\u0000\u0000\u013f\u0145"+
		"\u0003\n\u0005\u0000\u0140\u0141\u0005\u0002\u0000\u0000\u0141\u0142\u0003"+
		"4\u001a\u0000\u0142\u0143\u0005\u0003\u0000\u0000\u0143\u0145\u0001\u0000"+
		"\u0000\u0000\u0144\u0139\u0001\u0000\u0000\u0000\u0144\u013a\u0001\u0000"+
		"\u0000\u0000\u0144\u013b\u0001\u0000\u0000\u0000\u0144\u013c\u0001\u0000"+
		"\u0000\u0000\u0144\u013d\u0001\u0000\u0000\u0000\u0144\u013e\u0001\u0000"+
		"\u0000\u0000\u0144\u013f\u0001\u0000\u0000\u0000\u0144\u0140\u0001\u0000"+
		"\u0000\u0000\u0145E\u0001\u0000\u0000\u0000\u001bI[afow|\u0085\u008a\u009a"+
		"\u00a4\u00b4\u00be\u00c4\u00d9\u00e7\u00eb\u00f2\u00f6\u00f9\u010b\u0113"+
		"\u011e\u0126\u012f\u0137\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}