// Generated from /Users/lenasaid/Desktop/Desktop/OneDrive/Uni/Semester 4/PSS/P4/ANTLR/parser/Lexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ASSIGN_OP=8, 
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LEFT_PAREN=13, RIGHT_PAREN=14, 
		LEFT_BRACKET=15, RIGHT_BRACKET=16, LEFT_BRACE=17, RIGHT_BRACE=18, SEMICOLON=19, 
		IF=20, ELSE=21, WHILE=22, REPEAT=23, COMMA=24, VOID=25, TYPE=26, ARRAY=27, 
		PIN_LITERAL=28, ID=29, INT_LITERAL=30, LONG_LITERAL=31, FLOAT_LITERAL=32, 
		CHAR_LITERAL=33;
	public static final int
		RULE_prog = 0, RULE_dcls = 1, RULE_dcl = 2, RULE_assign = 3, RULE_expr = 4, 
		RULE_cond_expr = 5, RULE_arithm_expr = 6, RULE_term = 7, RULE_factor = 8, 
		RULE_array_assign = 9, RULE_array_expr = 10, RULE_func = 11, RULE_param = 12, 
		RULE_func_call = 13, RULE_blk = 14, RULE_stmt = 15, RULE_selection = 16, 
		RULE_iterative = 17, RULE_val = 18, RULE_array_call = 19, RULE_return_type = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcls", "dcl", "assign", "expr", "cond_expr", "arithm_expr", 
			"term", "factor", "array_assign", "array_expr", "func", "param", "func_call", 
			"blk", "stmt", "selection", "iterative", "val", "array_call", "return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "'if'", "'else'", "'while'", "'repeat'", "','", "'void'", null, 
			"'array'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", 
			"IF", "ELSE", "WHILE", "REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "PIN_LITERAL", 
			"ID", "INT_LITERAL", "LONG_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL"
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
	public String getGrammarFileName() { return "Lexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LexerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LexerParser.EOF, 0); }
		public List<DclsContext> dcls() {
			return getRuleContexts(DclsContext.class);
		}
		public DclsContext dcls(int i) {
			return getRuleContext(DclsContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitProg(this);
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
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==TYPE) {
				{
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					dcls();
					}
					break;
				case 2:
					{
					setState(43);
					func();
					}
					break;
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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

	public static class DclsContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LexerParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LexerParser.SEMICOLON, i);
		}
		public DclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterDcls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitDcls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitDcls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclsContext dcls() throws RecognitionException {
		DclsContext _localctx = new DclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcls);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(51);
					dcl();
					setState(52);
					match(SEMICOLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class DclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LexerParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
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
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dcl);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(TYPE);
				setState(59);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(TYPE);
				setState(63);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(61);
					assign();
					}
					break;
				case ARRAY:
					{
					setState(62);
					array_assign();
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(LexerParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_assignContext array_assign() {
			return getRuleContext(Array_assignContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(ID);
			setState(68);
			match(ASSIGN_OP);
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
			case PIN_LITERAL:
			case ID:
			case INT_LITERAL:
			case LONG_LITERAL:
			case FLOAT_LITERAL:
			case CHAR_LITERAL:
				{
				setState(69);
				expr();
				}
				break;
			case ARRAY:
				{
				setState(70);
				array_assign();
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

	public static class ExprContext extends ParserRuleContext {
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			cond_expr();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode COMP_OP() { return getToken(LexerParser.COMP_OP, 0); }
		public List<Cond_exprContext> cond_expr() {
			return getRuleContexts(Cond_exprContext.class);
		}
		public Cond_exprContext cond_expr(int i) {
			return getRuleContext(Cond_exprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LexerParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LexerParser.OR, i);
		}
		public List<TerminalNode> AND() { return getTokens(LexerParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LexerParser.AND, i);
		}
		public Cond_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterCond_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitCond_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitCond_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_exprContext cond_expr() throws RecognitionException {
		Cond_exprContext _localctx = new Cond_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cond_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			arithm_expr();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMP_OP) {
				{
				setState(76);
				match(COMP_OP);
				setState(77);
				arithm_expr();
				}
			}

			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(81);
					cond_expr();
					}
					} 
				}
				setState(86);
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
		public List<TerminalNode> PLUS() { return getTokens(LexerParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LexerParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LexerParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LexerParser.MINUS, i);
		}
		public Arithm_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterArithm_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitArithm_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitArithm_expr(this);
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
			setState(87);
			term();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				term();
				}
				}
				setState(94);
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
		public List<TerminalNode> MULT() { return getTokens(LexerParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LexerParser.MULT, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(LexerParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(LexerParser.DIVISION, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitTerm(this);
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
			setState(95);
			factor();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVISION) {
				{
				{
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIVISION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				factor();
				}
				}
				setState(102);
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
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Array_callContext array_call() {
			return getRuleContext(Array_callContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(LexerParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LexerParser.RIGHT_PAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_factor);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				val();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				array_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(LEFT_PAREN);
				setState(107);
				expr();
				setState(108);
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
		public TerminalNode ARRAY() { return getToken(LexerParser.ARRAY, 0); }
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(LexerParser.ASSIGN_OP, 0); }
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public Array_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterArray_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitArray_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitArray_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_assignContext array_assign() throws RecognitionException {
		Array_assignContext _localctx = new Array_assignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(ARRAY);
			setState(113);
			match(ID);
			setState(114);
			match(ASSIGN_OP);
			setState(115);
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
		public TerminalNode LEFT_BRACE() { return getToken(LexerParser.LEFT_BRACE, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LexerParser.RIGHT_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LexerParser.COMMA, i);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterArray_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitArray_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitArray_expr(this);
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
			setState(117);
			match(LEFT_BRACE);
			setState(118);
			val();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				val();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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

	public static class FuncContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(LexerParser.LEFT_PAREN, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LexerParser.RIGHT_PAREN, 0); }
		public BlkContext blk() {
			return getRuleContext(BlkContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			return_type();
			setState(129);
			match(ID);
			setState(130);
			match(LEFT_PAREN);
			setState(131);
			param();
			setState(132);
			match(RIGHT_PAREN);
			setState(133);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LexerParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LexerParser.COMMA, i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(TYPE);
			setState(136);
			match(ID);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					param();
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Func_callContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LexerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LexerParser.ID, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(LexerParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(LexerParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LexerParser.COMMA, i);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitFunc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ID);
			setState(145);
			match(LEFT_PAREN);
			setState(146);
			match(ID);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147);
				match(COMMA);
				setState(148);
				match(ID);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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

	public static class BlkContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(LexerParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LexerParser.RIGHT_BRACKET, 0); }
		public List<DclsContext> dcls() {
			return getRuleContexts(DclsContext.class);
		}
		public DclsContext dcls(int i) {
			return getRuleContext(DclsContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterBlk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitBlk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitBlk(this);
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
			setState(156);
			match(LEFT_BRACKET);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << IF) | (1L << WHILE) | (1L << TYPE) | (1L << PIN_LITERAL) | (1L << ID) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(157);
					dcls();
					}
					break;
				case LEFT_PAREN:
				case IF:
				case WHILE:
				case PIN_LITERAL:
				case ID:
				case INT_LITERAL:
				case LONG_LITERAL:
				case FLOAT_LITERAL:
				case CHAR_LITERAL:
					{
					setState(158);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
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
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LexerParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LexerParser.SEMICOLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Func_callContext> func_call() {
			return getRuleContexts(Func_callContext.class);
		}
		public Func_callContext func_call(int i) {
			return getRuleContext(Func_callContext.class,i);
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
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(177);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(166);
						assign();
						setState(167);
						match(SEMICOLON);
						}
						break;
					case 2:
						{
						setState(169);
						expr();
						setState(170);
						match(SEMICOLON);
						}
						break;
					case 3:
						{
						setState(172);
						func_call();
						setState(173);
						match(SEMICOLON);
						}
						break;
					case 4:
						{
						setState(175);
						selection();
						}
						break;
					case 5:
						{
						setState(176);
						iterative();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(179); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LexerParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(LexerParser.LEFT_PAREN, 0); }
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LexerParser.RIGHT_PAREN, 0); }
		public List<BlkContext> blk() {
			return getRuleContexts(BlkContext.class);
		}
		public BlkContext blk(int i) {
			return getRuleContext(BlkContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LexerParser.ELSE, 0); }
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(IF);
			setState(182);
			match(LEFT_PAREN);
			setState(183);
			cond_expr();
			setState(184);
			match(RIGHT_PAREN);
			setState(185);
			blk();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(186);
				match(ELSE);
				setState(187);
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

	public static class IterativeContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LexerParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(LexerParser.LEFT_PAREN, 0); }
		public Cond_exprContext cond_expr() {
			return getRuleContext(Cond_exprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LexerParser.RIGHT_PAREN, 0); }
		public TerminalNode REPEAT() { return getToken(LexerParser.REPEAT, 0); }
		public BlkContext blk() {
			return getRuleContext(BlkContext.class,0);
		}
		public IterativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterIterative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitIterative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitIterative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeContext iterative() throws RecognitionException {
		IterativeContext _localctx = new IterativeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iterative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHILE);
			setState(191);
			match(LEFT_PAREN);
			setState(192);
			cond_expr();
			setState(193);
			match(RIGHT_PAREN);
			setState(194);
			match(REPEAT);
			setState(195);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(LexerParser.INT_LITERAL, 0); }
		public TerminalNode LONG_LITERAL() { return getToken(LexerParser.LONG_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(LexerParser.FLOAT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(LexerParser.CHAR_LITERAL, 0); }
		public TerminalNode PIN_LITERAL() { return getToken(LexerParser.PIN_LITERAL, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIN_LITERAL) | (1L << INT_LITERAL) | (1L << LONG_LITERAL) | (1L << FLOAT_LITERAL) | (1L << CHAR_LITERAL))) != 0)) ) {
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

	public static class Array_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LexerParser.ID, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(LexerParser.LEFT_BRACE, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LexerParser.RIGHT_BRACE, 0); }
		public Array_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterArray_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitArray_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitArray_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_callContext array_call() throws RecognitionException {
		Array_callContext _localctx = new Array_callContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(ID);
			setState(200);
			match(LEFT_BRACE);
			setState(201);
			val();
			setState(202);
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

	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LexerParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(LexerParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LexerListener ) ((LexerListener)listener).exitReturn_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LexerVisitor ) return ((LexerVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\7\2/\n\2\f\2\16\2\62"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\6\39\n\3\r\3\16\3:\3\4\3\4\3\4\3\4\3\4\5\4B"+
		"\n\4\5\4D\n\4\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\7\3\7\3\7\5\7Q\n\7\3"+
		"\7\3\7\7\7U\n\7\f\7\16\7X\13\7\3\b\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\3\t"+
		"\3\t\3\t\7\te\n\t\f\t\16\th\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nq\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f|\n\f\f\f\16\f\177\13\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u008e\n\16"+
		"\f\16\16\16\u0091\13\16\3\17\3\17\3\17\3\17\3\17\7\17\u0098\n\17\f\17"+
		"\16\17\u009b\13\17\3\17\3\17\3\20\3\20\3\20\7\20\u00a2\n\20\f\20\16\20"+
		"\u00a5\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\6\21\u00b4\n\21\r\21\16\21\u00b5\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00bf\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*\2\7\3\2\b\t\3\2\13\f\3\2\r\16\4\2\36\36 #\3\2\33\34"+
		"\2\u00d3\2\60\3\2\2\2\48\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nK\3\2\2\2\fM\3"+
		"\2\2\2\16Y\3\2\2\2\20a\3\2\2\2\22p\3\2\2\2\24r\3\2\2\2\26w\3\2\2\2\30"+
		"\u0082\3\2\2\2\32\u0089\3\2\2\2\34\u0092\3\2\2\2\36\u009e\3\2\2\2 \u00b3"+
		"\3\2\2\2\"\u00b7\3\2\2\2$\u00c0\3\2\2\2&\u00c7\3\2\2\2(\u00c9\3\2\2\2"+
		"*\u00ce\3\2\2\2,/\5\4\3\2-/\5\30\r\2.,\3\2\2\2.-\3\2\2\2/\62\3\2\2\2\60"+
		".\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7\2\2\3\64\3"+
		"\3\2\2\2\65\66\5\6\4\2\66\67\7\25\2\2\679\3\2\2\28\65\3\2\2\29:\3\2\2"+
		"\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<=\7\34\2\2=D\7\37\2\2>A\7\34\2\2?B\5"+
		"\b\5\2@B\5\24\13\2A?\3\2\2\2A@\3\2\2\2BD\3\2\2\2C<\3\2\2\2C>\3\2\2\2D"+
		"\7\3\2\2\2EF\7\37\2\2FI\7\n\2\2GJ\5\n\6\2HJ\5\24\13\2IG\3\2\2\2IH\3\2"+
		"\2\2J\t\3\2\2\2KL\5\f\7\2L\13\3\2\2\2MP\5\16\b\2NO\7\3\2\2OQ\5\16\b\2"+
		"PN\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RS\t\2\2\2SU\5\f\7\2TR\3\2\2\2UX\3\2\2\2"+
		"VT\3\2\2\2VW\3\2\2\2W\r\3\2\2\2XV\3\2\2\2Y^\5\20\t\2Z[\t\3\2\2[]\5\20"+
		"\t\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\17\3\2\2\2`^\3\2\2\2a"+
		"f\5\22\n\2bc\t\4\2\2ce\5\22\n\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2"+
		"\2g\21\3\2\2\2hf\3\2\2\2iq\7\37\2\2jq\5&\24\2kq\5(\25\2lm\7\17\2\2mn\5"+
		"\n\6\2no\7\20\2\2oq\3\2\2\2pi\3\2\2\2pj\3\2\2\2pk\3\2\2\2pl\3\2\2\2q\23"+
		"\3\2\2\2rs\7\35\2\2st\7\37\2\2tu\7\n\2\2uv\5\26\f\2v\25\3\2\2\2wx\7\23"+
		"\2\2x}\5&\24\2yz\7\32\2\2z|\5&\24\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}"+
		"~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\24\2\2\u0081\27\3"+
		"\2\2\2\u0082\u0083\5*\26\2\u0083\u0084\7\37\2\2\u0084\u0085\7\17\2\2\u0085"+
		"\u0086\5\32\16\2\u0086\u0087\7\20\2\2\u0087\u0088\5\36\20\2\u0088\31\3"+
		"\2\2\2\u0089\u008a\7\34\2\2\u008a\u008f\7\37\2\2\u008b\u008c\7\32\2\2"+
		"\u008c\u008e\5\32\16\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\33\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7\37\2\2\u0093\u0094\7\17\2\2\u0094\u0099\7\37\2\2\u0095\u0096"+
		"\7\32\2\2\u0096\u0098\7\37\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2"+
		"\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c\u009d\7\20\2\2\u009d\35\3\2\2\2\u009e\u00a3\7\21\2\2\u009f"+
		"\u00a2\5\4\3\2\u00a0\u00a2\5 \21\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\22\2\2\u00a7\37\3\2\2"+
		"\2\u00a8\u00a9\5\b\5\2\u00a9\u00aa\7\25\2\2\u00aa\u00b4\3\2\2\2\u00ab"+
		"\u00ac\5\n\6\2\u00ac\u00ad\7\25\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00af\5"+
		"\34\17\2\u00af\u00b0\7\25\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b4\5\"\22\2"+
		"\u00b2\u00b4\5$\23\2\u00b3\u00a8\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00ae"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6!\3\2\2\2\u00b7\u00b8\7\26\2\2"+
		"\u00b8\u00b9\7\17\2\2\u00b9\u00ba\5\f\7\2\u00ba\u00bb\7\20\2\2\u00bb\u00be"+
		"\5\36\20\2\u00bc\u00bd\7\27\2\2\u00bd\u00bf\5\36\20\2\u00be\u00bc\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf#\3\2\2\2\u00c0\u00c1\7\30\2\2\u00c1\u00c2"+
		"\7\17\2\2\u00c2\u00c3\5\f\7\2\u00c3\u00c4\7\20\2\2\u00c4\u00c5\7\31\2"+
		"\2\u00c5\u00c6\5\36\20\2\u00c6%\3\2\2\2\u00c7\u00c8\t\5\2\2\u00c8\'\3"+
		"\2\2\2\u00c9\u00ca\7\37\2\2\u00ca\u00cb\7\23\2\2\u00cb\u00cc\5&\24\2\u00cc"+
		"\u00cd\7\24\2\2\u00cd)\3\2\2\2\u00ce\u00cf\t\6\2\2\u00cf+\3\2\2\2\25."+
		"\60:ACIPV^fp}\u008f\u0099\u00a1\u00a3\u00b3\u00b5\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}