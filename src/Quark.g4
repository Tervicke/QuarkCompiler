grammar Quark;

//parser grammer
prog: stat+ ;

stat
: assig=assigstat
| print=printstat
| ifstatement
| whilestat
| funcdefn
| funccall
| returnstat
| importstat
| definestructstat
| declarestruct
| LineComment
| NEWLINE

;
funcdefn : 'fn' ID '(' paramlist? ')' ('->' TYPE)? block;
paramlist: param (','  param)* ;
param: TYPE ID ;
funccall: (modulename=ID '.')? functionname=ID '(' arglist? ')';
arglist: expr (',' expr)* ;
returnstat: 'return' expr? NEWLINE ;
importstat: 'import' ID ;
definestructstat: 'struct' ID '{' structstats '}';
structstats: structfield* ;
structfield: TYPE ID ;
declarestruct: ID ID'(' arglist? ')' ;

ifstatement: 'if' '(' expr ')' block ('else' block )?;
block: '{' stat* '}' ;

whilestat: 'while' '(' expr ')' block;

assigstat : TYPE? ID '=' ( expr) ;
printstat : 'print' '(' (expr) ')' ;

expr
    : equalityexpr;

equalityexpr    : relationalexpr (('==' | '!=') relationalexpr)* ;
relationalexpr  : addexpr (('<' | '<=' | '>' | '>=') addexpr)* ;

addexpr : addexpr ( '+' | '-') mulexpr
| mulexpr
;

mulexpr : fieldaccess ( '*' | '/' | '%' ) fieldaccess
        | fieldaccess
        ;

fieldaccess : atom access;
access: ('.' ID)* ;

atom : INT
| ID
| DOUBLE
| STRING
| TRUE
| FALSE
| funccall
| '(' expr ')'
;

//lexer rules
TYPE
    : 'int'
    | 'string'
    | 'bool'
    | 'double'
    | 'const' ;
TRUE  : 'true' ;
FALSE : 'false' ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
DOUBLE
    : DIGIT+ '.' DIGIT* ([eE] [+-]? DIGIT+)?     // 123.456, 10., 1.2e3
    | '.' DIGIT+ ([eE] [+-]? DIGIT+)?            // .456, .1e-5
    ;
fragment DIGIT : [0-9];

INT : DIGIT+ ;

NEWLINE : '\r'?'\n' -> skip;
WS : [ \t]+ -> skip ;
STRING : '"' (~["\\] | '\\' .)* '"' ;
LineComment
    : '//' ~( '\r' | '\n' )* NEWLINE -> skip
    ;