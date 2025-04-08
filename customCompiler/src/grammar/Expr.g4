grammar Expr;

prog : (declaration | assignment | expr)* EOF; 
//prog -> starting rule of the grammar
//expr -> This tells ANTLR: “The input can contain zero or more declarations or expressions, in any order.
//EOF -> end of file, implies parser will not except anything after this

//parser rule
expr
    : 'buttercup' '(' expr ',' expr ',' expr ')' #ButtercupExpr
    | expr ('*' | '/') expr                      #MulDivExpr
    | expr ('+' | '-') expr                      #AddSubExpr
    | INT                                        #IntExpr
    | ID                                         #IdExpr
    | '(' expr ')'                               #ParenExpr
    ;

// new declaration rule
declaration : type ID ';' ;

//assignment
assignment : ID '=' expr ';' ;

// new type rule
type : 'int' | 'float' | 'String';
 
//lexer rules(tokens)
ID : [a-zA-Z_][a-zA-Z0-9]*;
INT : [0-9]+;
LPAREN : '(';
RPAREN : ')';
COMA : ',';
WS : [ \t\r\n]+ -> skip ;

/*
The parser rules are written before the grammar rules as parser rules define the structure of your language and lexer rules defines the tokens  used by parser rules. 
ANTLR does not enforce this order of writing parser rules first then the lexer rules, however doing so makes the grammar easier to read and maintain, especially for others.
as first understand the structure of the grammar and then go through the tokens.
*/	 
