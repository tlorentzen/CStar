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
		COMP_OP=1, LESS_THAN=2, GREATER_THAN=3, IS=4, ISNOT=5, OR=6, AND=7, ASSIGN_OP=8, 
		PLUS=9, MINUS=10, MULT=11, DIVISION=12, LESS_THAN_EQ=13, GREATER_THAN_EQ=14, 
		MODULO=15, LEFT_PAREN=16, RIGHT_PAREN=17, LEFT_BRACKET=18, RIGHT_BRACKET=19, 
		LEFT_BRACE=20, RIGHT_BRACE=21, SEMICOLON=22, DOT=23, IF=24, ELSE=25, WHILE=26, 
		REPEAT=27, COMMA=28, VOID=29, TYPE=30, ARRAY=31, RETURN=32, PRINT=33, 
		HIGH=34, LOW=35, NUMBER=36, BOOLEAN_LITERAL=37, PIN_LITERAL=38, CHAR_LITERAL=39, 
		STRING_LITERAL=40, ID=41, FUNCID=42, WHITESPACE=43, Newline=44, LINE_COMMENT=45, 
		INCLUDE=46, HEADER=47;
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
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "HIGH", 
			"LOW", "NUMBER", "BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", 
			"ID", "FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT", "INCLUDE", "HEADER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<'", "'>'", "'IS'", "'ISNOT'", "'OR'", "'AND'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'<='", "'>='", "'%'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "';'", "'.'", "'if'", "'else'", "'while'", "'repeat'", 
			"','", "'void'", null, "'array'", "'return'", "'console.print'", "'HIGH'", 
			"'LOW'", null, null, null, null, null, null, null, null, null, null, 
			"'#include'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMP_OP", "LESS_THAN", "GREATER_THAN", "IS", "ISNOT", "OR", "AND", 
			"ASSIGN_OP", "PLUS", "MINUS", "MULT", "DIVISION", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"MODULO", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_BRACE", "RIGHT_BRACE", "SEMICOLON", "DOT", "IF", "ELSE", "WHILE", 
			"REPEAT", "COMMA", "VOID", "TYPE", "ARRAY", "RETURN", "PRINT", "HIGH", 
			"LOW", "NUMBER", "BOOLEAN_LITERAL", "PIN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", 
			"ID", "FUNCID", "WHITESPACE", "Newline", "LINE_COMMENT", "INCLUDE", "HEADER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0182\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\5\2h\n\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00f6\n\37\3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\6%\u011d\n%\r%\16%\u011e\3"+
		"%\3%\6%\u0123\n%\r%\16%\u0124\5%\u0127\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5"+
		"&\u0132\n&\3\'\5\'\u0135\n\'\3\'\6\'\u0138\n\'\r\'\16\'\u0139\3(\3(\3"+
		"(\3(\3)\3)\7)\u0142\n)\f)\16)\u0145\13)\3)\3)\3*\6*\u014a\n*\r*\16*\u014b"+
		"\3+\6+\u014f\n+\r+\16+\u0150\3+\5+\u0154\n+\6+\u0156\n+\r+\16+\u0157\3"+
		",\6,\u015b\n,\r,\16,\u015c\3,\3,\3-\3-\5-\u0163\n-\3-\5-\u0166\n-\3-\3"+
		"-\3.\3.\3.\3.\7.\u016e\n.\f.\16.\u0171\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3\60\3\60\3\60\5\60\u017f\n\60\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61\3\2\7\4\2CCcc\5\2\f\f\17\17$$\6\2\62;C\\aac|\4\2"+
		"\13\13\"\"\4\2\f\f\17\17\2\u019c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\3g\3\2\2\2\5i\3\2\2\2\7k\3\2\2\2\tm\3\2\2\2"+
		"\13p\3\2\2\2\rv\3\2\2\2\17y\3\2\2\2\21}\3\2\2\2\23\177\3\2\2\2\25\u0081"+
		"\3\2\2\2\27\u0083\3\2\2\2\31\u0085\3\2\2\2\33\u0087\3\2\2\2\35\u008a\3"+
		"\2\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'"+
		"\u0095\3\2\2\2)\u0097\3\2\2\2+\u0099\3\2\2\2-\u009b\3\2\2\2/\u009d\3\2"+
		"\2\2\61\u009f\3\2\2\2\63\u00a2\3\2\2\2\65\u00a7\3\2\2\2\67\u00ad\3\2\2"+
		"\29\u00b4\3\2\2\2;\u00b6\3\2\2\2=\u00f5\3\2\2\2?\u00f7\3\2\2\2A\u00fd"+
		"\3\2\2\2C\u0104\3\2\2\2E\u0112\3\2\2\2G\u0117\3\2\2\2I\u011c\3\2\2\2K"+
		"\u0131\3\2\2\2M\u0134\3\2\2\2O\u013b\3\2\2\2Q\u013f\3\2\2\2S\u0149\3\2"+
		"\2\2U\u0155\3\2\2\2W\u015a\3\2\2\2Y\u0165\3\2\2\2[\u0169\3\2\2\2]\u0172"+
		"\3\2\2\2_\u017b\3\2\2\2ah\5\5\3\2bh\5\7\4\2ch\5\t\5\2dh\5\13\6\2eh\5\33"+
		"\16\2fh\5\35\17\2ga\3\2\2\2gb\3\2\2\2gc\3\2\2\2gd\3\2\2\2ge\3\2\2\2gf"+
		"\3\2\2\2h\4\3\2\2\2ij\7>\2\2j\6\3\2\2\2kl\7@\2\2l\b\3\2\2\2mn\7K\2\2n"+
		"o\7U\2\2o\n\3\2\2\2pq\7K\2\2qr\7U\2\2rs\7P\2\2st\7Q\2\2tu\7V\2\2u\f\3"+
		"\2\2\2vw\7Q\2\2wx\7T\2\2x\16\3\2\2\2yz\7C\2\2z{\7P\2\2{|\7F\2\2|\20\3"+
		"\2\2\2}~\7?\2\2~\22\3\2\2\2\177\u0080\7-\2\2\u0080\24\3\2\2\2\u0081\u0082"+
		"\7/\2\2\u0082\26\3\2\2\2\u0083\u0084\7,\2\2\u0084\30\3\2\2\2\u0085\u0086"+
		"\7\61\2\2\u0086\32\3\2\2\2\u0087\u0088\7>\2\2\u0088\u0089\7?\2\2\u0089"+
		"\34\3\2\2\2\u008a\u008b\7@\2\2\u008b\u008c\7?\2\2\u008c\36\3\2\2\2\u008d"+
		"\u008e\7\'\2\2\u008e \3\2\2\2\u008f\u0090\7*\2\2\u0090\"\3\2\2\2\u0091"+
		"\u0092\7+\2\2\u0092$\3\2\2\2\u0093\u0094\7]\2\2\u0094&\3\2\2\2\u0095\u0096"+
		"\7_\2\2\u0096(\3\2\2\2\u0097\u0098\7}\2\2\u0098*\3\2\2\2\u0099\u009a\7"+
		"\177\2\2\u009a,\3\2\2\2\u009b\u009c\7=\2\2\u009c.\3\2\2\2\u009d\u009e"+
		"\7\60\2\2\u009e\60\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1"+
		"\62\3\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7u\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7j\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\66\3\2\2\2\u00ad"+
		"\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7r\2\2\u00b0\u00b1\7g\2\2"+
		"\u00b1\u00b2\7c\2\2\u00b2\u00b3\7v\2\2\u00b38\3\2\2\2\u00b4\u00b5\7.\2"+
		"\2\u00b5:\3\2\2\2\u00b6\u00b7\7x\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7"+
		"k\2\2\u00b9\u00ba\7f\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd"+
		"\7p\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7i\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\u00f6\7t\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7g\2\2"+
		"\u00c4\u00c5\7e\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7o\2\2\u00c7\u00c8"+
		"\7c\2\2\u00c8\u00f6\7n\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7j\2\2\u00cb"+
		"\u00cc\7c\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7e\2\2"+
		"\u00cf\u00d0\7v\2\2\u00d0\u00d1\7g\2\2\u00d1\u00f6\7t\2\2\u00d2\u00d3"+
		"\7n\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7i\2\2\u00d6"+
		"\u00d7\7\"\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7v\2"+
		"\2\u00da\u00db\7g\2\2\u00db\u00dc\7i\2\2\u00dc\u00dd\7g\2\2\u00dd\u00f6"+
		"\7t\2\2\u00de\u00df\7u\2\2\u00df\u00e0\7o\2\2\u00e0\u00e1\7c\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7\"\2\2\u00e4\u00e5\7k\2"+
		"\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9"+
		"\7i\2\2\u00e9\u00ea\7g\2\2\u00ea\u00f6\7t\2\2\u00eb\u00ec\7r\2\2\u00ec"+
		"\u00ed\7k\2\2\u00ed\u00f6\7p\2\2\u00ee\u00ef\7d\2\2\u00ef\u00f0\7q\2\2"+
		"\u00f0\u00f1\7q\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4"+
		"\7c\2\2\u00f4\u00f6\7p\2\2\u00f5\u00bb\3\2\2\2\u00f5\u00c2\3\2\2\2\u00f5"+
		"\u00c9\3\2\2\2\u00f5\u00d2\3\2\2\2\u00f5\u00de\3\2\2\2\u00f5\u00eb\3\2"+
		"\2\2\u00f5\u00ee\3\2\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9"+
		"\7t\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7{\2\2\u00fc"+
		"@\3\2\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7v\2\2\u0100"+
		"\u0101\7w\2\2\u0101\u0102\7t\2\2\u0102\u0103\7p\2\2\u0103B\3\2\2\2\u0104"+
		"\u0105\7e\2\2\u0105\u0106\7q\2\2\u0106\u0107\7p\2\2\u0107\u0108\7u\2\2"+
		"\u0108\u0109\7q\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2\u010b\u010c"+
		"\7\60\2\2\u010c\u010d\7r\2\2\u010d\u010e\7t\2\2\u010e\u010f\7k\2\2\u010f"+
		"\u0110\7p\2\2\u0110\u0111\7v\2\2\u0111D\3\2\2\2\u0112\u0113\7J\2\2\u0113"+
		"\u0114\7K\2\2\u0114\u0115\7I\2\2\u0115\u0116\7J\2\2\u0116F\3\2\2\2\u0117"+
		"\u0118\7N\2\2\u0118\u0119\7Q\2\2\u0119\u011a\7Y\2\2\u011aH\3\2\2\2\u011b"+
		"\u011d\4\62;\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0126\3\2\2\2\u0120\u0122\7\60\2\2\u0121"+
		"\u0123\4\62;\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0120\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127J\3\2\2\2\u0128\u0129\7v\2\2\u0129\u012a\7t\2\2\u012a"+
		"\u012b\7w\2\2\u012b\u0132\7g\2\2\u012c\u012d\7h\2\2\u012d\u012e\7c\2\2"+
		"\u012e\u012f\7n\2\2\u012f\u0130\7u\2\2\u0130\u0132\7g\2\2\u0131\u0128"+
		"\3\2\2\2\u0131\u012c\3\2\2\2\u0132L\3\2\2\2\u0133\u0135\t\2\2\2\u0134"+
		"\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0138\4\62"+
		";\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013aN\3\2\2\2\u013b\u013c\7)\2\2\u013c\u013d\13\2\2\2"+
		"\u013d\u013e\7)\2\2\u013eP\3\2\2\2\u013f\u0143\7$\2\2\u0140\u0142\n\3"+
		"\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7$"+
		"\2\2\u0147R\3\2\2\2\u0148\u014a\t\4\2\2\u0149\u0148\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014cT\3\2\2\2\u014d"+
		"\u014f\t\4\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0154\7\60\2\2\u0153"+
		"\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u014e\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"V\3\2\2\2\u0159\u015b\t\5\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2"+
		"\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f"+
		"\b,\2\2\u015fX\3\2\2\2\u0160\u0162\7\17\2\2\u0161\u0163\7\f\2\2\u0162"+
		"\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0166\7\f"+
		"\2\2\u0165\u0160\3\2\2\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u0168\b-\2\2\u0168Z\3\2\2\2\u0169\u016a\7\61\2\2\u016a\u016b\7\61\2\2"+
		"\u016b\u016f\3\2\2\2\u016c\u016e\n\6\2\2\u016d\u016c\3\2\2\2\u016e\u0171"+
		"\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\\\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0172\u0173\7%\2\2\u0173\u0174\7k\2\2\u0174\u0175\7p\2"+
		"\2\u0175\u0176\7e\2\2\u0176\u0177\7n\2\2\u0177\u0178\7w\2\2\u0178\u0179"+
		"\7f\2\2\u0179\u017a\7g\2\2\u017a^\3\2\2\2\u017b\u017e\7>\2\2\u017c\u017f"+
		"\5S*\2\u017d\u017f\5U+\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\7@\2\2\u0181`\3\2\2\2\25\2g\u00f5\u011e\u0124"+
		"\u0126\u0131\u0134\u0139\u0143\u014b\u0150\u0153\u0157\u015c\u0162\u0165"+
		"\u016f\u017e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}