import java_cup.runtime.*;

%%

%public
%class Scanner
%implements sym

%unicode

%line
%column

%cup
%cupdebug

%{
  StringBuilder string = new StringBuilder();

  private Symbol symbol(int type) {
    return new JavaSymbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new JavaSymbol(type, yyline+1, yycolumn+1, value);
  }

  /**
   * assumes correct representation of a long value for
   * specified radix in scanner buffer from <code>start</code>
   * to <code>end</code>
   */
  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i),radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }
%}


/* main character classes */
LineTerminator = \r|\n|\r\n
/*InputCharacter = [^\r\n]*/

WhiteSpace = {LineTerminator} | [ \t\f]

/* identifiers */
Id = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = 0 | [1-9][0-9]*
LongLiteral    = {IntegerLiteral} [lL]

HexLiteral    = # 0* {HexDigit} {1,16} [lL]
HexDigit          = [0-9a-fA-F]

/* floating point literals */
FloatLiteral  = ({FLit1}|{FLit2}) [fF]
/* DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? */

FLit1    = [0-9]+ \. [0-9]*
FLit2    = [0-9]+

/* string and character literals */
/* StringCharacter = [^\r\n\"\\] */
CharLiteral = [^\r\n\'\\]

/* pin literal */
PinLiteral = A?[0-9]+

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* keywords */
  "array"                          { return symbol(ARRAY); }
  /*"boolean"                      { return symbol(BOOLEAN); }*/
  "big"                            { return symbol(LONG); }
  /*"byte"                         { return symbol(BYTE); }*/
  /*"case"                         { return symbol(CASE); }*/
  "character"                      { return symbol(CHAR); }
  "constant"                       { return symbol(CONST); }
  /*"double"                       { return symbol(DOUBLE); }*/
  "else"                           { return symbol(ELSE); }
  "decimal"                        { return symbol(FLOAT); }
  /*"for"                          { return symbol(FOR); }*/
  /*"default"                      { return symbol(DEFAULT); }*/
  "include"                        { return symbol(IMPORT); }
  "integer"                        { return symbol(INT); }
  "goto"                           { return symbol(GOTO); }
  "if"                             { return symbol(IF); }
  "pin"                            { return symbol(PIN); }
  "repeat"                         { return symbol(REPEAT); }
  /*"switch"                       { return symbol(SWITCH); }*/
  "return"                         { return symbol(RETURN); }
  "void"                           { return symbol(VOID); }
  "while"                          { return symbol(WHILE); }

  /* boolean literals */
  /*"true"                         { return symbol(BOOLEAN_LITERAL, true); }
  "false"                        { return symbol(BOOLEAN_LITERAL, false); }*/

  /* null literal */
  "null"                         { return symbol(NULL_LITERAL); }

  /* separators */
  "("                            { return symbol(LPAREN); }
  ")"                            { return symbol(RPAREN); }
  "{"                            { return symbol(LBRACE); }
  "}"                            { return symbol(RBRACE); }
  "["                            { return symbol(LBRACK); }
  "]"                            { return symbol(RBRACK); }
  ";"                            { return symbol(SEMICOLON); }
  ","                            { return symbol(COMMA); }
  "."                            { return symbol(DOT); }

  /* operators */
  "="                            { return symbol(EQ); }
  ">"                            { return symbol(GT); }
  "<"                            { return symbol(LT); }
  /*"NOT"                        { return symbol(NOT); }*/
  "IS"                           { return symbol(EQEQ); }
  /*"<="                           { return symbol(LTEQ); }
  ">="                           { return symbol(GTEQ); }*/
  "ISNOT"                        { return symbol(NOTEQ); }
  "AND"                          { return symbol(ANDAND); }
  "OR"                           { return symbol(OROR); }
  "+"                            { return symbol(PLUS); }
  "-"                            { return symbol(MINUS); }
  "*"                            { return symbol(MULT); }
  "/"                            { return symbol(DIV); }
/*  "%"                            { return symbol(MOD); }*/

  /* string literal */
  /*\"                             { yybegin(STRING); string.setLength(0); }*/

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }

  /* numeric literals */

  /* This is matched together with the minus, because the number is too big to
     be represented by a positive integer. */
  "-2147483648"                  { return symbol(INTEGER_LITERAL, Integer.valueOf(Integer.MIN_VALUE)); }

  {IntegerLiteral}               { return symbol(INTEGER_LITERAL, Integer.valueOf(yytext())); }

  {LongLiteral}                  { return symbol(INTEGER_LITERAL, new Long(yytext().substring(0,yylength()-1))); }

  {HexLiteral}                   { return symbol(INTEGER_LITERAL, new Long(parseLong(2, yylength()-1, 16))); }

  {FloatLiteral}                 { return symbol(FLOATING_POINT_LITERAL, new Float(yytext().substring(0,yylength()-1))); }
  /*{DoubleLiteral}                { return symbol(FLOATING_POINT_LITERAL, new Double(yytext())); }
  {DoubleLiteral}[dD]            { return symbol(FLOATING_POINT_LITERAL, new Double(yytext().substring(0,yylength()-1))); }*/

  {PinLiteral}                   { yybegin(PIN); string.setLength(0);}

  /* comments */
/*{Comment}                      { /* ignore */ }*/

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */
  {Id}                           { return symbol(IDENTIFIER, yytext()); }
}

/*<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString()); }

  {StringCharacter}+             { string.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }

  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}*/

<CHARLITERAL> {
  {CharLiteral}\'            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, yytext().charAt(0)); }

  /* escape sequences */
  "\\b"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\b');}
  "\\t"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\t');}
  "\\n"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\n');}
  "\\f"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\f');}
  "\\r"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\r');}
  "\\\""\'                       { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\"');}
  "\\'"\'                        { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\'');}
  "\\\\"\'                       { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\\');}

  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated character literal at end of line"); }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(EOF); }
