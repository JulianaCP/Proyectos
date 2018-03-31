import generated.*;

import javax.xml.bind.annotation.XmlElementDecl;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by oviquez on 8/9/2016.
 */
public class CodeGen extends miniPythonBaseVisitor<Object> {

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
        System.out.println("------------------------");
        Global.cont = 0;
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

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitProgram_AST(miniPythonParser.Program_ASTContext ctx) {

        System.out.println("stament");
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            System.out.println("stament adentro");
            visit(ctx.statement(i));
        }

        imprimirLista();

        return null;

    }
    public void imprimirLista(){
        for(int i = 0;i<listaInstrucciones.size();i++){
            if(listaInstrucciones.get(i).getComment()){
                System.out.println("");
            }
            else{
                System.out.println(listaInstrucciones.get(i).getCont() +" "
                        + listaInstrucciones.get(i).getInstruccion()+" "+
                        listaInstrucciones.get(i).getValor());
            }
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_DefStatement_AST(miniPythonParser.Statement_DefStatement_ASTContext ctx) {

        visit(ctx.defStatement());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_IfStatement_AST(miniPythonParser.Statement_IfStatement_ASTContext ctx) {

        agregarInstruccion("","");
        visit(ctx.ifStatement());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_ReturnStatement_AST(miniPythonParser.Statement_ReturnStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_PrintStatement_AST(miniPythonParser.Statement_PrintStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_WhileStatement_AST(miniPythonParser.Statement_WhileStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_AssignStatement_AST(miniPythonParser.Statement_AssignStatement_ASTContext ctx) {

        visit(ctx.assignStatement());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_FunctionCallStatement_AST(miniPythonParser.Statement_FunctionCallStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDefStatement_AST(miniPythonParser.DefStatement_ASTContext ctx) {
        
        //debo generar la instrucción para el nombre del método y sus argumentos
        visit(ctx.sequence());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgList_MoreArgs_AST(miniPythonParser.ArgList_MoreArgs_ASTContext ctx) {         

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgList_Epsilon_AST(miniPythonParser.ArgList_Epsilon_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreArgs_AST(miniPythonParser.MoreArgs_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIfStatement_AST(miniPythonParser.IfStatement_ASTContext ctx) {
            int posTrue;
            int posFalse;
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

        //actualizarIF(posTrue,posFalse);
        System.out.println("call actualizar : "+ Global.cont);

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitWhileStatement_AST(miniPythonParser.WhileStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitReturnStatement_AST(miniPythonParser.ReturnStatement_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrintStatement_AST(miniPythonParser.PrintStatement_ASTContext ctx) {
        
        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAssignStatement_AST(miniPythonParser.AssignStatement_ASTContext ctx) {
        
        visit(ctx.expression());

        //generar instrucción STORE_FAST

        Global.cont = Global.cont + 1;
        agregarInstruccion("STORE_FAST " ,ctx.IDENTIFIER().toString());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctionCallStatement_AST(miniPythonParser.FunctionCallStatement_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFceEnding(miniPythonParser.FceEndingContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSequence_AST(miniPythonParser.Sequence_ASTContext ctx) {

        visit(ctx.moreStatement());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreStatement_AST(miniPythonParser.MoreStatement_ASTContext ctx) {

        for (int i=0; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpression_AST(miniPythonParser.Expression_ASTContext ctx) {
        
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitComparison_AST(miniPythonParser.Comparison_ASTContext ctx) {
        
        
        if (ctx.additionExpression().size()!=0)
        {
            //deben visitarse todas las additionExpression
            visit(ctx.additionExpression(0));

            //debe elegiste cual de los operadores viene para saber cual instrucción generar
            Global.cont = Global.cont + 1;
            agregarInstruccion("COMPARE_OP " ,"<");
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditionExpression_AST(miniPythonParser.AdditionExpression_ASTContext ctx) {

        visit(ctx.multiplicationExpression());
        //visit(ctx.additionFactor());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditionFactor_AST(miniPythonParser.AdditionFactor_ASTContext ctx) {

        //deben visitar todos los multiplicationExpression

        visit(ctx.multiplicationExpression(0));

        // genere ADD o SUB dependiendo de cual venga

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMultiplicationExpression_AST(miniPythonParser.MultiplicationExpression_ASTContext ctx) {

        visit(ctx.elementExpression());

        visit(ctx.multiplicationFactor());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMultiplicationFactor_AST(miniPythonParser.MultiplicationFactor_ASTContext ctx) {

        //deben visitar todos los elementExpression
        if (ctx.elementExpression().size()!=0) {
            visit(ctx.elementExpression(0));

            // genere MUL o DIV dependiendo de cual venga
            Global.cont = Global.cont + 1;
            agregarInstruccion("BINARY_MULTIPLY" ,"");
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitElementExpression_AST(miniPythonParser.ElementExpression_ASTContext ctx) {
        
        visit(ctx.primitiveExpression());
        //recordar visitar el elementAccess

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitElementAccess_AST(miniPythonParser.ElementAccess_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctionCallExpression_AST(miniPythonParser.FunctionCallExpression_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpressionList_AST(miniPythonParser.ExpressionList_ASTContext ctx) {

        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpressionList_EPSILON_AST(miniPythonParser.ExpressionList_EPSILON_ASTContext ctx) {


        //visitas
       return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreExpressions_AST(miniPythonParser.MoreExpressions_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_NUM_AST(miniPythonParser.PrimitiveExpression_NUM_ASTContext ctx) {

        //Generar la instruccion LOAD_CONST
        Global.cont = Global.cont + 1;

        agregarInstruccion("LOAD_CONST ",ctx.NUM().toString());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_STR_AST(miniPythonParser.PrimitiveExpression_STR_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_IDENTIFIER_AST(miniPythonParser.PrimitiveExpression_IDENTIFIER_ASTContext ctx) {
        //Generar la instruccion LOAD_FAST
        Global.cont = Global.cont + 1;
        agregarInstruccion("LOAD_FAST",ctx.IDENTIFIER().toString());

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_CHAR_AST(miniPythonParser.PrimitiveExpression_CHAR_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_Expression_AST(miniPythonParser.PrimitiveExpression_Expression_ASTContext ctx) {

        visit(ctx.expression());
        //visitas
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_ListExpression_AST(miniPythonParser.PrimitiveExpression_ListExpression_ASTContext ctx) {         

        //visitas
       return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_Len_Expression_AST(miniPythonParser.PrimitiveExpression_Len_Expression_ASTContext ctx) {

        //visitas

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_FunctionCallExpression_AST(miniPythonParser.PrimitiveExpression_FunctionCallExpression_ASTContext ctx) {

        //visitas
       return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitListExpression_AST(miniPythonParser.ListExpression_ASTContext ctx) {

        //visitas

        return null;
    }

}