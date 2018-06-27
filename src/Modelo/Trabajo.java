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
class Trabajo extends Estructura {
    private String nivel;
    private String titulo;
    private long ci_2;
    private String Apellido_2;
    private String Nombre_2;
    private String sem1erainsc;
    private String fechaDefensa;
    private long ci_t;
    private String Apellido_t1;
    private String Nombre_t1;
    private long ci_t2;
     private String Apellido_t2;
    private String Nombre_t2;
    
    
    //metodos
    String getTitulo() {
        return titulo;
    }
    String getFechaDefensa() {
        return fechaDefensa;
    }
    
    
}
