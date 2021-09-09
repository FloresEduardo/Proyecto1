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
public class NodoComparacion {
    
    String nombreArchivo;
    
    String nombreClase;     // CLASE
    int lineasClase;       //  CLASE
    String nombreFuncion;    // FUNCION
    int lineasFuncion;      //  FUNCION
    int cantidadParametros;//   FUNCION
    String nombreVariable;     // VARIABLE
    String comentarioUniLinea;    // COMENTARIO 1 LINEA
    String comentarioMultiLinea; //  COMENTARIO MULTI LINEAS
    
    NodoComparacion siguiente;
    int pos;

    public NodoComparacion() {
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public int getLineasClase() {
        return lineasClase;
    }

    public void setLineasClase(int lineasClase) {
        this.lineasClase = lineasClase;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public int getLineasFuncion() {
        return lineasFuncion;
    }

    public void setLineasFuncion(int lineasFuncion) {
        this.lineasFuncion = lineasFuncion;
    }

    public int getCantidadParametros() {
        return cantidadParametros;
    }

    public void setCantidadParametros(int cantidadParametros) {
        this.cantidadParametros = cantidadParametros;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public String getComentarioUniLinea() {
        return comentarioUniLinea;
    }

    public void setComentarioUniLinea(String comentarioUniLinea) {
        this.comentarioUniLinea = comentarioUniLinea;
    }

    public String getComentarioMultiLinea() {
        return comentarioMultiLinea;
    }

    public void setComentarioMultiLinea(String comentarioMultiLinea) {
        this.comentarioMultiLinea = comentarioMultiLinea;
    }

    public NodoComparacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoComparacion siguiente) {
        this.siguiente = siguiente;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "NodoComparacion{" + "nombreArchivo=" + nombreArchivo + ", nombreClase=" + nombreClase + 
                ", lineasClase=" + lineasClase + ", nombreFuncion=" + nombreFuncion + ", lineasFuncion=" + 
                lineasFuncion + ", cantidadParametros=" + cantidadParametros + ", nombreVariable=" + nombreVariable + 
                ", comentarioUniLinea=" + comentarioUniLinea + ", comentarioMultiLinea=" + comentarioMultiLinea + "}";
    }
    
    
}
