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
public class ListaTokens {
    
    NodoTokens inicio;
    public int cont = 0;
    
    public ListaTokens()
    {
        inicio = null;
    }
    
    public void agregarToken(String token, String lexema, int linea, int columna, String archivo)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp.siguiente != null)
            {
                temp = temp.siguiente;
            }
            temp.siguiente = new NodoTokens(token, lexema, linea, columna, archivo, cont, null);
            cont++;
        }
        else
        {
            inicio = new NodoTokens(token, lexema, linea, columna, archivo, cont, null);
            cont++;
        }
    }
    
    public int getSize()
    {
        return cont;
    }
    
    public String getToken(int pos)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp.token;
                }
                temp = temp.siguiente;
            }
        }
        return "";
    }
    
    public String getLexema(int pos)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp.lexema;
                }
                temp = temp.siguiente;
            }
        }
        return "";
    }
    
    public int getLinea(int pos)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp.linea;
                }
                temp = temp.siguiente;
            }
        }
        return 0;
    }
    
    public int getColumna(int pos)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp.columna;
                }
                temp = temp.siguiente;
            }
        }
        return 0;
    }
    
    public String getArchivo(int pos)
    {
        NodoTokens temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                if(temp.pos == pos)
                {
                    return temp.archivo;
                }
                temp = temp.siguiente;
            }
        }
        return "";
    }
}
