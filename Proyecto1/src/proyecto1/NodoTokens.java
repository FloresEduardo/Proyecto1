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
public class NodoTokens {
    
    String lexema;
    String token;
    int linea;
    int columna;
    String archivo;
    NodoTokens siguiente;
    int pos;
    
    public NodoTokens(String token, String lexema, int linea, int columna, String archivo, int pos, NodoTokens siguiente)
    {
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
        this.pos = pos;
        this.siguiente = siguiente;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
}
