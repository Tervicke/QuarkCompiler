grammar Quark;

//parser grammer
prog: stat+ ;

stat
: assig=assigstat
| print=printstat
| ifstatement
| LineComment
| NEWLINE

;

ifstatement: 'if' '(' expr ')' block ;
block: '{' stat* '}' ;

assigstat : TYPE ID '=' ( expr) ;
printstat : 'print' '(' (expr) ')' ;

expr
    : equalityexpr;

equalityexpr    : relationalexpr (('==' | '!=') relationalexpr)* ;
relationalexpr  : addexpr (('<' | '<=' | '>' | '>=') addexpr)* ;

addexpr : addexpr ( '+' | '-') mulexpr
| mulexpr
;

mulexpr : mulexpr ( '*' | '/' | '%' ) atom
| atom
;

atom : INT
| ID
| STRING
| '(' expr ')'
;

//lexer rules
TYPE
    : 'int'
    | 'string'
    | 'bool' ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
INT : [0-9]+ ;
NEWLINE : '\r'?'\n' ;
WS : [ \t]+ -> skip ;
STRING : '"' (~["\\] | '\\' .)* '"' ;
LineComment
    : '//' ~( '\r' | '\n' )* NEWLINE -> skip
    ;