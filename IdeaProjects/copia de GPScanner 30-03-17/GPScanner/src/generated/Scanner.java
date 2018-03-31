// Generated from C:/Users/Pruebas/IdeaProjects/GPScanner\Scanner.g4 by ANTLR 4.6
package generated;
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
		INT=1, STRING=2, PyCOMA=3, COMA=4, ASIGN=5, PIZQ=6, PDER=7, SUMA=8, MUL=9, 
		NUM=10, ID=11, STR=12, LINE_COMMENT=13, SPECIAL_COMMENT=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT", "STRING", "PyCOMA", "COMA", "ASIGN", "PIZQ", "PDER", "SUMA", "MUL", 
		"NUM", "ID", "STR", "CharContenido", "CharInicial", "LINE_COMMENT", "SPECIAL_COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'INT'", "'STRING'", "';'", "','", "'='", "'('", "')'", "'+'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "STRING", "PyCOMA", "COMA", "ASIGN", "PIZQ", "PDER", "SUMA", 
		"MUL", "NUM", "ID", "STR", "LINE_COMMENT", "SPECIAL_COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13B\n\13\f\13\16"+
		"\13E\13\13\5\13G\n\13\3\f\3\f\7\fK\n\f\f\f\16\fN\13\f\3\r\3\r\3\r\3\r"+
		"\7\rT\n\r\f\r\16\rW\13\r\3\r\3\r\3\16\3\16\5\16]\n\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\7\20e\n\20\f\20\16\20h\13\20\3\20\5\20k\n\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21v\n\21\f\21\16\21y\13\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\6\22\u0081\n\22\r\22\16\22\u0082\3\22\3\22\4f"+
		"w\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35"+
		"\2\37\17!\20#\21\3\2\6\3\2$$\7\2\62;aa\u00b9\u00b9\u0302\u0371\u2041\u2042"+
		"\17\2C\\c|\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001"+
		"\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff"+
		"\5\2\13\f\17\17\"\"\u008e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\3%\3\2\2\2\5)\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r\66"+
		"\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25F\3\2\2\2\27H\3\2\2\2\31"+
		"O\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37`\3\2\2\2!p\3\2\2\2#\u0080\3\2\2"+
		"\2%&\7K\2\2&\'\7P\2\2\'(\7V\2\2(\4\3\2\2\2)*\7U\2\2*+\7V\2\2+,\7T\2\2"+
		",-\7K\2\2-.\7P\2\2./\7I\2\2/\6\3\2\2\2\60\61\7=\2\2\61\b\3\2\2\2\62\63"+
		"\7.\2\2\63\n\3\2\2\2\64\65\7?\2\2\65\f\3\2\2\2\66\67\7*\2\2\67\16\3\2"+
		"\2\289\7+\2\29\20\3\2\2\2:;\7-\2\2;\22\3\2\2\2<=\7,\2\2=\24\3\2\2\2>G"+
		"\7\62\2\2?C\4\63;\2@B\4\62;\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2"+
		"DG\3\2\2\2EC\3\2\2\2F>\3\2\2\2F?\3\2\2\2G\26\3\2\2\2HL\5\35\17\2IK\5\33"+
		"\16\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\30\3\2\2\2NL\3\2\2\2OU"+
		"\7$\2\2PQ\7$\2\2QT\7$\2\2RT\n\2\2\2SP\3\2\2\2SR\3\2\2\2TW\3\2\2\2US\3"+
		"\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7$\2\2Y\32\3\2\2\2Z]\5\35\17\2"+
		"[]\t\3\2\2\\Z\3\2\2\2\\[\3\2\2\2]\34\3\2\2\2^_\t\4\2\2_\36\3\2\2\2`a\7"+
		"\61\2\2ab\7\61\2\2bf\3\2\2\2ce\13\2\2\2dc\3\2\2\2eh\3\2\2\2fg\3\2\2\2"+
		"fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2ik\7\17\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2"+
		"\2lm\7\f\2\2mn\3\2\2\2no\b\20\2\2o \3\2\2\2pq\7\61\2\2qr\7,\2\2rw\3\2"+
		"\2\2sv\5!\21\2tv\13\2\2\2us\3\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3"+
		"\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7,\2\2{|\7\61\2\2|}\3\2\2\2}~\b\21\2\2~\""+
		"\3\2\2\2\177\u0081\t\5\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\22"+
		"\2\2\u0085$\3\2\2\2\16\2CFLSU\\fjuw\u0082\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}