package define;

import java.util.HashMap;
import java.util.Map;

import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class EvalVisitor extends ExprBaseVisitor<Integer> {
    Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitIntExpr(ExprParser.IntExprContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitIdExpr(ExprParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        throw new RuntimeException("Undefined variable: " + id);
    }

    @Override
    public Integer visitAddSubExpr(ExprParser.AddSubExprContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.getChild(1).getText().equals("+")) return left + right;
        return left - right;
    }

    @Override
    public Integer visitMulDivExpr(ExprParser.MulDivExprContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.getChild(1).getText().equals("*")) return left * right;
        return left / right;
    }

    @Override
    public Integer visitParenExpr(ExprParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitAssignment(ExprParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitDeclaration(ExprParser.DeclarationContext ctx) {
        // Variable declared, but no value assigned here
        String id = ctx.ID().getText();
        memory.put(id, 0); // default initialization
        return 0;
    }

    @Override
    public Integer visitButtercupExpr(ExprParser.ButtercupExprContext ctx) {
        int x = visit(ctx.expr(0));
        int min = visit(ctx.expr(1));
        int max = visit(ctx.expr(2));

        if (x < min) return min;
        if (x > max) return max;
        return x;
    }

    @Override
    public Integer visitProg(ExprParser.ProgContext ctx) {
        Integer value = null;
        for (ExprParser.DeclarationContext decl : ctx.declaration()) {
            value = visit(decl);
        }
        for (ExprParser.AssignmentContext assign : ctx.assignment()) {
            value = visit(assign);
        }
        for (ExprParser.ExprContext expr : ctx.expr()) {
            value = visit(expr);
        }
        return value;
    }
}


