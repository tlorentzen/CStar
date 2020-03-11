// Generated from /Users/lenasaid/Desktop/Desktop/OneDrive/Uni/Semester 4/PSS/P4/ANTLR/parser/Lexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ASSIGN_OP=8, 
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LEFT_PAREN=13, RIGHT_PAREN=14, 
		LEFT_BRACKET=15, RIGHT_BRACKET=16, LEFT_BRACE=17, RIGHT_BRACE=18, SEMICOLON=19, 
		IF=20, ELSE=21, WHILE=22, REPEAT=23, COMMA=24, VOID=25, ID=26, INT_LITERAL=27, 
		LONG_LITERAL=28, FLOAT_LITERAL=29, CHAR_LITERAL=30, PIN_LITERAL=31, TYPE=32;
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
			"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "IF", "ELSE", 
			"WHILE", "REPEAT", "COMMA", "VOID", "ID", "INT_LITERAL", "LONG_LITERAL", 
			"FLOAT_LITERAL", "CHAR_LITERAL", "PIN_LITERAL", "TYPE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "'if'", "'else'", "'while'", "'repeat'", "','", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", 
			"IF", "ELSE", "WHILE", "REPEAT", "COMMA", "VOID", "ID", "INT_LITERAL", 
			"LONG_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "PIN_LITERAL", "TYPE"
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


	public LexerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\5\2H\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\6\33\u0093\n\33\r\33\16\33\u0094\3\34\5\34\u0098\n\34"+
		"\3\34\6\34\u009b\n\34\r\34\16\34\u009c\3\35\5\35\u00a0\n\35\3\35\6\35"+
		"\u00a3\n\35\r\35\16\35\u00a4\3\36\5\36\u00a8\n\36\3\36\6\36\u00ab\n\36"+
		"\r\36\16\36\u00ac\3\36\3\36\6\36\u00b1\n\36\r\36\16\36\u00b2\5\36\u00b5"+
		"\n\36\3\37\3\37\3\37\3\37\3 \5 \u00bc\n \3 \6 \u00bf\n \r \16 \u00c0\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u00e8\n!\2\2\"\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\4"+
		"\7\2//\62;C\\aac|\4\2CCcc\2\u00fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13P\3\2\2\2\rV\3\2\2\2"+
		"\17Y\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25a\3\2\2\2\27c\3\2\2\2\31e\3\2\2"+
		"\2\33g\3\2\2\2\35i\3\2\2\2\37k\3\2\2\2!m\3\2\2\2#o\3\2\2\2%q\3\2\2\2\'"+
		"s\3\2\2\2)u\3\2\2\2+x\3\2\2\2-}\3\2\2\2/\u0083\3\2\2\2\61\u008a\3\2\2"+
		"\2\63\u008c\3\2\2\2\65\u0092\3\2\2\2\67\u0097\3\2\2\29\u009f\3\2\2\2;"+
		"\u00a7\3\2\2\2=\u00b6\3\2\2\2?\u00bb\3\2\2\2A\u00e7\3\2\2\2CH\5\5\3\2"+
		"DH\5\7\4\2EH\5\t\5\2FH\5\13\6\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2"+
		"\2H\4\3\2\2\2IJ\7>\2\2J\6\3\2\2\2KL\7@\2\2L\b\3\2\2\2MN\7K\2\2NO\7U\2"+
		"\2O\n\3\2\2\2PQ\7K\2\2QR\7U\2\2RS\7P\2\2ST\7Q\2\2TU\7V\2\2U\f\3\2\2\2"+
		"VW\7Q\2\2WX\7T\2\2X\16\3\2\2\2YZ\7C\2\2Z[\7P\2\2[\\\7F\2\2\\\20\3\2\2"+
		"\2]^\7?\2\2^\22\3\2\2\2_`\7-\2\2`\24\3\2\2\2ab\7/\2\2b\26\3\2\2\2cd\7"+
		",\2\2d\30\3\2\2\2ef\7\61\2\2f\32\3\2\2\2gh\7*\2\2h\34\3\2\2\2ij\7+\2\2"+
		"j\36\3\2\2\2kl\7}\2\2l \3\2\2\2mn\7\177\2\2n\"\3\2\2\2op\7]\2\2p$\3\2"+
		"\2\2qr\7_\2\2r&\3\2\2\2st\7=\2\2t(\3\2\2\2uv\7k\2\2vw\7h\2\2w*\3\2\2\2"+
		"xy\7g\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2|,\3\2\2\2}~\7y\2\2~\177\7j\2\2\177"+
		"\u0080\7k\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082.\3\2\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086\7r\2\2\u0086\u0087\7g\2\2"+
		"\u0087\u0088\7c\2\2\u0088\u0089\7v\2\2\u0089\60\3\2\2\2\u008a\u008b\7"+
		".\2\2\u008b\62\3\2\2\2\u008c\u008d\7x\2\2\u008d\u008e\7q\2\2\u008e\u008f"+
		"\7k\2\2\u008f\u0090\7f\2\2\u0090\64\3\2\2\2\u0091\u0093\t\2\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\66\3\2\2\2\u0096\u0098\7/\2\2\u0097\u0096\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u009b\4\62;\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d8\3\2\2\2"+
		"\u009e\u00a0\7/\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2"+
		"\3\2\2\2\u00a1\u00a3\4\62;\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5:\3\2\2\2\u00a6\u00a8\7/\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab\4\62"+
		";\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b0\7\60\2\2\u00af\u00b1\4"+
		"\62;\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5<\3\2\2\2\u00b6\u00b7\7)\2\2\u00b7\u00b8\13\2\2\2\u00b8\u00b9"+
		"\7)\2\2\u00b9>\3\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1@\3\2\2\2"+
		"\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6"+
		"\7g\2\2\u00c6\u00c7\7i\2\2\u00c7\u00c8\7g\2\2\u00c8\u00e8\7t\2\2\u00c9"+
		"\u00ca\7f\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7k\2\2"+
		"\u00cd\u00ce\7o\2\2\u00ce\u00cf\7c\2\2\u00cf\u00e8\7n\2\2\u00d0\u00d1"+
		"\7e\2\2\u00d1\u00d2\7j\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7t\2\2\u00d4"+
		"\u00d5\7c\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7g\2\2"+
		"\u00d8\u00e8\7t\2\2\u00d9\u00da\7d\2\2\u00da\u00db\7k\2\2\u00db\u00dc"+
		"\7i\2\2\u00dc\u00dd\7\"\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7p\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7g\2\2"+
		"\u00e3\u00e8\7t\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e8"+
		"\7p\2\2\u00e7\u00c2\3\2\2\2\u00e7\u00c9\3\2\2\2\u00e7\u00d0\3\2\2\2\u00e7"+
		"\u00d9\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8B\3\2\2\2\20\2G\u0094\u0097\u009c"+
		"\u009f\u00a4\u00a7\u00ac\u00b2\u00b4\u00bb\u00c0\u00e7\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}