grammar Cstar;

Prog: (Dcls | Func )* EOF;

Stmt: ( Assign semicolon | Expr semicolon | Func_call semicolon | Selection | Iterative )+;

Selection: if left_paren Cond_expr right_paren Blk ( else Blk )?;

Iterative: while left_paren Cond_expr right_paren repeat Blk;
Blk: left_bracket ( Dcls | Stmt )* right_bracket;
Dcls: Dcl*;
Dcl: (Type id) | (Type ( Assign )?) ;

Func: Return_type id leftParen Param rightParen Blk;
Param: Type id (comma Param)*;
Func_call: id leftParen id (comma id)* rightParen;

Assign: id assign_op Expr;
Expr: Cond_expr;
Arithm_expr: Term ( ( plus | minus ) Term )*;
Term: Factor ( ( multiplication | division ) Factor )*;
Factor:	id | val | leftParen Expr rightParen;

Cond_expr: Arithm_expr (comp_op Arithm_expr)? (( or | and ) Cond_expr)*;

//TOKEN SPECIFICATION
comp_op: less_than | greater_than | is | isNot;
less_than: '<';
greater_than: '>';
is: 'IS';
isNot: 'ISNOT';
or: 'OR';
and: 'AND';
assign_op: '=';
plus: '+';
minus: '-';
multiplication:	'*';
division: '/';
left_paren: '(';
right_paren: ')';
left_bracket: '{';
right_bracket: '}';
semicolon: ';';
if: 'if';
else: 'else';
while: 'while';
repeat: 'repeat';
comma: ',';


id: ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '-' )+;
Val: int_literal | float_literal | char_literal | pin_literal | long_literal;
int_literal: ( '-' )? ('0'..'9')+;
long_literal: ( '-' )? ('0'..'9')+;
float_literal: ( '-' )? ('0'..'9')+ ('.' ('0'..'9')+ )?;
char_literal: '\'' (.) '\'';
pin_literal: ( 'a' | 'A' )?  ('0'..'9')+;
array_literal: '[' Val (comma Val)* ']';

Type: 'integer' | 'decimal' | 'character' | 'big integer' | 'pin';
Return_type: Type | 'void';
