// Generated from C:/Users/ichris18/Documents/GitHub/P4/src/com/p4/syntaxSemantic\CStar.g4 by ANTLR 4.8
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
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ASSIGN_OP=8,
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LESS_THAN_EQ=13, GREATER_THAN_EQ=14,
		MODULO=15, LEFT_PAREN=16, RIGHT_PAREN=17, LEFT_BRACKET=18, RIGHT_BRACKET=19,
		LEFT_BRACE=20, RIGHT_BRACE=21, SEMICOLON=22, DOT=23, IF=24, ELSE=25, WHILE=26,
		REPEAT=27, COMMA=28, VOID=29, TYPE=30, ARRAY=31, RETURN=32, PRINT=33,
		HIGH=34, LOW=35, BETWEEN=36, IN=37, NUMBER=38, BOOLEAN_LITERAL=39, PIN_LITERAL=40,
		CHAR_LITERAL=41, STRING_LITERAL=42, ID=43, FUNCID=44, WHITESPACE=45, Newline=46,
		LINE_COMMENT=47, INCLUDE=48, HEADER=49;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_assign = 2, RULE_expr = 3, RULE_logical_expr = 4,
		RULE_interval = 5, RULE_in_array = 6, RULE_cond_expr = 7, RULE_arithm_expr = 8,
		RULE_term = 9, RULE_factor = 10, RULE_value_expr = 11, RULE_array_dcl = 12,
		RULE_array_expr = 13, RULE_array_access = 14, RULE_stmt = 15, RULE_iterative = 16,
		RULE_selection = 17, RULE_blk = 18, RULE_print = 19, RULE_func = 20, RULE_return_type = 21,
		RULE_param = 22, RULE_return_exp = 23, RULE_func_call = 24, RULE_array_func = 25,
		RULE_val = 26, RULE_comment = 27, RULE_include = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "assign", "expr", "logical_expr", "interval", "in_array",
			"cond_expr", "arithm_expr", "term", "factor", "value_expr", "array_dcl",
			"array_expr", "array_access", "stmt", "iterative", "selection", "blk",
			"print", "func", "return_type", "param", "return_exp", "func_call", "array_func",
			"val", "comment", "include"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='",
			"'+'", "'-'", "'*'", "'/'", "'<='", "'>='", "'%'", "'('", "')'", "'['",
			"']'", "'{'", "'}'", "';'", "'.'", "'if'", "'else'", "'while'", "'repeat'",
			"','", "'void'", null, "'array'", "'return'", "'console.print'", "'HIGH'",
			"'LOW'", "'BETWEEN'", "'IN'", null, null, null, null, null, null, null,
			null, null, null, "'#include'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND",
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ",
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET",
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE",
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "HIGH",
			"LOW", "BETWEEN", "IN", "NUMBER", "BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL",
			"STRING_LITERAL", "ID", "FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT",
			"INCLUDE", "HEADER"
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
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << VOID) | (1L << TYPE) | (1L << PRINT) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID) | (1L << LINE_COMMENT) | (1L << INCLUDE))) != 0)) {
				{
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(58);
					dcl();
					}
					break;
				case 2:
					{
					setState(59);
					stmt();
					}
					break;
				case 3:
					{
					setState(60);
					func();
					}
					break;
				case 4:
					{
					setState(61);
					include();
					}
					break;
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
			setState(69);
			match(TYPE);
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(70);
				match(ID);
				}
				break;
			case 2:
				{
				setState(71);
				assign();
				}
				break;
			case 3:
				{
				setState(72);
				array_dcl();
				}
				break;
			}
			setState(75);
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
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(77);
				match(ID);
				}
				break;
			case 2:
				{
				setState(78);
				array_access();
				}
				break;
			}
			setState(81);
			match(ASSIGN_OP);
			setState(82);
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
			setState(84);
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
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(86);
				cond_expr();
				}
				break;
			case 2:
				{
				setState(87);
				interval();
				}
				break;
			case 3:
				{
				setState(88);
				in_array();
				}
				break;
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(91);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(92);
					cond_expr();
					}
					break;
				case 2:
					{
					setState(93);
					interval();
					}
					break;
				case 3:
					{
					setState(94);
					in_array();
					}
					break;
				}
				}
				}
				setState(101);
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
		enterRule(_localctx, 10, RULE_interval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			value_expr();
			setState(103);
			match(BETWEEN);
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==LEFT_BRACKET || _la==RIGHT_BRACKET) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(105);
			value_expr();
			setState(106);
			match(SEMICOLON);
			setState(107);
			value_expr();
			setState(108);
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
		enterRule(_localctx, 12, RULE_in_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			value_expr();
			setState(111);
			match(IN);
			setState(112);
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
		enterRule(_localctx, 14, RULE_cond_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			arithm_expr();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMP_OP) {
				{
				setState(115);
				match(COMP_OP);
				setState(116);
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
		enterRule(_localctx, 16, RULE_arithm_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			term();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(120);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(121);
				term();
				}
				}
				setState(126);
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
		enterRule(_localctx, 18, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			factor();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVISION) | (1L << MODULO))) != 0)) {
				{
				{
				setState(128);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVISION) | (1L << MODULO))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				factor();
				}
				}
				setState(134);
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
		enterRule(_localctx, 20, RULE_factor);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				value_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(136);
					match(MINUS);
					}
				}

				setState(139);
				match(LEFT_PAREN);
				setState(140);
				expr();
				setState(141);
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
		enterRule(_localctx, 22, RULE_value_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(145);
				match(MINUS);
				}
			}

			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(148);
				match(ID);
				}
				break;
			case 2:
				{
				setState(149);
				val();
				}
				break;
			case 3:
				{
				setState(150);
				func_call();
				}
				break;
			case 4:
				{
				setState(151);
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
		enterRule(_localctx, 24, RULE_array_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ARRAY);
			setState(155);
			match(ID);
			setState(156);
			match(ASSIGN_OP);
			setState(157);
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
		enterRule(_localctx, 26, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(LEFT_BRACKET);
			setState(160);
			expr();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161);
				match(COMMA);
				setState(162);
				expr();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
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
		enterRule(_localctx, 28, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ID);
			setState(171);
			match(LEFT_BRACKET);
			setState(172);
			expr();
			setState(173);
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
		enterRule(_localctx, 30, RULE_stmt);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				assign();
				setState(176);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				print();
				setState(179);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				expr();
				setState(182);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
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
		enterRule(_localctx, 32, RULE_iterative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(WHILE);
			setState(190);
			match(LEFT_PAREN);
			setState(191);
			logical_expr();
			setState(192);
			match(RIGHT_PAREN);
			setState(193);
			match(REPEAT);
			setState(194);
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
		enterRule(_localctx, 34, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IF);
			setState(197);
			match(LEFT_PAREN);
			setState(198);
			logical_expr();
			setState(199);
			match(RIGHT_PAREN);
			setState(200);
			blk();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(201);
				match(ELSE);
				setState(202);
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
		enterRule(_localctx, 36, RULE_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(LEFT_BRACE);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << TYPE) | (1L << RETURN) | (1L << PRINT) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID) | (1L << LINE_COMMENT))) != 0)) {
				{
				setState(209);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(206);
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
					setState(207);
					stmt();
					}
					break;
				case RETURN:
					{
					setState(208);
					return_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214);
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
		enterRule(_localctx, 38, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(PRINT);
			setState(217);
			match(LEFT_PAREN);
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HIGH:
			case LOW:
			case NUMBER:
			case BOOLEAN_LITERAL:
			case PIN_LITERAL:
			case CHAR_LITERAL:
				{
				setState(218);
				val();
				}
				break;
			case STRING_LITERAL:
				{
				setState(219);
				match(STRING_LITERAL);
				}
				break;
			case ID:
				{
				setState(220);
				match(ID);
				}
				break;
			case PLUS:
			case RIGHT_PAREN:
				break;
			default:
				break;
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(223);
				match(PLUS);
				setState(227);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HIGH:
				case LOW:
				case NUMBER:
				case BOOLEAN_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
					{
					setState(224);
					val();
					}
					break;
				case STRING_LITERAL:
					{
					setState(225);
					match(STRING_LITERAL);
					}
					break;
				case ID:
					{
					setState(226);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
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
		enterRule(_localctx, 40, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			return_type();
			setState(237);
			match(ID);
			setState(238);
			match(LEFT_PAREN);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(239);
				param();
				}
			}

			setState(242);
			match(RIGHT_PAREN);
			setState(243);
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
		enterRule(_localctx, 42, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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
		enterRule(_localctx, 44, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(TYPE);
			setState(248);
			match(ID);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(249);
				match(COMMA);
				setState(250);
				match(TYPE);
				setState(251);
				match(ID);
				}
				}
				setState(256);
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
		enterRule(_localctx, 46, RULE_return_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(RETURN);
			setState(258);
			expr();
			setState(259);
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
		enterRule(_localctx, 48, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(261);
				match(ID);
				}
				break;
			case 2:
				{
				setState(262);
				match(FUNCID);
				}
				break;
			case 3:
				{
				setState(263);
				array_func();
				}
				break;
			}
			setState(266);
			match(LEFT_PAREN);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << HIGH) | (1L << LOW) | (1L << NUMBER) | (1L << BOOLEAN_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID))) != 0)) {
				{
				setState(267);
				expr();
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(268);
					match(COMMA);
					setState(269);
					expr();
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(277);
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
		enterRule(_localctx, 50, RULE_array_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			array_access();
			setState(280);
			match(DOT);
			setState(281);
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
		enterRule(_localctx, 52, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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
		enterRule(_localctx, 54, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		enterRule(_localctx, 56, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(INCLUDE);
			setState(288);
			match(HEADER);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0125\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\7\2"+
		"A\n\2\f\2\16\2D\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\4\3\4"+
		"\5\4R\n\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6\\\n\6\3\6\3\6\3\6\3\6\5"+
		"\6b\n\6\7\6d\n\6\f\6\16\6g\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\5\tx\n\t\3\n\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13"+
		"\n\3\13\3\13\3\13\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\f\3\f\5\f\u008c"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u0092\n\f\3\r\5\r\u0095\n\r\3\r\3\r\3\r\3\r\5"+
		"\r\u009b\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u00a6\n"+
		"\17\f\17\16\17\u00a9\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00be\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00ce\n\23\3\24\3\24\3\24\3\24\7\24\u00d4\n\24\f\24\16\24\u00d7\13\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u00e0\n\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00e6\n\25\7\25\u00e8\n\25\f\25\16\25\u00eb\13\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\5\26\u00f3\n\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u00ff\n\30\f\30\16\30\u0102\13\30\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\5\32\u010b\n\32\3\32\3\32\3\32\3\32\7\32\u0111\n\32\f"+
		"\32\16\32\u0114\13\32\5\32\u0116\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\b\3\2\b\t\3\2\24\25\3\2\13\f"+
		"\4\2\r\16\21\21\3\2\37 \4\2$%(+\2\u0132\2B\3\2\2\2\4G\3\2\2\2\6Q\3\2\2"+
		"\2\bV\3\2\2\2\n[\3\2\2\2\fh\3\2\2\2\16p\3\2\2\2\20t\3\2\2\2\22y\3\2\2"+
		"\2\24\u0081\3\2\2\2\26\u0091\3\2\2\2\30\u0094\3\2\2\2\32\u009c\3\2\2\2"+
		"\34\u00a1\3\2\2\2\36\u00ac\3\2\2\2 \u00bd\3\2\2\2\"\u00bf\3\2\2\2$\u00c6"+
		"\3\2\2\2&\u00cf\3\2\2\2(\u00da\3\2\2\2*\u00ee\3\2\2\2,\u00f7\3\2\2\2."+
		"\u00f9\3\2\2\2\60\u0103\3\2\2\2\62\u010a\3\2\2\2\64\u0119\3\2\2\2\66\u011d"+
		"\3\2\2\28\u011f\3\2\2\2:\u0121\3\2\2\2<A\5\4\3\2=A\5 \21\2>A\5*\26\2?"+
		"A\5:\36\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2"+
		"BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7\2\2\3F\3\3\2\2\2GK\7 \2\2HL\7-\2\2"+
		"IL\5\6\4\2JL\5\32\16\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2LM\3\2\2\2MN\7\30"+
		"\2\2N\5\3\2\2\2OR\7-\2\2PR\5\36\20\2QO\3\2\2\2QP\3\2\2\2RS\3\2\2\2ST\7"+
		"\n\2\2TU\5\b\5\2U\7\3\2\2\2VW\5\n\6\2W\t\3\2\2\2X\\\5\20\t\2Y\\\5\f\7"+
		"\2Z\\\5\16\b\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\e\3\2\2\2]a\t\2\2\2^b\5"+
		"\20\t\2_b\5\f\7\2`b\5\16\b\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2bd\3\2\2\2c"+
		"]\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\13\3\2\2\2ge\3\2\2\2hi\5\30\r"+
		"\2ij\7&\2\2jk\t\3\2\2kl\5\30\r\2lm\7\30\2\2mn\5\30\r\2no\t\3\2\2o\r\3"+
		"\2\2\2pq\5\30\r\2qr\7\'\2\2rs\7-\2\2s\17\3\2\2\2tw\5\22\n\2uv\7\3\2\2"+
		"vx\5\22\n\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2\2y~\5\24\13\2z{\t\4\2\2{}\5"+
		"\24\13\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\23\3\2\2"+
		"\2\u0080~\3\2\2\2\u0081\u0086\5\26\f\2\u0082\u0083\t\5\2\2\u0083\u0085"+
		"\5\26\f\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0092"+
		"\5\30\r\2\u008a\u008c\7\f\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u008e\7\22\2\2\u008e\u008f\5\b\5\2\u008f\u0090"+
		"\7\23\2\2\u0090\u0092\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u008b\3\2\2\2"+
		"\u0092\27\3\2\2\2\u0093\u0095\7\f\2\2\u0094\u0093\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u009a\3\2\2\2\u0096\u009b\7-\2\2\u0097\u009b\5\66\34\2"+
		"\u0098\u009b\5\62\32\2\u0099\u009b\5\36\20\2\u009a\u0096\3\2\2\2\u009a"+
		"\u0097\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\31\3\2\2"+
		"\2\u009c\u009d\7!\2\2\u009d\u009e\7-\2\2\u009e\u009f\7\n\2\2\u009f\u00a0"+
		"\5\34\17\2\u00a0\33\3\2\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a7\5\b\5\2\u00a3"+
		"\u00a4\7\36\2\2\u00a4\u00a6\5\b\5\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3"+
		"\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u00ab\7\25\2\2\u00ab\35\3\2\2\2\u00ac\u00ad\7-\2"+
		"\2\u00ad\u00ae\7\24\2\2\u00ae\u00af\5\b\5\2\u00af\u00b0\7\25\2\2\u00b0"+
		"\37\3\2\2\2\u00b1\u00b2\5\6\4\2\u00b2\u00b3\7\30\2\2\u00b3\u00be\3\2\2"+
		"\2\u00b4\u00b5\5(\25\2\u00b5\u00b6\7\30\2\2\u00b6\u00be\3\2\2\2\u00b7"+
		"\u00b8\5\b\5\2\u00b8\u00b9\7\30\2\2\u00b9\u00be\3\2\2\2\u00ba\u00be\5"+
		"$\23\2\u00bb\u00be\5\"\22\2\u00bc\u00be\58\35\2\u00bd\u00b1\3\2\2\2\u00bd"+
		"\u00b4\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00bc\3\2\2\2\u00be!\3\2\2\2\u00bf\u00c0\7\34\2\2\u00c0\u00c1"+
		"\7\22\2\2\u00c1\u00c2\5\n\6\2\u00c2\u00c3\7\23\2\2\u00c3\u00c4\7\35\2"+
		"\2\u00c4\u00c5\5&\24\2\u00c5#\3\2\2\2\u00c6\u00c7\7\32\2\2\u00c7\u00c8"+
		"\7\22\2\2\u00c8\u00c9\5\n\6\2\u00c9\u00ca\7\23\2\2\u00ca\u00cd\5&\24\2"+
		"\u00cb\u00cc\7\33\2\2\u00cc\u00ce\5&\24\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce%\3\2\2\2\u00cf\u00d5\7\26\2\2\u00d0\u00d4\5\4\3\2\u00d1"+
		"\u00d4\5 \21\2\u00d2\u00d4\5\60\31\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3"+
		"\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7\27"+
		"\2\2\u00d9\'\3\2\2\2\u00da\u00db\7#\2\2\u00db\u00df\7\22\2\2\u00dc\u00e0"+
		"\5\66\34\2\u00dd\u00e0\7,\2\2\u00de\u00e0\7-\2\2\u00df\u00dc\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e9\3\2"+
		"\2\2\u00e1\u00e5\7\13\2\2\u00e2\u00e6\5\66\34\2\u00e3\u00e6\7,\2\2\u00e4"+
		"\u00e6\7-\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\7\23\2\2\u00ed)\3\2\2\2\u00ee\u00ef\5,\27\2\u00ef\u00f0"+
		"\7-\2\2\u00f0\u00f2\7\22\2\2\u00f1\u00f3\5.\30\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\23\2\2\u00f5\u00f6\5"+
		"&\24\2\u00f6+\3\2\2\2\u00f7\u00f8\t\6\2\2\u00f8-\3\2\2\2\u00f9\u00fa\7"+
		" \2\2\u00fa\u0100\7-\2\2\u00fb\u00fc\7\36\2\2\u00fc\u00fd\7 \2\2\u00fd"+
		"\u00ff\7-\2\2\u00fe\u00fb\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101/\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104"+
		"\7\"\2\2\u0104\u0105\5\b\5\2\u0105\u0106\7\30\2\2\u0106\61\3\2\2\2\u0107"+
		"\u010b\7-\2\2\u0108\u010b\7.\2\2\u0109\u010b\5\64\33\2\u010a\u0107\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u0115\7\22\2\2\u010d\u0112\5\b\5\2\u010e\u010f\7\36\2\2\u010f\u0111\5"+
		"\b\5\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u010d\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\7\23\2\2\u0118"+
		"\63\3\2\2\2\u0119\u011a\5\36\20\2\u011a\u011b\7\31\2\2\u011b\u011c\7-"+
		"\2\2\u011c\65\3\2\2\2\u011d\u011e\t\7\2\2\u011e\67\3\2\2\2\u011f\u0120"+
		"\7\61\2\2\u01209\3\2\2\2\u0121\u0122\7\62\2\2\u0122\u0123\7\63\2\2\u0123"+
		";\3\2\2\2\35@BKQ[aew~\u0086\u008b\u0091\u0094\u009a\u00a7\u00bd\u00cd"+
		"\u00d3\u00d5\u00df\u00e5\u00e9\u00f2\u0100\u010a\u0112\u0115";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}