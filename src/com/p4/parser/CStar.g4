grammar CStar;

prog: ( dcl | func | stmt )* EOF;

dcl: (TYPE ID | TYPE (assign | array_assign)) SEMICOLON ;

return_exp: RETURN expr SEMICOLON ;

assign: ID ASSIGN_OP expr ;
expr: cond_expr | func_call;
cond_expr: arithm_expr (COMP_OP arithm_expr)? (( OR | AND ) cond_expr)*;
arithm_expr: term ( ( PLUS | MINUS ) term )*;
term: factor ( ( MULT | DIVISION ) factor )*;
factor:	ID | val | array_value | LEFT_PAREN expr RIGHT_PAREN;

array_assign: ARRAY ID ASSIGN_OP array_expr ;
array_expr: LEFT_BRACKET val (COMMA val)* RIGHT_BRACKET ;

func: return_type ID LEFT_PAREN param RIGHT_PAREN blk;
param: (TYPE ID (COMMA param)*)*;
func_call: (ID DOT)? ID LEFT_PAREN ((ID | val) (COMMA (ID | val))*)? RIGHT_PAREN;

blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;

stmt: ( assign SEMICOLON | expr SEMICOLON | selection | iterative )+;

iterative: WHILE LEFT_PAREN cond_expr RIGHT_PAREN REPEAT blk;

selection: IF LEFT_PAREN cond_expr RIGHT_PAREN blk ( ELSE blk )?;

val: INT_LITERAL | LONG_LITERAL | FLOAT_LITERAL | CHAR_LITERAL | PIN_LITERAL ;

array_value: ID LEFT_BRACKET val RIGHT_BRACKET (ASSIGN_OP val)? ;

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
TYPE: 'integer' | 'decimal' | 'character' | 'big integer' | 'pin';
ARRAY: 'array';
RETURN: 'return';

INT_LITERAL: ( '-' )? ('0'..'9')+;
LONG_LITERAL: ( '-' )? ('0'..'9')+;
FLOAT_LITERAL: ( '-' )? ('0'..'9')+ ('.' ('0'..'9')+ )?;
PIN_LITERAL: ( 'a' | 'A' )?  ('0'..'9')+;
CHAR_LITERAL: '\'' (.) '\'';

ID: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' )+;

WHITESPACE: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n' ) -> skip;
