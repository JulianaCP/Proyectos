lexer grammar Scanner; //gramatica lexica que se llama scanner (lista de expresiones regulares)


//lista de tokens

PyCOMA   : ';';
TINT     : 'INT';
TSTRING  : 'STRING';
ID       : [a-zA-Z_]([a-zA-Z_] | [0-9])*;      // rango de valores  ( _ simbolo valido) ... letras de a-z min y mayus y ademas el _
ASIGN    : '=';
NUM      : [0-9][0-9]*;

//WS : [' '+ \r\n \t] -> skip;  // +     =significa uno o mas veces