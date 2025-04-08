package define;

import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class SemanticAnalyser extends ExprBaseVisitor<Void>{
	SymbolTable_SemanticAnalysis symboltable = new SymbolTable_SemanticAnalysis();
	
	@Override
	public Void visitProg(ExprParser.ProgContext ctx) {
	    System.out.println("Visiting Prog Node");

	    for (ExprParser.DeclarationContext decl : ctx.declaration()) {
	        visitDeclaration(decl);
	    }

	    for (ExprParser.ExprContext expr : ctx.expr()) {
	        visit(expr);
	    }

	    return null;
	}



	@Override
	public Void visitDeclaration(ExprParser.DeclarationContext ctx) {
	    System.out.println("Visiting Declaration: " + ctx.getText());
	    String varType = ctx.type().getText();
	    String varName = ctx.ID().getText();
	    symboltable.define(varName, varType);
	    return null;
	}
	
	public void printSymbolTable() {
		symboltable.printTable();
	}
	
}
