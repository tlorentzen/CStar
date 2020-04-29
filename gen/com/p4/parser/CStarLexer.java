// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
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
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LEFT_PAREN=13, RIGHT_PAREN=14, 
		LEFT_BRACKET=15, RIGHT_BRACKET=16, LEFT_BRACE=17, RIGHT_BRACE=18, SEMICOLON=19, 
		DOT=20, IF=21, ELSE=22, WHILE=23, REPEAT=24, COMMA=25, VOID=26, TYPE=27, 
		ARRAY=28, RETURN=29, INT_LITERAL=30, LONG_LITERAL=31, FLOAT_LITERAL=32, 
		PIN_LITERAL=33, CHAR_LITERAL=34, ID=35, FUNCID=36, WHITESPACE=37, Newline=38;
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
			"ID", "FUNCID", "WHITESPACE", "Newline"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0118\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\5\2T\n\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00c6\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\6\37\u00d6\n\37"+
		"\r\37\16\37\u00d7\3 \6 \u00db\n \r \16 \u00dc\3!\6!\u00e0\n!\r!\16!\u00e1"+
		"\3!\3!\6!\u00e6\n!\r!\16!\u00e7\5!\u00ea\n!\3\"\5\"\u00ed\n\"\3\"\6\""+
		"\u00f0\n\"\r\"\16\"\u00f1\3#\3#\3#\3#\3$\6$\u00f9\n$\r$\16$\u00fa\3%\6"+
		"%\u00fe\n%\r%\16%\u00ff\3%\5%\u0103\n%\6%\u0105\n%\r%\16%\u0106\3&\6&"+
		"\u010a\n&\r&\16&\u010b\3&\3&\3\'\3\'\5\'\u0112\n\'\3\'\5\'\u0115\n\'\3"+
		"\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\5\4\2CCcc\6\2\62;C\\aac|\4\2\13\13"+
		"\"\"\2\u012c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7"+
		"W\3\2\2\2\tY\3\2\2\2\13\\\3\2\2\2\rb\3\2\2\2\17e\3\2\2\2\21i\3\2\2\2\23"+
		"k\3\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33s\3\2\2\2\35u\3\2\2\2"+
		"\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2%}\3\2\2\2\'\177\3\2\2\2)\u0081\3\2\2"+
		"\2+\u0083\3\2\2\2-\u0086\3\2\2\2/\u008b\3\2\2\2\61\u0091\3\2\2\2\63\u0098"+
		"\3\2\2\2\65\u009a\3\2\2\2\67\u00c5\3\2\2\29\u00c7\3\2\2\2;\u00cd\3\2\2"+
		"\2=\u00d5\3\2\2\2?\u00da\3\2\2\2A\u00df\3\2\2\2C\u00ec\3\2\2\2E\u00f3"+
		"\3\2\2\2G\u00f8\3\2\2\2I\u0104\3\2\2\2K\u0109\3\2\2\2M\u0114\3\2\2\2O"+
		"T\5\5\3\2PT\5\7\4\2QT\5\t\5\2RT\5\13\6\2SO\3\2\2\2SP\3\2\2\2SQ\3\2\2\2"+
		"SR\3\2\2\2T\4\3\2\2\2UV\7>\2\2V\6\3\2\2\2WX\7@\2\2X\b\3\2\2\2YZ\7K\2\2"+
		"Z[\7U\2\2[\n\3\2\2\2\\]\7K\2\2]^\7U\2\2^_\7P\2\2_`\7Q\2\2`a\7V\2\2a\f"+
		"\3\2\2\2bc\7Q\2\2cd\7T\2\2d\16\3\2\2\2ef\7C\2\2fg\7P\2\2gh\7F\2\2h\20"+
		"\3\2\2\2ij\7?\2\2j\22\3\2\2\2kl\7-\2\2l\24\3\2\2\2mn\7/\2\2n\26\3\2\2"+
		"\2op\7,\2\2p\30\3\2\2\2qr\7\61\2\2r\32\3\2\2\2st\7*\2\2t\34\3\2\2\2uv"+
		"\7+\2\2v\36\3\2\2\2wx\7]\2\2x \3\2\2\2yz\7_\2\2z\"\3\2\2\2{|\7}\2\2|$"+
		"\3\2\2\2}~\7\177\2\2~&\3\2\2\2\177\u0080\7=\2\2\u0080(\3\2\2\2\u0081\u0082"+
		"\7\60\2\2\u0082*\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085\7h\2\2\u0085,"+
		"\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089"+
		"\u008a\7g\2\2\u008a.\3\2\2\2\u008b\u008c\7y\2\2\u008c\u008d\7j\2\2\u008d"+
		"\u008e\7k\2\2\u008e\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090\60\3\2\2\2\u0091"+
		"\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093\u0094\7r\2\2\u0094\u0095\7g\2\2"+
		"\u0095\u0096\7c\2\2\u0096\u0097\7v\2\2\u0097\62\3\2\2\2\u0098\u0099\7"+
		".\2\2\u0099\64\3\2\2\2\u009a\u009b\7x\2\2\u009b\u009c\7q\2\2\u009c\u009d"+
		"\7k\2\2\u009d\u009e\7f\2\2\u009e\66\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1"+
		"\7p\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7i\2\2\u00a4"+
		"\u00a5\7g\2\2\u00a5\u00c6\7t\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8\7g\2\2"+
		"\u00a8\u00a9\7e\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7o\2\2\u00ab\u00ac"+
		"\7c\2\2\u00ac\u00c6\7n\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7j\2\2\u00af"+
		"\u00b0\7c\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7e\2\2"+
		"\u00b3\u00b4\7v\2\2\u00b4\u00b5\7g\2\2\u00b5\u00c6\7t\2\2\u00b6\u00b7"+
		"\7n\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7i\2\2\u00ba"+
		"\u00bb\7\"\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7v\2"+
		"\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7i\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c6"+
		"\7t\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c6\7p\2\2\u00c5"+
		"\u009f\3\2\2\2\u00c5\u00a6\3\2\2\2\u00c5\u00ad\3\2\2\2\u00c5\u00b6\3\2"+
		"\2\2\u00c5\u00c2\3\2\2\2\u00c68\3\2\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9"+
		"\7t\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7{\2\2\u00cc"+
		":\3\2\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7v\2\2\u00d0"+
		"\u00d1\7w\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7p\2\2\u00d3<\3\2\2\2\u00d4"+
		"\u00d6\4\62;\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8>\3\2\2\2\u00d9\u00db\4\62;\2\u00da\u00d9"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"@\3\2\2\2\u00de\u00e0\4\62;\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e9\3\2\2\2\u00e3\u00e5"+
		"\7\60\2\2\u00e4\u00e6\4\62;\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2"+
		"\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e3"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00eaB\3\2\2\2\u00eb\u00ed\t\2\2\2\u00ec"+
		"\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\4\62"+
		";\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2D\3\2\2\2\u00f3\u00f4\7)\2\2\u00f4\u00f5\13\2\2\2"+
		"\u00f5\u00f6\7)\2\2\u00f6F\3\2\2\2\u00f7\u00f9\t\3\2\2\u00f8\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"H\3\2\2\2\u00fc\u00fe\t\3\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u0103"+
		"\7\60\2\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2"+
		"\u0104\u00fd\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107J\3\2\2\2\u0108\u010a\t\4\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010e\b&\2\2\u010eL\3\2\2\2\u010f\u0111\7\17\2\2\u0110\u0112"+
		"\7\f\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0115\7\f\2\2\u0114\u010f\3\2\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\b\'\2\2\u0117N\3\2\2\2\23\2S\u00c5\u00d7\u00dc\u00e1"+
		"\u00e7\u00e9\u00ec\u00f1\u00fa\u00ff\u0102\u0106\u010b\u0111\u0114\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}