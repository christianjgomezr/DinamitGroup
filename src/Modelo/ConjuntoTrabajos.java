/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author Sagnior
 */
public class ConjuntoTrabajos{
    private ArrayList<Trabajo> listado;
    
    public void agregar(Trabajo P){
        listado.add(P);
    }
}
