// Generated from Expr.g4 by ANTLR 4.13.2
package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, INT=12, LPAREN=13, RPAREN=14, COMA=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "ID", "INT", "LPAREN", "RPAREN", "COMA", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'buttercup'", "'*'", "'/'", "'+'", "'-'", "';'", "'='", "'int'", 
			"'float'", "'String'", null, null, "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"INT", "LPAREN", "RPAREN", "COMA", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

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
		"\u0004\u0000\u0010a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0005\nK\b\n\n\n\f\nN\t\n\u0001\u000b\u0004\u000bQ"+
		"\b\u000b\u000b\u000b\f\u000bR\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0004\u000f\\\b\u000f\u000b\u000f\f\u000f]\u0001"+
		"\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000"+
		"\u0004\u0003\u0000AZ__az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t"+
		"\n\r\r  c\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0001!\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000\u0000\u0005-"+
		"\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t1\u0001\u0000"+
		"\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\r5\u0001\u0000\u0000\u0000"+
		"\u000f7\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000\u0000\u0013A"+
		"\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000\u0000\u0017P\u0001\u0000"+
		"\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001bV\u0001\u0000\u0000\u0000"+
		"\u001dX\u0001\u0000\u0000\u0000\u001f[\u0001\u0000\u0000\u0000!\"\u0005"+
		"b\u0000\u0000\"#\u0005u\u0000\u0000#$\u0005t\u0000\u0000$%\u0005t\u0000"+
		"\u0000%&\u0005e\u0000\u0000&\'\u0005r\u0000\u0000\'(\u0005c\u0000\u0000"+
		"()\u0005u\u0000\u0000)*\u0005p\u0000\u0000*\u0002\u0001\u0000\u0000\u0000"+
		"+,\u0005*\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005/\u0000\u0000"+
		".\u0006\u0001\u0000\u0000\u0000/0\u0005+\u0000\u00000\b\u0001\u0000\u0000"+
		"\u000012\u0005-\u0000\u00002\n\u0001\u0000\u0000\u000034\u0005;\u0000"+
		"\u00004\f\u0001\u0000\u0000\u000056\u0005=\u0000\u00006\u000e\u0001\u0000"+
		"\u0000\u000078\u0005i\u0000\u000089\u0005n\u0000\u00009:\u0005t\u0000"+
		"\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0005f\u0000\u0000<=\u0005l\u0000"+
		"\u0000=>\u0005o\u0000\u0000>?\u0005a\u0000\u0000?@\u0005t\u0000\u0000"+
		"@\u0012\u0001\u0000\u0000\u0000AB\u0005S\u0000\u0000BC\u0005t\u0000\u0000"+
		"CD\u0005r\u0000\u0000DE\u0005i\u0000\u0000EF\u0005n\u0000\u0000FG\u0005"+
		"g\u0000\u0000G\u0014\u0001\u0000\u0000\u0000HL\u0007\u0000\u0000\u0000"+
		"IK\u0007\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0016\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OQ\u0007\u0002\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000S\u0018\u0001\u0000\u0000\u0000TU\u0005"+
		"(\u0000\u0000U\u001a\u0001\u0000\u0000\u0000VW\u0005)\u0000\u0000W\u001c"+
		"\u0001\u0000\u0000\u0000XY\u0005,\u0000\u0000Y\u001e\u0001\u0000\u0000"+
		"\u0000Z\\\u0007\u0003\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_`\u0006\u000f\u0000\u0000` \u0001\u0000\u0000\u0000"+
		"\u0004\u0000LR]\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}