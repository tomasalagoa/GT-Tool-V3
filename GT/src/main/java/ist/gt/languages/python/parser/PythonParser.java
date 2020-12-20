// Generated from C:/Users/mihail/Desktop/Tese/master-thesis/YASAT/src/main/resources/grammars/python\PythonParser.g4 by ANTLR 4.8
package ist.gt.languages.python.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PythonParser extends PythonParserBase {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, LINE_BREAK=3, DEF=4, RETURN=5, RAISE=6, FROM=7, IMPORT=8, 
		NONLOCAL=9, AS=10, GLOBAL=11, ASSERT=12, IF=13, ELIF=14, ELSE=15, WHILE=16, 
		FOR=17, IN=18, TRY=19, NONE=20, FINALLY=21, WITH=22, EXCEPT=23, LAMBDA=24, 
		OR=25, AND=26, NOT=27, IS=28, CLASS=29, YIELD=30, DEL=31, PASS=32, CONTINUE=33, 
		BREAK=34, ASYNC=35, AWAIT=36, PRINT=37, EXEC=38, TRUE=39, FALSE=40, DOT=41, 
		ELLIPSIS=42, REVERSE_QUOTE=43, STAR=44, COMMA=45, COLON=46, SEMI_COLON=47, 
		POWER=48, ASSIGN=49, OR_OP=50, XOR=51, AND_OP=52, LEFT_SHIFT=53, RIGHT_SHIFT=54, 
		ADD=55, MINUS=56, DIV=57, MOD=58, IDIV=59, NOT_OP=60, LESS_THAN=61, GREATER_THAN=62, 
		EQUALS=63, GT_EQ=64, LT_EQ=65, NOT_EQ_1=66, NOT_EQ_2=67, AT=68, ARROW=69, 
		ADD_ASSIGN=70, SUB_ASSIGN=71, MULT_ASSIGN=72, AT_ASSIGN=73, DIV_ASSIGN=74, 
		MOD_ASSIGN=75, AND_ASSIGN=76, OR_ASSIGN=77, XOR_ASSIGN=78, LEFT_SHIFT_ASSIGN=79, 
		RIGHT_SHIFT_ASSIGN=80, POWER_ASSIGN=81, IDIV_ASSIGN=82, STRING=83, DECIMAL_INTEGER=84, 
		OCT_INTEGER=85, HEX_INTEGER=86, BIN_INTEGER=87, IMAG_NUMBER=88, FLOAT_NUMBER=89, 
		OPEN_PAREN=90, CLOSE_PAREN=91, OPEN_BRACE=92, CLOSE_BRACE=93, OPEN_BRACKET=94, 
		CLOSE_BRACKET=95, NAME=96, LINE_JOIN=97, NEWLINE=98, WS=99, COMMENT=100;
	public static final int
		RULE_root = 0, RULE_single_input = 1, RULE_file_input = 2, RULE_eval_input = 3, 
		RULE_stmt = 4, RULE_compound_stmt = 5, RULE_suite = 6, RULE_decorator = 7, 
		RULE_elif_clause = 8, RULE_else_clause = 9, RULE_finally_clause = 10, 
		RULE_with_item = 11, RULE_except_clause = 12, RULE_classdef = 13, RULE_funcdef = 14, 
		RULE_typedargslist = 15, RULE_args = 16, RULE_kwargs = 17, RULE_def_parameters = 18, 
		RULE_def_parameter = 19, RULE_named_parameter = 20, RULE_simple_stmt = 21, 
		RULE_small_stmt = 22, RULE_testlist_star_expr = 23, RULE_star_expr = 24, 
		RULE_assign_part = 25, RULE_exprlist = 26, RULE_import_as_names = 27, 
		RULE_import_as_name = 28, RULE_dotted_as_names = 29, RULE_dotted_as_name = 30, 
		RULE_test = 31, RULE_varargslist = 32, RULE_vardef_parameters = 33, RULE_vardef_parameter = 34, 
		RULE_varargs = 35, RULE_varkwargs = 36, RULE_logical_test = 37, RULE_comparison = 38, 
		RULE_expr = 39, RULE_method_chain = 40, RULE_function_call = 41, RULE_atom = 42, 
		RULE_string_literal = 43, RULE_dictorsetmaker = 44, RULE_testlist_comp = 45, 
		RULE_testlist = 46, RULE_dotted_name = 47, RULE_name = 48, RULE_name_literal = 49, 
		RULE_true_false = 50, RULE_number = 51, RULE_integer = 52, RULE_yield_expr = 53, 
		RULE_yield_arg = 54, RULE_trailer = 55, RULE_method_call = 56, RULE_attribute_access = 57, 
		RULE_arguments = 58, RULE_arglist = 59, RULE_argument = 60, RULE_subscriptlist = 61, 
		RULE_subscript = 62, RULE_sliceop = 63, RULE_comp_for = 64, RULE_comp_iter = 65;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "single_input", "file_input", "eval_input", "stmt", "compound_stmt", 
			"suite", "decorator", "elif_clause", "else_clause", "finally_clause", 
			"with_item", "except_clause", "classdef", "funcdef", "typedargslist", 
			"args", "kwargs", "def_parameters", "def_parameter", "named_parameter", 
			"simple_stmt", "small_stmt", "testlist_star_expr", "star_expr", "assign_part", 
			"exprlist", "import_as_names", "import_as_name", "dotted_as_names", "dotted_as_name", 
			"test", "varargslist", "vardef_parameters", "vardef_parameter", "varargs", 
			"varkwargs", "logical_test", "comparison", "expr", "method_chain", "function_call", 
			"atom", "string_literal", "dictorsetmaker", "testlist_comp", "testlist", 
			"dotted_name", "name", "name_literal", "true_false", "number", "integer", 
			"yield_expr", "yield_arg", "trailer", "method_call", "attribute_access", 
			"arguments", "arglist", "argument", "subscriptlist", "subscript", "sliceop", 
			"comp_for", "comp_iter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'def'", "'return'", "'raise'", "'from'", "'import'", 
			"'nonlocal'", "'as'", "'global'", "'assert'", "'if'", "'elif'", "'else'", 
			"'while'", "'for'", "'in'", "'try'", "'None'", "'finally'", "'with'", 
			"'except'", "'lambda'", "'or'", "'and'", "'not'", "'is'", "'class'", 
			"'yield'", "'del'", "'pass'", "'continue'", "'break'", "'async'", "'await'", 
			"'print'", "'exec'", "'True'", "'False'", "'.'", "'...'", "'`'", "'*'", 
			"','", "':'", "';'", "'**'", "'='", "'|'", "'^'", "'&'", "'<<'", "'>>'", 
			"'+'", "'-'", "'/'", "'%'", "'//'", "'~'", "'<'", "'>'", "'=='", "'>='", 
			"'<='", "'<>'", "'!='", "'@'", "'->'", "'+='", "'-='", "'*='", "'@='", 
			"'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'**='", "'//='", 
			null, null, null, null, null, null, null, "'('", "')'", "'{'", "'}'", 
			"'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "LINE_BREAK", "DEF", "RETURN", "RAISE", "FROM", 
			"IMPORT", "NONLOCAL", "AS", "GLOBAL", "ASSERT", "IF", "ELIF", "ELSE", 
			"WHILE", "FOR", "IN", "TRY", "NONE", "FINALLY", "WITH", "EXCEPT", "LAMBDA", 
			"OR", "AND", "NOT", "IS", "CLASS", "YIELD", "DEL", "PASS", "CONTINUE", 
			"BREAK", "ASYNC", "AWAIT", "PRINT", "EXEC", "TRUE", "FALSE", "DOT", "ELLIPSIS", 
			"REVERSE_QUOTE", "STAR", "COMMA", "COLON", "SEMI_COLON", "POWER", "ASSIGN", 
			"OR_OP", "XOR", "AND_OP", "LEFT_SHIFT", "RIGHT_SHIFT", "ADD", "MINUS", 
			"DIV", "MOD", "IDIV", "NOT_OP", "LESS_THAN", "GREATER_THAN", "EQUALS", 
			"GT_EQ", "LT_EQ", "NOT_EQ_1", "NOT_EQ_2", "AT", "ARROW", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MULT_ASSIGN", "AT_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", 
			"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "LEFT_SHIFT_ASSIGN", "RIGHT_SHIFT_ASSIGN", 
			"POWER_ASSIGN", "IDIV_ASSIGN", "STRING", "DECIMAL_INTEGER", "OCT_INTEGER", 
			"HEX_INTEGER", "BIN_INTEGER", "IMAG_NUMBER", "FLOAT_NUMBER", "OPEN_PAREN", 
			"CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"NAME", "LINE_JOIN", "NEWLINE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "PythonParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public Single_inputContext single_input() {
			return getRuleContext(Single_inputContext.class,0);
		}
		public File_inputContext file_input() {
			return getRuleContext(File_inputContext.class,0);
		}
		public Eval_inputContext eval_input() {
			return getRuleContext(Eval_inputContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(132);
				single_input();
				}
				break;
			case 2:
				{
				setState(133);
				file_input();
				}
				break;
			case 3:
				{
				setState(134);
				eval_input();
				}
				break;
			}
			setState(137);
			match(EOF);
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

	public static class Single_inputContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() { return getToken(PythonParser.LINE_BREAK, 0); }
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Single_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSingle_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSingle_input(this);
		}
	}

	public final Single_inputContext single_input() throws RecognitionException {
		Single_inputContext _localctx = new Single_inputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_single_input);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(LINE_BREAK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				simple_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				compound_stmt();
				setState(142);
				match(LINE_BREAK);
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

	public static class File_inputContext extends ParserRuleContext {
		public List<TerminalNode> LINE_BREAK() { return getTokens(PythonParser.LINE_BREAK); }
		public TerminalNode LINE_BREAK(int i) {
			return getToken(PythonParser.LINE_BREAK, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFile_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFile_input(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_file_input);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(146);
						match(LINE_BREAK);
						}
						break;
					case 2:
						{
						setState(147);
						stmt();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(150); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Eval_inputContext extends ParserRuleContext {
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public List<TerminalNode> LINE_BREAK() { return getTokens(PythonParser.LINE_BREAK); }
		public TerminalNode LINE_BREAK(int i) {
			return getToken(PythonParser.LINE_BREAK, i);
		}
		public Eval_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterEval_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitEval_input(this);
		}
	}

	public final Eval_inputContext eval_input() throws RecognitionException {
		Eval_inputContext _localctx = new Eval_inputContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eval_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			testlist();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINE_BREAK) {
				{
				{
				setState(153);
				match(LINE_BREAK);
				}
				}
				setState(158);
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

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				simple_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				compound_stmt();
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	 
		public Compound_stmtContext() { }
		public void copyFrom(Compound_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class While_stmtContext extends Compound_stmtContext {
		public TerminalNode WHILE() { return getToken(PythonParser.WHILE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public While_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWhile_stmt(this);
		}
	}
	public static class Try_stmtContext extends Compound_stmtContext {
		public TerminalNode TRY() { return getToken(PythonParser.TRY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Finally_clauseContext finally_clause() {
			return getRuleContext(Finally_clauseContext.class,0);
		}
		public List<Except_clauseContext> except_clause() {
			return getRuleContexts(Except_clauseContext.class);
		}
		public Except_clauseContext except_clause(int i) {
			return getRuleContext(Except_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public Try_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTry_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTry_stmt(this);
		}
	}
	public static class If_stmtContext extends Compound_stmtContext {
		public TestContext cond;
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public List<Elif_clauseContext> elif_clause() {
			return getRuleContexts(Elif_clauseContext.class);
		}
		public Elif_clauseContext elif_clause(int i) {
			return getRuleContext(Elif_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public If_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIf_stmt(this);
		}
	}
	public static class With_stmtContext extends Compound_stmtContext {
		public TerminalNode WITH() { return getToken(PythonParser.WITH, 0); }
		public List<With_itemContext> with_item() {
			return getRuleContexts(With_itemContext.class);
		}
		public With_itemContext with_item(int i) {
			return getRuleContext(With_itemContext.class,i);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public With_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_stmt(this);
		}
	}
	public static class Class_or_func_def_stmtContext extends Compound_stmtContext {
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public Class_or_func_def_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_or_func_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_or_func_def_stmt(this);
		}
	}
	public static class For_stmtContext extends Compound_stmtContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public For_stmtContext(Compound_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compound_stmt);
		int _la;
		try {
			int _alt;
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new If_stmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(IF);
				setState(164);
				((If_stmtContext)_localctx).cond = test();
				setState(165);
				match(COLON);
				setState(166);
				suite();
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(167);
						elif_clause();
						}
						} 
					}
					setState(172);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(173);
					else_clause();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new While_stmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(WHILE);
				setState(177);
				test();
				setState(178);
				match(COLON);
				setState(179);
				suite();
				setState(181);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(180);
					else_clause();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new For_stmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASYNC) {
					{
					setState(183);
					match(ASYNC);
					}
				}

				setState(186);
				match(FOR);
				setState(187);
				exprlist();
				setState(188);
				match(IN);
				setState(189);
				testlist();
				setState(190);
				match(COLON);
				setState(191);
				suite();
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(192);
					else_clause();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new Try_stmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(TRY);
				setState(196);
				match(COLON);
				setState(197);
				suite();
				setState(210);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXCEPT:
					{
					setState(199); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(198);
							except_clause();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(201); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(204);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(203);
						else_clause();
						}
						break;
					}
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(206);
						finally_clause();
						}
						break;
					}
					}
					break;
				case FINALLY:
					{
					setState(209);
					finally_clause();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				_localctx = new With_stmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASYNC) {
					{
					setState(212);
					match(ASYNC);
					}
				}

				setState(215);
				match(WITH);
				setState(216);
				with_item();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(217);
					match(COMMA);
					setState(218);
					with_item();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(COLON);
				setState(225);
				suite();
				}
				break;
			case 6:
				_localctx = new Class_or_func_def_stmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(227);
					decorator();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(233);
					classdef();
					}
					break;
				case DEF:
				case ASYNC:
					{
					setState(234);
					funcdef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class SuiteContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode LINE_BREAK() { return getToken(PythonParser.LINE_BREAK, 0); }
		public TerminalNode INDENT() { return getToken(PythonParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSuite(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_suite);
		try {
			int _alt;
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				simple_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(LINE_BREAK);
				setState(241);
				match(INDENT);
				setState(243); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(242);
						stmt();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(245); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(247);
				match(DEDENT);
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

	public static class DecoratorContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(PythonParser.AT, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode LINE_BREAK() { return getToken(PythonParser.LINE_BREAK, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDecorator(this);
		}
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_decorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(AT);
			setState(252);
			dotted_name(0);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(253);
				match(OPEN_PAREN);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << STAR) | (1L << POWER) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(254);
					arglist();
					}
				}

				setState(257);
				match(CLOSE_PAREN);
				}
			}

			setState(260);
			match(LINE_BREAK);
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

	public static class Elif_clauseContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(PythonParser.ELIF, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Elif_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElif_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElif_clause(this);
		}
	}

	public final Elif_clauseContext elif_clause() throws RecognitionException {
		Elif_clauseContext _localctx = new Elif_clauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elif_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(ELIF);
			setState(263);
			test();
			setState(264);
			match(COLON);
			setState(265);
			suite();
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

	public static class Else_clauseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Else_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElse_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElse_clause(this);
		}
	}

	public final Else_clauseContext else_clause() throws RecognitionException {
		Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ELSE);
			setState(268);
			match(COLON);
			setState(269);
			suite();
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

	public static class Finally_clauseContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(PythonParser.FINALLY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Finally_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFinally_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFinally_clause(this);
		}
	}

	public final Finally_clauseContext finally_clause() throws RecognitionException {
		Finally_clauseContext _localctx = new Finally_clauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_finally_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(FINALLY);
			setState(272);
			match(COLON);
			setState(273);
			suite();
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

	public static class With_itemContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public With_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_item(this);
		}
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			test();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(276);
				match(AS);
				setState(277);
				expr(0);
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

	public static class Except_clauseContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(PythonParser.EXCEPT, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Except_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExcept_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExcept_clause(this);
		}
	}

	public final Except_clauseContext except_clause() throws RecognitionException {
		Except_clauseContext _localctx = new Except_clauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_except_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(EXCEPT);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
				{
				setState(281);
				test();
				setState(292);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(282);
					if (!(CheckVersion(2))) throw new FailedPredicateException(this, "CheckVersion(2)");
					setState(283);
					match(COMMA);
					setState(284);
					name();
					SetVersion(2);
					}
					break;
				case 2:
					{
					setState(287);
					if (!(CheckVersion(3))) throw new FailedPredicateException(this, "CheckVersion(3)");
					setState(288);
					match(AS);
					setState(289);
					name();
					SetVersion(3);
					}
					break;
				}
				}
			}

			setState(296);
			match(COLON);
			setState(297);
			suite();
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

	public static class ClassdefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(PythonParser.CLASS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClassdef(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(CLASS);
			setState(300);
			name();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(301);
				match(OPEN_PAREN);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << STAR) | (1L << POWER) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(302);
					arglist();
					}
				}

				setState(305);
				match(CLOSE_PAREN);
				}
			}

			setState(308);
			match(COLON);
			setState(309);
			suite();
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

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(PythonParser.DEF, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public TypedargslistContext typedargslist() {
			return getRuleContext(TypedargslistContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(PythonParser.ARROW, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFuncdef(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(311);
				match(ASYNC);
				}
			}

			setState(314);
			match(DEF);
			setState(315);
			name();
			setState(316);
			match(OPEN_PAREN);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (TRUE - 39)) | (1L << (FALSE - 39)) | (1L << (STAR - 39)) | (1L << (POWER - 39)) | (1L << (NAME - 39)))) != 0)) {
				{
				setState(317);
				typedargslist();
				}
			}

			setState(320);
			match(CLOSE_PAREN);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(321);
				match(ARROW);
				setState(322);
				test();
				}
			}

			setState(325);
			match(COLON);
			setState(326);
			suite();
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

	public static class TypedargslistContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public KwargsContext kwargs() {
			return getRuleContext(KwargsContext.class,0);
		}
		public List<Def_parametersContext> def_parameters() {
			return getRuleContexts(Def_parametersContext.class);
		}
		public Def_parametersContext def_parameters(int i) {
			return getRuleContext(Def_parametersContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TypedargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedargslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTypedargslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTypedargslist(this);
		}
	}

	public final TypedargslistContext typedargslist() throws RecognitionException {
		TypedargslistContext _localctx = new TypedargslistContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typedargslist);
		int _la;
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(328);
					def_parameters();
					setState(329);
					match(COMMA);
					}
					break;
				}
				setState(343);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(333);
					args();
					setState(336);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(334);
						match(COMMA);
						setState(335);
						def_parameters();
						}
						break;
					}
					setState(340);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(338);
						match(COMMA);
						setState(339);
						kwargs();
						}
						break;
					}
					}
					break;
				case POWER:
					{
					setState(342);
					kwargs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(345);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				def_parameters();
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(349);
					match(COMMA);
					}
				}

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

	public static class ArgsContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Named_parameterContext named_parameter() {
			return getRuleContext(Named_parameterContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_args);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(STAR);
			setState(355);
			named_parameter();
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

	public static class KwargsContext extends ParserRuleContext {
		public TerminalNode POWER() { return getToken(PythonParser.POWER, 0); }
		public Named_parameterContext named_parameter() {
			return getRuleContext(Named_parameterContext.class,0);
		}
		public KwargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwargs(this);
		}
	}

	public final KwargsContext kwargs() throws RecognitionException {
		KwargsContext _localctx = new KwargsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_kwargs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(POWER);
			setState(358);
			named_parameter();
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

	public static class Def_parametersContext extends ParserRuleContext {
		public List<Def_parameterContext> def_parameter() {
			return getRuleContexts(Def_parameterContext.class);
		}
		public Def_parameterContext def_parameter(int i) {
			return getRuleContext(Def_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Def_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDef_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDef_parameters(this);
		}
	}

	public final Def_parametersContext def_parameters() throws RecognitionException {
		Def_parametersContext _localctx = new Def_parametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_def_parameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			def_parameter();
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(361);
					match(COMMA);
					setState(362);
					def_parameter();
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class Def_parameterContext extends ParserRuleContext {
		public Named_parameterContext named_parameter() {
			return getRuleContext(Named_parameterContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PythonParser.ASSIGN, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Def_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDef_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDef_parameter(this);
		}
	}

	public final Def_parameterContext def_parameter() throws RecognitionException {
		Def_parameterContext _localctx = new Def_parameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_def_parameter);
		int _la;
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				named_parameter();
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(369);
					match(ASSIGN);
					setState(370);
					test();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(STAR);
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

	public static class Named_parameterContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public Named_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNamed_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNamed_parameter(this);
		}
	}

	public final Named_parameterContext named_parameter() throws RecognitionException {
		Named_parameterContext _localctx = new Named_parameterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_named_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			name();
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(377);
				match(COLON);
				setState(378);
				test();
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

	public static class Simple_stmtContext extends ParserRuleContext {
		public List<Small_stmtContext> small_stmt() {
			return getRuleContexts(Small_stmtContext.class);
		}
		public Small_stmtContext small_stmt(int i) {
			return getRuleContext(Small_stmtContext.class,i);
		}
		public TerminalNode LINE_BREAK() { return getToken(PythonParser.LINE_BREAK, 0); }
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<TerminalNode> SEMI_COLON() { return getTokens(PythonParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(PythonParser.SEMI_COLON, i);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSimple_stmt(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			small_stmt();
			setState(386);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(382);
					match(SEMI_COLON);
					setState(383);
					small_stmt();
					}
					} 
				}
				setState(388);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(389);
				match(SEMI_COLON);
				}
			}

			setState(392);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==LINE_BREAK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Small_stmtContext extends ParserRuleContext {
		public Small_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_small_stmt; }
	 
		public Small_stmtContext() { }
		public void copyFrom(Small_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Assert_stmtContext extends Small_stmtContext {
		public TerminalNode ASSERT() { return getToken(PythonParser.ASSERT, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Assert_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssert_stmt(this);
		}
	}
	public static class Nonlocal_stmtContext extends Small_stmtContext {
		public TerminalNode NONLOCAL() { return getToken(PythonParser.NONLOCAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Nonlocal_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNonlocal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNonlocal_stmt(this);
		}
	}
	public static class Pass_stmtContext extends Small_stmtContext {
		public TerminalNode PASS() { return getToken(PythonParser.PASS, 0); }
		public Pass_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPass_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPass_stmt(this);
		}
	}
	public static class Import_stmtContext extends Small_stmtContext {
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Dotted_as_namesContext dotted_as_names() {
			return getRuleContext(Dotted_as_namesContext.class,0);
		}
		public Import_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_stmt(this);
		}
	}
	public static class Expr_stmtContext extends Small_stmtContext {
		public Testlist_star_exprContext testlist_star_expr() {
			return getRuleContext(Testlist_star_exprContext.class,0);
		}
		public Assign_partContext assign_part() {
			return getRuleContext(Assign_partContext.class,0);
		}
		public Expr_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpr_stmt(this);
		}
	}
	public static class Raise_stmtContext extends Small_stmtContext {
		public TerminalNode RAISE() { return getToken(PythonParser.RAISE, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Raise_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRaise_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRaise_stmt(this);
		}
	}
	public static class Yield_stmtContext extends Small_stmtContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Yield_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_stmt(this);
		}
	}
	public static class From_stmtContext extends Small_stmtContext {
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public Import_as_namesContext import_as_names() {
			return getRuleContext(Import_as_namesContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public List<TerminalNode> ELLIPSIS() { return getTokens(PythonParser.ELLIPSIS); }
		public TerminalNode ELLIPSIS(int i) {
			return getToken(PythonParser.ELLIPSIS, i);
		}
		public From_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFrom_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFrom_stmt(this);
		}
	}
	public static class Global_stmtContext extends Small_stmtContext {
		public TerminalNode GLOBAL() { return getToken(PythonParser.GLOBAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Global_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGlobal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGlobal_stmt(this);
		}
	}
	public static class Continue_stmtContext extends Small_stmtContext {
		public TerminalNode CONTINUE() { return getToken(PythonParser.CONTINUE, 0); }
		public Continue_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterContinue_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitContinue_stmt(this);
		}
	}
	public static class Exec_stmtContext extends Small_stmtContext {
		public TerminalNode EXEC() { return getToken(PythonParser.EXEC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Exec_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExec_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExec_stmt(this);
		}
	}
	public static class Break_stmtContext extends Small_stmtContext {
		public TerminalNode BREAK() { return getToken(PythonParser.BREAK, 0); }
		public Break_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBreak_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBreak_stmt(this);
		}
	}
	public static class Del_stmtContext extends Small_stmtContext {
		public TerminalNode DEL() { return getToken(PythonParser.DEL, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public Del_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_stmt(this);
		}
	}
	public static class Print_stmtContext extends Small_stmtContext {
		public TerminalNode PRINT() { return getToken(PythonParser.PRINT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(PythonParser.RIGHT_SHIFT, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Print_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPrint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPrint_stmt(this);
		}
	}
	public static class Return_stmtContext extends Small_stmtContext {
		public TerminalNode RETURN() { return getToken(PythonParser.RETURN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Return_stmtContext(Small_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitReturn_stmt(this);
		}
	}

	public final Small_stmtContext small_stmt() throws RecognitionException {
		Small_stmtContext _localctx = new Small_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_small_stmt);
		int _la;
		try {
			int _alt;
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new Expr_stmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				testlist_star_expr();
				setState(396);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(395);
					assign_part();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new Print_stmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				if (!(CheckVersion(2))) throw new FailedPredicateException(this, "CheckVersion(2)");
				setState(399);
				match(PRINT);
				setState(422);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NONE:
				case LAMBDA:
				case NOT:
				case AWAIT:
				case PRINT:
				case EXEC:
				case TRUE:
				case FALSE:
				case ELLIPSIS:
				case REVERSE_QUOTE:
				case ADD:
				case MINUS:
				case NOT_OP:
				case STRING:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case IMAG_NUMBER:
				case FLOAT_NUMBER:
				case OPEN_PAREN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NAME:
					{
					{
					setState(400);
					test();
					setState(405);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(401);
							match(COMMA);
							setState(402);
							test();
							}
							} 
						}
						setState(407);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					}
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(408);
						match(COMMA);
						}
					}

					}
					}
					break;
				case RIGHT_SHIFT:
					{
					setState(411);
					match(RIGHT_SHIFT);
					setState(412);
					test();
					{
					setState(415); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(413);
							match(COMMA);
							setState(414);
							test();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(417); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(419);
						match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				SetVersion(2);
				}
				break;
			case 3:
				_localctx = new Del_stmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				match(DEL);
				setState(427);
				exprlist();
				}
				break;
			case 4:
				_localctx = new Pass_stmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(428);
				match(PASS);
				}
				break;
			case 5:
				_localctx = new Break_stmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(429);
				match(BREAK);
				}
				break;
			case 6:
				_localctx = new Continue_stmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(430);
				match(CONTINUE);
				}
				break;
			case 7:
				_localctx = new Return_stmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(431);
				match(RETURN);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(432);
					testlist();
					}
				}

				}
				break;
			case 8:
				_localctx = new Raise_stmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(435);
				match(RAISE);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(436);
					test();
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(437);
						match(COMMA);
						setState(438);
						test();
						setState(441);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(439);
							match(COMMA);
							setState(440);
							test();
							}
						}

						}
					}

					}
				}

				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(447);
					match(FROM);
					setState(448);
					test();
					}
				}

				}
				break;
			case 9:
				_localctx = new Yield_stmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(451);
				yield_expr();
				}
				break;
			case 10:
				_localctx = new Import_stmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(452);
				match(IMPORT);
				setState(453);
				dotted_as_names();
				}
				break;
			case 11:
				_localctx = new From_stmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(454);
				match(FROM);
				setState(467);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(458);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==DOT || _la==ELLIPSIS) {
						{
						{
						setState(455);
						_la = _input.LA(1);
						if ( !(_la==DOT || _la==ELLIPSIS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(460);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(461);
					dotted_name(0);
					}
					break;
				case 2:
					{
					setState(463); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(462);
						_la = _input.LA(1);
						if ( !(_la==DOT || _la==ELLIPSIS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(465); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DOT || _la==ELLIPSIS );
					}
					break;
				}
				setState(469);
				match(IMPORT);
				setState(476);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(470);
					match(STAR);
					}
					break;
				case OPEN_PAREN:
					{
					setState(471);
					match(OPEN_PAREN);
					setState(472);
					import_as_names();
					setState(473);
					match(CLOSE_PAREN);
					}
					break;
				case TRUE:
				case FALSE:
				case NAME:
					{
					setState(475);
					import_as_names();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 12:
				_localctx = new Global_stmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(478);
				match(GLOBAL);
				setState(479);
				name();
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(480);
					match(COMMA);
					setState(481);
					name();
					}
					}
					setState(486);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 13:
				_localctx = new Exec_stmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(487);
				if (!(CheckVersion(2))) throw new FailedPredicateException(this, "CheckVersion(2)");
				setState(488);
				match(EXEC);
				setState(489);
				expr(0);
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IN) {
					{
					setState(490);
					match(IN);
					setState(491);
					test();
					setState(494);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(492);
						match(COMMA);
						setState(493);
						test();
						}
					}

					}
				}

				SetVersion(2);
				}
				break;
			case 14:
				_localctx = new Assert_stmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(500);
				match(ASSERT);
				setState(501);
				test();
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(502);
					match(COMMA);
					setState(503);
					test();
					}
				}

				}
				break;
			case 15:
				_localctx = new Nonlocal_stmtContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(506);
				if (!(CheckVersion(3))) throw new FailedPredicateException(this, "CheckVersion(3)");
				setState(507);
				match(NONLOCAL);
				setState(508);
				name();
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(509);
					match(COMMA);
					setState(510);
					name();
					}
					}
					setState(515);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				SetVersion(3);
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

	public static class Testlist_star_exprContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Testlist_star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_star_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTestlist_star_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTestlist_star_expr(this);
		}
	}

	public final Testlist_star_exprContext testlist_star_expr() throws RecognitionException {
		Testlist_star_exprContext _localctx = new Testlist_star_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_testlist_star_expr);
		try {
			int _alt;
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(526); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(522);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case NONE:
						case LAMBDA:
						case NOT:
						case AWAIT:
						case PRINT:
						case EXEC:
						case TRUE:
						case FALSE:
						case ELLIPSIS:
						case REVERSE_QUOTE:
						case ADD:
						case MINUS:
						case NOT_OP:
						case STRING:
						case DECIMAL_INTEGER:
						case OCT_INTEGER:
						case HEX_INTEGER:
						case BIN_INTEGER:
						case IMAG_NUMBER:
						case FLOAT_NUMBER:
						case OPEN_PAREN:
						case OPEN_BRACE:
						case OPEN_BRACKET:
						case NAME:
							{
							setState(520);
							test();
							}
							break;
						case STAR:
							{
							setState(521);
							star_expr();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(524);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(528); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(532);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(530);
					test();
					}
					break;
				case 2:
					{
					setState(531);
					star_expr();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				testlist();
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

	public static class Star_exprContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_expr(this);
		}
	}

	public final Star_exprContext star_expr() throws RecognitionException {
		Star_exprContext _localctx = new Star_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_star_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(STAR);
			setState(538);
			expr(0);
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

	public static class Assign_partContext extends ParserRuleContext {
		public Token op;
		public List<TerminalNode> ASSIGN() { return getTokens(PythonParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(PythonParser.ASSIGN, i);
		}
		public List<Testlist_star_exprContext> testlist_star_expr() {
			return getRuleContexts(Testlist_star_exprContext.class);
		}
		public Testlist_star_exprContext testlist_star_expr(int i) {
			return getRuleContext(Testlist_star_exprContext.class,i);
		}
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public TerminalNode ADD_ASSIGN() { return getToken(PythonParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(PythonParser.SUB_ASSIGN, 0); }
		public TerminalNode MULT_ASSIGN() { return getToken(PythonParser.MULT_ASSIGN, 0); }
		public TerminalNode AT_ASSIGN() { return getToken(PythonParser.AT_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(PythonParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(PythonParser.MOD_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(PythonParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(PythonParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(PythonParser.XOR_ASSIGN, 0); }
		public TerminalNode LEFT_SHIFT_ASSIGN() { return getToken(PythonParser.LEFT_SHIFT_ASSIGN, 0); }
		public TerminalNode RIGHT_SHIFT_ASSIGN() { return getToken(PythonParser.RIGHT_SHIFT_ASSIGN, 0); }
		public TerminalNode POWER_ASSIGN() { return getToken(PythonParser.POWER_ASSIGN, 0); }
		public TerminalNode IDIV_ASSIGN() { return getToken(PythonParser.IDIV_ASSIGN, 0); }
		public Assign_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssign_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssign_part(this);
		}
	}

	public final Assign_partContext assign_part() throws RecognitionException {
		Assign_partContext _localctx = new Assign_partContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assign_part);
		int _la;
		try {
			int _alt;
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(ASSIGN);
				setState(554);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NONE:
				case LAMBDA:
				case NOT:
				case AWAIT:
				case PRINT:
				case EXEC:
				case TRUE:
				case FALSE:
				case ELLIPSIS:
				case REVERSE_QUOTE:
				case STAR:
				case ADD:
				case MINUS:
				case NOT_OP:
				case STRING:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case IMAG_NUMBER:
				case FLOAT_NUMBER:
				case OPEN_PAREN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NAME:
					{
					setState(541);
					testlist_star_expr();
					setState(546);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(542);
							match(ASSIGN);
							setState(543);
							testlist_star_expr();
							}
							} 
						}
						setState(548);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
					}
					setState(551);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASSIGN) {
						{
						setState(549);
						match(ASSIGN);
						setState(550);
						yield_expr();
						}
					}

					}
					break;
				case YIELD:
					{
					setState(553);
					yield_expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(556);
				if (!(CheckVersion(3))) throw new FailedPredicateException(this, "CheckVersion(3)");
				setState(557);
				match(COLON);
				setState(558);
				test();
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(559);
					match(ASSIGN);
					setState(560);
					testlist();
					}
				}

				SetVersion(3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(565);
				((Assign_partContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ADD_ASSIGN - 70)) | (1L << (SUB_ASSIGN - 70)) | (1L << (MULT_ASSIGN - 70)) | (1L << (AT_ASSIGN - 70)) | (1L << (DIV_ASSIGN - 70)) | (1L << (MOD_ASSIGN - 70)) | (1L << (AND_ASSIGN - 70)) | (1L << (OR_ASSIGN - 70)) | (1L << (XOR_ASSIGN - 70)) | (1L << (LEFT_SHIFT_ASSIGN - 70)) | (1L << (RIGHT_SHIFT_ASSIGN - 70)) | (1L << (POWER_ASSIGN - 70)) | (1L << (IDIV_ASSIGN - 70)))) != 0)) ) {
					((Assign_partContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(568);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(566);
					yield_expr();
					}
					break;
				case NONE:
				case LAMBDA:
				case NOT:
				case AWAIT:
				case PRINT:
				case EXEC:
				case TRUE:
				case FALSE:
				case ELLIPSIS:
				case REVERSE_QUOTE:
				case ADD:
				case MINUS:
				case NOT_OP:
				case STRING:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case IMAG_NUMBER:
				case FLOAT_NUMBER:
				case OPEN_PAREN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NAME:
					{
					setState(567);
					testlist();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class ExprlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExprlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExprlist(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exprlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			expr(0);
			setState(577);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(573);
					match(COMMA);
					setState(574);
					expr(0);
					}
					} 
				}
				setState(579);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(580);
				match(COMMA);
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

	public static class Import_as_namesContext extends ParserRuleContext {
		public List<Import_as_nameContext> import_as_name() {
			return getRuleContexts(Import_as_nameContext.class);
		}
		public Import_as_nameContext import_as_name(int i) {
			return getRuleContext(Import_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Import_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_as_names(this);
		}
	}

	public final Import_as_namesContext import_as_names() throws RecognitionException {
		Import_as_namesContext _localctx = new Import_as_namesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_import_as_names);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			import_as_name();
			setState(588);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(584);
					match(COMMA);
					setState(585);
					import_as_name();
					}
					} 
				}
				setState(590);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			}
			setState(592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(591);
				match(COMMA);
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

	public static class Import_as_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Import_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_as_name(this);
		}
	}

	public final Import_as_nameContext import_as_name() throws RecognitionException {
		Import_as_nameContext _localctx = new Import_as_nameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_import_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			name();
			setState(597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(595);
				match(AS);
				setState(596);
				name();
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

	public static class Dotted_as_namesContext extends ParserRuleContext {
		public List<Dotted_as_nameContext> dotted_as_name() {
			return getRuleContexts(Dotted_as_nameContext.class);
		}
		public Dotted_as_nameContext dotted_as_name(int i) {
			return getRuleContext(Dotted_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Dotted_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_names(this);
		}
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			dotted_as_name();
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(600);
				match(COMMA);
				setState(601);
				dotted_as_name();
				}
				}
				setState(606);
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

	public static class Dotted_as_nameContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_name(this);
		}
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			dotted_name(0);
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(608);
				match(AS);
				setState(609);
				name();
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

	public static class TestContext extends ParserRuleContext {
		public List<Logical_testContext> logical_test() {
			return getRuleContexts(Logical_testContext.class);
		}
		public Logical_testContext logical_test(int i) {
			return getRuleContext(Logical_testContext.class,i);
		}
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode LAMBDA() { return getToken(PythonParser.LAMBDA, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public VarargslistContext varargslist() {
			return getRuleContext(VarargslistContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTest(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_test);
		int _la;
		try {
			setState(626);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case NOT:
			case AWAIT:
			case PRINT:
			case EXEC:
			case TRUE:
			case FALSE:
			case ELLIPSIS:
			case REVERSE_QUOTE:
			case ADD:
			case MINUS:
			case NOT_OP:
			case STRING:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
			case OPEN_PAREN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				logical_test(0);
				setState(618);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(613);
					match(IF);
					setState(614);
					logical_test(0);
					setState(615);
					match(ELSE);
					setState(616);
					test();
					}
					break;
				}
				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(620);
				match(LAMBDA);
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (TRUE - 39)) | (1L << (FALSE - 39)) | (1L << (STAR - 39)) | (1L << (POWER - 39)) | (1L << (NAME - 39)))) != 0)) {
					{
					setState(621);
					varargslist();
					}
				}

				setState(624);
				match(COLON);
				setState(625);
				test();
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

	public static class VarargslistContext extends ParserRuleContext {
		public VarargsContext varargs() {
			return getRuleContext(VarargsContext.class,0);
		}
		public VarkwargsContext varkwargs() {
			return getRuleContext(VarkwargsContext.class,0);
		}
		public List<Vardef_parametersContext> vardef_parameters() {
			return getRuleContexts(Vardef_parametersContext.class);
		}
		public Vardef_parametersContext vardef_parameters(int i) {
			return getRuleContext(Vardef_parametersContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public VarargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varargslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterVarargslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitVarargslist(this);
		}
	}

	public final VarargslistContext varargslist() throws RecognitionException {
		VarargslistContext _localctx = new VarargslistContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_varargslist);
		int _la;
		try {
			setState(652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(628);
					vardef_parameters();
					setState(629);
					match(COMMA);
					}
					break;
				}
				setState(643);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(633);
					varargs();
					setState(636);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						setState(634);
						match(COMMA);
						setState(635);
						vardef_parameters();
						}
						break;
					}
					setState(640);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
					case 1:
						{
						setState(638);
						match(COMMA);
						setState(639);
						varkwargs();
						}
						break;
					}
					}
					break;
				case POWER:
					{
					setState(642);
					varkwargs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(645);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(648);
				vardef_parameters();
				setState(650);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(649);
					match(COMMA);
					}
				}

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

	public static class Vardef_parametersContext extends ParserRuleContext {
		public List<Vardef_parameterContext> vardef_parameter() {
			return getRuleContexts(Vardef_parameterContext.class);
		}
		public Vardef_parameterContext vardef_parameter(int i) {
			return getRuleContext(Vardef_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Vardef_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterVardef_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitVardef_parameters(this);
		}
	}

	public final Vardef_parametersContext vardef_parameters() throws RecognitionException {
		Vardef_parametersContext _localctx = new Vardef_parametersContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vardef_parameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			vardef_parameter();
			setState(659);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(655);
					match(COMMA);
					setState(656);
					vardef_parameter();
					}
					} 
				}
				setState(661);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
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

	public static class Vardef_parameterContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PythonParser.ASSIGN, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Vardef_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterVardef_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitVardef_parameter(this);
		}
	}

	public final Vardef_parameterContext vardef_parameter() throws RecognitionException {
		Vardef_parameterContext _localctx = new Vardef_parameterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_vardef_parameter);
		int _la;
		try {
			setState(668);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(662);
				name();
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(663);
					match(ASSIGN);
					setState(664);
					test();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				match(STAR);
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

	public static class VarargsContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public VarargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterVarargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitVarargs(this);
		}
	}

	public final VarargsContext varargs() throws RecognitionException {
		VarargsContext _localctx = new VarargsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_varargs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			match(STAR);
			setState(671);
			name();
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

	public static class VarkwargsContext extends ParserRuleContext {
		public TerminalNode POWER() { return getToken(PythonParser.POWER, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public VarkwargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varkwargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterVarkwargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitVarkwargs(this);
		}
	}

	public final VarkwargsContext varkwargs() throws RecognitionException {
		VarkwargsContext _localctx = new VarkwargsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_varkwargs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			match(POWER);
			setState(674);
			name();
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

	public static class Logical_testContext extends ParserRuleContext {
		public Token op;
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public List<Logical_testContext> logical_test() {
			return getRuleContexts(Logical_testContext.class);
		}
		public Logical_testContext logical_test(int i) {
			return getRuleContext(Logical_testContext.class,i);
		}
		public TerminalNode AND() { return getToken(PythonParser.AND, 0); }
		public TerminalNode OR() { return getToken(PythonParser.OR, 0); }
		public Logical_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLogical_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLogical_test(this);
		}
	}

	public final Logical_testContext logical_test() throws RecognitionException {
		return logical_test(0);
	}

	private Logical_testContext logical_test(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_testContext _localctx = new Logical_testContext(_ctx, _parentState);
		Logical_testContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_logical_test, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case AWAIT:
			case PRINT:
			case EXEC:
			case TRUE:
			case FALSE:
			case ELLIPSIS:
			case REVERSE_QUOTE:
			case ADD:
			case MINUS:
			case NOT_OP:
			case STRING:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
			case OPEN_PAREN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case NAME:
				{
				setState(677);
				comparison(0);
				}
				break;
			case NOT:
				{
				setState(678);
				match(NOT);
				setState(679);
				logical_test(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(690);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(688);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
					case 1:
						{
						_localctx = new Logical_testContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logical_test);
						setState(682);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(683);
						((Logical_testContext)_localctx).op = match(AND);
						setState(684);
						logical_test(3);
						}
						break;
					case 2:
						{
						_localctx = new Logical_testContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logical_test);
						setState(685);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(686);
						((Logical_testContext)_localctx).op = match(OR);
						setState(687);
						logical_test(2);
						}
						break;
					}
					} 
				}
				setState(692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
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

	public static class ComparisonContext extends ParserRuleContext {
		public Token optional;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(PythonParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(PythonParser.GREATER_THAN, 0); }
		public TerminalNode EQUALS() { return getToken(PythonParser.EQUALS, 0); }
		public TerminalNode GT_EQ() { return getToken(PythonParser.GT_EQ, 0); }
		public TerminalNode LT_EQ() { return getToken(PythonParser.LT_EQ, 0); }
		public TerminalNode NOT_EQ_1() { return getToken(PythonParser.NOT_EQ_1, 0); }
		public TerminalNode NOT_EQ_2() { return getToken(PythonParser.NOT_EQ_2, 0); }
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public TerminalNode IS() { return getToken(PythonParser.IS, 0); }
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		return comparison(0);
	}

	private ComparisonContext comparison(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ComparisonContext _localctx = new ComparisonContext(_ctx, _parentState);
		ComparisonContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_comparison, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(694);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(717);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComparisonContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_comparison);
					setState(696);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(712);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LESS_THAN:
						{
						setState(697);
						match(LESS_THAN);
						}
						break;
					case GREATER_THAN:
						{
						setState(698);
						match(GREATER_THAN);
						}
						break;
					case EQUALS:
						{
						setState(699);
						match(EQUALS);
						}
						break;
					case GT_EQ:
						{
						setState(700);
						match(GT_EQ);
						}
						break;
					case LT_EQ:
						{
						setState(701);
						match(LT_EQ);
						}
						break;
					case NOT_EQ_1:
						{
						setState(702);
						match(NOT_EQ_1);
						}
						break;
					case NOT_EQ_2:
						{
						setState(703);
						match(NOT_EQ_2);
						}
						break;
					case IN:
					case NOT:
						{
						setState(705);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(704);
							((ComparisonContext)_localctx).optional = match(NOT);
							}
						}

						setState(707);
						match(IN);
						}
						break;
					case IS:
						{
						setState(708);
						match(IS);
						setState(710);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(709);
							((ComparisonContext)_localctx).optional = match(NOT);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(714);
					comparison(3);
					}
					} 
				}
				setState(719);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Method_chainContext method_chain() {
			return getRuleContext(Method_chainContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(PythonParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public TerminalNode NOT_OP() { return getToken(PythonParser.NOT_OP, 0); }
		public TerminalNode POWER() { return getToken(PythonParser.POWER, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(PythonParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PythonParser.MOD, 0); }
		public TerminalNode IDIV() { return getToken(PythonParser.IDIV, 0); }
		public TerminalNode AT() { return getToken(PythonParser.AT, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(PythonParser.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(PythonParser.RIGHT_SHIFT, 0); }
		public TerminalNode AND_OP() { return getToken(PythonParser.AND_OP, 0); }
		public TerminalNode XOR() { return getToken(PythonParser.XOR, 0); }
		public TerminalNode OR_OP() { return getToken(PythonParser.OR_OP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(721);
				atom();
				}
				break;
			case 2:
				{
				setState(722);
				method_chain();
				}
				break;
			case 3:
				{
				setState(723);
				function_call();
				}
				break;
			case 4:
				{
				setState(724);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(725);
				expr(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(751);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(749);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(728);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(729);
						((ExprContext)_localctx).op = match(POWER);
						setState(730);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(731);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(732);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (STAR - 44)) | (1L << (DIV - 44)) | (1L << (MOD - 44)) | (1L << (IDIV - 44)) | (1L << (AT - 44)))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(733);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(734);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(735);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MINUS) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(736);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(737);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(738);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(739);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(740);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(741);
						((ExprContext)_localctx).op = match(AND_OP);
						setState(742);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(743);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(744);
						((ExprContext)_localctx).op = match(XOR);
						setState(745);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(746);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(747);
						((ExprContext)_localctx).op = match(OR_OP);
						setState(748);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(753);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
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

	public static class Method_chainContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TrailerContext trailer() {
			return getRuleContext(TrailerContext.class,0);
		}
		public TerminalNode AWAIT() { return getToken(PythonParser.AWAIT, 0); }
		public Method_chainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMethod_chain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMethod_chain(this);
		}
	}

	public final Method_chainContext method_chain() throws RecognitionException {
		Method_chainContext _localctx = new Method_chainContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_method_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AWAIT) {
				{
				setState(754);
				match(AWAIT);
				}
			}

			setState(757);
			atom();
			setState(758);
			trailer();
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

	public static class Function_callContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode AWAIT() { return getToken(PythonParser.AWAIT, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunction_call(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AWAIT) {
				{
				setState(760);
				match(AWAIT);
				}
			}

			setState(763);
			atom();
			setState(764);
			arguments();
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Testlist_compContext testlist_comp() {
			return getRuleContext(Testlist_compContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(PythonParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(PythonParser.CLOSE_BRACKET, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(PythonParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(PythonParser.CLOSE_BRACE, 0); }
		public DictorsetmakerContext dictorsetmaker() {
			return getRuleContext(DictorsetmakerContext.class,0);
		}
		public List<TerminalNode> REVERSE_QUOTE() { return getTokens(PythonParser.REVERSE_QUOTE); }
		public TerminalNode REVERSE_QUOTE(int i) {
			return getToken(PythonParser.REVERSE_QUOTE, i);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode ELLIPSIS() { return getToken(PythonParser.ELLIPSIS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(PythonParser.PRINT, 0); }
		public TerminalNode EXEC() { return getToken(PythonParser.EXEC, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_atom);
		int _la;
		try {
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(766);
				match(OPEN_PAREN);
				setState(769);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(767);
					yield_expr();
					}
					break;
				case NONE:
				case LAMBDA:
				case NOT:
				case AWAIT:
				case PRINT:
				case EXEC:
				case TRUE:
				case FALSE:
				case ELLIPSIS:
				case REVERSE_QUOTE:
				case STAR:
				case ADD:
				case MINUS:
				case NOT_OP:
				case STRING:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case IMAG_NUMBER:
				case FLOAT_NUMBER:
				case OPEN_PAREN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NAME:
					{
					setState(768);
					testlist_comp();
					}
					break;
				case CLOSE_PAREN:
					break;
				default:
					break;
				}
				setState(771);
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(772);
				match(OPEN_BRACKET);
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << STAR) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(773);
					testlist_comp();
					}
				}

				setState(776);
				match(CLOSE_BRACKET);
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(777);
				match(OPEN_BRACE);
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << STAR) | (1L << POWER) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(778);
					dictorsetmaker();
					}
				}

				setState(781);
				match(CLOSE_BRACE);
				}
				break;
			case REVERSE_QUOTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(782);
				match(REVERSE_QUOTE);
				setState(783);
				testlist();
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(784);
					match(COMMA);
					}
				}

				setState(787);
				match(REVERSE_QUOTE);
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 5);
				{
				setState(789);
				match(ELLIPSIS);
				}
				break;
			case TRUE:
			case FALSE:
			case NAME:
				enterOuterAlt(_localctx, 6);
				{
				setState(790);
				name();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(791);
				match(PRINT);
				}
				break;
			case EXEC:
				enterOuterAlt(_localctx, 8);
				{
				setState(792);
				match(EXEC);
				}
				break;
			case MINUS:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 9);
				{
				setState(794);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(793);
					match(MINUS);
					}
				}

				setState(796);
				number();
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 10);
				{
				setState(797);
				match(NONE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 11);
				{
				setState(798);
				string_literal();
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

	public static class String_literalContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(PythonParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PythonParser.STRING, i);
		}
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_string_literal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(802); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(801);
					match(STRING);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(804); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DictorsetmakerContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(PythonParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PythonParser.COLON, i);
		}
		public List<TerminalNode> POWER() { return getTokens(PythonParser.POWER); }
		public TerminalNode POWER(int i) {
			return getToken(PythonParser.POWER, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public Testlist_compContext testlist_comp() {
			return getRuleContext(Testlist_compContext.class,0);
		}
		public DictorsetmakerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictorsetmaker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDictorsetmaker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDictorsetmaker(this);
		}
	}

	public final DictorsetmakerContext dictorsetmaker() throws RecognitionException {
		DictorsetmakerContext _localctx = new DictorsetmakerContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_dictorsetmaker);
		int _la;
		try {
			int _alt;
			setState(837);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NONE:
				case LAMBDA:
				case NOT:
				case AWAIT:
				case PRINT:
				case EXEC:
				case TRUE:
				case FALSE:
				case ELLIPSIS:
				case REVERSE_QUOTE:
				case ADD:
				case MINUS:
				case NOT_OP:
				case STRING:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case IMAG_NUMBER:
				case FLOAT_NUMBER:
				case OPEN_PAREN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NAME:
					{
					setState(806);
					test();
					setState(807);
					match(COLON);
					setState(808);
					test();
					}
					break;
				case POWER:
					{
					setState(810);
					match(POWER);
					setState(811);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(825);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(814);
						match(COMMA);
						setState(821);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case NONE:
						case LAMBDA:
						case NOT:
						case AWAIT:
						case PRINT:
						case EXEC:
						case TRUE:
						case FALSE:
						case ELLIPSIS:
						case REVERSE_QUOTE:
						case ADD:
						case MINUS:
						case NOT_OP:
						case STRING:
						case DECIMAL_INTEGER:
						case OCT_INTEGER:
						case HEX_INTEGER:
						case BIN_INTEGER:
						case IMAG_NUMBER:
						case FLOAT_NUMBER:
						case OPEN_PAREN:
						case OPEN_BRACE:
						case OPEN_BRACKET:
						case NAME:
							{
							setState(815);
							test();
							setState(816);
							match(COLON);
							setState(817);
							test();
							}
							break;
						case POWER:
							{
							setState(819);
							match(POWER);
							setState(820);
							expr(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(827);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				}
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(828);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(831);
				test();
				setState(832);
				match(COLON);
				setState(833);
				test();
				setState(834);
				comp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(836);
				testlist_comp();
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

	public static class Testlist_compContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Testlist_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTestlist_comp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTestlist_comp(this);
		}
	}

	public final Testlist_compContext testlist_comp() throws RecognitionException {
		Testlist_compContext _localctx = new Testlist_compContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_testlist_comp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case LAMBDA:
			case NOT:
			case AWAIT:
			case PRINT:
			case EXEC:
			case TRUE:
			case FALSE:
			case ELLIPSIS:
			case REVERSE_QUOTE:
			case ADD:
			case MINUS:
			case NOT_OP:
			case STRING:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
			case OPEN_PAREN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case NAME:
				{
				setState(839);
				test();
				}
				break;
			case STAR:
				{
				setState(840);
				star_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(857);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(843);
				comp_for();
				}
				break;
			case COMMA:
			case CLOSE_PAREN:
			case CLOSE_BRACE:
			case CLOSE_BRACKET:
				{
				setState(851);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(844);
						match(COMMA);
						setState(847);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case NONE:
						case LAMBDA:
						case NOT:
						case AWAIT:
						case PRINT:
						case EXEC:
						case TRUE:
						case FALSE:
						case ELLIPSIS:
						case REVERSE_QUOTE:
						case ADD:
						case MINUS:
						case NOT_OP:
						case STRING:
						case DECIMAL_INTEGER:
						case OCT_INTEGER:
						case HEX_INTEGER:
						case BIN_INTEGER:
						case IMAG_NUMBER:
						case FLOAT_NUMBER:
						case OPEN_PAREN:
						case OPEN_BRACE:
						case OPEN_BRACKET:
						case NAME:
							{
							setState(845);
							test();
							}
							break;
						case STAR:
							{
							setState(846);
							star_expr();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(853);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
				}
				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(854);
					match(COMMA);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TestlistContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TestlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTestlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTestlist(this);
		}
	}

	public final TestlistContext testlist() throws RecognitionException {
		TestlistContext _localctx = new TestlistContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_testlist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			test();
			setState(864);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(860);
					match(COMMA);
					setState(861);
					test();
					}
					} 
				}
				setState(866);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			setState(868);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				setState(867);
				match(COMMA);
				}
				break;
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

	public static class Dotted_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public Dotted_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_name(this);
		}
	}

	public final Dotted_nameContext dotted_name() throws RecognitionException {
		return dotted_name(0);
	}

	private Dotted_nameContext dotted_name(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Dotted_nameContext _localctx = new Dotted_nameContext(_ctx, _parentState);
		Dotted_nameContext _prevctx = _localctx;
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_dotted_name, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(871);
			name();
			}
			_ctx.stop = _input.LT(-1);
			setState(878);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Dotted_nameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dotted_name);
					setState(873);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(874);
					match(DOT);
					setState(875);
					name();
					}
					} 
				}
				setState(880);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
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

	public static class NameContext extends ParserRuleContext {
		public Name_literalContext name_literal() {
			return getRuleContext(Name_literalContext.class,0);
		}
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_name);
		try {
			setState(883);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				name_literal();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(882);
				true_false();
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

	public static class Name_literalContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PythonParser.NAME, 0); }
		public Name_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName_literal(this);
		}
	}

	public final Name_literalContext name_literal() throws RecognitionException {
		Name_literalContext _localctx = new Name_literalContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_name_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			match(NAME);
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

	public static class True_falseContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTrue_false(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_true_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode IMAG_NUMBER() { return getToken(PythonParser.IMAG_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(PythonParser.FLOAT_NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_number);
		try {
			setState(892);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				integer();
				}
				break;
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				match(IMAG_NUMBER);
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(891);
				match(FLOAT_NUMBER);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(PythonParser.DECIMAL_INTEGER, 0); }
		public TerminalNode OCT_INTEGER() { return getToken(PythonParser.OCT_INTEGER, 0); }
		public TerminalNode HEX_INTEGER() { return getToken(PythonParser.HEX_INTEGER, 0); }
		public TerminalNode BIN_INTEGER() { return getToken(PythonParser.BIN_INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DECIMAL_INTEGER - 84)) | (1L << (OCT_INTEGER - 84)) | (1L << (HEX_INTEGER - 84)) | (1L << (BIN_INTEGER - 84)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Yield_exprContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(PythonParser.YIELD, 0); }
		public Yield_argContext yield_arg() {
			return getRuleContext(Yield_argContext.class,0);
		}
		public Yield_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_expr(this);
		}
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			match(YIELD);
			setState(898);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FROM) | (1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
				{
				setState(897);
				yield_arg();
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

	public static class Yield_argContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Yield_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_arg(this);
		}
	}

	public final Yield_argContext yield_arg() throws RecognitionException {
		Yield_argContext _localctx = new Yield_argContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_yield_arg);
		try {
			setState(903);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(900);
				match(FROM);
				setState(901);
				test();
				}
				break;
			case NONE:
			case LAMBDA:
			case NOT:
			case AWAIT:
			case PRINT:
			case EXEC:
			case TRUE:
			case FALSE:
			case ELLIPSIS:
			case REVERSE_QUOTE:
			case ADD:
			case MINUS:
			case NOT_OP:
			case STRING:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
			case OPEN_PAREN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(902);
				testlist();
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

	public static class TrailerContext extends ParserRuleContext {
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Attribute_accessContext attribute_access() {
			return getRuleContext(Attribute_accessContext.class,0);
		}
		public TrailerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTrailer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTrailer(this);
		}
	}

	public final TrailerContext trailer() throws RecognitionException {
		TrailerContext _localctx = new TrailerContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_trailer);
		try {
			setState(907);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(905);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(906);
				attribute_access();
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

	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMethod_call(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_method_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			match(DOT);
			setState(910);
			name();
			setState(911);
			arguments();
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

	public static class Attribute_accessContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Attribute_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAttribute_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAttribute_access(this);
		}
	}

	public final Attribute_accessContext attribute_access() throws RecognitionException {
		Attribute_accessContext _localctx = new Attribute_accessContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_attribute_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			match(DOT);
			setState(914);
			name();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(PythonParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(PythonParser.CLOSE_PAREN, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(PythonParser.OPEN_BRACKET, 0); }
		public SubscriptlistContext subscriptlist() {
			return getRuleContext(SubscriptlistContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(PythonParser.CLOSE_BRACKET, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_arguments);
		int _la;
		try {
			setState(925);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(916);
				match(OPEN_PAREN);
				setState(918);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << STAR) | (1L << POWER) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(917);
					arglist();
					}
				}

				setState(920);
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(921);
				match(OPEN_BRACKET);
				setState(922);
				subscriptlist();
				setState(923);
				match(CLOSE_BRACKET);
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

	public static class ArglistContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArglist(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_arglist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(927);
			argument();
			setState(932);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(928);
					match(COMMA);
					setState(929);
					argument();
					}
					} 
				}
				setState(934);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			}
			setState(936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(935);
				match(COMMA);
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

	public static class ArgumentContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PythonParser.ASSIGN, 0); }
		public TerminalNode POWER() { return getToken(PythonParser.POWER, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_argument);
		int _la;
		try {
			setState(946);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case LAMBDA:
			case NOT:
			case AWAIT:
			case PRINT:
			case EXEC:
			case TRUE:
			case FALSE:
			case ELLIPSIS:
			case REVERSE_QUOTE:
			case ADD:
			case MINUS:
			case NOT_OP:
			case STRING:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case IMAG_NUMBER:
			case FLOAT_NUMBER:
			case OPEN_PAREN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(938);
				test();
				setState(942);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(939);
					comp_for();
					}
					break;
				case ASSIGN:
					{
					setState(940);
					match(ASSIGN);
					setState(941);
					test();
					}
					break;
				case COMMA:
				case CLOSE_PAREN:
					break;
				default:
					break;
				}
				}
				break;
			case STAR:
			case POWER:
				enterOuterAlt(_localctx, 2);
				{
				setState(944);
				_la = _input.LA(1);
				if ( !(_la==STAR || _la==POWER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(945);
				test();
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

	public static class SubscriptlistContext extends ParserRuleContext {
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public SubscriptlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSubscriptlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSubscriptlist(this);
		}
	}

	public final SubscriptlistContext subscriptlist() throws RecognitionException {
		SubscriptlistContext _localctx = new SubscriptlistContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_subscriptlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(948);
			subscript();
			setState(953);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(949);
					match(COMMA);
					setState(950);
					subscript();
					}
					} 
				}
				setState(955);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			}
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(956);
				match(COMMA);
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

	public static class SubscriptContext extends ParserRuleContext {
		public TerminalNode ELLIPSIS() { return getToken(PythonParser.ELLIPSIS, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public SliceopContext sliceop() {
			return getRuleContext(SliceopContext.class,0);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSubscript(this);
		}
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_subscript);
		int _la;
		try {
			setState(977);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(959);
				match(ELLIPSIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(960);
				test();
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(961);
					match(COLON);
					setState(963);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
						{
						setState(962);
						test();
						}
					}

					setState(966);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COLON) {
						{
						setState(965);
						sliceop();
						}
					}

					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(970);
				match(COLON);
				setState(972);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
					{
					setState(971);
					test();
					}
				}

				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(974);
					sliceop();
					}
				}

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

	public static class SliceopContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SliceopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSliceop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSliceop(this);
		}
	}

	public final SliceopContext sliceop() throws RecognitionException {
		SliceopContext _localctx = new SliceopContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_sliceop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(979);
			match(COLON);
			setState(981);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONE) | (1L << LAMBDA) | (1L << NOT) | (1L << AWAIT) | (1L << PRINT) | (1L << EXEC) | (1L << TRUE) | (1L << FALSE) | (1L << ELLIPSIS) | (1L << REVERSE_QUOTE) | (1L << ADD) | (1L << MINUS) | (1L << NOT_OP))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (STRING - 83)) | (1L << (DECIMAL_INTEGER - 83)) | (1L << (OCT_INTEGER - 83)) | (1L << (HEX_INTEGER - 83)) | (1L << (BIN_INTEGER - 83)) | (1L << (IMAG_NUMBER - 83)) | (1L << (FLOAT_NUMBER - 83)) | (1L << (OPEN_PAREN - 83)) | (1L << (OPEN_BRACE - 83)) | (1L << (OPEN_BRACKET - 83)) | (1L << (NAME - 83)))) != 0)) {
				{
				setState(980);
				test();
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

	public static class Comp_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Logical_testContext logical_test() {
			return getRuleContext(Logical_testContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComp_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComp_for(this);
		}
	}

	public final Comp_forContext comp_for() throws RecognitionException {
		Comp_forContext _localctx = new Comp_forContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_comp_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(FOR);
			setState(984);
			exprlist();
			setState(985);
			match(IN);
			setState(986);
			logical_test(0);
			setState(988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF || _la==FOR) {
				{
				setState(987);
				comp_iter();
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

	public static class Comp_iterContext extends ParserRuleContext {
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_iterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_iter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComp_iter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComp_iter(this);
		}
	}

	public final Comp_iterContext comp_iter() throws RecognitionException {
		Comp_iterContext _localctx = new Comp_iterContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_comp_iter);
		int _la;
		try {
			setState(996);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(990);
				comp_for();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(991);
				match(IF);
				setState(992);
				test();
				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF || _la==FOR) {
					{
					setState(993);
					comp_iter();
					}
				}

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
		case 12:
			return except_clause_sempred((Except_clauseContext)_localctx, predIndex);
		case 22:
			return small_stmt_sempred((Small_stmtContext)_localctx, predIndex);
		case 25:
			return assign_part_sempred((Assign_partContext)_localctx, predIndex);
		case 37:
			return logical_test_sempred((Logical_testContext)_localctx, predIndex);
		case 38:
			return comparison_sempred((ComparisonContext)_localctx, predIndex);
		case 39:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 47:
			return dotted_name_sempred((Dotted_nameContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean except_clause_sempred(Except_clauseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return CheckVersion(2);
		case 1:
			return CheckVersion(3);
		}
		return true;
	}
	private boolean small_stmt_sempred(Small_stmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return CheckVersion(2);
		case 3:
			return CheckVersion(2);
		case 4:
			return CheckVersion(3);
		}
		return true;
	}
	private boolean assign_part_sempred(Assign_partContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return CheckVersion(3);
		}
		return true;
	}
	private boolean logical_test_sempred(Logical_testContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean comparison_sempred(ComparisonContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		case 14:
			return precpred(_ctx, 2);
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean dotted_name_sempred(Dotted_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3f\u03e9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\5\2\u008a\n\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\u0093\n\3\3\4\3\4\6\4\u0097\n\4\r\4\16\4\u0098"+
		"\3\5\3\5\7\5\u009d\n\5\f\5\16\5\u00a0\13\5\3\6\3\6\5\6\u00a4\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\7\5\7\u00b1\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00b8\n\7\3\7\5\7\u00bb\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00c4\n\7\3\7\3\7\3\7\3\7\6\7\u00ca\n\7\r\7\16\7\u00cb\3\7"+
		"\5\7\u00cf\n\7\3\7\5\7\u00d2\n\7\3\7\5\7\u00d5\n\7\3\7\5\7\u00d8\n\7\3"+
		"\7\3\7\3\7\3\7\7\7\u00de\n\7\f\7\16\7\u00e1\13\7\3\7\3\7\3\7\3\7\7\7\u00e7"+
		"\n\7\f\7\16\7\u00ea\13\7\3\7\3\7\5\7\u00ee\n\7\5\7\u00f0\n\7\3\b\3\b\3"+
		"\b\3\b\6\b\u00f6\n\b\r\b\16\b\u00f7\3\b\3\b\5\b\u00fc\n\b\3\t\3\t\3\t"+
		"\3\t\5\t\u0102\n\t\3\t\5\t\u0105\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0119\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0127\n\16\5\16"+
		"\u0129\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0132\n\17\3\17\5"+
		"\17\u0135\n\17\3\17\3\17\3\17\3\20\5\20\u013b\n\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0141\n\20\3\20\3\20\3\20\5\20\u0146\n\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\5\21\u014e\n\21\3\21\3\21\3\21\5\21\u0153\n\21\3\21\3\21\5\21"+
		"\u0157\n\21\3\21\5\21\u015a\n\21\3\21\5\21\u015d\n\21\3\21\3\21\5\21\u0161"+
		"\n\21\5\21\u0163\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\7\24"+
		"\u016e\n\24\f\24\16\24\u0171\13\24\3\25\3\25\3\25\5\25\u0176\n\25\3\25"+
		"\5\25\u0179\n\25\3\26\3\26\3\26\5\26\u017e\n\26\3\27\3\27\3\27\7\27\u0183"+
		"\n\27\f\27\16\27\u0186\13\27\3\27\5\27\u0189\n\27\3\27\3\27\3\30\3\30"+
		"\5\30\u018f\n\30\3\30\3\30\3\30\3\30\3\30\7\30\u0196\n\30\f\30\16\30\u0199"+
		"\13\30\3\30\5\30\u019c\n\30\3\30\3\30\3\30\3\30\6\30\u01a2\n\30\r\30\16"+
		"\30\u01a3\3\30\5\30\u01a7\n\30\5\30\u01a9\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u01b4\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u01bc\n\30\5\30\u01be\n\30\5\30\u01c0\n\30\3\30\3\30\5\30\u01c4\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u01cb\n\30\f\30\16\30\u01ce\13\30\3\30"+
		"\3\30\6\30\u01d2\n\30\r\30\16\30\u01d3\5\30\u01d6\n\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u01df\n\30\3\30\3\30\3\30\3\30\7\30\u01e5\n"+
		"\30\f\30\16\30\u01e8\13\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01f1"+
		"\n\30\5\30\u01f3\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01fb\n\30\3"+
		"\30\3\30\3\30\3\30\3\30\7\30\u0202\n\30\f\30\16\30\u0205\13\30\3\30\3"+
		"\30\5\30\u0209\n\30\3\31\3\31\5\31\u020d\n\31\3\31\3\31\6\31\u0211\n\31"+
		"\r\31\16\31\u0212\3\31\3\31\5\31\u0217\n\31\3\31\5\31\u021a\n\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0223\n\33\f\33\16\33\u0226\13\33"+
		"\3\33\3\33\5\33\u022a\n\33\3\33\5\33\u022d\n\33\3\33\3\33\3\33\3\33\3"+
		"\33\5\33\u0234\n\33\3\33\3\33\3\33\3\33\3\33\5\33\u023b\n\33\5\33\u023d"+
		"\n\33\3\34\3\34\3\34\7\34\u0242\n\34\f\34\16\34\u0245\13\34\3\34\5\34"+
		"\u0248\n\34\3\35\3\35\3\35\7\35\u024d\n\35\f\35\16\35\u0250\13\35\3\35"+
		"\5\35\u0253\n\35\3\36\3\36\3\36\5\36\u0258\n\36\3\37\3\37\3\37\7\37\u025d"+
		"\n\37\f\37\16\37\u0260\13\37\3 \3 \3 \5 \u0265\n \3!\3!\3!\3!\3!\3!\5"+
		"!\u026d\n!\3!\3!\5!\u0271\n!\3!\3!\5!\u0275\n!\3\"\3\"\3\"\5\"\u027a\n"+
		"\"\3\"\3\"\3\"\5\"\u027f\n\"\3\"\3\"\5\"\u0283\n\"\3\"\5\"\u0286\n\"\3"+
		"\"\5\"\u0289\n\"\3\"\3\"\5\"\u028d\n\"\5\"\u028f\n\"\3#\3#\3#\7#\u0294"+
		"\n#\f#\16#\u0297\13#\3$\3$\3$\5$\u029c\n$\3$\5$\u029f\n$\3%\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\5\'\u02ab\n\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u02b3\n"+
		"\'\f\'\16\'\u02b6\13\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u02c4\n"+
		"(\3(\3(\3(\5(\u02c9\n(\5(\u02cb\n(\3(\7(\u02ce\n(\f(\16(\u02d1\13(\3)"+
		"\3)\3)\3)\3)\3)\5)\u02d9\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\7)\u02f0\n)\f)\16)\u02f3\13)\3*\5*\u02f6\n*\3*\3"+
		"*\3*\3+\5+\u02fc\n+\3+\3+\3+\3,\3,\3,\5,\u0304\n,\3,\3,\3,\5,\u0309\n"+
		",\3,\3,\3,\5,\u030e\n,\3,\3,\3,\3,\5,\u0314\n,\3,\3,\3,\3,\3,\3,\3,\5"+
		",\u031d\n,\3,\3,\3,\5,\u0322\n,\3-\6-\u0325\n-\r-\16-\u0326\3.\3.\3.\3"+
		".\3.\3.\5.\u032f\n.\3.\3.\3.\3.\3.\3.\3.\5.\u0338\n.\7.\u033a\n.\f.\16"+
		".\u033d\13.\3.\5.\u0340\n.\3.\3.\3.\3.\3.\3.\5.\u0348\n.\3/\3/\5/\u034c"+
		"\n/\3/\3/\3/\3/\5/\u0352\n/\7/\u0354\n/\f/\16/\u0357\13/\3/\5/\u035a\n"+
		"/\5/\u035c\n/\3\60\3\60\3\60\7\60\u0361\n\60\f\60\16\60\u0364\13\60\3"+
		"\60\5\60\u0367\n\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u036f\n\61\f\61"+
		"\16\61\u0372\13\61\3\62\3\62\5\62\u0376\n\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\65\5\65\u037f\n\65\3\66\3\66\3\67\3\67\5\67\u0385\n\67\38\38\3"+
		"8\58\u038a\n8\39\39\59\u038e\n9\3:\3:\3:\3:\3;\3;\3;\3<\3<\5<\u0399\n"+
		"<\3<\3<\3<\3<\3<\5<\u03a0\n<\3=\3=\3=\7=\u03a5\n=\f=\16=\u03a8\13=\3="+
		"\5=\u03ab\n=\3>\3>\3>\3>\5>\u03b1\n>\3>\3>\5>\u03b5\n>\3?\3?\3?\7?\u03ba"+
		"\n?\f?\16?\u03bd\13?\3?\5?\u03c0\n?\3@\3@\3@\3@\5@\u03c6\n@\3@\5@\u03c9"+
		"\n@\5@\u03cb\n@\3@\3@\5@\u03cf\n@\3@\5@\u03d2\n@\5@\u03d4\n@\3A\3A\5A"+
		"\u03d8\nA\3B\3B\3B\3B\3B\5B\u03df\nB\3C\3C\3C\3C\5C\u03e5\nC\5C\u03e7"+
		"\nC\3C\2\6LNP`D\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\2\f\3\3"+
		"\5\5\3\2+,\3\2HT\4\29:>>\5\2..;=FF\3\29:\3\2\678\3\2)*\3\2VY\4\2..\62"+
		"\62\2\u0471\2\u0089\3\2\2\2\4\u0092\3\2\2\2\6\u0096\3\2\2\2\b\u009a\3"+
		"\2\2\2\n\u00a3\3\2\2\2\f\u00ef\3\2\2\2\16\u00fb\3\2\2\2\20\u00fd\3\2\2"+
		"\2\22\u0108\3\2\2\2\24\u010d\3\2\2\2\26\u0111\3\2\2\2\30\u0115\3\2\2\2"+
		"\32\u011a\3\2\2\2\34\u012d\3\2\2\2\36\u013a\3\2\2\2 \u0162\3\2\2\2\"\u0164"+
		"\3\2\2\2$\u0167\3\2\2\2&\u016a\3\2\2\2(\u0178\3\2\2\2*\u017a\3\2\2\2,"+
		"\u017f\3\2\2\2.\u0208\3\2\2\2\60\u0219\3\2\2\2\62\u021b\3\2\2\2\64\u023c"+
		"\3\2\2\2\66\u023e\3\2\2\28\u0249\3\2\2\2:\u0254\3\2\2\2<\u0259\3\2\2\2"+
		">\u0261\3\2\2\2@\u0274\3\2\2\2B\u028e\3\2\2\2D\u0290\3\2\2\2F\u029e\3"+
		"\2\2\2H\u02a0\3\2\2\2J\u02a3\3\2\2\2L\u02aa\3\2\2\2N\u02b7\3\2\2\2P\u02d8"+
		"\3\2\2\2R\u02f5\3\2\2\2T\u02fb\3\2\2\2V\u0321\3\2\2\2X\u0324\3\2\2\2Z"+
		"\u0347\3\2\2\2\\\u034b\3\2\2\2^\u035d\3\2\2\2`\u0368\3\2\2\2b\u0375\3"+
		"\2\2\2d\u0377\3\2\2\2f\u0379\3\2\2\2h\u037e\3\2\2\2j\u0380\3\2\2\2l\u0382"+
		"\3\2\2\2n\u0389\3\2\2\2p\u038d\3\2\2\2r\u038f\3\2\2\2t\u0393\3\2\2\2v"+
		"\u039f\3\2\2\2x\u03a1\3\2\2\2z\u03b4\3\2\2\2|\u03b6\3\2\2\2~\u03d3\3\2"+
		"\2\2\u0080\u03d5\3\2\2\2\u0082\u03d9\3\2\2\2\u0084\u03e6\3\2\2\2\u0086"+
		"\u008a\5\4\3\2\u0087\u008a\5\6\4\2\u0088\u008a\5\b\5\2\u0089\u0086\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\7\2\2\3\u008c\3\3\2\2\2\u008d\u0093\7\5\2\2"+
		"\u008e\u0093\5,\27\2\u008f\u0090\5\f\7\2\u0090\u0091\7\5\2\2\u0091\u0093"+
		"\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u008e\3\2\2\2\u0092\u008f\3\2\2\2\u0093"+
		"\5\3\2\2\2\u0094\u0097\7\5\2\2\u0095\u0097\5\n\6\2\u0096\u0094\3\2\2\2"+
		"\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\7\3\2\2\2\u009a\u009e\5^\60\2\u009b\u009d\7\5\2\2\u009c"+
		"\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\t\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\5,\27\2\u00a2\u00a4"+
		"\5\f\7\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\13\3\2\2\2\u00a5"+
		"\u00a6\7\17\2\2\u00a6\u00a7\5@!\2\u00a7\u00a8\7\60\2\2\u00a8\u00ac\5\16"+
		"\b\2\u00a9\u00ab\5\22\n\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00af\u00b1\5\24\13\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00f0\3\2\2\2\u00b2\u00b3\7\22\2\2\u00b3\u00b4\5@!\2\u00b4\u00b5\7\60"+
		"\2\2\u00b5\u00b7\5\16\b\2\u00b6\u00b8\5\24\13\2\u00b7\u00b6\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00f0\3\2\2\2\u00b9\u00bb\7%\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\23\2\2\u00bd"+
		"\u00be\5\66\34\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\5^\60\2\u00c0\u00c1"+
		"\7\60\2\2\u00c1\u00c3\5\16\b\2\u00c2\u00c4\5\24\13\2\u00c3\u00c2\3\2\2"+
		"\2\u00c3\u00c4\3\2\2\2\u00c4\u00f0\3\2\2\2\u00c5\u00c6\7\25\2\2\u00c6"+
		"\u00c7\7\60\2\2\u00c7\u00d4\5\16\b\2\u00c8\u00ca\5\32\16\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00cf\5\24\13\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00d2\5\26\f\2\u00d1\u00d0\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\5\26\f\2\u00d4\u00c9\3"+
		"\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00f0\3\2\2\2\u00d6\u00d8\7%\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7\30"+
		"\2\2\u00da\u00df\5\30\r\2\u00db\u00dc\7/\2\2\u00dc\u00de\5\30\r\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\60\2\2\u00e3"+
		"\u00e4\5\16\b\2\u00e4\u00f0\3\2\2\2\u00e5\u00e7\5\20\t\2\u00e6\u00e5\3"+
		"\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ed\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\5\34\17\2\u00ec\u00ee\5"+
		"\36\20\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00a5\3\2\2\2\u00ef\u00b2\3\2\2\2\u00ef\u00ba\3\2\2\2\u00ef\u00c5\3\2"+
		"\2\2\u00ef\u00d7\3\2\2\2\u00ef\u00e8\3\2\2\2\u00f0\r\3\2\2\2\u00f1\u00fc"+
		"\5,\27\2\u00f2\u00f3\7\5\2\2\u00f3\u00f5\7\3\2\2\u00f4\u00f6\5\n\6\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7\4\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f1\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fc\17\3\2\2\2\u00fd\u00fe\7F\2\2"+
		"\u00fe\u0104\5`\61\2\u00ff\u0101\7\\\2\2\u0100\u0102\5x=\2\u0101\u0100"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\7]\2\2\u0104"+
		"\u00ff\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7\5"+
		"\2\2\u0107\21\3\2\2\2\u0108\u0109\7\20\2\2\u0109\u010a\5@!\2\u010a\u010b"+
		"\7\60\2\2\u010b\u010c\5\16\b\2\u010c\23\3\2\2\2\u010d\u010e\7\21\2\2\u010e"+
		"\u010f\7\60\2\2\u010f\u0110\5\16\b\2\u0110\25\3\2\2\2\u0111\u0112\7\27"+
		"\2\2\u0112\u0113\7\60\2\2\u0113\u0114\5\16\b\2\u0114\27\3\2\2\2\u0115"+
		"\u0118\5@!\2\u0116\u0117\7\f\2\2\u0117\u0119\5P)\2\u0118\u0116\3\2\2\2"+
		"\u0118\u0119\3\2\2\2\u0119\31\3\2\2\2\u011a\u0128\7\31\2\2\u011b\u0126"+
		"\5@!\2\u011c\u011d\6\16\2\2\u011d\u011e\7/\2\2\u011e\u011f\5b\62\2\u011f"+
		"\u0120\b\16\1\2\u0120\u0127\3\2\2\2\u0121\u0122\6\16\3\2\u0122\u0123\7"+
		"\f\2\2\u0123\u0124\5b\62\2\u0124\u0125\b\16\1\2\u0125\u0127\3\2\2\2\u0126"+
		"\u011c\3\2\2\2\u0126\u0121\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2"+
		"\2\2\u0128\u011b\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\7\60\2\2\u012b\u012c\5\16\b\2\u012c\33\3\2\2\2\u012d\u012e\7\37"+
		"\2\2\u012e\u0134\5b\62\2\u012f\u0131\7\\\2\2\u0130\u0132\5x=\2\u0131\u0130"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\7]\2\2\u0134"+
		"\u012f\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\7\60"+
		"\2\2\u0137\u0138\5\16\b\2\u0138\35\3\2\2\2\u0139\u013b\7%\2\2\u013a\u0139"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\7\6\2\2\u013d"+
		"\u013e\5b\62\2\u013e\u0140\7\\\2\2\u013f\u0141\5 \21\2\u0140\u013f\3\2"+
		"\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\7]\2\2\u0143"+
		"\u0144\7G\2\2\u0144\u0146\5@!\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2"+
		"\2\u0146\u0147\3\2\2\2\u0147\u0148\7\60\2\2\u0148\u0149\5\16\b\2\u0149"+
		"\37\3\2\2\2\u014a\u014b\5&\24\2\u014b\u014c\7/\2\2\u014c\u014e\3\2\2\2"+
		"\u014d\u014a\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0159\3\2\2\2\u014f\u0152"+
		"\5\"\22\2\u0150\u0151\7/\2\2\u0151\u0153\5&\24\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0155\7/\2\2\u0155\u0157\5$\23"+
		"\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u015a"+
		"\5$\23\2\u0159\u014f\3\2\2\2\u0159\u0158\3\2\2\2\u015a\u015c\3\2\2\2\u015b"+
		"\u015d\7/\2\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0163\3\2"+
		"\2\2\u015e\u0160\5&\24\2\u015f\u0161\7/\2\2\u0160\u015f\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u014d\3\2\2\2\u0162\u015e\3\2"+
		"\2\2\u0163!\3\2\2\2\u0164\u0165\7.\2\2\u0165\u0166\5*\26\2\u0166#\3\2"+
		"\2\2\u0167\u0168\7\62\2\2\u0168\u0169\5*\26\2\u0169%\3\2\2\2\u016a\u016f"+
		"\5(\25\2\u016b\u016c\7/\2\2\u016c\u016e\5(\25\2\u016d\u016b\3\2\2\2\u016e"+
		"\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\'\3\2\2\2"+
		"\u0171\u016f\3\2\2\2\u0172\u0175\5*\26\2\u0173\u0174\7\63\2\2\u0174\u0176"+
		"\5@!\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2\2\2\u0177"+
		"\u0179\7.\2\2\u0178\u0172\3\2\2\2\u0178\u0177\3\2\2\2\u0179)\3\2\2\2\u017a"+
		"\u017d\5b\62\2\u017b\u017c\7\60\2\2\u017c\u017e\5@!\2\u017d\u017b\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017e+\3\2\2\2\u017f\u0184\5.\30\2\u0180\u0181"+
		"\7\61\2\2\u0181\u0183\5.\30\2\u0182\u0180\3\2\2\2\u0183\u0186\3\2\2\2"+
		"\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184"+
		"\3\2\2\2\u0187\u0189\7\61\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2"+
		"\u0189\u018a\3\2\2\2\u018a\u018b\t\2\2\2\u018b-\3\2\2\2\u018c\u018e\5"+
		"\60\31\2\u018d\u018f\5\64\33\2\u018e\u018d\3\2\2\2\u018e\u018f\3\2\2\2"+
		"\u018f\u0209\3\2\2\2\u0190\u0191\6\30\4\2\u0191\u01a8\7\'\2\2\u0192\u0197"+
		"\5@!\2\u0193\u0194\7/\2\2\u0194\u0196\5@!\2\u0195\u0193\3\2\2\2\u0196"+
		"\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019b\3\2"+
		"\2\2\u0199\u0197\3\2\2\2\u019a\u019c\7/\2\2\u019b\u019a\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u01a9\3\2\2\2\u019d\u019e\78\2\2\u019e\u01a1\5@!"+
		"\2\u019f\u01a0\7/\2\2\u01a0\u01a2\5@!\2\u01a1\u019f\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5"+
		"\u01a7\7/\2\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2"+
		"\2\2\u01a8\u0192\3\2\2\2\u01a8\u019d\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ab\b\30\1\2\u01ab\u0209\3\2\2\2\u01ac\u01ad\7!\2\2\u01ad\u0209\5\66"+
		"\34\2\u01ae\u0209\7\"\2\2\u01af\u0209\7$\2\2\u01b0\u0209\7#\2\2\u01b1"+
		"\u01b3\7\7\2\2\u01b2\u01b4\5^\60\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4\u0209\3\2\2\2\u01b5\u01bf\7\b\2\2\u01b6\u01bd\5@!\2\u01b7\u01b8"+
		"\7/\2\2\u01b8\u01bb\5@!\2\u01b9\u01ba\7/\2\2\u01ba\u01bc\5@!\2\u01bb\u01b9"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01b7\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01b6\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01c2\7\t\2\2\u01c2\u01c4\5@!\2\u01c3\u01c1"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u0209\3\2\2\2\u01c5\u0209\5l\67\2\u01c6"+
		"\u01c7\7\n\2\2\u01c7\u0209\5<\37\2\u01c8\u01d5\7\t\2\2\u01c9\u01cb\t\3"+
		"\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d6\5`"+
		"\61\2\u01d0\u01d2\t\3\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01cc\3\2"+
		"\2\2\u01d5\u01d1\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01de\7\n\2\2\u01d8"+
		"\u01df\7.\2\2\u01d9\u01da\7\\\2\2\u01da\u01db\58\35\2\u01db\u01dc\7]\2"+
		"\2\u01dc\u01df\3\2\2\2\u01dd\u01df\58\35\2\u01de\u01d8\3\2\2\2\u01de\u01d9"+
		"\3\2\2\2\u01de\u01dd\3\2\2\2\u01df\u0209\3\2\2\2\u01e0\u01e1\7\r\2\2\u01e1"+
		"\u01e6\5b\62\2\u01e2\u01e3\7/\2\2\u01e3\u01e5\5b\62\2\u01e4\u01e2\3\2"+
		"\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u0209\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\6\30\5\2\u01ea\u01eb\7"+
		"(\2\2\u01eb\u01f2\5P)\2\u01ec\u01ed\7\24\2\2\u01ed\u01f0\5@!\2\u01ee\u01ef"+
		"\7/\2\2\u01ef\u01f1\5@!\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01ec\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2"+
		"\2\2\u01f4\u01f5\b\30\1\2\u01f5\u0209\3\2\2\2\u01f6\u01f7\7\16\2\2\u01f7"+
		"\u01fa\5@!\2\u01f8\u01f9\7/\2\2\u01f9\u01fb\5@!\2\u01fa\u01f8\3\2\2\2"+
		"\u01fa\u01fb\3\2\2\2\u01fb\u0209\3\2\2\2\u01fc\u01fd\6\30\6\2\u01fd\u01fe"+
		"\7\13\2\2\u01fe\u0203\5b\62\2\u01ff\u0200\7/\2\2\u0200\u0202\5b\62\2\u0201"+
		"\u01ff\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2"+
		"\2\2\u0204\u0206\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0207\b\30\1\2\u0207"+
		"\u0209\3\2\2\2\u0208\u018c\3\2\2\2\u0208\u0190\3\2\2\2\u0208\u01ac\3\2"+
		"\2\2\u0208\u01ae\3\2\2\2\u0208\u01af\3\2\2\2\u0208\u01b0\3\2\2\2\u0208"+
		"\u01b1\3\2\2\2\u0208\u01b5\3\2\2\2\u0208\u01c5\3\2\2\2\u0208\u01c6\3\2"+
		"\2\2\u0208\u01c8\3\2\2\2\u0208\u01e0\3\2\2\2\u0208\u01e9\3\2\2\2\u0208"+
		"\u01f6\3\2\2\2\u0208\u01fc\3\2\2\2\u0209/\3\2\2\2\u020a\u020d\5@!\2\u020b"+
		"\u020d\5\62\32\2\u020c\u020a\3\2\2\2\u020c\u020b\3\2\2\2\u020d\u020e\3"+
		"\2\2\2\u020e\u020f\7/\2\2\u020f\u0211\3\2\2\2\u0210\u020c\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0216\3\2"+
		"\2\2\u0214\u0217\5@!\2\u0215\u0217\5\62\32\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u021a\5^"+
		"\60\2\u0219\u0210\3\2\2\2\u0219\u0218\3\2\2\2\u021a\61\3\2\2\2\u021b\u021c"+
		"\7.\2\2\u021c\u021d\5P)\2\u021d\63\3\2\2\2\u021e\u022c\7\63\2\2\u021f"+
		"\u0224\5\60\31\2\u0220\u0221\7\63\2\2\u0221\u0223\5\60\31\2\u0222\u0220"+
		"\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0229\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\7\63\2\2\u0228\u022a\5"+
		"l\67\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022d\3\2\2\2\u022b"+
		"\u022d\5l\67\2\u022c\u021f\3\2\2\2\u022c\u022b\3\2\2\2\u022d\u023d\3\2"+
		"\2\2\u022e\u022f\6\33\7\2\u022f\u0230\7\60\2\2\u0230\u0233\5@!\2\u0231"+
		"\u0232\7\63\2\2\u0232\u0234\5^\60\2\u0233\u0231\3\2\2\2\u0233\u0234\3"+
		"\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\b\33\1\2\u0236\u023d\3\2\2\2\u0237"+
		"\u023a\t\4\2\2\u0238\u023b\5l\67\2\u0239\u023b\5^\60\2\u023a\u0238\3\2"+
		"\2\2\u023a\u0239\3\2\2\2\u023b\u023d\3\2\2\2\u023c\u021e\3\2\2\2\u023c"+
		"\u022e\3\2\2\2\u023c\u0237\3\2\2\2\u023d\65\3\2\2\2\u023e\u0243\5P)\2"+
		"\u023f\u0240\7/\2\2\u0240\u0242\5P)\2\u0241\u023f\3\2\2\2\u0242\u0245"+
		"\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0247\3\2\2\2\u0245"+
		"\u0243\3\2\2\2\u0246\u0248\7/\2\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2"+
		"\2\2\u0248\67\3\2\2\2\u0249\u024e\5:\36\2\u024a\u024b\7/\2\2\u024b\u024d"+
		"\5:\36\2\u024c\u024a\3\2\2\2\u024d\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024e"+
		"\u024f\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0251\u0253\7/"+
		"\2\2\u0252\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u02539\3\2\2\2\u0254\u0257"+
		"\5b\62\2\u0255\u0256\7\f\2\2\u0256\u0258\5b\62\2\u0257\u0255\3\2\2\2\u0257"+
		"\u0258\3\2\2\2\u0258;\3\2\2\2\u0259\u025e\5> \2\u025a\u025b\7/\2\2\u025b"+
		"\u025d\5> \2\u025c\u025a\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2"+
		"\2\u025e\u025f\3\2\2\2\u025f=\3\2\2\2\u0260\u025e\3\2\2\2\u0261\u0264"+
		"\5`\61\2\u0262\u0263\7\f\2\2\u0263\u0265\5b\62\2\u0264\u0262\3\2\2\2\u0264"+
		"\u0265\3\2\2\2\u0265?\3\2\2\2\u0266\u026c\5L\'\2\u0267\u0268\7\17\2\2"+
		"\u0268\u0269\5L\'\2\u0269\u026a\7\21\2\2\u026a\u026b\5@!\2\u026b\u026d"+
		"\3\2\2\2\u026c\u0267\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u0275\3\2\2\2\u026e"+
		"\u0270\7\32\2\2\u026f\u0271\5B\"\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271\u0272\3\2\2\2\u0272\u0273\7\60\2\2\u0273\u0275\5@!\2\u0274"+
		"\u0266\3\2\2\2\u0274\u026e\3\2\2\2\u0275A\3\2\2\2\u0276\u0277\5D#\2\u0277"+
		"\u0278\7/\2\2\u0278\u027a\3\2\2\2\u0279\u0276\3\2\2\2\u0279\u027a\3\2"+
		"\2\2\u027a\u0285\3\2\2\2\u027b\u027e\5H%\2\u027c\u027d\7/\2\2\u027d\u027f"+
		"\5D#\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0282\3\2\2\2\u0280"+
		"\u0281\7/\2\2\u0281\u0283\5J&\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2"+
		"\2\u0283\u0286\3\2\2\2\u0284\u0286\5J&\2\u0285\u027b\3\2\2\2\u0285\u0284"+
		"\3\2\2\2\u0286\u0288\3\2\2\2\u0287\u0289\7/\2\2\u0288\u0287\3\2\2\2\u0288"+
		"\u0289\3\2\2\2\u0289\u028f\3\2\2\2\u028a\u028c\5D#\2\u028b\u028d\7/\2"+
		"\2\u028c\u028b\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028f\3\2\2\2\u028e\u0279"+
		"\3\2\2\2\u028e\u028a\3\2\2\2\u028fC\3\2\2\2\u0290\u0295\5F$\2\u0291\u0292"+
		"\7/\2\2\u0292\u0294\5F$\2\u0293\u0291\3\2\2\2\u0294\u0297\3\2\2\2\u0295"+
		"\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296E\3\2\2\2\u0297\u0295\3\2\2\2"+
		"\u0298\u029b\5b\62\2\u0299\u029a\7\63\2\2\u029a\u029c\5@!\2\u029b\u0299"+
		"\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029f\7.\2\2\u029e"+
		"\u0298\3\2\2\2\u029e\u029d\3\2\2\2\u029fG\3\2\2\2\u02a0\u02a1\7.\2\2\u02a1"+
		"\u02a2\5b\62\2\u02a2I\3\2\2\2\u02a3\u02a4\7\62\2\2\u02a4\u02a5\5b\62\2"+
		"\u02a5K\3\2\2\2\u02a6\u02a7\b\'\1\2\u02a7\u02ab\5N(\2\u02a8\u02a9\7\35"+
		"\2\2\u02a9\u02ab\5L\'\5\u02aa\u02a6\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab"+
		"\u02b4\3\2\2\2\u02ac\u02ad\f\4\2\2\u02ad\u02ae\7\34\2\2\u02ae\u02b3\5"+
		"L\'\5\u02af\u02b0\f\3\2\2\u02b0\u02b1\7\33\2\2\u02b1\u02b3\5L\'\4\u02b2"+
		"\u02ac\3\2\2\2\u02b2\u02af\3\2\2\2\u02b3\u02b6\3\2\2\2\u02b4\u02b2\3\2"+
		"\2\2\u02b4\u02b5\3\2\2\2\u02b5M\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b7\u02b8"+
		"\b(\1\2\u02b8\u02b9\5P)\2\u02b9\u02cf\3\2\2\2\u02ba\u02ca\f\4\2\2\u02bb"+
		"\u02cb\7?\2\2\u02bc\u02cb\7@\2\2\u02bd\u02cb\7A\2\2\u02be\u02cb\7B\2\2"+
		"\u02bf\u02cb\7C\2\2\u02c0\u02cb\7D\2\2\u02c1\u02cb\7E\2\2\u02c2\u02c4"+
		"\7\35\2\2\u02c3\u02c2\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5\3\2\2\2"+
		"\u02c5\u02cb\7\24\2\2\u02c6\u02c8\7\36\2\2\u02c7\u02c9\7\35\2\2\u02c8"+
		"\u02c7\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02bb\3\2"+
		"\2\2\u02ca\u02bc\3\2\2\2\u02ca\u02bd\3\2\2\2\u02ca\u02be\3\2\2\2\u02ca"+
		"\u02bf\3\2\2\2\u02ca\u02c0\3\2\2\2\u02ca\u02c1\3\2\2\2\u02ca\u02c3\3\2"+
		"\2\2\u02ca\u02c6\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce\5N(\5\u02cd\u02ba"+
		"\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"O\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d3\b)\1\2\u02d3\u02d9\5V,\2\u02d4"+
		"\u02d9\5R*\2\u02d5\u02d9\5T+\2\u02d6\u02d7\t\5\2\2\u02d7\u02d9\5P)\t\u02d8"+
		"\u02d2\3\2\2\2\u02d8\u02d4\3\2\2\2\u02d8\u02d5\3\2\2\2\u02d8\u02d6\3\2"+
		"\2\2\u02d9\u02f1\3\2\2\2\u02da\u02db\f\n\2\2\u02db\u02dc\7\62\2\2\u02dc"+
		"\u02f0\5P)\n\u02dd\u02de\f\b\2\2\u02de\u02df\t\6\2\2\u02df\u02f0\5P)\t"+
		"\u02e0\u02e1\f\7\2\2\u02e1\u02e2\t\7\2\2\u02e2\u02f0\5P)\b\u02e3\u02e4"+
		"\f\6\2\2\u02e4\u02e5\t\b\2\2\u02e5\u02f0\5P)\7\u02e6\u02e7\f\5\2\2\u02e7"+
		"\u02e8\7\66\2\2\u02e8\u02f0\5P)\6\u02e9\u02ea\f\4\2\2\u02ea\u02eb\7\65"+
		"\2\2\u02eb\u02f0\5P)\5\u02ec\u02ed\f\3\2\2\u02ed\u02ee\7\64\2\2\u02ee"+
		"\u02f0\5P)\4\u02ef\u02da\3\2\2\2\u02ef\u02dd\3\2\2\2\u02ef\u02e0\3\2\2"+
		"\2\u02ef\u02e3\3\2\2\2\u02ef\u02e6\3\2\2\2\u02ef\u02e9\3\2\2\2\u02ef\u02ec"+
		"\3\2\2\2\u02f0\u02f3\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2"+
		"Q\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f4\u02f6\7&\2\2\u02f5\u02f4\3\2\2\2\u02f5"+
		"\u02f6\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\5V,\2\u02f8\u02f9\5p9\2"+
		"\u02f9S\3\2\2\2\u02fa\u02fc\7&\2\2\u02fb\u02fa\3\2\2\2\u02fb\u02fc\3\2"+
		"\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\5V,\2\u02fe\u02ff\5v<\2\u02ffU\3"+
		"\2\2\2\u0300\u0303\7\\\2\2\u0301\u0304\5l\67\2\u0302\u0304\5\\/\2\u0303"+
		"\u0301\3\2\2\2\u0303\u0302\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305\3\2"+
		"\2\2\u0305\u0322\7]\2\2\u0306\u0308\7`\2\2\u0307\u0309\5\\/\2\u0308\u0307"+
		"\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u0322\7a\2\2\u030b"+
		"\u030d\7^\2\2\u030c\u030e\5Z.\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2"+
		"\2\u030e\u030f\3\2\2\2\u030f\u0322\7_\2\2\u0310\u0311\7-\2\2\u0311\u0313"+
		"\5^\60\2\u0312\u0314\7/\2\2\u0313\u0312\3\2\2\2\u0313\u0314\3\2\2\2\u0314"+
		"\u0315\3\2\2\2\u0315\u0316\7-\2\2\u0316\u0322\3\2\2\2\u0317\u0322\7,\2"+
		"\2\u0318\u0322\5b\62\2\u0319\u0322\7\'\2\2\u031a\u0322\7(\2\2\u031b\u031d"+
		"\7:\2\2\u031c\u031b\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031e\3\2\2\2\u031e"+
		"\u0322\5h\65\2\u031f\u0322\7\26\2\2\u0320\u0322\5X-\2\u0321\u0300\3\2"+
		"\2\2\u0321\u0306\3\2\2\2\u0321\u030b\3\2\2\2\u0321\u0310\3\2\2\2\u0321"+
		"\u0317\3\2\2\2\u0321\u0318\3\2\2\2\u0321\u0319\3\2\2\2\u0321\u031a\3\2"+
		"\2\2\u0321\u031c\3\2\2\2\u0321\u031f\3\2\2\2\u0321\u0320\3\2\2\2\u0322"+
		"W\3\2\2\2\u0323\u0325\7U\2\2\u0324\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326"+
		"\u0324\3\2\2\2\u0326\u0327\3\2\2\2\u0327Y\3\2\2\2\u0328\u0329\5@!\2\u0329"+
		"\u032a\7\60\2\2\u032a\u032b\5@!\2\u032b\u032f\3\2\2\2\u032c\u032d\7\62"+
		"\2\2\u032d\u032f\5P)\2\u032e\u0328\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u033b"+
		"\3\2\2\2\u0330\u0337\7/\2\2\u0331\u0332\5@!\2\u0332\u0333\7\60\2\2\u0333"+
		"\u0334\5@!\2\u0334\u0338\3\2\2\2\u0335\u0336\7\62\2\2\u0336\u0338\5P)"+
		"\2\u0337\u0331\3\2\2\2\u0337\u0335\3\2\2\2\u0338\u033a\3\2\2\2\u0339\u0330"+
		"\3\2\2\2\u033a\u033d\3\2\2\2\u033b\u0339\3\2\2\2\u033b\u033c\3\2\2\2\u033c"+
		"\u033f\3\2\2\2\u033d\u033b\3\2\2\2\u033e\u0340\7/\2\2\u033f\u033e\3\2"+
		"\2\2\u033f\u0340\3\2\2\2\u0340\u0348\3\2\2\2\u0341\u0342\5@!\2\u0342\u0343"+
		"\7\60\2\2\u0343\u0344\5@!\2\u0344\u0345\5\u0082B\2\u0345\u0348\3\2\2\2"+
		"\u0346\u0348\5\\/\2\u0347\u032e\3\2\2\2\u0347\u0341\3\2\2\2\u0347\u0346"+
		"\3\2\2\2\u0348[\3\2\2\2\u0349\u034c\5@!\2\u034a\u034c\5\62\32\2\u034b"+
		"\u0349\3\2\2\2\u034b\u034a\3\2\2\2\u034c\u035b\3\2\2\2\u034d\u035c\5\u0082"+
		"B\2\u034e\u0351\7/\2\2\u034f\u0352\5@!\2\u0350\u0352\5\62\32\2\u0351\u034f"+
		"\3\2\2\2\u0351\u0350\3\2\2\2\u0352\u0354\3\2\2\2\u0353\u034e\3\2\2\2\u0354"+
		"\u0357\3\2\2\2\u0355\u0353\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0359\3\2"+
		"\2\2\u0357\u0355\3\2\2\2\u0358\u035a\7/\2\2\u0359\u0358\3\2\2\2\u0359"+
		"\u035a\3\2\2\2\u035a\u035c\3\2\2\2\u035b\u034d\3\2\2\2\u035b\u0355\3\2"+
		"\2\2\u035c]\3\2\2\2\u035d\u0362\5@!\2\u035e\u035f\7/\2\2\u035f\u0361\5"+
		"@!\2\u0360\u035e\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0360\3\2\2\2\u0362"+
		"\u0363\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0365\u0367\7/"+
		"\2\2\u0366\u0365\3\2\2\2\u0366\u0367\3\2\2\2\u0367_\3\2\2\2\u0368\u0369"+
		"\b\61\1\2\u0369\u036a\5b\62\2\u036a\u0370\3\2\2\2\u036b\u036c\f\4\2\2"+
		"\u036c\u036d\7+\2\2\u036d\u036f\5b\62\2\u036e\u036b\3\2\2\2\u036f\u0372"+
		"\3\2\2\2\u0370\u036e\3\2\2\2\u0370\u0371\3\2\2\2\u0371a\3\2\2\2\u0372"+
		"\u0370\3\2\2\2\u0373\u0376\5d\63\2\u0374\u0376\5f\64\2\u0375\u0373\3\2"+
		"\2\2\u0375\u0374\3\2\2\2\u0376c\3\2\2\2\u0377\u0378\7b\2\2\u0378e\3\2"+
		"\2\2\u0379\u037a\t\t\2\2\u037ag\3\2\2\2\u037b\u037f\5j\66\2\u037c\u037f"+
		"\7Z\2\2\u037d\u037f\7[\2\2\u037e\u037b\3\2\2\2\u037e\u037c\3\2\2\2\u037e"+
		"\u037d\3\2\2\2\u037fi\3\2\2\2\u0380\u0381\t\n\2\2\u0381k\3\2\2\2\u0382"+
		"\u0384\7 \2\2\u0383\u0385\5n8\2\u0384\u0383\3\2\2\2\u0384\u0385\3\2\2"+
		"\2\u0385m\3\2\2\2\u0386\u0387\7\t\2\2\u0387\u038a\5@!\2\u0388\u038a\5"+
		"^\60\2\u0389\u0386\3\2\2\2\u0389\u0388\3\2\2\2\u038ao\3\2\2\2\u038b\u038e"+
		"\5r:\2\u038c\u038e\5t;\2\u038d\u038b\3\2\2\2\u038d\u038c\3\2\2\2\u038e"+
		"q\3\2\2\2\u038f\u0390\7+\2\2\u0390\u0391\5b\62\2\u0391\u0392\5v<\2\u0392"+
		"s\3\2\2\2\u0393\u0394\7+\2\2\u0394\u0395\5b\62\2\u0395u\3\2\2\2\u0396"+
		"\u0398\7\\\2\2\u0397\u0399\5x=\2\u0398\u0397\3\2\2\2\u0398\u0399\3\2\2"+
		"\2\u0399\u039a\3\2\2\2\u039a\u03a0\7]\2\2\u039b\u039c\7`\2\2\u039c\u039d"+
		"\5|?\2\u039d\u039e\7a\2\2\u039e\u03a0\3\2\2\2\u039f\u0396\3\2\2\2\u039f"+
		"\u039b\3\2\2\2\u03a0w\3\2\2\2\u03a1\u03a6\5z>\2\u03a2\u03a3\7/\2\2\u03a3"+
		"\u03a5\5z>\2\u03a4\u03a2\3\2\2\2\u03a5\u03a8\3\2\2\2\u03a6\u03a4\3\2\2"+
		"\2\u03a6\u03a7\3\2\2\2\u03a7\u03aa\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a9\u03ab"+
		"\7/\2\2\u03aa\u03a9\3\2\2\2\u03aa\u03ab\3\2\2\2\u03aby\3\2\2\2\u03ac\u03b0"+
		"\5@!\2\u03ad\u03b1\5\u0082B\2\u03ae\u03af\7\63\2\2\u03af\u03b1\5@!\2\u03b0"+
		"\u03ad\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b5\3\2"+
		"\2\2\u03b2\u03b3\t\13\2\2\u03b3\u03b5\5@!\2\u03b4\u03ac\3\2\2\2\u03b4"+
		"\u03b2\3\2\2\2\u03b5{\3\2\2\2\u03b6\u03bb\5~@\2\u03b7\u03b8\7/\2\2\u03b8"+
		"\u03ba\5~@\2\u03b9\u03b7\3\2\2\2\u03ba\u03bd\3\2\2\2\u03bb\u03b9\3\2\2"+
		"\2\u03bb\u03bc\3\2\2\2\u03bc\u03bf\3\2\2\2\u03bd\u03bb\3\2\2\2\u03be\u03c0"+
		"\7/\2\2\u03bf\u03be\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0}\3\2\2\2\u03c1\u03d4"+
		"\7,\2\2\u03c2\u03ca\5@!\2\u03c3\u03c5\7\60\2\2\u03c4\u03c6\5@!\2\u03c5"+
		"\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c8\3\2\2\2\u03c7\u03c9\5\u0080"+
		"A\2\u03c8\u03c7\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03cb\3\2\2\2\u03ca"+
		"\u03c3\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03d4\3\2\2\2\u03cc\u03ce\7\60"+
		"\2\2\u03cd\u03cf\5@!\2\u03ce\u03cd\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d1"+
		"\3\2\2\2\u03d0\u03d2\5\u0080A\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2"+
		"\2\u03d2\u03d4\3\2\2\2\u03d3\u03c1\3\2\2\2\u03d3\u03c2\3\2\2\2\u03d3\u03cc"+
		"\3\2\2\2\u03d4\177\3\2\2\2\u03d5\u03d7\7\60\2\2\u03d6\u03d8\5@!\2\u03d7"+
		"\u03d6\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u0081\3\2\2\2\u03d9\u03da\7\23"+
		"\2\2\u03da\u03db\5\66\34\2\u03db\u03dc\7\24\2\2\u03dc\u03de\5L\'\2\u03dd"+
		"\u03df\5\u0084C\2\u03de\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u0083"+
		"\3\2\2\2\u03e0\u03e7\5\u0082B\2\u03e1\u03e2\7\17\2\2\u03e2\u03e4\5@!\2"+
		"\u03e3\u03e5\5\u0084C\2\u03e4\u03e3\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5"+
		"\u03e7\3\2\2\2\u03e6\u03e0\3\2\2\2\u03e6\u03e1\3\2\2\2\u03e7\u0085\3\2"+
		"\2\2\u0099\u0089\u0092\u0096\u0098\u009e\u00a3\u00ac\u00b0\u00b7\u00ba"+
		"\u00c3\u00cb\u00ce\u00d1\u00d4\u00d7\u00df\u00e8\u00ed\u00ef\u00f7\u00fb"+
		"\u0101\u0104\u0118\u0126\u0128\u0131\u0134\u013a\u0140\u0145\u014d\u0152"+
		"\u0156\u0159\u015c\u0160\u0162\u016f\u0175\u0178\u017d\u0184\u0188\u018e"+
		"\u0197\u019b\u01a3\u01a6\u01a8\u01b3\u01bb\u01bd\u01bf\u01c3\u01cc\u01d3"+
		"\u01d5\u01de\u01e6\u01f0\u01f2\u01fa\u0203\u0208\u020c\u0212\u0216\u0219"+
		"\u0224\u0229\u022c\u0233\u023a\u023c\u0243\u0247\u024e\u0252\u0257\u025e"+
		"\u0264\u026c\u0270\u0274\u0279\u027e\u0282\u0285\u0288\u028c\u028e\u0295"+
		"\u029b\u029e\u02aa\u02b2\u02b4\u02c3\u02c8\u02ca\u02cf\u02d8\u02ef\u02f1"+
		"\u02f5\u02fb\u0303\u0308\u030d\u0313\u031c\u0321\u0326\u032e\u0337\u033b"+
		"\u033f\u0347\u034b\u0351\u0355\u0359\u035b\u0362\u0366\u0370\u0375\u037e"+
		"\u0384\u0389\u038d\u0398\u039f\u03a6\u03aa\u03b0\u03b4\u03bb\u03bf\u03c5"+
		"\u03c8\u03ca\u03ce\u03d1\u03d3\u03d7\u03de\u03e4\u03e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}