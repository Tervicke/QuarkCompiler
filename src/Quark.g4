grammar Quark;

//parser grammer
prog: stat+ ;


stat
: assig=assigstat NEWLINE
| print=printstat NEWLINE
;

assigstat : 'let' ID '=' expr ;
printstat : 'print' '(' expr ')' ;

expr: addexpr;

addexpr : addexpr ( '+' | '-') mulexpr
| mulexpr
;

mulexpr : mulexpr ( '*' | '/') atom
| atom
;

atom : INT
| ID
| '(' expr ')'
| '[' expr ']'
| '{' expr '}'
;

//lexer rules
ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE : '\r'?'\n' ;
WS : [ \t]+ -> skip ;