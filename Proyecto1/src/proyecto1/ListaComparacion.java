/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EduardoFlores
 */
public class ListaComparacion {
    
    NodoComparacion inicio;
    public int pos = 0;
    public ListaGlobales listaArchivos = new ListaGlobales();
    public ListaGlobales listaClases = new ListaGlobales();
    public ListaGlobales listaFunciones = new ListaGlobales();
    public ListaGlobales listaVariables = new ListaGlobales();
    public ListaGlobales listaComentariosMulti = new ListaGlobales();
    public ListaGlobales listaComentariosUni = new ListaGlobales();
    
    public ListaComparacion(){
        
    }
    
    public void agregar(NodoComparacion nodo)
    {
        NodoComparacion temp;
        if(inicio != null)
        {
            if(!existeVariable(nodo))
            {
                temp = inicio;
                while(temp.siguiente != null)
                {
                    temp = temp.siguiente;
                }
                nodo.setPos(pos);
                temp.siguiente = nodo;
                pos++;
            }
        }
        else
        {
            nodo.setPos(pos);
            inicio = nodo;
            pos++;
        }
    }
    
    public boolean existeVariable(NodoComparacion nodo)
    {
        NodoComparacion temp;
        temp = inicio;
        while(temp != inicio)
        {
            if(nodo.getNombreArchivo().equals(temp.getNombreArchivo()) && 
                    nodo.getNombreVariable().equals(temp.getNombreVariable()))
            {
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }
    
    public int getSize()
    {
        return pos;
    }
    
    public void imprimir()
    {
        NodoComparacion temp;
        if(inicio != null)
        {
            temp = inicio;
            while(temp != null)
            {
                System.out.println(temp.toString());
                temp = temp.siguiente;
            }
        }
    }
    
    public double getPuntajeRepitenciaClase(String nombreArchivo, String nombreArchivo2, String id)
    {
        NodoComparacion temp, temp2, temp3;
        double puntaje = 0.0;
        double puntaMetodos = 0.0;
        String clase1 = "";
        String clase2 = "";
        String proyecto1 = "";
        String proyecto2 = "";
        int lineas1 = 0;
        int lineas2 = 0;
        if(inicio!= null)
        {
            temp = inicio;
            while(temp != null)
            {
                String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
                
                if(temp.getNombreArchivo().equalsIgnoreCase(proyecto1+"\\"+nombreArchivo))
                {
                    if(temp.getNombreClase() != null)
                    {
                        if(temp.getNombreClase().equals(id))
                        {
                            clase1 = temp.getNombreClase();
                            lineas1 = temp.getLineasClase();
                            if(proyecto2.equals(""))
                            {
                                temp3 = inicio;
                                while(temp3 != null)
                                {
                                    String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                    if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                    temp3 = temp3.siguiente;
                                }
                            }
                            break;
                        }
                    }
                }
                temp = temp.siguiente;
            }
            
            temp = inicio;
            while(temp != null)
            {
                String getNombreAr2 = temp.getNombreArchivo();
                String nombreAr2 = proyecto2+"\\"+nombreArchivo;
                
                if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                {
                    if(temp.getNombreClase() != null)
                    {
                        if(temp.getNombreClase().equals(id))
                        {
                            clase2 = temp.getNombreClase();
                            lineas2 = temp.getLineasClase();
                            break;
                        }
                    }
                }
                temp = temp.siguiente;
            }
            if(clase1.equals(clase2)){    puntaje = puntaje + 0.2;    }
            if(lineas1 == lineas2){   puntaje = puntaje + 0.4;   }
            
            // Inicia comparacion para metodos de una clase/archivo
            temp = inicio;
            proyecto1 = "";
            proyecto2 = "";
            NodoComparacion nodoTemp = new NodoComparacion();
            String idMetodo = "";
            int lineasMetodo = 0;
            String idMetodo2 = "";
            int lineasMetodo2 = 0;
            while(temp != null)
            {
                String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
                
                String getNombreAr2 = temp.getNombreArchivo();
                String nombreAr2 = proyecto1+"\\"+nombreArchivo;
                if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                {
                    if(temp.getNombreFuncion() != null)
                    {
                        idMetodo = temp.getNombreFuncion();
                        lineasMetodo = temp.getLineasFuncion();
                        
                        if(proyecto2.equals(""))
                        {
                            temp3 = inicio;
                            while(temp3 != null)
                            {
                                String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                temp3 = temp3.siguiente;
                            }
                        }
                        if(temp.siguiente != null)
                        {
                            temp2 = temp.siguiente;
                            while(temp2 != null)
                            {
                                String getNombreAr2M = temp.getNombreArchivo();
                                String nombreAr2M = proyecto2+"\\"+nombreArchivo;
                                
                                if(temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2M))
                                {
                                    if(temp2.getNombreFuncion() != null)//***************************************************************************
                                    {
                                        if(temp2.getNombreFuncion().equals(idMetodo) || temp2.getLineasFuncion() == lineasMetodo)
                                        {
                                            if(temp2.getNombreFuncion().equals(idMetodo)){  puntaMetodos = puntaMetodos + 0.4;    }
                                            if(temp2.getLineasFuncion() == lineasMetodo){  puntaMetodos = puntaMetodos + 0.4;    }
                                            //return puntaje;
                                        }
                                        
                                    }
                                }
                                temp2 = temp2.siguiente; 
                            }
                        }
                    }
                }
                temp = temp.siguiente;
            }
        }
        if(puntaMetodos >= 0.6) {   puntaje = puntaje + 0.4;   }
        return puntaje;
    }
    
    public double getPuntajeRepitenciaVariable(String nombreArchivo, String variable)
    {
        NodoComparacion temp, temp2, temp3;
        String proyecto1 = "";
        String proyecto2 = "";
        String var = "";
        if(inicio!= null)
        {
            temp = inicio;
            while(temp != null)
            {
                String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0]) && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
                
                String getNombreAr = temp.getNombreArchivo();
                String nombreAr = proyecto1+"\\"+nombreArchivo;
                if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
                {
                    if(temp.getNombreVariable() != null)
                    {
                        if(temp.getNombreVariable().equals(variable))
                        {
                            var = temp.getNombreVariable();
                            if(proyecto2.equals(""))
                            {
                                temp3 = inicio;
                                while(temp3 != null)
                                {
                                    String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                    if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                    temp3 = temp3.siguiente;
                                }
                            }
                            break;
                        }
                        
                    }
                }
                temp = temp.siguiente;
            }
            
            temp2 = inicio;
            while(temp2 != null)
            {
                String getNombreAr2 = temp2.getNombreArchivo();
                String nombreAr2 = proyecto2+"\\"+nombreArchivo;
                //System.out.println("A "+getNombreAr2 +" - " + nombreAr2);
                if(temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                {
                    if(temp2.getNombreVariable() != null)
                    {
                        //System.out.println("V "+temp2.getNombreVariable()+" - "+var);
                        if(temp2.getNombreVariable().equals(var))
                        {
                            return 1.0;
                        }
                        
                    }
                }
                temp2 = temp2.siguiente;
            }
        }
        return 0.0;
    }
    
    public double getPuntajeRepitenciaComentario(String nombreArchivo, String comentario)
    {
        NodoComparacion temp, temp2, temp3;
        String proyecto1 = "";
        String proyecto2 = "";
        String var = "";
        if(inicio!= null)
        {
            temp = inicio;
            while(temp != null)
            {
               String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
                
                if(temp.getNombreArchivo().equalsIgnoreCase(proyecto1+"\\"+nombreArchivo))
                {
                    if((temp.getComentarioMultiLinea() != null) || 
                           (temp.getComentarioUniLinea() != null) )
                    {
                        if(temp.getComentarioMultiLinea().equals(comentario))
                        {
                            var = temp.getComentarioMultiLinea();
                            temp3 = inicio;
                            while(temp3 != null)
                            {
                                String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                if(!nombreTemp[0].equalsIgnoreCase(proyecto1) && proyecto2.equalsIgnoreCase("") ) 
                                {    proyecto2 = nombreTemp[0]; break;    }
                                temp3 = temp3.siguiente;
                            }
                        }else if(temp.getComentarioUniLinea().equals(comentario))
                        {
                            var = temp.getComentarioMultiLinea();
                            temp3 = inicio;
                            while(temp3 != null)
                            {
                                String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                if(!nombreTemp[0].equalsIgnoreCase(proyecto1) && proyecto2.equalsIgnoreCase("") ) 
                                {    proyecto2 = nombreTemp[0]; break;    }
                                temp3 = temp3.siguiente;
                            }
                        }
                        
                    }
                }
                
                temp = temp.siguiente;
            }
            
            temp2 = temp.siguiente;
            while(temp2 != null)
            {
                if(temp2.getNombreArchivo().equals(proyecto2+"\\"+nombreArchivo))
                {
                    if(temp2.getNombreVariable() != null)
                    {
                        if(temp2.getNombreVariable().equals(var))
                        {
                            return 1;
                        }
                        
                    }
                }
            }
        }
        return 0.0;
    }
    
    public double getPuntajeRepitenciaFunciones(String nombreArchivo, String id)
    {
        double puntaje = 0.0;
        String metodo1 = "";
        String metodo2 = "";
        String proyecto1 = "";
        String proyecto2 = "";
        int lineas1 = 0;
        int lineas2 = 0;
        int parametros1 = 0;
        int parametros2 = 0;
        NodoComparacion temp, temp3;
        boolean existeENproyecto1 = false;
        boolean existeENproyecto2 = false;
        temp = inicio;
        while(temp != null)
        {
            String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
            if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
            else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
            
            String getNombreAr = temp.getNombreArchivo();
            String nombreAr = proyecto1+"\\"+nombreArchivo;
            if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
            {
                if(temp.getNombreFuncion() != null)
                {
                    if(temp.getNombreFuncion().equals(id))
                    {
                        metodo1 = temp.getNombreFuncion();
                        lineas1 = temp.getLineasFuncion();
                        parametros1 = temp.getCantidadParametros();
                        temp3 = inicio;
                        while(temp3 != null)
                        {
                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                            if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                            temp3 = temp3.siguiente;
                        }
                        existeENproyecto1 = true;
                        break;
                        
                    }
                }
            }
            temp = temp.siguiente;
        }
            
        temp = inicio;
        while(temp != null)
        {
            String getNombreAr = temp.getNombreArchivo();
            String nombreAr = proyecto2+"\\"+nombreArchivo;
            if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
            {
                if(temp.getNombreFuncion() != null)
                {
                    if(temp.getNombreFuncion().equals(id))
                    {
                        metodo2 = temp.getNombreFuncion();
                        lineas2 = temp.getLineasFuncion();
                        parametros2 = temp.getCantidadParametros();
                        existeENproyecto2 = true;
                        break;
                        
                    }
                }
            }
            temp = temp.siguiente;
        }
        if(!metodo1.equals("") && !metodo2.equals("") || lineas1 != 0 && lineas2 != 0 || parametros1 != 0 && parametros2 != 0)
        {
            if(metodo1.equals(metodo2)){    puntaje = puntaje + 0.4;    }
            if(lineas1 == lineas2 && lineas1 != 0){   puntaje = puntaje + 0.3;   }
            if(parametros1 == parametros2 && parametros1 != 0){   puntaje = puntaje + 0.3;   }
            return puntaje;
        }
        
        
        //*******
        temp = inicio;
        String proyecto = "";
        int lineas = 0;
        int parametros = 0;
        if(existeENproyecto1)
        {  
            lineas = lineas1;
            parametros = parametros1;
            proyecto = proyecto2;   
        }
        else if(existeENproyecto2) 
        { 
            lineas = lineas2;
            parametros = parametros2;
            proyecto = proyecto1; 
        }
        
        while(temp != null)
        {
            String nombreAr = proyecto+"\\"+nombreArchivo;
            if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
            {
                if(temp.getNombreFuncion() != null)
                {
                    if(temp.getCantidadParametros() == parametros || temp.getLineasFuncion() == lineas)
                    {
                        if(temp.getCantidadParametros() == parametros){     puntaje = puntaje + 0.3;    }
                        if(temp.getLineasFuncion() == lineas){     puntaje = puntaje + 0.3;    }
                        return puntaje;
                    }
                }
            }
            temp = temp.siguiente;
        }
        

        return puntaje;
    }
    
    public String getDatosParaGraficaLineas(String nombreArchivo)
    {
        int contVariables1 = 0;
        int contMetodos1 = 0;
        int contClasaes1 = 0;
        int contComentarios1 = 0;
        int contVariables2 = 0;
        int contMetodos2 = 0;
        int contClasaes2 = 0;
        int contComentarios2 = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        NodoComparacion temp;
        String res = "";
        
        temp = inicio;
        while(temp != null)
        {
            String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
            if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
            else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }
            
            String nombreAr1 = proyecto1+"\\"+nombreArchivo;
            String nombreAr2 = proyecto2+"\\"+nombreArchivo;
            if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr1))
            {
                if(temp.getNombreVariable() != null){   contVariables1++;   }
                else if(temp.getNombreFuncion() != null){    contMetodos1++;    }
                else if(temp.getNombreClase() != null){   contClasaes1++;   }
                else if(temp.getComentarioMultiLinea() != null || temp.getComentarioUniLinea() != null){    contComentarios1++; }
            }else if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr2))
            {
                if(temp.getNombreVariable() != null){   contVariables2++;   }
                else if(temp.getNombreFuncion() != null){    contMetodos2++;    }
                else if(temp.getNombreClase() != null){   contClasaes2++;   }
                else if(temp.getComentarioMultiLinea() != null || temp.getComentarioUniLinea() != null){    contComentarios2++; }
            }
            temp = temp.siguiente;
        }
        res = proyecto1 + "@" + contVariables1 + "@" + contMetodos1 + "@" + contClasaes1 + "@" + contComentarios1 +
                "#" + proyecto2 + "@" + contVariables2 + "@" + contMetodos2 + "@" + contClasaes2 + "@" + contComentarios2;
        return res;
    }
    
    public double getCalcularPuntajeGeneral()
    {
        crearListas();
        double puntaje = 0.0;
        
        double comM = 0.0; 
        double comU = 0.0;
        double sumCom = 0.0;
        double comentarios = 0.0;
        comM = (double)comentariosMultiRepetidas();
        comU = (double)comentariosUniRepetidas();
        sumCom = (double)sumatoriaDatosProyecto1y2("comentarios");
        comentarios = ( comM / sumCom );
        comentarios = comentarios * 0.2;
        
        double varRep = 0.0;
        double sumVar = 0.0;
        double variables = 0.0;
        varRep = (double)variablesRepetidas();
        sumVar = (double)sumatoriaDatosProyecto1y2("variables");
        variables = ( varRep / sumVar );
        variables = variables * 0.2;
                
        double metRep = 0.0;
        double sumMet = 0.0;
        double metodos = 0.0;
        metRep = (double)metodosRepetidas();
        sumMet = (double)sumatoriaDatosProyecto1y2("metodos");
        metodos = ( metRep / sumMet );
        metodos = metodos * 0.3;
        
        double clasRep = 0.0;
        double sumClas = 0.0;
        double clases = 0.0;
        clasRep = (double)clasesRepetidas();
        sumClas = (double)sumatoriaDatosProyecto1y2("clases");
        clases = ( clasRep / sumClas );
        clases = clases * 0.3;

        puntaje = comentarios + variables + metodos + clases;
        return puntaje;
    }
    
    private int variablesRepetidas()
    {
        int res = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        
        NodoComparacion temp, temp2, temp3;
        
        for(int i = 0; i<listaArchivos.getSize(); i++)
        {
            NodoVariables nodoArchivo;
            nodoArchivo = listaArchivos.getVariableByPos(i);
            String archivo = nodoArchivo.getVariable();
            
            for(int j =0; j<listaVariables.getSize(); j++)
            {
                String var = "";
                NodoVariables nodoVariable;
                nodoVariable = listaVariables.getVariableByPos(j);
                String variable = nodoVariable.getVariable();
                if(inicio!= null)
                {
                    temp = inicio;
                    while(temp != null)
                    {
                        String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                        if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                        else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0]) && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }

                        String nombreAr = proyecto1+"\\"+archivo;
                        if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
                        {
                            if(temp.getNombreVariable() != null)
                            {
                                if(temp.getNombreVariable().equals(variable))
                                {
                                    var = temp.getNombreVariable();
                                    if(proyecto2.equals(""))
                                    {
                                        temp3 = inicio;
                                        while(temp3 != null)
                                        {
                                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                            if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                            temp3 = temp3.siguiente;
                                        }
                                    }
                                    break;
                                }

                            }
                        }
                        temp = temp.siguiente;
                    }
                    
                    temp2 = inicio;
                    while(temp2 != null)
                    {
                        String nombreAr2 = proyecto2+"\\"+archivo;
                        if(temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                        {
                            if(temp2.getNombreVariable() != null)
                            {
                                if(temp2.getNombreVariable().equals(var))
                                {
                                    res++;
                                    break;
                                }
                            }
                        }
                        temp2 = temp2.siguiente;
                    }
                }
            }// for j - variables
            
        }// for i - archivos
        return res;
    }
    
    private int comentariosMultiRepetidas()
    {
        int res = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        String var = "";
        NodoComparacion temp, temp2, temp3;
        
        for(int i = 0; i<listaArchivos.getSize(); i++)
        {
            NodoVariables nodoArchivo;
            nodoArchivo = listaArchivos.getVariableByPos(i);
            String archivo = nodoArchivo.getVariable();
            
            for(int j =0; j<listaComentariosMulti.getSize(); j++)
            {
                NodoVariables nodoComentarios;
                nodoComentarios = listaComentariosMulti.getVariableByPos(j);
                String comentario = nodoComentarios.getVariable();
                if(inicio!= null)
                {
                    temp = inicio;
                    while(temp != null)
                    {
                        String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                        if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                        else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0]) && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }

                        String nombreAr = proyecto1+"\\"+archivo;
                        if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
                        {
                            if(temp.getComentarioMultiLinea() != null)
                            {
                                if(temp.getComentarioMultiLinea().equals(comentario))
                                {
                                    var = temp.getComentarioMultiLinea();
                                    if(proyecto2.equals(""))
                                    {
                                        temp3 = inicio;
                                        while(temp3 != null)
                                        {
                                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                            if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                            temp3 = temp3.siguiente;
                                        }
                                    }
                                    break;
                                }

                            }
                        }
                        temp = temp.siguiente;
                    }
                    
                    temp2 = inicio;
                    while(temp2 != null)
                    {
                        String nombreAr2 = proyecto2+"\\"+archivo;
                        if(temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                        {
                            if(temp2.getComentarioMultiLinea() != null)
                            {
                                if(temp2.getComentarioMultiLinea().equals(var))
                                {
                                    res++;
                                    break;
                                }
                            }
                        }
                        temp2 = temp2.siguiente;
                    }
                }
            }// for j - comentarios
            
        }// for i - archivos
        return res;
    }
    
    private int comentariosUniRepetidas()
    {
        int res = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        String var = "";
        NodoComparacion temp, temp2, temp3;
        
        for(int i = 0; i<listaArchivos.getSize(); i++)
        {
            NodoVariables nodoArchivo;
            nodoArchivo = listaArchivos.getVariableByPos(i);
            String archivo = nodoArchivo.getVariable();
            
            for(int j =0; j<listaComentariosUni.getSize(); j++)
            {
                NodoVariables nodoComentarios;
                nodoComentarios = listaComentariosUni.getVariableByPos(j);
                String comentario = nodoComentarios.getVariable();
                if(inicio!= null)
                {
                    temp = inicio;
                    while(temp != null)
                    {
                        String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                        if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                        else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0]) && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }

                        String nombreAr = proyecto1+"\\"+archivo;
                        if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr))
                        {
                            if(temp.getComentarioUniLinea() != null)
                            {
                                if(temp.getComentarioUniLinea().equals(comentario))
                                {
                                    var = temp.getComentarioUniLinea();
                                    if(proyecto2.equals(""))
                                    {
                                        temp3 = inicio;
                                        while(temp3 != null)
                                        {
                                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                            if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                            temp3 = temp3.siguiente;
                                        }
                                    }
                                    break;
                                }

                            }
                        }
                        temp = temp.siguiente;
                    }
                    
                    temp2 = inicio;
                    while(temp2 != null)
                    {
                        String nombreAr2 = proyecto2+"\\"+archivo;
                        if(temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                        {
                            if(temp2.getComentarioUniLinea() != null)
                            {
                                if(temp2.getComentarioUniLinea().equals(var))
                                {
                                    res++;
                                    break;
                                }
                            }
                        }
                        temp2 = temp2.siguiente;
                    }
                }
            }// for j - comentarios
            
        }// for i - archivos
        return res;
    }
    
    private int clasesRepetidas()
    {
        int res = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        NodoComparacion temp1, temp, temp2, temp3;
        String clase1 = "";
        int lineas1 = 0;
        String clase2 = "";
        int lineas2 = 0;
        double puntaje = 0.0;
        double puntajeMetodo = 0.0;
        
        for(int i = 0; i<listaArchivos.getSize(); i++)
        {
            NodoVariables nodoArchivo;
            nodoArchivo = listaArchivos.getVariableByPos(i);
            String nombreArchivo = nodoArchivo.getVariable();
            
            for(int j =0; j<listaClases.getSize(); j++)
            {
                NodoVariables nodoClases;
                nodoClases = listaClases.getVariableByPos(j);
                String id = nodoClases.getVariable();
                //*********************************************************************************
                
                if(inicio!= null)
                {
                    temp1 = inicio;
                    while(temp1 != null)
                    {
                        String vTempArchivo [] = temp1.getNombreArchivo().split("\\\\");
                        if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                        else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }

                        if(temp1.getNombreArchivo().equalsIgnoreCase(proyecto1+"\\"+nombreArchivo))
                        {
                            if(temp1.getNombreClase() != null)
                            {
                                if(temp1.getNombreClase().equals(id))
                                {
                                    clase1 = temp1.getNombreClase();
                                    lineas1 = temp1.getLineasClase();
                                    if(proyecto2.equals(""))
                                    {
                                        temp3 = inicio;
                                        while(temp3 != null)
                                        {
                                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                            if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                            temp3 = temp3.siguiente;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        temp1 = temp1.siguiente;
                    }

                    temp = inicio;
                    while(temp != null)
                    {
                        String nombreAr2 = proyecto2+"\\"+nombreArchivo;

                        if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                        {
                            if(temp.getNombreClase() != null)
                            {
                                if(temp.getNombreClase().equals(id))
                                {
                                    clase2 = temp.getNombreClase();
                                    lineas2 = temp.getLineasClase();
                                    break;
                                }
                            }
                        }
                        temp = temp.siguiente;
                    }
                    if(clase1.equals(clase2))
                    {    
                        puntaje = puntaje + 0.2;    
                    }
                    if(lineas1 == lineas2){   puntaje = puntaje + 0.4;   } 
                }
                //puntajeMetodo = 0.0;
                //puntaje = 0.0;
                //*********************************************************************************
            }// for j - clases
            
        }// for i - archivos
        return res;
    }
    
    
    
    private int metodosRepetidas()
    {
        double puntajeMetodo = 0.0;
        int res = 0;
        String proyecto1 = "";
        String proyecto2 = "";
        NodoComparacion temp, temp2, temp3;
        
        for(int i = 0; i<listaArchivos.getSize(); i++)
        {
            //listaMethoEncontrados.clear();
            NodoVariables nodoArchivo;
            nodoArchivo = listaArchivos.getVariableByPos(i);
            String nombreArchivo = nodoArchivo.getVariable();
            
            // Inicia comparacion para metodos de una clase/archivo
            temp = inicio;
            proyecto1 = "";
            proyecto2 = "";
            boolean findById = true;
            NodoComparacion nodoTemp = new NodoComparacion();
            String idMetodo = "";
            int parametros1 = 0;
            int parametros2 = 0;
            int lineasMetodo = 0;
            String idMetodo2 = "";
            int lineasMetodo2 = 0;
            while(temp != null)
            {
                puntajeMetodo = 0.0;
                String vTempArchivo [] = temp.getNombreArchivo().split("\\\\");
                if(proyecto1.equals(""))    {   proyecto1 = vTempArchivo [0];   }
                else if(!proyecto1.equalsIgnoreCase(vTempArchivo[0])  && proyecto2.equals("")){   proyecto2 = vTempArchivo[0];   }

                String nombreAr2 = proyecto1+"\\"+nombreArchivo;
                if(temp.getNombreArchivo().equalsIgnoreCase(nombreAr2))
                {
                    if(temp.getNombreFuncion() != null)
                    {
                        idMetodo = temp.getNombreFuncion();
                        lineasMetodo = temp.getLineasFuncion();
                        parametros1 = temp.getCantidadParametros();

                        if(proyecto2.equals(""))
                        {
                            temp3 = inicio;
                            while(temp3 != null)
                            {
                                String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                                if(!nombreTemp[0].equalsIgnoreCase(proyecto1)) {    proyecto2 = nombreTemp[0]; break;    }
                                temp3 = temp3.siguiente;
                            }
                        }
                        if(temp.siguiente != null)
                        {
                            findById = true;
                            temp2 = temp.siguiente;
                            while(temp2 != null)
                            {
                                String nombreAr2M = proyecto2+"\\"+nombreArchivo;

                                if(findById)
                                {
                                    if(temp2.getNombreFuncion() != null && temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2M))//***************************************************************************
                                    {
                                        if(temp2.getNombreFuncion().equals(idMetodo))
                                        {
                                            idMetodo2 = temp2.getNombreFuncion();
                                            lineasMetodo2 = temp2.getLineasFuncion();
                                            parametros2 = temp2.getCantidadParametros();
                                            
                                            if(idMetodo2.equals(idMetodo)) { puntajeMetodo = puntajeMetodo + 0.4; }
                                            if(lineasMetodo2 == lineasMetodo && lineasMetodo != 0) { puntajeMetodo = puntajeMetodo + 0.3; }
                                            if(parametros2 == parametros1) { puntajeMetodo = puntajeMetodo + 0.3; }
                                            proyecto2 = "";
                                            if(puntajeMetodo>=0.6){ res++; }
//                                            System.out.println("ProA - " + idMetodo + "  ProB - " + idMetodo2);
//                                            System.out.println("linA - " + lineasMetodo + "  linB - " + lineasMetodo2);
//                                            System.out.println("parA - " + parametros1 + "  parB - " + parametros2);
//                                            System.out.println("contador: " + res);
                                            //listaMethoEncontrados.add(idMetodo);
                                            break;
                                            
                                        }
                                    }else if(temp2.siguiente == null) 
                                    {
                                        findById = false;
                                        temp2 = temp;
                                    }
                                }
                                else if (temp2.getNombreFuncion() != null && temp2.getNombreArchivo().equalsIgnoreCase(nombreAr2M))
                                {
                                    //if(!yaSeComparo(temp2.getNombreFuncion())){
                                        lineasMetodo2 = temp2.getLineasFuncion();
                                        parametros2 = temp2.getCantidadParametros();
                                        idMetodo2 = temp2.getNombreFuncion();
                                        if(lineasMetodo == lineasMetodo2 && lineasMetodo != 0 && !idMetodo.equals(""))
                                        {  
                                            puntajeMetodo = puntajeMetodo + 0.3;
                                            if(parametros2 == parametros1) { puntajeMetodo = puntajeMetodo + 0.3; }
                                            if(puntajeMetodo>=0.6)
                                            { 
                                                res++; 
//                                                System.out.println("ProA - " + idMetodo + "  ProB - " + idMetodo2);
//                                                System.out.println("linA - " + lineasMetodo + "  linB - " + lineasMetodo2);
//                                                System.out.println("parA - " + parametros1 + "  parB - " + parametros2);
//                                                System.out.println("contador: " + res);
                                                break;
                                            }
                                        }
                                    //}
                                }
                                temp2 = temp2.siguiente; 
                            }
                        }
                    }
                }
                temp = temp.siguiente;
            }  
        }// for i - archivos
        return res;
    }
    
    private double paraMetodos()
    {
        double res = 0.0;
        
        return res;
    }
    
    /*private boolean yaSeComparo(String metodo)
    {
        String var = "";
        for(int i= 0; i<listaMethoEncontrados.size(); i++){
            var = listaMethoEncontrados.get(i);
            if(var.equals(metodo))
            {
                return true;
            }
        }
        return false;
    }*/
    
    private int sumatoriaDatosProyecto1y2(String dato)
    {
        int cont = 0;
        int comentarios = 0;
        int variables = 0;
        int metodos = 0;
        int clases = 0;
        NodoComparacion temp;
        temp = inicio;
        while(temp != null)
        {
            if(temp.getComentarioMultiLinea() != null || temp.getComentarioUniLinea() != null)  {   comentarios++;  }
            else if(temp.getNombreVariable() != null){ variables++; }
            else if(temp.getNombreFuncion() != null){   metodos++;  }
            else if(temp.getNombreClase() != null){   clases++;   }
            temp = temp.siguiente;
        }
        switch(dato)
        {
            case "comentarios":
                cont = comentarios;
                break;
            case "variables":
                cont = variables;
                break;
            case "metodos":
                cont = metodos;
                break;
            case "clases":
                cont = clases;
                break;
        }
        return cont;
    }
    
    public String getDatosResumenProyecto(String dato)
    {
        String resultado = "";
        int comentarios1 = 0;
        int variables1 = 0;
        int metodos1 = 0;
        int clases1 = 0;
        int comentarios2 = 0;
        int variables2 = 0;
        int metodos2 = 0;
        int clases2 = 0;
        NodoComparacion temp, temp3;
        String proyecto = "";
        String proyecto2 = "";
        temp = inicio;
        
        for(int i=0; i<listaArchivos.getSize(); i++)
        {
            temp = inicio;
            String file = listaArchivos.getVariableByPos(i).getVariable();
            proyecto = "";
            proyecto2 = "";
            boolean proyecto1 = true;
            while(temp != null)
            {
                if(proyecto1)
                {
                    String arNomArchivo [] = temp.getNombreArchivo().split("\\\\");
                    if(proyecto.equals("")) {  proyecto = arNomArchivo[0];    }

                    String nombreArch = proyecto+"\\"+file;
                    if((temp.getComentarioMultiLinea() != null || temp.getComentarioUniLinea() != null) &&
                            temp.getNombreArchivo().equals(nombreArch)){   
                        comentarios1++;  
                    }
                    else if(temp.getNombreVariable() != null && temp.getNombreArchivo().equals(nombreArch)){ 
                        variables1++; 
                    }
                    else if(temp.getNombreFuncion() != null && temp.getNombreArchivo().equals(nombreArch)){   
                        metodos1++;  
                    }
                    else if(temp.getNombreClase() != null && temp.getNombreArchivo().equals(nombreArch)){   
                        clases1++;   
                    }
                    
                    if(temp.siguiente == null)
                    {   
                        proyecto1=false;    
                        temp=inicio;
                        temp3 = inicio;
                        while(temp3 != null)
                        {
                            String nombreTemp[] = temp3.getNombreArchivo().split("\\\\");
                            if(!nombreTemp[0].equalsIgnoreCase(proyecto)) {    proyecto2 = nombreTemp[0]; break;    }
                            temp3 = temp3.siguiente;
                        }
                    }else{  
                        temp = temp.siguiente;  
                    }
                }
                else
                {
                    String nombreArch = proyecto2+"\\"+file;
                    if((temp.getComentarioMultiLinea() != null || temp.getComentarioUniLinea() != null) &&
                            temp.getNombreArchivo().equals(nombreArch)) {   comentarios2++;  }
                    else if(temp.getNombreVariable() != null && temp.getNombreArchivo().equals(nombreArch)){ variables2++; }
                    else if(temp.getNombreFuncion() != null && temp.getNombreArchivo().equals(nombreArch)){   metodos2++;  }
                    else if(temp.getNombreClase() != null && temp.getNombreArchivo().equals(nombreArch)){   clases2++;   }
                    temp = temp.siguiente;
                }
            }
        }
        switch(dato)
        {
            case "comentarios":
                resultado = proyecto+"-"+comentarios1 +"-"+proyecto2+"-"+comentarios2;
                break;
            case "variables":
                resultado = proyecto+"-"+variables1 + "-"+proyecto2+"-"+variables2;
                break;
            case "metodos":
                resultado = proyecto+"-"+metodos1+"-"+proyecto2+"-"+metodos2;
                break;
            case "clases":
                resultado = proyecto+"-"+clases1+"-"+proyecto2+"-"+clases2;
                break;
        }
        return resultado;
    }
    
    private void crearListas(){
        NodoComparacion temp;
        temp = inicio;
        while(temp != null)
        {   //****** guardamos todos los nombres de los archivos, pero sin repetirse
            String arNomArchivo [] = temp.getNombreArchivo().split("\\\\");
            String archivo = arNomArchivo[1];
            listaArchivos.agregarVariable("", archivo, "");
            
            //******** guardamos todos los nombres de las clases, pero sin repetirse
            if(temp.getNombreClase() != null)
            {
                listaClases.agregarVariable("", temp.getNombreClase(), String.valueOf(temp.getLineasClase()));
            }
            
            //******* guardamos todos los metodos/funciones
            if(temp.getNombreFuncion() != null)
            {
                listaFunciones.agregarVariable(String.valueOf(temp.getCantidadParametros()), temp.getNombreFuncion(), String.valueOf(temp.getLineasFuncion()));
            }
            
            //************guardando variables
            if(temp.getNombreVariable() != null)
            {
                listaVariables.agregarVariable("", temp.getNombreVariable(), "");
            }
            
            //******* guardadocomentarios
            if(temp.getComentarioMultiLinea() != null)
            {
                listaComentariosMulti.agregarVariable("", temp.getComentarioMultiLinea(), "");
            }
            
            //****** comentarios de una linea
            if(temp.getComentarioUniLinea() != null)
            {
                listaComentariosUni.agregarVariable("", temp.getComentarioUniLinea(), "");
            }
            
            temp = temp.siguiente;
        }
    }
  
}
