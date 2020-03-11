grammar Lexer;

prog: (dcls | func )* EOF;

dcls: ( dcl SEMICOLON )+;
dcl: TYPE ID | TYPE assign ;

assign: ID ASSIGN_OP expr;
expr: cond_expr;
cond_expr: arithm_expr (COMP_OP arithm_expr)? (( OR | AND ) cond_expr)*;
arithm_expr: term ( ( PLUS | MINUS ) term )*;
term: factor ( ( MULT | DIVISION ) factor )*;
factor:	ID | val | LEFT_PAREN expr RIGHT_PAREN;

func: return_type ID LEFT_PAREN param RIGHT_PAREN blk;
param: TYPE ID (COMMA param)*;
func_call: ID LEFT_PAREN ID (COMMA ID)* RIGHT_PAREN;

blk: LEFT_BRACKET ( dcls | stmt )* RIGHT_BRACKET;

stmt: ( assign SEMICOLON | expr SEMICOLON | func_call SEMICOLON | selection | iterative )+;

selection: IF LEFT_PAREN cond_expr RIGHT_PAREN blk ( ELSE blk )?;

iterative: WHILE LEFT_PAREN cond_expr RIGHT_PAREN REPEAT blk;

val: INT_LITERAL | LONG_LITERAL | FLOAT_LITERAL | CHAR_LITERAL | PIN_LITERAL;

array_literal: LEFT_BRACE val (COMMA val)* RIGHT_BRACE;

return_type: TYPE | VOID;

//TOKEN SPECIFICATION
COMP_OP: LESS_THAN | GREATER_THAN | IS | ISNOT;
LESS_THAN: '<';
GREATER_THAN: '>';
IS: 'IS';
ISNOT: 'ISNOT';
OR: 'OR';
AND: 'AND';
ASSIGN_OP: '=';
PLUS: '+';
MINUS: '-';
MULT:	'*';
DIVISION: '/';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';
LEFT_BRACE: '[';
RIGHT_BRACE: ']';
SEMICOLON: ';';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
REPEAT: 'repeat';
COMMA: ',';
VOID: 'void';
TYPE: 'integer' | 'decimal' | 'character' | 'big integer' | 'pin';

PIN_LITERAL: ( 'a' | 'A' )?  ('0'..'9')+;
ID: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '-' )+;
INT_LITERAL: ( '-' )? ('0'..'9')+;
LONG_LITERAL: ( '-' )? ('0'..'9')+;
FLOAT_LITERAL: ( '-' )? ('0'..'9')+ ('.' ('0'..'9')+ )?;
CHAR_LITERAL: '\'' (.) '\'';
