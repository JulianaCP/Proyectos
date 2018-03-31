import generated.GPParser;
import generated.GPParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Juliana on 11/05/2017.
 */
public class CodeGen extends GPParserBaseVisitor {

    class Data{
        String id;
        int valor;

        Data(String i){
            id=i;
            valor = 0;
        }
    }
    LinkedList<Data> storage;

    public CodeGen(){
        storage = new LinkedList<Data>();
    }
    private Data buscarEnStorage(String id){
        for (Data i : storage) {
            if(i.id.equals(id)){
                return i;
            }
        }

        return null;
    }

    @Override
    public Object visitCondecls(GPParser.CondeclsContext ctx) {

        visit(ctx.declarations());
        visit(ctx.statements());
        return null;
    }

    @Override
    public Object visitSindecls(GPParser.SindeclsContext ctx) {
        visit(ctx.statements());
        return null;
    }


    @Override
    public Object visitDecls(GPParser.DeclsContext ctx) {
        visit(ctx.declaration(0));
        for (int i=1; i <= ctx. declaration().size()-1; i++)
        {
            visit(ctx.declaration(i));
        }
        return null;
    }

    @Override
    public Object visitIntdecl(GPParser.IntdeclContext ctx) {

        List<TerminalNode> listaIDs = (List<TerminalNode>) visit(ctx.idlist());
        for (TerminalNode id : listaIDs){
            storage.add(new Data(id.getSymbol().getText()));
        }
        return null;
    }

    @Override
    public Object visitStrdecl(GPParser.StrdeclContext ctx) {

        List<TerminalNode> listaIDs = (List<TerminalNode>) visit(ctx.idlist());
        for (TerminalNode id : listaIDs){

        }
        return null;
    }

    @Override
    public Object visitStats(GPParser.StatsContext ctx) {

        for (GPParser.StatementContext i : ctx.statement())
            visit(i);

        return null;
    }

    @Override
    public Object visitAsignstat(GPParser.AsignstatContext ctx) {


        int valorExp = (Integer)visit(ctx.expression());

        //almacenar el valor en el almecen, en el campo ctx.ID()

        Data res = buscarEnStorage(ctx.ID().getSymbol().getText());
        res.valor=valorExp;

        System.out.println(res.valor);


        return null;

    }

    @Override
    public Object visitExprstat(GPParser.ExprstatContext ctx) {
        return super.visitExprstat(ctx);
    }

    @Override
    public Object visitEpsstat(GPParser.EpsstatContext ctx) {
        return super.visitEpsstat(ctx);
    }

    @Override
    public Object visitExpr(GPParser.ExprContext ctx) {
        int v1 =  (Integer)visit(ctx.term(0));
        int v2 = 0;
        for (int i=1; i <= ctx.term().size()-1; i++)
        {
            v2=v2+(Integer) visit(ctx.term(i));
        }
        return v1+v2;
    }

    @Override
    public Object visitTerm1(GPParser.Term1Context ctx) {
        return visit(ctx.factor(0));
    }

    @Override
    public Object visitGroupfact(GPParser.GroupfactContext ctx) {
        return super.visitGroupfact(ctx);
    }

    @Override
    public Object visitIdfact(GPParser.IdfactContext ctx) {
        Data res = buscarEnStorage(ctx.ID().getSymbol().getText());
        return res.valor;
    }

    @Override
    public Object visitNumfact(GPParser.NumfactContext ctx) {
        return Integer.parseInt(ctx.NUM().getSymbol().getText()); //devuelve un objeto integer
    }

    @Override
    public Object visitStrfact(GPParser.StrfactContext ctx) {
        return null;
    }

    @Override
    public Object visitIdlist1(GPParser.Idlist1Context ctx) {
        return ctx.ID();
    }
}