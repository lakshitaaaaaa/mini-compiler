package define;

import java.util.*;

import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class ICGenerator_ICG extends ExprBaseVisitor<String> {
    private int tempCount = 0;
    private int labelCount = 0;
    private Map<String, String> types = new HashMap<>();

    private String newTemp() {
        return "t" + (tempCount++);
    }

    private String newLabel() {
        return "L" + (labelCount++);
    }

    @Override
    public String visitDeclaration(ExprParser.DeclarationContext ctx) {
        String type = ctx.type().getText();
        String id = ctx.ID().getText();
        types.put(id, type);
        return ""; // Declarations do not emit ICG here
    }

    @Override
    public String visitAssignment(ExprParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        String exprCode = visit(ctx.expr());
        return exprCode + id + " = " + getLastTemp() + "\n";
    }

    private String lastTemp = "";

    private String getLastTemp() {
        return lastTemp;
    }

    private void setLastTemp(String t) {
        lastTemp = t;
    }

    @Override
    public String visitIntExpr(ExprParser.IntExprContext ctx) {
        String t = newTemp();
        setLastTemp(t);
        return t + " = " + ctx.INT().getText() + "\n";
    }

    @Override
    public String visitIdExpr(ExprParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        setLastTemp(id);  // No need to move to temp in basic ICG
        return "";
    }

    @Override
    public String visitAddSubExpr(ExprParser.AddSubExprContext ctx) {
        String code1 = visit(ctx.expr(0));
        String left = getLastTemp();
        String code2 = visit(ctx.expr(1));
        String right = getLastTemp();
        String op = ctx.getChild(1).getText();
        String t = newTemp();
        setLastTemp(t);
        return code1 + code2 + t + " = " + left + " " + op + " " + right + "\n";
    }

    @Override
    public String visitMulDivExpr(ExprParser.MulDivExprContext ctx) {
        String code1 = visit(ctx.expr(0));
        String left = getLastTemp();
        String code2 = visit(ctx.expr(1));
        String right = getLastTemp();
        String op = ctx.getChild(1).getText();
        String t = newTemp();
        setLastTemp(t);
        return code1 + code2 + t + " = " + left + " " + op + " " + right + "\n";
    }

    @Override
    public String visitParenExpr(ExprParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitButtercupExpr(ExprParser.ButtercupExprContext ctx) {
        String xCode = visit(ctx.expr(0));
        String x = getLastTemp();

        String minCode = visit(ctx.expr(1));
        String min = getLastTemp();

        String maxCode = visit(ctx.expr(2));
        String max = getLastTemp();

        String tCond1 = newTemp();
        String tCond2 = newTemp();
        String tResult = newTemp();
        String L1 = newLabel();
        String L2 = newLabel();
        String L3 = newLabel();

        setLastTemp(tResult);

        return
            xCode +
            minCode +
            maxCode +
            tCond1 + " = " + x + " < " + min + "\n" +
            "if " + tCond1 + " goto " + L1 + "\n" +
            tCond2 + " = " + x + " > " + max + "\n" +
            "if " + tCond2 + " goto " + L2 + "\n" +
            tResult + " = " + x + "\n" +
            "goto " + L3 + "\n" +
            L1 + ": " + tResult + " = " + min + "\n" +
            "goto " + L3 + "\n" +
            L2 + ": " + tResult + " = " + max + "\n" +
            L3 + ":\n";
    }

    @Override
    public String visitProg(ExprParser.ProgContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (var decl : ctx.declaration()) sb.append(visit(decl));
        for (var assign : ctx.assignment()) sb.append(visit(assign));
        for (var expr : ctx.expr()) sb.append(visit(expr));
        return sb.toString();
    }
}

