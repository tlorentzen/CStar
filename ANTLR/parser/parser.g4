parser grammar Parser;

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

Val: int_literal | float_literal | char_literal | pin_literal | long_literal;

Array_literal: left_brace Val (comma Val)* right_brace;

Return_type: Type | void;