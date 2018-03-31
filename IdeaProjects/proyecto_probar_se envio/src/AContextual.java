import generated.GParser;
import generated.GParserBaseVisitor;
import generated.Global;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Juliana on 18/04/2017.
 */
public class AContextual extends GParserBaseVisitor {

    private TablaSimbolos tablaSimbolos;
    public AContextual(){
        tablaSimbolos = new TablaSimbolos();
    }
    @Override
    public Object visitStamentprogram(GParser.StamentprogramContext ctx) {
        System.out.println("visitStamentprogram");
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            System.out.println("\n\nnuevo stament\n\n");
            visit(ctx.statement(i));
            System.out.println("\n\nfinal stament\n\n");
        }
        return null;
    }

    @Override
    public Object visitDefstamentcall(GParser.DefstamentcallContext ctx) {
        Global.nivel = Global.nivel + 1;
        visit(ctx.defStatement());

        tablaSimbolos.eliminar(Global.nivel);

        Global.nivel = Global.nivel - 1;

        return null;
    }

    @Override
    public Object visitIfstamentcall(GParser.IfstamentcallContext ctx) {

        Global.nivel = Global.nivel + 1;
        visit(ctx.ifStatement());
        tablaSimbolos.eliminar(Global.nivel);
        Global.nivel = Global.nivel - 1;
        return null;
    }

    @Override
    public Object visitReturnstamentcall(GParser.ReturnstamentcallContext ctx) {
        System.out.println("visitReturnstamentcall");
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitPrintstamentcall(GParser.PrintstamentcallContext ctx) {
        visit(ctx.printStatement());

        return null;
    }

    @Override
    public Object visitWhilestamentcall(GParser.WhilestamentcallContext ctx) {

        Global.nivel = Global.nivel + 1;
        visit(ctx.whileStatement());
        tablaSimbolos.eliminar(Global.nivel);
        Global.nivel = Global.nivel - 1;

        return null;
    }

    @Override
    public Object visitAssigstamentcall(GParser.AssigstamentcallContext ctx) {

        visit(ctx.assignStatement());
        return null;
    }

    @Override
    public Object visitFunctioncallstamentcall(GParser.FunctioncallstamentcallContext ctx) {
        visit(ctx.functionCallStatement());
        return null;
    }

    @Override
    public Object visitDefstamentfun(GParser.DefstamentfunContext ctx) {
        Global.listaAtributosGlobal.clear();
        Global.tipoRetornoAsignarDef = Global.RETURNO;
        Global.defActual = ctx.ID().getSymbol().getText();
        String valorTexto =  ctx.ID().getSymbol().getText();
        System.out.println("ID def: "+valorTexto);

        Object objeto = tablaSimbolos.buscar(Global.nivel,valorTexto,"def");

        if(objeto ==null ){
            System.out.println("def en tabla: NO ");
            Object parametros = visit(ctx.argList());
            System.out.println("LISTA DEL DEF STAMENT: " + Global.listaAtributosGlobal);
            List<Integer> copiaParametros = funcionCrear(Global.listaAtributosGlobal);
            if(parametros == null){
                parametros = 0; //no tiene parmetros
            }
            if((int)parametros == Global.FALLO){
                System.out.println("error parametros def");
                return null;
            }
            System.out.println("visita sequenceeeeeee");
            visit(ctx.sequence());
            System.out.println("sale sequence");
            //List<Integer> listaNuevaCopia = funcionCrear(Global.listaAtributosGlobal);
            tablaSimbolos.insertar(Global.DEF,valorTexto,Global.nivel-1,ctx
                    ,(int)parametros,Global.tipoRetornoAsignarDef,copiaParametros);

            TablaSimbolos.Ident objeto2  = tablaSimbolos.buscar(Global.nivel
                    ,valorTexto,"def");
            System.out.println("tipo: "+objeto2.tipo+" texto: "+objeto2.texto
                    +" nivel: "+objeto2.nivel+" parametros: "+objeto2.cantidadParametros
                    +" valor de returno: "+objeto2.retornoValor
                    + " lista: " + objeto2.listaAtributos);
            return null;
        }
        else{
            int fila = ctx.DEF().getSymbol().getLine();
            int columna = ctx.DEF().getSymbol().getCharPositionInLine();
            columna++;
            System.out.println("funcion ya se encuentra declarada:  fila "+fila
                     + " columna: " + columna);


            String stringInsertarModelo = "funcion ya se encuentra declarada:  fila "+fila
                    + " columna: " + columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
    }
    public List<Integer> funcionCrear(List<Integer> lista){
        List<Integer> nueva = new ArrayList<Integer>();
        for(int i=0;i<lista.size();i++){
            nueva.add(lista.get(i));
        }
        return nueva;
    }

    @Override
    public Object visitIdarglist(GParser.IdarglistContext ctx) {


        String valor = ctx.ID().getText();
        TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel,valor,"variable");

        if(objeto== null){
            int fila = ctx.ID().getSymbol().getLine();
            int columna = ctx.ID().getSymbol().getCharPositionInLine();
            columna++;
            //error
            System.out.println("ID indefinido -> ID: => fila:"
                    +fila+" columna:"+columna);

            String stringInsertarModelo = "ID indefinido -> ID: => fila:"
                    +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);

            return Global.FALLO;
        }
        else{
            Global.listaAtributosGlobal.clear();
            int tipo = objeto.tipo;

            int cantValores = 0;
            if(tipo == Global.STRING || tipo == Global.INT
                    || tipo== Global.CHAR){
                Global.listaAtributosGlobal.add(tipo);
                cantValores++;

                System.out.println("par 1: "+cantValores);
                Object valorTotales = visit(ctx.moreArgs());
                if(valorTotales == null){
                    return Global.FALLO;
                }

                System.out.println("par 2: "+(int)valorTotales);

                cantValores = cantValores + (int)valorTotales;
                System.out.println("par total: "+cantValores);
                return cantValores;
            }
            else{
                int fila = ctx.ID().getSymbol().getLine();
                int columna = ctx.ID().getSymbol().getCharPositionInLine();
                columna++;
                System.out.println("Tipo dato incompatible->se espera int," +
                        "char,string: "+fila + " columna: " + columna);


                String stringInsertarModelo = "Tipo dato incompatible->se espera int," +
                        "char,string: "+fila + " columna: " + columna;
                Global.modeloG.addElement(stringInsertarModelo);

                return Global.FALLO;
            }
        }
    }

    @Override
    public Object visitEspacarglist(GParser.EspacarglistContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreargsfun(GParser.MoreargsfunContext ctx) {
        int valores = 0;
        for (int i = 0; i <= ctx.ID().size() - 1; i++)
        {

            int tipo;
            String valorTexto = ctx.ID(i).getText();
            TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel,valorTexto
                    ,"variable");
            if(objeto==null ){
                int fila = ctx.ID(i).getSymbol().getLine();
                int columna = ctx.ID(i).getSymbol().getCharPositionInLine();
                columna++;
                System.out.println("ID indefinido -> ID: => fila:"
                        +fila+" columna:"+columna);

                String stringInsertarModelo = "ID indefinido -> ID: => fila:"
                        +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;

            }
            else{
                tipo = objeto.tipo;
                if(tipo == Global.STRING || tipo == Global.INT
                        || tipo== Global.CHAR){
                    Global.listaAtributosGlobal.add(tipo);
                    valores ++;
                }
                else{
                    int fila = ctx.ID(i).getSymbol().getLine();
                    int columna = ctx.ID(i).getSymbol().getCharPositionInLine();
                    columna++;
                    System.out.println("Tipo dato incompatible->se espera int," +
                            "char,string: "+fila + " columna: " + columna);

                    String stringInsertarModelo = "Tipo dato incompatible->se espera int," +
                            "char,string: "+fila + " columna: " + columna;
                    Global.modeloG.addElement(stringInsertarModelo);

                    return null;
                }

            }
        }
        return valores;
    }

    @Override
    public Object visitIfstamentfun(GParser.IfstamentfunContext ctx) {
        Object tipoIZQ=visit(ctx.expression());
        if(tipoIZQ == null){
            return null;
        }
        for (int i = 0; i <= ctx.sequence().size() - 1; i++)
        {
            visit(ctx.sequence(i));
        }
        return null;

    }

    @Override
    public Object visitWhilestamentfun(GParser.WhilestamentfunContext ctx) {

        Object tipoIZQ = visit(ctx.expression());
        if(tipoIZQ == null){
            return null;
        }
        visit(ctx.sequence());
        return null;
    }

    @Override
    public Object visitReturnstamentfun(GParser.ReturnstamentfunContext ctx) {

        Object tipoRetorno = visit(ctx.expression());
        if(tipoRetorno==null){
            return null;
        }
        System.out.println("visitReturnstamentfun.. return devuelve tipo: " +(int)tipoRetorno);

        if((int)tipoRetorno != Global.STRING  && (int)tipoRetorno != Global.INT
                && (int)tipoRetorno != Global.CHAR && (int)tipoRetorno != Global.LIST){
            int fila = Global.fila;
            int columna = Global.columna;
            columna++;
            //error
            System.out.println("Tipo Dato incompatible -> se espera int,string,char,list."
                    + " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "Tipo Dato incompatible -> se espera int,string,char,list."
                    + " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        Global.tipoRetornoAsignarDef = (int)tipoRetorno;
        /*
        TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel
                ,Global.defActual,"def");

        System.out.println("def " +Global.defActual+ " retorno: " + objeto.tipo);
        objeto.setRetornoValor((int)tipoRetorno);

        System.out.println("def " +Global.defActual+ " retorno: " + objeto.tipo+ " CAMBIO");

*/
        return null;
    }

    @Override
    public Object visitPrintstamentfun(GParser.PrintstamentfunContext ctx) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvisitPrintstamentfun");
        Object tipo = visit(ctx.expression());
        if(tipo==null){
            return null;
        }
        if((int)tipo != Global.STRING && (int)tipo != Global.INT
                && (int)tipo != Global.CHAR && (int)tipo != Global.LIST){
            int fila = ctx.ParenIZQ().getSymbol().getLine();
            int columna = ctx.ParenIZQ().getSymbol().getCharPositionInLine();
            columna++;
            System.out.println("Tipo dato incompatible -> se espera int,sting,char,list"
                    +" fila: "+fila+" columna: "+columna);

            String stringInsertarModelo = "Tipo dato incompatible -> se espera int,sting,char,list"
                    +" fila: "+fila+" columna: "+columna;
            Global.modeloG.addElement(stringInsertarModelo);

            return null;
        }
        return null;

    }

    @Override
    public Object visitAssigstamentfun(GParser.AssigstamentfunContext ctx) {
        String textoID = ctx.ID().getSymbol().getText();
        TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel
                ,textoID,"Variable");
        Object tipoDER = visit(ctx.expression());

        if(tipoDER==null) {
            return null;
        }
        System.out.println("\nDATO: "+(int)tipoDER);
        int fila = ctx.IGUAL().getSymbol().getLine();
        int columna = ctx.IGUAL().getSymbol().getCharPositionInLine();
        columna+=2;
        if (objeto != null) {
            System.out.println("\nexiste variable DATO: "+(int)tipoDER);
            int t1 = objeto.tipo;
            if (t1 != (int)tipoDER){
                if((int)tipoDER == Global.RETURNO){
                    columna++;
                    System.out.println("La funcion no tiene retorno"
                            + " => fila:" +fila+" columna:"+columna);

                    String stringInsertarModelo = "La funcion no tiene retorno"
                            + " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);


                    return null;
                }
                //error

                System.out.println("Tipos incompatibles en fila:  "+fila
                        + " columna: " + columna);

                String stringInsertarModelo = "Tipos incompatibles en fila:  "+fila
                        + " columna: " + columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
            else{
                if(objeto.tipo == Global.LIST){
                    List<Integer> listaNuevaCopia = funcionCrear(Global.listaAtributosGlobal);
                    objeto.setListaAtributos(listaNuevaCopia);
                    System.out.println("asigno id existente..LISTA->nuevo largo: "+objeto.listaAtributos.size());
                }
            }
        }
        else{
            System.out.println("\n no existe variable DATO: "+(int)tipoDER);
            if((int)tipoDER == Global.RETURNO){
                System.out.println("La funcion no tiene retorno"
                        + " => fila:" +fila+" columna:"+columna);

                String stringInsertarModelo = "La funcion no tiene retorno"
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);

                return null;
            }
            if((int)tipoDER != Global.INT && (int)tipoDER != Global.STRING
                    && (int)tipoDER != Global.CHAR && (int)tipoDER != Global.LIST){
                //error
                System.out.println("Tipo de dato invalido"
                        + " => fila:" +fila+" columna:"+columna);

                String stringInsertarModelo = "Tipo de dato invalido"
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);

                return null;
            }
            if((int)tipoDER == Global.LIST){
                System.out.println("inserto..es un lista, " +
                        "cantidad elementos: "+ Global.listaAtributosGlobal.size());
                List<Integer> listaNuevaCopia = funcionCrear(Global.listaAtributosGlobal);
                tablaSimbolos.insertar((int)tipoDER,textoID,Global.nivel,ctx
                        ,0,Global.RETURNO,listaNuevaCopia);
            }
            else{
                System.out.println("inserto... es un: "+(int)tipoDER);

                tablaSimbolos.insertar((int)tipoDER,textoID,Global.nivel,ctx
                        ,0,Global.RETURNO,null);
            }
        }
        return null;
    }

    @Override
    public Object visitFunctcallstamentfun(GParser.FunctcallstamentfunContext ctx) {
        Global.listaAtributosGlobal.clear();
        System.out.println("++ visitFunctcallstamentfun");

        int bool = 1;
        int fila;
        int columna;


        Global.tipoOperacion = "def";
        Object tipoIZQ= visit(ctx.primitiveExpression());
        if(tipoIZQ == null){
            System.out.println("tipoIZQ null");
            return null;
        }
        if(Global.IDFunctionStament.equals("ID")){
            System.out.println("es un ID");
            Object cantValoresObjeto = visit(ctx.expressionList());
            System.out.println("cantValoresObjeto: "+cantValoresObjeto);
            if(cantValoresObjeto==null){
                System.out.println("sigue");

                return null;
            }
            int cantValores = (int)cantValoresObjeto;

            if(cantValores == Global.SIN_PARAMETROS){
                cantValores=0;
            }

            System.out.println("RETORNO CANTVALORES FUNSTAMENT: "+cantValores);
            String texto = Global.IDTEXTOFunctionStament;
            System.out.println("Global.IDFunctionStament "+Global.IDFunctionStament);
            TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel
                    ,texto,Global.tipoOperacion);
            if(objeto == null){
                fila = ctx.ParenIZQ().getSymbol().getLine();
                columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
                columna--;
                System.out.println("Funcion no declarada  fila: "+fila
                        +" columna: "+columna);

                String stringInsertarModelo = "Funcion no declarada  fila: "+fila
                        +" columna: "+columna;
                Global.modeloG.addElement(stringInsertarModelo);

            }
            else{
                fila = ctx.ParenDER().getSymbol().getLine();
                columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
                if(cantValores != objeto.cantidadParametros){
                    System.out.println("cantidad de parametros erroneos "+fila
                            +" columna: "+columna);


                    String stringInsertarModelo = "cantidad de parametros erroneos "+fila
                            +" columna: "+columna;
                    Global.modeloG.addElement(stringInsertarModelo);

                    return null;
                }



                List<Integer>listaDEF = objeto.listaAtributos;
                List<Integer>listaGlobal = Global.listaAtributosGlobal;
                System.out.println("lista parametros def: " + listaDEF
                        + "listaGlobal: "+listaGlobal);

                for(int i=0;i<listaDEF.size();i++) {
                    System.out.println("listaDEF.get(i): " + listaDEF.get(i)
                            + "listaGlobal.get(i): "+listaGlobal.get(i));
                    if (!listaDEF.get(i).equals(listaGlobal.get(i))) {
                        bool = 0;
                    }
                }
                if(bool==1){
                    return objeto.retornoValor;
                }
                else{
                    fila = ctx.ParenDER().getSymbol().getLine();
                    columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
                    columna++;
                    System.out.println("Parametros imcompatibles"
                            + " => fila:" +fila+" columna:"+columna);


                    String stringInsertarModelo = "Parametros imcompatibles"
                            + " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);

                    return null;
                }




            }

        }
        else {
            fila = ctx.ParenIZQ().getSymbol().getLine();
            columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
            System.out.println("Tipo dato incompatible ->se espera ID" + fila
                    + " columna: " + columna);

            String stringInsertarModelo = "Tipo dato incompatible ->se espera ID" + fila
                    + " columna: " + columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        return null;
    }

    @Override
    public Object visitSequencefun(GParser.SequencefunContext ctx)
    {
        System.out.println("visitSequencefun");
        visit(ctx.moreStatement());
        return null;
    }

    @Override
    public Object visitMorestamentfun(GParser.MorestamentfunContext ctx) {

        System.out.println("visitMorestamentfun");
        visit(ctx.statement(0));
        for (int i=1; i <= ctx. statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        return null;
    }

    @Override
    public Object visitExpressinfun(GParser.ExpressinfunContext ctx) {

        Object tipoIZQ = visit(ctx.additionExpression());

        if(tipoIZQ == null){
            System.out.println("visitExpressinfun -> TipoIZQ : null: ");
            return null;
        }
        System.out.println("visitExpressinfun ->additionExpression: "+(int)tipoIZQ);
        Object tipoDER = visit(ctx.comparison());

        if(tipoDER==null){
            return null;
        }
        System.out.println("visitExpressinfun ->comparison: "+(int)tipoDER);


        if((int)tipoDER == Global.INDEFINIDO){
            return tipoIZQ;
        }
        else{
            if((int)tipoIZQ == (int)tipoDER){
                if((int)tipoIZQ != Global.INT && (int)tipoIZQ != Global.CHAR){
                    int fila = Global.fila;
                    int columna = Global.columna;
                    columna++;
                    //error
                    System.out.println("Dato incompatible. Se esperaba INT o CHAR"
                            + " => fila:" +fila+" columna:"+columna);

                    String stringInsertarModelo = "Dato incompatible. Se esperaba INT o CHAR"
                            + " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);


                    return null;
                }
                return tipoIZQ;
            }
            else{
                int fila = Global.fila;
                int columna = Global.columna;
                columna++;
                //error
                System.out.println("Dato incompatible. Comparación entre tipos de datos distintos."
                        + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Dato incompatible. Comparación entre tipos de datos distintos."
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
        }
    }

    @Override
    public Object visitComparisonfun(GParser.ComparisonfunContext ctx) {
        Object tipoDER = Global.INDEFINIDO;
        for (int i=0; i <= ctx. additionExpression().size()-1; i++)
        {
            visit(ctx.comparisonValores(i));
            tipoDER = visit(ctx.additionExpression(i));
            if(tipoDER == null){
                return null;
            }
        }
        return tipoDER;
    }

    @Override
    public Object visitMenorfun(GParser.MenorfunContext ctx) {
        return null;
    }

    @Override
    public Object visitMayorfun(GParser.MayorfunContext ctx) {
        return null;
    }

    @Override
    public Object visitMenorIgualfun(GParser.MenorIgualfunContext ctx) {
        return null;
    }

    @Override
    public Object visitMayorigualfun(GParser.MayorigualfunContext ctx) {
        return null;
    }

    @Override
    public Object visitIgualigualfun(GParser.IgualigualfunContext ctx) {
        return null;
    }

    @Override
    public Object visitAddiexpressifun(GParser.AddiexpressifunContext ctx) {
        Object tipoIZQ = visit(ctx.multiplicationExpression());

        if(tipoIZQ == null){
            return null;
        }
        System.out.println("visitAddiexpressifun ->multiplicationExpression: "+tipoIZQ);

        Object tipoDER = visit(ctx.additionFactor());

        if(tipoDER == null){
            System.out.println("tipoDER==null");
            return null;
        }
        System.out.println("visitAddiexpressifun ->additionFactor: "+tipoDER);



        if((int)tipoDER == Global.INDEFINIDO){
            return tipoIZQ;
        }
        else{
            if((int)tipoIZQ == (int)tipoDER){
                return tipoIZQ;
            }
            else{
                int fila = Global.fila;
                int columna = Global.columna;
                columna++;
                //error
                System.out.println("Datos incompatibles"
                        + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Datos incompatibles"
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
        }
    }

    @Override
    public Object visitAddifactfun(GParser.AddifactfunContext ctx) {

        int fila;
        int columna;
        Object iniciador = Global.INDEFINIDO;
        for (int i=0; i <= ctx. multiplicationExpression().size()-1; i++)
        {
            Object tipoOperadorIZQ = visit(ctx.factoresSumaResta(i));
            Object tipoDER = visit(ctx.multiplicationExpression(i));
            System.out.println("visitAddifactfun ->factoresSumaResta: "+tipoOperadorIZQ);

            if(tipoDER == null){
                return null;
            }
            System.out.println("visitAddifactfun ->multiplicationExpression: "+tipoDER);
            if((int)tipoOperadorIZQ == Global.SUMA){
                if((int)tipoDER != Global.STRING && (int)tipoDER != Global.INT){
                    fila = Global.fila;
                    columna = Global.columna;
                    columna++;
                    //error
                    System.out.println("Dato inconsistente -> se esperaba" +
                            " int o string: " + " => fila:" +fila+" columna:"+columna);


                    String stringInsertarModelo = "Dato inconsistente -> se esperaba" +
                            " int o string: " + " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);

                    return null;
                }
            }
            if((int)tipoOperadorIZQ == Global.RESTA){
                if((int)tipoDER != Global.INT){
                    fila = Global.fila;
                    columna = Global.columna;
                    columna++;
                    //error
                    System.out.println("Dato inconsistente -> se esperaba" +
                            " int: " + " => fila:" +fila+" columna:"+columna);


                    String stringInsertarModelo = "Dato inconsistente -> se esperaba" +
                            " int: " + " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);


                    return null;
                }
            }
            if((int)iniciador == Global.INDEFINIDO) {
                if ((int)tipoDER == Global.STRING) {
                    iniciador = Global.STRING;
                } else {
                    iniciador = Global.INT;
                }
            }
            else{
                if((int)tipoDER != (int)iniciador){
                    fila = Global.fila;
                    columna = Global.columna;
                    columna++;
                    //error
                    System.out.println("Datos inconsistentes -> Mezcla de diferentes " +
                            "tipos de datos "+ " => fila:" +fila+" columna:"+columna);



                    String stringInsertarModelo = "Datos inconsistentes -> Mezcla de diferentes " +
                            "tipos de datos "+ " => fila:" +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);

                    return null;
                }
            }
        }
        return iniciador;
    }

    @Override
    public Object visitSumafunc(GParser.SumafuncContext ctx) {
        return Global.SUMA;
    }

    @Override
    public Object visitRestafunc(GParser.RestafuncContext ctx) {
        return Global.RESTA;
    }



    @Override
    public Object visitMultexpressifun(GParser.MultexpressifunContext ctx) {
        Object tipoIZQ = visit(ctx.elementExpression());

        if(tipoIZQ == null){
            return null;
        }
        System.out.println("visitMultexpressifun ->elementExpression: "+tipoIZQ);

        Object tipoDER = visit(ctx.multiplicationFactor());

        if(tipoDER == null){
            return null;
        }
        System.out.println("visitMultexpressifun ->multiplicationFactor: "+tipoDER);



        if((int)tipoDER == Global.INDEFINIDO){
            return tipoIZQ;
        }
        else if((int)tipoDER == Global.INT && (int)tipoIZQ == Global.INT){
            return tipoIZQ;
        }
        else{
            int fila = Global.fila;
            int columna = Global.columna;
            columna++;
            //error
            System.out.println("Dato imcompatibles -> Element expresion diferente a multiplication factor: "
                    + " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "Dato imcompatibles -> Element expresion diferente a multiplication factor: "
                    + " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);

            return null;
        }
    }

    @Override
    public Object visitMultfactfun(GParser.MultfactfunContext ctx) {

        Object objeto = Global.INDEFINIDO;
        for (int i=0; i <= ctx. elementExpression().size()-1; i++)
        {
            visit(ctx.factoresMultDiv(i));
            objeto = visit(ctx.elementExpression(i));

            if(objeto == null){
                return null;
            }
            System.out.println("visitMultfactfun ->elementExpression: "+objeto);
            if((int)objeto != Global.INT){
                int fila = Global.fila;
                int columna = Global.columna;
                columna++;
                //error
                System.out.println("Dato imcompatibles -> se esperaba int: "
                        + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Dato imcompatibles -> se esperaba int: "
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
        }

        return objeto;
    }

    @Override
    public Object visitMultfunc(GParser.MultfuncContext ctx) {
        return null;
    }

    @Override
    public Object visitDivfunc(GParser.DivfuncContext ctx) {
        return null;
    }

    @Override
    public Object visitElementexpressifun(GParser.ElementexpressifunContext ctx) {
        Global.tipoOperacion = "variable";
        Object tipoIZQ = visit(ctx.primitiveExpression());


        Object devolver = null;
        int valorSub;
        int fila;
        int columna;
        if(tipoIZQ == null){
            return null;
        }
        System.out.println("visitElementexpressifun ->primitiveExpression: IZQ: "+tipoIZQ);

        String valorTextoIDLista = Global.textoTipoAnterior;

        Object tipoDER = visit(ctx.elementAccess());

        if(tipoDER==null){
            return null;
        }
        System.out.println("visitElementexpressifun ->elementAccess: DER: "+tipoDER);
        if((int)tipoDER == Global.INT){
            if((int)tipoIZQ != Global.LIST){

                fila = Global.fila;
                columna = Global.columna;
                columna+=1;

                //error
                System.out.println("Dato incompatible -> Element Access: " +
                        "se espera list" + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Dato incompatible -> Element Access: " +
                        "se espera list" + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);

                return null;
            }
            else{
                valorSub = Integer.parseInt(Global.textoTipoAnterior);
                System.out.print("entro");
                //valorSub = Global.tipoAnteriorInt;
                System.out.println("valor Sub: " + valorSub);
                TablaSimbolos.Ident elementoTabla = tablaSimbolos.buscar(Global.nivel,valorTextoIDLista
                        ,"variable");
                List<Integer> lista = elementoTabla.listaAtributos;
                try{
                    devolver = lista.get(valorSub);
                }catch (Exception e){
                    fila = Global.fila;
                    columna = Global.columna;
                    columna++;
                    System.out.println("Valor Sub fuera de rango  -> Element Access:  fila"
                            +fila+" columna:"+columna);



                    String stringInsertarModelo = "Valor Sub fuera de rango  -> Element Access:  fila"
                            +fila+" columna:"+columna;
                    Global.modeloG.addElement(stringInsertarModelo);


                    devolver = null;
                }
                return devolver;
            }
        }
        if((int)tipoDER != Global.INDEFINIDO){
              fila = Global.fila;
              columna = Global.columna;
              columna+=2;

              //error
              System.out.println("Dato incompatible -> Element Access: " +
                      "se espera int" + " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "Dato incompatible -> Element Access: " +
                    "se espera int" + " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        return tipoIZQ;
    }

    @Override
    public Object visitElementaccessfun(GParser.ElementaccessfunContext ctx) {

        int fila;
        int columna;
        int iniciador = Global.INDEFINIDO;
        for (int i = 0; i <= ctx.expression().size() - 1; i++)
        {
            Object tipo = visit(ctx.expression(i));


            if(tipo == null){
                return null;
            }
            System.out.println("visitElementaccessfun ->expression: "+tipo);
            if((int)tipo!=Global.INT){
                fila = ctx.ParenSubIZQ().get(i).getSymbol().getLine();
                columna = ctx.ParenSubIZQ().get(i).getSymbol().getCharPositionInLine();
                columna+=2;

                //error
                System.out.println("Dato incompatible -> Element Access: " +
                        "se espera int" + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Dato incompatible -> Element Access: " +
                        "se espera int" + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
            if(iniciador == Global.INDEFINIDO) {
                iniciador = Global.INT;
            }
        }
        return iniciador;
    }

    @Override
    public Object visitFunctcallexpressifun(GParser.FunctcallexpressifunContext ctx) {
        int fila;
        int columna;
        int bool = 1;

        String textoID = ctx.ID().getSymbol().getText();

        TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel,
                textoID,"def");



        if(objeto == null){
            fila = ctx.ID().getSymbol().getLine();
            columna = ctx.ID().getSymbol().getCharPositionInLine();
            columna++;

            //error
            System.out.println("funcion no ha sido declarada"
                    + " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "funcion no ha sido declarada"
                    + " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);

            return null;
        }
        else{

            System.out.println("ARRIBA...info objeto: "+objeto.texto+ " par: "+ objeto.cantidadParametros
                    +"lista: "+objeto.listaAtributos);


            System.out.println("visit expressionList");
            Object parametrosObjeto = visit(ctx.expressionList());

            if(parametrosObjeto==null){
                return null;
            }
            int parametros = (int)parametrosObjeto;

            System.out.println("DESPUES...info objeto: "+objeto.texto+ " par: "+ objeto.cantidadParametros
                    +"lista: "+objeto.listaAtributos);
            if(parametros == Global.SIN_PARAMETROS){
                parametros=0;
            }
            System.out.println("cantidadParametrosCALL: "+parametros
                    + " cantidadParametrosDEF: "+objeto.cantidadParametros);

            System.out.println("info objeto: "+objeto.texto+ " par: "+ objeto.cantidadParametros
                    +"lista: "+objeto.listaAtributos);



            if(parametros != objeto.cantidadParametros){
                fila = ctx.ParenDER().getSymbol().getLine();
                columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
                columna++;
                System.out.println("cantidad de parametros erroneos"
                        + " => fila:" +fila+" columna:"+columna);

                String stringInsertarModelo = "cantidad de parametros erroneos"
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);


                return null;
            }
            List<Integer>listaDEF = objeto.listaAtributos;
            List<Integer>listaGlobal = Global.listaAtributosGlobal;
            System.out.println("lista parametros def: " + listaDEF
                    + "listaGlobal: "+listaGlobal);

            for(int i=0;i<listaDEF.size();i++) {
                System.out.println("listaDEF.get(i): " + listaDEF.get(i)
                        + "listaGlobal.get(i): "+listaGlobal.get(i));
                if (!listaDEF.get(i).equals(listaGlobal.get(i))) {
                    bool = 0;
                }
            }
            if(bool==1){
                return objeto.retornoValor;
            }
            else{
                fila = ctx.ParenDER().getSymbol().getLine();
                columna = ctx.ParenDER().getSymbol().getCharPositionInLine();
                columna++;
                System.out.println("Parametros imcompatibles"
                        + " => fila:" +fila+" columna:"+columna);


                String stringInsertarModelo = "Parametros imcompatibles"
                        + " => fila:" +fila+" columna:"+columna;
                Global.modeloG.addElement(stringInsertarModelo);

                return null;
            }
        }
    }

    @Override
    public Object visitExpressiexpressilist(GParser.ExpressiexpressilistContext ctx) {
        System.out.println("adentro visitExpressiexpressilist");
        Global.listaAtributosGlobal.clear();
        int cantValores = 0;


        System.out.print("1");
        Object tipo = visit(ctx.expression());
        System.out.print("2");
        if(tipo == null){
            System.out.print(" ....2 ->null");
            return null;
        }

        if((int)tipo == Global.STRING || (int)tipo == Global.INT
                || (int)tipo == Global.CHAR){
            Global.listaAtributosGlobal.add((int)tipo); //primer elemento
            cantValores++;
            Object valorTotales = visit(ctx.moreExpressions());
            if(valorTotales == null){
                return null;
            }
            cantValores = cantValores + (int)valorTotales;
            System.out.println("LISTA DEL EXPRESION LIST: " + Global.listaAtributosGlobal);
            System.out.println("expresion list cantidad parametros: "+cantValores);
            return cantValores;
        }
        else{
            int fila = Global.fila;
            int columna = Global.columna;
            columna+=2;

            //error
            System.out.println("Dato incompatible -> List: se espera int,char o string" +
                    " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "Dato incompatible -> List: se espera int,char o string" +
                    " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
    }

    @Override
    public Object visitEspacexpressilist(GParser.EspacexpressilistContext ctx) {

        return Global.SIN_PARAMETROS;
    }

    @Override
    public Object visitMoreexpressifun(GParser.MoreexpressifunContext ctx) {
        System.out.println("visitMoreexpressifun");
        int valores = 0;
        boolean bool = true;
        int fila = 0;
        int columna = 0;
        for (int i=0; i <= ctx. expression().size()-1; i++)
        {
            Object tipoObject = visit(ctx.expression(i));
            if(tipoObject==null){
                return null;
            }

            int tipo=(int)tipoObject;
            if(tipo != Global.INT && tipo!=Global.STRING
                    && tipo!= Global.CHAR){
                fila = ctx.COMA().get(i).getSymbol().getLine();
                columna = ctx.COMA().get(i).getSymbol().getCharPositionInLine();
                columna+=2;

                //error
              // System.out.println("Dato incompatible -> List: se espera int,char o string" + " => fila:" +fila+" columna:"+columna);
                bool = false;
                break;
            }
            Global.listaAtributosGlobal.add(tipo);
            valores++;

        }
        if(!bool){
            //error
            System.out.println("Dato incompatible -> List: se espera int,char o string" +
                    " => fila:" +fila+" columna:"+columna);


            String stringInsertarModelo = "Dato incompatible -> List: se espera int,char o string" +
                    " => fila:" +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        else{
            return valores;
        }
    }

    @Override
    public Object visitIntprimatiespresi(GParser.IntprimatiespresiContext ctx) {
        System.out.println("visitIntprimatiespresi ->int: valor:"+ctx.INT().getText());
        Global.fila = ctx.INT().getSymbol().getLine();
        Global.columna = ctx.INT().getSymbol().getCharPositionInLine();
        Global.tipoAnteriorInt  = ctx.INT().getSymbol().getType();
        Global.textoTipoAnterior = ctx.INT().getText();
        return Global.INT;
    }

    @Override
    public Object visitStringprimatiexpresi(GParser.StringprimatiexpresiContext ctx) {
        System.out.println("visitStringprimatiexpresi ->string: valor:"+ctx.STRING().getText());
        Global.fila = ctx.STRING().getSymbol().getLine();
        Global.columna = ctx.STRING().getSymbol().getCharPositionInLine();
        return Global.STRING;
    }

    @Override
    public Object visitIdprimatiexpresi(GParser.IdprimatiexpresiContext ctx) {
        System.out.println("visitIdprimatiexpresi ->ID: valor:"+ctx.ID().getText());


        String valor = ctx.ID().getText();
        TablaSimbolos.Ident objeto = tablaSimbolos.buscar(Global.nivel,valor,Global.tipoOperacion);

        if(objeto== null){
            int fila = ctx.ID().getSymbol().getLine();
            int columna = ctx.ID().getSymbol().getCharPositionInLine();
            //error
            columna++;
            System.out.println("ID indefinido -> ID: => fila:"
                    +fila+" columna:"+columna);


            String stringInsertarModelo = "ID indefinido -> ID: => fila:"
                    +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        else{
            Global.fila = ctx.ID().getSymbol().getLine();
            Global.columna = ctx.ID().getSymbol().getCharPositionInLine();
            Global.tipoAnterior = "ID";
            Global.IDFunctionStament = "ID";
            Global.IDTEXTOFunctionStament = ctx.getText();
            Global.textoTipoAnterior  = ctx.getText();
            if(objeto.tipo == Global.LIST){
                List<Integer> copia = funcionCrear(objeto.listaAtributos);
                Global.listaAtributosGlobal = copia;
            }
            return objeto.tipo;
        }
    }

    @Override
    public Object visitCharprimatiexpresi(GParser.CharprimatiexpresiContext ctx) {
        System.out.println("visitCharprimatiexpresi ->CHAR: valor:"+ctx.CHAR().getText());

        Global.fila = ctx.CHAR().getSymbol().getLine();
        Global.columna = ctx.CHAR().getSymbol().getCharPositionInLine();
        return Global.CHAR;
    }

    @Override
    public Object visitExpresiprimatiexpresi(GParser.ExpresiprimatiexpresiContext ctx) {
        System.out.println("visitExpresiprimatiexpresi");
        Object objeto = visit(ctx.expression());
        if(objeto == null){
            return null;
        }
        return objeto;

    }

    @Override
    public Object visitListexpresiprimatiexpresi(GParser.ListexpresiprimatiexpresiContext ctx) {
        Global.listaAtributosGlobal.clear();
        System.out.println("visitListexpresiprimatiexpresi");
        Object objeto = visit(ctx.listExpression());
        if(objeto==null){
            return null;
        }
        return Global.LIST;
    }

    @Override
    public Object visitLenprimatiexpresi(GParser.LenprimatiexpresiContext ctx) {
        System.out.println("visitLenprimatiexpresi");
        Object tipo = visit(ctx.expression());
        if(tipo==null){
            return null;
        }
        if((int)tipo != Global.STRING && (int)tipo != Global.LIST){
            int fila = ctx.ParenIZQ().getSymbol().getLine();
            int columna = ctx.ParenIZQ().getSymbol().getCharPositionInLine();
            columna += 2  ;
            //error

            System.out.println("Dato incompatible -> LEN: se espera lista o string => fila:"
                    +fila+" columna:"+columna);



            String stringInsertarModelo = "Dato incompatible -> LEN: se espera lista o string => fila:"
                    +fila+" columna:"+columna;
            Global.modeloG.addElement(stringInsertarModelo);


            return null;
        }
        Global.fila = ctx.LEN().getSymbol().getLine();
        Global.columna = ctx.LEN().getSymbol().getCharPositionInLine();
        return Global.INT;

    }

    @Override
    public Object visitFunctcallexpresiprimatiexpresi(GParser.FunctcallexpresiprimatiexpresiContext ctx) {
        System.out.println("visitFunctcallexpresiprimatiexpresi");
        Object tipo = visit(ctx.functionCallExpression());
        if(tipo==null){
            return null;
        }
        else{
            return tipo;
        }

    }

    @Override
    public Object visitListexpresifun(GParser.ListexpresifunContext ctx) {
        System.out.println("visitListexpresifun");
        Object objeto = visit(ctx.expressionList());
        if(objeto == null){
            return null;
        }
        System.out.println("antes de null");
        return Global.ESTA_BIEN;

    }
}
