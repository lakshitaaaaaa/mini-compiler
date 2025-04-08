package define;

import org.antlr.v4.runtime.*;
import grammar.ExprLexer;
import grammar.ExprParser;

public class ParseTreeGenerator {

	public static void printTree(String input) {
		// TODO Auto-generated method stub
		CharStream stream = CharStreams.fromString(input);
		ExprLexer lexer = new ExprLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		
		ExprParser.ProgContext tree = parser.prog();
		System.out.println(tree.toStringTree(parser));
		
		SemanticAnalyser analyser = new SemanticAnalyser();
		analyser.visitProg(tree);
		analyser.printSymbolTable();
		
		//ICG
		ICGenerator_ICG visitor = new ICGenerator_ICG();
        String icg = visitor.visit(tree);

        // Print the ICG
        System.out.println("\n\n---- INTERMEDIATE CODE GENERATION ----\n");
        System.out.println(icg);
        
        //Assembly Code Generator
        AssemblyCodeGenerator code = new AssemblyCodeGenerator();
        String asm = code.visit(tree);
        
        System.out.println("\n---- ASSEMBLY CODE ----\n");
        System.out.println(asm);
        
      //evaluate
        EvalVisitor visitor2 = new EvalVisitor();
        Integer result = visitor2.visit(tree);
        System.out.println("\n---- RESULT ----\n " + result);
              
	}

}
