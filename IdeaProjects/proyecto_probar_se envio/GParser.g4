parser grammar GParser;

options {
    tokenVocab = Scanner;
}

//1
program:
        statement (statement)*  EOF             #stamentprogram
        ;

//2
statement:
        defStatement                #defstamentcall
        | ifStatement               #ifstamentcall
        | returnStatement           #returnstamentcall
        | printStatement            #printstamentcall
        | whileStatement            #whilestamentcall
        | assignStatement           #assigstamentcall
        | functionCallStatement     #functioncallstamentcall
        ;

//3
defStatement:
            DEF ID ParenIZQ argList ParenDER DosPUNTOS sequence     #defstamentfun
            ;

//4
argList:
        ID moreArgs         #idarglist
        |                   #espacarglist
        ;

//5
moreArgs:
    (COMA ID)*              #moreargsfun
    ;

//6
ifStatement:
            IF expression DosPUNTOS sequence ELSE DosPUNTOS sequence        #ifstamentfun
            ;

//7
whileStatement:
               WHILE expression DosPUNTOS sequence         #whilestamentfun
               ;

//8
returnStatement:
                RETURN expression NewLINE   #returnstamentfun
                ;

//9
printStatement:
            PRINT ParenIZQ expression ParenDER NewLINE          #printstamentfun
            ;

//10
assignStatement:
            ID IGUAL expression NewLINE             #assigstamentfun
            ;

//11
functionCallStatement:
            primitiveExpression ParenIZQ expressionList ParenDER NewLINE        #functcallstamentfun
            ;

//12
sequence:
        INDENT moreStatement DEDENT     #sequencefun
        ;


//13
moreStatement:
            statement (statement)*          #morestamentfun
            ;

//14
expression:
        additionExpression comparison       #expressinfun
        ;

//15
comparison:
        ((comparisonValores) additionExpression)*        #comparisonfun
        ;
//

//15 y medio
comparisonValores:
    MENOR                       #menorfun
    |MAYOR                      #mayorfun
    |MenorIGUAL                 #menorIgualfun
    |MayorIGUAL                 #mayorigualfun
    |IgualIGUAL                 #igualigualfun
    ;




//16
additionExpression:
            multiplicationExpression additionFactor         #addiexpressifun
            ;

//17
additionFactor:
            ((factoresSumaResta) multiplicationExpression)*        #addifactfun
            ;


//17 y medio

factoresSumaResta:
    SUMA                        #sumafunc
    |RESTA                      #restafunc
    ;


//18
multiplicationExpression:
                elementExpression multiplicationFactor      #multexpressifun
                ;

//19
multiplicationFactor:
            ((factoresMultDiv) elementExpression)*             #multfactfun
            ;

//19 y medio
factoresMultDiv:
    MULT                    #multfunc
    |DIV                    #divfunc
    ;


//20
elementExpression:
            primitiveExpression elementAccess           #elementexpressifun
            ;

//21
elementAccess:
            (ParenSubIZQ expression ParenSubDER)*      #elementaccessfun
            ;

//22
functionCallExpression:
            ID ParenIZQ expressionList ParenDER         #functcallexpressifun
            ;

//23
expressionList:
        expression moreExpressions          #expressiexpressilist
        |                                   #espacexpressilist
        ;

//24
moreExpressions:
            (COMA expression)*          #moreexpressifun
            ;

//25
primitiveExpression	:
                    INT             #intprimatiespresi
                    | STRING        #stringprimatiexpresi
                    | ID            #idprimatiexpresi
                    | CHAR          #charprimatiexpresi
                    | ParenIZQ expression ParenDER      #expresiprimatiexpresi
                    | listExpression                    #listexpresiprimatiexpresi
                    | LEN ParenIZQ expression ParenDER  #lenprimatiexpresi
                    | functionCallExpression            #functcallexpresiprimatiexpresi
                    ;

//26
listExpression:
            ParenSubIZQ expressionList ParenSubDER      #listexpresifun
            ;