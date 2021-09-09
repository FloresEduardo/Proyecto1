/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author EduardoFlores
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        //test();
        
//        double var = 0.0;
//        double mul = 1;
//        double uni = 0;
//        double sum = 6;
//        double _02 = 0.2;
//        var = ((mul+uni)/sum)*0.2;
//        System.out.println(var);
        
        //File file = new File("C:\\Users\\EduardoFlores\\Desktop\\ProyectoJS1");
        //archivoJS_Acompilar(file);
        
        //pie();
        //lineas();
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        //System.out.println(dtf.format(LocalDateTime.now()));
        
    }
    
    public static void archivoJS_Acompilar(File rootFile)
    {
        String ruta = "";
        JTree jTree1 = new JTree();
        DefaultTreeModel modelo;
        //creamos el nodo principal
        String rutaPoyecto [] = rootFile.getPath().split("\\\\");   //C:\\Users\\EduardoFlores\\Desktop\\Proyecto1
        String directorio = rutaPoyecto[rutaPoyecto.length-1];      // Proyecto1
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(directorio);
        //creamos un modelo con el nodo que creamos principal
        modelo = new DefaultTreeModel(top);
        jTree1.setModel(modelo);

        for (File f : rootFile.listFiles()) {       // lo que tiene adentro rootFile, osea adentro de Proyecto1
            String nombre [] = f.getPath().split("\\\\");
            String path = nombre[nombre.length-1];
            
            if(path.length() > 2)
            {
                String extencion = path.substring(path.length() - 3);
                if(extencion.equalsIgnoreCase(".js"))
                {
                    ruta = f.getPath();
                    System.out.println("El archivo a compilar: " + ruta);
                }
            }
            DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(path);
            //añadimos el nodo a la raiz
            top.add(raiz);
            //hacemos un recorrido de dos niveles a partir de cada una unidad
            actualizaNodo(raiz, f);     
        }
    }
    
    public static boolean actualizaNodo(DefaultMutableTreeNode nodo, File f) {
        //quitamos lo que tenga el nodo 
        nodo.removeAllChildren();
        //recursivamente mandamos actualizar
        return actualizaNodo(nodo,f,2); 
    }
    
    public static boolean actualizaNodo(DefaultMutableTreeNode nodo, File f, int profundidad) {
        String ruta = "";
        File[] files = f.listFiles(); // de el nodo que llega listamos todos sus archivos
        if(files!=null && profundidad>0) //permite detener la recursividad si ya llego al limite 
        {   
           for(File file: files)  // recorre todos los archivos 
           {
               String nombre [] = file.getPath().split("\\\\");
               String path = nombre[nombre.length-1];
               DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(path);
               if(path.length() > 2)
            {
                String extencion = path.substring(path.length() - 3);
                if(extencion.equalsIgnoreCase(".js"))
                {
                    ruta = file.getPath();
                    System.out.println("El archivo a compilar: " + ruta);
                }
            }
               //vuelve a mandar en caso que sea directorio 
               actualizaNodo(nuevo, file,profundidad); 
               nodo.add(nuevo); //crea el nodo
            }
        }
       return true; 
    } 
    
    
    
    
    
    
    
    
    
    public static void createImage(File file, JFreeChart chart){
        try {
            ChartUtilities.saveChartAsJPEG(file, chart, 800, 800);
        } catch (IOException ex) {
            Logger.getLogger(Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void pie(){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Iphone 5s", 20);
        pieDataset.setValue("SamSung Grand", 20);
        pieDataset.setValue("MotoG", 40);
        pieDataset.setValue("Nokia Lumia", 10);
        
        JFreeChart chart = ChartFactory.createPieChart("Mobile Sales", pieDataset, true, true, false);
        
        File file = new File("PieChart1.jpg");
        
        createImage(file, chart);  
    }
    
    public static void barras(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(1.0, "fiat", "fiat");
        dataset.addValue(5.0, "audi", "audi");
        dataset.addValue(4.0, "ford", "ford");
        dataset.addValue(3.0, "toyota", "toyota");
        dataset.addValue(1.0, "fiat2", "fiat2");
        dataset.addValue(5.0, "audi2", "audi2");
        dataset.addValue(4.0, "ford2", "ford2");
        dataset.addValue(3.0, "toyota2", "toyota2");
        
        JFreeChart chart = ChartFactory.createBarChart("Which car do you like?", "Category", "Score", 
                dataset, PlotOrientation.VERTICAL, true, true, false);
        
        File file = new File("BarrasChart1.jpg");
        createImage(file, chart);
    }
    
    public static void lineas(){
        JFreeChart chart = ChartFactory.createLineChart("Archivo", "", "Cantidad de Caracteristica", 
                createDataset(), PlotOrientation.VERTICAL, true, true, true);
        
        File file = new File("LineasChart1.jpg");
        createImage(file, chart);
    }
    
    public static DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "ProyectoA" , "variables");
        dataset.addValue(14, "ProyectoB" , "variables");
        dataset.addValue(6, "ProyectoA" , "metodos");
        dataset.addValue(6, "ProyectoB" , "metodos");
        dataset.addValue(2, "ProyectoA" , "clases");
        dataset.addValue(2, "ProyectoB" , "clases");
        dataset.addValue(4, "ProyectoA" , "comentarios");
        dataset.addValue(2, "ProyectoB" , "comentarios");
        return dataset;
    }
    
    public static void test(){
        NodoEspecifico nodoEspe = new NodoEspecifico();
        nodoEspe.setArchivo("archivo1.js");
        nodoEspe.setTipo("clase");
        nodoEspe.setNombre("clase1");
        nodoEspe.setPuntaje(0.4);
        
        NodoEspecifico nodo = new NodoEspecifico();
        nodo.setArchivo("archivo1.js");
        nodo.setTipo("variable");
        nodo.setNombre("var1");
        nodo.setPuntaje(0.5);
        
        NodoJSON nodoJson = new NodoJSON();
        nodoJson.setPuntajeGeneral(0.8);
        nodoJson.puntajeEspecifico.add(nodoEspe);
        nodoJson.puntajeEspecifico.add(nodo);
        
        Gson gson = new Gson();
        String strJson = gson.toJson(nodoJson);
        
         
        try {
            FileWriter fw = new FileWriter("ReporteJson.json", false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(gson.toJson(nodoJson));
            pw.close();
            System.out.println(gson.toJson(nodoJson));
        } catch (IOException ex) {
            Logger.getLogger(Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
        
    }
}
