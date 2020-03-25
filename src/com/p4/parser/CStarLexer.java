package com.p4.parser;

// Generated from C:/Users/Jakob/Desktop/AntlrTest\CStar.g4 by ANTLR 4.8
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
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LEFT_PAREN=13, RIGHT_PAREN=14, 
		LEFT_BRACKET=15, RIGHT_BRACKET=16, LEFT_BRACE=17, RIGHT_BRACE=18, SEMICOLON=19, 
		DOT=20, IF=21, ELSE=22, WHILE=23, REPEAT=24, COMMA=25, VOID=26, TYPE=27, 
		ARRAY=28, RETURN=29, INT_LITERAL=30, LONG_LITERAL=31, FLOAT_LITERAL=32, 
		PIN_LITERAL=33, CHAR_LITERAL=34, ID=35, WHITESPACE=36, Newline=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", "ASSIGN_OP", 
			"PLUS", "MINUS", "MULT", "DIVISION", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", 
			"ELSE", "WHILE", "REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", 
			"INT_LITERAL", "LONG_LITERAL", "FLOAT_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", 
			"ID", "WHITESPACE", "Newline"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0112\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\5\2R\n\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u00c3\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\5\37\u00d3\n\37\3\37\6\37"+
		"\u00d6\n\37\r\37\16\37\u00d7\3 \5 \u00db\n \3 \6 \u00de\n \r \16 \u00df"+
		"\3!\5!\u00e3\n!\3!\6!\u00e6\n!\r!\16!\u00e7\3!\3!\6!\u00ec\n!\r!\16!\u00ed"+
		"\5!\u00f0\n!\3\"\5\"\u00f3\n\"\3\"\6\"\u00f6\n\"\r\"\16\"\u00f7\3#\3#"+
		"\3#\3#\3$\6$\u00ff\n$\r$\16$\u0100\3%\6%\u0104\n%\r%\16%\u0105\3%\3%\3"+
		"&\3&\5&\u010c\n&\3&\5&\u010f\n&\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\5\4"+
		"\2CCcc\6\2\62;C\\aac|\4\2\13\13\"\"\2\u0126\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3"+
		"Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13Z\3\2\2\2\r`\3\2\2\2\17c"+
		"\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33"+
		"q\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'}\3\2"+
		"\2\2)\177\3\2\2\2+\u0081\3\2\2\2-\u0084\3\2\2\2/\u0089\3\2\2\2\61\u008f"+
		"\3\2\2\2\63\u0096\3\2\2\2\65\u0098\3\2\2\2\67\u00c2\3\2\2\29\u00c4\3\2"+
		"\2\2;\u00ca\3\2\2\2=\u00d2\3\2\2\2?\u00da\3\2\2\2A\u00e2\3\2\2\2C\u00f2"+
		"\3\2\2\2E\u00f9\3\2\2\2G\u00fe\3\2\2\2I\u0103\3\2\2\2K\u010e\3\2\2\2M"+
		"R\5\5\3\2NR\5\7\4\2OR\5\t\5\2PR\5\13\6\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2"+
		"QP\3\2\2\2R\4\3\2\2\2ST\7>\2\2T\6\3\2\2\2UV\7@\2\2V\b\3\2\2\2WX\7K\2\2"+
		"XY\7U\2\2Y\n\3\2\2\2Z[\7K\2\2[\\\7U\2\2\\]\7P\2\2]^\7Q\2\2^_\7V\2\2_\f"+
		"\3\2\2\2`a\7Q\2\2ab\7T\2\2b\16\3\2\2\2cd\7C\2\2de\7P\2\2ef\7F\2\2f\20"+
		"\3\2\2\2gh\7?\2\2h\22\3\2\2\2ij\7-\2\2j\24\3\2\2\2kl\7/\2\2l\26\3\2\2"+
		"\2mn\7,\2\2n\30\3\2\2\2op\7\61\2\2p\32\3\2\2\2qr\7*\2\2r\34\3\2\2\2st"+
		"\7+\2\2t\36\3\2\2\2uv\7}\2\2v \3\2\2\2wx\7\177\2\2x\"\3\2\2\2yz\7]\2\2"+
		"z$\3\2\2\2{|\7_\2\2|&\3\2\2\2}~\7=\2\2~(\3\2\2\2\177\u0080\7\60\2\2\u0080"+
		"*\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083\7h\2\2\u0083,\3\2\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088"+
		".\3\2\2\2\u0089\u008a\7y\2\2\u008a\u008b\7j\2\2\u008b\u008c\7k\2\2\u008c"+
		"\u008d\7n\2\2\u008d\u008e\7g\2\2\u008e\60\3\2\2\2\u008f\u0090\7t\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7r\2\2\u0092\u0093\7g\2\2\u0093\u0094\7c\2\2"+
		"\u0094\u0095\7v\2\2\u0095\62\3\2\2\2\u0096\u0097\7.\2\2\u0097\64\3\2\2"+
		"\2\u0098\u0099\7x\2\2\u0099\u009a\7q\2\2\u009a\u009b\7k\2\2\u009b\u009c"+
		"\7f\2\2\u009c\66\3\2\2\2\u009d\u009e\7k\2\2\u009e\u009f\7p\2\2\u009f\u00a0"+
		"\7v\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7i\2\2\u00a2\u00a3\7g\2\2\u00a3"+
		"\u00c3\7t\2\2\u00a4\u00a5\7f\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7e\2\2"+
		"\u00a7\u00a8\7k\2\2\u00a8\u00a9\7o\2\2\u00a9\u00aa\7c\2\2\u00aa\u00c3"+
		"\7n\2\2\u00ab\u00ac\7e\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7v\2\2"+
		"\u00b2\u00b3\7g\2\2\u00b3\u00c3\7t\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6"+
		"\7k\2\2\u00b6\u00b7\7i\2\2\u00b7\u00b8\7\"\2\2\u00b8\u00b9\7k\2\2\u00b9"+
		"\u00ba\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7i\2\2"+
		"\u00bd\u00be\7g\2\2\u00be\u00c3\7t\2\2\u00bf\u00c0\7r\2\2\u00c0\u00c1"+
		"\7k\2\2\u00c1\u00c3\7p\2\2\u00c2\u009d\3\2\2\2\u00c2\u00a4\3\2\2\2\u00c2"+
		"\u00ab\3\2\2\2\u00c2\u00b4\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c38\3\2\2\2"+
		"\u00c4\u00c5\7c\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8"+
		"\7c\2\2\u00c8\u00c9\7{\2\2\u00c9:\3\2\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc"+
		"\7g\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7w\2\2\u00ce\u00cf\7t\2\2\u00cf"+
		"\u00d0\7p\2\2\u00d0<\3\2\2\2\u00d1\u00d3\7/\2\2\u00d2\u00d1\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d6\4\62;\2\u00d5\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		">\3\2\2\2\u00d9\u00db\7/\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00de\4\62;\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0@\3\2\2\2\u00e1\u00e3"+
		"\7/\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e6\4\62;\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ef\3\2\2\2\u00e9\u00eb\7\60\2\2\u00ea"+
		"\u00ec\4\62;\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0B\3\2\2\2\u00f1\u00f3\t\2\2\2\u00f2\u00f1\3\2\2\2"+
		"\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f6\4\62;\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"D\3\2\2\2\u00f9\u00fa\7)\2\2\u00fa\u00fb\13\2\2\2\u00fb\u00fc\7)\2\2\u00fc"+
		"F\3\2\2\2\u00fd\u00ff\t\3\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101H\3\2\2\2\u0102\u0104\t"+
		"\4\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b%\2\2\u0108J\3\2\2\2\u0109"+
		"\u010b\7\17\2\2\u010a\u010c\7\f\2\2\u010b\u010a\3\2\2\2\u010b\u010c\3"+
		"\2\2\2\u010c\u010f\3\2\2\2\u010d\u010f\7\f\2\2\u010e\u0109\3\2\2\2\u010e"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\b&\2\2\u0111L\3\2\2\2\23"+
		"\2Q\u00c2\u00d2\u00d7\u00da\u00df\u00e2\u00e7\u00ed\u00ef\u00f2\u00f7"+
		"\u0100\u0105\u010b\u010e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}