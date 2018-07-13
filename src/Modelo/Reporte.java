/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Ugueto
 */
public abstract class Reporte {
    protected Calendar fecha_li= new GregorianCalendar(2014,Calendar.JANUARY,01);//(AÑO,MES,DIA)(los meses van de 0 a 11 y es mejor ponerlos así
    protected Calendar fecha_ls= new GregorianCalendar();
    
    protected ArrayList<Trabajo> Lista;
    
    public esValido(Calendar fecha_li,Calendar fecha_ls){
        
    }
}
