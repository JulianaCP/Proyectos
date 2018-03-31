import generated.GParser;
import generated.GParserBaseVisitor;
import generated.Global;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created by Pruebas on 22/05/2017.
 */
public class CodeGen extends GParserBaseVisitor {

    LinkedList<Instruc> listaInstrucciones;

    class Instruc{
        private String instruccion;
        private String valor;
        private int cont;
        private boolean comment;

        public Instruc(String instruccion, String valor,int cont,boolean comment) {
            this.instruccion = instruccion;
            this.valor = valor;
            this.cont = cont;
            this.comment = comment;
        }

        public String getInstruccion() {
            return instruccion;
        }

        public void setInstruccion(String instruccion) {
            this.instruccion = instruccion;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public int getCont() {
            return cont;
        }

        public void setCont(int cont) {
            this.cont = cont;
        }

        public boolean getComment() {
            return comment;
        }

        public void setComment(boolean comment) {
            this.comment = comment;
        }
    }
    public CodeGen(){
        Global.cont = -1;
        listaInstrucciones = new LinkedList<Instruc>();
    }
    public void agregarInstruccion(String instrucciones ,String valor){
        if(instrucciones.equals("") && valor.equals("")){
            Instruc nuevo = new Instruc(instrucciones,valor,Global.cont,true);
            listaInstrucciones.add(nuevo);
        }
        else{
            Instruc nuevo = new Instruc(instrucciones,valor,Global.cont,false);
            listaInstrucciones.add(nuevo);
        }
    }
    public void imprimirLista(){

        try {

            PrintWriter filename= new PrintWriter("archivoInstrucciones.txt");


            for(int i = 0;i<listaInstrucciones.size();i++){
                if(listaInstrucciones.get(i).getComment()){
                    filename.println(listaInstrucciones.get(i).getInstruccion());
                }
                else{
                    filename.println(listaInstrucciones.get(i).getCont() +" "
                            + listaInstrucciones.get(i).getInstruccion()+" "+
                            listaInstrucciones.get(i).getValor());
                }
            }
            filename.close();


        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }

        for(int i = 0;i<listaInstrucciones.size();i++){
            if(listaInstrucciones.get(i).getComment()){
                System.out.println(listaInstrucciones.get(i).getInstruccion());
            }
            else{
                System.out.println(listaInstrucciones.get(i).getCont() +" "
                        + listaInstrucciones.get(i).getInstruccion()+" "+
                        listaInstrucciones.get(i).getValor());
            }
        }
    }


    @Override
    public Object visitStamentprogram(GParser.StamentprogramContext ctx) {
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        imprimirLista();
        return null;
    }

    @Override
    public Object visitDefstamentcall(GParser.DefstamentcallContext ctx) {
        visit(ctx.defStatement());
        return null;
    }

    @Override
    public Object visitIfstamentcall(GParser.IfstamentcallContext ctx) {
        visit(ctx.ifStatement());
        return null;
    }

    @Override
    public Object visitReturnstamentcall(GParser.ReturnstamentcallContext ctx) {
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
        visit(ctx.whileStatement());
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


        Instruc nuevo = new Instruc(ctx.ID().toString(),"",0,true);
        listaInstrucciones.add(nuevo);

        visit(ctx.argList());
        visit(ctx.sequence());
        return null;
    }

    @Override
    public Object visitIdarglist(GParser.IdarglistContext ctx) {
        visit(ctx.moreArgs());
        return null;
    }

    @Override
    public Object visitEspacarglist(GParser.EspacarglistContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreargsfun(GParser.MoreargsfunContext ctx) {
        return super.visitMoreargsfun(ctx);
    }

    @Override
    public Object visitIfstamentfun(GParser.IfstamentfunContext ctx) {
        int posTrue,posFalse;
        Instruc objeto_1,objeto_2;

        visit(ctx.expression());

        Global.cont = Global.cont + 1;
        agregarInstruccion("JUMP_IF_TRUE " ,Integer.toString(Global.cont));
        objeto_1 = listaInstrucciones.get(listaInstrucciones.size()-1);

        visit(ctx.sequence(1));

        Global.cont = Global.cont + 1;
        agregarInstruccion("JUMP_ABSOLUTE " ,Integer.toString(Global.cont));
        objeto_2 = listaInstrucciones.get(listaInstrucciones.size()-1);


        posTrue = Global.cont + 1;
        visit(ctx.sequence(0));
        posFalse = Global.cont + 1;


        objeto_1.setValor(Integer.toString(posTrue));
        objeto_2.setValor(Integer.toString(posFalse));

        return null;
    }

    @Override
    public Object visitWhilestamentfun(GParser.WhilestamentfunContext ctx) {
        int posInicial,posFinal;

        posInicial = Global.cont + 1;
        Instruc objeto_1,objeto_2;



        visit(ctx.expression());
        Global.cont = Global.cont + 1;
        agregarInstruccion("JUMP_IF_FALSE " ,Integer.toString(Global.cont));
        objeto_1 = listaInstrucciones.get(listaInstrucciones.size()-1);
        visit(ctx.sequence());


        Global.cont = Global.cont + 1;
        agregarInstruccion("JUMP_ABSOLUTE " ,Integer.toString(posInicial));

        posFinal = Global.cont + 1;

        objeto_1.setValor(Integer.toString(posFinal));
        return null;
    }

    @Override
    public Object visitReturnstamentfun(GParser.ReturnstamentfunContext ctx) {
        visit(ctx.expression());

        Global.cont = Global.cont + 1;
        agregarInstruccion("RETURN_VALUE" ,"");
        return null;
    }

    @Override
    public Object visitPrintstamentfun(GParser.PrintstamentfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_GLOBAL" ,"print");
        visit(ctx.expression());

        Global.cont = Global.cont + 1;
        agregarInstruccion("CALL_FUNCTION" ,"1");
        return null;
    }

    @Override
    public Object visitAssigstamentfun(GParser.AssigstamentfunContext ctx) {
        visit(ctx.expression());

        Global.cont = Global.cont + 1;
        agregarInstruccion("STORE_FAST" ,ctx.ID().toString());
        return null;
    }

    @Override
    public Object visitFunctcallstamentfun(GParser.FunctcallstamentfunContext ctx) {
        int cantParametros = 0;
        visit(ctx.primitiveExpression());
        Instruc objeto = listaInstrucciones.get(listaInstrucciones.size()-1);
        objeto.setInstruccion("LOAD_GLOBAL");
        Object retorno = visit(ctx.expressionList());
        if(retorno!=null){
            cantParametros = (int)retorno;
        }

        Global.cont = Global.cont + 1;
        agregarInstruccion("CALL_FUNCTION" ,Integer.toString(cantParametros));

        return null;
    }

    @Override
    public Object visitSequencefun(GParser.SequencefunContext ctx) {
        return super.visitSequencefun(ctx);
    }

    @Override
    public Object visitMorestamentfun(GParser.MorestamentfunContext ctx) {
        return super.visitMorestamentfun(ctx);
    }

    @Override
    public Object visitExpressinfun(GParser.ExpressinfunContext ctx) {
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        return null;
    }

    @Override
    public Object visitComparisonfun(GParser.ComparisonfunContext ctx) {
        for (int i=0; i <= ctx. additionExpression().size()-1; i++)
        {
            visit(ctx.additionExpression(i));
            visit(ctx.comparisonValores(i));
        }
        return null;
    }

    @Override
    public Object visitMenorfun(GParser.MenorfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("COMPARE_OP" ,"<");
        return null;
    }

    @Override
    public Object visitMayorfun(GParser.MayorfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("COMPARE_OP" ,">");
        return null;
    }

    @Override
    public Object visitMenorIgualfun(GParser.MenorIgualfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("COMPARE_OP" ,"<=");
        return null;
    }

    @Override
    public Object visitMayorigualfun(GParser.MayorigualfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("COMPARE_OP" ,">=");
        return null;
    }

    @Override
    public Object visitIgualigualfun(GParser.IgualigualfunContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("COMPARE_OP" ,"==");
        return null;
    }

    @Override
    public Object visitAddiexpressifun(GParser.AddiexpressifunContext ctx) {
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());


        return null;
    }

    @Override
    public Object visitAddifactfun(GParser.AddifactfunContext ctx) {



        for (int i=0; i <= ctx. multiplicationExpression().size()-1; i++)
        {
            visit(ctx.multiplicationExpression(i));
            visit(ctx.factoresSumaResta(i));
        }
        return null;
    }

    @Override
    public Object visitSumafunc(GParser.SumafuncContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("BINARY_ADD" ,"");
        return null;
    }

    @Override
    public Object visitRestafunc(GParser.RestafuncContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("BINARY_SUBSTRACT" ,"");
        return null;
    }

    @Override
    public Object visitMultexpressifun(GParser.MultexpressifunContext ctx) {

        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());

        return null;
    }

    @Override
    public Object visitMultfactfun(GParser.MultfactfunContext ctx) {
        for (int i=0; i <= ctx. elementExpression().size()-1; i++)
        {
            visit(ctx.elementExpression(i));
            visit(ctx.factoresMultDiv(i));
        }
        return null;
    }

    @Override
    public Object visitMultfunc(GParser.MultfuncContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("BINARY_MULTIPLY" ,"");
        return null;
    }

    @Override
    public Object visitDivfunc(GParser.DivfuncContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("BINARY_DIVIDE" ,"");
        return null;
    }

    @Override
    public Object visitElementexpressifun(GParser.ElementexpressifunContext ctx) {

        visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());
        return null;
    }

    @Override
    public Object visitElementaccessfun(GParser.ElementaccessfunContext ctx) {

        for (int i = 0; i <= ctx.expression().size() - 1; i++)
        {
            visit(ctx.expression(i));
            Global.cont = Global.cont + 1;
            agregarInstruccion("BINARY_SUBSCR" ,"");
        }
        return null;
    }

    @Override
    public Object visitFunctcallexpressifun(GParser.FunctcallexpressifunContext ctx) {
        int cantParametros = 0;

        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_GLOBAL" ,ctx.ID().toString());
        Object retorno = visit(ctx.expressionList());
        if(retorno != null){
            cantParametros = (int)retorno;
        }
        Global.cont = Global.cont + 1;
        agregarInstruccion("CALL_FUNCTION" ,Integer.toString(cantParametros));
        return null;
    }

    @Override
    public Object visitExpressiexpressilist(GParser.ExpressiexpressilistContext ctx) {
        int cont = 1;
        visit(ctx.expression());

        int retorno = (int)visit(ctx.moreExpressions());


        return cont + retorno;
    }

    @Override
    public Object visitEspacexpressilist(GParser.EspacexpressilistContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreexpressifun(GParser.MoreexpressifunContext ctx) {
        int cont = 0;
        for (int i=0; i <= ctx. expression().size()-1; i++)
        {
            cont++;
            visit(ctx.expression(i));
        }
        return cont;
    }

    @Override
    public Object visitIntprimatiespresi(GParser.IntprimatiespresiContext ctx) {
        //INSTRUCCION INT
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_CONST" ,ctx.INT().toString());
        return null;
    }

    @Override
    public Object visitStringprimatiexpresi(GParser.StringprimatiexpresiContext ctx) {
        //INSTRUCCION STRING
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_CONST" ,ctx.STRING().toString());
        return null;
    }

    @Override
    public Object visitIdprimatiexpresi(GParser.IdprimatiexpresiContext ctx) {
        //INSTRUCCION FAST
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_FAST" ,ctx.ID().toString());
        return null;
    }

    @Override
    public Object visitCharprimatiexpresi(GParser.CharprimatiexpresiContext ctx) {
        //INSTRUCCION CHAR
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_CONST" ,ctx.CHAR().toString());
        return null;
    }

    @Override
    public Object visitExpresiprimatiexpresi(GParser.ExpresiprimatiexpresiContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitListexpresiprimatiexpresi(GParser.ListexpresiprimatiexpresiContext ctx) {
        visit(ctx.listExpression());
        return null;
    }

    @Override
    public Object visitLenprimatiexpresi(GParser.LenprimatiexpresiContext ctx) {
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_GLOBAL","len");
        visit(ctx.expression());

        Global.cont = Global.cont + 1;
        agregarInstruccion("CALL_FUNCTION","1");



        return null;
    }

    @Override
    public Object visitFunctcallexpresiprimatiexpresi(GParser.FunctcallexpresiprimatiexpresiContext ctx) {
        visit(ctx.functionCallExpression());
        return null;
    }

    @Override
    public Object visitListexpresifun(GParser.ListexpresifunContext ctx) {
        visit(ctx.expressionList());
        Global.cont = Global.cont + 1;
        agregarInstruccion("BUILD_LIST","");
        return null;
    }
}
