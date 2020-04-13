// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
package com.p4.parser;
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
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LEFT_PAREN=13, RIGHT_PAREN=14, 
		LEFT_BRACKET=15, RIGHT_BRACKET=16, LEFT_BRACE=17, RIGHT_BRACE=18, SEMICOLON=19, 
		DOT=20, IF=21, ELSE=22, WHILE=23, REPEAT=24, COMMA=25, VOID=26, TYPE=27, 
		ARRAY=28, RETURN=29, INT_LITERAL=30, LONG_LITERAL=31, FLOAT_LITERAL=32, 
		PIN_LITERAL=33, CHAR_LITERAL=34, ID=35, WHITESPACE=36, Newline=37;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_assign = 2, RULE_expr = 3, RULE_cond_expr = 4, 
		RULE_arithm_expr = 5, RULE_term = 6, RULE_factor = 7, RULE_array_assign = 8, 
		RULE_array_expr = 9, RULE_array_value = 10, RULE_func = 11, RULE_return_type = 12, 
		RULE_param = 13, RULE_blk = 14, RULE_return_exp = 15, RULE_func_call = 16, 
		RULE_stmt = 17, RULE_iterative = 18, RULE_selection = 19, RULE_val = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "assign", "expr", "cond_expr", "arithm_expr", "term", 
			"factor", "array_assign", "array_expr", "array_value", "func", "return_type", 
			"param", "blk", "return_exp", "func_call", "stmt", "iterative", "selection", 
			"val"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"';'", "'.'", "'if'", "'else'", "'while'", "'repeat'", "','", "'void'", 
			null, "'array'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", 
			"DOT", "IF", "ELSE", "WHILE", "REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", 
			"RETURN", "INT_LITERAL", "LONG_LITERAL", "FLOAT_LITERAL", "PIN_LITERAL", 
			"CHAR_LITERAL", "ID", "WHITESPACE", "Newline"
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
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << VOID) | (1L << TYPE) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(45);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					dcl();
					}
					break;
				case 2:
					{
					setState(43);
					func();
					}
					break;
				case 3:
					{
					setState(44);
					stmt();
					}
					break;
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
		public Array_assignContext array_assign() {
			return getRuleContext(Array_assignContext.class,0);
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
			setState(52);
			match(TYPE);
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(53);
				match(ID);
				}
				break;
			case 2:
				{
				setState(54);
				assign();
				}
				break;
			case 3:
				{
				setState(55);
				array_assign();
				}
				break;
			}
			setState(58);
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
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(60);
			match(ID);
			setState(61);
			match(ASSIGN_OP);
			setState(62);
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
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
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
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cond_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				func_call();
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

	public static class Cond_exprContext extends ParserRuleContext {
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public TerminalNode COMP_OP() { return getToken(CStarParser.COMP_OP, 0); }
		public List<Cond_exprContext> cond_expr() {
			return getRuleContexts(Cond_exprContext.class);
		}
		public Cond_exprContext cond_expr(int i) {
			return getRuleContext(Cond_exprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CStarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CStarParser.OR, i);
		}
		public List<TerminalNode> AND() { return getTokens(CStarParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CStarParser.AND, i);
		}
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
		enterRule(_localctx, 8, RULE_cond_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			arithm_expr();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMP_OP) {
				{
				setState(69);
				match(COMP_OP);
				setState(70);
				arithm_expr();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(74);
					cond_expr();
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 10, RULE_arithm_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			term();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(81);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(82);
				term();
				}
				}
				setState(87);
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
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			factor();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVISION) {
				{
				{
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIVISION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				factor();
				}
				}
				setState(95);
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
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Array_valueContext array_value() {
			return getRuleContext(Array_valueContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
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
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				val();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				array_value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(LEFT_PAREN);
				setState(100);
				expr();
				setState(101);
				match(RIGHT_PAREN);
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

	public static class Array_assignContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(CStarParser.ARRAY, 0); }
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public Array_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_assignContext array_assign() throws RecognitionException {
		Array_assignContext _localctx = new Array_assignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_array_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ARRAY);
			setState(106);
			match(ID);
			setState(107);
			match(ASSIGN_OP);
			setState(108);
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
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
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
		enterRule(_localctx, 18, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LEFT_BRACKET);
			setState(111);
			val();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(113);
				val();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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

	public static class Array_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CStarParser.LEFT_BRACKET, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CStarParser.RIGHT_BRACKET, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
		public Array_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).enterArray_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStarListener ) ((CStarListener)listener).exitArray_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CStarVisitor ) return ((CStarVisitor<? extends T>)visitor).visitArray_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_valueContext array_value() throws RecognitionException {
		Array_valueContext _localctx = new Array_valueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_array_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(ID);
			setState(122);
			match(LEFT_BRACKET);
			setState(123);
			val();
			setState(124);
			match(RIGHT_BRACKET);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(125);
				match(ASSIGN_OP);
				setState(126);
				val();
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
		enterRule(_localctx, 22, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			return_type();
			setState(130);
			match(ID);
			setState(131);
			match(LEFT_PAREN);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(132);
				param();
				}
			}

			setState(135);
			match(RIGHT_PAREN);
			setState(136);
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
		enterRule(_localctx, 24, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 26, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(TYPE);
			setState(141);
			match(ID);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				match(TYPE);
				setState(144);
				match(ID);
				}
				}
				setState(149);
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
		enterRule(_localctx, 28, RULE_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(LEFT_BRACE);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << TYPE) | (1L << RETURN) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(154);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(151);
					dcl();
					}
					break;
				case LEFT_PAREN:
				case IF:
				case WHILE:
				case INT_LITERAL:
				case LONG_LITERAL:
				case FLOAT_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
				case ID:
					{
					setState(152);
					stmt();
					}
					break;
				case RETURN:
					{
					setState(153);
					return_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
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
		enterRule(_localctx, 30, RULE_return_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(RETURN);
			setState(162);
			expr();
			setState(163);
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
		public List<TerminalNode> ID() { return getTokens(CStarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CStarParser.ID, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public TerminalNode DOT() { return getToken(CStarParser.DOT, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
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
		enterRule(_localctx, 32, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(165);
				match(ID);
				setState(166);
				match(DOT);
				}
				break;
			}
			setState(169);
			match(ID);
			setState(170);
			match(LEFT_PAREN);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(173);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(171);
					match(ID);
					}
					break;
				case INT_LITERAL:
				case LONG_LITERAL:
				case FLOAT_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
					{
					setState(172);
					val();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(175);
					match(COMMA);
					setState(178);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(176);
						match(ID);
						}
						break;
					case INT_LITERAL:
					case LONG_LITERAL:
					case FLOAT_LITERAL:
					case PIN_LITERAL:
					case CHAR_LITERAL:
						{
						setState(177);
						val();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(187);
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

	public static class StmtContext extends ParserRuleContext {
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CStarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CStarParser.SEMICOLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public List<IterativeContext> iterative() {
			return getRuleContexts(IterativeContext.class);
		}
		public IterativeContext iterative(int i) {
			return getRuleContext(IterativeContext.class,i);
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
		enterRule(_localctx, 34, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(189);
						assign();
						setState(190);
						match(SEMICOLON);
						}
						break;
					case 2:
						{
						setState(192);
						expr();
						setState(193);
						match(SEMICOLON);
						}
						break;
					case 3:
						{
						setState(195);
						selection();
						}
						break;
					case 4:
						{
						setState(196);
						iterative();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(199); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class IterativeContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CStarParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
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
		enterRule(_localctx, 36, RULE_iterative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(WHILE);
			setState(202);
			match(LEFT_PAREN);
			setState(203);
			cond_expr();
			setState(204);
			match(RIGHT_PAREN);
			setState(205);
			match(REPEAT);
			setState(206);
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
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
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
		enterRule(_localctx, 38, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(IF);
			setState(209);
			match(LEFT_PAREN);
			setState(210);
			cond_expr();
			setState(211);
			match(RIGHT_PAREN);
			setState(212);
			blk();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(213);
				match(ELSE);
				setState(214);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(CStarParser.INT_LITERAL, 0); }
		public TerminalNode LONG_LITERAL() { return getToken(CStarParser.LONG_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(CStarParser.FLOAT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(CStarParser.CHAR_LITERAL, 0); }
		public TerminalNode PIN_LITERAL() { return getToken(CStarParser.PIN_LITERAL, 0); }
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
		enterRule(_localctx, 40, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00de\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\7\2\60\n\2\f\2\16"+
		"\2\63\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\5\5E\n\5\3\6\3\6\3\6\5\6J\n\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3"+
		"\7\3\7\3\7\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\3\b\7\b^\n\b\f\b\16\ba\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tj\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\7\13u\n\13\f\13\16\13x\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0082\n\f\3\r\3\r\3\r\3\r\5\r\u0088\n\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u0094\n\17\f\17\16\17\u0097\13\17\3\20\3"+
		"\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\5\22\u00aa\n\22\3\22\3\22\3\22\3\22\5\22\u00b0"+
		"\n\22\3\22\3\22\3\22\5\22\u00b5\n\22\7\22\u00b7\n\22\f\22\16\22\u00ba"+
		"\13\22\5\22\u00bc\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\6\23\u00c8\n\23\r\23\16\23\u00c9\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00da\n\25\3\26\3\26\3\26\2\2"+
		"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\7\3\2\b\t\3\2\13\f"+
		"\3\2\r\16\3\2\34\35\3\2 $\2\u00e6\2\61\3\2\2\2\4\66\3\2\2\2\6>\3\2\2\2"+
		"\bD\3\2\2\2\nF\3\2\2\2\fR\3\2\2\2\16Z\3\2\2\2\20i\3\2\2\2\22k\3\2\2\2"+
		"\24p\3\2\2\2\26{\3\2\2\2\30\u0083\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3"+
		"\2\2\2\36\u0098\3\2\2\2 \u00a3\3\2\2\2\"\u00a9\3\2\2\2$\u00c7\3\2\2\2"+
		"&\u00cb\3\2\2\2(\u00d2\3\2\2\2*\u00db\3\2\2\2,\60\5\4\3\2-\60\5\30\r\2"+
		".\60\5$\23\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\2\2\3\65\3\3\2\2\2\66"+
		":\7\35\2\2\67;\7%\2\28;\5\6\4\29;\5\22\n\2:\67\3\2\2\2:8\3\2\2\2:9\3\2"+
		"\2\2;<\3\2\2\2<=\7\25\2\2=\5\3\2\2\2>?\7%\2\2?@\7\n\2\2@A\5\b\5\2A\7\3"+
		"\2\2\2BE\5\n\6\2CE\5\"\22\2DB\3\2\2\2DC\3\2\2\2E\t\3\2\2\2FI\5\f\7\2G"+
		"H\7\3\2\2HJ\5\f\7\2IG\3\2\2\2IJ\3\2\2\2JO\3\2\2\2KL\t\2\2\2LN\5\n\6\2"+
		"MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\13\3\2\2\2QO\3\2\2\2RW\5\16"+
		"\b\2ST\t\3\2\2TV\5\16\b\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\r\3"+
		"\2\2\2YW\3\2\2\2Z_\5\20\t\2[\\\t\4\2\2\\^\5\20\t\2][\3\2\2\2^a\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`\17\3\2\2\2a_\3\2\2\2bj\7%\2\2cj\5*\26\2dj\5\26\f"+
		"\2ef\7\17\2\2fg\5\b\5\2gh\7\20\2\2hj\3\2\2\2ib\3\2\2\2ic\3\2\2\2id\3\2"+
		"\2\2ie\3\2\2\2j\21\3\2\2\2kl\7\36\2\2lm\7%\2\2mn\7\n\2\2no\5\24\13\2o"+
		"\23\3\2\2\2pq\7\21\2\2qv\5*\26\2rs\7\33\2\2su\5*\26\2tr\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\22\2\2z\25\3\2\2\2{|"+
		"\7%\2\2|}\7\21\2\2}~\5*\26\2~\u0081\7\22\2\2\177\u0080\7\n\2\2\u0080\u0082"+
		"\5*\26\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\27\3\2\2\2\u0083"+
		"\u0084\5\32\16\2\u0084\u0085\7%\2\2\u0085\u0087\7\17\2\2\u0086\u0088\5"+
		"\34\17\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\7\20\2\2\u008a\u008b\5\36\20\2\u008b\31\3\2\2\2\u008c\u008d\t\5"+
		"\2\2\u008d\33\3\2\2\2\u008e\u008f\7\35\2\2\u008f\u0095\7%\2\2\u0090\u0091"+
		"\7\33\2\2\u0091\u0092\7\35\2\2\u0092\u0094\7%\2\2\u0093\u0090\3\2\2\2"+
		"\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\35"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009e\7\23\2\2\u0099\u009d\5\4\3\2"+
		"\u009a\u009d\5$\23\2\u009b\u009d\5 \21\2\u009c\u0099\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\24"+
		"\2\2\u00a2\37\3\2\2\2\u00a3\u00a4\7\37\2\2\u00a4\u00a5\5\b\5\2\u00a5\u00a6"+
		"\7\25\2\2\u00a6!\3\2\2\2\u00a7\u00a8\7%\2\2\u00a8\u00aa\7\26\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7%"+
		"\2\2\u00ac\u00bb\7\17\2\2\u00ad\u00b0\7%\2\2\u00ae\u00b0\5*\26\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b8\3\2\2\2\u00b1\u00b4\7\33"+
		"\2\2\u00b2\u00b5\7%\2\2\u00b3\u00b5\5*\26\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\u00af\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\7\20\2\2\u00be#\3\2\2\2\u00bf\u00c0\5\6\4\2\u00c0\u00c1"+
		"\7\25\2\2\u00c1\u00c8\3\2\2\2\u00c2\u00c3\5\b\5\2\u00c3\u00c4\7\25\2\2"+
		"\u00c4\u00c8\3\2\2\2\u00c5\u00c8\5(\25\2\u00c6\u00c8\5&\24\2\u00c7\u00bf"+
		"\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca%\3\2\2\2"+
		"\u00cb\u00cc\7\31\2\2\u00cc\u00cd\7\17\2\2\u00cd\u00ce\5\n\6\2\u00ce\u00cf"+
		"\7\20\2\2\u00cf\u00d0\7\32\2\2\u00d0\u00d1\5\36\20\2\u00d1\'\3\2\2\2\u00d2"+
		"\u00d3\7\27\2\2\u00d3\u00d4\7\17\2\2\u00d4\u00d5\5\n\6\2\u00d5\u00d6\7"+
		"\20\2\2\u00d6\u00d9\5\36\20\2\u00d7\u00d8\7\30\2\2\u00d8\u00da\5\36\20"+
		"\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da)\3\2\2\2\u00db\u00dc"+
		"\t\6\2\2\u00dc+\3\2\2\2\31/\61:DIOW_iv\u0081\u0087\u0095\u009c\u009e\u00a9"+
		"\u00af\u00b4\u00b8\u00bb\u00c7\u00c9\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}