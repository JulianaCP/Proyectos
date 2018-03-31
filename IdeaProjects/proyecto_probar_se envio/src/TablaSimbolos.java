import generated.Global;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pruebas on 25/04/2017.
 */
public class TablaSimbolos {
    LinkedList<Object>tabla;
    class Ident{
        int tipo;
        String texto;
        int nivel;
        ParserRuleContext decl;
        int cantidadParametros;
        Object retornoValor;
        List<Integer>listaAtributos;
        public Ident(int tipoPar,String textoPar,int nivelPar,ParserRuleContext declPar
                ,int cantidadParametrosPar,Object retornoValorPar,List<Integer> listaAtributosPar){
            tipo = tipoPar;
            texto = textoPar;
            nivel = nivelPar;
            decl = declPar;
            cantidadParametros = cantidadParametrosPar;
            retornoValor = retornoValorPar;
            listaAtributos = listaAtributosPar;
        }
        public void setListaAtributos(List<Integer> lista){
            this.listaAtributos = lista;
        }
        public void setRetornoValor(int tipoDato){
            this.retornoValor = tipoDato;
        }

    }
    public TablaSimbolos(){
        tabla = new LinkedList<Object>();
    }
    public Ident buscar(int nivel,String texto,String tipoOperacion){
        Ident temp = null;
        for(int x = nivel;x>=0;x--){
            for(int y=0;y<tabla.size();y++){
                int nivelTabla = ((Ident)tabla.get(y)).nivel;
                if(nivelTabla==x){
                    String textoTabla = ((Ident)tabla.get(y)).texto;
                    if(textoTabla.equals(texto)){
                        if(tipoOperacion.equals("def")){
                            int tipoTabla = ((Ident)tabla.get(y)).tipo;
                            if(tipoTabla==Global.DEF){
                                temp = ((Ident) tabla.get(y));
                            }
                        }
                        else{
                            temp = ((Ident) tabla.get(y));
                        }

                    }
                }
            }
        }
        return temp;
    }
    public void insertar(int tipoPar,String textoPar,int nivelPar,ParserRuleContext declPar
            ,int cantidadParametrosPar,Object retornoValorPar,List<Integer> listaAtributosPar){
        Ident nuevoElemento = new Ident(tipoPar,textoPar,nivelPar,declPar,cantidadParametrosPar,
                retornoValorPar,listaAtributosPar);
        tabla.add(nuevoElemento);
    }
    public void eliminar(int nivelEliminar){
        int nivel;
        for(int i=0;i<tabla.size();i++){
            nivel = ((Ident)tabla.get(i)).nivel;
            if(nivel == nivelEliminar){
                tabla.remove(i);
            }
        }
    }
}
