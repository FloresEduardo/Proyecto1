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
public class NodoJSON {
    
    double puntajeGeneral;
    List<NodoEspecifico> puntajeEspecifico = new ArrayList<>();

    public NodoJSON() {
    }

    public double getPuntajeGeneral() {
        return puntajeGeneral;
    }

    public void setPuntajeGeneral(double puntajeGeneral) {
        this.puntajeGeneral = puntajeGeneral;
    }

    public List<NodoEspecifico> getPuntajeEspecifico() {
        return puntajeEspecifico;
    }

    public void setPuntajeEspecifico(List<NodoEspecifico> puntajeEspecifico) {
        this.puntajeEspecifico = puntajeEspecifico;
    }
    
    
}
