grammar miniPython;
/*options
{
	tokenVocab = PyScanner;
}*/

tokens { INDENT, DEDENT}
options
{

}

@lexer::header {
  import com.yuvalshavit.antlr4.DenterHelper;
}

@lexer::members {
  private final DenterHelper denter = DenterHelper.builder()
    .nl(NEWLINE)
    .indent(miniPythonParser.INDENT)
    .dedent(miniPythonParser.DEDENT)
    .pullToken(miniPythonLexer.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}

/*program :   statement
            | statement program
            ;
statement : defStatement | ifStatement | returnStatement | printStatement | whileStatement | assignStatement | functionCallStatement ;
defStatement : DEF IDENTIFIER PIZQ argList PDER DOSPUNTOS sequence ;
argList : IDENTIFIER argList | ;
moreArgs : COMA IDENTIFIER moreArgs | ;
ifStatement : IF expression DOSPUNTOS sequence ELSE DOSPUNTOS sequence ;
whileStatement : WHILE expression DOSPUNTOS sequence ;
returnStatement : RETURN expression NEWLINE ;
printStatement : PRINT expression NEWLINE ;
assignStatement : IDENTIFIER IGUAL expression NEWLINE ;
functionCallStatement : primitiveExpression PIZQ expressionList PDER NEWLINE ;
sequence : NEWLINE INDENT moreStatements DEDENT ;
moreStatements : statement moreStatements | statement ;
expression : additionExpression comparison ;
comparison : (MENOR|MAYOR|MENORIGUAL|MAYORIGUAL|COMP) additionExpression comparison | ;
additionExpression : multiplicationExpression additionFactor ;
additionFactor : (SUMA|RESTA) multiplicationExpression additionFactor | ;
multiplicationExpression : elementExpression multiplicationFactor ;
multiplicationFactor : (MUL|DIV) elementExpression multiplicationFactor | ;
elementExpression : primitiveExpression elementAccess ;
elementAccess : PCABRIR expression PCCERRAR elementAccess | ;
functionCallExpression :  IDENTIFIER PIZQ expressionList PDER ;
expressionList : expression moreExpressions | ;
moreExpressions : COMA expression moreExpressions | ;
primitiveExpression : NUM | STRING | IDENTIFIER | CHAR | PIZQ expression PDER | listExpression | LEN PIZQ expression PDER | functionCallExpression ;
listExpression : PCABRIR expressionList PCCERRAR ;*/


program                  : statement (statement)*                                       #Program_AST
						// |																#Program_Epsilon_AST
						 ;
statement                : defStatement          										#Statement_DefStatement_AST
//statement                : (NEWLINE)* defStatement          										#Statement_DefStatement_AST
						 | ifStatement  		 								#Statement_IfStatement_AST
// 						 | (NEWLINE)* ifStatement  		 								#Statement_IfStatement_AST
					     | returnStatement 		 							#Statement_ReturnStatement_AST
//					     | (NEWLINE)* returnStatement 		 							#Statement_ReturnStatement_AST
						 | printStatement 		 							#Statement_PrintStatement_AST
//						 | (NEWLINE)* printStatement 		 							#Statement_PrintStatement_AST
					     | whileStatement        								#Statement_WhileStatement_AST
//					     | (NEWLINE)* whileStatement        								#Statement_WhileStatement_AST
					     | assignStatement       								#Statement_AssignStatement_AST
//					     | (NEWLINE)* assignStatement       								#Statement_AssignStatement_AST
					     | functionCallStatement  							#Statement_FunctionCallStatement_AST
//					     | (NEWLINE)* functionCallStatement  							#Statement_FunctionCallStatement_AST
//						 | NEWLINE 														#Statement_Newline_AST
						 ;
defStatement             : DEF IDENTIFIER PIZQ argList PDER DOSPUNTOS sequence 			#DefStatement_AST
						 ;
argList                  : IDENTIFIER moreArgs 											#ArgList_MoreArgs_AST
					     | 					  											#ArgList_Epsilon_AST
						 ;
moreArgs                 : (COMA IDENTIFIER)* 											#MoreArgs_AST
						 ;
ifStatement              : IF expression DOSPUNTOS sequence ELSE DOSPUNTOS sequence #IfStatement_AST
						 ;
whileStatement           : WHILE expression DOSPUNTOS sequence							#WhileStatement_AST
						 ;
returnStatement          : RETURN expression NEWLINE									#ReturnStatement_AST
						 ;
printStatement           : PRINT PIZQ expression PDER NEWLINE							#PrintStatement_AST
						 ;
assignStatement          : IDENTIFIER IGUAL expression NEWLINE							#AssignStatement_AST
						 ;
functionCallStatement    : primitiveExpression PIZQ expressionList PDER fceEnding			#FunctionCallStatement_AST
						 ;
fceEnding                : NEWLINE
                           |
                         ;
sequence                 : INDENT moreStatement DEDENT  				#Sequence_AST
//sequence                 : NEWLINE INDENT moreStatement DEDENT  				#Sequence_AST
						 ;
moreStatement            : statement (statement)* 									    #MoreStatement_AST
						 ;
expression               : additionExpression comparison								#Expression_AST
						 ;
comparison               : ((MENOR|MAYOR|MENORIGUAL|MAYORIGUAL|COMP) additionExpression)* #Comparison_AST
						 ;
additionExpression       : multiplicationExpression additionFactor						#AdditionExpression_AST
						 ;
additionFactor           : ((SUMA|RESTA) multiplicationExpression)* 					#AdditionFactor_AST
						 ;
multiplicationExpression : elementExpression multiplicationFactor						#MultiplicationExpression_AST
						 ;
multiplicationFactor     : ((MUL|DIV) elementExpression)*   							#MultiplicationFactor_AST
						 ;
elementExpression        : primitiveExpression elementAccess            				#ElementExpression_AST
						 ;
elementAccess            : (PCABRIR expression PCCERRAR)*								#ElementAccess_AST
						 ;
functionCallExpression   : IDENTIFIER PIZQ expressionList PDER 							#FunctionCallExpression_AST
						 ;
expressionList           : expression moreExpressions 									#ExpressionList_AST
						 | 														  		#ExpressionList_EPSILON_AST
						 ;
moreExpressions          : (COMA expression)* 											#MoreExpressions_AST
						 ;
primitiveExpression      : NUM                       									#PrimitiveExpression_NUM_AST
						 | STRING 					    								#PrimitiveExpression_STR_AST
						 | IDENTIFIER                									#PrimitiveExpression_IDENTIFIER_AST
						 | CHAR															#PrimitiveExpression_CHAR_AST
						 | PIZQ expression PDER      									#PrimitiveExpression_Expression_AST
						 | listExpression            									#PrimitiveExpression_ListExpression_AST
						 | LEN PIZQ expression PDER 									#PrimitiveExpression_Len_Expression_AST
						 | functionCallExpression   									#PrimitiveExpression_FunctionCallExpression_AST
						 ;
listExpression           : PCABRIR expressionList PCCERRAR								#ListExpression_AST
                         ;

DEF     : 'def';
LEN     : 'len';
IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
RETURN  : 'return';
NEWLINE : ('\r'? '\n' (' ' | '\t')* );
//NEWLINE : ('\r'? '\n');
PRINT   : 'print';

IGUAL     : '=';
COMA      : ',';
COMP      : '==';
PIZQ      : '(';
PDER      : ')';
SUMA      : '+';
MUL       : '*';
DIV       : '/';
MAYOR     : '>';
MENOR     : '<';
DOSPUNTOS : ':';
RESTA     : '-';
PCABRIR   : '[';
PCCERRAR  : ']';
MENORIGUAL : '<=';
MAYORIGUAL : '>=';

fragment L : [a-zA-Z_];
fragment N : [0-9] ;

CHAR         : '\'' (L|[0-9]|' ')? '\'';
NUM          :'0' | ('-'?[1-9] N* ) | ('-'?[0-9]+)?(('.'[0-9]+));
IDENTIFIER : L(L|N)*;

STRING : '"' ('""'|~'"')* '"' ;

//elementos omitidos
COMMENT:   '//'.*?'\r'?'\n' -> skip ;

COMENTARIO
 : '/*'( COMENTARIO | . )*?'*/' -> skip
 ;

WS:   [ \r\n\t] -> skip ;
//WS : [' '] -> skip ;

