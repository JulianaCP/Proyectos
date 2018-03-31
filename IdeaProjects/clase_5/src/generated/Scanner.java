// Generated from C:/Users/Pruebas/IdeaProjects/clase_5\Scanner.g4 by ANTLR 4.6
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
		PyCOMA=1, TINT=2, TSTRING=3, ID=4, ASIGN=5, NUM=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PyCOMA", "TINT", "TSTRING", "ID", "ASIGN", "NUM"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'INT'", "'STRING'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PyCOMA", "TINT", "TSTRING", "ID", "ASIGN", "NUM"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b,\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5\37\n\5\f\5\16\5\"\13\5\3\6\3\6\3\7\3"+
		"\7\7\7(\n\7\f\7\16\7+\13\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\5\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\2\62;-\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2\2\7\25\3\2\2\2"+
		"\t\34\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17\20\7=\2\2\20\4\3\2\2\2\21\22\7"+
		"K\2\2\22\23\7P\2\2\23\24\7V\2\2\24\6\3\2\2\2\25\26\7U\2\2\26\27\7V\2\2"+
		"\27\30\7T\2\2\30\31\7K\2\2\31\32\7P\2\2\32\33\7I\2\2\33\b\3\2\2\2\34 "+
		"\t\2\2\2\35\37\t\3\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2"+
		"\2!\n\3\2\2\2\" \3\2\2\2#$\7?\2\2$\f\3\2\2\2%)\t\4\2\2&(\t\4\2\2\'&\3"+
		"\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\16\3\2\2\2+)\3\2\2\2\6\2\36 )\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}