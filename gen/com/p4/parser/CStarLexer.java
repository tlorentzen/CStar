// Generated from /Users/lenasaid/floobits/share/ichris18/src/com/p4/parser/CStar.g4 by ANTLR 4.8
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
		NUMBER=34, BOOLEAN_LITERAL=35, PIN_LITERAL=36, CHAR_LITERAL=37, STRING_LITERAL=38,
		ID=39, FUNCID=40, WHITESPACE=41, Newline=42, LINE_COMMENT=43;
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
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "NUMBER",
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
			"','", "'void'", null, "'array'", "'return'", "'console.print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE", 
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "NUMBER",
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0163\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\5\2`\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u00ee\n\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u010c\n#\r"+
		"#\16#\u010d\3#\3#\6#\u0112\n#\r#\16#\u0113\5#\u0116\n#\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\5$\u0121\n$\3%\5%\u0124\n%\3%\6%\u0127\n%\r%\16%\u0128\3"+
		"&\3&\3&\3&\3\'\3\'\7\'\u0131\n\'\f\'\16\'\u0134\13\'\3\'\3\'\3(\6(\u0139"+
		"\n(\r(\16(\u013a\3)\6)\u013e\n)\r)\16)\u013f\3)\5)\u0143\n)\6)\u0145\n"+
		")\r)\16)\u0146\3*\6*\u014a\n*\r*\16*\u014b\3*\3*\3+\3+\5+\u0152\n+\3+"+
		"\5+\u0155\n+\3+\3+\3,\3,\3,\3,\7,\u015d\n,\f,\16,\u0160\13,\3,\3,\2\2"+
		"-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\7\4\2CCcc\5\2\f\f\17\17$$\6\2\62;C"+
		"\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u017c\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3_\3\2"+
		"\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13h\3\2\2\2\rn\3\2\2\2\17q\3\2\2"+
		"\2\21u\3\2\2\2\23w\3\2\2\2\25y\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\177"+
		"\3\2\2\2\35\u0082\3\2\2\2\37\u0085\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2"+
		"\2%\u008b\3\2\2\2\'\u008d\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0093"+
		"\3\2\2\2/\u0095\3\2\2\2\61\u0097\3\2\2\2\63\u009a\3\2\2\2\65\u009f\3\2"+
		"\2\2\67\u00a5\3\2\2\29\u00ac\3\2\2\2;\u00ae\3\2\2\2=\u00ed\3\2\2\2?\u00ef"+
		"\3\2\2\2A\u00f5\3\2\2\2C\u00fc\3\2\2\2E\u010b\3\2\2\2G\u0120\3\2\2\2I"+
		"\u0123\3\2\2\2K\u012a\3\2\2\2M\u012e\3\2\2\2O\u0138\3\2\2\2Q\u0144\3\2"+
		"\2\2S\u0149\3\2\2\2U\u0154\3\2\2\2W\u0158\3\2\2\2Y`\5\5\3\2Z`\5\7\4\2"+
		"[`\5\t\5\2\\`\5\13\6\2]`\5\33\16\2^`\5\35\17\2_Y\3\2\2\2_Z\3\2\2\2_[\3"+
		"\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`\4\3\2\2\2ab\7>\2\2b\6\3\2\2\2c"+
		"d\7@\2\2d\b\3\2\2\2ef\7K\2\2fg\7U\2\2g\n\3\2\2\2hi\7K\2\2ij\7U\2\2jk\7"+
		"P\2\2kl\7Q\2\2lm\7V\2\2m\f\3\2\2\2no\7Q\2\2op\7T\2\2p\16\3\2\2\2qr\7C"+
		"\2\2rs\7P\2\2st\7F\2\2t\20\3\2\2\2uv\7?\2\2v\22\3\2\2\2wx\7-\2\2x\24\3"+
		"\2\2\2yz\7/\2\2z\26\3\2\2\2{|\7,\2\2|\30\3\2\2\2}~\7\61\2\2~\32\3\2\2"+
		"\2\177\u0080\7>\2\2\u0080\u0081\7?\2\2\u0081\34\3\2\2\2\u0082\u0083\7"+
		"@\2\2\u0083\u0084\7?\2\2\u0084\36\3\2\2\2\u0085\u0086\7\'\2\2\u0086 \3"+
		"\2\2\2\u0087\u0088\7*\2\2\u0088\"\3\2\2\2\u0089\u008a\7+\2\2\u008a$\3"+
		"\2\2\2\u008b\u008c\7]\2\2\u008c&\3\2\2\2\u008d\u008e\7_\2\2\u008e(\3\2"+
		"\2\2\u008f\u0090\7}\2\2\u0090*\3\2\2\2\u0091\u0092\7\177\2\2\u0092,\3"+
		"\2\2\2\u0093\u0094\7=\2\2\u0094.\3\2\2\2\u0095\u0096\7\60\2\2\u0096\60"+
		"\3\2\2\2\u0097\u0098\7k\2\2\u0098\u0099\7h\2\2\u0099\62\3\2\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u009c\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2"+
		"\u009e\64\3\2\2\2\u009f\u00a0\7y\2\2\u00a0\u00a1\7j\2\2\u00a1\u00a2\7"+
		"k\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7g\2\2\u00a4\66\3\2\2\2\u00a5\u00a6"+
		"\7t\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7r\2\2\u00a8\u00a9\7g\2\2\u00a9"+
		"\u00aa\7c\2\2\u00aa\u00ab\7v\2\2\u00ab8\3\2\2\2\u00ac\u00ad\7.\2\2\u00ad"+
		":\3\2\2\2\u00ae\u00af\7x\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7k\2\2\u00b1"+
		"\u00b2\7f\2\2\u00b2<\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\u00b6\7v\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7i\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9\u00ee\7t\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7e\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7o\2\2\u00bf\u00c0\7c\2\2\u00c0"+
		"\u00ee\7n\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7j\2\2\u00c3\u00c4\7c\2\2"+
		"\u00c4\u00c5\7t\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8"+
		"\7v\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ee\7t\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\u00cc\7q\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7i\2\2\u00ce\u00cf\7\"\2"+
		"\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3"+
		"\7g\2\2\u00d3\u00d4\7i\2\2\u00d4\u00d5\7g\2\2\u00d5\u00ee\7t\2\2\u00d6"+
		"\u00d7\7u\2\2\u00d7\u00d8\7o\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7n\2\2"+
		"\u00da\u00db\7n\2\2\u00db\u00dc\7\"\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de"+
		"\7p\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7i\2\2\u00e1"+
		"\u00e2\7g\2\2\u00e2\u00ee\7t\2\2\u00e3\u00e4\7r\2\2\u00e4\u00e5\7k\2\2"+
		"\u00e5\u00ee\7p\2\2\u00e6\u00e7\7d\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7q\2\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ee\7p\2\2\u00ed\u00b3\3\2\2\2\u00ed\u00ba\3\2\2\2\u00ed\u00c1\3\2"+
		"\2\2\u00ed\u00ca\3\2\2\2\u00ed\u00d6\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed"+
		"\u00e6\3\2\2\2\u00ee>\3\2\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7t\2\2\u00f1"+
		"\u00f2\7t\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7{\2\2\u00f4@\3\2\2\2\u00f5"+
		"\u00f6\7t\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7w\2\2"+
		"\u00f9\u00fa\7t\2\2\u00fa\u00fb\7p\2\2\u00fbB\3\2\2\2\u00fc\u00fd\7e\2"+
		"\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7u\2\2\u0100\u0101"+
		"\7q\2\2\u0101\u0102\7n\2\2\u0102\u0103\7g\2\2\u0103\u0104\7\60\2\2\u0104"+
		"\u0105\7r\2\2\u0105\u0106\7t\2\2\u0106\u0107\7k\2\2\u0107\u0108\7p\2\2"+
		"\u0108\u0109\7v\2\2\u0109D\3\2\2\2\u010a\u010c\4\62;\2\u010b\u010a\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0115\3\2\2\2\u010f\u0111\7\60\2\2\u0110\u0112\4\62;\2\u0111\u0110\3"+
		"\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u010f\3\2\2\2\u0115\u0116\3\2\2\2\u0116F\3\2\2\2"+
		"\u0117\u0118\7v\2\2\u0118\u0119\7t\2\2\u0119\u011a\7w\2\2\u011a\u0121"+
		"\7g\2\2\u011b\u011c\7h\2\2\u011c\u011d\7c\2\2\u011d\u011e\7n\2\2\u011e"+
		"\u011f\7u\2\2\u011f\u0121\7g\2\2\u0120\u0117\3\2\2\2\u0120\u011b\3\2\2"+
		"\2\u0121H\3\2\2\2\u0122\u0124\t\2\2\2\u0123\u0122\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0127\4\62;\2\u0126\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129J\3\2\2\2"+
		"\u012a\u012b\7)\2\2\u012b\u012c\13\2\2\2\u012c\u012d\7)\2\2\u012dL\3\2"+
		"\2\2\u012e\u0132\7$\2\2\u012f\u0131\n\3\2\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7$\2\2\u0136N\3\2\2\2\u0137\u0139"+
		"\t\4\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013bP\3\2\2\2\u013c\u013e\t\4\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142"+
		"\3\2\2\2\u0141\u0143\7\60\2\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2"+
		"\u0143\u0145\3\2\2\2\u0144\u013d\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147R\3\2\2\2\u0148\u014a\t\5\2\2\u0149"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014e\b*\2\2\u014eT\3\2\2\2\u014f\u0151"+
		"\7\17\2\2\u0150\u0152\7\f\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2"+
		"\u0152\u0155\3\2\2\2\u0153\u0155\7\f\2\2\u0154\u014f\3\2\2\2\u0154\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b+\2\2\u0157V\3\2\2\2\u0158\u0159"+
		"\7\61\2\2\u0159\u015a\7\61\2\2\u015a\u015e\3\2\2\2\u015b\u015d\n\6\2\2"+
		"\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f"+
		"\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\b,\2\2\u0162"+
		"X\3\2\2\2\24\2_\u00ed\u010d\u0113\u0115\u0120\u0123\u0128\u0132\u013a"+
		"\u013f\u0142\u0146\u014b\u0151\u0154\u015e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}