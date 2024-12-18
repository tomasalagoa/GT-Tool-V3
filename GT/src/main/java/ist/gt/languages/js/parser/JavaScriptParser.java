// Generated from C:/Users/mihail/Desktop/Tese/master-thesis/YASAT/src/main/resources/grammars/js\JavaScriptParser.g4 by ANTLR 4.8
package ist.gt.languages.js.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaScriptParser extends JavaScriptParserBase {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HashBangLine=1, MultiLineComment=2, SingleLineComment=3, RegularExpressionLiteral=4, 
		OpenBracket=5, CloseBracket=6, OpenParen=7, CloseParen=8, OpenBrace=9, 
		CloseBrace=10, SemiColon=11, Comma=12, Assign=13, QuestionMark=14, Colon=15, 
		Ellipsis=16, Dot=17, PlusPlus=18, MinusMinus=19, Plus=20, Minus=21, BitNot=22, 
		Not=23, Multiply=24, Divide=25, Modulus=26, Power=27, NullCoalesce=28, 
		Hashtag=29, RightShiftArithmetic=30, LeftShiftArithmetic=31, RightShiftLogical=32, 
		LessThan=33, MoreThan=34, LessThanEquals=35, GreaterThanEquals=36, Equals_=37, 
		NotEquals=38, IdentityEquals=39, IdentityNotEquals=40, BitAnd=41, BitXOr=42, 
		BitOr=43, And=44, Or=45, MultiplyAssign=46, DivideAssign=47, ModulusAssign=48, 
		PlusAssign=49, MinusAssign=50, LeftShiftArithmeticAssign=51, RightShiftArithmeticAssign=52, 
		RightShiftLogicalAssign=53, BitAndAssign=54, BitXorAssign=55, BitOrAssign=56, 
		PowerAssign=57, ARROW=58, NullLiteral=59, BooleanLiteral=60, DecimalLiteral=61, 
		HexIntegerLiteral=62, OctalIntegerLiteral=63, OctalIntegerLiteral2=64, 
		BinaryIntegerLiteral=65, BigHexIntegerLiteral=66, BigOctalIntegerLiteral=67, 
		BigBinaryIntegerLiteral=68, BigDecimalIntegerLiteral=69, Break=70, Do=71, 
		Instanceof=72, Typeof=73, Case=74, Else=75, New=76, Var=77, Catch=78, 
		Finally=79, Return=80, Void=81, Continue=82, For=83, Switch=84, While=85, 
		Debugger=86, Function=87, This=88, With=89, Default=90, If=91, Throw=92, 
		Delete=93, In=94, Try=95, As=96, From=97, Class=98, Enum=99, Extends=100, 
		Super=101, Const=102, Export=103, Import=104, Async=105, Await=106, Implements=107, 
		StrictLet=108, NonStrictLet=109, Private=110, Public=111, Interface=112, 
		Package=113, Protected=114, Static=115, Yield=116, Identifier=117, StringLiteral=118, 
		TemplateStringLiteral=119, WhiteSpaces=120, LineTerminator=121, HtmlComment=122, 
		CDataComment=123, UnexpectedCharacter=124;
	public static final int
		RULE_program = 0, RULE_sourceElement = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_statementList = 4, RULE_importStatement = 5, RULE_importFromBlock = 6, 
		RULE_moduleItems = 7, RULE_importDefault = 8, RULE_importNamespace = 9, 
		RULE_importFrom = 10, RULE_aliasName = 11, RULE_exportStatement = 12, 
		RULE_exportFromBlock = 13, RULE_declaration = 14, RULE_variableStatement = 15, 
		RULE_variableDeclarationList = 16, RULE_variableDeclaration = 17, RULE_emptyStatement = 18, 
		RULE_expressionStatement = 19, RULE_ifStatement = 20, RULE_elseIfStatement = 21, 
		RULE_elseStatement = 22, RULE_iterationStatement = 23, RULE_varModifier = 24, 
		RULE_continueStatement = 25, RULE_breakStatement = 26, RULE_returnStatement = 27, 
		RULE_yieldStatement = 28, RULE_withStatement = 29, RULE_switchStatement = 30, 
		RULE_caseBlock = 31, RULE_caseClauses = 32, RULE_caseClause = 33, RULE_defaultClause = 34, 
		RULE_labelledStatement = 35, RULE_throwStatement = 36, RULE_tryStatement = 37, 
		RULE_catchProduction = 38, RULE_finallyProduction = 39, RULE_debuggerStatement = 40, 
		RULE_functionDeclaration = 41, RULE_classDeclaration = 42, RULE_classTail = 43, 
		RULE_classElement = 44, RULE_attribute = 45, RULE_methodDefinition = 46, 
		RULE_formalParameterList = 47, RULE_formalParameterArg = 48, RULE_lastFormalParameterArg = 49, 
		RULE_functionBody = 50, RULE_sourceElements = 51, RULE_arrayLiteral = 52, 
		RULE_elementList = 53, RULE_arrayElement = 54, RULE_propertyAssignment = 55, 
		RULE_propertyName = 56, RULE_arguments = 57, RULE_argument = 58, RULE_expressionSequence = 59, 
		RULE_singleExpression = 60, RULE_functionCall = 61, RULE_attributeAccess = 62, 
		RULE_assignable = 63, RULE_objectLiteral = 64, RULE_anoymousFunction = 65, 
		RULE_arrowFunctionParameters = 66, RULE_arrowFunctionBody = 67, RULE_assignmentOperator = 68, 
		RULE_literal = 69, RULE_numericLiteral = 70, RULE_bigintLiteral = 71, 
		RULE_getter = 72, RULE_setter = 73, RULE_identifierName = 74, RULE_identifier = 75, 
		RULE_reservedWord = 76, RULE_keyword = 77, RULE_let = 78, RULE_eos = 79;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sourceElement", "statement", "block", "statementList", "importStatement", 
			"importFromBlock", "moduleItems", "importDefault", "importNamespace", 
			"importFrom", "aliasName", "exportStatement", "exportFromBlock", "declaration", 
			"variableStatement", "variableDeclarationList", "variableDeclaration", 
			"emptyStatement", "expressionStatement", "ifStatement", "elseIfStatement", 
			"elseStatement", "iterationStatement", "varModifier", "continueStatement", 
			"breakStatement", "returnStatement", "yieldStatement", "withStatement", 
			"switchStatement", "caseBlock", "caseClauses", "caseClause", "defaultClause", 
			"labelledStatement", "throwStatement", "tryStatement", "catchProduction", 
			"finallyProduction", "debuggerStatement", "functionDeclaration", "classDeclaration", 
			"classTail", "classElement", "attribute", "methodDefinition", "formalParameterList", 
			"formalParameterArg", "lastFormalParameterArg", "functionBody", "sourceElements", 
			"arrayLiteral", "elementList", "arrayElement", "propertyAssignment", 
			"propertyName", "arguments", "argument", "expressionSequence", "singleExpression", 
			"functionCall", "attributeAccess", "assignable", "objectLiteral", "anoymousFunction", 
			"arrowFunctionParameters", "arrowFunctionBody", "assignmentOperator", 
			"literal", "numericLiteral", "bigintLiteral", "getter", "setter", "identifierName", 
			"identifier", "reservedWord", "keyword", "let", "eos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", 
			"';'", "','", "'='", "'?'", "':'", "'...'", "'.'", "'++'", "'--'", "'+'", 
			"'-'", "'~'", "'!'", "'*'", "'/'", "'%'", "'**'", "'??'", "'#'", "'>>'", 
			"'<<'", "'>>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'==='", 
			"'!=='", "'&'", "'^'", "'|'", "'&&'", "'||'", "'*='", "'/='", "'%='", 
			"'+='", "'-='", "'<<='", "'>>='", "'>>>='", "'&='", "'^='", "'|='", "'**='", 
			"'=>'", "'null'", null, null, null, null, null, null, null, null, null, 
			null, "'break'", "'do'", "'instanceof'", "'typeof'", "'case'", "'else'", 
			"'new'", "'var'", "'catch'", "'finally'", "'return'", "'void'", "'continue'", 
			"'for'", "'switch'", "'while'", "'debugger'", "'function'", "'this'", 
			"'with'", "'default'", "'if'", "'throw'", "'delete'", "'in'", "'try'", 
			"'as'", "'from'", "'class'", "'enum'", "'extends'", "'super'", "'const'", 
			"'export'", "'import'", "'async'", "'await'", "'implements'", null, null, 
			"'private'", "'public'", "'interface'", "'package'", "'protected'", "'static'", 
			"'yield'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HashBangLine", "MultiLineComment", "SingleLineComment", "RegularExpressionLiteral", 
			"OpenBracket", "CloseBracket", "OpenParen", "CloseParen", "OpenBrace", 
			"CloseBrace", "SemiColon", "Comma", "Assign", "QuestionMark", "Colon", 
			"Ellipsis", "Dot", "PlusPlus", "MinusMinus", "Plus", "Minus", "BitNot", 
			"Not", "Multiply", "Divide", "Modulus", "Power", "NullCoalesce", "Hashtag", 
			"RightShiftArithmetic", "LeftShiftArithmetic", "RightShiftLogical", "LessThan", 
			"MoreThan", "LessThanEquals", "GreaterThanEquals", "Equals_", "NotEquals", 
			"IdentityEquals", "IdentityNotEquals", "BitAnd", "BitXOr", "BitOr", "And", 
			"Or", "MultiplyAssign", "DivideAssign", "ModulusAssign", "PlusAssign", 
			"MinusAssign", "LeftShiftArithmeticAssign", "RightShiftArithmeticAssign", 
			"RightShiftLogicalAssign", "BitAndAssign", "BitXorAssign", "BitOrAssign", 
			"PowerAssign", "ARROW", "NullLiteral", "BooleanLiteral", "DecimalLiteral", 
			"HexIntegerLiteral", "OctalIntegerLiteral", "OctalIntegerLiteral2", "BinaryIntegerLiteral", 
			"BigHexIntegerLiteral", "BigOctalIntegerLiteral", "BigBinaryIntegerLiteral", 
			"BigDecimalIntegerLiteral", "Break", "Do", "Instanceof", "Typeof", "Case", 
			"Else", "New", "Var", "Catch", "Finally", "Return", "Void", "Continue", 
			"For", "Switch", "While", "Debugger", "Function", "This", "With", "Default", 
			"If", "Throw", "Delete", "In", "Try", "As", "From", "Class", "Enum", 
			"Extends", "Super", "Const", "Export", "Import", "Async", "Await", "Implements", 
			"StrictLet", "NonStrictLet", "Private", "Public", "Interface", "Package", 
			"Protected", "Static", "Yield", "Identifier", "StringLiteral", "TemplateStringLiteral", 
			"WhiteSpaces", "LineTerminator", "HtmlComment", "CDataComment", "UnexpectedCharacter"
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
	public String getGrammarFileName() { return "JavaScriptParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavaScriptParser.EOF, 0); }
		public TerminalNode HashBangLine() { return getToken(JavaScriptParser.HashBangLine, 0); }
		public SourceElementsContext sourceElements() {
			return getRuleContext(SourceElementsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(160);
				match(HashBangLine);
				}
				break;
			}
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(163);
				sourceElements();
				}
				break;
			}
			setState(166);
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

	public static class SourceElementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SourceElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterSourceElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitSourceElement(this);
		}
	}

	public final SourceElementContext sourceElement() throws RecognitionException {
		SourceElementContext _localctx = new SourceElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sourceElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			statement();
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public ExportStatementContext exportStatement() {
			return getRuleContext(ExportStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public YieldStatementContext yieldStatement() {
			return getRuleContext(YieldStatementContext.class,0);
		}
		public WithStatementContext withStatement() {
			return getRuleContext(WithStatementContext.class,0);
		}
		public LabelledStatementContext labelledStatement() {
			return getRuleContext(LabelledStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public DebuggerStatementContext debuggerStatement() {
			return getRuleContext(DebuggerStatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				variableStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				importStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				exportStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				emptyStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				classDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(176);
				expressionStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(177);
				ifStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(178);
				iterationStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(179);
				continueStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(180);
				breakStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(181);
				returnStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(182);
				yieldStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(183);
				withStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(184);
				labelledStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(185);
				switchStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(186);
				throwStatement();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(187);
				tryStatement();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(188);
				debuggerStatement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(189);
				functionDeclaration();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(OpenBrace);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(193);
				statementList();
				}
				break;
			}
			setState(196);
			match(CloseBrace);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitStatementList(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
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
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(201); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode Import() { return getToken(JavaScriptParser.Import, 0); }
		public ImportFromBlockContext importFromBlock() {
			return getRuleContext(ImportFromBlockContext.class,0);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(Import);
			setState(204);
			importFromBlock();
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

	public static class ImportFromBlockContext extends ParserRuleContext {
		public ImportFromContext importFrom() {
			return getRuleContext(ImportFromContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ImportNamespaceContext importNamespace() {
			return getRuleContext(ImportNamespaceContext.class,0);
		}
		public ModuleItemsContext moduleItems() {
			return getRuleContext(ModuleItemsContext.class,0);
		}
		public ImportDefaultContext importDefault() {
			return getRuleContext(ImportDefaultContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(JavaScriptParser.StringLiteral, 0); }
		public ImportFromBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFromBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportFromBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportFromBlock(this);
		}
	}

	public final ImportFromBlockContext importFromBlock() throws RecognitionException {
		ImportFromBlockContext _localctx = new ImportFromBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_importFromBlock);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenBrace:
			case Multiply:
			case NullLiteral:
			case BooleanLiteral:
			case Break:
			case Do:
			case Instanceof:
			case Typeof:
			case Case:
			case Else:
			case New:
			case Var:
			case Catch:
			case Finally:
			case Return:
			case Void:
			case Continue:
			case For:
			case Switch:
			case While:
			case Debugger:
			case Function:
			case This:
			case With:
			case Default:
			case If:
			case Throw:
			case Delete:
			case In:
			case Try:
			case As:
			case From:
			case Class:
			case Enum:
			case Extends:
			case Super:
			case Const:
			case Export:
			case Import:
			case Async:
			case Await:
			case Implements:
			case StrictLet:
			case NonStrictLet:
			case Private:
			case Public:
			case Interface:
			case Package:
			case Protected:
			case Static:
			case Yield:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(206);
					importDefault();
					}
					break;
				}
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Multiply:
				case NullLiteral:
				case BooleanLiteral:
				case Break:
				case Do:
				case Instanceof:
				case Typeof:
				case Case:
				case Else:
				case New:
				case Var:
				case Catch:
				case Finally:
				case Return:
				case Void:
				case Continue:
				case For:
				case Switch:
				case While:
				case Debugger:
				case Function:
				case This:
				case With:
				case Default:
				case If:
				case Throw:
				case Delete:
				case In:
				case Try:
				case As:
				case From:
				case Class:
				case Enum:
				case Extends:
				case Super:
				case Const:
				case Export:
				case Import:
				case Async:
				case Await:
				case Implements:
				case StrictLet:
				case NonStrictLet:
				case Private:
				case Public:
				case Interface:
				case Package:
				case Protected:
				case Static:
				case Yield:
				case Identifier:
					{
					setState(209);
					importNamespace();
					}
					break;
				case OpenBrace:
					{
					setState(210);
					moduleItems();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				importFrom();
				setState(214);
				eos();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(StringLiteral);
				setState(217);
				eos();
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

	public static class ModuleItemsContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public List<AliasNameContext> aliasName() {
			return getRuleContexts(AliasNameContext.class);
		}
		public AliasNameContext aliasName(int i) {
			return getRuleContext(AliasNameContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public ModuleItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterModuleItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitModuleItems(this);
		}
	}

	public final ModuleItemsContext moduleItems() throws RecognitionException {
		ModuleItemsContext _localctx = new ModuleItemsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_moduleItems);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(OpenBrace);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					aliasName();
					setState(222);
					match(Comma);
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (NullLiteral - 59)) | (1L << (BooleanLiteral - 59)) | (1L << (Break - 59)) | (1L << (Do - 59)) | (1L << (Instanceof - 59)) | (1L << (Typeof - 59)) | (1L << (Case - 59)) | (1L << (Else - 59)) | (1L << (New - 59)) | (1L << (Var - 59)) | (1L << (Catch - 59)) | (1L << (Finally - 59)) | (1L << (Return - 59)) | (1L << (Void - 59)) | (1L << (Continue - 59)) | (1L << (For - 59)) | (1L << (Switch - 59)) | (1L << (While - 59)) | (1L << (Debugger - 59)) | (1L << (Function - 59)) | (1L << (This - 59)) | (1L << (With - 59)) | (1L << (Default - 59)) | (1L << (If - 59)) | (1L << (Throw - 59)) | (1L << (Delete - 59)) | (1L << (In - 59)) | (1L << (Try - 59)) | (1L << (As - 59)) | (1L << (From - 59)) | (1L << (Class - 59)) | (1L << (Enum - 59)) | (1L << (Extends - 59)) | (1L << (Super - 59)) | (1L << (Const - 59)) | (1L << (Export - 59)) | (1L << (Import - 59)) | (1L << (Async - 59)) | (1L << (Await - 59)) | (1L << (Implements - 59)) | (1L << (StrictLet - 59)) | (1L << (NonStrictLet - 59)) | (1L << (Private - 59)) | (1L << (Public - 59)) | (1L << (Interface - 59)) | (1L << (Package - 59)) | (1L << (Protected - 59)) | (1L << (Static - 59)) | (1L << (Yield - 59)) | (1L << (Identifier - 59)))) != 0)) {
				{
				setState(229);
				aliasName();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(230);
					match(Comma);
					}
				}

				}
			}

			setState(235);
			match(CloseBrace);
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

	public static class ImportDefaultContext extends ParserRuleContext {
		public AliasNameContext aliasName() {
			return getRuleContext(AliasNameContext.class,0);
		}
		public TerminalNode Comma() { return getToken(JavaScriptParser.Comma, 0); }
		public ImportDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportDefault(this);
		}
	}

	public final ImportDefaultContext importDefault() throws RecognitionException {
		ImportDefaultContext _localctx = new ImportDefaultContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importDefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			aliasName();
			setState(238);
			match(Comma);
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

	public static class ImportNamespaceContext extends ParserRuleContext {
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public List<IdentifierNameContext> identifierName() {
			return getRuleContexts(IdentifierNameContext.class);
		}
		public IdentifierNameContext identifierName(int i) {
			return getRuleContext(IdentifierNameContext.class,i);
		}
		public TerminalNode As() { return getToken(JavaScriptParser.As, 0); }
		public ImportNamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importNamespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportNamespace(this);
		}
	}

	public final ImportNamespaceContext importNamespace() throws RecognitionException {
		ImportNamespaceContext _localctx = new ImportNamespaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_importNamespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Multiply:
				{
				setState(240);
				match(Multiply);
				}
				break;
			case NullLiteral:
			case BooleanLiteral:
			case Break:
			case Do:
			case Instanceof:
			case Typeof:
			case Case:
			case Else:
			case New:
			case Var:
			case Catch:
			case Finally:
			case Return:
			case Void:
			case Continue:
			case For:
			case Switch:
			case While:
			case Debugger:
			case Function:
			case This:
			case With:
			case Default:
			case If:
			case Throw:
			case Delete:
			case In:
			case Try:
			case As:
			case From:
			case Class:
			case Enum:
			case Extends:
			case Super:
			case Const:
			case Export:
			case Import:
			case Async:
			case Await:
			case Implements:
			case StrictLet:
			case NonStrictLet:
			case Private:
			case Public:
			case Interface:
			case Package:
			case Protected:
			case Static:
			case Yield:
			case Identifier:
				{
				setState(241);
				identifierName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(244);
				match(As);
				setState(245);
				identifierName();
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

	public static class ImportFromContext extends ParserRuleContext {
		public TerminalNode From() { return getToken(JavaScriptParser.From, 0); }
		public TerminalNode StringLiteral() { return getToken(JavaScriptParser.StringLiteral, 0); }
		public ImportFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportFrom(this);
		}
	}

	public final ImportFromContext importFrom() throws RecognitionException {
		ImportFromContext _localctx = new ImportFromContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_importFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(From);
			setState(249);
			match(StringLiteral);
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

	public static class AliasNameContext extends ParserRuleContext {
		public List<IdentifierNameContext> identifierName() {
			return getRuleContexts(IdentifierNameContext.class);
		}
		public IdentifierNameContext identifierName(int i) {
			return getRuleContext(IdentifierNameContext.class,i);
		}
		public TerminalNode As() { return getToken(JavaScriptParser.As, 0); }
		public AliasNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAliasName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAliasName(this);
		}
	}

	public final AliasNameContext aliasName() throws RecognitionException {
		AliasNameContext _localctx = new AliasNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_aliasName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			identifierName();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(252);
				match(As);
				setState(253);
				identifierName();
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

	public static class ExportStatementContext extends ParserRuleContext {
		public ExportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportStatement; }
	 
		public ExportStatementContext() { }
		public void copyFrom(ExportStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExportDefaultDeclarationContext extends ExportStatementContext {
		public TerminalNode Export() { return getToken(JavaScriptParser.Export, 0); }
		public TerminalNode Default() { return getToken(JavaScriptParser.Default, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExportDefaultDeclarationContext(ExportStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterExportDefaultDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitExportDefaultDeclaration(this);
		}
	}
	public static class ExportDeclarationContext extends ExportStatementContext {
		public TerminalNode Export() { return getToken(JavaScriptParser.Export, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExportFromBlockContext exportFromBlock() {
			return getRuleContext(ExportFromBlockContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExportDeclarationContext(ExportStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterExportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitExportDeclaration(this);
		}
	}

	public final ExportStatementContext exportStatement() throws RecognitionException {
		ExportStatementContext _localctx = new ExportStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exportStatement);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ExportDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(Export);
				setState(259);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(257);
					exportFromBlock();
					}
					break;
				case 2:
					{
					setState(258);
					declaration();
					}
					break;
				}
				setState(261);
				eos();
				}
				break;
			case 2:
				_localctx = new ExportDefaultDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(Export);
				setState(264);
				match(Default);
				setState(265);
				singleExpression(0);
				setState(266);
				eos();
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

	public static class ExportFromBlockContext extends ParserRuleContext {
		public ImportNamespaceContext importNamespace() {
			return getRuleContext(ImportNamespaceContext.class,0);
		}
		public ImportFromContext importFrom() {
			return getRuleContext(ImportFromContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ModuleItemsContext moduleItems() {
			return getRuleContext(ModuleItemsContext.class,0);
		}
		public ExportFromBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportFromBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterExportFromBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitExportFromBlock(this);
		}
	}

	public final ExportFromBlockContext exportFromBlock() throws RecognitionException {
		ExportFromBlockContext _localctx = new ExportFromBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exportFromBlock);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Multiply:
			case NullLiteral:
			case BooleanLiteral:
			case Break:
			case Do:
			case Instanceof:
			case Typeof:
			case Case:
			case Else:
			case New:
			case Var:
			case Catch:
			case Finally:
			case Return:
			case Void:
			case Continue:
			case For:
			case Switch:
			case While:
			case Debugger:
			case Function:
			case This:
			case With:
			case Default:
			case If:
			case Throw:
			case Delete:
			case In:
			case Try:
			case As:
			case From:
			case Class:
			case Enum:
			case Extends:
			case Super:
			case Const:
			case Export:
			case Import:
			case Async:
			case Await:
			case Implements:
			case StrictLet:
			case NonStrictLet:
			case Private:
			case Public:
			case Interface:
			case Package:
			case Protected:
			case Static:
			case Yield:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				importNamespace();
				setState(271);
				importFrom();
				setState(272);
				eos();
				}
				break;
			case OpenBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				moduleItems();
				setState(276);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(275);
					importFrom();
					}
					break;
				}
				setState(278);
				eos();
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

	public static class DeclarationContext extends ParserRuleContext {
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration);
		try {
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
			case Const:
			case StrictLet:
			case NonStrictLet:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				variableStatement();
				}
				break;
			case Class:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				classDeclaration();
				}
				break;
			case Function:
			case Async:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				functionDeclaration();
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

	public static class VariableStatementContext extends ParserRuleContext {
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitVariableStatement(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			variableDeclarationList();
			setState(288);
			eos();
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

	public static class VariableDeclarationListContext extends ParserRuleContext {
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitVariableDeclarationList(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variableDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			varModifier();
			setState(291);
			variableDeclaration();
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(292);
					match(Comma);
					setState(293);
					variableDeclaration();
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode Assign() { return getToken(JavaScriptParser.Assign, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			assignable();
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(300);
				match(Assign);
				setState(301);
				singleExpression(0);
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(JavaScriptParser.SemiColon, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitEmptyStatement(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(SemiColon);
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			if (!(this.notOpenBraceAndNotFunction())) throw new FailedPredicateException(this, "this.notOpenBraceAndNotFunction()");
			setState(307);
			expressionSequence();
			setState(308);
			eos();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(JavaScriptParser.If, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(If);
			setState(311);
			match(OpenParen);
			setState(312);
			expressionSequence();
			setState(313);
			match(CloseParen);
			setState(314);
			statement();
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(315);
					elseIfStatement();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(321);
				elseStatement();
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(JavaScriptParser.Else, 0); }
		public TerminalNode If() { return getToken(JavaScriptParser.If, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitElseIfStatement(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(Else);
			setState(325);
			match(If);
			setState(326);
			match(OpenParen);
			setState(327);
			expressionSequence();
			setState(328);
			match(CloseParen);
			setState(329);
			statement();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(JavaScriptParser.Else, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(Else);
			setState(332);
			statement();
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

	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(JavaScriptParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(JavaScriptParser.While, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public List<ExpressionSequenceContext> expressionSequence() {
			return getRuleContexts(ExpressionSequenceContext.class);
		}
		public ExpressionSequenceContext expressionSequence(int i) {
			return getRuleContext(ExpressionSequenceContext.class,i);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public TerminalNode For() { return getToken(JavaScriptParser.For, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(JavaScriptParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(JavaScriptParser.SemiColon, i);
		}
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public TerminalNode In() { return getToken(JavaScriptParser.In, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Await() { return getToken(JavaScriptParser.Await, 0); }
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitIterationStatement(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_iterationStatement);
		int _la;
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(Do);
				setState(335);
				statement();
				setState(336);
				match(While);
				setState(337);
				match(OpenParen);
				setState(338);
				expressionSequence();
				setState(339);
				match(CloseParen);
				setState(340);
				eos();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(While);
				setState(343);
				match(OpenParen);
				setState(344);
				expressionSequence();
				setState(345);
				match(CloseParen);
				setState(346);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				match(For);
				setState(349);
				match(OpenParen);
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(350);
					expressionSequence();
					}
					break;
				case 2:
					{
					setState(351);
					variableDeclarationList();
					}
					break;
				}
				setState(354);
				match(SemiColon);
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RegularExpressionLiteral) | (1L << OpenBracket) | (1L << OpenParen) | (1L << OpenBrace) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Plus) | (1L << Minus) | (1L << BitNot) | (1L << Not) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << HexIntegerLiteral) | (1L << OctalIntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OctalIntegerLiteral2 - 64)) | (1L << (BinaryIntegerLiteral - 64)) | (1L << (BigHexIntegerLiteral - 64)) | (1L << (BigOctalIntegerLiteral - 64)) | (1L << (BigBinaryIntegerLiteral - 64)) | (1L << (BigDecimalIntegerLiteral - 64)) | (1L << (Typeof - 64)) | (1L << (New - 64)) | (1L << (Void - 64)) | (1L << (Function - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (Class - 64)) | (1L << (Super - 64)) | (1L << (Import - 64)) | (1L << (Async - 64)) | (1L << (Await - 64)) | (1L << (NonStrictLet - 64)) | (1L << (Yield - 64)) | (1L << (Identifier - 64)) | (1L << (StringLiteral - 64)) | (1L << (TemplateStringLiteral - 64)))) != 0)) {
					{
					setState(355);
					expressionSequence();
					}
				}

				setState(358);
				match(SemiColon);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RegularExpressionLiteral) | (1L << OpenBracket) | (1L << OpenParen) | (1L << OpenBrace) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Plus) | (1L << Minus) | (1L << BitNot) | (1L << Not) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << HexIntegerLiteral) | (1L << OctalIntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OctalIntegerLiteral2 - 64)) | (1L << (BinaryIntegerLiteral - 64)) | (1L << (BigHexIntegerLiteral - 64)) | (1L << (BigOctalIntegerLiteral - 64)) | (1L << (BigBinaryIntegerLiteral - 64)) | (1L << (BigDecimalIntegerLiteral - 64)) | (1L << (Typeof - 64)) | (1L << (New - 64)) | (1L << (Void - 64)) | (1L << (Function - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (Class - 64)) | (1L << (Super - 64)) | (1L << (Import - 64)) | (1L << (Async - 64)) | (1L << (Await - 64)) | (1L << (NonStrictLet - 64)) | (1L << (Yield - 64)) | (1L << (Identifier - 64)) | (1L << (StringLiteral - 64)) | (1L << (TemplateStringLiteral - 64)))) != 0)) {
					{
					setState(359);
					expressionSequence();
					}
				}

				setState(362);
				match(CloseParen);
				setState(363);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				match(For);
				setState(365);
				match(OpenParen);
				setState(368);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(366);
					singleExpression(0);
					}
					break;
				case 2:
					{
					setState(367);
					variableDeclarationList();
					}
					break;
				}
				setState(370);
				match(In);
				setState(371);
				expressionSequence();
				setState(372);
				match(CloseParen);
				setState(373);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(375);
				match(For);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Await) {
					{
					setState(376);
					match(Await);
					}
				}

				setState(379);
				match(OpenParen);
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(380);
					singleExpression(0);
					}
					break;
				case 2:
					{
					setState(381);
					variableDeclarationList();
					}
					break;
				}
				setState(384);
				identifier();
				setState(385);
				if (!(this.p("of"))) throw new FailedPredicateException(this, "this.p(\"of\")");
				setState(386);
				expressionSequence();
				setState(387);
				match(CloseParen);
				setState(388);
				statement();
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

	public static class VarModifierContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(JavaScriptParser.Var, 0); }
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public TerminalNode Const() { return getToken(JavaScriptParser.Const, 0); }
		public VarModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterVarModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitVarModifier(this);
		}
	}

	public final VarModifierContext varModifier() throws RecognitionException {
		VarModifierContext _localctx = new VarModifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_varModifier);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				match(Var);
				}
				break;
			case StrictLet:
			case NonStrictLet:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				let();
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(394);
				match(Const);
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(JavaScriptParser.Continue, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(Continue);
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(398);
				if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
				setState(399);
				identifier();
				}
				break;
			}
			setState(402);
			eos();
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(JavaScriptParser.Break, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(Break);
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(405);
				if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
				setState(406);
				identifier();
				}
				break;
			}
			setState(409);
			eos();
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(JavaScriptParser.Return, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(Return);
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(412);
				if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
				setState(413);
				expressionSequence();
				}
				break;
			}
			setState(416);
			eos();
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

	public static class YieldStatementContext extends ParserRuleContext {
		public TerminalNode Yield() { return getToken(JavaScriptParser.Yield, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public YieldStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterYieldStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitYieldStatement(this);
		}
	}

	public final YieldStatementContext yieldStatement() throws RecognitionException {
		YieldStatementContext _localctx = new YieldStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(Yield);
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(419);
				if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
				setState(420);
				expressionSequence();
				}
				break;
			}
			setState(423);
			eos();
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

	public static class WithStatementContext extends ParserRuleContext {
		public TerminalNode With() { return getToken(JavaScriptParser.With, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WithStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterWithStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitWithStatement(this);
		}
	}

	public final WithStatementContext withStatement() throws RecognitionException {
		WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_withStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(With);
			setState(426);
			match(OpenParen);
			setState(427);
			expressionSequence();
			setState(428);
			match(CloseParen);
			setState(429);
			statement();
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode Switch() { return getToken(JavaScriptParser.Switch, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public CaseBlockContext caseBlock() {
			return getRuleContext(CaseBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(Switch);
			setState(432);
			match(OpenParen);
			setState(433);
			expressionSequence();
			setState(434);
			match(CloseParen);
			setState(435);
			caseBlock();
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

	public static class CaseBlockContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public List<CaseClausesContext> caseClauses() {
			return getRuleContexts(CaseClausesContext.class);
		}
		public CaseClausesContext caseClauses(int i) {
			return getRuleContext(CaseClausesContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterCaseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitCaseBlock(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(OpenBrace);
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Case) {
				{
				setState(438);
				caseClauses();
				}
			}

			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Default) {
				{
				setState(441);
				defaultClause();
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Case) {
					{
					setState(442);
					caseClauses();
					}
				}

				}
			}

			setState(447);
			match(CloseBrace);
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

	public static class CaseClausesContext extends ParserRuleContext {
		public List<CaseClauseContext> caseClause() {
			return getRuleContexts(CaseClauseContext.class);
		}
		public CaseClauseContext caseClause(int i) {
			return getRuleContext(CaseClauseContext.class,i);
		}
		public CaseClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterCaseClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitCaseClauses(this);
		}
	}

	public final CaseClausesContext caseClauses() throws RecognitionException {
		CaseClausesContext _localctx = new CaseClausesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_caseClauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(449);
				caseClause();
				}
				}
				setState(452); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Case );
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

	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode Case() { return getToken(JavaScriptParser.Case, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitCaseClause(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(Case);
			setState(455);
			expressionSequence();
			setState(456);
			match(Colon);
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(457);
				statementList();
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

	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode Default() { return getToken(JavaScriptParser.Default, 0); }
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitDefaultClause(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(Default);
			setState(461);
			match(Colon);
			setState(463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(462);
				statementList();
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

	public static class LabelledStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabelledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterLabelledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitLabelledStatement(this);
		}
	}

	public final LabelledStatementContext labelledStatement() throws RecognitionException {
		LabelledStatementContext _localctx = new LabelledStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_labelledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			identifier();
			setState(466);
			match(Colon);
			setState(467);
			statement();
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

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(JavaScriptParser.Throw, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(Throw);
			setState(470);
			if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
			setState(471);
			expressionSequence();
			setState(472);
			eos();
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

	public static class TryStatementContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(JavaScriptParser.Try, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchProductionContext catchProduction() {
			return getRuleContext(CatchProductionContext.class,0);
		}
		public FinallyProductionContext finallyProduction() {
			return getRuleContext(FinallyProductionContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitTryStatement(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tryStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(Try);
			setState(475);
			block();
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Catch:
				{
				setState(476);
				catchProduction();
				setState(478);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(477);
					finallyProduction();
					}
					break;
				}
				}
				break;
			case Finally:
				{
				setState(480);
				finallyProduction();
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

	public static class CatchProductionContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(JavaScriptParser.Catch, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public CatchProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterCatchProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitCatchProduction(this);
		}
	}

	public final CatchProductionContext catchProduction() throws RecognitionException {
		CatchProductionContext _localctx = new CatchProductionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_catchProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(Catch);
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpenParen) {
				{
				setState(484);
				match(OpenParen);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenBracket || _la==OpenBrace || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(485);
					assignable();
					}
				}

				setState(488);
				match(CloseParen);
				}
			}

			setState(491);
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

	public static class FinallyProductionContext extends ParserRuleContext {
		public TerminalNode Finally() { return getToken(JavaScriptParser.Finally, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFinallyProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFinallyProduction(this);
		}
	}

	public final FinallyProductionContext finallyProduction() throws RecognitionException {
		FinallyProductionContext _localctx = new FinallyProductionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_finallyProduction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(Finally);
			setState(494);
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

	public static class DebuggerStatementContext extends ParserRuleContext {
		public TerminalNode Debugger() { return getToken(JavaScriptParser.Debugger, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public DebuggerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debuggerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterDebuggerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitDebuggerStatement(this);
		}
	}

	public final DebuggerStatementContext debuggerStatement() throws RecognitionException {
		DebuggerStatementContext _localctx = new DebuggerStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_debuggerStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(Debugger);
			setState(497);
			eos();
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode Function() { return getToken(JavaScriptParser.Function, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Async) {
				{
				setState(499);
				match(Async);
				}
			}

			setState(502);
			match(Function);
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Multiply) {
				{
				setState(503);
				match(Multiply);
				}
			}

			setState(506);
			identifier();
			setState(507);
			match(OpenParen);
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
				{
				setState(508);
				formalParameterList();
				}
			}

			setState(511);
			match(CloseParen);
			setState(512);
			match(OpenBrace);
			setState(513);
			functionBody();
			setState(514);
			match(CloseBrace);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(JavaScriptParser.Class, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassTailContext classTail() {
			return getRuleContext(ClassTailContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(Class);
			setState(517);
			identifier();
			setState(518);
			classTail();
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

	public static class ClassTailContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public TerminalNode Extends() { return getToken(JavaScriptParser.Extends, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public List<ClassElementContext> classElement() {
			return getRuleContexts(ClassElementContext.class);
		}
		public ClassElementContext classElement(int i) {
			return getRuleContext(ClassElementContext.class,i);
		}
		public ClassTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterClassTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitClassTail(this);
		}
	}

	public final ClassTailContext classTail() throws RecognitionException {
		ClassTailContext _localctx = new ClassTailContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_classTail);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extends) {
				{
				setState(520);
				match(Extends);
				setState(521);
				singleExpression(0);
				}
			}

			setState(524);
			match(OpenBrace);
			setState(528);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(525);
					classElement();
					}
					} 
				}
				setState(530);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(531);
			match(CloseBrace);
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

	public static class ClassElementContext extends ParserRuleContext {
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode Assign() { return getToken(JavaScriptParser.Assign, 0); }
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(JavaScriptParser.SemiColon, 0); }
		public List<TerminalNode> Static() { return getTokens(JavaScriptParser.Static); }
		public TerminalNode Static(int i) {
			return getToken(JavaScriptParser.Static, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Async() { return getTokens(JavaScriptParser.Async); }
		public TerminalNode Async(int i) {
			return getToken(JavaScriptParser.Async, i);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public ClassElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterClassElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitClassElement(this);
		}
	}

	public final ClassElementContext classElement() throws RecognitionException {
		ClassElementContext _localctx = new ClassElementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_classElement);
		try {
			int _alt;
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(537);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
						case 1:
							{
							setState(533);
							match(Static);
							}
							break;
						case 2:
							{
							setState(534);
							if (!(this.n("static"))) throw new FailedPredicateException(this, "this.n(\"static\")");
							setState(535);
							identifier();
							}
							break;
						case 3:
							{
							setState(536);
							match(Async);
							}
							break;
						}
						} 
					}
					setState(541);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				}
				setState(548);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(542);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(543);
					assignable();
					setState(544);
					match(Assign);
					setState(545);
					objectLiteral();
					setState(546);
					match(SemiColon);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				emptyStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(551);
				attribute();
				setState(552);
				match(Assign);
				setState(553);
				singleExpression(0);
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

	public static class AttributeContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode Hashtag() { return getToken(JavaScriptParser.Hashtag, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Hashtag) {
				{
				setState(557);
				match(Hashtag);
				}
			}

			setState(560);
			propertyName();
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

	public static class MethodDefinitionContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public TerminalNode Hashtag() { return getToken(JavaScriptParser.Hashtag, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitMethodDefinition(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_methodDefinition);
		int _la;
		try {
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Multiply) {
					{
					setState(562);
					match(Multiply);
					}
				}

				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Hashtag) {
					{
					setState(565);
					match(Hashtag);
					}
				}

				setState(568);
				propertyName();
				setState(569);
				match(OpenParen);
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(570);
					formalParameterList();
					}
				}

				setState(573);
				match(CloseParen);
				setState(574);
				match(OpenBrace);
				setState(575);
				functionBody();
				setState(576);
				match(CloseBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(578);
					match(Multiply);
					}
					break;
				}
				setState(582);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(581);
					match(Hashtag);
					}
					break;
				}
				setState(584);
				getter();
				setState(585);
				match(OpenParen);
				setState(586);
				match(CloseParen);
				setState(587);
				match(OpenBrace);
				setState(588);
				functionBody();
				setState(589);
				match(CloseBrace);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(592);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(591);
					match(Multiply);
					}
					break;
				}
				setState(595);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(594);
					match(Hashtag);
					}
					break;
				}
				setState(597);
				setter();
				setState(598);
				match(OpenParen);
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(599);
					formalParameterList();
					}
				}

				setState(602);
				match(CloseParen);
				setState(603);
				match(OpenBrace);
				setState(604);
				functionBody();
				setState(605);
				match(CloseBrace);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterArgContext> formalParameterArg() {
			return getRuleContexts(FormalParameterArgContext.class);
		}
		public FormalParameterArgContext formalParameterArg(int i) {
			return getRuleContext(FormalParameterArgContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public LastFormalParameterArgContext lastFormalParameterArg() {
			return getRuleContext(LastFormalParameterArgContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(622);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenBracket:
			case OpenBrace:
			case Async:
			case NonStrictLet:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				formalParameterArg();
				setState(614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(610);
						match(Comma);
						setState(611);
						formalParameterArg();
						}
						} 
					}
					setState(616);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(617);
					match(Comma);
					setState(618);
					lastFormalParameterArg();
					}
				}

				}
				break;
			case Ellipsis:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
				lastFormalParameterArg();
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

	public static class FormalParameterArgContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode Assign() { return getToken(JavaScriptParser.Assign, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public FormalParameterArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFormalParameterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFormalParameterArg(this);
		}
	}

	public final FormalParameterArgContext formalParameterArg() throws RecognitionException {
		FormalParameterArgContext _localctx = new FormalParameterArgContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_formalParameterArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			assignable();
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(625);
				match(Assign);
				setState(626);
				singleExpression(0);
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

	public static class LastFormalParameterArgContext extends ParserRuleContext {
		public TerminalNode Ellipsis() { return getToken(JavaScriptParser.Ellipsis, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public LastFormalParameterArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameterArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterLastFormalParameterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitLastFormalParameterArg(this);
		}
	}

	public final LastFormalParameterArgContext lastFormalParameterArg() throws RecognitionException {
		LastFormalParameterArgContext _localctx = new LastFormalParameterArgContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_lastFormalParameterArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(Ellipsis);
			setState(630);
			singleExpression(0);
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

	public static class FunctionBodyContext extends ParserRuleContext {
		public SourceElementsContext sourceElements() {
			return getRuleContext(SourceElementsContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionBody(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(632);
				sourceElements();
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

	public static class SourceElementsContext extends ParserRuleContext {
		public List<SourceElementContext> sourceElement() {
			return getRuleContexts(SourceElementContext.class);
		}
		public SourceElementContext sourceElement(int i) {
			return getRuleContext(SourceElementContext.class,i);
		}
		public SourceElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterSourceElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitSourceElements(this);
		}
	}

	public final SourceElementsContext sourceElements() throws RecognitionException {
		SourceElementsContext _localctx = new SourceElementsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_sourceElements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(636); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(635);
					sourceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(638); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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

	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode OpenBracket() { return getToken(JavaScriptParser.OpenBracket, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public TerminalNode CloseBracket() { return getToken(JavaScriptParser.CloseBracket, 0); }
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrayLiteral(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_arrayLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(640);
			match(OpenBracket);
			setState(641);
			elementList();
			setState(642);
			match(CloseBracket);
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

	public static class ElementListContext extends ParserRuleContext {
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public List<ArrayElementContext> arrayElement() {
			return getRuleContexts(ArrayElementContext.class);
		}
		public ArrayElementContext arrayElement(int i) {
			return getRuleContext(ArrayElementContext.class,i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitElementList(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_elementList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(644);
					match(Comma);
					}
					} 
				}
				setState(649);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RegularExpressionLiteral) | (1L << OpenBracket) | (1L << OpenParen) | (1L << OpenBrace) | (1L << Ellipsis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Plus) | (1L << Minus) | (1L << BitNot) | (1L << Not) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << HexIntegerLiteral) | (1L << OctalIntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OctalIntegerLiteral2 - 64)) | (1L << (BinaryIntegerLiteral - 64)) | (1L << (BigHexIntegerLiteral - 64)) | (1L << (BigOctalIntegerLiteral - 64)) | (1L << (BigBinaryIntegerLiteral - 64)) | (1L << (BigDecimalIntegerLiteral - 64)) | (1L << (Typeof - 64)) | (1L << (New - 64)) | (1L << (Void - 64)) | (1L << (Function - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (Class - 64)) | (1L << (Super - 64)) | (1L << (Import - 64)) | (1L << (Async - 64)) | (1L << (Await - 64)) | (1L << (NonStrictLet - 64)) | (1L << (Yield - 64)) | (1L << (Identifier - 64)) | (1L << (StringLiteral - 64)) | (1L << (TemplateStringLiteral - 64)))) != 0)) {
				{
				setState(650);
				arrayElement();
				}
			}

			setState(661);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(654); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(653);
						match(Comma);
						}
						}
						setState(656); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Comma );
					setState(658);
					arrayElement();
					}
					} 
				}
				setState(663);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			}
			setState(667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(664);
				match(Comma);
				}
				}
				setState(669);
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

	public static class ArrayElementContext extends ParserRuleContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(JavaScriptParser.Ellipsis, 0); }
		public ArrayElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrayElement(this);
		}
	}

	public final ArrayElementContext arrayElement() throws RecognitionException {
		ArrayElementContext _localctx = new ArrayElementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_arrayElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(670);
				match(Ellipsis);
				}
			}

			setState(673);
			singleExpression(0);
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

	public static class PropertyAssignmentContext extends ParserRuleContext {
		public PropertyAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAssignment; }
	 
		public PropertyAssignmentContext() { }
		public void copyFrom(PropertyAssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PropertyExpressionAssignmentContext extends PropertyAssignmentContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public PropertyExpressionAssignmentContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterPropertyExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitPropertyExpressionAssignment(this);
		}
	}
	public static class ComputedPropertyExpressionAssignmentContext extends PropertyAssignmentContext {
		public TerminalNode OpenBracket() { return getToken(JavaScriptParser.OpenBracket, 0); }
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TerminalNode CloseBracket() { return getToken(JavaScriptParser.CloseBracket, 0); }
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public ComputedPropertyExpressionAssignmentContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterComputedPropertyExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitComputedPropertyExpressionAssignment(this);
		}
	}
	public static class PropertyShorthandContext extends PropertyAssignmentContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(JavaScriptParser.Ellipsis, 0); }
		public PropertyShorthandContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterPropertyShorthand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitPropertyShorthand(this);
		}
	}
	public static class PropertySetterContext extends PropertyAssignmentContext {
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public FormalParameterArgContext formalParameterArg() {
			return getRuleContext(FormalParameterArgContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public PropertySetterContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterPropertySetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitPropertySetter(this);
		}
	}
	public static class PropertyGetterContext extends PropertyAssignmentContext {
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public PropertyGetterContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterPropertyGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitPropertyGetter(this);
		}
	}
	public static class FunctionPropertyContext extends PropertyAssignmentContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionPropertyContext(PropertyAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionProperty(this);
		}
	}

	public final PropertyAssignmentContext propertyAssignment() throws RecognitionException {
		PropertyAssignmentContext _localctx = new PropertyAssignmentContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_propertyAssignment);
		int _la;
		try {
			setState(720);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				_localctx = new PropertyExpressionAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				propertyName();
				setState(676);
				match(Colon);
				setState(677);
				singleExpression(0);
				}
				break;
			case 2:
				_localctx = new ComputedPropertyExpressionAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(679);
				match(OpenBracket);
				setState(680);
				singleExpression(0);
				setState(681);
				match(CloseBracket);
				setState(682);
				match(Colon);
				setState(683);
				singleExpression(0);
				}
				break;
			case 3:
				_localctx = new FunctionPropertyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(686);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(685);
					match(Async);
					}
					break;
				}
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Multiply) {
					{
					setState(688);
					match(Multiply);
					}
				}

				setState(691);
				propertyName();
				setState(692);
				match(OpenParen);
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(693);
					formalParameterList();
					}
				}

				setState(696);
				match(CloseParen);
				setState(697);
				match(OpenBrace);
				setState(698);
				functionBody();
				setState(699);
				match(CloseBrace);
				}
				break;
			case 4:
				_localctx = new PropertyGetterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(701);
				getter();
				setState(702);
				match(OpenParen);
				setState(703);
				match(CloseParen);
				setState(704);
				match(OpenBrace);
				setState(705);
				functionBody();
				setState(706);
				match(CloseBrace);
				}
				break;
			case 5:
				_localctx = new PropertySetterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(708);
				setter();
				setState(709);
				match(OpenParen);
				setState(710);
				formalParameterArg();
				setState(711);
				match(CloseParen);
				setState(712);
				match(OpenBrace);
				setState(713);
				functionBody();
				setState(714);
				match(CloseBrace);
				}
				break;
			case 6:
				_localctx = new PropertyShorthandContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(716);
					match(Ellipsis);
					}
				}

				setState(719);
				singleExpression(0);
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

	public static class PropertyNameContext extends ParserRuleContext {
		public IdentifierNameContext identifierName() {
			return getRuleContext(IdentifierNameContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(JavaScriptParser.StringLiteral, 0); }
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public TerminalNode OpenBracket() { return getToken(JavaScriptParser.OpenBracket, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode CloseBracket() { return getToken(JavaScriptParser.CloseBracket, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitPropertyName(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_propertyName);
		try {
			setState(729);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NullLiteral:
			case BooleanLiteral:
			case Break:
			case Do:
			case Instanceof:
			case Typeof:
			case Case:
			case Else:
			case New:
			case Var:
			case Catch:
			case Finally:
			case Return:
			case Void:
			case Continue:
			case For:
			case Switch:
			case While:
			case Debugger:
			case Function:
			case This:
			case With:
			case Default:
			case If:
			case Throw:
			case Delete:
			case In:
			case Try:
			case As:
			case From:
			case Class:
			case Enum:
			case Extends:
			case Super:
			case Const:
			case Export:
			case Import:
			case Async:
			case Await:
			case Implements:
			case StrictLet:
			case NonStrictLet:
			case Private:
			case Public:
			case Interface:
			case Package:
			case Protected:
			case Static:
			case Yield:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(722);
				identifierName();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(723);
				match(StringLiteral);
				}
				break;
			case DecimalLiteral:
			case HexIntegerLiteral:
			case OctalIntegerLiteral:
			case OctalIntegerLiteral2:
			case BinaryIntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(724);
				numericLiteral();
				}
				break;
			case OpenBracket:
				enterOuterAlt(_localctx, 4);
				{
				setState(725);
				match(OpenBracket);
				setState(726);
				singleExpression(0);
				setState(727);
				match(CloseBracket);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_arguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			match(OpenParen);
			setState(743);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RegularExpressionLiteral) | (1L << OpenBracket) | (1L << OpenParen) | (1L << OpenBrace) | (1L << Ellipsis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Plus) | (1L << Minus) | (1L << BitNot) | (1L << Not) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << HexIntegerLiteral) | (1L << OctalIntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OctalIntegerLiteral2 - 64)) | (1L << (BinaryIntegerLiteral - 64)) | (1L << (BigHexIntegerLiteral - 64)) | (1L << (BigOctalIntegerLiteral - 64)) | (1L << (BigBinaryIntegerLiteral - 64)) | (1L << (BigDecimalIntegerLiteral - 64)) | (1L << (Typeof - 64)) | (1L << (New - 64)) | (1L << (Void - 64)) | (1L << (Function - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (Class - 64)) | (1L << (Super - 64)) | (1L << (Import - 64)) | (1L << (Async - 64)) | (1L << (Await - 64)) | (1L << (NonStrictLet - 64)) | (1L << (Yield - 64)) | (1L << (Identifier - 64)) | (1L << (StringLiteral - 64)) | (1L << (TemplateStringLiteral - 64)))) != 0)) {
				{
				setState(732);
				argument();
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(733);
						match(Comma);
						setState(734);
						argument();
						}
						} 
					}
					setState(739);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				}
				setState(741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(740);
					match(Comma);
					}
				}

				}
			}

			setState(745);
			match(CloseParen);
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
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(JavaScriptParser.Ellipsis, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(747);
				match(Ellipsis);
				}
			}

			setState(752);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(750);
				singleExpression(0);
				}
				break;
			case 2:
				{
				setState(751);
				identifier();
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

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitExpressionSequence(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_expressionSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(754);
			singleExpression(0);
			setState(759);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(755);
					match(Comma);
					setState(756);
					singleExpression(0);
					}
					} 
				}
				setState(761);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
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

	public static class SingleExpressionContext extends ParserRuleContext {
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
	 
		public SingleExpressionContext() { }
		public void copyFrom(SingleExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesizedExpressionContext extends SingleExpressionContext {
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public ParenthesizedExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitParenthesizedExpression(this);
		}
	}
	public static class TemplateStringExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode TemplateStringLiteral() { return getToken(JavaScriptParser.TemplateStringLiteral, 0); }
		public TemplateStringExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterTemplateStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitTemplateStringExpression(this);
		}
	}
	public static class YieldExpressionContext extends SingleExpressionContext {
		public YieldStatementContext yieldStatement() {
			return getRuleContext(YieldStatementContext.class,0);
		}
		public YieldExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterYieldExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitYieldExpression(this);
		}
	}
	public static class ObjectLiteralExpressionContext extends SingleExpressionContext {
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ObjectLiteralExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterObjectLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitObjectLiteralExpression(this);
		}
	}
	public static class NewExpressionContext extends SingleExpressionContext {
		public TerminalNode New() { return getToken(JavaScriptParser.New, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NewExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitNewExpression(this);
		}
	}
	public static class MetaExpressionContext extends SingleExpressionContext {
		public TerminalNode New() { return getToken(JavaScriptParser.New, 0); }
		public TerminalNode Dot() { return getToken(JavaScriptParser.Dot, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MetaExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterMetaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitMetaExpression(this);
		}
	}
	public static class LiteralExpressionContext extends SingleExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitLiteralExpression(this);
		}
	}
	public static class ArrayLiteralExpressionContext extends SingleExpressionContext {
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ArrayLiteralExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrayLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrayLiteralExpression(this);
		}
	}
	public static class ClassExpressionContext extends SingleExpressionContext {
		public TerminalNode Class() { return getToken(JavaScriptParser.Class, 0); }
		public ClassTailContext classTail() {
			return getRuleContext(ClassTailContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterClassExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitClassExpression(this);
		}
	}
	public static class GenericExpressionContext extends SingleExpressionContext {
		public TerminalNode Delete() { return getToken(JavaScriptParser.Delete, 0); }
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TerminalNode Void() { return getToken(JavaScriptParser.Void, 0); }
		public TerminalNode Typeof() { return getToken(JavaScriptParser.Typeof, 0); }
		public TerminalNode PlusPlus() { return getToken(JavaScriptParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(JavaScriptParser.MinusMinus, 0); }
		public TerminalNode Plus() { return getToken(JavaScriptParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(JavaScriptParser.Minus, 0); }
		public TerminalNode BitNot() { return getToken(JavaScriptParser.BitNot, 0); }
		public TerminalNode Not() { return getToken(JavaScriptParser.Not, 0); }
		public TerminalNode Await() { return getToken(JavaScriptParser.Await, 0); }
		public TerminalNode Power() { return getToken(JavaScriptParser.Power, 0); }
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(JavaScriptParser.Divide, 0); }
		public TerminalNode Modulus() { return getToken(JavaScriptParser.Modulus, 0); }
		public TerminalNode NullCoalesce() { return getToken(JavaScriptParser.NullCoalesce, 0); }
		public TerminalNode LeftShiftArithmetic() { return getToken(JavaScriptParser.LeftShiftArithmetic, 0); }
		public TerminalNode RightShiftArithmetic() { return getToken(JavaScriptParser.RightShiftArithmetic, 0); }
		public TerminalNode RightShiftLogical() { return getToken(JavaScriptParser.RightShiftLogical, 0); }
		public TerminalNode LessThan() { return getToken(JavaScriptParser.LessThan, 0); }
		public TerminalNode MoreThan() { return getToken(JavaScriptParser.MoreThan, 0); }
		public TerminalNode LessThanEquals() { return getToken(JavaScriptParser.LessThanEquals, 0); }
		public TerminalNode GreaterThanEquals() { return getToken(JavaScriptParser.GreaterThanEquals, 0); }
		public TerminalNode Instanceof() { return getToken(JavaScriptParser.Instanceof, 0); }
		public TerminalNode In() { return getToken(JavaScriptParser.In, 0); }
		public TerminalNode Equals_() { return getToken(JavaScriptParser.Equals_, 0); }
		public TerminalNode NotEquals() { return getToken(JavaScriptParser.NotEquals, 0); }
		public TerminalNode IdentityEquals() { return getToken(JavaScriptParser.IdentityEquals, 0); }
		public TerminalNode IdentityNotEquals() { return getToken(JavaScriptParser.IdentityNotEquals, 0); }
		public TerminalNode BitAnd() { return getToken(JavaScriptParser.BitAnd, 0); }
		public TerminalNode BitXOr() { return getToken(JavaScriptParser.BitXOr, 0); }
		public TerminalNode BitOr() { return getToken(JavaScriptParser.BitOr, 0); }
		public TerminalNode And() { return getToken(JavaScriptParser.And, 0); }
		public TerminalNode Or() { return getToken(JavaScriptParser.Or, 0); }
		public TerminalNode QuestionMark() { return getToken(JavaScriptParser.QuestionMark, 0); }
		public TerminalNode Colon() { return getToken(JavaScriptParser.Colon, 0); }
		public GenericExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterGenericExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitGenericExpression(this);
		}
	}
	public static class MemberIndexExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode OpenBracket() { return getToken(JavaScriptParser.OpenBracket, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode CloseBracket() { return getToken(JavaScriptParser.CloseBracket, 0); }
		public MemberIndexExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterMemberIndexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitMemberIndexExpression(this);
		}
	}
	public static class FunctionCallExpressionContext extends SingleExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionCallExpression(this);
		}
	}
	public static class IdentifierExpressionContext extends SingleExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitIdentifierExpression(this);
		}
	}
	public static class ArgumentsExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public List<TerminalNode> Dot() { return getTokens(JavaScriptParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(JavaScriptParser.Dot, i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public List<AttributeAccessContext> attributeAccess() {
			return getRuleContexts(AttributeAccessContext.class);
		}
		public AttributeAccessContext attributeAccess(int i) {
			return getRuleContext(AttributeAccessContext.class,i);
		}
		public ArgumentsExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArgumentsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArgumentsExpression(this);
		}
	}
	public static class ThisExpressionContext extends SingleExpressionContext {
		public TerminalNode This() { return getToken(JavaScriptParser.This, 0); }
		public ThisExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterThisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitThisExpression(this);
		}
	}
	public static class FunctionExpressionContext extends SingleExpressionContext {
		public AnoymousFunctionContext anoymousFunction() {
			return getRuleContext(AnoymousFunctionContext.class,0);
		}
		public FunctionExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionExpression(this);
		}
	}
	public static class AssignmentExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(JavaScriptParser.Assign, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAssignmentExpression(this);
		}
	}
	public static class ImportExpressionContext extends SingleExpressionContext {
		public TerminalNode Import() { return getToken(JavaScriptParser.Import, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public ImportExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterImportExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitImportExpression(this);
		}
	}
	public static class SuperExpressionContext extends SingleExpressionContext {
		public TerminalNode Super() { return getToken(JavaScriptParser.Super, 0); }
		public SuperExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterSuperExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitSuperExpression(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		return singleExpression(0);
	}

	private SingleExpressionContext singleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, _parentState);
		SingleExpressionContext _prevctx = _localctx;
		int _startState = 120;
		enterRecursionRule(_localctx, 120, RULE_singleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(763);
				anoymousFunction();
				}
				break;
			case 2:
				{
				_localctx = new ClassExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(764);
				match(Class);
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(765);
					identifier();
					}
				}

				setState(768);
				classTail();
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(769);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(770);
				match(New);
				setState(771);
				singleExpression(0);
				setState(773);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(772);
					arguments();
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new MetaExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(775);
				match(New);
				setState(776);
				match(Dot);
				setState(777);
				identifier();
				}
				break;
			case 6:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(778);
				match(Delete);
				setState(779);
				singleExpression(37);
				}
				break;
			case 7:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(780);
				match(Void);
				setState(781);
				singleExpression(36);
				}
				break;
			case 8:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(782);
				match(Typeof);
				setState(783);
				singleExpression(35);
				}
				break;
			case 9:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(784);
				match(PlusPlus);
				setState(785);
				singleExpression(34);
				}
				break;
			case 10:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(786);
				match(MinusMinus);
				setState(787);
				singleExpression(33);
				}
				break;
			case 11:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(788);
				match(Plus);
				setState(789);
				singleExpression(32);
				}
				break;
			case 12:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(790);
				match(Minus);
				setState(791);
				singleExpression(31);
				}
				break;
			case 13:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(792);
				match(BitNot);
				setState(793);
				singleExpression(30);
				}
				break;
			case 14:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(794);
				match(Not);
				setState(795);
				singleExpression(29);
				}
				break;
			case 15:
				{
				_localctx = new GenericExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(796);
				match(Await);
				setState(797);
				singleExpression(28);
				}
				break;
			case 16:
				{
				_localctx = new ImportExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(798);
				match(Import);
				setState(799);
				match(OpenParen);
				setState(800);
				singleExpression(0);
				setState(801);
				match(CloseParen);
				}
				break;
			case 17:
				{
				_localctx = new YieldExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(803);
				yieldStatement();
				}
				break;
			case 18:
				{
				_localctx = new ThisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(804);
				match(This);
				}
				break;
			case 19:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(805);
				identifier();
				}
				break;
			case 20:
				{
				_localctx = new SuperExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(806);
				match(Super);
				}
				break;
			case 21:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(807);
				literal();
				}
				break;
			case 22:
				{
				_localctx = new ArrayLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(808);
				arrayLiteral();
				}
				break;
			case 23:
				{
				_localctx = new ObjectLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(809);
				objectLiteral();
				}
				break;
			case 24:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(810);
				match(OpenParen);
				setState(811);
				expressionSequence();
				setState(812);
				match(CloseParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(896);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(894);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(816);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(817);
						match(Power);
						setState(818);
						singleExpression(27);
						}
						break;
					case 2:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(819);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(820);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(821);
						singleExpression(27);
						}
						break;
					case 3:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(822);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(823);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(824);
						singleExpression(26);
						}
						break;
					case 4:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(825);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(826);
						match(NullCoalesce);
						setState(827);
						singleExpression(25);
						}
						break;
					case 5:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(828);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(829);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RightShiftArithmetic) | (1L << LeftShiftArithmetic) | (1L << RightShiftLogical))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(830);
						singleExpression(24);
						}
						break;
					case 6:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(831);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(832);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LessThan) | (1L << MoreThan) | (1L << LessThanEquals) | (1L << GreaterThanEquals))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(833);
						singleExpression(23);
						}
						break;
					case 7:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(834);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(835);
						match(Instanceof);
						setState(836);
						singleExpression(22);
						}
						break;
					case 8:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(837);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(838);
						match(In);
						setState(839);
						singleExpression(21);
						}
						break;
					case 9:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(840);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(841);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equals_) | (1L << NotEquals) | (1L << IdentityEquals) | (1L << IdentityNotEquals))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(842);
						singleExpression(20);
						}
						break;
					case 10:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(843);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(844);
						match(BitAnd);
						setState(845);
						singleExpression(19);
						}
						break;
					case 11:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(846);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(847);
						match(BitXOr);
						setState(848);
						singleExpression(18);
						}
						break;
					case 12:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(849);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(850);
						match(BitOr);
						setState(851);
						singleExpression(17);
						}
						break;
					case 13:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(852);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(853);
						match(And);
						setState(854);
						singleExpression(16);
						}
						break;
					case 14:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(855);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(856);
						match(Or);
						setState(857);
						singleExpression(15);
						}
						break;
					case 15:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(858);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(859);
						match(QuestionMark);
						setState(860);
						singleExpression(0);
						setState(861);
						match(Colon);
						setState(862);
						singleExpression(14);
						}
						break;
					case 16:
						{
						_localctx = new AssignmentExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(864);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(865);
						match(Assign);
						setState(866);
						singleExpression(12);
						}
						break;
					case 17:
						{
						_localctx = new AssignmentExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(867);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(868);
						assignmentOperator();
						setState(869);
						singleExpression(11);
						}
						break;
					case 18:
						{
						_localctx = new MemberIndexExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(871);
						if (!(precpred(_ctx, 44))) throw new FailedPredicateException(this, "precpred(_ctx, 44)");
						setState(872);
						match(OpenBracket);
						setState(873);
						expressionSequence();
						setState(874);
						match(CloseBracket);
						}
						break;
					case 19:
						{
						_localctx = new ArgumentsExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(876);
						if (!(precpred(_ctx, 43))) throw new FailedPredicateException(this, "precpred(_ctx, 43)");
						setState(882); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(877);
								match(Dot);
								setState(880);
								_errHandler.sync(this);
								switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
								case 1:
									{
									setState(878);
									functionCall();
									}
									break;
								case 2:
									{
									setState(879);
									attributeAccess();
									}
									break;
								}
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(884); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 20:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(886);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(887);
						if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
						setState(888);
						match(PlusPlus);
						}
						break;
					case 21:
						{
						_localctx = new GenericExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(889);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(890);
						if (!(this.notLineTerminator())) throw new FailedPredicateException(this, "this.notLineTerminator()");
						setState(891);
						match(MinusMinus);
						}
						break;
					case 22:
						{
						_localctx = new TemplateStringExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(892);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(893);
						match(TemplateStringLiteral);
						}
						break;
					}
					} 
				}
				setState(898);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			identifier();
			setState(900);
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

	public static class AttributeAccessContext extends ParserRuleContext {
		public IdentifierNameContext identifierName() {
			return getRuleContext(IdentifierNameContext.class,0);
		}
		public TerminalNode Hashtag() { return getToken(JavaScriptParser.Hashtag, 0); }
		public AttributeAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAttributeAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAttributeAccess(this);
		}
	}

	public final AttributeAccessContext attributeAccess() throws RecognitionException {
		AttributeAccessContext _localctx = new AttributeAccessContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_attributeAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Hashtag) {
				{
				setState(902);
				match(Hashtag);
				}
			}

			setState(905);
			identifierName();
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

	public static class AssignableContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_assignable);
		try {
			setState(910);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Async:
			case NonStrictLet:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(907);
				identifier();
				}
				break;
			case OpenBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(908);
				arrayLiteral();
				}
				break;
			case OpenBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(909);
				objectLiteral();
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

	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public List<PropertyAssignmentContext> propertyAssignment() {
			return getRuleContexts(PropertyAssignmentContext.class);
		}
		public PropertyAssignmentContext propertyAssignment(int i) {
			return getRuleContext(PropertyAssignmentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(JavaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(JavaScriptParser.Comma, i);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitObjectLiteral(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_objectLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
			match(OpenBrace);
			setState(921);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(913);
				propertyAssignment();
				setState(918);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(914);
						match(Comma);
						setState(915);
						propertyAssignment();
						}
						} 
					}
					setState(920);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				}
				break;
			}
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(923);
				match(Comma);
				}
			}

			setState(926);
			match(CloseBrace);
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

	public static class AnoymousFunctionContext extends ParserRuleContext {
		public AnoymousFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anoymousFunction; }
	 
		public AnoymousFunctionContext() { }
		public void copyFrom(AnoymousFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnoymousFunctionDeclContext extends AnoymousFunctionContext {
		public TerminalNode Function() { return getToken(JavaScriptParser.Function, 0); }
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public TerminalNode Multiply() { return getToken(JavaScriptParser.Multiply, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public AnoymousFunctionDeclContext(AnoymousFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAnoymousFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAnoymousFunctionDecl(this);
		}
	}
	public static class ArrowFunctionContext extends AnoymousFunctionContext {
		public ArrowFunctionParametersContext arrowFunctionParameters() {
			return getRuleContext(ArrowFunctionParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(JavaScriptParser.ARROW, 0); }
		public ArrowFunctionBodyContext arrowFunctionBody() {
			return getRuleContext(ArrowFunctionBodyContext.class,0);
		}
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public ArrowFunctionContext(AnoymousFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrowFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrowFunction(this);
		}
	}
	public static class FunctionDeclContext extends AnoymousFunctionContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public FunctionDeclContext(AnoymousFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitFunctionDecl(this);
		}
	}

	public final AnoymousFunctionContext anoymousFunction() throws RecognitionException {
		AnoymousFunctionContext _localctx = new AnoymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_anoymousFunction);
		int _la;
		try {
			setState(952);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				_localctx = new FunctionDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(928);
				functionDeclaration();
				}
				break;
			case 2:
				_localctx = new AnoymousFunctionDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(930);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Async) {
					{
					setState(929);
					match(Async);
					}
				}

				setState(932);
				match(Function);
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Multiply) {
					{
					setState(933);
					match(Multiply);
					}
				}

				setState(936);
				match(OpenParen);
				setState(938);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(937);
					formalParameterList();
					}
				}

				setState(940);
				match(CloseParen);
				setState(941);
				match(OpenBrace);
				setState(942);
				functionBody();
				setState(943);
				match(CloseBrace);
				}
				break;
			case 3:
				_localctx = new ArrowFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(946);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(945);
					match(Async);
					}
					break;
				}
				setState(948);
				arrowFunctionParameters();
				setState(949);
				match(ARROW);
				setState(950);
				arrowFunctionBody();
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

	public static class ArrowFunctionParametersContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(JavaScriptParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(JavaScriptParser.CloseParen, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ArrowFunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowFunctionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrowFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrowFunctionParameters(this);
		}
	}

	public final ArrowFunctionParametersContext arrowFunctionParameters() throws RecognitionException {
		ArrowFunctionParametersContext _localctx = new ArrowFunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_arrowFunctionParameters);
		int _la;
		try {
			setState(960);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Async:
			case NonStrictLet:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(954);
				identifier();
				}
				break;
			case OpenParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(955);
				match(OpenParen);
				setState(957);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenBracket) | (1L << OpenBrace) | (1L << Ellipsis))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) {
					{
					setState(956);
					formalParameterList();
					}
				}

				setState(959);
				match(CloseParen);
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

	public static class ArrowFunctionBodyContext extends ParserRuleContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TerminalNode OpenBrace() { return getToken(JavaScriptParser.OpenBrace, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(JavaScriptParser.CloseBrace, 0); }
		public ArrowFunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowFunctionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterArrowFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitArrowFunctionBody(this);
		}
	}

	public final ArrowFunctionBodyContext arrowFunctionBody() throws RecognitionException {
		ArrowFunctionBodyContext _localctx = new ArrowFunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_arrowFunctionBody);
		try {
			setState(967);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(962);
				singleExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(963);
				match(OpenBrace);
				setState(964);
				functionBody();
				setState(965);
				match(CloseBrace);
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode MultiplyAssign() { return getToken(JavaScriptParser.MultiplyAssign, 0); }
		public TerminalNode DivideAssign() { return getToken(JavaScriptParser.DivideAssign, 0); }
		public TerminalNode ModulusAssign() { return getToken(JavaScriptParser.ModulusAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(JavaScriptParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(JavaScriptParser.MinusAssign, 0); }
		public TerminalNode LeftShiftArithmeticAssign() { return getToken(JavaScriptParser.LeftShiftArithmeticAssign, 0); }
		public TerminalNode RightShiftArithmeticAssign() { return getToken(JavaScriptParser.RightShiftArithmeticAssign, 0); }
		public TerminalNode RightShiftLogicalAssign() { return getToken(JavaScriptParser.RightShiftLogicalAssign, 0); }
		public TerminalNode BitAndAssign() { return getToken(JavaScriptParser.BitAndAssign, 0); }
		public TerminalNode BitXorAssign() { return getToken(JavaScriptParser.BitXorAssign, 0); }
		public TerminalNode BitOrAssign() { return getToken(JavaScriptParser.BitOrAssign, 0); }
		public TerminalNode PowerAssign() { return getToken(JavaScriptParser.PowerAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MultiplyAssign) | (1L << DivideAssign) | (1L << ModulusAssign) | (1L << PlusAssign) | (1L << MinusAssign) | (1L << LeftShiftArithmeticAssign) | (1L << RightShiftArithmeticAssign) | (1L << RightShiftLogicalAssign) | (1L << BitAndAssign) | (1L << BitXorAssign) | (1L << BitOrAssign) | (1L << PowerAssign))) != 0)) ) {
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NullLiteral() { return getToken(JavaScriptParser.NullLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(JavaScriptParser.BooleanLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(JavaScriptParser.StringLiteral, 0); }
		public TerminalNode TemplateStringLiteral() { return getToken(JavaScriptParser.TemplateStringLiteral, 0); }
		public TerminalNode RegularExpressionLiteral() { return getToken(JavaScriptParser.RegularExpressionLiteral, 0); }
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public BigintLiteralContext bigintLiteral() {
			return getRuleContext(BigintLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_literal);
		try {
			setState(978);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NullLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(971);
				match(NullLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(972);
				match(BooleanLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(973);
				match(StringLiteral);
				}
				break;
			case TemplateStringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(974);
				match(TemplateStringLiteral);
				}
				break;
			case RegularExpressionLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(975);
				match(RegularExpressionLiteral);
				}
				break;
			case DecimalLiteral:
			case HexIntegerLiteral:
			case OctalIntegerLiteral:
			case OctalIntegerLiteral2:
			case BinaryIntegerLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(976);
				numericLiteral();
				}
				break;
			case BigHexIntegerLiteral:
			case BigOctalIntegerLiteral:
			case BigBinaryIntegerLiteral:
			case BigDecimalIntegerLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(977);
				bigintLiteral();
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

	public static class NumericLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalLiteral() { return getToken(JavaScriptParser.DecimalLiteral, 0); }
		public TerminalNode HexIntegerLiteral() { return getToken(JavaScriptParser.HexIntegerLiteral, 0); }
		public TerminalNode OctalIntegerLiteral() { return getToken(JavaScriptParser.OctalIntegerLiteral, 0); }
		public TerminalNode OctalIntegerLiteral2() { return getToken(JavaScriptParser.OctalIntegerLiteral2, 0); }
		public TerminalNode BinaryIntegerLiteral() { return getToken(JavaScriptParser.BinaryIntegerLiteral, 0); }
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitNumericLiteral(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_numericLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (DecimalLiteral - 61)) | (1L << (HexIntegerLiteral - 61)) | (1L << (OctalIntegerLiteral - 61)) | (1L << (OctalIntegerLiteral2 - 61)) | (1L << (BinaryIntegerLiteral - 61)))) != 0)) ) {
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

	public static class BigintLiteralContext extends ParserRuleContext {
		public TerminalNode BigDecimalIntegerLiteral() { return getToken(JavaScriptParser.BigDecimalIntegerLiteral, 0); }
		public TerminalNode BigHexIntegerLiteral() { return getToken(JavaScriptParser.BigHexIntegerLiteral, 0); }
		public TerminalNode BigOctalIntegerLiteral() { return getToken(JavaScriptParser.BigOctalIntegerLiteral, 0); }
		public TerminalNode BigBinaryIntegerLiteral() { return getToken(JavaScriptParser.BigBinaryIntegerLiteral, 0); }
		public BigintLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bigintLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterBigintLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitBigintLiteral(this);
		}
	}

	public final BigintLiteralContext bigintLiteral() throws RecognitionException {
		BigintLiteralContext _localctx = new BigintLiteralContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_bigintLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (BigHexIntegerLiteral - 66)) | (1L << (BigOctalIntegerLiteral - 66)) | (1L << (BigBinaryIntegerLiteral - 66)) | (1L << (BigDecimalIntegerLiteral - 66)))) != 0)) ) {
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

	public static class GetterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public GetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitGetter(this);
		}
	}

	public final GetterContext getter() throws RecognitionException {
		GetterContext _localctx = new GetterContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_getter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			if (!(this.n("get"))) throw new FailedPredicateException(this, "this.n(\"get\")");
			setState(985);
			identifier();
			setState(986);
			propertyName();
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

	public static class SetterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public SetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterSetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitSetter(this);
		}
	}

	public final SetterContext setter() throws RecognitionException {
		SetterContext _localctx = new SetterContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_setter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			if (!(this.n("set"))) throw new FailedPredicateException(this, "this.n(\"set\")");
			setState(989);
			identifier();
			setState(990);
			propertyName();
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

	public static class IdentifierNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ReservedWordContext reservedWord() {
			return getRuleContext(ReservedWordContext.class,0);
		}
		public IdentifierNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterIdentifierName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitIdentifierName(this);
		}
	}

	public final IdentifierNameContext identifierName() throws RecognitionException {
		IdentifierNameContext _localctx = new IdentifierNameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_identifierName);
		try {
			setState(994);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(992);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(993);
				reservedWord();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaScriptParser.Identifier, 0); }
		public TerminalNode NonStrictLet() { return getToken(JavaScriptParser.NonStrictLet, 0); }
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(996);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Async - 105)) | (1L << (NonStrictLet - 105)) | (1L << (Identifier - 105)))) != 0)) ) {
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

	public static class ReservedWordContext extends ParserRuleContext {
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode NullLiteral() { return getToken(JavaScriptParser.NullLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(JavaScriptParser.BooleanLiteral, 0); }
		public ReservedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reservedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterReservedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitReservedWord(this);
		}
	}

	public final ReservedWordContext reservedWord() throws RecognitionException {
		ReservedWordContext _localctx = new ReservedWordContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_reservedWord);
		try {
			setState(1001);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
			case Do:
			case Instanceof:
			case Typeof:
			case Case:
			case Else:
			case New:
			case Var:
			case Catch:
			case Finally:
			case Return:
			case Void:
			case Continue:
			case For:
			case Switch:
			case While:
			case Debugger:
			case Function:
			case This:
			case With:
			case Default:
			case If:
			case Throw:
			case Delete:
			case In:
			case Try:
			case As:
			case From:
			case Class:
			case Enum:
			case Extends:
			case Super:
			case Const:
			case Export:
			case Import:
			case Async:
			case Await:
			case Implements:
			case StrictLet:
			case NonStrictLet:
			case Private:
			case Public:
			case Interface:
			case Package:
			case Protected:
			case Static:
			case Yield:
				enterOuterAlt(_localctx, 1);
				{
				setState(998);
				keyword();
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(999);
				match(NullLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(1000);
				match(BooleanLiteral);
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(JavaScriptParser.Break, 0); }
		public TerminalNode Do() { return getToken(JavaScriptParser.Do, 0); }
		public TerminalNode Instanceof() { return getToken(JavaScriptParser.Instanceof, 0); }
		public TerminalNode Typeof() { return getToken(JavaScriptParser.Typeof, 0); }
		public TerminalNode Case() { return getToken(JavaScriptParser.Case, 0); }
		public TerminalNode Else() { return getToken(JavaScriptParser.Else, 0); }
		public TerminalNode New() { return getToken(JavaScriptParser.New, 0); }
		public TerminalNode Var() { return getToken(JavaScriptParser.Var, 0); }
		public TerminalNode Catch() { return getToken(JavaScriptParser.Catch, 0); }
		public TerminalNode Finally() { return getToken(JavaScriptParser.Finally, 0); }
		public TerminalNode Return() { return getToken(JavaScriptParser.Return, 0); }
		public TerminalNode Void() { return getToken(JavaScriptParser.Void, 0); }
		public TerminalNode Continue() { return getToken(JavaScriptParser.Continue, 0); }
		public TerminalNode For() { return getToken(JavaScriptParser.For, 0); }
		public TerminalNode Switch() { return getToken(JavaScriptParser.Switch, 0); }
		public TerminalNode While() { return getToken(JavaScriptParser.While, 0); }
		public TerminalNode Debugger() { return getToken(JavaScriptParser.Debugger, 0); }
		public TerminalNode Function() { return getToken(JavaScriptParser.Function, 0); }
		public TerminalNode This() { return getToken(JavaScriptParser.This, 0); }
		public TerminalNode With() { return getToken(JavaScriptParser.With, 0); }
		public TerminalNode Default() { return getToken(JavaScriptParser.Default, 0); }
		public TerminalNode If() { return getToken(JavaScriptParser.If, 0); }
		public TerminalNode Throw() { return getToken(JavaScriptParser.Throw, 0); }
		public TerminalNode Delete() { return getToken(JavaScriptParser.Delete, 0); }
		public TerminalNode In() { return getToken(JavaScriptParser.In, 0); }
		public TerminalNode Try() { return getToken(JavaScriptParser.Try, 0); }
		public TerminalNode Class() { return getToken(JavaScriptParser.Class, 0); }
		public TerminalNode Enum() { return getToken(JavaScriptParser.Enum, 0); }
		public TerminalNode Extends() { return getToken(JavaScriptParser.Extends, 0); }
		public TerminalNode Super() { return getToken(JavaScriptParser.Super, 0); }
		public TerminalNode Const() { return getToken(JavaScriptParser.Const, 0); }
		public TerminalNode Export() { return getToken(JavaScriptParser.Export, 0); }
		public TerminalNode Import() { return getToken(JavaScriptParser.Import, 0); }
		public TerminalNode Implements() { return getToken(JavaScriptParser.Implements, 0); }
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public TerminalNode Private() { return getToken(JavaScriptParser.Private, 0); }
		public TerminalNode Public() { return getToken(JavaScriptParser.Public, 0); }
		public TerminalNode Interface() { return getToken(JavaScriptParser.Interface, 0); }
		public TerminalNode Package() { return getToken(JavaScriptParser.Package, 0); }
		public TerminalNode Protected() { return getToken(JavaScriptParser.Protected, 0); }
		public TerminalNode Static() { return getToken(JavaScriptParser.Static, 0); }
		public TerminalNode Yield() { return getToken(JavaScriptParser.Yield, 0); }
		public TerminalNode Async() { return getToken(JavaScriptParser.Async, 0); }
		public TerminalNode Await() { return getToken(JavaScriptParser.Await, 0); }
		public TerminalNode From() { return getToken(JavaScriptParser.From, 0); }
		public TerminalNode As() { return getToken(JavaScriptParser.As, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_keyword);
		try {
			setState(1049);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				enterOuterAlt(_localctx, 1);
				{
				setState(1003);
				match(Break);
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(1004);
				match(Do);
				}
				break;
			case Instanceof:
				enterOuterAlt(_localctx, 3);
				{
				setState(1005);
				match(Instanceof);
				}
				break;
			case Typeof:
				enterOuterAlt(_localctx, 4);
				{
				setState(1006);
				match(Typeof);
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 5);
				{
				setState(1007);
				match(Case);
				}
				break;
			case Else:
				enterOuterAlt(_localctx, 6);
				{
				setState(1008);
				match(Else);
				}
				break;
			case New:
				enterOuterAlt(_localctx, 7);
				{
				setState(1009);
				match(New);
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 8);
				{
				setState(1010);
				match(Var);
				}
				break;
			case Catch:
				enterOuterAlt(_localctx, 9);
				{
				setState(1011);
				match(Catch);
				}
				break;
			case Finally:
				enterOuterAlt(_localctx, 10);
				{
				setState(1012);
				match(Finally);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 11);
				{
				setState(1013);
				match(Return);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 12);
				{
				setState(1014);
				match(Void);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 13);
				{
				setState(1015);
				match(Continue);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 14);
				{
				setState(1016);
				match(For);
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 15);
				{
				setState(1017);
				match(Switch);
				}
				break;
			case While:
				enterOuterAlt(_localctx, 16);
				{
				setState(1018);
				match(While);
				}
				break;
			case Debugger:
				enterOuterAlt(_localctx, 17);
				{
				setState(1019);
				match(Debugger);
				}
				break;
			case Function:
				enterOuterAlt(_localctx, 18);
				{
				setState(1020);
				match(Function);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 19);
				{
				setState(1021);
				match(This);
				}
				break;
			case With:
				enterOuterAlt(_localctx, 20);
				{
				setState(1022);
				match(With);
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 21);
				{
				setState(1023);
				match(Default);
				}
				break;
			case If:
				enterOuterAlt(_localctx, 22);
				{
				setState(1024);
				match(If);
				}
				break;
			case Throw:
				enterOuterAlt(_localctx, 23);
				{
				setState(1025);
				match(Throw);
				}
				break;
			case Delete:
				enterOuterAlt(_localctx, 24);
				{
				setState(1026);
				match(Delete);
				}
				break;
			case In:
				enterOuterAlt(_localctx, 25);
				{
				setState(1027);
				match(In);
				}
				break;
			case Try:
				enterOuterAlt(_localctx, 26);
				{
				setState(1028);
				match(Try);
				}
				break;
			case Class:
				enterOuterAlt(_localctx, 27);
				{
				setState(1029);
				match(Class);
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 28);
				{
				setState(1030);
				match(Enum);
				}
				break;
			case Extends:
				enterOuterAlt(_localctx, 29);
				{
				setState(1031);
				match(Extends);
				}
				break;
			case Super:
				enterOuterAlt(_localctx, 30);
				{
				setState(1032);
				match(Super);
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 31);
				{
				setState(1033);
				match(Const);
				}
				break;
			case Export:
				enterOuterAlt(_localctx, 32);
				{
				setState(1034);
				match(Export);
				}
				break;
			case Import:
				enterOuterAlt(_localctx, 33);
				{
				setState(1035);
				match(Import);
				}
				break;
			case Implements:
				enterOuterAlt(_localctx, 34);
				{
				setState(1036);
				match(Implements);
				}
				break;
			case StrictLet:
			case NonStrictLet:
				enterOuterAlt(_localctx, 35);
				{
				setState(1037);
				let();
				}
				break;
			case Private:
				enterOuterAlt(_localctx, 36);
				{
				setState(1038);
				match(Private);
				}
				break;
			case Public:
				enterOuterAlt(_localctx, 37);
				{
				setState(1039);
				match(Public);
				}
				break;
			case Interface:
				enterOuterAlt(_localctx, 38);
				{
				setState(1040);
				match(Interface);
				}
				break;
			case Package:
				enterOuterAlt(_localctx, 39);
				{
				setState(1041);
				match(Package);
				}
				break;
			case Protected:
				enterOuterAlt(_localctx, 40);
				{
				setState(1042);
				match(Protected);
				}
				break;
			case Static:
				enterOuterAlt(_localctx, 41);
				{
				setState(1043);
				match(Static);
				}
				break;
			case Yield:
				enterOuterAlt(_localctx, 42);
				{
				setState(1044);
				match(Yield);
				}
				break;
			case Async:
				enterOuterAlt(_localctx, 43);
				{
				setState(1045);
				match(Async);
				}
				break;
			case Await:
				enterOuterAlt(_localctx, 44);
				{
				setState(1046);
				match(Await);
				}
				break;
			case From:
				enterOuterAlt(_localctx, 45);
				{
				setState(1047);
				match(From);
				}
				break;
			case As:
				enterOuterAlt(_localctx, 46);
				{
				setState(1048);
				match(As);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode NonStrictLet() { return getToken(JavaScriptParser.NonStrictLet, 0); }
		public TerminalNode StrictLet() { return getToken(JavaScriptParser.StrictLet, 0); }
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitLet(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1051);
			_la = _input.LA(1);
			if ( !(_la==StrictLet || _la==NonStrictLet) ) {
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

	public static class EosContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(JavaScriptParser.SemiColon, 0); }
		public TerminalNode EOF() { return getToken(JavaScriptParser.EOF, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaScriptParserListener ) ((JavaScriptParserListener)listener).exitEos(this);
		}
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_eos);
		try {
			setState(1057);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1053);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1054);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1055);
				if (!(this.lineTerminatorAhead())) throw new FailedPredicateException(this, "this.lineTerminatorAhead()");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1056);
				if (!(this.closeBrace())) throw new FailedPredicateException(this, "this.closeBrace()");
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
		case 19:
			return expressionStatement_sempred((ExpressionStatementContext)_localctx, predIndex);
		case 23:
			return iterationStatement_sempred((IterationStatementContext)_localctx, predIndex);
		case 25:
			return continueStatement_sempred((ContinueStatementContext)_localctx, predIndex);
		case 26:
			return breakStatement_sempred((BreakStatementContext)_localctx, predIndex);
		case 27:
			return returnStatement_sempred((ReturnStatementContext)_localctx, predIndex);
		case 28:
			return yieldStatement_sempred((YieldStatementContext)_localctx, predIndex);
		case 36:
			return throwStatement_sempred((ThrowStatementContext)_localctx, predIndex);
		case 44:
			return classElement_sempred((ClassElementContext)_localctx, predIndex);
		case 60:
			return singleExpression_sempred((SingleExpressionContext)_localctx, predIndex);
		case 72:
			return getter_sempred((GetterContext)_localctx, predIndex);
		case 73:
			return setter_sempred((SetterContext)_localctx, predIndex);
		case 79:
			return eos_sempred((EosContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressionStatement_sempred(ExpressionStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return this.notOpenBraceAndNotFunction();
		}
		return true;
	}
	private boolean iterationStatement_sempred(IterationStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return this.p("of");
		}
		return true;
	}
	private boolean continueStatement_sempred(ContinueStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return this.notLineTerminator();
		}
		return true;
	}
	private boolean breakStatement_sempred(BreakStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return this.notLineTerminator();
		}
		return true;
	}
	private boolean returnStatement_sempred(ReturnStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return this.notLineTerminator();
		}
		return true;
	}
	private boolean yieldStatement_sempred(YieldStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return this.notLineTerminator();
		}
		return true;
	}
	private boolean throwStatement_sempred(ThrowStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return this.notLineTerminator();
		}
		return true;
	}
	private boolean classElement_sempred(ClassElementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return this.n("static");
		}
		return true;
	}
	private boolean singleExpression_sempred(SingleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 27);
		case 9:
			return precpred(_ctx, 26);
		case 10:
			return precpred(_ctx, 25);
		case 11:
			return precpred(_ctx, 24);
		case 12:
			return precpred(_ctx, 23);
		case 13:
			return precpred(_ctx, 22);
		case 14:
			return precpred(_ctx, 21);
		case 15:
			return precpred(_ctx, 20);
		case 16:
			return precpred(_ctx, 19);
		case 17:
			return precpred(_ctx, 18);
		case 18:
			return precpred(_ctx, 17);
		case 19:
			return precpred(_ctx, 16);
		case 20:
			return precpred(_ctx, 15);
		case 21:
			return precpred(_ctx, 14);
		case 22:
			return precpred(_ctx, 13);
		case 23:
			return precpred(_ctx, 12);
		case 24:
			return precpred(_ctx, 11);
		case 25:
			return precpred(_ctx, 44);
		case 26:
			return precpred(_ctx, 43);
		case 27:
			return precpred(_ctx, 39);
		case 28:
			return this.notLineTerminator();
		case 29:
			return precpred(_ctx, 38);
		case 30:
			return this.notLineTerminator();
		case 31:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean getter_sempred(GetterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return this.n("get");
		}
		return true;
	}
	private boolean setter_sempred(SetterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 33:
			return this.n("set");
		}
		return true;
	}
	private boolean eos_sempred(EosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 34:
			return this.lineTerminatorAhead();
		case 35:
			return this.closeBrace();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3~\u0426\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\5\2\u00a4\n\2"+
		"\3\2\5\2\u00a7\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00c1\n\4\3\5\3\5\5\5"+
		"\u00c5\n\5\3\5\3\5\3\6\6\6\u00ca\n\6\r\6\16\6\u00cb\3\7\3\7\3\7\3\b\5"+
		"\b\u00d2\n\b\3\b\3\b\5\b\u00d6\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u00dd\n\b\3"+
		"\t\3\t\3\t\3\t\7\t\u00e3\n\t\f\t\16\t\u00e6\13\t\3\t\3\t\5\t\u00ea\n\t"+
		"\5\t\u00ec\n\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\5\13\u00f5\n\13\3\13\3\13"+
		"\5\13\u00f9\n\13\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0101\n\r\3\16\3\16\3\16"+
		"\5\16\u0106\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u010f\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u0117\n\17\3\17\3\17\5\17\u011b\n\17"+
		"\3\20\3\20\3\20\5\20\u0120\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22"+
		"\u0129\n\22\f\22\16\22\u012c\13\22\3\23\3\23\3\23\5\23\u0131\n\23\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u013f\n\26"+
		"\f\26\16\26\u0142\13\26\3\26\5\26\u0145\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0163\n\31\3\31\3\31"+
		"\5\31\u0167\n\31\3\31\3\31\5\31\u016b\n\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u0173\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u017c\n\31"+
		"\3\31\3\31\3\31\5\31\u0181\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0189"+
		"\n\31\3\32\3\32\3\32\5\32\u018e\n\32\3\33\3\33\3\33\5\33\u0193\n\33\3"+
		"\33\3\33\3\34\3\34\3\34\5\34\u019a\n\34\3\34\3\34\3\35\3\35\3\35\5\35"+
		"\u01a1\n\35\3\35\3\35\3\36\3\36\3\36\5\36\u01a8\n\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\5!\u01ba\n!\3!\3!\5!\u01be"+
		"\n!\5!\u01c0\n!\3!\3!\3\"\6\"\u01c5\n\"\r\"\16\"\u01c6\3#\3#\3#\3#\5#"+
		"\u01cd\n#\3$\3$\3$\5$\u01d2\n$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\5\'\u01e1\n\'\3\'\5\'\u01e4\n\'\3(\3(\3(\5(\u01e9\n(\3(\5(\u01ec"+
		"\n(\3(\3(\3)\3)\3)\3*\3*\3*\3+\5+\u01f7\n+\3+\3+\5+\u01fb\n+\3+\3+\3+"+
		"\5+\u0200\n+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\5-\u020d\n-\3-\3-\7-\u0211"+
		"\n-\f-\16-\u0214\13-\3-\3-\3.\3.\3.\3.\7.\u021c\n.\f.\16.\u021f\13.\3"+
		".\3.\3.\3.\3.\3.\5.\u0227\n.\3.\3.\3.\3.\3.\5.\u022e\n.\3/\5/\u0231\n"+
		"/\3/\3/\3\60\5\60\u0236\n\60\3\60\5\60\u0239\n\60\3\60\3\60\3\60\5\60"+
		"\u023e\n\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0246\n\60\3\60\5\60\u0249"+
		"\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0253\n\60\3\60\5\60"+
		"\u0256\n\60\3\60\3\60\3\60\5\60\u025b\n\60\3\60\3\60\3\60\3\60\3\60\5"+
		"\60\u0262\n\60\3\61\3\61\3\61\7\61\u0267\n\61\f\61\16\61\u026a\13\61\3"+
		"\61\3\61\5\61\u026e\n\61\3\61\5\61\u0271\n\61\3\62\3\62\3\62\5\62\u0276"+
		"\n\62\3\63\3\63\3\63\3\64\5\64\u027c\n\64\3\65\6\65\u027f\n\65\r\65\16"+
		"\65\u0280\3\66\3\66\3\66\3\66\3\67\7\67\u0288\n\67\f\67\16\67\u028b\13"+
		"\67\3\67\5\67\u028e\n\67\3\67\6\67\u0291\n\67\r\67\16\67\u0292\3\67\7"+
		"\67\u0296\n\67\f\67\16\67\u0299\13\67\3\67\7\67\u029c\n\67\f\67\16\67"+
		"\u029f\13\67\38\58\u02a2\n8\38\38\39\39\39\39\39\39\39\39\39\39\39\59"+
		"\u02b1\n9\39\59\u02b4\n9\39\39\39\59\u02b9\n9\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u02d0\n9\39\59\u02d3\n9\3:"+
		"\3:\3:\3:\3:\3:\3:\5:\u02dc\n:\3;\3;\3;\3;\7;\u02e2\n;\f;\16;\u02e5\13"+
		";\3;\5;\u02e8\n;\5;\u02ea\n;\3;\3;\3<\5<\u02ef\n<\3<\3<\5<\u02f3\n<\3"+
		"=\3=\3=\7=\u02f8\n=\f=\16=\u02fb\13=\3>\3>\3>\3>\5>\u0301\n>\3>\3>\3>"+
		"\3>\3>\5>\u0308\n>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>"+
		"\u0331\n>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u0373"+
		"\n>\6>\u0375\n>\r>\16>\u0376\3>\3>\3>\3>\3>\3>\3>\3>\7>\u0381\n>\f>\16"+
		">\u0384\13>\3?\3?\3?\3@\5@\u038a\n@\3@\3@\3A\3A\3A\5A\u0391\nA\3B\3B\3"+
		"B\3B\7B\u0397\nB\fB\16B\u039a\13B\5B\u039c\nB\3B\5B\u039f\nB\3B\3B\3C"+
		"\3C\5C\u03a5\nC\3C\3C\5C\u03a9\nC\3C\3C\5C\u03ad\nC\3C\3C\3C\3C\3C\3C"+
		"\5C\u03b5\nC\3C\3C\3C\3C\5C\u03bb\nC\3D\3D\3D\5D\u03c0\nD\3D\5D\u03c3"+
		"\nD\3E\3E\3E\3E\3E\5E\u03ca\nE\3F\3F\3G\3G\3G\3G\3G\3G\3G\5G\u03d5\nG"+
		"\3H\3H\3I\3I\3J\3J\3J\3J\3K\3K\3K\3K\3L\3L\5L\u03e5\nL\3M\3M\3N\3N\3N"+
		"\5N\u03ec\nN\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O"+
		"\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O"+
		"\3O\3O\3O\3O\5O\u041c\nO\3P\3P\3Q\3Q\3Q\3Q\5Q\u0424\nQ\3Q\2\3zR\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\2\f\3\2\32\34\3"+
		"\2\26\27\3\2 \"\3\2#&\3\2\'*\3\2\60;\3\2?C\3\2DG\5\2kkooww\3\2no\2\u04c7"+
		"\2\u00a3\3\2\2\2\4\u00aa\3\2\2\2\6\u00c0\3\2\2\2\b\u00c2\3\2\2\2\n\u00c9"+
		"\3\2\2\2\f\u00cd\3\2\2\2\16\u00dc\3\2\2\2\20\u00de\3\2\2\2\22\u00ef\3"+
		"\2\2\2\24\u00f4\3\2\2\2\26\u00fa\3\2\2\2\30\u00fd\3\2\2\2\32\u010e\3\2"+
		"\2\2\34\u011a\3\2\2\2\36\u011f\3\2\2\2 \u0121\3\2\2\2\"\u0124\3\2\2\2"+
		"$\u012d\3\2\2\2&\u0132\3\2\2\2(\u0134\3\2\2\2*\u0138\3\2\2\2,\u0146\3"+
		"\2\2\2.\u014d\3\2\2\2\60\u0188\3\2\2\2\62\u018d\3\2\2\2\64\u018f\3\2\2"+
		"\2\66\u0196\3\2\2\28\u019d\3\2\2\2:\u01a4\3\2\2\2<\u01ab\3\2\2\2>\u01b1"+
		"\3\2\2\2@\u01b7\3\2\2\2B\u01c4\3\2\2\2D\u01c8\3\2\2\2F\u01ce\3\2\2\2H"+
		"\u01d3\3\2\2\2J\u01d7\3\2\2\2L\u01dc\3\2\2\2N\u01e5\3\2\2\2P\u01ef\3\2"+
		"\2\2R\u01f2\3\2\2\2T\u01f6\3\2\2\2V\u0206\3\2\2\2X\u020c\3\2\2\2Z\u022d"+
		"\3\2\2\2\\\u0230\3\2\2\2^\u0261\3\2\2\2`\u0270\3\2\2\2b\u0272\3\2\2\2"+
		"d\u0277\3\2\2\2f\u027b\3\2\2\2h\u027e\3\2\2\2j\u0282\3\2\2\2l\u0289\3"+
		"\2\2\2n\u02a1\3\2\2\2p\u02d2\3\2\2\2r\u02db\3\2\2\2t\u02dd\3\2\2\2v\u02ee"+
		"\3\2\2\2x\u02f4\3\2\2\2z\u0330\3\2\2\2|\u0385\3\2\2\2~\u0389\3\2\2\2\u0080"+
		"\u0390\3\2\2\2\u0082\u0392\3\2\2\2\u0084\u03ba\3\2\2\2\u0086\u03c2\3\2"+
		"\2\2\u0088\u03c9\3\2\2\2\u008a\u03cb\3\2\2\2\u008c\u03d4\3\2\2\2\u008e"+
		"\u03d6\3\2\2\2\u0090\u03d8\3\2\2\2\u0092\u03da\3\2\2\2\u0094\u03de\3\2"+
		"\2\2\u0096\u03e4\3\2\2\2\u0098\u03e6\3\2\2\2\u009a\u03eb\3\2\2\2\u009c"+
		"\u041b\3\2\2\2\u009e\u041d\3\2\2\2\u00a0\u0423\3\2\2\2\u00a2\u00a4\7\3"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a7\5h\65\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\7\2\2\3\u00a9\3\3\2\2\2\u00aa\u00ab\5\6\4\2\u00ab\5\3"+
		"\2\2\2\u00ac\u00c1\5\b\5\2\u00ad\u00c1\5 \21\2\u00ae\u00c1\5\f\7\2\u00af"+
		"\u00c1\5\32\16\2\u00b0\u00c1\5&\24\2\u00b1\u00c1\5V,\2\u00b2\u00c1\5("+
		"\25\2\u00b3\u00c1\5*\26\2\u00b4\u00c1\5\60\31\2\u00b5\u00c1\5\64\33\2"+
		"\u00b6\u00c1\5\66\34\2\u00b7\u00c1\58\35\2\u00b8\u00c1\5:\36\2\u00b9\u00c1"+
		"\5<\37\2\u00ba\u00c1\5H%\2\u00bb\u00c1\5> \2\u00bc\u00c1\5J&\2\u00bd\u00c1"+
		"\5L\'\2\u00be\u00c1\5R*\2\u00bf\u00c1\5T+\2\u00c0\u00ac\3\2\2\2\u00c0"+
		"\u00ad\3\2\2\2\u00c0\u00ae\3\2\2\2\u00c0\u00af\3\2\2\2\u00c0\u00b0\3\2"+
		"\2\2\u00c0\u00b1\3\2\2\2\u00c0\u00b2\3\2\2\2\u00c0\u00b3\3\2\2\2\u00c0"+
		"\u00b4\3\2\2\2\u00c0\u00b5\3\2\2\2\u00c0\u00b6\3\2\2\2\u00c0\u00b7\3\2"+
		"\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00b9\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0"+
		"\u00bb\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00bf\3\2\2\2\u00c1\7\3\2\2\2\u00c2\u00c4\7\13\2\2\u00c3\u00c5"+
		"\5\n\6\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\7\f\2\2\u00c7\t\3\2\2\2\u00c8\u00ca\5\6\4\2\u00c9\u00c8\3\2\2\2"+
		"\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\13"+
		"\3\2\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\5\16\b\2\u00cf\r\3\2\2\2\u00d0"+
		"\u00d2\5\22\n\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3"+
		"\2\2\2\u00d3\u00d6\5\24\13\2\u00d4\u00d6\5\20\t\2\u00d5\u00d3\3\2\2\2"+
		"\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\5\26\f\2\u00d8\u00d9"+
		"\5\u00a0Q\2\u00d9\u00dd\3\2\2\2\u00da\u00db\7x\2\2\u00db\u00dd\5\u00a0"+
		"Q\2\u00dc\u00d1\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\17\3\2\2\2\u00de\u00e4"+
		"\7\13\2\2\u00df\u00e0\5\30\r\2\u00e0\u00e1\7\16\2\2\u00e1\u00e3\3\2\2"+
		"\2\u00e2\u00df\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00eb\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\5\30\r\2"+
		"\u00e8\u00ea\7\16\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec"+
		"\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\7\f\2\2\u00ee\21\3\2\2\2\u00ef\u00f0\5\30\r\2\u00f0\u00f1\7\16"+
		"\2\2\u00f1\23\3\2\2\2\u00f2\u00f5\7\32\2\2\u00f3\u00f5\5\u0096L\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\7b"+
		"\2\2\u00f7\u00f9\5\u0096L\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\25\3\2\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7x\2\2\u00fc\27\3\2\2\2\u00fd"+
		"\u0100\5\u0096L\2\u00fe\u00ff\7b\2\2\u00ff\u0101\5\u0096L\2\u0100\u00fe"+
		"\3\2\2\2\u0100\u0101\3\2\2\2\u0101\31\3\2\2\2\u0102\u0105\7i\2\2\u0103"+
		"\u0106\5\34\17\2\u0104\u0106\5\36\20\2\u0105\u0103\3\2\2\2\u0105\u0104"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\5\u00a0Q\2\u0108\u010f\3\2\2"+
		"\2\u0109\u010a\7i\2\2\u010a\u010b\7\\\2\2\u010b\u010c\5z>\2\u010c\u010d"+
		"\5\u00a0Q\2\u010d\u010f\3\2\2\2\u010e\u0102\3\2\2\2\u010e\u0109\3\2\2"+
		"\2\u010f\33\3\2\2\2\u0110\u0111\5\24\13\2\u0111\u0112\5\26\f\2\u0112\u0113"+
		"\5\u00a0Q\2\u0113\u011b\3\2\2\2\u0114\u0116\5\20\t\2\u0115\u0117\5\26"+
		"\f\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\5\u00a0Q\2\u0119\u011b\3\2\2\2\u011a\u0110\3\2\2\2\u011a\u0114"+
		"\3\2\2\2\u011b\35\3\2\2\2\u011c\u0120\5 \21\2\u011d\u0120\5V,\2\u011e"+
		"\u0120\5T+\2\u011f\u011c\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2"+
		"\2\u0120\37\3\2\2\2\u0121\u0122\5\"\22\2\u0122\u0123\5\u00a0Q\2\u0123"+
		"!\3\2\2\2\u0124\u0125\5\62\32\2\u0125\u012a\5$\23\2\u0126\u0127\7\16\2"+
		"\2\u0127\u0129\5$\23\2\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b#\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u0130\5\u0080A\2\u012e\u012f\7\17\2\2\u012f\u0131\5z>\2\u0130\u012e\3"+
		"\2\2\2\u0130\u0131\3\2\2\2\u0131%\3\2\2\2\u0132\u0133\7\r\2\2\u0133\'"+
		"\3\2\2\2\u0134\u0135\6\25\2\2\u0135\u0136\5x=\2\u0136\u0137\5\u00a0Q\2"+
		"\u0137)\3\2\2\2\u0138\u0139\7]\2\2\u0139\u013a\7\t\2\2\u013a\u013b\5x"+
		"=\2\u013b\u013c\7\n\2\2\u013c\u0140\5\6\4\2\u013d\u013f\5,\27\2\u013e"+
		"\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\5.\30\2\u0144"+
		"\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145+\3\2\2\2\u0146\u0147\7M\2\2\u0147"+
		"\u0148\7]\2\2\u0148\u0149\7\t\2\2\u0149\u014a\5x=\2\u014a\u014b\7\n\2"+
		"\2\u014b\u014c\5\6\4\2\u014c-\3\2\2\2\u014d\u014e\7M\2\2\u014e\u014f\5"+
		"\6\4\2\u014f/\3\2\2\2\u0150\u0151\7I\2\2\u0151\u0152\5\6\4\2\u0152\u0153"+
		"\7W\2\2\u0153\u0154\7\t\2\2\u0154\u0155\5x=\2\u0155\u0156\7\n\2\2\u0156"+
		"\u0157\5\u00a0Q\2\u0157\u0189\3\2\2\2\u0158\u0159\7W\2\2\u0159\u015a\7"+
		"\t\2\2\u015a\u015b\5x=\2\u015b\u015c\7\n\2\2\u015c\u015d\5\6\4\2\u015d"+
		"\u0189\3\2\2\2\u015e\u015f\7U\2\2\u015f\u0162\7\t\2\2\u0160\u0163\5x="+
		"\2\u0161\u0163\5\"\22\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\7\r\2\2\u0165\u0167\5x"+
		"=\2\u0166\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016a\7\r\2\2\u0169\u016b\5x=\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2"+
		"\2\u016b\u016c\3\2\2\2\u016c\u016d\7\n\2\2\u016d\u0189\5\6\4\2\u016e\u016f"+
		"\7U\2\2\u016f\u0172\7\t\2\2\u0170\u0173\5z>\2\u0171\u0173\5\"\22\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\7`"+
		"\2\2\u0175\u0176\5x=\2\u0176\u0177\7\n\2\2\u0177\u0178\5\6\4\2\u0178\u0189"+
		"\3\2\2\2\u0179\u017b\7U\2\2\u017a\u017c\7l\2\2\u017b\u017a\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0180\7\t\2\2\u017e\u0181\5z"+
		">\2\u017f\u0181\5\"\22\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0183\5\u0098M\2\u0183\u0184\6\31\3\2\u0184\u0185"+
		"\5x=\2\u0185\u0186\7\n\2\2\u0186\u0187\5\6\4\2\u0187\u0189\3\2\2\2\u0188"+
		"\u0150\3\2\2\2\u0188\u0158\3\2\2\2\u0188\u015e\3\2\2\2\u0188\u016e\3\2"+
		"\2\2\u0188\u0179\3\2\2\2\u0189\61\3\2\2\2\u018a\u018e\7O\2\2\u018b\u018e"+
		"\5\u009eP\2\u018c\u018e\7h\2\2\u018d\u018a\3\2\2\2\u018d\u018b\3\2\2\2"+
		"\u018d\u018c\3\2\2\2\u018e\63\3\2\2\2\u018f\u0192\7T\2\2\u0190\u0191\6"+
		"\33\4\2\u0191\u0193\5\u0098M\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2"+
		"\u0193\u0194\3\2\2\2\u0194\u0195\5\u00a0Q\2\u0195\65\3\2\2\2\u0196\u0199"+
		"\7H\2\2\u0197\u0198\6\34\5\2\u0198\u019a\5\u0098M\2\u0199\u0197\3\2\2"+
		"\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\5\u00a0Q\2\u019c"+
		"\67\3\2\2\2\u019d\u01a0\7R\2\2\u019e\u019f\6\35\6\2\u019f\u01a1\5x=\2"+
		"\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3"+
		"\5\u00a0Q\2\u01a39\3\2\2\2\u01a4\u01a7\7v\2\2\u01a5\u01a6\6\36\7\2\u01a6"+
		"\u01a8\5x=\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2"+
		"\2\u01a9\u01aa\5\u00a0Q\2\u01aa;\3\2\2\2\u01ab\u01ac\7[\2\2\u01ac\u01ad"+
		"\7\t\2\2\u01ad\u01ae\5x=\2\u01ae\u01af\7\n\2\2\u01af\u01b0\5\6\4\2\u01b0"+
		"=\3\2\2\2\u01b1\u01b2\7V\2\2\u01b2\u01b3\7\t\2\2\u01b3\u01b4\5x=\2\u01b4"+
		"\u01b5\7\n\2\2\u01b5\u01b6\5@!\2\u01b6?\3\2\2\2\u01b7\u01b9\7\13\2\2\u01b8"+
		"\u01ba\5B\"\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bf\3\2"+
		"\2\2\u01bb\u01bd\5F$\2\u01bc\u01be\5B\"\2\u01bd\u01bc\3\2\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01bb\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\7\f\2\2\u01c2A\3\2\2\2\u01c3\u01c5\5D#\2\u01c4"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2"+
		"\2\2\u01c7C\3\2\2\2\u01c8\u01c9\7L\2\2\u01c9\u01ca\5x=\2\u01ca\u01cc\7"+
		"\21\2\2\u01cb\u01cd\5\n\6\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"E\3\2\2\2\u01ce\u01cf\7\\\2\2\u01cf\u01d1\7\21\2\2\u01d0\u01d2\5\n\6\2"+
		"\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2G\3\2\2\2\u01d3\u01d4\5"+
		"\u0098M\2\u01d4\u01d5\7\21\2\2\u01d5\u01d6\5\6\4\2\u01d6I\3\2\2\2\u01d7"+
		"\u01d8\7^\2\2\u01d8\u01d9\6&\b\2\u01d9\u01da\5x=\2\u01da\u01db\5\u00a0"+
		"Q\2\u01dbK\3\2\2\2\u01dc\u01dd\7a\2\2\u01dd\u01e3\5\b\5\2\u01de\u01e0"+
		"\5N(\2\u01df\u01e1\5P)\2\u01e0\u01df\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1"+
		"\u01e4\3\2\2\2\u01e2\u01e4\5P)\2\u01e3\u01de\3\2\2\2\u01e3\u01e2\3\2\2"+
		"\2\u01e4M\3\2\2\2\u01e5\u01eb\7P\2\2\u01e6\u01e8\7\t\2\2\u01e7\u01e9\5"+
		"\u0080A\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2"+
		"\u01ea\u01ec\7\n\2\2\u01eb\u01e6\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed"+
		"\3\2\2\2\u01ed\u01ee\5\b\5\2\u01eeO\3\2\2\2\u01ef\u01f0\7Q\2\2\u01f0\u01f1"+
		"\5\b\5\2\u01f1Q\3\2\2\2\u01f2\u01f3\7X\2\2\u01f3\u01f4\5\u00a0Q\2\u01f4"+
		"S\3\2\2\2\u01f5\u01f7\7k\2\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01fa\7Y\2\2\u01f9\u01fb\7\32\2\2\u01fa\u01f9\3\2"+
		"\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\5\u0098M\2\u01fd"+
		"\u01ff\7\t\2\2\u01fe\u0200\5`\61\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7\n\2\2\u0202\u0203\7\13\2\2\u0203"+
		"\u0204\5f\64\2\u0204\u0205\7\f\2\2\u0205U\3\2\2\2\u0206\u0207\7d\2\2\u0207"+
		"\u0208\5\u0098M\2\u0208\u0209\5X-\2\u0209W\3\2\2\2\u020a\u020b\7f\2\2"+
		"\u020b\u020d\5z>\2\u020c\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020e\u0212\7\13\2\2\u020f\u0211\5Z.\2\u0210\u020f\3\2\2\2\u0211"+
		"\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0215\3\2"+
		"\2\2\u0214\u0212\3\2\2\2\u0215\u0216\7\f\2\2\u0216Y\3\2\2\2\u0217\u021c"+
		"\7u\2\2\u0218\u0219\6.\t\2\u0219\u021c\5\u0098M\2\u021a\u021c\7k\2\2\u021b"+
		"\u0217\3\2\2\2\u021b\u0218\3\2\2\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2"+
		"\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0226\3\2\2\2\u021f"+
		"\u021d\3\2\2\2\u0220\u0227\5^\60\2\u0221\u0222\5\u0080A\2\u0222\u0223"+
		"\7\17\2\2\u0223\u0224\5\u0082B\2\u0224\u0225\7\r\2\2\u0225\u0227\3\2\2"+
		"\2\u0226\u0220\3\2\2\2\u0226\u0221\3\2\2\2\u0227\u022e\3\2\2\2\u0228\u022e"+
		"\5&\24\2\u0229\u022a\5\\/\2\u022a\u022b\7\17\2\2\u022b\u022c\5z>\2\u022c"+
		"\u022e\3\2\2\2\u022d\u021d\3\2\2\2\u022d\u0228\3\2\2\2\u022d\u0229\3\2"+
		"\2\2\u022e[\3\2\2\2\u022f\u0231\7\37\2\2\u0230\u022f\3\2\2\2\u0230\u0231"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\5r:\2\u0233]\3\2\2\2\u0234\u0236"+
		"\7\32\2\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\3\2\2\2"+
		"\u0237\u0239\7\37\2\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a"+
		"\3\2\2\2\u023a\u023b\5r:\2\u023b\u023d\7\t\2\2\u023c\u023e\5`\61\2\u023d"+
		"\u023c\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\7\n"+
		"\2\2\u0240\u0241\7\13\2\2\u0241\u0242\5f\64\2\u0242\u0243\7\f\2\2\u0243"+
		"\u0262\3\2\2\2\u0244\u0246\7\32\2\2\u0245\u0244\3\2\2\2\u0245\u0246\3"+
		"\2\2\2\u0246\u0248\3\2\2\2\u0247\u0249\7\37\2\2\u0248\u0247\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\5\u0092J\2\u024b\u024c"+
		"\7\t\2\2\u024c\u024d\7\n\2\2\u024d\u024e\7\13\2\2\u024e\u024f\5f\64\2"+
		"\u024f\u0250\7\f\2\2\u0250\u0262\3\2\2\2\u0251\u0253\7\32\2\2\u0252\u0251"+
		"\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254\u0256\7\37\2\2"+
		"\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258"+
		"\5\u0094K\2\u0258\u025a\7\t\2\2\u0259\u025b\5`\61\2\u025a\u0259\3\2\2"+
		"\2\u025a\u025b\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\7\n\2\2\u025d\u025e"+
		"\7\13\2\2\u025e\u025f\5f\64\2\u025f\u0260\7\f\2\2\u0260\u0262\3\2\2\2"+
		"\u0261\u0235\3\2\2\2\u0261\u0245\3\2\2\2\u0261\u0252\3\2\2\2\u0262_\3"+
		"\2\2\2\u0263\u0268\5b\62\2\u0264\u0265\7\16\2\2\u0265\u0267\5b\62\2\u0266"+
		"\u0264\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2"+
		"\2\2\u0269\u026d\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u026c\7\16\2\2\u026c"+
		"\u026e\5d\63\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0271\3\2"+
		"\2\2\u026f\u0271\5d\63\2\u0270\u0263\3\2\2\2\u0270\u026f\3\2\2\2\u0271"+
		"a\3\2\2\2\u0272\u0275\5\u0080A\2\u0273\u0274\7\17\2\2\u0274\u0276\5z>"+
		"\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276c\3\2\2\2\u0277\u0278"+
		"\7\22\2\2\u0278\u0279\5z>\2\u0279e\3\2\2\2\u027a\u027c\5h\65\2\u027b\u027a"+
		"\3\2\2\2\u027b\u027c\3\2\2\2\u027cg\3\2\2\2\u027d\u027f\5\4\3\2\u027e"+
		"\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u027e\3\2\2\2\u0280\u0281\3\2"+
		"\2\2\u0281i\3\2\2\2\u0282\u0283\7\7\2\2\u0283\u0284\5l\67\2\u0284\u0285"+
		"\7\b\2\2\u0285k\3\2\2\2\u0286\u0288\7\16\2\2\u0287\u0286\3\2\2\2\u0288"+
		"\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028d\3\2"+
		"\2\2\u028b\u0289\3\2\2\2\u028c\u028e\5n8\2\u028d\u028c\3\2\2\2\u028d\u028e"+
		"\3\2\2\2\u028e\u0297\3\2\2\2\u028f\u0291\7\16\2\2\u0290\u028f\3\2\2\2"+
		"\u0291\u0292\3\2\2\2\u0292\u0290\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294"+
		"\3\2\2\2\u0294\u0296\5n8\2\u0295\u0290\3\2\2\2\u0296\u0299\3\2\2\2\u0297"+
		"\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029d\3\2\2\2\u0299\u0297\3\2"+
		"\2\2\u029a\u029c\7\16\2\2\u029b\u029a\3\2\2\2\u029c\u029f\3\2\2\2\u029d"+
		"\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029em\3\2\2\2\u029f\u029d\3\2\2\2"+
		"\u02a0\u02a2\7\22\2\2\u02a1\u02a0\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3"+
		"\3\2\2\2\u02a3\u02a4\5z>\2\u02a4o\3\2\2\2\u02a5\u02a6\5r:\2\u02a6\u02a7"+
		"\7\21\2\2\u02a7\u02a8\5z>\2\u02a8\u02d3\3\2\2\2\u02a9\u02aa\7\7\2\2\u02aa"+
		"\u02ab\5z>\2\u02ab\u02ac\7\b\2\2\u02ac\u02ad\7\21\2\2\u02ad\u02ae\5z>"+
		"\2\u02ae\u02d3\3\2\2\2\u02af\u02b1\7k\2\2\u02b0\u02af\3\2\2\2\u02b0\u02b1"+
		"\3\2\2\2\u02b1\u02b3\3\2\2\2\u02b2\u02b4\7\32\2\2\u02b3\u02b2\3\2\2\2"+
		"\u02b3\u02b4\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\5r:\2\u02b6\u02b8"+
		"\7\t\2\2\u02b7\u02b9\5`\61\2\u02b8\u02b7\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9"+
		"\u02ba\3\2\2\2\u02ba\u02bb\7\n\2\2\u02bb\u02bc\7\13\2\2\u02bc\u02bd\5"+
		"f\64\2\u02bd\u02be\7\f\2\2\u02be\u02d3\3\2\2\2\u02bf\u02c0\5\u0092J\2"+
		"\u02c0\u02c1\7\t\2\2\u02c1\u02c2\7\n\2\2\u02c2\u02c3\7\13\2\2\u02c3\u02c4"+
		"\5f\64\2\u02c4\u02c5\7\f\2\2\u02c5\u02d3\3\2\2\2\u02c6\u02c7\5\u0094K"+
		"\2\u02c7\u02c8\7\t\2\2\u02c8\u02c9\5b\62\2\u02c9\u02ca\7\n\2\2\u02ca\u02cb"+
		"\7\13\2\2\u02cb\u02cc\5f\64\2\u02cc\u02cd\7\f\2\2\u02cd\u02d3\3\2\2\2"+
		"\u02ce\u02d0\7\22\2\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d1"+
		"\3\2\2\2\u02d1\u02d3\5z>\2\u02d2\u02a5\3\2\2\2\u02d2\u02a9\3\2\2\2\u02d2"+
		"\u02b0\3\2\2\2\u02d2\u02bf\3\2\2\2\u02d2\u02c6\3\2\2\2\u02d2\u02cf\3\2"+
		"\2\2\u02d3q\3\2\2\2\u02d4\u02dc\5\u0096L\2\u02d5\u02dc\7x\2\2\u02d6\u02dc"+
		"\5\u008eH\2\u02d7\u02d8\7\7\2\2\u02d8\u02d9\5z>\2\u02d9\u02da\7\b\2\2"+
		"\u02da\u02dc\3\2\2\2\u02db\u02d4\3\2\2\2\u02db\u02d5\3\2\2\2\u02db\u02d6"+
		"\3\2\2\2\u02db\u02d7\3\2\2\2\u02dcs\3\2\2\2\u02dd\u02e9\7\t\2\2\u02de"+
		"\u02e3\5v<\2\u02df\u02e0\7\16\2\2\u02e0\u02e2\5v<\2\u02e1\u02df\3\2\2"+
		"\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e7"+
		"\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6\u02e8\7\16\2\2\u02e7\u02e6\3\2\2\2"+
		"\u02e7\u02e8\3\2\2\2\u02e8\u02ea\3\2\2\2\u02e9\u02de\3\2\2\2\u02e9\u02ea"+
		"\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\7\n\2\2\u02ecu\3\2\2\2\u02ed"+
		"\u02ef\7\22\2\2\u02ee\u02ed\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f2\3"+
		"\2\2\2\u02f0\u02f3\5z>\2\u02f1\u02f3\5\u0098M\2\u02f2\u02f0\3\2\2\2\u02f2"+
		"\u02f1\3\2\2\2\u02f3w\3\2\2\2\u02f4\u02f9\5z>\2\u02f5\u02f6\7\16\2\2\u02f6"+
		"\u02f8\5z>\2\u02f7\u02f5\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9\u02f7\3\2\2"+
		"\2\u02f9\u02fa\3\2\2\2\u02fay\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fc\u02fd"+
		"\b>\1\2\u02fd\u0331\5\u0084C\2\u02fe\u0300\7d\2\2\u02ff\u0301\5\u0098"+
		"M\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302\3\2\2\2\u0302"+
		"\u0331\5X-\2\u0303\u0331\5|?\2\u0304\u0305\7N\2\2\u0305\u0307\5z>\2\u0306"+
		"\u0308\5t;\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0331\3\2\2"+
		"\2\u0309\u030a\7N\2\2\u030a\u030b\7\23\2\2\u030b\u0331\5\u0098M\2\u030c"+
		"\u030d\7_\2\2\u030d\u0331\5z>\'\u030e\u030f\7S\2\2\u030f\u0331\5z>&\u0310"+
		"\u0311\7K\2\2\u0311\u0331\5z>%\u0312\u0313\7\24\2\2\u0313\u0331\5z>$\u0314"+
		"\u0315\7\25\2\2\u0315\u0331\5z>#\u0316\u0317\7\26\2\2\u0317\u0331\5z>"+
		"\"\u0318\u0319\7\27\2\2\u0319\u0331\5z>!\u031a\u031b\7\30\2\2\u031b\u0331"+
		"\5z> \u031c\u031d\7\31\2\2\u031d\u0331\5z>\37\u031e\u031f\7l\2\2\u031f"+
		"\u0331\5z>\36\u0320\u0321\7j\2\2\u0321\u0322\7\t\2\2\u0322\u0323\5z>\2"+
		"\u0323\u0324\7\n\2\2\u0324\u0331\3\2\2\2\u0325\u0331\5:\36\2\u0326\u0331"+
		"\7Z\2\2\u0327\u0331\5\u0098M\2\u0328\u0331\7g\2\2\u0329\u0331\5\u008c"+
		"G\2\u032a\u0331\5j\66\2\u032b\u0331\5\u0082B\2\u032c\u032d\7\t\2\2\u032d"+
		"\u032e\5x=\2\u032e\u032f\7\n\2\2\u032f\u0331\3\2\2\2\u0330\u02fc\3\2\2"+
		"\2\u0330\u02fe\3\2\2\2\u0330\u0303\3\2\2\2\u0330\u0304\3\2\2\2\u0330\u0309"+
		"\3\2\2\2\u0330\u030c\3\2\2\2\u0330\u030e\3\2\2\2\u0330\u0310\3\2\2\2\u0330"+
		"\u0312\3\2\2\2\u0330\u0314\3\2\2\2\u0330\u0316\3\2\2\2\u0330\u0318\3\2"+
		"\2\2\u0330\u031a\3\2\2\2\u0330\u031c\3\2\2\2\u0330\u031e\3\2\2\2\u0330"+
		"\u0320\3\2\2\2\u0330\u0325\3\2\2\2\u0330\u0326\3\2\2\2\u0330\u0327\3\2"+
		"\2\2\u0330\u0328\3\2\2\2\u0330\u0329\3\2\2\2\u0330\u032a\3\2\2\2\u0330"+
		"\u032b\3\2\2\2\u0330\u032c\3\2\2\2\u0331\u0382\3\2\2\2\u0332\u0333\f\35"+
		"\2\2\u0333\u0334\7\35\2\2\u0334\u0381\5z>\35\u0335\u0336\f\34\2\2\u0336"+
		"\u0337\t\2\2\2\u0337\u0381\5z>\35\u0338\u0339\f\33\2\2\u0339\u033a\t\3"+
		"\2\2\u033a\u0381\5z>\34\u033b\u033c\f\32\2\2\u033c\u033d\7\36\2\2\u033d"+
		"\u0381\5z>\33\u033e\u033f\f\31\2\2\u033f\u0340\t\4\2\2\u0340\u0381\5z"+
		">\32\u0341\u0342\f\30\2\2\u0342\u0343\t\5\2\2\u0343\u0381\5z>\31\u0344"+
		"\u0345\f\27\2\2\u0345\u0346\7J\2\2\u0346\u0381\5z>\30\u0347\u0348\f\26"+
		"\2\2\u0348\u0349\7`\2\2\u0349\u0381\5z>\27\u034a\u034b\f\25\2\2\u034b"+
		"\u034c\t\6\2\2\u034c\u0381\5z>\26\u034d\u034e\f\24\2\2\u034e\u034f\7+"+
		"\2\2\u034f\u0381\5z>\25\u0350\u0351\f\23\2\2\u0351\u0352\7,\2\2\u0352"+
		"\u0381\5z>\24\u0353\u0354\f\22\2\2\u0354\u0355\7-\2\2\u0355\u0381\5z>"+
		"\23\u0356\u0357\f\21\2\2\u0357\u0358\7.\2\2\u0358\u0381\5z>\22\u0359\u035a"+
		"\f\20\2\2\u035a\u035b\7/\2\2\u035b\u0381\5z>\21\u035c\u035d\f\17\2\2\u035d"+
		"\u035e\7\20\2\2\u035e\u035f\5z>\2\u035f\u0360\7\21\2\2\u0360\u0361\5z"+
		">\20\u0361\u0381\3\2\2\2\u0362\u0363\f\16\2\2\u0363\u0364\7\17\2\2\u0364"+
		"\u0381\5z>\16\u0365\u0366\f\r\2\2\u0366\u0367\5\u008aF\2\u0367\u0368\5"+
		"z>\r\u0368\u0381\3\2\2\2\u0369\u036a\f.\2\2\u036a\u036b\7\7\2\2\u036b"+
		"\u036c\5x=\2\u036c\u036d\7\b\2\2\u036d\u0381\3\2\2\2\u036e\u0374\f-\2"+
		"\2\u036f\u0372\7\23\2\2\u0370\u0373\5|?\2\u0371\u0373\5~@\2\u0372\u0370"+
		"\3\2\2\2\u0372\u0371\3\2\2\2\u0373\u0375\3\2\2\2\u0374\u036f\3\2\2\2\u0375"+
		"\u0376\3\2\2\2\u0376\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0381\3\2"+
		"\2\2\u0378\u0379\f)\2\2\u0379\u037a\6>\36\2\u037a\u0381\7\24\2\2\u037b"+
		"\u037c\f(\2\2\u037c\u037d\6> \2\u037d\u0381\7\25\2\2\u037e\u037f\f\13"+
		"\2\2\u037f\u0381\7y\2\2\u0380\u0332\3\2\2\2\u0380\u0335\3\2\2\2\u0380"+
		"\u0338\3\2\2\2\u0380\u033b\3\2\2\2\u0380\u033e\3\2\2\2\u0380\u0341\3\2"+
		"\2\2\u0380\u0344\3\2\2\2\u0380\u0347\3\2\2\2\u0380\u034a\3\2\2\2\u0380"+
		"\u034d\3\2\2\2\u0380\u0350\3\2\2\2\u0380\u0353\3\2\2\2\u0380\u0356\3\2"+
		"\2\2\u0380\u0359\3\2\2\2\u0380\u035c\3\2\2\2\u0380\u0362\3\2\2\2\u0380"+
		"\u0365\3\2\2\2\u0380\u0369\3\2\2\2\u0380\u036e\3\2\2\2\u0380\u0378\3\2"+
		"\2\2\u0380\u037b\3\2\2\2\u0380\u037e\3\2\2\2\u0381\u0384\3\2\2\2\u0382"+
		"\u0380\3\2\2\2\u0382\u0383\3\2\2\2\u0383{\3\2\2\2\u0384\u0382\3\2\2\2"+
		"\u0385\u0386\5\u0098M\2\u0386\u0387\5t;\2\u0387}\3\2\2\2\u0388\u038a\7"+
		"\37\2\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038b\3\2\2\2\u038b"+
		"\u038c\5\u0096L\2\u038c\177\3\2\2\2\u038d\u0391\5\u0098M\2\u038e\u0391"+
		"\5j\66\2\u038f\u0391\5\u0082B\2\u0390\u038d\3\2\2\2\u0390\u038e\3\2\2"+
		"\2\u0390\u038f\3\2\2\2\u0391\u0081\3\2\2\2\u0392\u039b\7\13\2\2\u0393"+
		"\u0398\5p9\2\u0394\u0395\7\16\2\2\u0395\u0397\5p9\2\u0396\u0394\3\2\2"+
		"\2\u0397\u039a\3\2\2\2\u0398\u0396\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039c"+
		"\3\2\2\2\u039a\u0398\3\2\2\2\u039b\u0393\3\2\2\2\u039b\u039c\3\2\2\2\u039c"+
		"\u039e\3\2\2\2\u039d\u039f\7\16\2\2\u039e\u039d\3\2\2\2\u039e\u039f\3"+
		"\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a1\7\f\2\2\u03a1\u0083\3\2\2\2\u03a2"+
		"\u03bb\5T+\2\u03a3\u03a5\7k\2\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2"+
		"\2\u03a5\u03a6\3\2\2\2\u03a6\u03a8\7Y\2\2\u03a7\u03a9\7\32\2\2\u03a8\u03a7"+
		"\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ac\7\t\2\2\u03ab"+
		"\u03ad\5`\61\2\u03ac\u03ab\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ae\3\2"+
		"\2\2\u03ae\u03af\7\n\2\2\u03af\u03b0\7\13\2\2\u03b0\u03b1\5f\64\2\u03b1"+
		"\u03b2\7\f\2\2\u03b2\u03bb\3\2\2\2\u03b3\u03b5\7k\2\2\u03b4\u03b3\3\2"+
		"\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b7\5\u0086D\2\u03b7"+
		"\u03b8\7<\2\2\u03b8\u03b9\5\u0088E\2\u03b9\u03bb\3\2\2\2\u03ba\u03a2\3"+
		"\2\2\2\u03ba\u03a4\3\2\2\2\u03ba\u03b4\3\2\2\2\u03bb\u0085\3\2\2\2\u03bc"+
		"\u03c3\5\u0098M\2\u03bd\u03bf\7\t\2\2\u03be\u03c0\5`\61\2\u03bf\u03be"+
		"\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03c3\7\n\2\2\u03c2"+
		"\u03bc\3\2\2\2\u03c2\u03bd\3\2\2\2\u03c3\u0087\3\2\2\2\u03c4\u03ca\5z"+
		">\2\u03c5\u03c6\7\13\2\2\u03c6\u03c7\5f\64\2\u03c7\u03c8\7\f\2\2\u03c8"+
		"\u03ca\3\2\2\2\u03c9\u03c4\3\2\2\2\u03c9\u03c5\3\2\2\2\u03ca\u0089\3\2"+
		"\2\2\u03cb\u03cc\t\7\2\2\u03cc\u008b\3\2\2\2\u03cd\u03d5\7=\2\2\u03ce"+
		"\u03d5\7>\2\2\u03cf\u03d5\7x\2\2\u03d0\u03d5\7y\2\2\u03d1\u03d5\7\6\2"+
		"\2\u03d2\u03d5\5\u008eH\2\u03d3\u03d5\5\u0090I\2\u03d4\u03cd\3\2\2\2\u03d4"+
		"\u03ce\3\2\2\2\u03d4\u03cf\3\2\2\2\u03d4\u03d0\3\2\2\2\u03d4\u03d1\3\2"+
		"\2\2\u03d4\u03d2\3\2\2\2\u03d4\u03d3\3\2\2\2\u03d5\u008d\3\2\2\2\u03d6"+
		"\u03d7\t\b\2\2\u03d7\u008f\3\2\2\2\u03d8\u03d9\t\t\2\2\u03d9\u0091\3\2"+
		"\2\2\u03da\u03db\6J\"\2\u03db\u03dc\5\u0098M\2\u03dc\u03dd\5r:\2\u03dd"+
		"\u0093\3\2\2\2\u03de\u03df\6K#\2\u03df\u03e0\5\u0098M\2\u03e0\u03e1\5"+
		"r:\2\u03e1\u0095\3\2\2\2\u03e2\u03e5\5\u0098M\2\u03e3\u03e5\5\u009aN\2"+
		"\u03e4\u03e2\3\2\2\2\u03e4\u03e3\3\2\2\2\u03e5\u0097\3\2\2\2\u03e6\u03e7"+
		"\t\n\2\2\u03e7\u0099\3\2\2\2\u03e8\u03ec\5\u009cO\2\u03e9\u03ec\7=\2\2"+
		"\u03ea\u03ec\7>\2\2\u03eb\u03e8\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb\u03ea"+
		"\3\2\2\2\u03ec\u009b\3\2\2\2\u03ed\u041c\7H\2\2\u03ee\u041c\7I\2\2\u03ef"+
		"\u041c\7J\2\2\u03f0\u041c\7K\2\2\u03f1\u041c\7L\2\2\u03f2\u041c\7M\2\2"+
		"\u03f3\u041c\7N\2\2\u03f4\u041c\7O\2\2\u03f5\u041c\7P\2\2\u03f6\u041c"+
		"\7Q\2\2\u03f7\u041c\7R\2\2\u03f8\u041c\7S\2\2\u03f9\u041c\7T\2\2\u03fa"+
		"\u041c\7U\2\2\u03fb\u041c\7V\2\2\u03fc\u041c\7W\2\2\u03fd\u041c\7X\2\2"+
		"\u03fe\u041c\7Y\2\2\u03ff\u041c\7Z\2\2\u0400\u041c\7[\2\2\u0401\u041c"+
		"\7\\\2\2\u0402\u041c\7]\2\2\u0403\u041c\7^\2\2\u0404\u041c\7_\2\2\u0405"+
		"\u041c\7`\2\2\u0406\u041c\7a\2\2\u0407\u041c\7d\2\2\u0408\u041c\7e\2\2"+
		"\u0409\u041c\7f\2\2\u040a\u041c\7g\2\2\u040b\u041c\7h\2\2\u040c\u041c"+
		"\7i\2\2\u040d\u041c\7j\2\2\u040e\u041c\7m\2\2\u040f\u041c\5\u009eP\2\u0410"+
		"\u041c\7p\2\2\u0411\u041c\7q\2\2\u0412\u041c\7r\2\2\u0413\u041c\7s\2\2"+
		"\u0414\u041c\7t\2\2\u0415\u041c\7u\2\2\u0416\u041c\7v\2\2\u0417\u041c"+
		"\7k\2\2\u0418\u041c\7l\2\2\u0419\u041c\7c\2\2\u041a\u041c\7b\2\2\u041b"+
		"\u03ed\3\2\2\2\u041b\u03ee\3\2\2\2\u041b\u03ef\3\2\2\2\u041b\u03f0\3\2"+
		"\2\2\u041b\u03f1\3\2\2\2\u041b\u03f2\3\2\2\2\u041b\u03f3\3\2\2\2\u041b"+
		"\u03f4\3\2\2\2\u041b\u03f5\3\2\2\2\u041b\u03f6\3\2\2\2\u041b\u03f7\3\2"+
		"\2\2\u041b\u03f8\3\2\2\2\u041b\u03f9\3\2\2\2\u041b\u03fa\3\2\2\2\u041b"+
		"\u03fb\3\2\2\2\u041b\u03fc\3\2\2\2\u041b\u03fd\3\2\2\2\u041b\u03fe\3\2"+
		"\2\2\u041b\u03ff\3\2\2\2\u041b\u0400\3\2\2\2\u041b\u0401\3\2\2\2\u041b"+
		"\u0402\3\2\2\2\u041b\u0403\3\2\2\2\u041b\u0404\3\2\2\2\u041b\u0405\3\2"+
		"\2\2\u041b\u0406\3\2\2\2\u041b\u0407\3\2\2\2\u041b\u0408\3\2\2\2\u041b"+
		"\u0409\3\2\2\2\u041b\u040a\3\2\2\2\u041b\u040b\3\2\2\2\u041b\u040c\3\2"+
		"\2\2\u041b\u040d\3\2\2\2\u041b\u040e\3\2\2\2\u041b\u040f\3\2\2\2\u041b"+
		"\u0410\3\2\2\2\u041b\u0411\3\2\2\2\u041b\u0412\3\2\2\2\u041b\u0413\3\2"+
		"\2\2\u041b\u0414\3\2\2\2\u041b\u0415\3\2\2\2\u041b\u0416\3\2\2\2\u041b"+
		"\u0417\3\2\2\2\u041b\u0418\3\2\2\2\u041b\u0419\3\2\2\2\u041b\u041a\3\2"+
		"\2\2\u041c\u009d\3\2\2\2\u041d\u041e\t\13\2\2\u041e\u009f\3\2\2\2\u041f"+
		"\u0424\7\r\2\2\u0420\u0424\7\2\2\3\u0421\u0424\6Q$\2\u0422\u0424\6Q%\2"+
		"\u0423\u041f\3\2\2\2\u0423\u0420\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0422"+
		"\3\2\2\2\u0424\u00a1\3\2\2\2s\u00a3\u00a6\u00c0\u00c4\u00cb\u00d1\u00d5"+
		"\u00dc\u00e4\u00e9\u00eb\u00f4\u00f8\u0100\u0105\u010e\u0116\u011a\u011f"+
		"\u012a\u0130\u0140\u0144\u0162\u0166\u016a\u0172\u017b\u0180\u0188\u018d"+
		"\u0192\u0199\u01a0\u01a7\u01b9\u01bd\u01bf\u01c6\u01cc\u01d1\u01e0\u01e3"+
		"\u01e8\u01eb\u01f6\u01fa\u01ff\u020c\u0212\u021b\u021d\u0226\u022d\u0230"+
		"\u0235\u0238\u023d\u0245\u0248\u0252\u0255\u025a\u0261\u0268\u026d\u0270"+
		"\u0275\u027b\u0280\u0289\u028d\u0292\u0297\u029d\u02a1\u02b0\u02b3\u02b8"+
		"\u02cf\u02d2\u02db\u02e3\u02e7\u02e9\u02ee\u02f2\u02f9\u0300\u0307\u0330"+
		"\u0372\u0376\u0380\u0382\u0389\u0390\u0398\u039b\u039e\u03a4\u03a8\u03ac"+
		"\u03b4\u03ba\u03bf\u03c2\u03c9\u03d4\u03e4\u03eb\u041b\u0423";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}