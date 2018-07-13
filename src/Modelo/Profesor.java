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
public class Profesor {
    String ci;
    String Apellido;
    String Nombre; 
    String centro;
    public String getCentro(){
        return centro;
    }
    public String getCi(){
        return ci;
    }
    
    public void llenarCampos(String linea) {
        int li_str=0, ls_str=1;
                 while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.ci = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.Apellido = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.Nombre = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != ';') {ls_str++;}
                this.centro = linea.substring(li_str, ls_str);
                //System.out.println("\nci:"+ci+"\nNombre:"+Nombre+"\nApellido:"+Apellido+"\ncentro:"+centro);
    }
}
