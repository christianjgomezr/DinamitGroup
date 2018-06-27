/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author krlos
 */
class Estructura {
    protected int ci;
    protected String Nombre;
    protected String Apellido;
    protected int cont_Total;
    
    
    //metodos
    int getCI() {
        return ci;
    }
    String getNombre() {
        return Nombre;
    }
    String getApellido() {
        return Apellido;
    }
    
    void llenarCampos(String linea) {
        
    }
}
