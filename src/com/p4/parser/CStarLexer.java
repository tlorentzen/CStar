// Generated from C:/Users/Zohra/floobits/share/Jakob4dhx8/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
package com.p4.parser;
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
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ASSIGN_OP=8, 
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LESS_THAN_EQ=13, GREATER_THAN_EQ=14, 
		MODULO=15, LEFT_PAREN=16, RIGHT_PAREN=17, LEFT_BRACKET=18, RIGHT_BRACKET=19, 
		LEFT_BRACE=20, RIGHT_BRACE=21, SEMICOLON=22, DOT=23, IF=24, ELSE=25, WHILE=26, 
		REPEAT=27, COMMA=28, VOID=29, TYPE=30, ARRAY=31, RETURN=32, PRINT=33, 
		READ=34, WRITE=35, SLEEP=36, INT_LITERAL=37, LONG_LITERAL=38, SMALL_LITERAL=39, 
		FLOAT_LITERAL=40, BOOLEAN_LITERAL=41, PIN_LITERAL=42, CHAR_LITERAL=43, 
		STRING_LITERAL=44, ID=45, FUNCID=46, WHITESPACE=47, Newline=48, LINE_COMMENT=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", "ASSIGN_OP", 
			"PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE", 
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "READ", 
			"WRITE", "SLEEP", "INT_LITERAL", "LONG_LITERAL", "SMALL_LITERAL", "FLOAT_LITERAL", 
			"BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "ID", 
			"FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'<='", "'>='", "'%'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "';'", "'.'", "'if'", "'else'", "'while'", "'repeat'", 
			"','", "'void'", null, "'array'", "'return'", "'console.print'", "'read'", 
			"'write'", "'sleep'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE", 
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "READ", 
			"WRITE", "SLEEP", "INT_LITERAL", "LONG_LITERAL", "SMALL_LITERAL", "FLOAT_LITERAL", 
			"BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "ID", 
			"FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0187\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2l\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u00f2\n\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\6&\u0121\n&\r&\16&\u0122"+
		"\3\'\6\'\u0126\n\'\r\'\16\'\u0127\3(\6(\u012b\n(\r(\16(\u012c\3)\6)\u0130"+
		"\n)\r)\16)\u0131\3)\3)\6)\u0136\n)\r)\16)\u0137\5)\u013a\n)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\5*\u0145\n*\3+\5+\u0148\n+\3+\6+\u014b\n+\r+\16+\u014c"+
		"\3,\3,\3,\3,\3-\3-\7-\u0155\n-\f-\16-\u0158\13-\3-\3-\3.\6.\u015d\n.\r"+
		".\16.\u015e\3/\6/\u0162\n/\r/\16/\u0163\3/\5/\u0167\n/\6/\u0169\n/\r/"+
		"\16/\u016a\3\60\6\60\u016e\n\60\r\60\16\60\u016f\3\60\3\60\3\61\3\61\5"+
		"\61\u0176\n\61\3\61\5\61\u0179\n\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62"+
		"\u0181\n\62\f\62\16\62\u0184\13\62\3\62\3\62\2\2\63\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\7\4\2CCcc\5\2\f\f\17\17$$\6\2\62"+
		";C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u01a3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3k\3\2\2"+
		"\2\5m\3\2\2\2\7o\3\2\2\2\tq\3\2\2\2\13t\3\2\2\2\rz\3\2\2\2\17}\3\2\2\2"+
		"\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31"+
		"\u0089\3\2\2\2\33\u008b\3\2\2\2\35\u008e\3\2\2\2\37\u0091\3\2\2\2!\u0093"+
		"\3\2\2\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2)\u009b\3\2\2\2"+
		"+\u009d\3\2\2\2-\u009f\3\2\2\2/\u00a1\3\2\2\2\61\u00a3\3\2\2\2\63\u00a6"+
		"\3\2\2\2\65\u00ab\3\2\2\2\67\u00b1\3\2\2\29\u00b8\3\2\2\2;\u00ba\3\2\2"+
		"\2=\u00f1\3\2\2\2?\u00f3\3\2\2\2A\u00f9\3\2\2\2C\u0100\3\2\2\2E\u010e"+
		"\3\2\2\2G\u0113\3\2\2\2I\u0119\3\2\2\2K\u0120\3\2\2\2M\u0125\3\2\2\2O"+
		"\u012a\3\2\2\2Q\u012f\3\2\2\2S\u0144\3\2\2\2U\u0147\3\2\2\2W\u014e\3\2"+
		"\2\2Y\u0152\3\2\2\2[\u015c\3\2\2\2]\u0168\3\2\2\2_\u016d\3\2\2\2a\u0178"+
		"\3\2\2\2c\u017c\3\2\2\2el\5\5\3\2fl\5\7\4\2gl\5\t\5\2hl\5\13\6\2il\5\33"+
		"\16\2jl\5\35\17\2ke\3\2\2\2kf\3\2\2\2kg\3\2\2\2kh\3\2\2\2ki\3\2\2\2kj"+
		"\3\2\2\2l\4\3\2\2\2mn\7>\2\2n\6\3\2\2\2op\7@\2\2p\b\3\2\2\2qr\7K\2\2r"+
		"s\7U\2\2s\n\3\2\2\2tu\7K\2\2uv\7U\2\2vw\7P\2\2wx\7Q\2\2xy\7V\2\2y\f\3"+
		"\2\2\2z{\7Q\2\2{|\7T\2\2|\16\3\2\2\2}~\7C\2\2~\177\7P\2\2\177\u0080\7"+
		"F\2\2\u0080\20\3\2\2\2\u0081\u0082\7?\2\2\u0082\22\3\2\2\2\u0083\u0084"+
		"\7-\2\2\u0084\24\3\2\2\2\u0085\u0086\7/\2\2\u0086\26\3\2\2\2\u0087\u0088"+
		"\7,\2\2\u0088\30\3\2\2\2\u0089\u008a\7\61\2\2\u008a\32\3\2\2\2\u008b\u008c"+
		"\7>\2\2\u008c\u008d\7?\2\2\u008d\34\3\2\2\2\u008e\u008f\7@\2\2\u008f\u0090"+
		"\7?\2\2\u0090\36\3\2\2\2\u0091\u0092\7\'\2\2\u0092 \3\2\2\2\u0093\u0094"+
		"\7*\2\2\u0094\"\3\2\2\2\u0095\u0096\7+\2\2\u0096$\3\2\2\2\u0097\u0098"+
		"\7]\2\2\u0098&\3\2\2\2\u0099\u009a\7_\2\2\u009a(\3\2\2\2\u009b\u009c\7"+
		"}\2\2\u009c*\3\2\2\2\u009d\u009e\7\177\2\2\u009e,\3\2\2\2\u009f\u00a0"+
		"\7=\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7\60\2\2\u00a2\60\3\2\2\2\u00a3\u00a4"+
		"\7k\2\2\u00a4\u00a5\7h\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8"+
		"\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa\64\3\2\2\2\u00ab\u00ac"+
		"\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\66\3\2\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7r\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7v\2\2"+
		"\u00b78\3\2\2\2\u00b8\u00b9\7.\2\2\u00b9:\3\2\2\2\u00ba\u00bb\7x\2\2\u00bb"+
		"\u00bc\7q\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7f\2\2\u00be<\3\2\2\2\u00bf"+
		"\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3\u00c4\7i\2\2\u00c4\u00c5\7g\2\2\u00c5\u00f2\7t\2\2\u00c6\u00c7"+
		"\7f\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7k\2\2\u00ca"+
		"\u00cb\7o\2\2\u00cb\u00cc\7c\2\2\u00cc\u00f2\7n\2\2\u00cd\u00ce\7e\2\2"+
		"\u00ce\u00cf\7j\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7c\2\2\u00d2\u00d3\7e\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00f2\7t\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7p\2\2"+
		"\u00d9\u00da\7i\2\2\u00da\u00db\7\"\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7i\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00f2\7t\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7k\2\2"+
		"\u00e4\u00f2\7p\2\2\u00e5\u00e6\7d\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8"+
		"\7q\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7c\2\2\u00eb"+
		"\u00f2\7p\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee\7o\2\2\u00ee\u00ef\7c\2\2"+
		"\u00ef\u00f0\7n\2\2\u00f0\u00f2\7n\2\2\u00f1\u00bf\3\2\2\2\u00f1\u00c6"+
		"\3\2\2\2\u00f1\u00cd\3\2\2\2\u00f1\u00d6\3\2\2\2\u00f1\u00e2\3\2\2\2\u00f1"+
		"\u00e5\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2>\3\2\2\2\u00f3\u00f4\7c\2\2\u00f4"+
		"\u00f5\7t\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7{\2\2"+
		"\u00f8@\3\2\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7v\2"+
		"\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7p\2\2\u00ffB\3\2"+
		"\2\2\u0100\u0101\7e\2\2\u0101\u0102\7q\2\2\u0102\u0103\7p\2\2\u0103\u0104"+
		"\7u\2\2\u0104\u0105\7q\2\2\u0105\u0106\7n\2\2\u0106\u0107\7g\2\2\u0107"+
		"\u0108\7\60\2\2\u0108\u0109\7r\2\2\u0109\u010a\7t\2\2\u010a\u010b\7k\2"+
		"\2\u010b\u010c\7p\2\2\u010c\u010d\7v\2\2\u010dD\3\2\2\2\u010e\u010f\7"+
		"t\2\2\u010f\u0110\7g\2\2\u0110\u0111\7c\2\2\u0111\u0112\7f\2\2\u0112F"+
		"\3\2\2\2\u0113\u0114\7y\2\2\u0114\u0115\7t\2\2\u0115\u0116\7k\2\2\u0116"+
		"\u0117\7v\2\2\u0117\u0118\7g\2\2\u0118H\3\2\2\2\u0119\u011a\7u\2\2\u011a"+
		"\u011b\7n\2\2\u011b\u011c\7g\2\2\u011c\u011d\7g\2\2\u011d\u011e\7r\2\2"+
		"\u011eJ\3\2\2\2\u011f\u0121\4\62;\2\u0120\u011f\3\2\2\2\u0121\u0122\3"+
		"\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123L\3\2\2\2\u0124\u0126"+
		"\4\62;\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128N\3\2\2\2\u0129\u012b\4\62;\2\u012a\u0129\3\2\2\2"+
		"\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012dP\3"+
		"\2\2\2\u012e\u0130\4\62;\2\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0139\3\2\2\2\u0133\u0135\7\60"+
		"\2\2\u0134\u0136\4\62;\2\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0133\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013aR\3\2\2\2\u013b\u013c\7v\2\2\u013c\u013d"+
		"\7t\2\2\u013d\u013e\7w\2\2\u013e\u0145\7g\2\2\u013f\u0140\7h\2\2\u0140"+
		"\u0141\7c\2\2\u0141\u0142\7n\2\2\u0142\u0143\7u\2\2\u0143\u0145\7g\2\2"+
		"\u0144\u013b\3\2\2\2\u0144\u013f\3\2\2\2\u0145T\3\2\2\2\u0146\u0148\t"+
		"\2\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u014b\4\62;\2\u014a\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014dV\3\2\2\2\u014e\u014f\7)\2\2\u014f\u0150"+
		"\13\2\2\2\u0150\u0151\7)\2\2\u0151X\3\2\2\2\u0152\u0156\7$\2\2\u0153\u0155"+
		"\n\3\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7$"+
		"\2\2\u015aZ\3\2\2\2\u015b\u015d\t\4\2\2\u015c\u015b\3\2\2\2\u015d\u015e"+
		"\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\\\3\2\2\2\u0160"+
		"\u0162\t\4\2\2\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0161\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0167\7\60\2\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0161\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"^\3\2\2\2\u016c\u016e\t\5\2\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2"+
		"\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172"+
		"\b\60\2\2\u0172`\3\2\2\2\u0173\u0175\7\17\2\2\u0174\u0176\7\f\2\2\u0175"+
		"\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0179\7\f"+
		"\2\2\u0178\u0173\3\2\2\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017b\b\61\2\2\u017bb\3\2\2\2\u017c\u017d\7\61\2\2\u017d\u017e\7\61\2"+
		"\2\u017e\u0182\3\2\2\2\u017f\u0181\n\6\2\2\u0180\u017f\3\2\2\2\u0181\u0184"+
		"\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0185\u0186\b\62\2\2\u0186d\3\2\2\2\27\2k\u00f1\u0122\u0127"+
		"\u012c\u0131\u0137\u0139\u0144\u0147\u014c\u0156\u015e\u0163\u0166\u016a"+
		"\u016f\u0175\u0178\u0182\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}