package generated;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Joha on 27/3/2017.
 */
public class Global {

    //manejo de tipos
    public static final int INT = 0;
    public static final int ID = 1;
    public static final int STRING = 2;
    public static final int CHAR = 3;
    public static final int LIST = 4;
    public static final int INDEFINIDO = 5;
    public static final int DEF = 6;
    public static final int RETURNO = 7;
    public static final int RESTA = 10;
    public static final int SUMA = 11;

    public static final int FALLO = 15;
    public static final int ESTA_BIEN = 16;

    public static final int SIN_PARAMETROS = 20;

    //complementos
    public static String tipoOperacion;
    public static int nivel = 0;
    public static String tipoAnterior;
    public static int tipoAnteriorInt;
    public static String textoTipoAnterior;
    public static List<Integer>listaAtributosGlobal = new ArrayList<Integer>();

    public static int fila;
    public static int columna;


    public static String defActual;
    public static String IDFunctionStament;
    public static String IDTEXTOFunctionStament;


    public static int tipoRetornoAsignarDef;


    //vista
    public static JList listaErroresG;
    public static DefaultListModel modeloG;

    public static int cont;

}
