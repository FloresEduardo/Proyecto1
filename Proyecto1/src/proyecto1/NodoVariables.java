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
public class NodoVariables {
    public String tipo;
    public String variable;
    public String valor;
    int pos;
    NodoVariables siguiente;

    public NodoVariables(String tipo, String variable, String valor, int pos, NodoVariables siguiente) {
        this.tipo = tipo;
        this.variable = variable;
        this.valor = valor;
        this.pos = pos;
        this.siguiente = siguiente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public NodoVariables getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVariables siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
