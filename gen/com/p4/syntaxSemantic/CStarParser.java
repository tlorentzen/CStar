// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/syntaxSemantic\CStar.g4 by ANTLR 4.8
package com.p4.syntaxSemantic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ONE_OF=8,
		ASSIGN_OP=9, PLUS=10, MINUS=11, MULT=12, DIVISION=13, LESS_THAN_EQ=14,
		GREATER_THAN_EQ=15, MODULO=16, LEFT_PAREN=17, RIGHT_PAREN=18, LEFT_BRACKET=19,
		RIGHT_BRACKET=20, LEFT_BRACE=21, RIGHT_BRACE=22, SEMICOLON=23, DOT=24,
		IF=25, ELSE=26, WHILE=27, REPEAT=28, COMMA=29, VOID=30, TYPE=31, ARRAY=32,
		RETURN=33, PRINT=34, HIGH=35, LOW=36, BETWEEN=37, IN=38, NUMBER=39, BOOLEAN_LITERAL=40,
		PIN_LITERAL=41, CHAR_LITERAL=42, STRING_LITERAL=43, ID=44, FUNCID=45,
		WHITESPACE=46, Newline=47, LINE_COMMENT=48, INCLUDE=49, HEADER=50;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_assign = 2, RULE_expr = 3, RULE_logical_expr = 4,
		RULE_test_mult_val = 5, RULE_interval = 6, RULE_in_array = 7, RULE_cond_expr = 8,
		RULE_arithm_expr = 9, RULE_term = 10, RULE_factor = 11, RULE_value_expr = 12,
		RULE_array_dcl = 13, RULE_array_expr = 14, RULE_array_access = 15, RULE_stmt = 16,
		RULE_iterative = 17, RULE_selection = 18, RULE_blk = 19, RULE_print = 20,
		RULE_func = 21, RULE_return_type = 22, RULE_param = 23, RULE_return_exp = 24,
		RULE_func_call = 25, RULE_array_func = 26, RULE_val = 27, RULE_comment = 28,
		RULE_include = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "assign", "expr", "logical_expr", "test_mult_val", "interval",
			"in_array", "cond_expr", "arithm_expr", "term", "factor", "value_expr",
			"array_dcl", "array_expr", "array_access", "stmt", "iterative", "selection",
			"blk", "print", "func", "return_type", "param", "return_exp", "func_call",
			"array_func", "val", "comment", "include"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'ONE OF'",
			"'='", "'+'", "'-'", "'*'", "'/'", "'<='", "'>='", "'%'", "'('", "')'",
			"'['", "']'", "'{'", "'}'", "';'", "'.'", "'if'", "'else'", "'while'",
			"'repeat'", "','", "'void'", null, "'array'", "'return'", "'console.print'",
			"'HIGH'", "'LOW'", "'BETWEEN'", "'IN'", null, null, null, null, null,
			null, null, null, null, null, "'#include'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND",
			"ONE_OF", "ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ",
			"GREATER_THAN_EQ", "MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET",
			"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF",
			"ELSE", "WHILE", "REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN",
			"PRINT", "HIGH", "LOW", "BETWEEN", "IN", "NUMBER", "BOOLEAN_LITERAL",
			"PIN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "ID", "FUNCID", "WHITESPACE",
			"Newline", "LINE_COMMENT", "INCLUDE", "HEADER"
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
	public String getGrammarFileName() { return "CStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CStarParser.EOF, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitProg(this);
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
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << VOID) | (1L << TYPE) | (1L << PRINT) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID) | (1L << LINE_COMMENT) | (1L << INCLUDE))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(60);
					dcl();
					}
					break;
				case 2:
					{
					setState(61);
					stmt();
					}
					break;
				case 3:
					{
					setState(62);
					func();
					}
					break;
				case 4:
					{
					setState(63);
					include();
					}
					break;
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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

	public static class DclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CStarParser.TYPE, 0); }
		public TerminalNode SEMICOLON() { return getToken(CStarParser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Array_dclContext array_dcl() {
			return getRuleContext(Array_dclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(TYPE);
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(72);
				match(ID);
				}
				break;
			case 2:
				{
				setState(73);
				assign();
				}
				break;
			case 3:
				{
				setState(74);
				array_dcl();
				}
				break;
			}
			setState(77);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(79);
				match(ID);
				}
				break;
			case 2:
				{
				setState(80);
				array_access();
				}
				break;
			}
			setState(83);
			match(ASSIGN_OP);
			setState(84);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			logical_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_exprContext extends ParserRuleContext {
		public List<Cond_exprContext> cond_expr() {
			return getRuleContexts(Cond_exprContext.class);
		}
		public Cond_exprContext cond_expr(int i) {
			return getRuleContext(Cond_exprContext.class,i);
		}
		public List<IntervalContext> interval() {
			return getRuleContexts(IntervalContext.class);
		}
		public IntervalContext interval(int i) {
			return getRuleContext(IntervalContext.class,i);
		}
		public List<In_arrayContext> in_array() {
			return getRuleContexts(In_arrayContext.class);
		}
		public In_arrayContext in_array(int i) {
			return getRuleContext(In_arrayContext.class,i);
		}
		public List<Test_mult_valContext> test_mult_val() {
			return getRuleContexts(Test_mult_valContext.class);
		}
		public Test_mult_valContext test_mult_val(int i) {
			return getRuleContext(Test_mult_valContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CStarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CStarParser.OR, i);
		}
		public List<TerminalNode> AND() { return getTokens(CStarParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CStarParser.AND, i);
		}
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterLogical_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitLogical_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitLogical_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(88);
				cond_expr();
				}
				break;
			case 2:
				{
				setState(89);
				interval();
				}
				break;
			case 3:
				{
				setState(90);
				in_array();
				}
				break;
			case 4:
				{
				setState(91);
				test_mult_val();
				}
				break;
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(94);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(95);
					cond_expr();
					}
					break;
				case 2:
					{
					setState(96);
					interval();
					}
					break;
				case 3:
					{
					setState(97);
					in_array();
					}
					break;
				case 4:
					{
					setState(98);
					test_mult_val();
					}
					break;
				}
				}
				}
				setState(105);
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

	public static class Test_mult_valContext extends ParserRuleContext {
		public List<Value_exprContext> value_expr() {
			return getRuleContexts(Value_exprContext.class);
		}
		public Value_exprContext value_expr(int i) {
			return getRuleContext(Value_exprContext.class,i);
		}
		public TerminalNode ONE_OF() { return getToken(CStarParser.ONE_OF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CStarParser.COMMA, i);
		}
		public Test_mult_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_mult_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterTest_mult_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitTest_mult_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitTest_mult_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_mult_valContext test_mult_val() throws RecognitionException {
		Test_mult_valContext _localctx = new Test_mult_valContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_test_mult_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			value_expr();
			setState(107);
			match(ONE_OF);
			setState(108);
			match(LEFT_PAREN);
			setState(109);
			value_expr();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(110);
				match(COMMA);
				setState(111);
				value_expr();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public List<Value_exprContext> value_expr() {
			return getRuleContexts(Value_exprContext.class);
		}
		public Value_exprContext value_expr(int i) {
			return getRuleContext(Value_exprContext.class,i);
		}
		public TerminalNode BETWEEN() { return getToken(CStarParser.BETWEEN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CStarParser.SEMICOLON, 0); }
		public List<TerminalNode> LEFT_BRACKET() { return getTokens(CStarParser.LEFT_BRACKET); }
		public TerminalNode LEFT_BRACKET(int i) {
			return getToken(CStarParser.LEFT_BRACKET, i);
		}
		public List<TerminalNode> RIGHT_BRACKET() { return getTokens(CStarParser.RIGHT_BRACKET); }
		public TerminalNode RIGHT_BRACKET(int i) {
			return getToken(CStarParser.RIGHT_BRACKET, i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_interval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			value_expr();
			setState(120);
			match(BETWEEN);
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==LEFT_BRACKET || _la==RIGHT_BRACKET) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(122);
			value_expr();
			setState(123);
			match(SEMICOLON);
			setState(124);
			value_expr();
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==LEFT_BRACKET || _la==RIGHT_BRACKET) ) {
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

	public static class In_arrayContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public TerminalNode IN() { return getToken(CStarParser.IN, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public In_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterIn_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitIn_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitIn_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_arrayContext in_array() throws RecognitionException {
		In_arrayContext _localctx = new In_arrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_in_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			value_expr();
			setState(128);
			match(IN);
			setState(129);
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

	public static class Cond_exprContext extends ParserRuleContext {
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public TerminalNode COMP_OP() { return getToken(CStarParser.COMP_OP, 0); }
		public Cond_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterCond_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitCond_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitCond_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_exprContext cond_expr() throws RecognitionException {
		Cond_exprContext _localctx = new Cond_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cond_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			arithm_expr();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMP_OP) {
				{
				setState(132);
				match(COMP_OP);
				setState(133);
				arithm_expr();
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

	public static class Arithm_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CStarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CStarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CStarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CStarParser.MINUS, i);
		}
		public Arithm_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArithm_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArithm_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArithm_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithm_exprContext arithm_expr() throws RecognitionException {
		Arithm_exprContext _localctx = new Arithm_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arithm_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			term();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				term();
				}
				}
				setState(143);
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CStarParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CStarParser.MULT, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(CStarParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(CStarParser.DIVISION, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(CStarParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(CStarParser.MODULO, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			factor();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVISION) | (1L << MODULO))) != 0)) {
				{
				{
				setState(145);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVISION) | (1L << MODULO))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				factor();
				}
				}
				setState(151);
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

	public static class FactorContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public TerminalNode MINUS() { return getToken(CStarParser.MINUS, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				value_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(153);
					match(MINUS);
					}
				}

				setState(156);
				match(LEFT_PAREN);
				setState(157);
				expr();
				setState(158);
				match(RIGHT_PAREN);
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

	public static class Value_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CStarParser.MINUS, 0); }
		public Value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterValue_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitValue_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitValue_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_exprContext value_expr() throws RecognitionException {
		Value_exprContext _localctx = new Value_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(162);
				match(MINUS);
				}
			}

			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(165);
				match(ID);
				}
				break;
			case 2:
				{
				setState(166);
				val();
				}
				break;
			case 3:
				{
				setState(167);
				func_call();
				}
				break;
			case 4:
				{
				setState(168);
				array_access();
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

	public static class Array_dclContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(CStarParser.ARRAY, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public Array_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_dclContext array_dcl() throws RecognitionException {
		Array_dclContext _localctx = new Array_dclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(ARRAY);
			setState(172);
			match(ID);
			setState(173);
			match(ASSIGN_OP);
			setState(174);
			array_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_exprContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(CStarParser.LEFT_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CStarParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CStarParser.COMMA, i);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_exprContext array_expr() throws RecognitionException {
		Array_exprContext _localctx = new Array_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LEFT_BRACKET);
			setState(177);
			expr();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(178);
				match(COMMA);
				setState(179);
				expr();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_accessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CStarParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CStarParser.RIGHT_BRACKET, 0); }
		public Array_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_accessContext array_access() throws RecognitionException {
		Array_accessContext _localctx = new Array_accessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ID);
			setState(188);
			match(LEFT_BRACKET);
			setState(189);
			expr();
			setState(190);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CStarParser.SEMICOLON, 0); }
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public IterativeContext iterative() {
			return getRuleContext(IterativeContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stmt);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				assign();
				setState(193);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				print();
				setState(196);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				expr();
				setState(199);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(203);
				comment();
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

	public static class IterativeContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CStarParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public TerminalNode REPEAT() { return getToken(CStarParser.REPEAT, 0); }
		public BlkContext blk() {
			return getRuleContext(BlkContext.class,0);
		}
		public IterativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterIterative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitIterative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitIterative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeContext iterative() throws RecognitionException {
		IterativeContext _localctx = new IterativeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iterative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(WHILE);
			setState(207);
			match(LEFT_PAREN);
			setState(208);
			logical_expr();
			setState(209);
			match(RIGHT_PAREN);
			setState(210);
			match(REPEAT);
			setState(211);
			blk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CStarParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public List<BlkContext> blk() {
			return getRuleContexts(BlkContext.class);
		}
		public BlkContext blk(int i) {
			return getRuleContext(BlkContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CStarParser.ELSE, 0); }
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(IF);
			setState(214);
			match(LEFT_PAREN);
			setState(215);
			logical_expr();
			setState(216);
			match(RIGHT_PAREN);
			setState(217);
			blk();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(218);
				match(ELSE);
				setState(219);
				blk();
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

	public static class BlkContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(CStarParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CStarParser.RIGHT_BRACE, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<Return_expContext> return_exp() {
			return getRuleContexts(Return_expContext.class);
		}
		public Return_expContext return_exp(int i) {
			return getRuleContext(Return_expContext.class,i);
		}
		public BlkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterBlk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitBlk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitBlk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlkContext blk() throws RecognitionException {
		BlkContext _localctx = new BlkContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LEFT_BRACE);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << TYPE) | (1L << RETURN) | (1L << PRINT) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID) | (1L << LINE_COMMENT))) != 0)) {
				{
				setState(226);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(223);
					dcl();
					}
					break;
				case MINUS:
				case LEFT_PAREN:
				case IF:
				case WHILE:
				case PRINT:
				case HIGH:
				case LOW:
				case NUMBER:
				case BOOLEAN_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
				case ID:
				case FUNCID:
				case LINE_COMMENT:
					{
					setState(224);
					stmt();
					}
					break;
				case RETURN:
					{
					setState(225);
					return_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(CStarParser.PRINT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public List<TerminalNode> STRING_LITERAL() { return getTokens(CStarParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(CStarParser.STRING_LITERAL, i);
		}
		public List<TerminalNode> ID() { return getTokens(CStarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CStarParser.ID, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CStarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CStarParser.PLUS, i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(PRINT);
			setState(234);
			match(LEFT_PAREN);
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HIGH:
			case LOW:
			case NUMBER:
			case BOOLEAN_LITERAL:
			case PIN_LITERAL:
			case CHAR_LITERAL:
				{
				setState(235);
				val();
				}
				break;
			case STRING_LITERAL:
				{
				setState(236);
				match(STRING_LITERAL);
				}
				break;
			case ID:
				{
				setState(237);
				match(ID);
				}
				break;
			case PLUS:
			case RIGHT_PAREN:
				break;
			default:
				break;
			}
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(240);
				match(PLUS);
				setState(244);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HIGH:
				case LOW:
				case NUMBER:
				case BOOLEAN_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
					{
					setState(241);
					val();
					}
					break;
				case STRING_LITERAL:
					{
					setState(242);
					match(STRING_LITERAL);
					}
					break;
				case ID:
					{
					setState(243);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public BlkContext blk() {
			return getRuleContext(BlkContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			return_type();
			setState(254);
			match(ID);
			setState(255);
			match(LEFT_PAREN);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(256);
				param();
				}
			}

			setState(259);
			match(RIGHT_PAREN);
			setState(260);
			blk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CStarParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(CStarParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitReturn_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==TYPE) ) {
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

	public static class ParamContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(CStarParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CStarParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(CStarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CStarParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CStarParser.COMMA, i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(TYPE);
			setState(265);
			match(ID);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(266);
				match(COMMA);
				setState(267);
				match(TYPE);
				setState(268);
				match(ID);
				}
				}
				setState(273);
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

	public static class Return_expContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CStarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CStarParser.SEMICOLON, 0); }
		public Return_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterReturn_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitReturn_exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitReturn_exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_expContext return_exp() throws RecognitionException {
		Return_expContext _localctx = new Return_expContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_return_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(RETURN);
			setState(275);
			expr();
			setState(276);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode FUNCID() { return getToken(CStarParser.FUNCID, 0); }
		public Array_funcContext array_func() {
			return getRuleContext(Array_funcContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CStarParser.COMMA, i);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitFunc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(278);
				match(ID);
				}
				break;
			case 2:
				{
				setState(279);
				match(FUNCID);
				}
				break;
			case 3:
				{
				setState(280);
				array_func();
				}
				break;
			}
			setState(283);
			match(LEFT_PAREN);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID))) != 0)) {
				{
				setState(284);
				expr();
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(285);
					match(COMMA);
					setState(286);
					expr();
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(294);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_funcContext extends ParserRuleContext {
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CStarParser.DOT, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public Array_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_funcContext array_func() throws RecognitionException {
		Array_funcContext _localctx = new Array_funcContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_array_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			array_access();
			setState(297);
			match(DOT);
			setState(298);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode CHAR_LITERAL() { return getToken(CStarParser.CHAR_LITERAL, 0); }
		public TerminalNode PIN_LITERAL() { return getToken(CStarParser.PIN_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(CStarParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode NUMBER() { return getToken(CStarParser.NUMBER, 0); }
		public TerminalNode HIGH() { return getToken(CStarParser.HIGH, 0); }
		public TerminalNode LOW() { return getToken(CStarParser.LOW, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL))) != 0)) ) {
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() { return getToken(CStarParser.LINE_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(LINE_COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(CStarParser.INCLUDE, 0); }
		public TerminalNode HEADER() { return getToken(CStarParser.HEADER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CStarParser.STRING_LITERAL, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_include);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(INCLUDE);
			setState(305);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL || _la==HEADER) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u0136\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\7\2C\n\2\f\2\16\2F\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3N\n\3\3\3\3"+
		"\3\3\4\3\4\5\4T\n\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6_\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6f\n\6\7\6h\n\6\f\6\16\6k\13\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7s\n\7\f\7\16\7v\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\7\13\u008e\n\13"+
		"\f\13\16\13\u0091\13\13\3\f\3\f\3\f\7\f\u0096\n\f\f\f\16\f\u0099\13\f"+
		"\3\r\3\r\5\r\u009d\n\r\3\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\5\16\u00a6\n"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00ac\n\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\7\20\u00b7\n\20\f\20\16\20\u00ba\13\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00cf\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00df\n\24\3\25\3\25\3\25\3\25\7\25\u00e5"+
		"\n\25\f\25\16\25\u00e8\13\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00f1"+
		"\n\26\3\26\3\26\3\26\3\26\5\26\u00f7\n\26\7\26\u00f9\n\26\f\26\16\26\u00fc"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u0104\n\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\7\31\u0110\n\31\f\31\16\31\u0113\13"+
		"\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u011c\n\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0122\n\33\f\33\16\33\u0125\13\33\5\33\u0127\n\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\2\2 \2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\t\3\2\b"+
		"\t\3\2\25\26\3\2\f\r\4\2\16\17\22\22\3\2 !\4\2%&),\4\2--\64\64\2\u0145"+
		"\2D\3\2\2\2\4I\3\2\2\2\6S\3\2\2\2\bX\3\2\2\2\n^\3\2\2\2\fl\3\2\2\2\16"+
		"y\3\2\2\2\20\u0081\3\2\2\2\22\u0085\3\2\2\2\24\u008a\3\2\2\2\26\u0092"+
		"\3\2\2\2\30\u00a2\3\2\2\2\32\u00a5\3\2\2\2\34\u00ad\3\2\2\2\36\u00b2\3"+
		"\2\2\2 \u00bd\3\2\2\2\"\u00ce\3\2\2\2$\u00d0\3\2\2\2&\u00d7\3\2\2\2(\u00e0"+
		"\3\2\2\2*\u00eb\3\2\2\2,\u00ff\3\2\2\2.\u0108\3\2\2\2\60\u010a\3\2\2\2"+
		"\62\u0114\3\2\2\2\64\u011b\3\2\2\2\66\u012a\3\2\2\28\u012e\3\2\2\2:\u0130"+
		"\3\2\2\2<\u0132\3\2\2\2>C\5\4\3\2?C\5\"\22\2@C\5,\27\2AC\5<\37\2B>\3\2"+
		"\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2"+
		"\2\2FD\3\2\2\2GH\7\2\2\3H\3\3\2\2\2IM\7!\2\2JN\7.\2\2KN\5\6\4\2LN\5\34"+
		"\17\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2NO\3\2\2\2OP\7\31\2\2P\5\3\2\2\2QT"+
		"\7.\2\2RT\5 \21\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2UV\7\13\2\2VW\5\b\5\2W"+
		"\7\3\2\2\2XY\5\n\6\2Y\t\3\2\2\2Z_\5\22\n\2[_\5\16\b\2\\_\5\20\t\2]_\5"+
		"\f\7\2^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_i\3\2\2\2`e\t\2\2\2af"+
		"\5\22\n\2bf\5\16\b\2cf\5\20\t\2df\5\f\7\2ea\3\2\2\2eb\3\2\2\2ec\3\2\2"+
		"\2ed\3\2\2\2fh\3\2\2\2g`\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2"+
		"\2\2ki\3\2\2\2lm\5\32\16\2mn\7\n\2\2no\7\23\2\2ot\5\32\16\2pq\7\37\2\2"+
		"qs\5\32\16\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2"+
		"\2wx\7\24\2\2x\r\3\2\2\2yz\5\32\16\2z{\7\'\2\2{|\t\3\2\2|}\5\32\16\2}"+
		"~\7\31\2\2~\177\5\32\16\2\177\u0080\t\3\2\2\u0080\17\3\2\2\2\u0081\u0082"+
		"\5\32\16\2\u0082\u0083\7(\2\2\u0083\u0084\7.\2\2\u0084\21\3\2\2\2\u0085"+
		"\u0088\5\24\13\2\u0086\u0087\7\3\2\2\u0087\u0089\5\24\13\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\23\3\2\2\2\u008a\u008f\5\26\f\2\u008b"+
		"\u008c\t\4\2\2\u008c\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008e\u0091\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\25\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0097\5\30\r\2\u0093\u0094\t\5\2\2\u0094\u0096\5"+
		"\30\r\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\27\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u00a3\5\32\16"+
		"\2\u009b\u009d\7\r\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u009f\7\23\2\2\u009f\u00a0\5\b\5\2\u00a0\u00a1\7\24\2\2"+
		"\u00a1\u00a3\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009c\3\2\2\2\u00a3\31"+
		"\3\2\2\2\u00a4\u00a6\7\r\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00ab\3\2\2\2\u00a7\u00ac\7.\2\2\u00a8\u00ac\58\35\2\u00a9\u00ac\5\64"+
		"\33\2\u00aa\u00ac\5 \21\2\u00ab\u00a7\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\7\"\2"+
		"\2\u00ae\u00af\7.\2\2\u00af\u00b0\7\13\2\2\u00b0\u00b1\5\36\20\2\u00b1"+
		"\35\3\2\2\2\u00b2\u00b3\7\25\2\2\u00b3\u00b8\5\b\5\2\u00b4\u00b5\7\37"+
		"\2\2\u00b5\u00b7\5\b\5\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00bc\7\26\2\2\u00bc\37\3\2\2\2\u00bd\u00be\7.\2\2\u00be\u00bf"+
		"\7\25\2\2\u00bf\u00c0\5\b\5\2\u00c0\u00c1\7\26\2\2\u00c1!\3\2\2\2\u00c2"+
		"\u00c3\5\6\4\2\u00c3\u00c4\7\31\2\2\u00c4\u00cf\3\2\2\2\u00c5\u00c6\5"+
		"*\26\2\u00c6\u00c7\7\31\2\2\u00c7\u00cf\3\2\2\2\u00c8\u00c9\5\b\5\2\u00c9"+
		"\u00ca\7\31\2\2\u00ca\u00cf\3\2\2\2\u00cb\u00cf\5&\24\2\u00cc\u00cf\5"+
		"$\23\2\u00cd\u00cf\5:\36\2\u00ce\u00c2\3\2\2\2\u00ce\u00c5\3\2\2\2\u00ce"+
		"\u00c8\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2"+
		"\2\2\u00cf#\3\2\2\2\u00d0\u00d1\7\35\2\2\u00d1\u00d2\7\23\2\2\u00d2\u00d3"+
		"\5\n\6\2\u00d3\u00d4\7\24\2\2\u00d4\u00d5\7\36\2\2\u00d5\u00d6\5(\25\2"+
		"\u00d6%\3\2\2\2\u00d7\u00d8\7\33\2\2\u00d8\u00d9\7\23\2\2\u00d9\u00da"+
		"\5\n\6\2\u00da\u00db\7\24\2\2\u00db\u00de\5(\25\2\u00dc\u00dd\7\34\2\2"+
		"\u00dd\u00df\5(\25\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\'\3"+
		"\2\2\2\u00e0\u00e6\7\27\2\2\u00e1\u00e5\5\4\3\2\u00e2\u00e5\5\"\22\2\u00e3"+
		"\u00e5\5\62\32\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3"+
		"\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\30\2\2\u00ea)\3\2\2\2"+
		"\u00eb\u00ec\7$\2\2\u00ec\u00f0\7\23\2\2\u00ed\u00f1\58\35\2\u00ee\u00f1"+
		"\7-\2\2\u00ef\u00f1\7.\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00fa\3\2\2\2\u00f2\u00f6\7\f"+
		"\2\2\u00f3\u00f7\58\35\2\u00f4\u00f7\7-\2\2\u00f5\u00f7\7.\2\2\u00f6\u00f3"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8"+
		"\u00f2\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7\24\2\2\u00fe"+
		"+\3\2\2\2\u00ff\u0100\5.\30\2\u0100\u0101\7.\2\2\u0101\u0103\7\23\2\2"+
		"\u0102\u0104\5\60\31\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0106\7\24\2\2\u0106\u0107\5(\25\2\u0107-\3\2\2\2\u0108"+
		"\u0109\t\6\2\2\u0109/\3\2\2\2\u010a\u010b\7!\2\2\u010b\u0111\7.\2\2\u010c"+
		"\u010d\7\37\2\2\u010d\u010e\7!\2\2\u010e\u0110\7.\2\2\u010f\u010c\3\2"+
		"\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\61\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7#\2\2\u0115\u0116\5\b\5\2"+
		"\u0116\u0117\7\31\2\2\u0117\63\3\2\2\2\u0118\u011c\7.\2\2\u0119\u011c"+
		"\7/\2\2\u011a\u011c\5\66\34\2\u011b\u0118\3\2\2\2\u011b\u0119\3\2\2\2"+
		"\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0126\7\23\2\2\u011e\u0123"+
		"\5\b\5\2\u011f\u0120\7\37\2\2\u0120\u0122\5\b\5\2\u0121\u011f\3\2\2\2"+
		"\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0127"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u011e\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\7\24\2\2\u0129\65\3\2\2\2\u012a\u012b\5 \21"+
		"\2\u012b\u012c\7\32\2\2\u012c\u012d\7.\2\2\u012d\67\3\2\2\2\u012e\u012f"+
		"\t\7\2\2\u012f9\3\2\2\2\u0130\u0131\7\62\2\2\u0131;\3\2\2\2\u0132\u0133"+
		"\7\63\2\2\u0133\u0134\t\b\2\2\u0134=\3\2\2\2\36BDMS^eit\u0088\u008f\u0097"+
		"\u009c\u00a2\u00a5\u00ab\u00b8\u00ce\u00de\u00e4\u00e6\u00f0\u00f6\u00fa"+
		"\u0103\u0111\u011b\u0123\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}