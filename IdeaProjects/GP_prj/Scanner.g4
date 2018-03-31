lexer grammar Scanner;

//Tokens para palabras reservadas
INT
	:	'INT'
	;

STRING
	:	'STRING'
	;

//Tokens para simbolos
PyCOMA	:	';' ;
COMA	:	',' ;
ASIGN	:	'=' ;
PIZQ	:	'(' ;
PDER	:	')' ;
SUMA	:	'+' ;
MUL		:	'*' ;

//Tokens para expresiones regulares
NUM
	:	'0'
	| '1'..'9' ('0'..'9')*
	;

ID
	:	CharInicial CharContenido*
	;

STR : '"' ('""'|~'"')* '"' ;

//el modificador fragment determina que la regla en particular no será reconocida como regla léxica
//y solo podrá ser utilizada como parte de una existente
//
//Aquí por ejemplo, CharContenido se crea no para que se reconozca como tal sino para ser parte de la regla anterior ID
fragment
CharContenido
   : CharInicial
   | '0'..'9'
   | '_'
   | '\u00B7'
   | '\u0300'..'\u036F'
   | '\u203F'..'\u2040'
   ;
fragment
CharInicial
   : 'A'..'Z' | 'a'..'z'
   | '\u00C0'..'\u00D6'
   | '\u00D8'..'\u00F6'
   | '\u00F8'..'\u02FF'
   | '\u0370'..'\u037D'
   | '\u037F'..'\u1FFF'
   | '\u200C'..'\u200D'
   | '\u2070'..'\u218F'
   | '\u2C00'..'\u2FEF'
   | '\u3001'..'\uD7FF'
   | '\uF900'..'\uFDCF'
   | '\uFDF0'..'\uFFFD'
   ;

//elementos omitidos
LINE_COMMENT:   '//'.*?'\r'?'\n' -> skip ;

SPECIAL_COMMENT
 : '/*'( SPECIAL_COMMENT | . )*?'*/' -> skip
 ;

WS:   [ \t\n\r]+ -> skip ; //El espacio en blanco es equivalente a ' '+...