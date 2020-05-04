grammar CStar;

prog: ( dcl | stmt | func )* EOF;

dcl: TYPE (ID | assign | array_dcl ) SEMICOLON;
assign: (ID | array_access) ASSIGN_OP expr;
expr: logical_expr;

logical_expr: cond_expr (( OR | AND ) cond_expr)*;
cond_expr: arithm_expr (COMP_OP arithm_expr)?;
arithm_expr: term (( PLUS | MINUS ) term)*;
term: factor (( MULT | DIVISION | MODULO ) factor)*;
factor:	(MINUS)? (ID | val | LEFT_PAREN expr RIGHT_PAREN | func_call | array_access);

array_dcl: ARRAY ID ASSIGN_OP array_expr;
array_expr: LEFT_BRACKET expr (COMMA expr)* RIGHT_BRACKET;
array_access: ID LEFT_BRACKET expr RIGHT_BRACKET;

stmt: assign SEMICOLON | print SEMICOLON | expr SEMICOLON | selection | iterative | comment;
iterative: WHILE LEFT_PAREN logical_expr RIGHT_PAREN REPEAT blk;
selection: IF LEFT_PAREN logical_expr RIGHT_PAREN blk ( ELSE blk )?;
blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;

print: PRINT LEFT_PAREN (val | STRING_LITERAL | ID)? (PLUS (val | STRING_LITERAL | ID))* RIGHT_PAREN;

func: return_type ID LEFT_PAREN param? RIGHT_PAREN blk;
return_type: TYPE | VOID;
param: TYPE ID (COMMA TYPE ID)*;
return_exp: RETURN expr SEMICOLON;
func_call: (ID | FUNCID | array_func) LEFT_PAREN (expr (COMMA expr)*)? RIGHT_PAREN;
array_func: array_access DOT ID;

val: CHAR_LITERAL | PIN_LITERAL | BOOLEAN_LITERAL | NUMBER | HIGH | LOW;

comment: LINE_COMMENT;

//TOKEN SPECIFICATION
COMP_OP: LESS_THAN | GREATER_THAN | IS | ISNOT | LESS_THAN_EQ | GREATER_THAN_EQ;
LESS_THAN: '<';
GREATER_THAN: '>';
IS: 'IS';
ISNOT: 'ISNOT';
OR: 'OR';
AND: 'AND';
ASSIGN_OP: '=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIVISION: '/';
LESS_THAN_EQ: '<=';
GREATER_THAN_EQ: '>=';
MODULO: '%';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
SEMICOLON: ';';
DOT: '.';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
REPEAT: 'repeat';
COMMA: ',';
VOID: 'void';
TYPE: 'integer' | 'decimal' | 'character' | 'long integer' | 'small integer' | 'pin' | 'boolean';
ARRAY: 'array';
RETURN: 'return';
PRINT: 'console.print';
HIGH: 'HIGH';
LOW: 'LOW';

NUMBER: ('0'..'9') + ('.' ('0'..'9')+ )?;
BOOLEAN_LITERAL: 'true' | 'false';
PIN_LITERAL: ( 'a' | 'A' )?  ('0'..'9')+;
CHAR_LITERAL: '\'' (.) '\'';
STRING_LITERAL: '"' ~('\r' | '\n' | '"')* '"';

ID: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' )+;
FUNCID: ( ('a'..'z' | 'A'..'Z' | '0'..'9' | '_') + ('.')? )+;

WHITESPACE: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n' ) -> skip;
LINE_COMMENT: '//' ~[\r\n]*;