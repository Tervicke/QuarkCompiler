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
| continuestatement
| breakstatement
| patternmatchstat
| destructstat
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
destructstat: 'let' '[' idlist ']' '=' ID ;
idlist: destructfield (',' destructfield)* ;
destructfield: id=ID | skip='_' ;
ifstatement: 'if' '(' expr ')' block ('else' block )?;
block: '{' stat* '}' ;

continuestatement: 'continue' ;
breakstatement: 'break' ;

whilestat: 'while' '(' expr ')' block;

patternmatchstat: 'match' ID '{' matcharms* '}';
matcharms: pattern '=>' matchbody;
matchbody: stat | '{' stat* '}' ;
pattern: isatom=atom   //normal literals
         | istruct='@' ID '(' arglist? ')' //for constructor @point(x,y)
         | iswildcard='_' ; //wildcard

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

fieldaccess : unaryExpr access;
access: ('.' ID)* ;

unaryExpr
    : neg='-' unaryExpr
    | pos='+' unaryExpr
    | atom
    ;

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