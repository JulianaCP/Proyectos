lexer grammar Scanner;

tokens { INDENT, DEDENT }
@lexer::header {
  import com.yuvalshavit.antlr4.DenterHelper;
}

@lexer::members {
  private final DenterHelper denter = DenterHelper.builder()
    .nl(NewLINE)
    .indent(GParser.INDENT)
    .dedent(GParser.DEDENT)
    .pullToken(Scanner.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}



ParenIZQ: '(' ;
ParenDER: ')' ;
DosPUNTOS: ':' ;
COMA: ',' ;
DEF: 'def' ;
IF: 'if' ;
ELSE: 'else' ;
WHILE: 'while' ;
RETURN: 'return' ;
PRINT: 'print' ;
MENOR: '<' ;
MAYOR: '>' ;
MenorIGUAL: '<=' ;
MayorIGUAL: '>=' ;
IgualIGUAL: '==' ;
SUMA: '+' ;
RESTA: '-' ;
MULT: '*' ;
DIV: '/' ;
ParenSubIZQ: '[' ;
ParenSubDER: ']' ;
NewLINE: ('\r'? '\n' (' ' | '\t')* );
IGUAL: '=' ;
LEN: 'len' ;

/*
INT:
    '0'
    | '-'?'1'..'9'('0'..'9')*
    | '-'?'0'..'9''.''0'..'9'('0'..'9')*
    ;
*/
INT:
    '0'
    | '1'..'9'('0'..'9')*
    | '0'..'9''.''0'..'9'('0'..'9')*
    ;
STRING: '"' (~'"')* '"';


ID: CharInicial CharContenido* ;
fragment CharInicial:   'A'..'Z'
                        | 'a'..'z'
                        ;
fragment CharContenido: '0'..'9'
                        |'_'
                        | 'A'..'Z'
                        | 'a'..'z'
                        ;


WS:   [ \r\n\t] -> skip ;

CHAR: ['](~['])[']
      | [']'\\''n'[']
      | [']'\\''t'[']
      | [']'\\''r'['];



LINE_COMMENT: '#'.*?'\r'?'\n' -> skip ;
SPECIAL_COMMENT: '"""'.*?'"""'-> skip;