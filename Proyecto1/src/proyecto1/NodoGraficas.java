/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author EduardoFlores
 */
public class NodoGraficas {
    String tipo;
    String titulo;
    String ejeX [];      // Barras - Pie
    String valores [];  //  Barras - Pie
    String tituloX;    //   Barras
    String tituloY;   //    Barras
    String archivo;  //     Lineas
    Double valoresDouble [];
    
    public NodoGraficas(){
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getEjeX() {
        return ejeX;
    }

    public void setEjeX(String[] ejeX) {
        this.ejeX = ejeX;
    }

    public String[] getValores() {
        return valores;
    }

    public void setValores(String[] valores) {
        this.valores = valores;
    }

    public String getTituloX() {
        return tituloX;
    }

    public void setTituloX(String tituloX) {
        this.tituloX = tituloX;
    }

    public String getTituloY() {
        return tituloY;
    }

    public void setTituloY(String tituloY) {
        this.tituloY = tituloY;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Double[] getValoresDouble() {
        return valoresDouble;
    }

    public void setValoresDouble(Double[] valoresDouble) {
        this.valoresDouble = valoresDouble;
    }
    
    public void setValorDouble(int pos, double valor){
        this.valoresDouble[pos] = valor;
    }
}
