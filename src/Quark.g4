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

ifstatement: 'if' '(' equalityexpr+ ')' block ;
block: '{' stat* '}' ;

assigstat : TYPE ID '=' ( expr) ;
printstat : 'print' '(' (expr) ')' ;

expr
    : equalityexpr;

equalityexpr : left=addexpr  (('==' | '!=' ) right=addexpr )* ;
addexpr : addexpr ( '+' | '-') mulexpr
| mulexpr
;

mulexpr : mulexpr ( '*' | '/') atom
| atom
;

atom : INT
| ID
| STRING
| '(' expr ')'
| '[' expr ']'
| '{' expr '}'
;

//lexer rules
TYPE
    : 'int'
    | 'string'
    | 'bool' ;
ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE : '\r'?'\n' ;
WS : [ \t]+ -> skip ;
STRING : '"' (~["\\] | '\\' .)* '"' ;
LineComment
    : '//' ~( '\r' | '\n' )* NEWLINE -> skip
    ;