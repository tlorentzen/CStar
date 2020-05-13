// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/syntaxSemantic\CStar.g4 by ANTLR 4.8
package com.p4.syntaxSemantic;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CStarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", "ONE_OF", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE", 
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "HIGH", 
			"LOW", "BETWEEN", "IN", "NUMBER", "BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", 
			"STRING_LITERAL", "ID", "FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT", 
			"INCLUDE", "HEADER"
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


	public CStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u019a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2n\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0103\n"+
		" \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3(\6(\u0135\n(\r(\16(\u0136\3(\3(\6(\u013b\n(\r(\16(\u013c"+
		"\5(\u013f\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u014a\n)\3*\5*\u014d\n*\3*"+
		"\6*\u0150\n*\r*\16*\u0151\3+\3+\3+\3+\3,\3,\7,\u015a\n,\f,\16,\u015d\13"+
		",\3,\3,\3-\6-\u0162\n-\r-\16-\u0163\3.\6.\u0167\n.\r.\16.\u0168\3.\5."+
		"\u016c\n.\6.\u016e\n.\r.\16.\u016f\3/\6/\u0173\n/\r/\16/\u0174\3/\3/\3"+
		"\60\3\60\5\60\u017b\n\60\3\60\5\60\u017e\n\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\7\61\u0186\n\61\f\61\16\61\u0189\13\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\5\63\u0197\n\63\3\63\3\63\2\2\64\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64\3\2\7\4\2CCcc\5"+
		"\2\f\f\17\17$$\6\2\62;C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u01b4\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\3m\3\2\2\2\5o\3\2\2\2\7q\3\2\2\2\ts\3\2\2\2\13"+
		"v\3\2\2\2\r|\3\2\2\2\17\177\3\2\2\2\21\u0083\3\2\2\2\23\u008a\3\2\2\2"+
		"\25\u008c\3\2\2\2\27\u008e\3\2\2\2\31\u0090\3\2\2\2\33\u0092\3\2\2\2\35"+
		"\u0094\3\2\2\2\37\u0097\3\2\2\2!\u009a\3\2\2\2#\u009c\3\2\2\2%\u009e\3"+
		"\2\2\2\'\u00a0\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3\2\2\2-\u00a6\3\2\2\2/\u00a8"+
		"\3\2\2\2\61\u00aa\3\2\2\2\63\u00ac\3\2\2\2\65\u00af\3\2\2\2\67\u00b4\3"+
		"\2\2\29\u00ba\3\2\2\2;\u00c1\3\2\2\2=\u00c3\3\2\2\2?\u0102\3\2\2\2A\u0104"+
		"\3\2\2\2C\u010a\3\2\2\2E\u0111\3\2\2\2G\u011f\3\2\2\2I\u0124\3\2\2\2K"+
		"\u0128\3\2\2\2M\u0130\3\2\2\2O\u0134\3\2\2\2Q\u0149\3\2\2\2S\u014c\3\2"+
		"\2\2U\u0153\3\2\2\2W\u0157\3\2\2\2Y\u0161\3\2\2\2[\u016d\3\2\2\2]\u0172"+
		"\3\2\2\2_\u017d\3\2\2\2a\u0181\3\2\2\2c\u018a\3\2\2\2e\u0193\3\2\2\2g"+
		"n\5\5\3\2hn\5\7\4\2in\5\t\5\2jn\5\13\6\2kn\5\35\17\2ln\5\37\20\2mg\3\2"+
		"\2\2mh\3\2\2\2mi\3\2\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\4\3\2\2\2op\7"+
		">\2\2p\6\3\2\2\2qr\7@\2\2r\b\3\2\2\2st\7K\2\2tu\7U\2\2u\n\3\2\2\2vw\7"+
		"K\2\2wx\7U\2\2xy\7P\2\2yz\7Q\2\2z{\7V\2\2{\f\3\2\2\2|}\7Q\2\2}~\7T\2\2"+
		"~\16\3\2\2\2\177\u0080\7C\2\2\u0080\u0081\7P\2\2\u0081\u0082\7F\2\2\u0082"+
		"\20\3\2\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7P\2\2\u0085\u0086\7G\2\2\u0086"+
		"\u0087\7\"\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7H\2\2\u0089\22\3\2\2\2"+
		"\u008a\u008b\7?\2\2\u008b\24\3\2\2\2\u008c\u008d\7-\2\2\u008d\26\3\2\2"+
		"\2\u008e\u008f\7/\2\2\u008f\30\3\2\2\2\u0090\u0091\7,\2\2\u0091\32\3\2"+
		"\2\2\u0092\u0093\7\61\2\2\u0093\34\3\2\2\2\u0094\u0095\7>\2\2\u0095\u0096"+
		"\7?\2\2\u0096\36\3\2\2\2\u0097\u0098\7@\2\2\u0098\u0099\7?\2\2\u0099 "+
		"\3\2\2\2\u009a\u009b\7\'\2\2\u009b\"\3\2\2\2\u009c\u009d\7*\2\2\u009d"+
		"$\3\2\2\2\u009e\u009f\7+\2\2\u009f&\3\2\2\2\u00a0\u00a1\7]\2\2\u00a1("+
		"\3\2\2\2\u00a2\u00a3\7_\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7}\2\2\u00a5,\3"+
		"\2\2\2\u00a6\u00a7\7\177\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7=\2\2\u00a9\60"+
		"\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab\62\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad"+
		"\u00ae\7h\2\2\u00ae\64\3\2\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7n\2\2\u00b1"+
		"\u00b2\7u\2\2\u00b2\u00b3\7g\2\2\u00b3\66\3\2\2\2\u00b4\u00b5\7y\2\2\u00b5"+
		"\u00b6\7j\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b98\3\2\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7r\2"+
		"\2\u00bd\u00be\7g\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7v\2\2\u00c0:\3\2"+
		"\2\2\u00c1\u00c2\7.\2\2\u00c2<\3\2\2\2\u00c3\u00c4\7x\2\2\u00c4\u00c5"+
		"\7q\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7f\2\2\u00c7>\3\2\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7g\2\2\u00cc"+
		"\u00cd\7i\2\2\u00cd\u00ce\7g\2\2\u00ce\u0103\7t\2\2\u00cf\u00d0\7f\2\2"+
		"\u00d0\u00d1\7g\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4"+
		"\7o\2\2\u00d4\u00d5\7c\2\2\u00d5\u0103\7n\2\2\u00d6\u00d7\7e\2\2\u00d7"+
		"\u00d8\7j\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7c\2\2"+
		"\u00db\u00dc\7e\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7g\2\2\u00de\u0103"+
		"\7t\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7p\2\2\u00e2"+
		"\u00e3\7i\2\2\u00e3\u00e4\7\"\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7p\2"+
		"\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7i\2\2\u00e9\u00ea"+
		"\7g\2\2\u00ea\u0103\7t\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7o\2\2\u00ed"+
		"\u00ee\7c\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7\"\2"+
		"\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5"+
		"\7g\2\2\u00f5\u00f6\7i\2\2\u00f6\u00f7\7g\2\2\u00f7\u0103\7t\2\2\u00f8"+
		"\u00f9\7r\2\2\u00f9\u00fa\7k\2\2\u00fa\u0103\7p\2\2\u00fb\u00fc\7d\2\2"+
		"\u00fc\u00fd\7q\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100"+
		"\7g\2\2\u0100\u0101\7c\2\2\u0101\u0103\7p\2\2\u0102\u00c8\3\2\2\2\u0102"+
		"\u00cf\3\2\2\2\u0102\u00d6\3\2\2\2\u0102\u00df\3\2\2\2\u0102\u00eb\3\2"+
		"\2\2\u0102\u00f8\3\2\2\2\u0102\u00fb\3\2\2\2\u0103@\3\2\2\2\u0104\u0105"+
		"\7c\2\2\u0105\u0106\7t\2\2\u0106\u0107\7t\2\2\u0107\u0108\7c\2\2\u0108"+
		"\u0109\7{\2\2\u0109B\3\2\2\2\u010a\u010b\7t\2\2\u010b\u010c\7g\2\2\u010c"+
		"\u010d\7v\2\2\u010d\u010e\7w\2\2\u010e\u010f\7t\2\2\u010f\u0110\7p\2\2"+
		"\u0110D\3\2\2\2\u0111\u0112\7e\2\2\u0112\u0113\7q\2\2\u0113\u0114\7p\2"+
		"\2\u0114\u0115\7u\2\2\u0115\u0116\7q\2\2\u0116\u0117\7n\2\2\u0117\u0118"+
		"\7g\2\2\u0118\u0119\7\60\2\2\u0119\u011a\7r\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7k\2\2\u011c\u011d\7p\2\2\u011d\u011e\7v\2\2\u011eF\3\2\2\2\u011f"+
		"\u0120\7J\2\2\u0120\u0121\7K\2\2\u0121\u0122\7I\2\2\u0122\u0123\7J\2\2"+
		"\u0123H\3\2\2\2\u0124\u0125\7N\2\2\u0125\u0126\7Q\2\2\u0126\u0127\7Y\2"+
		"\2\u0127J\3\2\2\2\u0128\u0129\7D\2\2\u0129\u012a\7G\2\2\u012a\u012b\7"+
		"V\2\2\u012b\u012c\7Y\2\2\u012c\u012d\7G\2\2\u012d\u012e\7G\2\2\u012e\u012f"+
		"\7P\2\2\u012fL\3\2\2\2\u0130\u0131\7K\2\2\u0131\u0132\7P\2\2\u0132N\3"+
		"\2\2\2\u0133\u0135\4\62;\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u013e\3\2\2\2\u0138\u013a\7\60"+
		"\2\2\u0139\u013b\4\62;\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0138\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013fP\3\2\2\2\u0140\u0141\7v\2\2\u0141\u0142"+
		"\7t\2\2\u0142\u0143\7w\2\2\u0143\u014a\7g\2\2\u0144\u0145\7h\2\2\u0145"+
		"\u0146\7c\2\2\u0146\u0147\7n\2\2\u0147\u0148\7u\2\2\u0148\u014a\7g\2\2"+
		"\u0149\u0140\3\2\2\2\u0149\u0144\3\2\2\2\u014aR\3\2\2\2\u014b\u014d\t"+
		"\2\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u0150\4\62;\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152T\3\2\2\2\u0153\u0154\7)\2\2\u0154\u0155"+
		"\13\2\2\2\u0155\u0156\7)\2\2\u0156V\3\2\2\2\u0157\u015b\7$\2\2\u0158\u015a"+
		"\n\3\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7$"+
		"\2\2\u015fX\3\2\2\2\u0160\u0162\t\4\2\2\u0161\u0160\3\2\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164Z\3\2\2\2\u0165"+
		"\u0167\t\4\2\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u016c\7\60\2\2\u016b"+
		"\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u0166\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\\\3\2\2\2\u0171\u0173\t\5\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2"+
		"\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\b/\2\2\u0177^\3\2\2\2\u0178\u017a\7\17\2\2\u0179\u017b\7\f\2\2\u017a"+
		"\u0179\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017e\7\f"+
		"\2\2\u017d\u0178\3\2\2\2\u017d\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0180\b\60\2\2\u0180`\3\2\2\2\u0181\u0182\7\61\2\2\u0182\u0183\7\61\2"+
		"\2\u0183\u0187\3\2\2\2\u0184\u0186\n\6\2\2\u0185\u0184\3\2\2\2\u0186\u0189"+
		"\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u018a\u018b\7%\2\2\u018b\u018c\7k\2\2\u018c\u018d\7p\2"+
		"\2\u018d\u018e\7e\2\2\u018e\u018f\7n\2\2\u018f\u0190\7w\2\2\u0190\u0191"+
		"\7f\2\2\u0191\u0192\7g\2\2\u0192d\3\2\2\2\u0193\u0196\7>\2\2\u0194\u0197"+
		"\5Y-\2\u0195\u0197\5[.\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u0199\7@\2\2\u0199f\3\2\2\2\25\2m\u0102\u0136\u013c"+
		"\u013e\u0149\u014c\u0151\u015b\u0163\u0168\u016b\u016f\u0174\u017a\u017d"+
		"\u0187\u0196\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}