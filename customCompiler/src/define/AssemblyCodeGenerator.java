package define;

import java.util.Stack;

import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class AssemblyCodeGenerator extends ExprBaseVisitor<String> {
	public final StringBuilder asm = new StringBuilder();
	public final String[] Registers = {"eax","ebx","ecx","edx","esi","edi"};
	public final Stack<String> freeRegisters = new Stack<>();
	
	int labelCounter = 0;
	private String newLabel(String base) {
		return base+"_"+(labelCounter++);
	}
	
	public AssemblyCodeGenerator() {
		for (int i = Registers.length-1;i>=0;i--) {
			freeRegisters.push(Registers[i]);
		}
	}
	
	private String allocateRegister() {
		if (freeRegisters.isEmpty()) {
			throw new RuntimeException("No free Registers");
		}
		return freeRegisters.pop();
	}
	
	private void freeReg(String reg) {
		freeRegisters.push(reg);
	}
	
	@Override
	public String visitIntExpr(ExprParser.IntExprContext ctx) {
		String reg = allocateRegister();
		asm.append("mov ").append(reg).append(", ").append(ctx.INT().getText()).append("\n");
		return reg;
	}
	
	@Override
	public String visitIdExpr(ExprParser.IdExprContext ctx) {
		String reg = allocateRegister();
		asm.append("mov ").append(reg).append(", ").append(ctx.ID().getText()).append("\n");
		return reg;
	}
	
	@Override
	public String visitAddSubExpr(ExprParser.AddSubExprContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String operator = ctx.getChild(1).getText().equals("+")?"add ":"sub ";
		asm.append(operator).append(left).append(", ").append(right).append("\n");
		freeReg(right);
		return left;
	}
	
	@Override
	public String visitMulDivExpr(ExprParser.MulDivExprContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String operator = ctx.getChild(1).getText().equals("*")?"mul ":"div ";
		asm.append(operator).append(left).append(", ").append(right).append("\n");
		freeReg(right);
		return left;
	}
	
	@Override
	public String visitAssignment(ExprParser.AssignmentContext ctx) {
		String reg = visit(ctx.expr());
		asm.append("mov ").append(ctx.ID().getText()).append(", ").append(reg).append("\n");
		freeReg(reg);
		return null;
	}
	
	@Override
	public String visitButtercupExpr(ExprParser.ButtercupExprContext ctx) {
		String regA = visit(ctx.expr(0));
		String regB = visit(ctx.expr(1));
		String regC = visit(ctx.expr(2));
		
		String resultRegister = allocateRegister();
		
		String labelMn = newLabel("return_min");
		String labelMx = newLabel("return_min");
		String labelEnd = newLabel("end_buttercup");
		
//		asm.append("\nmov ").append(regA).append(", ").append(ctx.expr(0).getText()).append("\n");
//		asm.append("mov ").append(regB).append(", ").append(ctx.expr(1).getText()).append("\n");
//		asm.append("mov ").append(regC).append(", ").append(ctx.expr(2).getText()).append("\n\n");
		asm.append("buttercup:").append("\n");
		asm.append("cmp ").append(regA).append(", ").append(regB).append("\n");
		asm.append("jl ").append(labelMn).append("\n");
		asm.append("cmp ").append(regA).append(", ").append(regC).append("\n");
		asm.append("jg ").append(labelMx).append("\n");
		asm.append("mov ").append(resultRegister).append(", ").append(regA).append("\n");
		asm.append("jmp ").append(labelEnd).append("\n");
		asm.append(labelMn).append(":").append("\n");
		asm.append("mov ").append(resultRegister).append(", ").append(regB).append("\n");
		asm.append("jmp ").append(labelEnd).append("\n");
		asm.append(labelMx).append(":").append("\n");
		asm.append("mov ").append(resultRegister).append(", ").append(regB).append("\n");
		asm.append("jmp ").append(labelEnd).append("\n");
		asm.append(labelEnd).append(":");
		return resultRegister;
	}
	
	@Override
	public String visitDeclaration(ExprParser.DeclarationContext ctx) {
		asm.append("// declare ").append(ctx.type().getText()).append(" ").append(ctx.ID().getText()).append("\n");
		return null;
		
	}
	
	@Override
	public String visitProg(ExprParser.ProgContext ctx) {
		for (var child : ctx.children) {
			visit(child);
		}
		return asm.toString();
	}
}
