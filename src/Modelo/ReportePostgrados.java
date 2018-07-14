/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author Ugueto
 */
public class ReportePostgrados extends Reporte{
    
    
    public void ordenar(){
        Profesor aux = new Profesor();
        for(int i=ListaProf.size()-1; i>0 ;i--){      
            for(int j=0; j<i ;j++){
                if(ListaProf.get(j).Apellido.compareTo(ListaProf.get(j+1).Apellido)==0){ 
                    
                    if(ListaProf.get(j).Nombre.compareTo(ListaProf.get(j+1).Nombre)<0){ //pasa al nombre
                        aux.Apellido=ListaProf.get(j).Apellido;
                        aux.Nombre=ListaProf.get(j).Nombre;
                        aux.centro=ListaProf.get(j).centro;
                        aux.ci=ListaProf.get(j).ci;

                        ListaProf.get(j).Apellido=ListaProf.get(j+1).Apellido;
                        ListaProf.get(j).Nombre=ListaProf.get(j+1).Nombre;
                        ListaProf.get(j).centro=ListaProf.get(j+1).centro;
                        ListaProf.get(j).ci=ListaProf.get(j+1).ci;

                        ListaProf.get(j+1).Apellido=aux.Apellido;
                        ListaProf.get(j+1).Nombre=aux.Nombre;
                        ListaProf.get(j+1).centro=aux.centro;
                        ListaProf.get(j+1).ci=aux.ci;
                    }
                }
                if(ListaProf.get(j).Apellido.compareTo(ListaProf.get(j+1).Apellido) < 0){
                    
                    aux.Apellido=ListaProf.get(j).Apellido;
                    aux.Nombre=ListaProf.get(j).Nombre;
                    aux.centro=ListaProf.get(j).centro;
                    aux.ci=ListaProf.get(j).ci;
                    
                    ListaProf.get(j).Apellido=ListaProf.get(j+1).Apellido;
                    ListaProf.get(j).Nombre=ListaProf.get(j+1).Nombre;
                    ListaProf.get(j).centro=ListaProf.get(j+1).centro;
                    ListaProf.get(j).ci=ListaProf.get(j+1).ci;
                    
                    ListaProf.get(j+1).Apellido=aux.Apellido;
                    ListaProf.get(j+1).Nombre=aux.Nombre;
                    ListaProf.get(j+1).centro=aux.centro;
                    ListaProf.get(j+1).ci=aux.ci;
                }
            }
        } 
    }
       
    public void listarProf(String ci_t){
        ListaProf.add(ConjuntoProfesores.encontrarProf(ci_t));
    }
}
