import generated.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Token;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Pruebas on 23/03/2017.
 */
public class editor {

    String path;
    ///
    private int tamañoTexto=17;
    private int tamañoTab=1;
    private Font areaFuente;
    Global nueva;
    ///

    private JPanel contenido;
    private JButton compilarButton;
    private JTextArea areaTexto;
    private JTextField status;

    private JList listaErrores;
    private JButton limpiarButton;
    private DefaultListModel modelo;

    JMenuBar barra = new JMenuBar();
    JMenu archivo = new JMenu("Archivo");
    JMenuItem nuevo = new JMenuItem("Nuevo");
    JMenuItem abrir = new JMenuItem("Abrir");
    JMenuItem guardar = new JMenuItem("Guardar");
    JMenuItem salir = new JMenuItem("Salir");
    JFrame frame= new JFrame("editor");



    public editor(){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar cargar L&F");
        }

        frame.setPreferredSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(250,100);
        frame.setJMenuBar(barra);
        barra.add(archivo);
        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(new JSeparator());
        archivo.add(salir);

        menuListener l = new menuListener();
        abrir.addActionListener(l);
        guardar.addActionListener(l);
        salir.addActionListener(l);
        nuevo.addActionListener(l);

        frame.pack();
        frame.getContentPane().add(contenido);
        frame.setVisible(true);

        modelo = new DefaultListModel();

        compilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.removeAllElements();

                System.out.println("Compilar button");
                Scanner scanner = null;
                GParser parser =  null;
                try{
                    salvarArchivo(path);
                }catch (Exception error){
                    System.out.println("Por favor, abrir o guardar el archivo");
                }
                try{



                    ANTLRInputStream inputCode = new ANTLRInputStream(new FileReader(path));
                    Scanner scannerCode = new Scanner(inputCode);
                    CommonTokenStream tokensCode = new CommonTokenStream(scannerCode);
                    GParser parserCode = new GParser(tokensCode);
                    ParseTree raizCode = parserCode.program();
                    CodeGen gen = new CodeGen();
                    gen.visit(raizCode);




                    /************* PARA IMPRIMIR LOS TOKENS ***************/
                    Global.modeloG = modelo;
                    ANTLRInputStream input = new ANTLRInputStream(new FileReader(path));
                    scanner = new Scanner(input);
                    scanner.removeErrorListeners();
                    scanner.addErrorListener(ScannerErrores.ERRORIDENTIFICADO);

                    Token[] lista = new Token[scanner.getAllTokens().size()];
                    ANTLRInputStream inputt = new ANTLRInputStream(new FileReader(path));
                    scanner = new Scanner(inputt);
                    scanner.removeErrorListeners();
                    scanner.addErrorListener(ScannerErrores.ERRORIDENTIFICADO);

                    if (Global.modeloG.size()>= 1){
                        listaErrores.setModel(Global.modeloG);
                        return;
                    }

                    modelo.addElement("LISTA DE TOKENS");
                    modelo.addElement("");
                    for(int i=0;i<lista.length;i++){
                        lista[i] = scanner.nextToken();
                        modelo.addElement("token: "+lista[i].getText() + "    lexema: "+lista[i].getType()+ "    fila: "
                                +lista[i].getCharPositionInLine()+"   columna: " + lista[i].getLine());
                        listaErrores.setModel(modelo);
                        System.out.println("elemento: "+lista[i]);
                    }
                    listaErrores.setModel(modelo);
                    Global.modeloG = modelo;
                    Global.listaErroresG = listaErrores;
                    System.out.println("modelo: "+ Global.modeloG );

            ////////////////////////////////////////////////////////////////////////////////////////////

                    /************* PARA REALIZAR ERRORES LOS TOKENS ***************/

                    scanner.reset();
                    input = new ANTLRInputStream(new FileReader(path));
                    scanner = new Scanner(input);
                    CommonTokenStream tokens = new CommonTokenStream(scanner);
                    errores er= new errores();
                    parser = new GParser(tokens);
                    parser.setErrorHandler(er);
                    parser.program();
                    System.out.println(er.lista.size());
                    if (er.lista.size() >=1){
                        System.out.println("Lista CANTIDAD DE ELEMENTOS: "+ er.lista.size());
                        for (int i= 0; i< er.lista.size(); i++){
                            modelo.addElement("ERROR   "+ er.lista.get(i));
                        }
                        System.out.println("Error en sistema return 1");
                        modelo.addElement("Error en sistema return 1");
                        return;
                    }

            /////////////////////////////////////////////////////////////////////////////////////////////

                    /************ PARA CREAR UN ARBOL ********************/

                    else{
                        scanner.reset();
                        input = new ANTLRInputStream(new FileReader(path));
                        scanner = new Scanner(input);
                        tokens = new CommonTokenStream(scanner);
                        parser = new GParser(tokens);
                        ParseTree raiz = parser.program();
                        System.out.println("\n\n" + raiz.toStringTree(parser));
                        PrettyPrint print = new PrettyPrint();
                        modelo.addElement("");
                        modelo.addElement("ARBOL");
                        modelo.addElement("");
                        print.visit(raiz);
                        modelo = Global.modeloG;
                        listaErrores.setModel(modelo);
                        System.out.println("Compilación de sistema Exitoso return 0");
                        modelo.addElement("Compilación de sistema Exitoso 0");




                        //A contextual


                        modelo.addElement("");
                        modelo.addElement("");
                        modelo.addElement("");
                        modelo.addElement("ANALIS CONTEXTUAL");
                        modelo.addElement("");
                        modelo.addElement("Errores encontrados :");
                        modelo.addElement("");
                        modelo.addElement("");
                        Global.modeloG = modelo;
                        System.out.println("\n\nAnalisis Contextual\n\n");

                        scanner.reset();
                        input = new ANTLRInputStream(new FileReader(path));
                        scanner = new Scanner(input);
                        tokens = new CommonTokenStream(scanner);
                        parser = new GParser(tokens);
                        ParseTree raizContextual = parser.program();
                        AContextual checker = new AContextual();
                        checker.visit(raizContextual);

                        modelo = Global.modeloG;
                        listaErrores.setModel(modelo);
                    }

                }catch (Exception error){
                    System.out.println("No hay archivo");
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.removeAllElements();
                listaErrores.setModel(modelo);
            }
        });

        areaFuente= new Font("Arial", Font.PLAIN, tamañoTexto);
        areaTexto.setFont(areaFuente);
        areaTexto.setTabSize(tamañoTab);
        actualizarEstado(0, 0);
        areaTexto.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linea = 1;
                int columna = 1;
                try {
                    int caretpos = editArea.getCaretPosition();
                    linea= editArea.getLineOfOffset(caretpos);
                    columna = caretpos - editArea.getLineStartOffset(linea);

                    linea += 1;
                } catch(Exception ex) { }

                actualizarEstado(linea, columna);
            }
        });
    }


    private class menuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(abrir)){
                System.out.println("eligio abrir");
                abrir();
            }
            if(e.getSource().equals(nuevo)){
                System.out.println("eligio nuevo");
                nuevo();  // malo
            }
            if(e.getSource().equals(guardar)){
                System.out.println("eligio guardar");
                guardar();
            }
        }
    }
    private void actualizarEstado(int linea, int columna) {
        status.setText("Linea: " + linea + " Columna: " + columna);
    }

    public void abrir () {
        JFileChooser abrirArchivo = new JFileChooser();

        abrirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = abrirArchivo.showOpenDialog(null);

        if(seleccion == JFileChooser.APPROVE_OPTION){
            File f = abrirArchivo.getSelectedFile();

            String nombre = f.getName();
            path = f.getAbsolutePath();

            System.out.println("nombre: " + nombre);
            System.out.println("path: " + path);
            String contenido = getContenido(path);

            frame.setTitle(nombre + " [" + path + "]");
            areaTexto.setText(contenido);
        }
    }
    public String getContenido(String path){
        FileReader fr;
        BufferedReader br = null;
        String contenido = "";
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);


            String linea;
            while((linea=br.readLine())!=null){
                contenido += linea + "\n";

            }
            return contenido;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try{
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return contenido;
    }
    public void nuevo(){
        System.out.println("nuevo1");
        frame.dispose();
        new editor();
    }

    public void guardar () {
        JFileChooser guardarArchivo = new JFileChooser();
        guardarArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = guardarArchivo.showSaveDialog(null);

        if(seleccion == JFileChooser.APPROVE_OPTION){
            File f = guardarArchivo.getSelectedFile();

            path = f.getAbsolutePath();

            if(f.exists()){
                if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(contenido,"El fichero existe,deseas reemplazarlo?","Sobreescribir Archivo",JOptionPane.YES_NO_OPTION)){
                    salvarArchivo(path);
                }
            }else{
                try {
                    f.createNewFile();
                    salvarArchivo(path);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }
    public void salvarArchivo(String path){
        FileWriter fw;
        BufferedWriter bw = null ;
        String contenido="";
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);

            BufferedReader reader = new BufferedReader(
                    new StringReader(areaTexto.getText()));

            String linea;
            while((linea=reader.readLine())!=null){
                contenido += linea + "\n";
            }

            bw.write(contenido);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
