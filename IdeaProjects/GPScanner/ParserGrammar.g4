parser grammar ParserGrammar;

options {
    tokenVocab = Scanner;
}

/*
  PARSER RULES
*/

program:
       declarations statements  EOF         #condecls
       | statements EOF                     #sindecls
       ;
declarations:
            declaration PyCOMA ( declaration PyCOMA )*      #decls
            ;

declaration:
           INT idlist               #intdecl
           | STRING idlist          #strdecl
           ;

statements:
          statement ( PyCOMA statement )*       #stats
          ;

statement:	ID ASIGN expression         #asignstat
         | expression                   #exprstat
         |                              #epsstat
         ;

expression:
          term ( SUMA term )*       #expr
          ;

term:
	factor ( MUL factor )*      #term1
	;

factor:
	  PIZQ expression PDER          #groupfact
	  | ID                          #idfact
	  | NUM                         #numfact
	  | STR                         #strfact
	  ;

idlist:
      ID ( COMA ID )*               #idlist1
      ;

