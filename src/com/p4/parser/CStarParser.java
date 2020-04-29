// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
package com.p4.parser;
import com.p4.parser.visitors.CStarVisitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		PIN_LITERAL=33, CHAR_LITERAL=34, ID=35, FUNCID=36, WHITESPACE=37, Newline=38;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_assign = 2, RULE_expr = 3, RULE_logical_expr = 4, 
		RULE_cond_expr = 5, RULE_arithm_expr = 6, RULE_term = 7, RULE_factor = 8, 
		RULE_array_dcl = 9, RULE_array_expr = 10, RULE_array_assign = 11, RULE_array_access = 12,
		RULE_func = 13, RULE_return_type = 14, RULE_param = 15, RULE_blk = 16,
		RULE_return_exp = 17, RULE_func_call = 18, RULE_stmt = 19, RULE_iterative = 20,
		RULE_selection = 21, RULE_val = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "assign", "expr", "logical_expr", "cond_expr", "arithm_expr", 
			"term", "factor", "array_dcl", "array_expr", "array_assign", "array_access",
			"func", "return_type", "param", "blk", "return_exp", "func_call", "stmt",
			"iterative", "selection", "val"
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
			"CHAR_LITERAL", "ID", "FUNCID", "WHITESPACE", "Newline"
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
			if ( visitor instanceof CStarVisitor) return ((CStarVisitor<? extends T>)visitor).visitProg(this);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << VOID) | (1L << TYPE) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID))) != 0)) {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					dcl();
					}
					break;
				case 2:
					{
					setState(47);
					func();
					}
					break;
				case 3:
					{
					setState(48);
					stmt();
					}
					break;
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
			setState(56);
			match(TYPE);
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(57);
				match(ID);
				}
				break;
			case 2:
				{
				setState(58);
				assign();
				}
				break;
			case 3:
				{
				setState(59);
				array_dcl();
				}
				break;
			}
			setState(62);
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
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(64);
				match(ID);
				}
				break;
			case 2:
				{
				setState(65);
				array_access();
				}
				break;
			}
			setState(68);
			match(ASSIGN_OP);
			setState(69);
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
			setState(71);
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
			setState(73);
			cond_expr();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				cond_expr();
				}
				}
				setState(80);
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
		enterRule(_localctx, 10, RULE_cond_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			arithm_expr();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMP_OP) {
				{
				setState(82);
				match(COMP_OP);
				setState(83);
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
		enterRule(_localctx, 12, RULE_arithm_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			term();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(87);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				term();
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
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			factor();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVISION) {
				{
				{
				setState(95);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIVISION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(96);
				factor();
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

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(CStarParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CStarParser.RIGHT_PAREN, 0); }
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(102);
				match(MINUS);
				}
			}

			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(105);
				match(ID);
				}
				break;
			case 2:
				{
				setState(106);
				val();
				}
				break;
			case 3:
				{
				setState(107);
				match(LEFT_PAREN);
				setState(108);
				expr();
				setState(109);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				{
				setState(111);
				func_call();
				}
				break;
			case 5:
				{
				setState(112);
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
		enterRule(_localctx, 18, RULE_array_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ARRAY);
			setState(116);
			match(ID);
			setState(117);
			match(ASSIGN_OP);
			setState(118);
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
		enterRule(_localctx, 20, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LEFT_BRACKET);
			setState(121);
			expr();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(122);
				match(COMMA);
				setState(123);
				expr();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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

	public static class Array_assignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CStarParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CStarParser.LEFT_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CStarParser.RIGHT_BRACKET, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(CStarParser.ASSIGN_OP, 0); }
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
		enterRule(_localctx, 22, RULE_array_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(ID);
			setState(132);
			match(LEFT_BRACKET);
			setState(133);
			expr();
			setState(134);
			match(RIGHT_BRACKET);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(135);
				match(ASSIGN_OP);
				setState(136);
				expr();
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
		enterRule(_localctx, 24, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ID);
			setState(140);
			match(LEFT_BRACKET);
			setState(141);
			expr();
			setState(142);
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
		enterRule(_localctx, 26, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			return_type();
			setState(145);
			match(ID);
			setState(146);
			match(LEFT_PAREN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(147);
				param();
				}
			}

			setState(150);
			match(RIGHT_PAREN);
			setState(151);
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
		enterRule(_localctx, 28, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
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
		enterRule(_localctx, 30, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(TYPE);
			setState(156);
			match(ID);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(157);
				match(COMMA);
				setState(158);
				match(TYPE);
				setState(159);
				match(ID);
				}
				}
				setState(164);
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
		enterRule(_localctx, 32, RULE_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(LEFT_BRACE);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << TYPE) | (1L << RETURN) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID))) != 0)) {
				{
				setState(169);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(166);
					dcl();
					}
					break;
				case MINUS:
				case LEFT_PAREN:
				case IF:
				case WHILE:
				case INT_LITERAL:
				case LONG_LITERAL:
				case FLOAT_LITERAL:
				case PIN_LITERAL:
				case CHAR_LITERAL:
				case ID:
				case FUNCID:
					{
					setState(167);
					stmt();
					}
					break;
				case RETURN:
					{
					setState(168);
					return_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
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
		enterRule(_localctx, 34, RULE_return_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(RETURN);
			setState(177);
			expr();
			setState(178);
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
		enterRule(_localctx, 36, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==FUNCID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(181);
			match(LEFT_PAREN);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << LEFT_PAREN) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << PIN_LITERAL) | (1L << CHAR_LITERAL) | (1L << ID) | (1L << FUNCID))) != 0)) {
				{
				setState(182);
				expr();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(183);
					match(COMMA);
					setState(184);
					expr();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(192);
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CStarParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public IterativeContext iterative() {
			return getRuleContext(IterativeContext.class,0);
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
		enterRule(_localctx, 38, RULE_stmt);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				assign();
				setState(195);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				expr();
				setState(198);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				selection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				iterative();
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
		enterRule(_localctx, 40, RULE_iterative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(WHILE);
			setState(205);
			match(LEFT_PAREN);
			setState(206);
			logical_expr();
			setState(207);
			match(RIGHT_PAREN);
			setState(208);
			match(REPEAT);
			setState(209);
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
		enterRule(_localctx, 42, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(IF);
			setState(212);
			match(LEFT_PAREN);
			setState(213);
			logical_expr();
			setState(214);
			match(RIGHT_PAREN);
			setState(215);
			blk();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(216);
				match(ELSE);
				setState(217);
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
		enterRule(_localctx, 44, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3?\n\3\3\3\3"+
		"\3\3\4\3\4\5\4E\n\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6O\n\6\f\6\16\6"+
		"R\13\6\3\7\3\7\3\7\5\7W\n\7\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\t\3"+
		"\t\3\t\7\td\n\t\f\t\16\tg\13\t\3\n\5\nj\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\nt\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\177\n\f\f"+
		"\f\16\f\u0082\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008c\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0097\n\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a3\n\21\f\21\16\21\u00a6\13"+
		"\21\3\22\3\22\3\22\3\22\7\22\u00ac\n\22\f\22\16\22\u00af\13\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u00bc\n\24\f\24"+
		"\16\24\u00bf\13\24\5\24\u00c1\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00cd\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00dd\n\27\3\30\3\30\3\30\2\2\31\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\b\3\2\b\t\3\2\13\f\3"+
		"\2\r\16\3\2\34\35\3\2%&\3\2 $\2\u00e5\2\65\3\2\2\2\4:\3\2\2\2\6D\3\2\2"+
		"\2\bI\3\2\2\2\nK\3\2\2\2\fS\3\2\2\2\16X\3\2\2\2\20`\3\2\2\2\22i\3\2\2"+
		"\2\24u\3\2\2\2\26z\3\2\2\2\30\u0085\3\2\2\2\32\u008d\3\2\2\2\34\u0092"+
		"\3\2\2\2\36\u009b\3\2\2\2 \u009d\3\2\2\2\"\u00a7\3\2\2\2$\u00b2\3\2\2"+
		"\2&\u00b6\3\2\2\2(\u00cc\3\2\2\2*\u00ce\3\2\2\2,\u00d5\3\2\2\2.\u00de"+
		"\3\2\2\2\60\64\5\4\3\2\61\64\5\34\17\2\62\64\5(\25\2\63\60\3\2\2\2\63"+
		"\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"8\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:>\7\35\2\2;?\7%\2\2<?\5\6"+
		"\4\2=?\5\24\13\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?@\3\2\2\2@A\7\25\2\2A\5"+
		"\3\2\2\2BE\7%\2\2CE\5\32\16\2DB\3\2\2\2DC\3\2\2\2EF\3\2\2\2FG\7\n\2\2"+
		"GH\5\b\5\2H\7\3\2\2\2IJ\5\n\6\2J\t\3\2\2\2KP\5\f\7\2LM\t\2\2\2MO\5\f\7"+
		"\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2SV\5\16"+
		"\b\2TU\7\3\2\2UW\5\16\b\2VT\3\2\2\2VW\3\2\2\2W\r\3\2\2\2X]\5\20\t\2YZ"+
		"\t\3\2\2Z\\\5\20\t\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\17\3\2"+
		"\2\2_]\3\2\2\2`e\5\22\n\2ab\t\4\2\2bd\5\22\n\2ca\3\2\2\2dg\3\2\2\2ec\3"+
		"\2\2\2ef\3\2\2\2f\21\3\2\2\2ge\3\2\2\2hj\7\f\2\2ih\3\2\2\2ij\3\2\2\2j"+
		"s\3\2\2\2kt\7%\2\2lt\5.\30\2mn\7\17\2\2no\5\b\5\2op\7\20\2\2pt\3\2\2\2"+
		"qt\5&\24\2rt\5\32\16\2sk\3\2\2\2sl\3\2\2\2sm\3\2\2\2sq\3\2\2\2sr\3\2\2"+
		"\2t\23\3\2\2\2uv\7\36\2\2vw\7%\2\2wx\7\n\2\2xy\5\26\f\2y\25\3\2\2\2z{"+
		"\7\21\2\2{\u0080\5\b\5\2|}\7\33\2\2}\177\5\b\5\2~|\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0084\7\22\2\2\u0084\27\3\2\2\2\u0085\u0086\7%\2\2\u0086"+
		"\u0087\7\21\2\2\u0087\u0088\5\b\5\2\u0088\u008b\7\22\2\2\u0089\u008a\7"+
		"\n\2\2\u008a\u008c\5\b\5\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\31\3\2\2\2\u008d\u008e\7%\2\2\u008e\u008f\7\21\2\2\u008f\u0090\5\b\5"+
		"\2\u0090\u0091\7\22\2\2\u0091\33\3\2\2\2\u0092\u0093\5\36\20\2\u0093\u0094"+
		"\7%\2\2\u0094\u0096\7\17\2\2\u0095\u0097\5 \21\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\20\2\2\u0099\u009a\5"+
		"\"\22\2\u009a\35\3\2\2\2\u009b\u009c\t\5\2\2\u009c\37\3\2\2\2\u009d\u009e"+
		"\7\35\2\2\u009e\u00a4\7%\2\2\u009f\u00a0\7\33\2\2\u00a0\u00a1\7\35\2\2"+
		"\u00a1\u00a3\7%\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5!\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00ad\7\23\2\2\u00a8\u00ac\5\4\3\2\u00a9\u00ac\5(\25\2\u00aa\u00ac\5"+
		"$\23\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\24\2\2\u00b1#\3\2\2\2\u00b2\u00b3"+
		"\7\37\2\2\u00b3\u00b4\5\b\5\2\u00b4\u00b5\7\25\2\2\u00b5%\3\2\2\2\u00b6"+
		"\u00b7\t\6\2\2\u00b7\u00c0\7\17\2\2\u00b8\u00bd\5\b\5\2\u00b9\u00ba\7"+
		"\33\2\2\u00ba\u00bc\5\b\5\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\7\20\2\2\u00c3\'\3\2\2\2\u00c4\u00c5\5\6\4\2\u00c5\u00c6\7\25\2"+
		"\2\u00c6\u00cd\3\2\2\2\u00c7\u00c8\5\b\5\2\u00c8\u00c9\7\25\2\2\u00c9"+
		"\u00cd\3\2\2\2\u00ca\u00cd\5,\27\2\u00cb\u00cd\5*\26\2\u00cc\u00c4\3\2"+
		"\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		")\3\2\2\2\u00ce\u00cf\7\31\2\2\u00cf\u00d0\7\17\2\2\u00d0\u00d1\5\n\6"+
		"\2\u00d1\u00d2\7\20\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d4\5\"\22\2\u00d4"+
		"+\3\2\2\2\u00d5\u00d6\7\27\2\2\u00d6\u00d7\7\17\2\2\u00d7\u00d8\5\n\6"+
		"\2\u00d8\u00d9\7\20\2\2\u00d9\u00dc\5\"\22\2\u00da\u00db\7\30\2\2\u00db"+
		"\u00dd\5\"\22\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd-\3\2\2\2"+
		"\u00de\u00df\t\7\2\2\u00df/\3\2\2\2\26\63\65>DPV]eis\u0080\u008b\u0096"+
		"\u00a4\u00ab\u00ad\u00bd\u00c0\u00cc\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}