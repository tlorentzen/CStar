grammar CStar;

prog: ( dcl | func | stmt )* EOF;

dcl: TYPE (ID | assign | array_dcl) SEMICOLON; //done
assign: (ID | array_access) ASSIGN_OP expr; //done
expr: logical_expr; //done
logical_expr: cond_expr (( OR | AND ) cond_expr)*;
cond_expr: arithm_expr (COMP_OP arithm_expr)?;
arithm_expr: term (( PLUS | MINUS ) term)*; //done
term: factor (( MULT | DIVISION ) factor)*; //done
factor:	(MINUS)? (ID | val | LEFT_PAREN expr RIGHT_PAREN | func_call | array_access); //done

array_dcl: ARRAY ID ASSIGN_OP array_expr; //done
array_expr: LEFT_BRACKET expr (COMMA expr)* RIGHT_BRACKET; //done
array_assign: ID LEFT_BRACKET expr RIGHT_BRACKET (ASSIGN_OP expr)?; //done
array_access: ID LEFT_BRACKET expr RIGHT_BRACKET;

func: return_type ID LEFT_PAREN param? RIGHT_PAREN blk; //done
return_type: TYPE | VOID; //done
param: TYPE ID (COMMA TYPE ID)*;
blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE; //done
return_exp: RETURN expr SEMICOLON; //done
func_call: (ID | FUNCID) LEFT_PAREN (expr (COMMA expr)*)? RIGHT_PAREN; //done

stmt: assign SEMICOLON | expr SEMICOLON | selection | iterative;
iterative: WHILE LEFT_PAREN logical_expr RIGHT_PAREN REPEAT blk; //done
selection: IF LEFT_PAREN logical_expr RIGHT_PAREN blk ( ELSE blk )?; //done

val: INT_LITERAL | LONG_LITERAL | FLOAT_LITERAL | CHAR_LITERAL | PIN_LITERAL; // done

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
TYPE: 'integer' | 'decimal' | 'character' | 'long integer' | 'pin';
ARRAY: 'array';
RETURN: 'return';

INT_LITERAL: ('0'..'9')+;
LONG_LITERAL: ('0'..'9')+;
FLOAT_LITERAL: ('0'..'9')+ ('.' ('0'..'9')+ )?;
PIN_LITERAL: ( 'a' | 'A' )?  ('0'..'9')+;
CHAR_LITERAL: '\'' (.) '\'';

ID: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' )+;
FUNCID: (('a'..'z' | 'A'..'Z' | '0'..'9' | '_')+('.')?)+;

WHITESPACE: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n' ) -> skip;
