// Generated from C:/Users/Niels/Documents/GitHub/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
package com.p4.parser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

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
		PIN_LITERAL=33, CHAR_LITERAL=34, SIGN=35, ID=36, FUNCID=37, WHITESPACE=38, 
		Newline=39;
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
			"SIGN", "ID", "FUNCID", "WHITESPACE", "Newline"
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
			"CHAR_LITERAL", "SIGN", "ID", "FUNCID", "WHITESPACE", "Newline"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u011b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\5\2"+
		"V\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00c7\n\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\6\37\u00d7"+
		"\n\37\r\37\16\37\u00d8\3 \6 \u00dc\n \r \16 \u00dd\3!\6!\u00e1\n!\r!\16"+
		"!\u00e2\3!\3!\6!\u00e7\n!\r!\16!\u00e8\5!\u00eb\n!\3\"\5\"\u00ee\n\"\3"+
		"\"\6\"\u00f1\n\"\r\"\16\"\u00f2\3#\3#\3#\3#\3$\3$\3%\6%\u00fc\n%\r%\16"+
		"%\u00fd\3&\6&\u0101\n&\r&\16&\u0102\3&\5&\u0106\n&\6&\u0108\n&\r&\16&"+
		"\u0109\3\'\6\'\u010d\n\'\r\'\16\'\u010e\3\'\3\'\3(\3(\5(\u0115\n(\3(\5"+
		"(\u0118\n(\3(\3(\2\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\6\4\2CCcc\4\2--//\6\2\62"+
		";C\\aac|\4\2\13\13\"\"\2\u012f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7Y\3\2\2\2\t[\3\2\2\2\13^\3\2\2\2\rd\3\2"+
		"\2\2\17g\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3"+
		"\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%\177\3"+
		"\2\2\2\'\u0081\3\2\2\2)\u0083\3\2\2\2+\u0085\3\2\2\2-\u0088\3\2\2\2/\u008d"+
		"\3\2\2\2\61\u0093\3\2\2\2\63\u009a\3\2\2\2\65\u009c\3\2\2\2\67\u00c6\3"+
		"\2\2\29\u00c8\3\2\2\2;\u00ce\3\2\2\2=\u00d6\3\2\2\2?\u00db\3\2\2\2A\u00e0"+
		"\3\2\2\2C\u00ed\3\2\2\2E\u00f4\3\2\2\2G\u00f8\3\2\2\2I\u00fb\3\2\2\2K"+
		"\u0107\3\2\2\2M\u010c\3\2\2\2O\u0117\3\2\2\2QV\5\5\3\2RV\5\7\4\2SV\5\t"+
		"\5\2TV\5\13\6\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\4\3\2\2\2WX\7"+
		">\2\2X\6\3\2\2\2YZ\7@\2\2Z\b\3\2\2\2[\\\7K\2\2\\]\7U\2\2]\n\3\2\2\2^_"+
		"\7K\2\2_`\7U\2\2`a\7P\2\2ab\7Q\2\2bc\7V\2\2c\f\3\2\2\2de\7Q\2\2ef\7T\2"+
		"\2f\16\3\2\2\2gh\7C\2\2hi\7P\2\2ij\7F\2\2j\20\3\2\2\2kl\7?\2\2l\22\3\2"+
		"\2\2mn\7-\2\2n\24\3\2\2\2op\7/\2\2p\26\3\2\2\2qr\7,\2\2r\30\3\2\2\2st"+
		"\7\61\2\2t\32\3\2\2\2uv\7*\2\2v\34\3\2\2\2wx\7+\2\2x\36\3\2\2\2yz\7]\2"+
		"\2z \3\2\2\2{|\7_\2\2|\"\3\2\2\2}~\7}\2\2~$\3\2\2\2\177\u0080\7\177\2"+
		"\2\u0080&\3\2\2\2\u0081\u0082\7=\2\2\u0082(\3\2\2\2\u0083\u0084\7\60\2"+
		"\2\u0084*\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087,\3\2\2\2"+
		"\u0088\u0089\7g\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008c"+
		"\7g\2\2\u008c.\3\2\2\2\u008d\u008e\7y\2\2\u008e\u008f\7j\2\2\u008f\u0090"+
		"\7k\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\60\3\2\2\2\u0093\u0094"+
		"\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7r\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7c\2\2\u0098\u0099\7v\2\2\u0099\62\3\2\2\2\u009a\u009b\7.\2\2\u009b"+
		"\64\3\2\2\2\u009c\u009d\7x\2\2\u009d\u009e\7q\2\2\u009e\u009f\7k\2\2\u009f"+
		"\u00a0\7f\2\2\u00a0\66\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3"+
		"\u00a4\7v\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7i\2\2\u00a6\u00a7\7g\2\2"+
		"\u00a7\u00c7\7t\2\2\u00a8\u00a9\7f\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7e\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7o\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00c7\7n\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7c\2\2"+
		"\u00b2\u00b3\7t\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6"+
		"\7v\2\2\u00b6\u00b7\7g\2\2\u00b7\u00c7\7t\2\2\u00b8\u00b9\7d\2\2\u00b9"+
		"\u00ba\7k\2\2\u00ba\u00bb\7i\2\2\u00bb\u00bc\7\"\2\2\u00bc\u00bd\7k\2"+
		"\2\u00bd\u00be\7p\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1"+
		"\7i\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c7\7t\2\2\u00c3\u00c4\7r\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c7\7p\2\2\u00c6\u00a1\3\2\2\2\u00c6\u00a8\3\2\2"+
		"\2\u00c6\u00af\3\2\2\2\u00c6\u00b8\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c78"+
		"\3\2\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7t\2\2\u00cb"+
		"\u00cc\7c\2\2\u00cc\u00cd\7{\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7t\2\2\u00cf"+
		"\u00d0\7g\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7t\2\2"+
		"\u00d3\u00d4\7p\2\2\u00d4<\3\2\2\2\u00d5\u00d7\4\62;\2\u00d6\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		">\3\2\2\2\u00da\u00dc\4\62;\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2"+
		"\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de@\3\2\2\2\u00df\u00e1\4"+
		"\62;\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00ea\3\2\2\2\u00e4\u00e6\7\60\2\2\u00e5\u00e7\4"+
		"\62;\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00ebB\3\2\2\2\u00ec\u00ee\t\2\2\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\4\62;\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3D\3\2\2\2"+
		"\u00f4\u00f5\7)\2\2\u00f5\u00f6\13\2\2\2\u00f6\u00f7\7)\2\2\u00f7F\3\2"+
		"\2\2\u00f8\u00f9\t\3\2\2\u00f9H\3\2\2\2\u00fa\u00fc\t\4\2\2\u00fb\u00fa"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"J\3\2\2\2\u00ff\u0101\t\4\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2"+
		"\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0106"+
		"\7\60\2\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2"+
		"\u0107\u0100\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010aL\3\2\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0111\b\'\2\2\u0111N\3\2\2\2\u0112\u0114\7\17\2\2\u0113\u0115"+
		"\7\f\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0118\7\f\2\2\u0117\u0112\3\2\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011a\b(\2\2\u011aP\3\2\2\2\23\2U\u00c6\u00d8\u00dd\u00e2\u00e8"+
		"\u00ea\u00ed\u00f2\u00fd\u0102\u0105\u0109\u010e\u0114\u0117\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}