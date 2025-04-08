package define;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import grammar.ExprLexer;

public class Tokenization_LexicalAnalysis {

	public static void printTokens(String str) {
		// TODO Auto-generated method stub
		
		CharStream input = CharStreams.fromString(str);
		
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		tokens.fill();
		
		for (Token token : tokens.getTokens()) {
			String tokenName = ExprLexer.VOCABULARY.getSymbolicName(token.getType());
			System.out.printf("Token: %-15s Text: %s\n", tokenName, token.getText());
		}

	}

}
