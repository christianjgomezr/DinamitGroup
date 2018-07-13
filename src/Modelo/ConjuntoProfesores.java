/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author Ugueto
 */
public class ConjuntoProfesores {
     
     private ArrayList<Profesor> listado;
    public ConjuntoProfesores() {
        listado = new ArrayList<>();
    }
     
    public void agregar(Profesor P){
        listado.add(P);
    }
    public ArrayList<Profesor> getListado()
    {
         return listado;
    }
    public int getTotal() {
        return listado.size();
    }
}
