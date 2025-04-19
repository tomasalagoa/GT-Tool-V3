package ist.gt.languages.solidity.parser;

// Generated from SolidityParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SolidityParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ReservedKeywords=1, Abstract=2, Address=3, Anonymous=4, As=5, Assembly=6, 
		Bool=7, Break=8, Bytes=9, Calldata=10, Catch=11, Constant=12, Constructor=13, 
		Continue=14, Contract=15, Delete=16, Do=17, Else=18, Emit=19, Enum=20, 
		Error=21, Event=22, External=23, Fallback=24, FalseLiteral=25, Fixed=26, 
		FixedBytes=27, For=28, From=29, Function=30, Global=31, Hex=32, If=33, 
		Immutable=34, Import=35, Indexed=36, Interface=37, Internal=38, Is=39, 
		Library=40, Mapping=41, Memory=42, Modifier=43, New=44, SubDenomination=45, 
		Override=46, Payable=47, Pragma=48, Private=49, Public=50, Pure=51, Receive=52, 
		Return=53, Returns=54, Revert=55, SignedIntegerType=56, Storage=57, String=58, 
		Struct=59, Transient=60, TrueLiteral=61, Try=62, Type=63, Ufixed=64, Unchecked=65, 
		Unicode=66, UnsignedIntegerType=67, Using=68, View=69, Virtual=70, While=71, 
		LParen=72, RParen=73, LBrack=74, RBrack=75, LBrace=76, RBrace=77, Colon=78, 
		Semicolon=79, Period=80, Conditional=81, DoubleArrow=82, RightArrow=83, 
		Assign=84, AssignBitOr=85, AssignBitXor=86, AssignBitAnd=87, AssignShl=88, 
		AssignSar=89, AssignShr=90, AssignAdd=91, AssignSub=92, AssignMul=93, 
		AssignDiv=94, AssignMod=95, Comma=96, Or=97, And=98, BitOr=99, BitXor=100, 
		BitAnd=101, Shl=102, Sar=103, Shr=104, Add=105, Sub=106, Mul=107, Div=108, 
		Mod=109, Exp=110, Equal=111, NotEqual=112, LessThan=113, GreaterThan=114, 
		LessThanOrEqual=115, GreaterThanOrEqual=116, Not=117, BitNot=118, Inc=119, 
		Dec=120, DoubleQuote=121, SingleQuote=122, NonEmptyStringLiteral=123, 
		EmptyStringLiteral=124, UnicodeStringLiteral=125, HexString=126, HexNumber=127, 
		OctalNumber=128, DecimalNumber=129, DecimalNumberFollowedByIdentifier=130, 
		Identifier=131, WS=132, COMMENT=133, LINE_COMMENT=134, AssemblyDialect=135, 
		AssemblyLBrace=136, AssemblyFlagString=137, AssemblyBlockLParen=138, AssemblyBlockRParen=139, 
		AssemblyBlockComma=140, AssemblyBlockWS=141, AssemblyBlockCOMMENT=142, 
		AssemblyBlockLINE_COMMENT=143, YulBreak=144, YulCase=145, YulContinue=146, 
		YulDefault=147, YulFalse=148, YulFor=149, YulFunction=150, YulIf=151, 
		YulLeave=152, YulLet=153, YulSwitch=154, YulTrue=155, YulHex=156, YulEVMBuiltin=157, 
		YulLBrace=158, YulRBrace=159, YulLParen=160, YulRParen=161, YulAssign=162, 
		YulPeriod=163, YulComma=164, YulArrow=165, YulIdentifier=166, YulHexNumber=167, 
		YulDecimalNumber=168, YulStringLiteral=169, YulHexStringLiteral=170, YulWS=171, 
		YulCOMMENT=172, YulLINE_COMMENT=173, PragmaToken=174, PragmaSemicolon=175, 
		PragmaWS=176, PragmaCOMMENT=177, PragmaLINE_COMMENT=178;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_importDirective = 2, 
		RULE_importAliases = 3, RULE_path = 4, RULE_symbolAliases = 5, RULE_contractDefinition = 6, 
		RULE_interfaceDefinition = 7, RULE_libraryDefinition = 8, RULE_inheritanceSpecifierList = 9, 
		RULE_inheritanceSpecifier = 10, RULE_contractBodyElement = 11, RULE_namedArgument = 12, 
		RULE_callArgumentList = 13, RULE_identifierPath = 14, RULE_modifierInvocation = 15, 
		RULE_visibility = 16, RULE_parameterList = 17, RULE_parameterDeclaration = 18, 
		RULE_constructorDefinition = 19, RULE_stateMutability = 20, RULE_overrideSpecifier = 21, 
		RULE_functionDefinition = 22, RULE_modifierDefinition = 23, RULE_fallbackFunctionDefinition = 24, 
		RULE_receiveFunctionDefinition = 25, RULE_structDefinition = 26, RULE_structMember = 27, 
		RULE_enumDefinition = 28, RULE_userDefinedValueTypeDefinition = 29, RULE_stateVariableDeclaration = 30, 
		RULE_constantVariableDeclaration = 31, RULE_eventParameter = 32, RULE_eventDefinition = 33, 
		RULE_errorParameter = 34, RULE_errorDefinition = 35, RULE_userDefinableOperator = 36, 
		RULE_usingDirective = 37, RULE_usingAliases = 38, RULE_typeName = 39, 
		RULE_elementaryTypeName = 40, RULE_addressPayable = 41, RULE_functionTypeName = 42, 
		RULE_variableDeclaration = 43, RULE_dataLocation = 44, RULE_expression = 45, 
		RULE_assignOp = 46, RULE_tupleExpression = 47, RULE_inlineArrayExpression = 48, 
		RULE_identifier = 49, RULE_literal = 50, RULE_literalWithSubDenomination = 51, 
		RULE_boolLiteral = 52, RULE_stringLiteral = 53, RULE_hexStringLiteral = 54, 
		RULE_unicodeStringLiteral = 55, RULE_numberLiteral = 56, RULE_block = 57, 
		RULE_uncheckedBlock = 58, RULE_statement = 59, RULE_simpleStatement = 60, 
		RULE_ifStatement = 61, RULE_forStatement = 62, RULE_whileStatement = 63, 
		RULE_doWhileStatement = 64, RULE_continueStatement = 65, RULE_breakStatement = 66, 
		RULE_tryStatement = 67, RULE_catchClause = 68, RULE_returnStatement = 69, 
		RULE_emitStatement = 70, RULE_revertStatement = 71, RULE_assemblyStatement = 72, 
		RULE_assemblyFlags = 73, RULE_variableDeclarationList = 74, RULE_variableDeclarationTuple = 75, 
		RULE_variableDeclarationStatement = 76, RULE_expressionStatement = 77, 
		RULE_mappingType = 78, RULE_mappingKeyType = 79, RULE_yulStatement = 80, 
		RULE_yulBlock = 81, RULE_yulVariableDeclaration = 82, RULE_yulAssignment = 83, 
		RULE_yulIfStatement = 84, RULE_yulForStatement = 85, RULE_yulSwitchCase = 86, 
		RULE_yulSwitchStatement = 87, RULE_yulFunctionDefinition = 88, RULE_yulPath = 89, 
		RULE_yulFunctionCall = 90, RULE_yulbool = 91, RULE_yulLiteral = 92, RULE_yulExpression = 93;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "importDirective", "importAliases", 
			"path", "symbolAliases", "contractDefinition", "interfaceDefinition", 
			"libraryDefinition", "inheritanceSpecifierList", "inheritanceSpecifier", 
			"contractBodyElement", "namedArgument", "callArgumentList", "identifierPath", 
			"modifierInvocation", "visibility", "parameterList", "parameterDeclaration", 
			"constructorDefinition", "stateMutability", "overrideSpecifier", "functionDefinition", 
			"modifierDefinition", "fallbackFunctionDefinition", "receiveFunctionDefinition", 
			"structDefinition", "structMember", "enumDefinition", "userDefinedValueTypeDefinition", 
			"stateVariableDeclaration", "constantVariableDeclaration", "eventParameter", 
			"eventDefinition", "errorParameter", "errorDefinition", "userDefinableOperator", 
			"usingDirective", "usingAliases", "typeName", "elementaryTypeName", "addressPayable", 
			"functionTypeName", "variableDeclaration", "dataLocation", "expression", 
			"assignOp", "tupleExpression", "inlineArrayExpression", "identifier", 
			"literal", "literalWithSubDenomination", "boolLiteral", "stringLiteral", 
			"hexStringLiteral", "unicodeStringLiteral", "numberLiteral", "block", 
			"uncheckedBlock", "statement", "simpleStatement", "ifStatement", "forStatement", 
			"whileStatement", "doWhileStatement", "continueStatement", "breakStatement", 
			"tryStatement", "catchClause", "returnStatement", "emitStatement", "revertStatement", 
			"assemblyStatement", "assemblyFlags", "variableDeclarationList", "variableDeclarationTuple", 
			"variableDeclarationStatement", "expressionStatement", "mappingType", 
			"mappingKeyType", "yulStatement", "yulBlock", "yulVariableDeclaration", 
			"yulAssignment", "yulIfStatement", "yulForStatement", "yulSwitchCase", 
			"yulSwitchStatement", "yulFunctionDefinition", "yulPath", "yulFunctionCall", 
			"yulbool", "yulLiteral", "yulExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'abstract'", "'address'", "'anonymous'", "'as'", "'assembly'", 
			"'bool'", null, "'bytes'", "'calldata'", "'catch'", "'constant'", "'constructor'", 
			null, "'contract'", "'delete'", "'do'", "'else'", "'emit'", "'enum'", 
			"'error'", "'event'", "'external'", "'fallback'", null, null, null, null, 
			"'from'", null, "'global'", null, null, "'immutable'", "'import'", "'indexed'", 
			"'interface'", "'internal'", "'is'", "'library'", "'mapping'", "'memory'", 
			"'modifier'", "'new'", null, "'override'", "'payable'", "'pragma'", "'private'", 
			"'public'", "'pure'", "'receive'", "'return'", "'returns'", "'revert'", 
			null, "'storage'", "'string'", "'struct'", "'transient'", null, "'try'", 
			"'type'", null, "'unchecked'", "'unicode'", null, "'using'", "'view'", 
			"'virtual'", "'while'", null, null, "'['", "']'", null, null, "':'", 
			null, null, "'?'", "'=>'", null, "'='", "'|='", "'^='", "'&='", "'<<='", 
			"'>>='", "'>>>='", "'+='", "'-='", "'*='", "'/='", "'%='", null, "'||'", 
			"'&&'", "'|'", "'^'", "'&'", "'<<'", "'>>'", "'>>>'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'**'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'!'", 
			"'~'", "'++'", "'--'", "'\"'", "'''", null, null, null, null, null, null, 
			null, null, null, null, null, null, "'\"evmasm\"'", null, null, null, 
			null, null, null, null, null, null, "'case'", null, "'default'", null, 
			null, null, null, "'leave'", "'let'", "'switch'", null, null, null, null, 
			null, null, null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ReservedKeywords", "Abstract", "Address", "Anonymous", "As", "Assembly", 
			"Bool", "Break", "Bytes", "Calldata", "Catch", "Constant", "Constructor", 
			"Continue", "Contract", "Delete", "Do", "Else", "Emit", "Enum", "Error", 
			"Event", "External", "Fallback", "FalseLiteral", "Fixed", "FixedBytes", 
			"For", "From", "Function", "Global", "Hex", "If", "Immutable", "Import", 
			"Indexed", "Interface", "Internal", "Is", "Library", "Mapping", "Memory", 
			"Modifier", "New", "SubDenomination", "Override", "Payable", "Pragma", 
			"Private", "Public", "Pure", "Receive", "Return", "Returns", "Revert", 
			"SignedIntegerType", "Storage", "String", "Struct", "Transient", "TrueLiteral", 
			"Try", "Type", "Ufixed", "Unchecked", "Unicode", "UnsignedIntegerType", 
			"Using", "View", "Virtual", "While", "LParen", "RParen", "LBrack", "RBrack", 
			"LBrace", "RBrace", "Colon", "Semicolon", "Period", "Conditional", "DoubleArrow", 
			"RightArrow", "Assign", "AssignBitOr", "AssignBitXor", "AssignBitAnd", 
			"AssignShl", "AssignSar", "AssignShr", "AssignAdd", "AssignSub", "AssignMul", 
			"AssignDiv", "AssignMod", "Comma", "Or", "And", "BitOr", "BitXor", "BitAnd", 
			"Shl", "Sar", "Shr", "Add", "Sub", "Mul", "Div", "Mod", "Exp", "Equal", 
			"NotEqual", "LessThan", "GreaterThan", "LessThanOrEqual", "GreaterThanOrEqual", 
			"Not", "BitNot", "Inc", "Dec", "DoubleQuote", "SingleQuote", "NonEmptyStringLiteral", 
			"EmptyStringLiteral", "UnicodeStringLiteral", "HexString", "HexNumber", 
			"OctalNumber", "DecimalNumber", "DecimalNumberFollowedByIdentifier", 
			"Identifier", "WS", "COMMENT", "LINE_COMMENT", "AssemblyDialect", "AssemblyLBrace", 
			"AssemblyFlagString", "AssemblyBlockLParen", "AssemblyBlockRParen", "AssemblyBlockComma", 
			"AssemblyBlockWS", "AssemblyBlockCOMMENT", "AssemblyBlockLINE_COMMENT", 
			"YulBreak", "YulCase", "YulContinue", "YulDefault", "YulFalse", "YulFor", 
			"YulFunction", "YulIf", "YulLeave", "YulLet", "YulSwitch", "YulTrue", 
			"YulHex", "YulEVMBuiltin", "YulLBrace", "YulRBrace", "YulLParen", "YulRParen", 
			"YulAssign", "YulPeriod", "YulComma", "YulArrow", "YulIdentifier", "YulHexNumber", 
			"YulDecimalNumber", "YulStringLiteral", "YulHexStringLiteral", "YulWS", 
			"YulCOMMENT", "YulLINE_COMMENT", "PragmaToken", "PragmaSemicolon", "PragmaWS", 
			"PragmaCOMMENT", "PragmaLINE_COMMENT"
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
	public String getGrammarFileName() { return "SolidityParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolidityParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SourceUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolidityParser.EOF, 0); }
		public List<PragmaDirectiveContext> pragmaDirective() {
			return getRuleContexts(PragmaDirectiveContext.class);
		}
		public PragmaDirectiveContext pragmaDirective(int i) {
			return getRuleContext(PragmaDirectiveContext.class,i);
		}
		public List<ImportDirectiveContext> importDirective() {
			return getRuleContexts(ImportDirectiveContext.class);
		}
		public ImportDirectiveContext importDirective(int i) {
			return getRuleContext(ImportDirectiveContext.class,i);
		}
		public List<UsingDirectiveContext> usingDirective() {
			return getRuleContexts(UsingDirectiveContext.class);
		}
		public UsingDirectiveContext usingDirective(int i) {
			return getRuleContext(UsingDirectiveContext.class,i);
		}
		public List<ContractDefinitionContext> contractDefinition() {
			return getRuleContexts(ContractDefinitionContext.class);
		}
		public ContractDefinitionContext contractDefinition(int i) {
			return getRuleContext(ContractDefinitionContext.class,i);
		}
		public List<InterfaceDefinitionContext> interfaceDefinition() {
			return getRuleContexts(InterfaceDefinitionContext.class);
		}
		public InterfaceDefinitionContext interfaceDefinition(int i) {
			return getRuleContext(InterfaceDefinitionContext.class,i);
		}
		public List<LibraryDefinitionContext> libraryDefinition() {
			return getRuleContexts(LibraryDefinitionContext.class);
		}
		public LibraryDefinitionContext libraryDefinition(int i) {
			return getRuleContext(LibraryDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstantVariableDeclarationContext> constantVariableDeclaration() {
			return getRuleContexts(ConstantVariableDeclarationContext.class);
		}
		public ConstantVariableDeclarationContext constantVariableDeclaration(int i) {
			return getRuleContext(ConstantVariableDeclarationContext.class,i);
		}
		public List<StructDefinitionContext> structDefinition() {
			return getRuleContexts(StructDefinitionContext.class);
		}
		public StructDefinitionContext structDefinition(int i) {
			return getRuleContext(StructDefinitionContext.class,i);
		}
		public List<EnumDefinitionContext> enumDefinition() {
			return getRuleContexts(EnumDefinitionContext.class);
		}
		public EnumDefinitionContext enumDefinition(int i) {
			return getRuleContext(EnumDefinitionContext.class,i);
		}
		public List<UserDefinedValueTypeDefinitionContext> userDefinedValueTypeDefinition() {
			return getRuleContexts(UserDefinedValueTypeDefinitionContext.class);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition(int i) {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,i);
		}
		public List<ErrorDefinitionContext> errorDefinition() {
			return getRuleContexts(ErrorDefinitionContext.class);
		}
		public ErrorDefinitionContext errorDefinition(int i) {
			return getRuleContext(ErrorDefinitionContext.class,i);
		}
		public List<EventDefinitionContext> eventDefinition() {
			return getRuleContexts(EventDefinitionContext.class);
		}
		public EventDefinitionContext eventDefinition(int i) {
			return getRuleContext(EventDefinitionContext.class,i);
		}
		public SourceUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSourceUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSourceUnit(this);
		}
	}

	public final SourceUnitContext sourceUnit() throws RecognitionException {
		SourceUnitContext _localctx = new SourceUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Abstract) | (1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Contract) | (1L << Enum) | (1L << Error) | (1L << Event) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Import) | (1L << Interface) | (1L << Library) | (1L << Mapping) | (1L << Pragma) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Struct) | (1L << Transient) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (Using - 64)))) != 0) || _la==Identifier) {
				{
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(188);
					pragmaDirective();
					}
					break;
				case 2:
					{
					setState(189);
					importDirective();
					}
					break;
				case 3:
					{
					setState(190);
					usingDirective();
					}
					break;
				case 4:
					{
					setState(191);
					contractDefinition();
					}
					break;
				case 5:
					{
					setState(192);
					interfaceDefinition();
					}
					break;
				case 6:
					{
					setState(193);
					libraryDefinition();
					}
					break;
				case 7:
					{
					setState(194);
					functionDefinition();
					}
					break;
				case 8:
					{
					setState(195);
					constantVariableDeclaration();
					}
					break;
				case 9:
					{
					setState(196);
					structDefinition();
					}
					break;
				case 10:
					{
					setState(197);
					enumDefinition();
					}
					break;
				case 11:
					{
					setState(198);
					userDefinedValueTypeDefinition();
					}
					break;
				case 12:
					{
					setState(199);
					errorDefinition();
					}
					break;
				case 13:
					{
					setState(200);
					eventDefinition();
					}
					break;
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
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

	public static class PragmaDirectiveContext extends ParserRuleContext {
		public TerminalNode Pragma() { return getToken(SolidityParser.Pragma, 0); }
		public TerminalNode PragmaSemicolon() { return getToken(SolidityParser.PragmaSemicolon, 0); }
		public List<TerminalNode> PragmaToken() { return getTokens(SolidityParser.PragmaToken); }
		public TerminalNode PragmaToken(int i) {
			return getToken(SolidityParser.PragmaToken, i);
		}
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPragmaDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPragmaDirective(this);
		}
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragmaDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(Pragma);
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209);
				match(PragmaToken);
				}
				}
				setState(212); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PragmaToken );
			setState(214);
			match(PragmaSemicolon);
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

	public static class ImportDirectiveContext extends ParserRuleContext {
		public IdentifierContext unitAlias;
		public TerminalNode Import() { return getToken(SolidityParser.Import, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SymbolAliasesContext symbolAliases() {
			return getRuleContext(SymbolAliasesContext.class,0);
		}
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterImportDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitImportDirective(this);
		}
	}

	public final ImportDirectiveContext importDirective() throws RecognitionException {
		ImportDirectiveContext _localctx = new ImportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(Import);
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
				{
				{
				setState(217);
				path();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==As) {
					{
					setState(218);
					match(As);
					setState(219);
					((ImportDirectiveContext)_localctx).unitAlias = identifier();
					}
				}

				}
				}
				break;
			case LBrace:
				{
				{
				setState(222);
				symbolAliases();
				setState(223);
				match(From);
				setState(224);
				path();
				}
				}
				break;
			case Mul:
				{
				{
				setState(226);
				match(Mul);
				setState(227);
				match(As);
				setState(228);
				((ImportDirectiveContext)_localctx).unitAlias = identifier();
				setState(229);
				match(From);
				setState(230);
				path();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(234);
			match(Semicolon);
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

	public static class ImportAliasesContext extends ParserRuleContext {
		public IdentifierContext symbol;
		public IdentifierContext alias;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public ImportAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterImportAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitImportAliases(this);
		}
	}

	public final ImportAliasesContext importAliases() throws RecognitionException {
		ImportAliasesContext _localctx = new ImportAliasesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			((ImportAliasesContext)_localctx).symbol = identifier();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(237);
				match(As);
				setState(238);
				((ImportAliasesContext)_localctx).alias = identifier();
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

	public static class PathContext extends ParserRuleContext {
		public TerminalNode NonEmptyStringLiteral() { return getToken(SolidityParser.NonEmptyStringLiteral, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(NonEmptyStringLiteral);
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

	public static class SymbolAliasesContext extends ParserRuleContext {
		public ImportAliasesContext importAliases;
		public List<ImportAliasesContext> aliases = new ArrayList<ImportAliasesContext>();
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ImportAliasesContext> importAliases() {
			return getRuleContexts(ImportAliasesContext.class);
		}
		public ImportAliasesContext importAliases(int i) {
			return getRuleContext(ImportAliasesContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public SymbolAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSymbolAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSymbolAliases(this);
		}
	}

	public final SymbolAliasesContext symbolAliases() throws RecognitionException {
		SymbolAliasesContext _localctx = new SymbolAliasesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbolAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(LBrace);
			setState(244);
			((SymbolAliasesContext)_localctx).importAliases = importAliases();
			((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(245);
				match(Comma);
				setState(246);
				((SymbolAliasesContext)_localctx).importAliases = importAliases();
				((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			match(RBrace);
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

	public static class ContractDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Contract() { return getToken(SolidityParser.Contract, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Abstract() { return getToken(SolidityParser.Abstract, 0); }
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public ContractDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContractDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContractDefinition(this);
		}
	}

	public final ContractDefinitionContext contractDefinition() throws RecognitionException {
		ContractDefinitionContext _localctx = new ContractDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contractDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(254);
				match(Abstract);
				}
			}

			setState(257);
			match(Contract);
			setState(258);
			((ContractDefinitionContext)_localctx).name = identifier();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(259);
				inheritanceSpecifierList();
				}
			}

			setState(262);
			match(LBrace);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Constructor) | (1L << Enum) | (1L << Error) | (1L << Event) | (1L << Fallback) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Modifier) | (1L << Receive) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Struct) | (1L << Transient) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (Using - 64)))) != 0) || _la==Identifier) {
				{
				{
				setState(263);
				contractBodyElement();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			match(RBrace);
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

	public static class InterfaceDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Interface() { return getToken(SolidityParser.Interface, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public InterfaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInterfaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInterfaceDefinition(this);
		}
	}

	public final InterfaceDefinitionContext interfaceDefinition() throws RecognitionException {
		InterfaceDefinitionContext _localctx = new InterfaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_interfaceDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(Interface);
			setState(272);
			((InterfaceDefinitionContext)_localctx).name = identifier();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(273);
				inheritanceSpecifierList();
				}
			}

			setState(276);
			match(LBrace);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Constructor) | (1L << Enum) | (1L << Error) | (1L << Event) | (1L << Fallback) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Modifier) | (1L << Receive) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Struct) | (1L << Transient) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (Using - 64)))) != 0) || _la==Identifier) {
				{
				{
				setState(277);
				contractBodyElement();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
			match(RBrace);
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

	public static class LibraryDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Library() { return getToken(SolidityParser.Library, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public LibraryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraryDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterLibraryDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitLibraryDefinition(this);
		}
	}

	public final LibraryDefinitionContext libraryDefinition() throws RecognitionException {
		LibraryDefinitionContext _localctx = new LibraryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_libraryDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(Library);
			setState(286);
			((LibraryDefinitionContext)_localctx).name = identifier();
			setState(287);
			match(LBrace);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Constructor) | (1L << Enum) | (1L << Error) | (1L << Event) | (1L << Fallback) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Modifier) | (1L << Receive) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Struct) | (1L << Transient) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (Using - 64)))) != 0) || _la==Identifier) {
				{
				{
				setState(288);
				contractBodyElement();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			match(RBrace);
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

	public static class InheritanceSpecifierListContext extends ParserRuleContext {
		public InheritanceSpecifierContext inheritanceSpecifier;
		public List<InheritanceSpecifierContext> inheritanceSpecifiers = new ArrayList<InheritanceSpecifierContext>();
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public List<InheritanceSpecifierContext> inheritanceSpecifier() {
			return getRuleContexts(InheritanceSpecifierContext.class);
		}
		public InheritanceSpecifierContext inheritanceSpecifier(int i) {
			return getRuleContext(InheritanceSpecifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InheritanceSpecifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInheritanceSpecifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInheritanceSpecifierList(this);
		}
	}

	public final InheritanceSpecifierListContext inheritanceSpecifierList() throws RecognitionException {
		InheritanceSpecifierListContext _localctx = new InheritanceSpecifierListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inheritanceSpecifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(Is);
			setState(297);
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(298);
					match(Comma);
					setState(299);
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class InheritanceSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext name;
		public CallArgumentListContext arguments;
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public InheritanceSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInheritanceSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInheritanceSpecifier(this);
		}
	}

	public final InheritanceSpecifierContext inheritanceSpecifier() throws RecognitionException {
		InheritanceSpecifierContext _localctx = new InheritanceSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inheritanceSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			((InheritanceSpecifierContext)_localctx).name = identifierPath();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(306);
				((InheritanceSpecifierContext)_localctx).arguments = callArgumentList();
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

	public static class ContractBodyElementContext extends ParserRuleContext {
		public ConstructorDefinitionContext constructorDefinition() {
			return getRuleContext(ConstructorDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ModifierDefinitionContext modifierDefinition() {
			return getRuleContext(ModifierDefinitionContext.class,0);
		}
		public FallbackFunctionDefinitionContext fallbackFunctionDefinition() {
			return getRuleContext(FallbackFunctionDefinitionContext.class,0);
		}
		public ReceiveFunctionDefinitionContext receiveFunctionDefinition() {
			return getRuleContext(ReceiveFunctionDefinitionContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,0);
		}
		public StateVariableDeclarationContext stateVariableDeclaration() {
			return getRuleContext(StateVariableDeclarationContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public ErrorDefinitionContext errorDefinition() {
			return getRuleContext(ErrorDefinitionContext.class,0);
		}
		public UsingDirectiveContext usingDirective() {
			return getRuleContext(UsingDirectiveContext.class,0);
		}
		public ContractBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContractBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContractBodyElement(this);
		}
	}

	public final ContractBodyElementContext contractBodyElement() throws RecognitionException {
		ContractBodyElementContext _localctx = new ContractBodyElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contractBodyElement);
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				constructorDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				modifierDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				fallbackFunctionDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				receiveFunctionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(314);
				structDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				enumDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(316);
				userDefinedValueTypeDefinition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(317);
				stateVariableDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(318);
				eventDefinition();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(319);
				errorDefinition();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(320);
				usingDirective();
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

	public static class NamedArgumentContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext value;
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNamedArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNamedArgument(this);
		}
	}

	public final NamedArgumentContext namedArgument() throws RecognitionException {
		NamedArgumentContext _localctx = new NamedArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_namedArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			((NamedArgumentContext)_localctx).name = identifier();
			setState(324);
			match(Colon);
			setState(325);
			((NamedArgumentContext)_localctx).value = expression(0);
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

	public static class CallArgumentListContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public CallArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterCallArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitCallArgumentList(this);
		}
	}

	public final CallArgumentListContext callArgumentList() throws RecognitionException {
		CallArgumentListContext _localctx = new CallArgumentListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(LParen);
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case RParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
					{
					setState(328);
					expression(0);
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(329);
						match(Comma);
						setState(330);
						expression(0);
						}
						}
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case LBrace:
				{
				setState(338);
				match(LBrace);
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
					{
					setState(339);
					namedArgument();
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(340);
						match(Comma);
						setState(341);
						namedArgument();
						}
						}
						setState(346);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(349);
				match(RBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(352);
			match(RParen);
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

	public static class IdentifierPathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Period() { return getTokens(SolidityParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(SolidityParser.Period, i);
		}
		public IdentifierPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIdentifierPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIdentifierPath(this);
		}
	}

	public final IdentifierPathContext identifierPath() throws RecognitionException {
		IdentifierPathContext _localctx = new IdentifierPathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifierPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			identifier();
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(355);
					match(Period);
					setState(356);
					identifier();
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ModifierInvocationContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public ModifierInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterModifierInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitModifierInvocation(this);
		}
	}

	public final ModifierInvocationContext modifierInvocation() throws RecognitionException {
		ModifierInvocationContext _localctx = new ModifierInvocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modifierInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			identifierPath();
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(363);
				callArgumentList();
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

	public static class VisibilityContext extends ParserRuleContext {
		public TerminalNode Internal() { return getToken(SolidityParser.Internal, 0); }
		public TerminalNode External() { return getToken(SolidityParser.External, 0); }
		public TerminalNode Private() { return getToken(SolidityParser.Private, 0); }
		public TerminalNode Public() { return getToken(SolidityParser.Public, 0); }
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVisibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVisibility(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << External) | (1L << Internal) | (1L << Private) | (1L << Public))) != 0)) ) {
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

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration;
		public List<ParameterDeclarationContext> parameters = new ArrayList<ParameterDeclarationContext>();
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
			((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(369);
				match(Comma);
				setState(370);
				((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
				((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
				}
				}
				setState(375);
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

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitParameterDeclaration(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			((ParameterDeclarationContext)_localctx).type = typeName(0);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Calldata) | (1L << Memory) | (1L << Storage))) != 0)) {
				{
				setState(377);
				((ParameterDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(380);
				((ParameterDeclarationContext)_localctx).name = identifier();
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

	public static class ConstructorDefinitionContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Constructor() { return getToken(SolidityParser.Constructor, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ConstructorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConstructorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConstructorDefinition(this);
		}
	}

	public final ConstructorDefinitionContext constructorDefinition() throws RecognitionException {
		ConstructorDefinitionContext _localctx = new ConstructorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constructorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(Constructor);
			setState(384);
			match(LParen);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(385);
				((ConstructorDefinitionContext)_localctx).arguments = parameterList();
				}
			}

			setState(388);
			match(RParen);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Internal) | (1L << Payable) | (1L << Public) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(393);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(389);
					modifierInvocation();
					}
					break;
				case Payable:
					{
					setState(390);
					match(Payable);
					}
					break;
				case Internal:
					{
					setState(391);
					match(Internal);
					}
					break;
				case Public:
					{
					setState(392);
					match(Public);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(398);
			((ConstructorDefinitionContext)_localctx).body = block();
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

	public static class StateMutabilityContext extends ParserRuleContext {
		public TerminalNode Pure() { return getToken(SolidityParser.Pure, 0); }
		public TerminalNode View() { return getToken(SolidityParser.View, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public StateMutabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateMutability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStateMutability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStateMutability(this);
		}
	}

	public final StateMutabilityContext stateMutability() throws RecognitionException {
		StateMutabilityContext _localctx = new StateMutabilityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (Payable - 47)) | (1L << (Pure - 47)) | (1L << (View - 47)))) != 0)) ) {
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

	public static class OverrideSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath;
		public List<IdentifierPathContext> overrides = new ArrayList<IdentifierPathContext>();
		public TerminalNode Override() { return getToken(SolidityParser.Override, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<IdentifierPathContext> identifierPath() {
			return getRuleContexts(IdentifierPathContext.class);
		}
		public IdentifierPathContext identifierPath(int i) {
			return getRuleContext(IdentifierPathContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public OverrideSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOverrideSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOverrideSpecifier(this);
		}
	}

	public final OverrideSpecifierContext overrideSpecifier() throws RecognitionException {
		OverrideSpecifierContext _localctx = new OverrideSpecifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(Override);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(403);
				match(LParen);
				setState(404);
				((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
				((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(405);
					match(Comma);
					setState(406);
					((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
					((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(412);
				match(RParen);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<TerminalNode> Constant() { return getTokens(SolidityParser.Constant); }
		public TerminalNode Constant(int i) {
			return getToken(SolidityParser.Constant, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(Function);
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				{
				setState(417);
				identifier();
				}
				break;
			case Fallback:
				{
				setState(418);
				match(Fallback);
				}
				break;
			case Receive:
				{
				setState(419);
				match(Receive);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(422);
			match(LParen);
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(423);
				((FunctionDefinitionContext)_localctx).arguments = parameterList();
				}
			}

			setState(426);
			match(RParen);
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Constant) | (1L << Error) | (1L << External) | (1L << From) | (1L << Global) | (1L << Internal) | (1L << Override) | (1L << Payable) | (1L << Private) | (1L << Public) | (1L << Pure) | (1L << Revert) | (1L << Transient))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (View - 69)) | (1L << (Virtual - 69)) | (1L << (Identifier - 69)))) != 0)) {
				{
				setState(433);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
				case Internal:
				case Private:
				case Public:
					{
					setState(427);
					visibility();
					}
					break;
				case Payable:
				case Pure:
				case View:
					{
					setState(428);
					stateMutability();
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(429);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(430);
					match(Virtual);
					}
					break;
				case Constant:
					{
					setState(431);
					match(Constant);
					}
					break;
				case Override:
					{
					setState(432);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(438);
				match(Returns);
				setState(439);
				match(LParen);
				setState(440);
				((FunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(441);
				match(RParen);
				}
			}

			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(445);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(446);
				((FunctionDefinitionContext)_localctx).body = block();
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

	public static class ModifierDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Modifier() { return getToken(SolidityParser.Modifier, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterModifierDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitModifierDefinition(this);
		}
	}

	public final ModifierDefinitionContext modifierDefinition() throws RecognitionException {
		ModifierDefinitionContext _localctx = new ModifierDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_modifierDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(Modifier);
			setState(450);
			((ModifierDefinitionContext)_localctx).name = identifier();
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(451);
				match(LParen);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
					{
					setState(452);
					((ModifierDefinitionContext)_localctx).arguments = parameterList();
					}
				}

				setState(455);
				match(RParen);
				}
			}

			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Override || _la==Virtual) {
				{
				setState(460);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Virtual:
					{
					setState(458);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(459);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(465);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(466);
				((ModifierDefinitionContext)_localctx).body = block();
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

	public static class FallbackFunctionDefinitionContext extends ParserRuleContext {
		public Token kind;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FallbackFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fallbackFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFallbackFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFallbackFunctionDefinition(this);
		}
	}

	public final FallbackFunctionDefinitionContext fallbackFunctionDefinition() throws RecognitionException {
		FallbackFunctionDefinitionContext _localctx = new FallbackFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fallbackFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			((FallbackFunctionDefinitionContext)_localctx).kind = match(Fallback);
			setState(470);
			match(LParen);
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(471);
				parameterList();
				}
			}

			setState(474);
			match(RParen);
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << External) | (1L << From) | (1L << Global) | (1L << Override) | (1L << Payable) | (1L << Pure) | (1L << Revert) | (1L << Transient))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (View - 69)) | (1L << (Virtual - 69)) | (1L << (Identifier - 69)))) != 0)) {
				{
				setState(480);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
					{
					setState(475);
					match(External);
					}
					break;
				case Payable:
				case Pure:
				case View:
					{
					setState(476);
					stateMutability();
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(477);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(478);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(479);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(485);
				match(Returns);
				setState(486);
				match(LParen);
				setState(487);
				((FallbackFunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(488);
				match(RParen);
				}
			}

			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(492);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(493);
				((FallbackFunctionDefinitionContext)_localctx).body = block();
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

	public static class ReceiveFunctionDefinitionContext extends ParserRuleContext {
		public Token kind;
		public BlockContext body;
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReceiveFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiveFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterReceiveFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitReceiveFunctionDefinition(this);
		}
	}

	public final ReceiveFunctionDefinitionContext receiveFunctionDefinition() throws RecognitionException {
		ReceiveFunctionDefinitionContext _localctx = new ReceiveFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_receiveFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			((ReceiveFunctionDefinitionContext)_localctx).kind = match(Receive);
			setState(497);
			match(LParen);
			setState(498);
			match(RParen);
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << External) | (1L << From) | (1L << Global) | (1L << Override) | (1L << Payable) | (1L << Revert) | (1L << Transient))) != 0) || _la==Virtual || _la==Identifier) {
				{
				setState(504);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
					{
					setState(499);
					match(External);
					}
					break;
				case Payable:
					{
					setState(500);
					match(Payable);
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(501);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(502);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(503);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(511);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(509);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(510);
				((ReceiveFunctionDefinitionContext)_localctx).body = block();
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

	public static class StructDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public StructMemberContext members;
		public TerminalNode Struct() { return getToken(SolidityParser.Struct, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStructDefinition(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(Struct);
			setState(514);
			((StructDefinitionContext)_localctx).name = identifier();
			setState(515);
			match(LBrace);
			setState(517); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(516);
				((StructDefinitionContext)_localctx).members = structMember();
				}
				}
				setState(519); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier );
			setState(521);
			match(RBrace);
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

	public static class StructMemberContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStructMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStructMember(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_structMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			((StructMemberContext)_localctx).type = typeName(0);
			setState(524);
			((StructMemberContext)_localctx).name = identifier();
			setState(525);
			match(Semicolon);
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

	public static class EnumDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> enumValues = new ArrayList<IdentifierContext>();
		public TerminalNode Enum() { return getToken(SolidityParser.Enum, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEnumDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEnumDefinition(this);
		}
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(Enum);
			setState(528);
			((EnumDefinitionContext)_localctx).name = identifier();
			setState(529);
			match(LBrace);
			setState(530);
			((EnumDefinitionContext)_localctx).identifier = identifier();
			((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(531);
				match(Comma);
				setState(532);
				((EnumDefinitionContext)_localctx).identifier = identifier();
				((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
			match(RBrace);
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

	public static class UserDefinedValueTypeDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public AddressPayableContext addressPayable() {
			return getRuleContext(AddressPayableContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedValueTypeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUserDefinedValueTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUserDefinedValueTypeDefinition(this);
		}
	}

	public final UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() throws RecognitionException {
		UserDefinedValueTypeDefinitionContext _localctx = new UserDefinedValueTypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_userDefinedValueTypeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(Type);
			setState(541);
			((UserDefinedValueTypeDefinitionContext)_localctx).name = identifier();
			setState(542);
			match(Is);
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(543);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(544);
				addressPayable();
				}
				break;
			}
			setState(547);
			match(Semicolon);
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

	public static class StateVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public List<TerminalNode> Private() { return getTokens(SolidityParser.Private); }
		public TerminalNode Private(int i) {
			return getToken(SolidityParser.Private, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Constant() { return getTokens(SolidityParser.Constant); }
		public TerminalNode Constant(int i) {
			return getToken(SolidityParser.Constant, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public List<TerminalNode> Immutable() { return getTokens(SolidityParser.Immutable); }
		public TerminalNode Immutable(int i) {
			return getToken(SolidityParser.Immutable, i);
		}
		public List<TerminalNode> Transient() { return getTokens(SolidityParser.Transient); }
		public TerminalNode Transient(int i) {
			return getToken(SolidityParser.Transient, i);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStateVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStateVariableDeclaration(this);
		}
	}

	public final StateVariableDeclarationContext stateVariableDeclaration() throws RecognitionException {
		StateVariableDeclarationContext _localctx = new StateVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stateVariableDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			((StateVariableDeclarationContext)_localctx).type = typeName(0);
			setState(559);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(557);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Public:
						{
						setState(550);
						match(Public);
						}
						break;
					case Private:
						{
						setState(551);
						match(Private);
						}
						break;
					case Internal:
						{
						setState(552);
						match(Internal);
						}
						break;
					case Constant:
						{
						setState(553);
						match(Constant);
						}
						break;
					case Override:
						{
						setState(554);
						overrideSpecifier();
						}
						break;
					case Immutable:
						{
						setState(555);
						match(Immutable);
						}
						break;
					case Transient:
						{
						setState(556);
						match(Transient);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(561);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(562);
			((StateVariableDeclarationContext)_localctx).name = identifier();
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(563);
				match(Assign);
				setState(564);
				((StateVariableDeclarationContext)_localctx).initialValue = expression(0);
				}
			}

			setState(567);
			match(Semicolon);
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

	public static class ConstantVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Constant() { return getToken(SolidityParser.Constant, 0); }
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConstantVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConstantVariableDeclaration(this);
		}
	}

	public final ConstantVariableDeclarationContext constantVariableDeclaration() throws RecognitionException {
		ConstantVariableDeclarationContext _localctx = new ConstantVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			((ConstantVariableDeclarationContext)_localctx).type = typeName(0);
			setState(570);
			match(Constant);
			setState(571);
			((ConstantVariableDeclarationContext)_localctx).name = identifier();
			setState(572);
			match(Assign);
			setState(573);
			((ConstantVariableDeclarationContext)_localctx).initialValue = expression(0);
			setState(574);
			match(Semicolon);
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

	public static class EventParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Indexed() { return getToken(SolidityParser.Indexed, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEventParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEventParameter(this);
		}
	}

	public final EventParameterContext eventParameter() throws RecognitionException {
		EventParameterContext _localctx = new EventParameterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			((EventParameterContext)_localctx).type = typeName(0);
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Indexed) {
				{
				setState(577);
				match(Indexed);
				}
			}

			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(580);
				((EventParameterContext)_localctx).name = identifier();
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

	public static class EventDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public EventParameterContext eventParameter;
		public List<EventParameterContext> parameters = new ArrayList<EventParameterContext>();
		public TerminalNode Event() { return getToken(SolidityParser.Event, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Anonymous() { return getToken(SolidityParser.Anonymous, 0); }
		public List<EventParameterContext> eventParameter() {
			return getRuleContexts(EventParameterContext.class);
		}
		public EventParameterContext eventParameter(int i) {
			return getRuleContext(EventParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEventDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEventDefinition(this);
		}
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(Event);
			setState(584);
			((EventDefinitionContext)_localctx).name = identifier();
			setState(585);
			match(LParen);
			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(586);
				((EventDefinitionContext)_localctx).eventParameter = eventParameter();
				((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(587);
					match(Comma);
					setState(588);
					((EventDefinitionContext)_localctx).eventParameter = eventParameter();
					((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
					}
					}
					setState(593);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(596);
			match(RParen);
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Anonymous) {
				{
				setState(597);
				match(Anonymous);
				}
			}

			setState(600);
			match(Semicolon);
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

	public static class ErrorParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ErrorParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterErrorParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitErrorParameter(this);
		}
	}

	public final ErrorParameterContext errorParameter() throws RecognitionException {
		ErrorParameterContext _localctx = new ErrorParameterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_errorParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			((ErrorParameterContext)_localctx).type = typeName(0);
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(603);
				((ErrorParameterContext)_localctx).name = identifier();
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

	public static class ErrorDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public ErrorParameterContext errorParameter;
		public List<ErrorParameterContext> parameters = new ArrayList<ErrorParameterContext>();
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ErrorParameterContext> errorParameter() {
			return getRuleContexts(ErrorParameterContext.class);
		}
		public ErrorParameterContext errorParameter(int i) {
			return getRuleContext(ErrorParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ErrorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterErrorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitErrorDefinition(this);
		}
	}

	public final ErrorDefinitionContext errorDefinition() throws RecognitionException {
		ErrorDefinitionContext _localctx = new ErrorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_errorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(Error);
			setState(607);
			((ErrorDefinitionContext)_localctx).name = identifier();
			setState(608);
			match(LParen);
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(609);
				((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
				((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(610);
					match(Comma);
					setState(611);
					((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
					((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
					}
					}
					setState(616);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(619);
			match(RParen);
			setState(620);
			match(Semicolon);
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

	public static class UserDefinableOperatorContext extends ParserRuleContext {
		public TerminalNode BitAnd() { return getToken(SolidityParser.BitAnd, 0); }
		public TerminalNode BitNot() { return getToken(SolidityParser.BitNot, 0); }
		public TerminalNode BitOr() { return getToken(SolidityParser.BitOr, 0); }
		public TerminalNode BitXor() { return getToken(SolidityParser.BitXor, 0); }
		public TerminalNode Add() { return getToken(SolidityParser.Add, 0); }
		public TerminalNode Div() { return getToken(SolidityParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SolidityParser.Mod, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public TerminalNode Equal() { return getToken(SolidityParser.Equal, 0); }
		public TerminalNode GreaterThan() { return getToken(SolidityParser.GreaterThan, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(SolidityParser.GreaterThanOrEqual, 0); }
		public TerminalNode LessThan() { return getToken(SolidityParser.LessThan, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(SolidityParser.LessThanOrEqual, 0); }
		public TerminalNode NotEqual() { return getToken(SolidityParser.NotEqual, 0); }
		public UserDefinableOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinableOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUserDefinableOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUserDefinableOperator(this);
		}
	}

	public final UserDefinableOperatorContext userDefinableOperator() throws RecognitionException {
		UserDefinableOperatorContext _localctx = new UserDefinableOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_userDefinableOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (BitOr - 99)) | (1L << (BitXor - 99)) | (1L << (BitAnd - 99)) | (1L << (Add - 99)) | (1L << (Sub - 99)) | (1L << (Mul - 99)) | (1L << (Div - 99)) | (1L << (Mod - 99)) | (1L << (Equal - 99)) | (1L << (NotEqual - 99)) | (1L << (LessThan - 99)) | (1L << (GreaterThan - 99)) | (1L << (LessThanOrEqual - 99)) | (1L << (GreaterThanOrEqual - 99)) | (1L << (BitNot - 99)))) != 0)) ) {
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

	public static class UsingDirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(SolidityParser.Using, 0); }
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Global() { return getToken(SolidityParser.Global, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public List<UsingAliasesContext> usingAliases() {
			return getRuleContexts(UsingAliasesContext.class);
		}
		public UsingAliasesContext usingAliases(int i) {
			return getRuleContext(UsingAliasesContext.class,i);
		}
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public UsingDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUsingDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUsingDirective(this);
		}
	}

	public final UsingDirectiveContext usingDirective() throws RecognitionException {
		UsingDirectiveContext _localctx = new UsingDirectiveContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_usingDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(Using);
			setState(637);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				{
				setState(625);
				identifierPath();
				}
				break;
			case LBrace:
				{
				{
				setState(626);
				match(LBrace);
				setState(627);
				usingAliases();
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(628);
					match(Comma);
					setState(629);
					usingAliases();
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(635);
				match(RBrace);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(639);
			match(For);
			setState(642);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Mul:
				{
				setState(640);
				match(Mul);
				}
				break;
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case Ufixed:
			case UnsignedIntegerType:
			case Identifier:
				{
				setState(641);
				typeName(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Global) {
				{
				setState(644);
				match(Global);
				}
			}

			setState(647);
			match(Semicolon);
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

	public static class UsingAliasesContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public UserDefinableOperatorContext userDefinableOperator() {
			return getRuleContext(UserDefinableOperatorContext.class,0);
		}
		public UsingAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUsingAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUsingAliases(this);
		}
	}

	public final UsingAliasesContext usingAliases() throws RecognitionException {
		UsingAliasesContext _localctx = new UsingAliasesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_usingAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			identifierPath();
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(650);
				match(As);
				setState(651);
				userDefinableOperator();
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

	public static class TypeNameContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public AddressPayableContext addressPayable() {
			return getRuleContext(AddressPayableContext.class,0);
		}
		public FunctionTypeNameContext functionTypeName() {
			return getRuleContext(FunctionTypeNameContext.class,0);
		}
		public MappingTypeContext mappingType() {
			return getRuleContext(MappingTypeContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(655);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(656);
				addressPayable();
				}
				break;
			case 3:
				{
				setState(657);
				functionTypeName();
				}
				break;
			case 4:
				{
				setState(658);
				mappingType();
				}
				break;
			case 5:
				{
				setState(659);
				identifierPath();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(670);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(662);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(663);
					match(LBrack);
					setState(665);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
						{
						setState(664);
						expression(0);
						}
					}

					setState(667);
					match(RBrack);
					}
					} 
				}
				setState(672);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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

	public static class ElementaryTypeNameContext extends ParserRuleContext {
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public TerminalNode Bool() { return getToken(SolidityParser.Bool, 0); }
		public TerminalNode String() { return getToken(SolidityParser.String, 0); }
		public TerminalNode Bytes() { return getToken(SolidityParser.Bytes, 0); }
		public TerminalNode SignedIntegerType() { return getToken(SolidityParser.SignedIntegerType, 0); }
		public TerminalNode UnsignedIntegerType() { return getToken(SolidityParser.UnsignedIntegerType, 0); }
		public TerminalNode FixedBytes() { return getToken(SolidityParser.FixedBytes, 0); }
		public TerminalNode Fixed() { return getToken(SolidityParser.Fixed, 0); }
		public TerminalNode Ufixed() { return getToken(SolidityParser.Ufixed, 0); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementaryTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterElementaryTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitElementaryTypeName(this);
		}
	}

	public final ElementaryTypeNameContext elementaryTypeName() throws RecognitionException {
		ElementaryTypeNameContext _localctx = new ElementaryTypeNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_elementaryTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Fixed) | (1L << FixedBytes) | (1L << SignedIntegerType) | (1L << String))) != 0) || _la==Ufixed || _la==UnsignedIntegerType) ) {
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

	public static class AddressPayableContext extends ParserRuleContext {
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public AddressPayableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addressPayable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAddressPayable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAddressPayable(this);
		}
	}

	public final AddressPayableContext addressPayable() throws RecognitionException {
		AddressPayableContext _localctx = new AddressPayableContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_addressPayable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(Address);
			setState(676);
			match(Payable);
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

	public static class FunctionTypeNameContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionTypeName(this);
		}
	}

	public final FunctionTypeNameContext functionTypeName() throws RecognitionException {
		FunctionTypeNameContext _localctx = new FunctionTypeNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_functionTypeName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(Function);
			setState(679);
			match(LParen);
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(680);
				((FunctionTypeNameContext)_localctx).arguments = parameterList();
				}
			}

			setState(683);
			match(RParen);
			setState(688);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(686);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case External:
					case Internal:
					case Private:
					case Public:
						{
						setState(684);
						visibility();
						}
						break;
					case Payable:
					case Pure:
					case View:
						{
						setState(685);
						stateMutability();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(690);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(691);
				match(Returns);
				setState(692);
				match(LParen);
				setState(693);
				((FunctionTypeNameContext)_localctx).returnParameters = parameterList();
				setState(694);
				match(RParen);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			((VariableDeclarationContext)_localctx).type = typeName(0);
			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Calldata) | (1L << Memory) | (1L << Storage))) != 0)) {
				{
				setState(699);
				((VariableDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(702);
			((VariableDeclarationContext)_localctx).name = identifier();
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

	public static class DataLocationContext extends ParserRuleContext {
		public TerminalNode Memory() { return getToken(SolidityParser.Memory, 0); }
		public TerminalNode Storage() { return getToken(SolidityParser.Storage, 0); }
		public TerminalNode Calldata() { return getToken(SolidityParser.Calldata, 0); }
		public DataLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterDataLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitDataLocation(this);
		}
	}

	public final DataLocationContext dataLocation() throws RecognitionException {
		DataLocationContext _localctx = new DataLocationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_dataLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Calldata) | (1L << Memory) | (1L << Storage))) != 0)) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryPrefixOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public TerminalNode Not() { return getToken(SolidityParser.Not, 0); }
		public TerminalNode BitNot() { return getToken(SolidityParser.BitNot, 0); }
		public TerminalNode Delete() { return getToken(SolidityParser.Delete, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public UnaryPrefixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnaryPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnaryPrefixOperation(this);
		}
	}
	public static class PrimaryExpressionContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralWithSubDenominationContext literalWithSubDenomination() {
			return getRuleContext(LiteralWithSubDenominationContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public PrimaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPrimaryExpression(this);
		}
	}
	public static class OrderComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LessThan() { return getToken(SolidityParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(SolidityParser.GreaterThan, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(SolidityParser.LessThanOrEqual, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(SolidityParser.GreaterThanOrEqual, 0); }
		public OrderComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOrderComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOrderComparison(this);
		}
	}
	public static class ConditionalContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Conditional() { return getToken(SolidityParser.Conditional, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public ConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConditional(this);
		}
	}
	public static class PayableConversionContext extends ExpressionContext {
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public PayableConversionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPayableConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPayableConversion(this);
		}
	}
	public static class AssignmentContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public AssignmentContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssignment(this);
		}
	}
	public static class UnarySuffixOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public UnarySuffixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnarySuffixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnarySuffixOperation(this);
		}
	}
	public static class ShiftOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Shl() { return getToken(SolidityParser.Shl, 0); }
		public TerminalNode Sar() { return getToken(SolidityParser.Sar, 0); }
		public TerminalNode Shr() { return getToken(SolidityParser.Shr, 0); }
		public ShiftOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterShiftOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitShiftOperation(this);
		}
	}
	public static class BitAndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitAnd() { return getToken(SolidityParser.BitAnd, 0); }
		public BitAndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitAndOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitAndOperation(this);
		}
	}
	public static class FunctionCallContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public FunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionCall(this);
		}
	}
	public static class IndexRangeAccessContext extends ExpressionContext {
		public ExpressionContext startIndex;
		public ExpressionContext endIndex;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexRangeAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIndexRangeAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIndexRangeAccess(this);
		}
	}
	public static class IndexAccessContext extends ExpressionContext {
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIndexAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIndexAccess(this);
		}
	}
	public static class AddSubOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(SolidityParser.Add, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public AddSubOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAddSubOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAddSubOperation(this);
		}
	}
	public static class BitOrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitOr() { return getToken(SolidityParser.BitOr, 0); }
		public BitOrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitOrOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitOrOperation(this);
		}
	}
	public static class ExpOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Exp() { return getToken(SolidityParser.Exp, 0); }
		public ExpOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterExpOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitExpOperation(this);
		}
	}
	public static class AndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(SolidityParser.And, 0); }
		public AndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAndOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAndOperation(this);
		}
	}
	public static class InlineArrayContext extends ExpressionContext {
		public InlineArrayExpressionContext inlineArrayExpression() {
			return getRuleContext(InlineArrayExpressionContext.class,0);
		}
		public InlineArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInlineArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInlineArray(this);
		}
	}
	public static class OrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(SolidityParser.Or, 0); }
		public OrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOrOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOrOperation(this);
		}
	}
	public static class MemberAccessContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Period() { return getToken(SolidityParser.Period, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public MemberAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMemberAccess(this);
		}
	}
	public static class MulDivModOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode Div() { return getToken(SolidityParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SolidityParser.Mod, 0); }
		public MulDivModOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMulDivModOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMulDivModOperation(this);
		}
	}
	public static class FunctionCallOptionsContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public FunctionCallOptionsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionCallOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionCallOptions(this);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(SolidityParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNewExpr(this);
		}
	}
	public static class BitXorOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitXor() { return getToken(SolidityParser.BitXor, 0); }
		public BitXorOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitXorOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitXorOperation(this);
		}
	}
	public static class TupleContext extends ExpressionContext {
		public TupleExpressionContext tupleExpression() {
			return getRuleContext(TupleExpressionContext.class,0);
		}
		public TupleContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTuple(this);
		}
	}
	public static class EqualityComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equal() { return getToken(SolidityParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SolidityParser.NotEqual, 0); }
		public EqualityComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEqualityComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEqualityComparison(this);
		}
	}
	public static class MetaTypeContext extends ExpressionContext {
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MetaTypeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMetaType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMetaType(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Payable:
				{
				_localctx = new PayableConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(707);
				match(Payable);
				setState(708);
				callArgumentList();
				}
				break;
			case Type:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(709);
				match(Type);
				setState(710);
				match(LParen);
				setState(711);
				typeName(0);
				setState(712);
				match(RParen);
				}
				break;
			case Delete:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
				{
				_localctx = new UnaryPrefixOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(714);
				_la = _input.LA(1);
				if ( !(_la==Delete || ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (Sub - 106)) | (1L << (Not - 106)) | (1L << (BitNot - 106)) | (1L << (Inc - 106)) | (1L << (Dec - 106)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(715);
				expression(19);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(716);
				match(New);
				setState(717);
				typeName(0);
				}
				break;
			case LParen:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				tupleExpression();
				}
				break;
			case LBrack:
				{
				_localctx = new InlineArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				inlineArrayExpression();
				}
				break;
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Ufixed:
			case UnsignedIntegerType:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(724);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(720);
					identifier();
					}
					break;
				case 2:
					{
					setState(721);
					literal();
					}
					break;
				case 3:
					{
					setState(722);
					literalWithSubDenomination();
					}
					break;
				case 4:
					{
					setState(723);
					elementaryTypeName();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(812);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(810);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						_localctx = new ExpOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(728);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(729);
						match(Exp);
						setState(730);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(731);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(732);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Mul - 107)) | (1L << (Div - 107)) | (1L << (Mod - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(733);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new AddSubOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(734);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(735);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(736);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ShiftOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(737);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(738);
						_la = _input.LA(1);
						if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (Shl - 102)) | (1L << (Sar - 102)) | (1L << (Shr - 102)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(739);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BitAndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(740);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(741);
						match(BitAnd);
						setState(742);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new BitXorOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(743);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(744);
						match(BitXor);
						setState(745);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BitOrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(746);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(747);
						match(BitOr);
						setState(748);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new OrderComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(749);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(750);
						_la = _input.LA(1);
						if ( !(((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (LessThan - 113)) | (1L << (GreaterThan - 113)) | (1L << (LessThanOrEqual - 113)) | (1L << (GreaterThanOrEqual - 113)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(751);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new EqualityComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(752);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(753);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(754);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new AndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(755);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(756);
						match(And);
						setState(757);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new OrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(758);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(759);
						match(Or);
						setState(760);
						expression(8);
						}
						break;
					case 12:
						{
						_localctx = new ConditionalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(761);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(762);
						match(Conditional);
						setState(763);
						expression(0);
						setState(764);
						match(Colon);
						setState(765);
						expression(6);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(767);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(768);
						assignOp();
						setState(769);
						expression(5);
						}
						break;
					case 14:
						{
						_localctx = new IndexAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(771);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(772);
						match(LBrack);
						setState(774);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(773);
							((IndexAccessContext)_localctx).index = expression(0);
							}
						}

						setState(776);
						match(RBrack);
						}
						break;
					case 15:
						{
						_localctx = new IndexRangeAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(777);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(778);
						match(LBrack);
						setState(780);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(779);
							((IndexRangeAccessContext)_localctx).startIndex = expression(0);
							}
						}

						setState(782);
						match(Colon);
						setState(784);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(783);
							((IndexRangeAccessContext)_localctx).endIndex = expression(0);
							}
						}

						setState(786);
						match(RBrack);
						}
						break;
					case 16:
						{
						_localctx = new MemberAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(787);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(788);
						match(Period);
						setState(791);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Error:
						case From:
						case Global:
						case Revert:
						case Transient:
						case Identifier:
							{
							setState(789);
							identifier();
							}
							break;
						case Address:
							{
							setState(790);
							match(Address);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 17:
						{
						_localctx = new FunctionCallOptionsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(793);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(794);
						match(LBrace);
						setState(803);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
							{
							setState(795);
							namedArgument();
							setState(800);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Comma) {
								{
								{
								setState(796);
								match(Comma);
								setState(797);
								namedArgument();
								}
								}
								setState(802);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(805);
						match(RBrace);
						}
						break;
					case 18:
						{
						_localctx = new FunctionCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(806);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(807);
						callArgumentList();
						}
						break;
					case 19:
						{
						_localctx = new UnarySuffixOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(808);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(809);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(814);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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

	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode AssignBitOr() { return getToken(SolidityParser.AssignBitOr, 0); }
		public TerminalNode AssignBitXor() { return getToken(SolidityParser.AssignBitXor, 0); }
		public TerminalNode AssignBitAnd() { return getToken(SolidityParser.AssignBitAnd, 0); }
		public TerminalNode AssignShl() { return getToken(SolidityParser.AssignShl, 0); }
		public TerminalNode AssignSar() { return getToken(SolidityParser.AssignSar, 0); }
		public TerminalNode AssignShr() { return getToken(SolidityParser.AssignShr, 0); }
		public TerminalNode AssignAdd() { return getToken(SolidityParser.AssignAdd, 0); }
		public TerminalNode AssignSub() { return getToken(SolidityParser.AssignSub, 0); }
		public TerminalNode AssignMul() { return getToken(SolidityParser.AssignMul, 0); }
		public TerminalNode AssignDiv() { return getToken(SolidityParser.AssignDiv, 0); }
		public TerminalNode AssignMod() { return getToken(SolidityParser.AssignMod, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssignOp(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (Assign - 84)) | (1L << (AssignBitOr - 84)) | (1L << (AssignBitXor - 84)) | (1L << (AssignBitAnd - 84)) | (1L << (AssignShl - 84)) | (1L << (AssignSar - 84)) | (1L << (AssignShr - 84)) | (1L << (AssignAdd - 84)) | (1L << (AssignSub - 84)) | (1L << (AssignMul - 84)) | (1L << (AssignDiv - 84)) | (1L << (AssignMod - 84)))) != 0)) ) {
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

	public static class TupleExpressionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public TupleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTupleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTupleExpression(this);
		}
	}

	public final TupleExpressionContext tupleExpression() throws RecognitionException {
		TupleExpressionContext _localctx = new TupleExpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_tupleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			match(LParen);
			{
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(818);
				expression(0);
				}
			}

			setState(827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(821);
				match(Comma);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
					{
					setState(822);
					expression(0);
					}
				}

				}
				}
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(830);
			match(RParen);
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

	public static class InlineArrayExpressionContext extends ParserRuleContext {
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InlineArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineArrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInlineArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInlineArrayExpression(this);
		}
	}

	public final InlineArrayExpressionContext inlineArrayExpression() throws RecognitionException {
		InlineArrayExpressionContext _localctx = new InlineArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_inlineArrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			match(LBrack);
			{
			setState(833);
			expression(0);
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(834);
				match(Comma);
				setState(835);
				expression(0);
				}
				}
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(841);
			match(RBrack);
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
		public TerminalNode Identifier() { return getToken(SolidityParser.Identifier, 0); }
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public TerminalNode Global() { return getToken(SolidityParser.Global, 0); }
		public TerminalNode Transient() { return getToken(SolidityParser.Transient, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) ) {
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
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public HexStringLiteralContext hexStringLiteral() {
			return getRuleContext(HexStringLiteralContext.class,0);
		}
		public UnicodeStringLiteralContext unicodeStringLiteral() {
			return getRuleContext(UnicodeStringLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_literal);
		try {
			setState(850);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(845);
				stringLiteral();
				}
				break;
			case HexNumber:
			case DecimalNumber:
				enterOuterAlt(_localctx, 2);
				{
				setState(846);
				numberLiteral();
				}
				break;
			case FalseLiteral:
			case TrueLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(847);
				boolLiteral();
				}
				break;
			case HexString:
				enterOuterAlt(_localctx, 4);
				{
				setState(848);
				hexStringLiteral();
				}
				break;
			case UnicodeStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(849);
				unicodeStringLiteral();
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

	public static class LiteralWithSubDenominationContext extends ParserRuleContext {
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public TerminalNode SubDenomination() { return getToken(SolidityParser.SubDenomination, 0); }
		public LiteralWithSubDenominationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalWithSubDenomination; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterLiteralWithSubDenomination(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitLiteralWithSubDenomination(this);
		}
	}

	public final LiteralWithSubDenominationContext literalWithSubDenomination() throws RecognitionException {
		LiteralWithSubDenominationContext _localctx = new LiteralWithSubDenominationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_literalWithSubDenomination);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			numberLiteral();
			setState(853);
			match(SubDenomination);
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

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TrueLiteral() { return getToken(SolidityParser.TrueLiteral, 0); }
		public TerminalNode FalseLiteral() { return getToken(SolidityParser.FalseLiteral, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBoolLiteral(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855);
			_la = _input.LA(1);
			if ( !(_la==FalseLiteral || _la==TrueLiteral) ) {
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

	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> NonEmptyStringLiteral() { return getTokens(SolidityParser.NonEmptyStringLiteral); }
		public TerminalNode NonEmptyStringLiteral(int i) {
			return getToken(SolidityParser.NonEmptyStringLiteral, i);
		}
		public List<TerminalNode> EmptyStringLiteral() { return getTokens(SolidityParser.EmptyStringLiteral); }
		public TerminalNode EmptyStringLiteral(int i) {
			return getToken(SolidityParser.EmptyStringLiteral, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(858); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(857);
					_la = _input.LA(1);
					if ( !(_la==NonEmptyStringLiteral || _la==EmptyStringLiteral) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(860); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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

	public static class HexStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> HexString() { return getTokens(SolidityParser.HexString); }
		public TerminalNode HexString(int i) {
			return getToken(SolidityParser.HexString, i);
		}
		public HexStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterHexStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitHexStringLiteral(this);
		}
	}

	public final HexStringLiteralContext hexStringLiteral() throws RecognitionException {
		HexStringLiteralContext _localctx = new HexStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_hexStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(863); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(862);
					match(HexString);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(865); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
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

	public static class UnicodeStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> UnicodeStringLiteral() { return getTokens(SolidityParser.UnicodeStringLiteral); }
		public TerminalNode UnicodeStringLiteral(int i) {
			return getToken(SolidityParser.UnicodeStringLiteral, i);
		}
		public UnicodeStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unicodeStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnicodeStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnicodeStringLiteral(this);
		}
	}

	public final UnicodeStringLiteralContext unicodeStringLiteral() throws RecognitionException {
		UnicodeStringLiteralContext _localctx = new UnicodeStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unicodeStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(868); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(867);
					match(UnicodeStringLiteral);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(870); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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

	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNumberLiteral(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			_la = _input.LA(1);
			if ( !(_la==HexNumber || _la==DecimalNumber) ) {
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<UncheckedBlockContext> uncheckedBlock() {
			return getRuleContexts(UncheckedBlockContext.class);
		}
		public UncheckedBlockContext uncheckedBlock(int i) {
			return getRuleContext(UncheckedBlockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			match(LBrace);
			setState(879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Assembly) | (1L << Bool) | (1L << Break) | (1L << Bytes) | (1L << Continue) | (1L << Delete) | (1L << Do) | (1L << Emit) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << For) | (1L << From) | (1L << Function) | (1L << Global) | (1L << If) | (1L << Mapping) | (1L << New) | (1L << Payable) | (1L << Return) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Try) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (Unchecked - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (While - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (LBrace - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(877);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Address:
				case Assembly:
				case Bool:
				case Break:
				case Bytes:
				case Continue:
				case Delete:
				case Do:
				case Emit:
				case Error:
				case FalseLiteral:
				case Fixed:
				case FixedBytes:
				case For:
				case From:
				case Function:
				case Global:
				case If:
				case Mapping:
				case New:
				case Payable:
				case Return:
				case Revert:
				case SignedIntegerType:
				case String:
				case Transient:
				case TrueLiteral:
				case Try:
				case Type:
				case Ufixed:
				case UnsignedIntegerType:
				case While:
				case LParen:
				case LBrack:
				case LBrace:
				case Sub:
				case Not:
				case BitNot:
				case Inc:
				case Dec:
				case NonEmptyStringLiteral:
				case EmptyStringLiteral:
				case UnicodeStringLiteral:
				case HexString:
				case HexNumber:
				case DecimalNumber:
				case Identifier:
					{
					setState(875);
					statement();
					}
					break;
				case Unchecked:
					{
					setState(876);
					uncheckedBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(882);
			match(RBrace);
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

	public static class UncheckedBlockContext extends ParserRuleContext {
		public TerminalNode Unchecked() { return getToken(SolidityParser.Unchecked, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public UncheckedBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncheckedBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUncheckedBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUncheckedBlock(this);
		}
	}

	public final UncheckedBlockContext uncheckedBlock() throws RecognitionException {
		UncheckedBlockContext _localctx = new UncheckedBlockContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_uncheckedBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(Unchecked);
			setState(885);
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public EmitStatementContext emitStatement() {
			return getRuleContext(EmitStatementContext.class,0);
		}
		public RevertStatementContext revertStatement() {
			return getRuleContext(RevertStatementContext.class,0);
		}
		public AssemblyStatementContext assemblyStatement() {
			return getRuleContext(AssemblyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_statement);
		try {
			setState(900);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(887);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(888);
				simpleStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(889);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(890);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(891);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(892);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(893);
				continueStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(894);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(895);
				tryStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(896);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(897);
				emitStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(898);
				revertStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(899);
				assemblyStatement();
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

	public static class SimpleStatementContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSimpleStatement(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_simpleStatement);
		try {
			setState(904);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(902);
				variableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(903);
				expressionStatement();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(SolidityParser.If, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SolidityParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			match(If);
			setState(907);
			match(LParen);
			setState(908);
			expression(0);
			setState(909);
			match(RParen);
			setState(910);
			statement();
			setState(913);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(911);
				match(Else);
				setState(912);
				statement();
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(SolidityParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(SolidityParser.Semicolon, i);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(For);
			setState(916);
			match(LParen);
			setState(919);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(917);
				simpleStatement();
				}
				break;
			case Semicolon:
				{
				setState(918);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(923);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(921);
				expressionStatement();
				}
				break;
			case Semicolon:
				{
				setState(922);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(925);
				expression(0);
				}
			}

			setState(928);
			match(RParen);
			setState(929);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931);
			match(While);
			setState(932);
			match(LParen);
			setState(933);
			expression(0);
			setState(934);
			match(RParen);
			setState(935);
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

	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(SolidityParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitDoWhileStatement(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937);
			match(Do);
			setState(938);
			statement();
			setState(939);
			match(While);
			setState(940);
			match(LParen);
			setState(941);
			expression(0);
			setState(942);
			match(RParen);
			setState(943);
			match(Semicolon);
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
		public TerminalNode Continue() { return getToken(SolidityParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			match(Continue);
			setState(946);
			match(Semicolon);
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
		public TerminalNode Break() { return getToken(SolidityParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(948);
			match(Break);
			setState(949);
			match(Semicolon);
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
		public ParameterListContext returnParameters;
		public TerminalNode Try() { return getToken(SolidityParser.Try, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTryStatement(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(951);
			match(Try);
			setState(952);
			expression(0);
			setState(958);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(953);
				match(Returns);
				setState(954);
				match(LParen);
				setState(955);
				((TryStatementContext)_localctx).returnParameters = parameterList();
				setState(956);
				match(RParen);
				}
			}

			setState(960);
			block();
			setState(962); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(961);
				catchClause();
				}
				}
				setState(964); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Catch );
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

	public static class CatchClauseContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public TerminalNode Catch() { return getToken(SolidityParser.Catch, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			match(Catch);
			setState(974);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==LParen || _la==Identifier) {
				{
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
					{
					setState(967);
					identifier();
					}
				}

				setState(970);
				match(LParen);
				{
				setState(971);
				((CatchClauseContext)_localctx).arguments = parameterList();
				}
				setState(972);
				match(RParen);
				}
			}

			setState(976);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(SolidityParser.Return, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(Return);
			setState(980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Delete) | (1L << Error) | (1L << FalseLiteral) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Global) | (1L << New) | (1L << Payable) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient) | (1L << TrueLiteral) | (1L << Type))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Ufixed - 64)) | (1L << (UnsignedIntegerType - 64)) | (1L << (LParen - 64)) | (1L << (LBrack - 64)) | (1L << (Sub - 64)) | (1L << (Not - 64)) | (1L << (BitNot - 64)) | (1L << (Inc - 64)) | (1L << (Dec - 64)) | (1L << (NonEmptyStringLiteral - 64)) | (1L << (EmptyStringLiteral - 64)) | (1L << (UnicodeStringLiteral - 64)) | (1L << (HexString - 64)) | (1L << (HexNumber - 64)))) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(979);
				expression(0);
				}
			}

			setState(982);
			match(Semicolon);
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

	public static class EmitStatementContext extends ParserRuleContext {
		public TerminalNode Emit() { return getToken(SolidityParser.Emit, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public EmitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emitStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEmitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEmitStatement(this);
		}
	}

	public final EmitStatementContext emitStatement() throws RecognitionException {
		EmitStatementContext _localctx = new EmitStatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			match(Emit);
			setState(985);
			expression(0);
			setState(986);
			callArgumentList();
			setState(987);
			match(Semicolon);
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

	public static class RevertStatementContext extends ParserRuleContext {
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public RevertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterRevertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitRevertStatement(this);
		}
	}

	public final RevertStatementContext revertStatement() throws RecognitionException {
		RevertStatementContext _localctx = new RevertStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_revertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(989);
			match(Revert);
			setState(990);
			expression(0);
			setState(991);
			callArgumentList();
			setState(992);
			match(Semicolon);
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

	public static class AssemblyStatementContext extends ParserRuleContext {
		public TerminalNode Assembly() { return getToken(SolidityParser.Assembly, 0); }
		public TerminalNode AssemblyLBrace() { return getToken(SolidityParser.AssemblyLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public TerminalNode AssemblyDialect() { return getToken(SolidityParser.AssemblyDialect, 0); }
		public AssemblyFlagsContext assemblyFlags() {
			return getRuleContext(AssemblyFlagsContext.class,0);
		}
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public AssemblyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssemblyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssemblyStatement(this);
		}
	}

	public final AssemblyStatementContext assemblyStatement() throws RecognitionException {
		AssemblyStatementContext _localctx = new AssemblyStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_assemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(994);
			match(Assembly);
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyDialect) {
				{
				setState(995);
				match(AssemblyDialect);
				}
			}

			setState(999);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyBlockLParen) {
				{
				setState(998);
				assemblyFlags();
				}
			}

			setState(1001);
			match(AssemblyLBrace);
			setState(1005);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (YulBreak - 144)) | (1L << (YulContinue - 144)) | (1L << (YulFor - 144)) | (1L << (YulFunction - 144)) | (1L << (YulIf - 144)) | (1L << (YulLeave - 144)) | (1L << (YulLet - 144)) | (1L << (YulSwitch - 144)) | (1L << (YulEVMBuiltin - 144)) | (1L << (YulLBrace - 144)) | (1L << (YulIdentifier - 144)))) != 0)) {
				{
				{
				setState(1002);
				yulStatement();
				}
				}
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1008);
			match(YulRBrace);
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

	public static class AssemblyFlagsContext extends ParserRuleContext {
		public TerminalNode AssemblyBlockLParen() { return getToken(SolidityParser.AssemblyBlockLParen, 0); }
		public List<TerminalNode> AssemblyFlagString() { return getTokens(SolidityParser.AssemblyFlagString); }
		public TerminalNode AssemblyFlagString(int i) {
			return getToken(SolidityParser.AssemblyFlagString, i);
		}
		public TerminalNode AssemblyBlockRParen() { return getToken(SolidityParser.AssemblyBlockRParen, 0); }
		public List<TerminalNode> AssemblyBlockComma() { return getTokens(SolidityParser.AssemblyBlockComma); }
		public TerminalNode AssemblyBlockComma(int i) {
			return getToken(SolidityParser.AssemblyBlockComma, i);
		}
		public AssemblyFlagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFlags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssemblyFlags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssemblyFlags(this);
		}
	}

	public final AssemblyFlagsContext assemblyFlags() throws RecognitionException {
		AssemblyFlagsContext _localctx = new AssemblyFlagsContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_assemblyFlags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			match(AssemblyBlockLParen);
			setState(1011);
			match(AssemblyFlagString);
			setState(1016);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AssemblyBlockComma) {
				{
				{
				setState(1012);
				match(AssemblyBlockComma);
				setState(1013);
				match(AssemblyFlagString);
				}
				}
				setState(1018);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1019);
			match(AssemblyBlockRParen);
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
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationList(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021);
			((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
			setState(1026);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1022);
				match(Comma);
				setState(1023);
				((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
				((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
				}
				}
				setState(1028);
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

	public static class VariableDeclarationTupleContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationTuple(this);
		}
	}

	public final VariableDeclarationTupleContext variableDeclarationTuple() throws RecognitionException {
		VariableDeclarationTupleContext _localctx = new VariableDeclarationTupleContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_variableDeclarationTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			match(LParen);
			{
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1030);
				match(Comma);
				}
				}
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1036);
			((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
			}
			setState(1044);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1038);
				match(Comma);
				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Address) | (1L << Bool) | (1L << Bytes) | (1L << Error) | (1L << Fixed) | (1L << FixedBytes) | (1L << From) | (1L << Function) | (1L << Global) | (1L << Mapping) | (1L << Revert) | (1L << SignedIntegerType) | (1L << String) | (1L << Transient))) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
					{
					setState(1039);
					((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
					((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
					}
				}

				}
				}
				setState(1046);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1047);
			match(RParen);
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

	public static class VariableDeclarationStatementContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationTupleContext variableDeclarationTuple() {
			return getRuleContext(VariableDeclarationTupleContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationStatement(this);
		}
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case Ufixed:
			case UnsignedIntegerType:
			case Identifier:
				{
				{
				setState(1049);
				variableDeclaration();
				setState(1052);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(1050);
					match(Assign);
					setState(1051);
					expression(0);
					}
				}

				}
				}
				break;
			case LParen:
				{
				{
				setState(1054);
				variableDeclarationTuple();
				setState(1055);
				match(Assign);
				setState(1056);
				expression(0);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1060);
			match(Semicolon);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			expression(0);
			setState(1063);
			match(Semicolon);
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

	public static class MappingTypeContext extends ParserRuleContext {
		public MappingKeyTypeContext key;
		public IdentifierContext name;
		public TypeNameContext value;
		public TerminalNode Mapping() { return getToken(SolidityParser.Mapping, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode DoubleArrow() { return getToken(SolidityParser.DoubleArrow, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MappingKeyTypeContext mappingKeyType() {
			return getRuleContext(MappingKeyTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public MappingTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMappingType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMappingType(this);
		}
	}

	public final MappingTypeContext mappingType() throws RecognitionException {
		MappingTypeContext _localctx = new MappingTypeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_mappingType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			match(Mapping);
			setState(1066);
			match(LParen);
			setState(1067);
			((MappingTypeContext)_localctx).key = mappingKeyType();
			setState(1069);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(1068);
				((MappingTypeContext)_localctx).name = identifier();
				}
			}

			setState(1071);
			match(DoubleArrow);
			setState(1072);
			((MappingTypeContext)_localctx).value = typeName(0);
			setState(1074);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Error) | (1L << From) | (1L << Global) | (1L << Revert) | (1L << Transient))) != 0) || _la==Identifier) {
				{
				setState(1073);
				((MappingTypeContext)_localctx).name = identifier();
				}
			}

			setState(1076);
			match(RParen);
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

	public static class MappingKeyTypeContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public MappingKeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingKeyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMappingKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMappingKeyType(this);
		}
	}

	public final MappingKeyTypeContext mappingKeyType() throws RecognitionException {
		MappingKeyTypeContext _localctx = new MappingKeyTypeContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_mappingKeyType);
		try {
			setState(1080);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Fixed:
			case FixedBytes:
			case SignedIntegerType:
			case String:
			case Ufixed:
			case UnsignedIntegerType:
				enterOuterAlt(_localctx, 1);
				{
				setState(1078);
				elementaryTypeName();
				}
				break;
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1079);
				identifierPath();
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

	public static class YulStatementContext extends ParserRuleContext {
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulVariableDeclarationContext yulVariableDeclaration() {
			return getRuleContext(YulVariableDeclarationContext.class,0);
		}
		public YulAssignmentContext yulAssignment() {
			return getRuleContext(YulAssignmentContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulIfStatementContext yulIfStatement() {
			return getRuleContext(YulIfStatementContext.class,0);
		}
		public YulForStatementContext yulForStatement() {
			return getRuleContext(YulForStatementContext.class,0);
		}
		public YulSwitchStatementContext yulSwitchStatement() {
			return getRuleContext(YulSwitchStatementContext.class,0);
		}
		public TerminalNode YulLeave() { return getToken(SolidityParser.YulLeave, 0); }
		public TerminalNode YulBreak() { return getToken(SolidityParser.YulBreak, 0); }
		public TerminalNode YulContinue() { return getToken(SolidityParser.YulContinue, 0); }
		public YulFunctionDefinitionContext yulFunctionDefinition() {
			return getRuleContext(YulFunctionDefinitionContext.class,0);
		}
		public YulStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulStatement(this);
		}
	}

	public final YulStatementContext yulStatement() throws RecognitionException {
		YulStatementContext _localctx = new YulStatementContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_yulStatement);
		try {
			setState(1093);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1082);
				yulBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1083);
				yulVariableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1084);
				yulAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1085);
				yulFunctionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1086);
				yulIfStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1087);
				yulForStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1088);
				yulSwitchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1089);
				match(YulLeave);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1090);
				match(YulBreak);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1091);
				match(YulContinue);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1092);
				yulFunctionDefinition();
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

	public static class YulBlockContext extends ParserRuleContext {
		public TerminalNode YulLBrace() { return getToken(SolidityParser.YulLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public YulBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulBlock(this);
		}
	}

	public final YulBlockContext yulBlock() throws RecognitionException {
		YulBlockContext _localctx = new YulBlockContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_yulBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1095);
			match(YulLBrace);
			setState(1099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (YulBreak - 144)) | (1L << (YulContinue - 144)) | (1L << (YulFor - 144)) | (1L << (YulFunction - 144)) | (1L << (YulIf - 144)) | (1L << (YulLeave - 144)) | (1L << (YulLet - 144)) | (1L << (YulSwitch - 144)) | (1L << (YulEVMBuiltin - 144)) | (1L << (YulLBrace - 144)) | (1L << (YulIdentifier - 144)))) != 0)) {
				{
				{
				setState(1096);
				yulStatement();
				}
				}
				setState(1101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1102);
			match(YulRBrace);
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

	public static class YulVariableDeclarationContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> variables = new ArrayList<Token>();
		public TerminalNode YulLet() { return getToken(SolidityParser.YulLet, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulVariableDeclaration(this);
		}
	}

	public final YulVariableDeclarationContext yulVariableDeclaration() throws RecognitionException {
		YulVariableDeclarationContext _localctx = new YulVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_yulVariableDeclaration);
		int _la;
		try {
			setState(1123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1104);
				match(YulLet);
				setState(1105);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1106);
					match(YulAssign);
					setState(1107);
					yulExpression();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1110);
				match(YulLet);
				setState(1111);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1112);
					match(YulComma);
					setState(1113);
					((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
					}
					}
					setState(1118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1119);
					match(YulAssign);
					setState(1120);
					yulFunctionCall();
					}
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

	public static class YulAssignmentContext extends ParserRuleContext {
		public List<YulPathContext> yulPath() {
			return getRuleContexts(YulPathContext.class);
		}
		public YulPathContext yulPath(int i) {
			return getRuleContext(YulPathContext.class,i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulAssignment(this);
		}
	}

	public final YulAssignmentContext yulAssignment() throws RecognitionException {
		YulAssignmentContext _localctx = new YulAssignmentContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_yulAssignment);
		int _la;
		try {
			setState(1139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1125);
				yulPath();
				setState(1126);
				match(YulAssign);
				setState(1127);
				yulExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1129);
				yulPath();
				setState(1132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1130);
					match(YulComma);
					setState(1131);
					yulPath();
					}
					}
					setState(1134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulComma );
				}
				setState(1136);
				match(YulAssign);
				setState(1137);
				yulFunctionCall();
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

	public static class YulIfStatementContext extends ParserRuleContext {
		public YulExpressionContext cond;
		public YulBlockContext body;
		public TerminalNode YulIf() { return getToken(SolidityParser.YulIf, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulIfStatement(this);
		}
	}

	public final YulIfStatementContext yulIfStatement() throws RecognitionException {
		YulIfStatementContext _localctx = new YulIfStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_yulIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			match(YulIf);
			setState(1142);
			((YulIfStatementContext)_localctx).cond = yulExpression();
			setState(1143);
			((YulIfStatementContext)_localctx).body = yulBlock();
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

	public static class YulForStatementContext extends ParserRuleContext {
		public YulBlockContext init;
		public YulExpressionContext cond;
		public YulBlockContext post;
		public YulBlockContext body;
		public TerminalNode YulFor() { return getToken(SolidityParser.YulFor, 0); }
		public List<YulBlockContext> yulBlock() {
			return getRuleContexts(YulBlockContext.class);
		}
		public YulBlockContext yulBlock(int i) {
			return getRuleContext(YulBlockContext.class,i);
		}
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulForStatement(this);
		}
	}

	public final YulForStatementContext yulForStatement() throws RecognitionException {
		YulForStatementContext _localctx = new YulForStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_yulForStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1145);
			match(YulFor);
			setState(1146);
			((YulForStatementContext)_localctx).init = yulBlock();
			setState(1147);
			((YulForStatementContext)_localctx).cond = yulExpression();
			setState(1148);
			((YulForStatementContext)_localctx).post = yulBlock();
			setState(1149);
			((YulForStatementContext)_localctx).body = yulBlock();
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

	public static class YulSwitchCaseContext extends ParserRuleContext {
		public TerminalNode YulCase() { return getToken(SolidityParser.YulCase, 0); }
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulSwitchCase(this);
		}
	}

	public final YulSwitchCaseContext yulSwitchCase() throws RecognitionException {
		YulSwitchCaseContext _localctx = new YulSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_yulSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(YulCase);
			setState(1152);
			yulLiteral();
			setState(1153);
			yulBlock();
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

	public static class YulSwitchStatementContext extends ParserRuleContext {
		public TerminalNode YulSwitch() { return getToken(SolidityParser.YulSwitch, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public TerminalNode YulDefault() { return getToken(SolidityParser.YulDefault, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public List<YulSwitchCaseContext> yulSwitchCase() {
			return getRuleContexts(YulSwitchCaseContext.class);
		}
		public YulSwitchCaseContext yulSwitchCase(int i) {
			return getRuleContext(YulSwitchCaseContext.class,i);
		}
		public YulSwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulSwitchStatement(this);
		}
	}

	public final YulSwitchStatementContext yulSwitchStatement() throws RecognitionException {
		YulSwitchStatementContext _localctx = new YulSwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_yulSwitchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			match(YulSwitch);
			setState(1156);
			yulExpression();
			setState(1168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulCase:
				{
				{
				setState(1158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1157);
					yulSwitchCase();
					}
					}
					setState(1160); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulCase );
				setState(1164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulDefault) {
					{
					setState(1162);
					match(YulDefault);
					setState(1163);
					yulBlock();
					}
				}

				}
				}
				break;
			case YulDefault:
				{
				{
				setState(1166);
				match(YulDefault);
				setState(1167);
				yulBlock();
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

	public static class YulFunctionDefinitionContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> arguments = new ArrayList<Token>();
		public List<Token> returnParameters = new ArrayList<Token>();
		public YulBlockContext body;
		public TerminalNode YulFunction() { return getToken(SolidityParser.YulFunction, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public TerminalNode YulArrow() { return getToken(SolidityParser.YulArrow, 0); }
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulFunctionDefinition(this);
		}
	}

	public final YulFunctionDefinitionContext yulFunctionDefinition() throws RecognitionException {
		YulFunctionDefinitionContext _localctx = new YulFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_yulFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1170);
			match(YulFunction);
			setState(1171);
			match(YulIdentifier);
			setState(1172);
			match(YulLParen);
			setState(1181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulIdentifier) {
				{
				setState(1173);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1174);
					match(YulComma);
					setState(1175);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1183);
			match(YulRParen);
			setState(1193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulArrow) {
				{
				setState(1184);
				match(YulArrow);
				setState(1185);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1186);
					match(YulComma);
					setState(1187);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1195);
			((YulFunctionDefinitionContext)_localctx).body = yulBlock();
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

	public static class YulPathContext extends ParserRuleContext {
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public List<TerminalNode> YulPeriod() { return getTokens(SolidityParser.YulPeriod); }
		public TerminalNode YulPeriod(int i) {
			return getToken(SolidityParser.YulPeriod, i);
		}
		public List<TerminalNode> YulEVMBuiltin() { return getTokens(SolidityParser.YulEVMBuiltin); }
		public TerminalNode YulEVMBuiltin(int i) {
			return getToken(SolidityParser.YulEVMBuiltin, i);
		}
		public YulPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulPath(this);
		}
	}

	public final YulPathContext yulPath() throws RecognitionException {
		YulPathContext _localctx = new YulPathContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_yulPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1197);
			match(YulIdentifier);
			setState(1202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==YulPeriod) {
				{
				{
				setState(1198);
				match(YulPeriod);
				setState(1199);
				_la = _input.LA(1);
				if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(1204);
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

	public static class YulFunctionCallContext extends ParserRuleContext {
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public TerminalNode YulIdentifier() { return getToken(SolidityParser.YulIdentifier, 0); }
		public TerminalNode YulEVMBuiltin() { return getToken(SolidityParser.YulEVMBuiltin, 0); }
		public List<YulExpressionContext> yulExpression() {
			return getRuleContexts(YulExpressionContext.class);
		}
		public YulExpressionContext yulExpression(int i) {
			return getRuleContext(YulExpressionContext.class,i);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulFunctionCall(this);
		}
	}

	public final YulFunctionCallContext yulFunctionCall() throws RecognitionException {
		YulFunctionCallContext _localctx = new YulFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_yulFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1205);
			_la = _input.LA(1);
			if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1206);
			match(YulLParen);
			setState(1215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (YulFalse - 148)) | (1L << (YulTrue - 148)) | (1L << (YulEVMBuiltin - 148)) | (1L << (YulIdentifier - 148)) | (1L << (YulHexNumber - 148)) | (1L << (YulDecimalNumber - 148)) | (1L << (YulStringLiteral - 148)) | (1L << (YulHexStringLiteral - 148)))) != 0)) {
				{
				setState(1207);
				yulExpression();
				setState(1212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1208);
					match(YulComma);
					setState(1209);
					yulExpression();
					}
					}
					setState(1214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1217);
			match(YulRParen);
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

	public static class YulboolContext extends ParserRuleContext {
		public TerminalNode YulTrue() { return getToken(SolidityParser.YulTrue, 0); }
		public TerminalNode YulFalse() { return getToken(SolidityParser.YulFalse, 0); }
		public YulboolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulbool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulbool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulbool(this);
		}
	}

	public final YulboolContext yulbool() throws RecognitionException {
		YulboolContext _localctx = new YulboolContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_yulbool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1219);
			_la = _input.LA(1);
			if ( !(_la==YulFalse || _la==YulTrue) ) {
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

	public static class YulLiteralContext extends ParserRuleContext {
		public TerminalNode YulDecimalNumber() { return getToken(SolidityParser.YulDecimalNumber, 0); }
		public TerminalNode YulStringLiteral() { return getToken(SolidityParser.YulStringLiteral, 0); }
		public TerminalNode YulHexNumber() { return getToken(SolidityParser.YulHexNumber, 0); }
		public YulboolContext yulbool() {
			return getRuleContext(YulboolContext.class,0);
		}
		public TerminalNode YulHexStringLiteral() { return getToken(SolidityParser.YulHexStringLiteral, 0); }
		public YulLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulLiteral(this);
		}
	}

	public final YulLiteralContext yulLiteral() throws RecognitionException {
		YulLiteralContext _localctx = new YulLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_yulLiteral);
		try {
			setState(1226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulDecimalNumber:
				enterOuterAlt(_localctx, 1);
				{
				setState(1221);
				match(YulDecimalNumber);
				}
				break;
			case YulStringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1222);
				match(YulStringLiteral);
				}
				break;
			case YulHexNumber:
				enterOuterAlt(_localctx, 3);
				{
				setState(1223);
				match(YulHexNumber);
				}
				break;
			case YulFalse:
			case YulTrue:
				enterOuterAlt(_localctx, 4);
				{
				setState(1224);
				yulbool();
				}
				break;
			case YulHexStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(1225);
				match(YulHexStringLiteral);
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

	public static class YulExpressionContext extends ParserRuleContext {
		public YulPathContext yulPath() {
			return getRuleContext(YulPathContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulExpression(this);
		}
	}

	public final YulExpressionContext yulExpression() throws RecognitionException {
		YulExpressionContext _localctx = new YulExpressionContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_yulExpression);
		try {
			setState(1231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1228);
				yulPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1229);
				yulFunctionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1230);
				yulLiteral();
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
		case 39:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 45:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 26);
		case 15:
			return precpred(_ctx, 25);
		case 16:
			return precpred(_ctx, 24);
		case 17:
			return precpred(_ctx, 23);
		case 18:
			return precpred(_ctx, 22);
		case 19:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00b4\u04d4\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u00cc\n\2\f\2\16"+
		"\2\u00cf\13\2\3\2\3\2\3\3\3\3\6\3\u00d5\n\3\r\3\16\3\u00d6\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\5\4\u00df\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u00eb\n\4\3\4\3\4\3\5\3\5\3\5\5\5\u00f2\n\5\3\6\3\6\3\7\3\7\3\7\3\7\7"+
		"\7\u00fa\n\7\f\7\16\7\u00fd\13\7\3\7\3\7\3\b\5\b\u0102\n\b\3\b\3\b\3\b"+
		"\5\b\u0107\n\b\3\b\3\b\7\b\u010b\n\b\f\b\16\b\u010e\13\b\3\b\3\b\3\t\3"+
		"\t\3\t\5\t\u0115\n\t\3\t\3\t\7\t\u0119\n\t\f\t\16\t\u011c\13\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\7\n\u0124\n\n\f\n\16\n\u0127\13\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\7\13\u012f\n\13\f\13\16\13\u0132\13\13\3\f\3\f\5\f\u0136\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0144\n\r\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u014e\n\17\f\17\16\17\u0151\13"+
		"\17\5\17\u0153\n\17\3\17\3\17\3\17\3\17\7\17\u0159\n\17\f\17\16\17\u015c"+
		"\13\17\5\17\u015e\n\17\3\17\5\17\u0161\n\17\3\17\3\17\3\20\3\20\3\20\7"+
		"\20\u0168\n\20\f\20\16\20\u016b\13\20\3\21\3\21\5\21\u016f\n\21\3\22\3"+
		"\22\3\23\3\23\3\23\7\23\u0176\n\23\f\23\16\23\u0179\13\23\3\24\3\24\5"+
		"\24\u017d\n\24\3\24\5\24\u0180\n\24\3\25\3\25\3\25\5\25\u0185\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u018c\n\25\f\25\16\25\u018f\13\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u019a\n\27\f\27\16\27\u019d\13"+
		"\27\3\27\3\27\5\27\u01a1\n\27\3\30\3\30\3\30\3\30\5\30\u01a7\n\30\3\30"+
		"\3\30\5\30\u01ab\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u01b4\n"+
		"\30\f\30\16\30\u01b7\13\30\3\30\3\30\3\30\3\30\3\30\5\30\u01be\n\30\3"+
		"\30\3\30\5\30\u01c2\n\30\3\31\3\31\3\31\3\31\5\31\u01c8\n\31\3\31\5\31"+
		"\u01cb\n\31\3\31\3\31\7\31\u01cf\n\31\f\31\16\31\u01d2\13\31\3\31\3\31"+
		"\5\31\u01d6\n\31\3\32\3\32\3\32\5\32\u01db\n\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\7\32\u01e3\n\32\f\32\16\32\u01e6\13\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u01ed\n\32\3\32\3\32\5\32\u01f1\n\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u01fb\n\33\f\33\16\33\u01fe\13\33\3\33\3\33\5\33"+
		"\u0202\n\33\3\34\3\34\3\34\3\34\6\34\u0208\n\34\r\34\16\34\u0209\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0218\n\36"+
		"\f\36\16\36\u021b\13\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\5\37\u0224"+
		"\n\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \7 \u0230\n \f \16 \u0233\13 \3"+
		" \3 \3 \5 \u0238\n \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\5\"\u0245\n\"\3"+
		"\"\5\"\u0248\n\"\3#\3#\3#\3#\3#\3#\7#\u0250\n#\f#\16#\u0253\13#\5#\u0255"+
		"\n#\3#\3#\5#\u0259\n#\3#\3#\3$\3$\5$\u025f\n$\3%\3%\3%\3%\3%\3%\7%\u0267"+
		"\n%\f%\16%\u026a\13%\5%\u026c\n%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\7\'\u0279\n\'\f\'\16\'\u027c\13\'\3\'\3\'\5\'\u0280\n\'\3\'\3\'\3\'"+
		"\5\'\u0285\n\'\3\'\5\'\u0288\n\'\3\'\3\'\3(\3(\3(\5(\u028f\n(\3)\3)\3"+
		")\3)\3)\3)\5)\u0297\n)\3)\3)\3)\5)\u029c\n)\3)\7)\u029f\n)\f)\16)\u02a2"+
		"\13)\3*\3*\3+\3+\3+\3,\3,\3,\5,\u02ac\n,\3,\3,\3,\7,\u02b1\n,\f,\16,\u02b4"+
		"\13,\3,\3,\3,\3,\3,\5,\u02bb\n,\3-\3-\5-\u02bf\n-\3-\3-\3.\3.\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u02d7\n/\5/\u02d9\n"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\5/\u0309\n/\3/\3/\3/\3/\5/\u030f\n/\3/\3/\5/\u0313\n/\3/\3/\3/\3/\3"+
		"/\5/\u031a\n/\3/\3/\3/\3/\3/\7/\u0321\n/\f/\16/\u0324\13/\5/\u0326\n/"+
		"\3/\3/\3/\3/\3/\7/\u032d\n/\f/\16/\u0330\13/\3\60\3\60\3\61\3\61\5\61"+
		"\u0336\n\61\3\61\3\61\5\61\u033a\n\61\7\61\u033c\n\61\f\61\16\61\u033f"+
		"\13\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0347\n\62\f\62\16\62\u034a"+
		"\13\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u0355\n\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\67\6\67\u035d\n\67\r\67\16\67\u035e\38\68\u0362"+
		"\n8\r8\168\u0363\39\69\u0367\n9\r9\169\u0368\3:\3:\3;\3;\3;\7;\u0370\n"+
		";\f;\16;\u0373\13;\3;\3;\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3="+
		"\3=\5=\u0387\n=\3>\3>\5>\u038b\n>\3?\3?\3?\3?\3?\3?\3?\5?\u0394\n?\3@"+
		"\3@\3@\3@\5@\u039a\n@\3@\3@\5@\u039e\n@\3@\5@\u03a1\n@\3@\3@\3@\3A\3A"+
		"\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3E\3E\3E"+
		"\3E\3E\5E\u03c1\nE\3E\3E\6E\u03c5\nE\rE\16E\u03c6\3F\3F\5F\u03cb\nF\3"+
		"F\3F\3F\3F\5F\u03d1\nF\3F\3F\3G\3G\5G\u03d7\nG\3G\3G\3H\3H\3H\3H\3H\3"+
		"I\3I\3I\3I\3I\3J\3J\5J\u03e7\nJ\3J\5J\u03ea\nJ\3J\3J\7J\u03ee\nJ\fJ\16"+
		"J\u03f1\13J\3J\3J\3K\3K\3K\3K\7K\u03f9\nK\fK\16K\u03fc\13K\3K\3K\3L\3"+
		"L\3L\7L\u0403\nL\fL\16L\u0406\13L\3M\3M\7M\u040a\nM\fM\16M\u040d\13M\3"+
		"M\3M\3M\3M\5M\u0413\nM\7M\u0415\nM\fM\16M\u0418\13M\3M\3M\3N\3N\3N\5N"+
		"\u041f\nN\3N\3N\3N\3N\5N\u0425\nN\3N\3N\3O\3O\3O\3P\3P\3P\3P\5P\u0430"+
		"\nP\3P\3P\3P\5P\u0435\nP\3P\3P\3Q\3Q\5Q\u043b\nQ\3R\3R\3R\3R\3R\3R\3R"+
		"\3R\3R\3R\3R\5R\u0448\nR\3S\3S\7S\u044c\nS\fS\16S\u044f\13S\3S\3S\3T\3"+
		"T\3T\3T\5T\u0457\nT\3T\3T\3T\3T\7T\u045d\nT\fT\16T\u0460\13T\3T\3T\5T"+
		"\u0464\nT\5T\u0466\nT\3U\3U\3U\3U\3U\3U\3U\6U\u046f\nU\rU\16U\u0470\3"+
		"U\3U\3U\5U\u0476\nU\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3X\3X\3X\3X\3Y\3Y\3"+
		"Y\6Y\u0489\nY\rY\16Y\u048a\3Y\3Y\5Y\u048f\nY\3Y\3Y\5Y\u0493\nY\3Z\3Z\3"+
		"Z\3Z\3Z\3Z\7Z\u049b\nZ\fZ\16Z\u049e\13Z\5Z\u04a0\nZ\3Z\3Z\3Z\3Z\3Z\7Z"+
		"\u04a7\nZ\fZ\16Z\u04aa\13Z\5Z\u04ac\nZ\3Z\3Z\3[\3[\3[\7[\u04b3\n[\f[\16"+
		"[\u04b6\13[\3\\\3\\\3\\\3\\\3\\\7\\\u04bd\n\\\f\\\16\\\u04c0\13\\\5\\"+
		"\u04c2\n\\\3\\\3\\\3]\3]\3^\3^\3^\3^\3^\5^\u04cd\n^\3_\3_\3_\5_\u04d2"+
		"\n_\3_\3\u0130\4P\\`\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\2\25\5\2\31\31((\63\64\5\2\61\61\65\65GG\6\2egkoqv"+
		"xx\n\2\5\5\t\t\13\13\34\35::<<BBEE\5\2\f\f,,;;\5\2\22\22llwz\3\2mo\3\2"+
		"kl\3\2hj\3\2sv\3\2qr\3\2yz\3\2Va\b\2\27\27\37\37!!99>>\u0085\u0085\4\2"+
		"\33\33??\3\2}~\4\2\u0081\u0081\u0083\u0083\4\2\u009f\u009f\u00a8\u00a8"+
		"\4\2\u0096\u0096\u009d\u009d\2\u0560\2\u00cd\3\2\2\2\4\u00d2\3\2\2\2\6"+
		"\u00da\3\2\2\2\b\u00ee\3\2\2\2\n\u00f3\3\2\2\2\f\u00f5\3\2\2\2\16\u0101"+
		"\3\2\2\2\20\u0111\3\2\2\2\22\u011f\3\2\2\2\24\u012a\3\2\2\2\26\u0133\3"+
		"\2\2\2\30\u0143\3\2\2\2\32\u0145\3\2\2\2\34\u0149\3\2\2\2\36\u0164\3\2"+
		"\2\2 \u016c\3\2\2\2\"\u0170\3\2\2\2$\u0172\3\2\2\2&\u017a\3\2\2\2(\u0181"+
		"\3\2\2\2*\u0192\3\2\2\2,\u0194\3\2\2\2.\u01a2\3\2\2\2\60\u01c3\3\2\2\2"+
		"\62\u01d7\3\2\2\2\64\u01f2\3\2\2\2\66\u0203\3\2\2\28\u020d\3\2\2\2:\u0211"+
		"\3\2\2\2<\u021e\3\2\2\2>\u0227\3\2\2\2@\u023b\3\2\2\2B\u0242\3\2\2\2D"+
		"\u0249\3\2\2\2F\u025c\3\2\2\2H\u0260\3\2\2\2J\u0270\3\2\2\2L\u0272\3\2"+
		"\2\2N\u028b\3\2\2\2P\u0296\3\2\2\2R\u02a3\3\2\2\2T\u02a5\3\2\2\2V\u02a8"+
		"\3\2\2\2X\u02bc\3\2\2\2Z\u02c2\3\2\2\2\\\u02d8\3\2\2\2^\u0331\3\2\2\2"+
		"`\u0333\3\2\2\2b\u0342\3\2\2\2d\u034d\3\2\2\2f\u0354\3\2\2\2h\u0356\3"+
		"\2\2\2j\u0359\3\2\2\2l\u035c\3\2\2\2n\u0361\3\2\2\2p\u0366\3\2\2\2r\u036a"+
		"\3\2\2\2t\u036c\3\2\2\2v\u0376\3\2\2\2x\u0386\3\2\2\2z\u038a\3\2\2\2|"+
		"\u038c\3\2\2\2~\u0395\3\2\2\2\u0080\u03a5\3\2\2\2\u0082\u03ab\3\2\2\2"+
		"\u0084\u03b3\3\2\2\2\u0086\u03b6\3\2\2\2\u0088\u03b9\3\2\2\2\u008a\u03c8"+
		"\3\2\2\2\u008c\u03d4\3\2\2\2\u008e\u03da\3\2\2\2\u0090\u03df\3\2\2\2\u0092"+
		"\u03e4\3\2\2\2\u0094\u03f4\3\2\2\2\u0096\u03ff\3\2\2\2\u0098\u0407\3\2"+
		"\2\2\u009a\u0424\3\2\2\2\u009c\u0428\3\2\2\2\u009e\u042b\3\2\2\2\u00a0"+
		"\u043a\3\2\2\2\u00a2\u0447\3\2\2\2\u00a4\u0449\3\2\2\2\u00a6\u0465\3\2"+
		"\2\2\u00a8\u0475\3\2\2\2\u00aa\u0477\3\2\2\2\u00ac\u047b\3\2\2\2\u00ae"+
		"\u0481\3\2\2\2\u00b0\u0485\3\2\2\2\u00b2\u0494\3\2\2\2\u00b4\u04af\3\2"+
		"\2\2\u00b6\u04b7\3\2\2\2\u00b8\u04c5\3\2\2\2\u00ba\u04cc\3\2\2\2\u00bc"+
		"\u04d1\3\2\2\2\u00be\u00cc\5\4\3\2\u00bf\u00cc\5\6\4\2\u00c0\u00cc\5L"+
		"\'\2\u00c1\u00cc\5\16\b\2\u00c2\u00cc\5\20\t\2\u00c3\u00cc\5\22\n\2\u00c4"+
		"\u00cc\5.\30\2\u00c5\u00cc\5@!\2\u00c6\u00cc\5\66\34\2\u00c7\u00cc\5:"+
		"\36\2\u00c8\u00cc\5<\37\2\u00c9\u00cc\5H%\2\u00ca\u00cc\5D#\2\u00cb\u00be"+
		"\3\2\2\2\u00cb\u00bf\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cb"+
		"\u00c2\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb\u00c4\3\2\2\2\u00cb\u00c5\3\2"+
		"\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\7\2\2\3\u00d1\3\3\2\2\2\u00d2\u00d4\7\62\2\2\u00d3\u00d5\7\u00b0"+
		"\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\7\u00b1\2\2\u00d9\5\3\2"+
		"\2\2\u00da\u00ea\7%\2\2\u00db\u00de\5\n\6\2\u00dc\u00dd\7\7\2\2\u00dd"+
		"\u00df\5d\63\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00eb\3\2"+
		"\2\2\u00e0\u00e1\5\f\7\2\u00e1\u00e2\7\37\2\2\u00e2\u00e3\5\n\6\2\u00e3"+
		"\u00eb\3\2\2\2\u00e4\u00e5\7m\2\2\u00e5\u00e6\7\7\2\2\u00e6\u00e7\5d\63"+
		"\2\u00e7\u00e8\7\37\2\2\u00e8\u00e9\5\n\6\2\u00e9\u00eb\3\2\2\2\u00ea"+
		"\u00db\3\2\2\2\u00ea\u00e0\3\2\2\2\u00ea\u00e4\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00ed\7Q\2\2\u00ed\7\3\2\2\2\u00ee\u00f1\5d\63\2\u00ef\u00f0"+
		"\7\7\2\2\u00f0\u00f2\5d\63\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\t\3\2\2\2\u00f3\u00f4\7}\2\2\u00f4\13\3\2\2\2\u00f5\u00f6\7N\2\2\u00f6"+
		"\u00fb\5\b\5\2\u00f7\u00f8\7b\2\2\u00f8\u00fa\5\b\5\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7O\2\2\u00ff\r\3\2\2\2"+
		"\u0100\u0102\7\4\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0104\7\21\2\2\u0104\u0106\5d\63\2\u0105\u0107\5\24\13"+
		"\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010c"+
		"\7N\2\2\u0109\u010b\5\30\r\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010f\u0110\7O\2\2\u0110\17\3\2\2\2\u0111\u0112\7\'\2\2\u0112\u0114"+
		"\5d\63\2\u0113\u0115\5\24\13\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2"+
		"\u0115\u0116\3\2\2\2\u0116\u011a\7N\2\2\u0117\u0119\5\30\r\2\u0118\u0117"+
		"\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7O\2\2\u011e\21\3\2\2\2"+
		"\u011f\u0120\7*\2\2\u0120\u0121\5d\63\2\u0121\u0125\7N\2\2\u0122\u0124"+
		"\5\30\r\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2"+
		"\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\7O\2\2\u0129\23\3\2\2\2\u012a\u012b\7)\2\2\u012b\u0130\5\26\f\2\u012c"+
		"\u012d\7b\2\2\u012d\u012f\5\26\f\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2"+
		"\2\2\u0130\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\25\3\2\2\2\u0132\u0130"+
		"\3\2\2\2\u0133\u0135\5\36\20\2\u0134\u0136\5\34\17\2\u0135\u0134\3\2\2"+
		"\2\u0135\u0136\3\2\2\2\u0136\27\3\2\2\2\u0137\u0144\5(\25\2\u0138\u0144"+
		"\5.\30\2\u0139\u0144\5\60\31\2\u013a\u0144\5\62\32\2\u013b\u0144\5\64"+
		"\33\2\u013c\u0144\5\66\34\2\u013d\u0144\5:\36\2\u013e\u0144\5<\37\2\u013f"+
		"\u0144\5> \2\u0140\u0144\5D#\2\u0141\u0144\5H%\2\u0142\u0144\5L\'\2\u0143"+
		"\u0137\3\2\2\2\u0143\u0138\3\2\2\2\u0143\u0139\3\2\2\2\u0143\u013a\3\2"+
		"\2\2\u0143\u013b\3\2\2\2\u0143\u013c\3\2\2\2\u0143\u013d\3\2\2\2\u0143"+
		"\u013e\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0140\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0143\u0142\3\2\2\2\u0144\31\3\2\2\2\u0145\u0146\5d\63\2\u0146\u0147"+
		"\7P\2\2\u0147\u0148\5\\/\2\u0148\33\3\2\2\2\u0149\u0160\7J\2\2\u014a\u014f"+
		"\5\\/\2\u014b\u014c\7b\2\2\u014c\u014e\5\\/\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0153\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0152\u014a\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0161\3\2\2\2\u0154\u015d\7N\2\2\u0155\u015a\5\32\16\2\u0156\u0157\7"+
		"b\2\2\u0157\u0159\5\32\16\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u0155\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0161\7O\2\2\u0160\u0152\3\2\2\2\u0160\u0154\3\2\2\2\u0161\u0162\3\2"+
		"\2\2\u0162\u0163\7K\2\2\u0163\35\3\2\2\2\u0164\u0169\5d\63\2\u0165\u0166"+
		"\7R\2\2\u0166\u0168\5d\63\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\37\3\2\2\2\u016b\u0169\3\2\2"+
		"\2\u016c\u016e\5\36\20\2\u016d\u016f\5\34\17\2\u016e\u016d\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f!\3\2\2\2\u0170\u0171\t\2\2\2\u0171#\3\2\2\2\u0172"+
		"\u0177\5&\24\2\u0173\u0174\7b\2\2\u0174\u0176\5&\24\2\u0175\u0173\3\2"+
		"\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"%\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017c\5P)\2\u017b\u017d\5Z.\2\u017c"+
		"\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u0180\5d"+
		"\63\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\'\3\2\2\2\u0181\u0182"+
		"\7\17\2\2\u0182\u0184\7J\2\2\u0183\u0185\5$\23\2\u0184\u0183\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u018d\7K\2\2\u0187\u018c\5 \21"+
		"\2\u0188\u018c\7\61\2\2\u0189\u018c\7(\2\2\u018a\u018c\7\64\2\2\u018b"+
		"\u0187\3\2\2\2\u018b\u0188\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2"+
		"\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\5t;\2\u0191)\3\2\2\2\u0192"+
		"\u0193\t\3\2\2\u0193+\3\2\2\2\u0194\u01a0\7\60\2\2\u0195\u0196\7J\2\2"+
		"\u0196\u019b\5\36\20\2\u0197\u0198\7b\2\2\u0198\u019a\5\36\20\2\u0199"+
		"\u0197\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2"+
		"\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u019f\7K\2\2\u019f"+
		"\u01a1\3\2\2\2\u01a0\u0195\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1-\3\2\2\2"+
		"\u01a2\u01a6\7 \2\2\u01a3\u01a7\5d\63\2\u01a4\u01a7\7\32\2\2\u01a5\u01a7"+
		"\7\66\2\2\u01a6\u01a3\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2"+
		"\u01a7\u01a8\3\2\2\2\u01a8\u01aa\7J\2\2\u01a9\u01ab\5$\23\2\u01aa\u01a9"+
		"\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b5\7K\2\2\u01ad"+
		"\u01b4\5\"\22\2\u01ae\u01b4\5*\26\2\u01af\u01b4\5 \21\2\u01b0\u01b4\7"+
		"H\2\2\u01b1\u01b4\7\16\2\2\u01b2\u01b4\5,\27\2\u01b3\u01ad\3\2\2\2\u01b3"+
		"\u01ae\3\2\2\2\u01b3\u01af\3\2\2\2\u01b3\u01b0\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01bd\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b9\78"+
		"\2\2\u01b9\u01ba\7J\2\2\u01ba\u01bb\5$\23\2\u01bb\u01bc\7K\2\2\u01bc\u01be"+
		"\3\2\2\2\u01bd\u01b8\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf"+
		"\u01c2\7Q\2\2\u01c0\u01c2\5t;\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2"+
		"\2\u01c2/\3\2\2\2\u01c3\u01c4\7-\2\2\u01c4\u01ca\5d\63\2\u01c5\u01c7\7"+
		"J\2\2\u01c6\u01c8\5$\23\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01cb\7K\2\2\u01ca\u01c5\3\2\2\2\u01ca\u01cb\3\2"+
		"\2\2\u01cb\u01d0\3\2\2\2\u01cc\u01cf\7H\2\2\u01cd\u01cf\5,\27\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d5\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01d6\7Q\2\2\u01d4\u01d6\5t;\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2"+
		"\2\u01d6\61\3\2\2\2\u01d7\u01d8\7\32\2\2\u01d8\u01da\7J\2\2\u01d9\u01db"+
		"\5$\23\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01e4\7K\2\2\u01dd\u01e3\7\31\2\2\u01de\u01e3\5*\26\2\u01df\u01e3\5 "+
		"\21\2\u01e0\u01e3\7H\2\2\u01e1\u01e3\5,\27\2\u01e2\u01dd\3\2\2\2\u01e2"+
		"\u01de\3\2\2\2\u01e2\u01df\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e1\3\2"+
		"\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01ec\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\78\2\2\u01e8\u01e9\7J\2"+
		"\2\u01e9\u01ea\5$\23\2\u01ea\u01eb\7K\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01e7"+
		"\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01f1\7Q\2\2\u01ef"+
		"\u01f1\5t;\2\u01f0\u01ee\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\63\3\2\2\2"+
		"\u01f2\u01f3\7\66\2\2\u01f3\u01f4\7J\2\2\u01f4\u01fc\7K\2\2\u01f5\u01fb"+
		"\7\31\2\2\u01f6\u01fb\7\61\2\2\u01f7\u01fb\5 \21\2\u01f8\u01fb\7H\2\2"+
		"\u01f9\u01fb\5,\27\2\u01fa\u01f5\3\2\2\2\u01fa\u01f6\3\2\2\2\u01fa\u01f7"+
		"\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc"+
		"\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0201\3\2\2\2\u01fe\u01fc\3\2"+
		"\2\2\u01ff\u0202\7Q\2\2\u0200\u0202\5t;\2\u0201\u01ff\3\2\2\2\u0201\u0200"+
		"\3\2\2\2\u0202\65\3\2\2\2\u0203\u0204\7=\2\2\u0204\u0205\5d\63\2\u0205"+
		"\u0207\7N\2\2\u0206\u0208\58\35\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\7O\2\2\u020c\67\3\2\2\2\u020d\u020e\5P)\2\u020e\u020f\5d\63\2\u020f"+
		"\u0210\7Q\2\2\u02109\3\2\2\2\u0211\u0212\7\26\2\2\u0212\u0213\5d\63\2"+
		"\u0213\u0214\7N\2\2\u0214\u0219\5d\63\2\u0215\u0216\7b\2\2\u0216\u0218"+
		"\5d\63\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021d\7O"+
		"\2\2\u021d;\3\2\2\2\u021e\u021f\7A\2\2\u021f\u0220\5d\63\2\u0220\u0223"+
		"\7)\2\2\u0221\u0224\5R*\2\u0222\u0224\5T+\2\u0223\u0221\3\2\2\2\u0223"+
		"\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\7Q\2\2\u0226=\3\2\2\2\u0227"+
		"\u0231\5P)\2\u0228\u0230\7\64\2\2\u0229\u0230\7\63\2\2\u022a\u0230\7("+
		"\2\2\u022b\u0230\7\16\2\2\u022c\u0230\5,\27\2\u022d\u0230\7$\2\2\u022e"+
		"\u0230\7>\2\2\u022f\u0228\3\2\2\2\u022f\u0229\3\2\2\2\u022f\u022a\3\2"+
		"\2\2\u022f\u022b\3\2\2\2\u022f\u022c\3\2\2\2\u022f\u022d\3\2\2\2\u022f"+
		"\u022e\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2"+
		"\2\2\u0232\u0234\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0237\5d\63\2\u0235"+
		"\u0236\7V\2\2\u0236\u0238\5\\/\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2"+
		"\2\u0238\u0239\3\2\2\2\u0239\u023a\7Q\2\2\u023a?\3\2\2\2\u023b\u023c\5"+
		"P)\2\u023c\u023d\7\16\2\2\u023d\u023e\5d\63\2\u023e\u023f\7V\2\2\u023f"+
		"\u0240\5\\/\2\u0240\u0241\7Q\2\2\u0241A\3\2\2\2\u0242\u0244\5P)\2\u0243"+
		"\u0245\7&\2\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2"+
		"\2\2\u0246\u0248\5d\63\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"C\3\2\2\2\u0249\u024a\7\30\2\2\u024a\u024b\5d\63\2\u024b\u0254\7J\2\2"+
		"\u024c\u0251\5B\"\2\u024d\u024e\7b\2\2\u024e\u0250\5B\"\2\u024f\u024d"+
		"\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u024c\3\2\2\2\u0254\u0255\3\2"+
		"\2\2\u0255\u0256\3\2\2\2\u0256\u0258\7K\2\2\u0257\u0259\7\6\2\2\u0258"+
		"\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025b\7Q"+
		"\2\2\u025bE\3\2\2\2\u025c\u025e\5P)\2\u025d\u025f\5d\63\2\u025e\u025d"+
		"\3\2\2\2\u025e\u025f\3\2\2\2\u025fG\3\2\2\2\u0260\u0261\7\27\2\2\u0261"+
		"\u0262\5d\63\2\u0262\u026b\7J\2\2\u0263\u0268\5F$\2\u0264\u0265\7b\2\2"+
		"\u0265\u0267\5F$\2\u0266\u0264\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266"+
		"\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026b"+
		"\u0263\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\7K"+
		"\2\2\u026e\u026f\7Q\2\2\u026fI\3\2\2\2\u0270\u0271\t\4\2\2\u0271K\3\2"+
		"\2\2\u0272\u027f\7F\2\2\u0273\u0280\5\36\20\2\u0274\u0275\7N\2\2\u0275"+
		"\u027a\5N(\2\u0276\u0277\7b\2\2\u0277\u0279\5N(\2\u0278\u0276\3\2\2\2"+
		"\u0279\u027c\3\2\2\2\u027a\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d"+
		"\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u027e\7O\2\2\u027e\u0280\3\2\2\2\u027f"+
		"\u0273\3\2\2\2\u027f\u0274\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0284\7\36"+
		"\2\2\u0282\u0285\7m\2\2\u0283\u0285\5P)\2\u0284\u0282\3\2\2\2\u0284\u0283"+
		"\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u0288\7!\2\2\u0287\u0286\3\2\2\2\u0287"+
		"\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\7Q\2\2\u028aM\3\2\2\2\u028b"+
		"\u028e\5\36\20\2\u028c\u028d\7\7\2\2\u028d\u028f\5J&\2\u028e\u028c\3\2"+
		"\2\2\u028e\u028f\3\2\2\2\u028fO\3\2\2\2\u0290\u0291\b)\1\2\u0291\u0297"+
		"\5R*\2\u0292\u0297\5T+\2\u0293\u0297\5V,\2\u0294\u0297\5\u009eP\2\u0295"+
		"\u0297\5\36\20\2\u0296\u0290\3\2\2\2\u0296\u0292\3\2\2\2\u0296\u0293\3"+
		"\2\2\2\u0296\u0294\3\2\2\2\u0296\u0295\3\2\2\2\u0297\u02a0\3\2\2\2\u0298"+
		"\u0299\f\3\2\2\u0299\u029b\7L\2\2\u029a\u029c\5\\/\2\u029b\u029a\3\2\2"+
		"\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\7M\2\2\u029e\u0298"+
		"\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1"+
		"Q\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\u02a4\t\5\2\2\u02a4S\3\2\2\2\u02a5"+
		"\u02a6\7\5\2\2\u02a6\u02a7\7\61\2\2\u02a7U\3\2\2\2\u02a8\u02a9\7 \2\2"+
		"\u02a9\u02ab\7J\2\2\u02aa\u02ac\5$\23\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac"+
		"\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02b2\7K\2\2\u02ae\u02b1\5\"\22\2\u02af"+
		"\u02b1\5*\26\2\u02b0\u02ae\3\2\2\2\u02b0\u02af\3\2\2\2\u02b1\u02b4\3\2"+
		"\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02ba\3\2\2\2\u02b4"+
		"\u02b2\3\2\2\2\u02b5\u02b6\78\2\2\u02b6\u02b7\7J\2\2\u02b7\u02b8\5$\23"+
		"\2\u02b8\u02b9\7K\2\2\u02b9\u02bb\3\2\2\2\u02ba\u02b5\3\2\2\2\u02ba\u02bb"+
		"\3\2\2\2\u02bbW\3\2\2\2\u02bc\u02be\5P)\2\u02bd\u02bf\5Z.\2\u02be\u02bd"+
		"\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\5d\63\2\u02c1"+
		"Y\3\2\2\2\u02c2\u02c3\t\6\2\2\u02c3[\3\2\2\2\u02c4\u02c5\b/\1\2\u02c5"+
		"\u02c6\7\61\2\2\u02c6\u02d9\5\34\17\2\u02c7\u02c8\7A\2\2\u02c8\u02c9\7"+
		"J\2\2\u02c9\u02ca\5P)\2\u02ca\u02cb\7K\2\2\u02cb\u02d9\3\2\2\2\u02cc\u02cd"+
		"\t\7\2\2\u02cd\u02d9\5\\/\25\u02ce\u02cf\7.\2\2\u02cf\u02d9\5P)\2\u02d0"+
		"\u02d9\5`\61\2\u02d1\u02d9\5b\62\2\u02d2\u02d7\5d\63\2\u02d3\u02d7\5f"+
		"\64\2\u02d4\u02d7\5h\65\2\u02d5\u02d7\5R*\2\u02d6\u02d2\3\2\2\2\u02d6"+
		"\u02d3\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d6\u02d5\3\2\2\2\u02d7\u02d9\3\2"+
		"\2\2\u02d8\u02c4\3\2\2\2\u02d8\u02c7\3\2\2\2\u02d8\u02cc\3\2\2\2\u02d8"+
		"\u02ce\3\2\2\2\u02d8\u02d0\3\2\2\2\u02d8\u02d1\3\2\2\2\u02d8\u02d6\3\2"+
		"\2\2\u02d9\u032e\3\2\2\2\u02da\u02db\f\23\2\2\u02db\u02dc\7p\2\2\u02dc"+
		"\u032d\5\\/\23\u02dd\u02de\f\22\2\2\u02de\u02df\t\b\2\2\u02df\u032d\5"+
		"\\/\23\u02e0\u02e1\f\21\2\2\u02e1\u02e2\t\t\2\2\u02e2\u032d\5\\/\22\u02e3"+
		"\u02e4\f\20\2\2\u02e4\u02e5\t\n\2\2\u02e5\u032d\5\\/\21\u02e6\u02e7\f"+
		"\17\2\2\u02e7\u02e8\7g\2\2\u02e8\u032d\5\\/\20\u02e9\u02ea\f\16\2\2\u02ea"+
		"\u02eb\7f\2\2\u02eb\u032d\5\\/\17\u02ec\u02ed\f\r\2\2\u02ed\u02ee\7e\2"+
		"\2\u02ee\u032d\5\\/\16\u02ef\u02f0\f\f\2\2\u02f0\u02f1\t\13\2\2\u02f1"+
		"\u032d\5\\/\r\u02f2\u02f3\f\13\2\2\u02f3\u02f4\t\f\2\2\u02f4\u032d\5\\"+
		"/\f\u02f5\u02f6\f\n\2\2\u02f6\u02f7\7d\2\2\u02f7\u032d\5\\/\13\u02f8\u02f9"+
		"\f\t\2\2\u02f9\u02fa\7c\2\2\u02fa\u032d\5\\/\n\u02fb\u02fc\f\b\2\2\u02fc"+
		"\u02fd\7S\2\2\u02fd\u02fe\5\\/\2\u02fe\u02ff\7P\2\2\u02ff\u0300\5\\/\b"+
		"\u0300\u032d\3\2\2\2\u0301\u0302\f\7\2\2\u0302\u0303\5^\60\2\u0303\u0304"+
		"\5\\/\7\u0304\u032d\3\2\2\2\u0305\u0306\f\34\2\2\u0306\u0308\7L\2\2\u0307"+
		"\u0309\5\\/\2\u0308\u0307\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2"+
		"\2\2\u030a\u032d\7M\2\2\u030b\u030c\f\33\2\2\u030c\u030e\7L\2\2\u030d"+
		"\u030f\5\\/\2\u030e\u030d\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0310\3\2"+
		"\2\2\u0310\u0312\7P\2\2\u0311\u0313\5\\/\2\u0312\u0311\3\2\2\2\u0312\u0313"+
		"\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u032d\7M\2\2\u0315\u0316\f\32\2\2\u0316"+
		"\u0319\7R\2\2\u0317\u031a\5d\63\2\u0318\u031a\7\5\2\2\u0319\u0317\3\2"+
		"\2\2\u0319\u0318\3\2\2\2\u031a\u032d\3\2\2\2\u031b\u031c\f\31\2\2\u031c"+
		"\u0325\7N\2\2\u031d\u0322\5\32\16\2\u031e\u031f\7b\2\2\u031f\u0321\5\32"+
		"\16\2\u0320\u031e\3\2\2\2\u0321\u0324\3\2\2\2\u0322\u0320\3\2\2\2\u0322"+
		"\u0323\3\2\2\2\u0323\u0326\3\2\2\2\u0324\u0322\3\2\2\2\u0325\u031d\3\2"+
		"\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u032d\7O\2\2\u0328"+
		"\u0329\f\30\2\2\u0329\u032d\5\34\17\2\u032a\u032b\f\24\2\2\u032b\u032d"+
		"\t\r\2\2\u032c\u02da\3\2\2\2\u032c\u02dd\3\2\2\2\u032c\u02e0\3\2\2\2\u032c"+
		"\u02e3\3\2\2\2\u032c\u02e6\3\2\2\2\u032c\u02e9\3\2\2\2\u032c\u02ec\3\2"+
		"\2\2\u032c\u02ef\3\2\2\2\u032c\u02f2\3\2\2\2\u032c\u02f5\3\2\2\2\u032c"+
		"\u02f8\3\2\2\2\u032c\u02fb\3\2\2\2\u032c\u0301\3\2\2\2\u032c\u0305\3\2"+
		"\2\2\u032c\u030b\3\2\2\2\u032c\u0315\3\2\2\2\u032c\u031b\3\2\2\2\u032c"+
		"\u0328\3\2\2\2\u032c\u032a\3\2\2\2\u032d\u0330\3\2\2\2\u032e\u032c\3\2"+
		"\2\2\u032e\u032f\3\2\2\2\u032f]\3\2\2\2\u0330\u032e\3\2\2\2\u0331\u0332"+
		"\t\16\2\2\u0332_\3\2\2\2\u0333\u0335\7J\2\2\u0334\u0336\5\\/\2\u0335\u0334"+
		"\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u033d\3\2\2\2\u0337\u0339\7b\2\2\u0338"+
		"\u033a\5\\/\2\u0339\u0338\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033c\3\2"+
		"\2\2\u033b\u0337\3\2\2\2\u033c\u033f\3\2\2\2\u033d\u033b\3\2\2\2\u033d"+
		"\u033e\3\2\2\2\u033e\u0340\3\2\2\2\u033f\u033d\3\2\2\2\u0340\u0341\7K"+
		"\2\2\u0341a\3\2\2\2\u0342\u0343\7L\2\2\u0343\u0348\5\\/\2\u0344\u0345"+
		"\7b\2\2\u0345\u0347\5\\/\2\u0346\u0344\3\2\2\2\u0347\u034a\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u0348\3\2"+
		"\2\2\u034b\u034c\7M\2\2\u034cc\3\2\2\2\u034d\u034e\t\17\2\2\u034ee\3\2"+
		"\2\2\u034f\u0355\5l\67\2\u0350\u0355\5r:\2\u0351\u0355\5j\66\2\u0352\u0355"+
		"\5n8\2\u0353\u0355\5p9\2\u0354\u034f\3\2\2\2\u0354\u0350\3\2\2\2\u0354"+
		"\u0351\3\2\2\2\u0354\u0352\3\2\2\2\u0354\u0353\3\2\2\2\u0355g\3\2\2\2"+
		"\u0356\u0357\5r:\2\u0357\u0358\7/\2\2\u0358i\3\2\2\2\u0359\u035a\t\20"+
		"\2\2\u035ak\3\2\2\2\u035b\u035d\t\21\2\2\u035c\u035b\3\2\2\2\u035d\u035e"+
		"\3\2\2\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035fm\3\2\2\2\u0360"+
		"\u0362\7\u0080\2\2\u0361\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0361"+
		"\3\2\2\2\u0363\u0364\3\2\2\2\u0364o\3\2\2\2\u0365\u0367\7\177\2\2\u0366"+
		"\u0365\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u0366\3\2\2\2\u0368\u0369\3\2"+
		"\2\2\u0369q\3\2\2\2\u036a\u036b\t\22\2\2\u036bs\3\2\2\2\u036c\u0371\7"+
		"N\2\2\u036d\u0370\5x=\2\u036e\u0370\5v<\2\u036f\u036d\3\2\2\2\u036f\u036e"+
		"\3\2\2\2\u0370\u0373\3\2\2\2\u0371\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372"+
		"\u0374\3\2\2\2\u0373\u0371\3\2\2\2\u0374\u0375\7O\2\2\u0375u\3\2\2\2\u0376"+
		"\u0377\7C\2\2\u0377\u0378\5t;\2\u0378w\3\2\2\2\u0379\u0387\5t;\2\u037a"+
		"\u0387\5z>\2\u037b\u0387\5|?\2\u037c\u0387\5~@\2\u037d\u0387\5\u0080A"+
		"\2\u037e\u0387\5\u0082B\2\u037f\u0387\5\u0084C\2\u0380\u0387\5\u0086D"+
		"\2\u0381\u0387\5\u0088E\2\u0382\u0387\5\u008cG\2\u0383\u0387\5\u008eH"+
		"\2\u0384\u0387\5\u0090I\2\u0385\u0387\5\u0092J\2\u0386\u0379\3\2\2\2\u0386"+
		"\u037a\3\2\2\2\u0386\u037b\3\2\2\2\u0386\u037c\3\2\2\2\u0386\u037d\3\2"+
		"\2\2\u0386\u037e\3\2\2\2\u0386\u037f\3\2\2\2\u0386\u0380\3\2\2\2\u0386"+
		"\u0381\3\2\2\2\u0386\u0382\3\2\2\2\u0386\u0383\3\2\2\2\u0386\u0384\3\2"+
		"\2\2\u0386\u0385\3\2\2\2\u0387y\3\2\2\2\u0388\u038b\5\u009aN\2\u0389\u038b"+
		"\5\u009cO\2\u038a\u0388\3\2\2\2\u038a\u0389\3\2\2\2\u038b{\3\2\2\2\u038c"+
		"\u038d\7#\2\2\u038d\u038e\7J\2\2\u038e\u038f\5\\/\2\u038f\u0390\7K\2\2"+
		"\u0390\u0393\5x=\2\u0391\u0392\7\24\2\2\u0392\u0394\5x=\2\u0393\u0391"+
		"\3\2\2\2\u0393\u0394\3\2\2\2\u0394}\3\2\2\2\u0395\u0396\7\36\2\2\u0396"+
		"\u0399\7J\2\2\u0397\u039a\5z>\2\u0398\u039a\7Q\2\2\u0399\u0397\3\2\2\2"+
		"\u0399\u0398\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u039e\5\u009cO\2\u039c"+
		"\u039e\7Q\2\2\u039d\u039b\3\2\2\2\u039d\u039c\3\2\2\2\u039e\u03a0\3\2"+
		"\2\2\u039f\u03a1\5\\/\2\u03a0\u039f\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1"+
		"\u03a2\3\2\2\2\u03a2\u03a3\7K\2\2\u03a3\u03a4\5x=\2\u03a4\177\3\2\2\2"+
		"\u03a5\u03a6\7I\2\2\u03a6\u03a7\7J\2\2\u03a7\u03a8\5\\/\2\u03a8\u03a9"+
		"\7K\2\2\u03a9\u03aa\5x=\2\u03aa\u0081\3\2\2\2\u03ab\u03ac\7\23\2\2\u03ac"+
		"\u03ad\5x=\2\u03ad\u03ae\7I\2\2\u03ae\u03af\7J\2\2\u03af\u03b0\5\\/\2"+
		"\u03b0\u03b1\7K\2\2\u03b1\u03b2\7Q\2\2\u03b2\u0083\3\2\2\2\u03b3\u03b4"+
		"\7\20\2\2\u03b4\u03b5\7Q\2\2\u03b5\u0085\3\2\2\2\u03b6\u03b7\7\n\2\2\u03b7"+
		"\u03b8\7Q\2\2\u03b8\u0087\3\2\2\2\u03b9\u03ba\7@\2\2\u03ba\u03c0\5\\/"+
		"\2\u03bb\u03bc\78\2\2\u03bc\u03bd\7J\2\2\u03bd\u03be\5$\23\2\u03be\u03bf"+
		"\7K\2\2\u03bf\u03c1\3\2\2\2\u03c0\u03bb\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1"+
		"\u03c2\3\2\2\2\u03c2\u03c4\5t;\2\u03c3\u03c5\5\u008aF\2\u03c4\u03c3\3"+
		"\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u0089\3\2\2\2\u03c8\u03d0\7\r\2\2\u03c9\u03cb\5d\63\2\u03ca\u03c9\3\2"+
		"\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03cd\7J\2\2\u03cd"+
		"\u03ce\5$\23\2\u03ce\u03cf\7K\2\2\u03cf\u03d1\3\2\2\2\u03d0\u03ca\3\2"+
		"\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d3\5t;\2\u03d3\u008b"+
		"\3\2\2\2\u03d4\u03d6\7\67\2\2\u03d5\u03d7\5\\/\2\u03d6\u03d5\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03d9\7Q\2\2\u03d9\u008d\3\2"+
		"\2\2\u03da\u03db\7\25\2\2\u03db\u03dc\5\\/\2\u03dc\u03dd\5\34\17\2\u03dd"+
		"\u03de\7Q\2\2\u03de\u008f\3\2\2\2\u03df\u03e0\79\2\2\u03e0\u03e1\5\\/"+
		"\2\u03e1\u03e2\5\34\17\2\u03e2\u03e3\7Q\2\2\u03e3\u0091\3\2\2\2\u03e4"+
		"\u03e6\7\b\2\2\u03e5\u03e7\7\u0089\2\2\u03e6\u03e5\3\2\2\2\u03e6\u03e7"+
		"\3\2\2\2\u03e7\u03e9\3\2\2\2\u03e8\u03ea\5\u0094K\2\u03e9\u03e8\3\2\2"+
		"\2\u03e9\u03ea\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03ef\7\u008a\2\2\u03ec"+
		"\u03ee\5\u00a2R\2\u03ed\u03ec\3\2\2\2\u03ee\u03f1\3\2\2\2\u03ef\u03ed"+
		"\3\2\2\2\u03ef\u03f0\3\2\2\2\u03f0\u03f2\3\2\2\2\u03f1\u03ef\3\2\2\2\u03f2"+
		"\u03f3\7\u00a1\2\2\u03f3\u0093\3\2\2\2\u03f4\u03f5\7\u008c\2\2\u03f5\u03fa"+
		"\7\u008b\2\2\u03f6\u03f7\7\u008e\2\2\u03f7\u03f9\7\u008b\2\2\u03f8\u03f6"+
		"\3\2\2\2\u03f9\u03fc\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa\u03fb\3\2\2\2\u03fb"+
		"\u03fd\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fd\u03fe\7\u008d\2\2\u03fe\u0095"+
		"\3\2\2\2\u03ff\u0404\5X-\2\u0400\u0401\7b\2\2\u0401\u0403\5X-\2\u0402"+
		"\u0400\3\2\2\2\u0403\u0406\3\2\2\2\u0404\u0402\3\2\2\2\u0404\u0405\3\2"+
		"\2\2\u0405\u0097\3\2\2\2\u0406\u0404\3\2\2\2\u0407\u040b\7J\2\2\u0408"+
		"\u040a\7b\2\2\u0409\u0408\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2"+
		"\2\2\u040b\u040c\3\2\2\2\u040c\u040e\3\2\2\2\u040d\u040b\3\2\2\2\u040e"+
		"\u040f\5X-\2\u040f\u0416\3\2\2\2\u0410\u0412\7b\2\2\u0411\u0413\5X-\2"+
		"\u0412\u0411\3\2\2\2\u0412\u0413\3\2\2\2\u0413\u0415\3\2\2\2\u0414\u0410"+
		"\3\2\2\2\u0415\u0418\3\2\2\2\u0416\u0414\3\2\2\2\u0416\u0417\3\2\2\2\u0417"+
		"\u0419\3\2\2\2\u0418\u0416\3\2\2\2\u0419\u041a\7K\2\2\u041a\u0099\3\2"+
		"\2\2\u041b\u041e\5X-\2\u041c\u041d\7V\2\2\u041d\u041f\5\\/\2\u041e\u041c"+
		"\3\2\2\2\u041e\u041f\3\2\2\2\u041f\u0425\3\2\2\2\u0420\u0421\5\u0098M"+
		"\2\u0421\u0422\7V\2\2\u0422\u0423\5\\/\2\u0423\u0425\3\2\2\2\u0424\u041b"+
		"\3\2\2\2\u0424\u0420\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\7Q\2\2\u0427"+
		"\u009b\3\2\2\2\u0428\u0429\5\\/\2\u0429\u042a\7Q\2\2\u042a\u009d\3\2\2"+
		"\2\u042b\u042c\7+\2\2\u042c\u042d\7J\2\2\u042d\u042f\5\u00a0Q\2\u042e"+
		"\u0430\5d\63\2\u042f\u042e\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u0431\3\2"+
		"\2\2\u0431\u0432\7T\2\2\u0432\u0434\5P)\2\u0433\u0435\5d\63\2\u0434\u0433"+
		"\3\2\2\2\u0434\u0435\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0437\7K\2\2\u0437"+
		"\u009f\3\2\2\2\u0438\u043b\5R*\2\u0439\u043b\5\36\20\2\u043a\u0438\3\2"+
		"\2\2\u043a\u0439\3\2\2\2\u043b\u00a1\3\2\2\2\u043c\u0448\5\u00a4S\2\u043d"+
		"\u0448\5\u00a6T\2\u043e\u0448\5\u00a8U\2\u043f\u0448\5\u00b6\\\2\u0440"+
		"\u0448\5\u00aaV\2\u0441\u0448\5\u00acW\2\u0442\u0448\5\u00b0Y\2\u0443"+
		"\u0448\7\u009a\2\2\u0444\u0448\7\u0092\2\2\u0445\u0448\7\u0094\2\2\u0446"+
		"\u0448\5\u00b2Z\2\u0447\u043c\3\2\2\2\u0447\u043d\3\2\2\2\u0447\u043e"+
		"\3\2\2\2\u0447\u043f\3\2\2\2\u0447\u0440\3\2\2\2\u0447\u0441\3\2\2\2\u0447"+
		"\u0442\3\2\2\2\u0447\u0443\3\2\2\2\u0447\u0444\3\2\2\2\u0447\u0445\3\2"+
		"\2\2\u0447\u0446\3\2\2\2\u0448\u00a3\3\2\2\2\u0449\u044d\7\u00a0\2\2\u044a"+
		"\u044c\5\u00a2R\2\u044b\u044a\3\2\2\2\u044c\u044f\3\2\2\2\u044d\u044b"+
		"\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u0450\3\2\2\2\u044f\u044d\3\2\2\2\u0450"+
		"\u0451\7\u00a1\2\2\u0451\u00a5\3\2\2\2\u0452\u0453\7\u009b\2\2\u0453\u0456"+
		"\7\u00a8\2\2\u0454\u0455\7\u00a4\2\2\u0455\u0457\5\u00bc_\2\u0456\u0454"+
		"\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0466\3\2\2\2\u0458\u0459\7\u009b\2"+
		"\2\u0459\u045e\7\u00a8\2\2\u045a\u045b\7\u00a6\2\2\u045b\u045d\7\u00a8"+
		"\2\2\u045c\u045a\3\2\2\2\u045d\u0460\3\2\2\2\u045e\u045c\3\2\2\2\u045e"+
		"\u045f\3\2\2\2\u045f\u0463\3\2\2\2\u0460\u045e\3\2\2\2\u0461\u0462\7\u00a4"+
		"\2\2\u0462\u0464\5\u00b6\\\2\u0463\u0461\3\2\2\2\u0463\u0464\3\2\2\2\u0464"+
		"\u0466\3\2\2\2\u0465\u0452\3\2\2\2\u0465\u0458\3\2\2\2\u0466\u00a7\3\2"+
		"\2\2\u0467\u0468\5\u00b4[\2\u0468\u0469\7\u00a4\2\2\u0469\u046a\5\u00bc"+
		"_\2\u046a\u0476\3\2\2\2\u046b\u046e\5\u00b4[\2\u046c\u046d\7\u00a6\2\2"+
		"\u046d\u046f\5\u00b4[\2\u046e\u046c\3\2\2\2\u046f\u0470\3\2\2\2\u0470"+
		"\u046e\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\7\u00a4"+
		"\2\2\u0473\u0474\5\u00b6\\\2\u0474\u0476\3\2\2\2\u0475\u0467\3\2\2\2\u0475"+
		"\u046b\3\2\2\2\u0476\u00a9\3\2\2\2\u0477\u0478\7\u0099\2\2\u0478\u0479"+
		"\5\u00bc_\2\u0479\u047a\5\u00a4S\2\u047a\u00ab\3\2\2\2\u047b\u047c\7\u0097"+
		"\2\2\u047c\u047d\5\u00a4S\2\u047d\u047e\5\u00bc_\2\u047e\u047f\5\u00a4"+
		"S\2\u047f\u0480\5\u00a4S\2\u0480\u00ad\3\2\2\2\u0481\u0482\7\u0093\2\2"+
		"\u0482\u0483\5\u00ba^\2\u0483\u0484\5\u00a4S\2\u0484\u00af\3\2\2\2\u0485"+
		"\u0486\7\u009c\2\2\u0486\u0492\5\u00bc_\2\u0487\u0489\5\u00aeX\2\u0488"+
		"\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2"+
		"\2\2\u048b\u048e\3\2\2\2\u048c\u048d\7\u0095\2\2\u048d\u048f\5\u00a4S"+
		"\2\u048e\u048c\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0493\3\2\2\2\u0490\u0491"+
		"\7\u0095\2\2\u0491\u0493\5\u00a4S\2\u0492\u0488\3\2\2\2\u0492\u0490\3"+
		"\2\2\2\u0493\u00b1\3\2\2\2\u0494\u0495\7\u0098\2\2\u0495\u0496\7\u00a8"+
		"\2\2\u0496\u049f\7\u00a2\2\2\u0497\u049c\7\u00a8\2\2\u0498\u0499\7\u00a6"+
		"\2\2\u0499\u049b\7\u00a8\2\2\u049a\u0498\3\2\2\2\u049b\u049e\3\2\2\2\u049c"+
		"\u049a\3\2\2\2\u049c\u049d\3\2\2\2\u049d\u04a0\3\2\2\2\u049e\u049c\3\2"+
		"\2\2\u049f\u0497\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1"+
		"\u04ab\7\u00a3\2\2\u04a2\u04a3\7\u00a7\2\2\u04a3\u04a8\7\u00a8\2\2\u04a4"+
		"\u04a5\7\u00a6\2\2\u04a5\u04a7\7\u00a8\2\2\u04a6\u04a4\3\2\2\2\u04a7\u04aa"+
		"\3\2\2\2\u04a8\u04a6\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04ac\3\2\2\2\u04aa"+
		"\u04a8\3\2\2\2\u04ab\u04a2\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\3\2"+
		"\2\2\u04ad\u04ae\5\u00a4S\2\u04ae\u00b3\3\2\2\2\u04af\u04b4\7\u00a8\2"+
		"\2\u04b0\u04b1\7\u00a5\2\2\u04b1\u04b3\t\23\2\2\u04b2\u04b0\3\2\2\2\u04b3"+
		"\u04b6\3\2\2\2\u04b4\u04b2\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u00b5\3\2"+
		"\2\2\u04b6\u04b4\3\2\2\2\u04b7\u04b8\t\23\2\2\u04b8\u04c1\7\u00a2\2\2"+
		"\u04b9\u04be\5\u00bc_\2\u04ba\u04bb\7\u00a6\2\2\u04bb\u04bd\5\u00bc_\2"+
		"\u04bc\u04ba\3\2\2\2\u04bd\u04c0\3\2\2\2\u04be\u04bc\3\2\2\2\u04be\u04bf"+
		"\3\2\2\2\u04bf\u04c2\3\2\2\2\u04c0\u04be\3\2\2\2\u04c1\u04b9\3\2\2\2\u04c1"+
		"\u04c2\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c4\7\u00a3\2\2\u04c4\u00b7"+
		"\3\2\2\2\u04c5\u04c6\t\24\2\2\u04c6\u00b9\3\2\2\2\u04c7\u04cd\7\u00aa"+
		"\2\2\u04c8\u04cd\7\u00ab\2\2\u04c9\u04cd\7\u00a9\2\2\u04ca\u04cd\5\u00b8"+
		"]\2\u04cb\u04cd\7\u00ac\2\2\u04cc\u04c7\3\2\2\2\u04cc\u04c8\3\2\2\2\u04cc"+
		"\u04c9\3\2\2\2\u04cc\u04ca\3\2\2\2\u04cc\u04cb\3\2\2\2\u04cd\u00bb\3\2"+
		"\2\2\u04ce\u04d2\5\u00b4[\2\u04cf\u04d2\5\u00b6\\\2\u04d0\u04d2\5\u00ba"+
		"^\2\u04d1\u04ce\3\2\2\2\u04d1\u04cf\3\2\2\2\u04d1\u04d0\3\2\2\2\u04d2"+
		"\u00bd\3\2\2\2\u008f\u00cb\u00cd\u00d6\u00de\u00ea\u00f1\u00fb\u0101\u0106"+
		"\u010c\u0114\u011a\u0125\u0130\u0135\u0143\u014f\u0152\u015a\u015d\u0160"+
		"\u0169\u016e\u0177\u017c\u017f\u0184\u018b\u018d\u019b\u01a0\u01a6\u01aa"+
		"\u01b3\u01b5\u01bd\u01c1\u01c7\u01ca\u01ce\u01d0\u01d5\u01da\u01e2\u01e4"+
		"\u01ec\u01f0\u01fa\u01fc\u0201\u0209\u0219\u0223\u022f\u0231\u0237\u0244"+
		"\u0247\u0251\u0254\u0258\u025e\u0268\u026b\u027a\u027f\u0284\u0287\u028e"+
		"\u0296\u029b\u02a0\u02ab\u02b0\u02b2\u02ba\u02be\u02d6\u02d8\u0308\u030e"+
		"\u0312\u0319\u0322\u0325\u032c\u032e\u0335\u0339\u033d\u0348\u0354\u035e"+
		"\u0363\u0368\u036f\u0371\u0386\u038a\u0393\u0399\u039d\u03a0\u03c0\u03c6"+
		"\u03ca\u03d0\u03d6\u03e6\u03e9\u03ef\u03fa\u0404\u040b\u0412\u0416\u041e"+
		"\u0424\u042f\u0434\u043a\u0447\u044d\u0456\u045e\u0463\u0465\u0470\u0475"+
		"\u048a\u048e\u0492\u049c\u049f\u04a8\u04ab\u04b4\u04be\u04c1\u04cc\u04d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}