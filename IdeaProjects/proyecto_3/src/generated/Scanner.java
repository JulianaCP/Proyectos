// Generated from C:/Users/Pruebas/IdeaProjects/proyecto_1\Scanner.g4 by ANTLR 4.6
package generated;

  import com.yuvalshavit.antlr4.DenterHelper;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Scanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, ParenIZQ=3, ParenDER=4, DosPUNTOS=5, COMA=6, DEF=7, 
		IF=8, ELSE=9, WHILE=10, RETURN=11, PRINT=12, MENOR=13, MAYOR=14, MenorIGUAL=15, 
		MayorIGUAL=16, IgualIGUAL=17, SUMA=18, RESTA=19, MULT=20, DIV=21, ParenSubIZQ=22, 
		ParenSubDER=23, NewLINE=24, IGUAL=25, LEN=26, INT=27, STRING=28, ID=29, 
		WS=30, CHAR=31, LINE_COMMENT=32, SPECIAL_COMMENT=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ParenIZQ", "ParenDER", "DosPUNTOS", "COMA", "DEF", "IF", "ELSE", "WHILE", 
		"RETURN", "PRINT", "MENOR", "MAYOR", "MenorIGUAL", "MayorIGUAL", "IgualIGUAL", 
		"SUMA", "RESTA", "MULT", "DIV", "ParenSubIZQ", "ParenSubDER", "NewLINE", 
		"IGUAL", "LEN", "INT", "STRING", "ID", "CharInicial", "CharContenido", 
		"WS", "CHAR", "LINE_COMMENT", "SPECIAL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "':'", "','", "'def'", "'if'", "'else'", 
		"'while'", "'return'", "'print'", "'<'", "'>'", "'<='", "'>='", "'=='", 
		"'+'", "'-'", "'*'", "'/'", "'['", "']'", null, "'='", "'len'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INDENT", "DEDENT", "ParenIZQ", "ParenDER", "DosPUNTOS", "COMA", 
		"DEF", "IF", "ELSE", "WHILE", "RETURN", "PRINT", "MENOR", "MAYOR", "MenorIGUAL", 
		"MayorIGUAL", "IgualIGUAL", "SUMA", "RESTA", "MULT", "DIV", "ParenSubIZQ", 
		"ParenSubDER", "NewLINE", "IGUAL", "LEN", "INT", "STRING", "ID", "WS", 
		"CHAR", "LINE_COMMENT", "SPECIAL_COMMENT"
	};
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


	  private final DenterHelper denter = DenterHelper.builder()
	    .nl(NewLINE)
	    .indent(GParser.INDENT)
	    .dedent(GParser.DEDENT)
	    .pullToken(Scanner.super::nextToken);

	  @Override
	  public Token nextToken() {
	    return denter.nextToken();
	  }


	public Scanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Scanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00ef\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\5\27\u0087\n\27\3\27\3\27\7\27\u008b\n\27\f\27\16"+
		"\27\u008e\13\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u0099"+
		"\n\32\f\32\16\32\u009c\13\32\3\32\3\32\3\32\3\32\7\32\u00a2\n\32\f\32"+
		"\16\32\u00a5\13\32\5\32\u00a7\n\32\3\33\3\33\7\33\u00ab\n\33\f\33\16\33"+
		"\u00ae\13\33\3\33\3\33\3\34\3\34\7\34\u00b4\n\34\f\34\16\34\u00b7\13\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \5 \u00d0\n \3!\3!\7!\u00d4\n!\f!\16!\u00d7\13!\3!\5!"+
		"\u00da\n!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u00e5\n\"\f\"\16\"\u00e8"+
		"\13\"\3\"\3\"\3\"\3\"\3\"\3\"\4\u00d5\u00e6\2#\3\5\5\6\7\7\t\b\13\t\r"+
		"\n\17\13\21\f\23\r\25\16\27\17\31\20\33\21\35\22\37\23!\24#\25%\26\'\27"+
		")\30+\31-\32/\33\61\34\63\35\65\36\67\379\2;\2= ?!A\"C#\3\2\b\4\2\13\13"+
		"\"\"\3\2$$\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\3\2))\u00fa\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13"+
		"M\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21Y\3\2\2\2\23_\3\2\2\2\25f\3\2\2\2\27"+
		"l\3\2\2\2\31n\3\2\2\2\33p\3\2\2\2\35s\3\2\2\2\37v\3\2\2\2!y\3\2\2\2#{"+
		"\3\2\2\2%}\3\2\2\2\'\177\3\2\2\2)\u0081\3\2\2\2+\u0083\3\2\2\2-\u0086"+
		"\3\2\2\2/\u008f\3\2\2\2\61\u0091\3\2\2\2\63\u00a6\3\2\2\2\65\u00a8\3\2"+
		"\2\2\67\u00b1\3\2\2\29\u00b8\3\2\2\2;\u00ba\3\2\2\2=\u00bc\3\2\2\2?\u00cf"+
		"\3\2\2\2A\u00d1\3\2\2\2C\u00df\3\2\2\2EF\7*\2\2F\4\3\2\2\2GH\7+\2\2H\6"+
		"\3\2\2\2IJ\7<\2\2J\b\3\2\2\2KL\7.\2\2L\n\3\2\2\2MN\7f\2\2NO\7g\2\2OP\7"+
		"h\2\2P\f\3\2\2\2QR\7k\2\2RS\7h\2\2S\16\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7u"+
		"\2\2WX\7g\2\2X\20\3\2\2\2YZ\7y\2\2Z[\7j\2\2[\\\7k\2\2\\]\7n\2\2]^\7g\2"+
		"\2^\22\3\2\2\2_`\7t\2\2`a\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2de\7p\2\2e"+
		"\24\3\2\2\2fg\7r\2\2gh\7t\2\2hi\7k\2\2ij\7p\2\2jk\7v\2\2k\26\3\2\2\2l"+
		"m\7>\2\2m\30\3\2\2\2no\7@\2\2o\32\3\2\2\2pq\7>\2\2qr\7?\2\2r\34\3\2\2"+
		"\2st\7@\2\2tu\7?\2\2u\36\3\2\2\2vw\7?\2\2wx\7?\2\2x \3\2\2\2yz\7-\2\2"+
		"z\"\3\2\2\2{|\7/\2\2|$\3\2\2\2}~\7,\2\2~&\3\2\2\2\177\u0080\7\61\2\2\u0080"+
		"(\3\2\2\2\u0081\u0082\7]\2\2\u0082*\3\2\2\2\u0083\u0084\7_\2\2\u0084,"+
		"\3\2\2\2\u0085\u0087\7\17\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\u008c\7\f\2\2\u0089\u008b\t\2\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		".\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7?\2\2\u0090\60\3\2\2\2\u0091"+
		"\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093\u0094\7p\2\2\u0094\62\3\2\2\2\u0095"+
		"\u00a7\7\62\2\2\u0096\u009a\4\63;\2\u0097\u0099\4\62;\2\u0098\u0097\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u00a7\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\4\62;\2\u009e\u009f\7\60"+
		"\2\2\u009f\u00a3\4\62;\2\u00a0\u00a2\4\62;\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u0095\3\2\2\2\u00a6\u0096\3\2\2\2\u00a6"+
		"\u009d\3\2\2\2\u00a7\64\3\2\2\2\u00a8\u00ac\7$\2\2\u00a9\u00ab\n\3\2\2"+
		"\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7$\2\2\u00b0"+
		"\66\3\2\2\2\u00b1\u00b5\59\35\2\u00b2\u00b4\5;\36\2\u00b3\u00b2\3\2\2"+
		"\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b68"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\t\4\2\2\u00b9:\3\2\2\2\u00ba"+
		"\u00bb\t\5\2\2\u00bb<\3\2\2\2\u00bc\u00bd\t\6\2\2\u00bd\u00be\3\2\2\2"+
		"\u00be\u00bf\b\37\2\2\u00bf>\3\2\2\2\u00c0\u00c1\t\7\2\2\u00c1\u00c2\n"+
		"\7\2\2\u00c2\u00d0\t\7\2\2\u00c3\u00c4\t\7\2\2\u00c4\u00c5\7^\2\2\u00c5"+
		"\u00c6\7p\2\2\u00c6\u00d0\t\7\2\2\u00c7\u00c8\t\7\2\2\u00c8\u00c9\7^\2"+
		"\2\u00c9\u00ca\7v\2\2\u00ca\u00d0\t\7\2\2\u00cb\u00cc\t\7\2\2\u00cc\u00cd"+
		"\7^\2\2\u00cd\u00ce\7t\2\2\u00ce\u00d0\t\7\2\2\u00cf\u00c0\3\2\2\2\u00cf"+
		"\u00c3\3\2\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0@\3\2\2\2"+
		"\u00d1\u00d5\7%\2\2\u00d2\u00d4\13\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00da\7\17\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3"+
		"\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\f\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\b!\2\2\u00deB\3\2\2\2\u00df\u00e0\7$\2\2\u00e0\u00e1\7$\2\2\u00e1"+
		"\u00e2\7$\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7$\2\2\u00ea\u00eb\7$\2"+
		"\2\u00eb\u00ec\7$\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\"\2\2\u00eeD\3"+
		"\2\2\2\16\2\u0086\u008c\u009a\u00a3\u00a6\u00ac\u00b5\u00cf\u00d5\u00d9"+
		"\u00e6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}