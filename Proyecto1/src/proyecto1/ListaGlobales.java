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
public class ListaGlobales {

    NodoVariables inicio;
    public int cont = 0;

    public ListaGlobales() {
        this.inicio = inicio;
    }
    
     public void agregarVariable(String tipo, String variable, String valor)
    {
        if(!existeVariable(variable))
        {
            NodoVariables temp;
            if(inicio != null)
            {
                temp = inicio;
                while(temp.siguiente != null)
                {
                    temp = temp.siguiente;
                }
                temp.siguiente = new NodoVariables(tipo, variable, valor, cont, null);
                cont++;
            }
            else
            {
                inicio = new NodoVariables(tipo, variable, valor, cont, null);
                cont++;
            }
        }
        else
        {
            updateVariable(variable, valor);
        }
    }
     
    public int getSize()
    {
        return cont;
    }
    
    public NodoVariables getVariableByPos(int pos)
    {
        NodoVariables temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp;
                }
                temp = temp.siguiente;
            }
        }
        return null;
    }
    
    public boolean isEmpty(){
        if(inicio == null)
        {
            return true;
        }
        return false;
    }
    
    public boolean existeVariable(String variable){
        NodoVariables temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.variable.equalsIgnoreCase(variable))
                {
                    return true;
                }
                temp = temp.siguiente;
            }
        }
        return false;
    }
    
    public void updateVariable(String variable, String valor){
        NodoVariables temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.variable.equalsIgnoreCase(variable))
                {
                    temp.setValor(valor);
                }
                temp = temp.siguiente;
            }
        }
    }
    
    public String getValorByVariable(String variable)
    {
        NodoVariables temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.variable.equalsIgnoreCase(variable))
                {
                    return temp.getValor();
                }
                temp = temp.siguiente;
            }
        }
        return variable;
    }
    //public void updateValor()
    
    
    
    
}
