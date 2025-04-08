package define;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "int a;\nfloat b;\na=12;\nbuttercup(a, 1, 5)";
		
		//lexical analysis
		System.out.println("---- TOKENISATION ----\n");
		Tokenization_LexicalAnalysis.printTokens(input);
		
		//syntax analysis & semantic analysis
		System.out.println("\n\n---- PARSE TREE----\n");
		ParseTreeGenerator.printTree(input);
		
		

	}

}
