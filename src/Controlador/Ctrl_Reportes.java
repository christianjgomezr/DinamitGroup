package Controlador;
import java.io.*;

import Vista.*;


public class Ctrl_Reportes {
    private Ctrl_Reportes() {
        ICP=null;
        IM=null;
    } 
    public static Ctrl_Reportes getInstance() {
        return Ctrl_ReportesHolder.INSTANCE;
    }
    private static class Ctrl_ReportesHolder {

        private static final Ctrl_Reportes INSTANCE = new Ctrl_Reportes();
    }
    //variables
    private ICargarProfesores ICP;
    private IMenu IM;
    
    //MENU
    public void i_Menu() {
        if(IM == null) {
            IM = new IMenu();
        }
        IM.setVisible(true);
    }
    
    
    //METODOS DE LA CLASE CONTROLADORA
    public int i_copiar_archivo_prof() {
        String linea;
        int total_prof=0;
        String Nombre, Apellido, ci, centro;
        int li_str=0, ls_str=1;
        
        
        try {
            FileReader fr = new FileReader("profs_Centros.txt");
            BufferedReader br = new BufferedReader(fr);
          
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                ci = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                Apellido = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                Nombre = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != ';') {ls_str++;}
                centro = linea.substring(li_str, ls_str);
                
                System.out.println("\nci:"+ci+"\nNombre:"+Nombre+"\nApellido:"+Apellido+"\ncentro:"+centro);
                
                li_str = ls_str=0;
                ++total_prof;
            }    
        } catch(Exception e) {
            total_prof=0;
        } finally {} 
        return total_prof;
    }
    
    public void i_copiar_archivo_trab() {
        String linea;
        String nivel, titulo, nombre, apellido, ci, ci_2, apellido_2, nombre_2, sem1erainsc;
        String fechaDefensa, ci_t, apellido_t1, nombre_t1, ci_t2, apellido_t2, nombre_t2;
        
        int ls_str=4, li_str=4;
        
        try {
            FileReader fr = new FileReader("trabajos.txt");
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                //asignar a campos OBLIGATORIOS 1
                nivel = linea.substring(0, 3);
                if(!nivel.equalsIgnoreCase("TEG") && !nivel.equalsIgnoreCase("TGM") && !nivel.equalsIgnoreCase("TDR")){
                    throw new IOException("campos de archivo invalidos");
                }
                                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                titulo = linea.substring(li_str, ls_str);
                
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                ci = linea.substring(li_str, ls_str);
                               
                
                //campos opcionales:
                //[apellido y nombre 1]
                 li_str = ls_str;
                ++ls_str; 
                ++li_str;
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                apellido = linea.substring(li_str, ls_str);
                
                 li_str = ls_str;
                ++ls_str; 
                ++li_str;
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                nombre = linea.substring(li_str, ls_str);
                
                //[ci_2, nombre2 y apellido2]
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                    while(linea.charAt(ls_str) != '#') {ls_str++;}
                    ci_2 = linea.substring(li_str, ls_str);
                } else {
                    ci_2 = " ";
                }
                
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                    while(linea.charAt(ls_str) != '#') {ls_str++;}
                    apellido_2 = linea.substring(li_str, ls_str);
                } else {
                    apellido_2 = " ";
                }
                 li_str = ls_str;
                ++ls_str; 
                ++li_str;
                 if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                     while(linea.charAt(ls_str) != '#') {ls_str++;}
                     nombre_2 = linea.substring(li_str, ls_str);
                 } else {
                     nombre_2 =" ";
                 }
                
                 
                 
                 
                System.out.println("INFO:\nnivel:"+nivel+"\ntitulo:"+titulo+"\nci:"+ci+"\napellido1:"+apellido+"\nnombre1:"+nombre+"\nci_2:"+ci_2+"\napellido2:"+apellido_2+"\nnombre2:"+nombre_2);
                
                
                //reiniciar apuntadores de subcadenas
                li_str = ls_str =4;
            }
        } catch(IOException e) {
            System.out.print("Archivo no valido.\n Detalles error: "+e.getMessage());
        } finally {} 
    }
    
    
    //METODOS DE INTERFACES
    public void i_CargarProfesores() {
        
        if(ICP == null) {
            ICP = new ICargarProfesores();
             ICP.setVisible(true);
        } else {
            ICP = null;
        }
        
      
        
    }
    
    
    //METODOS DE REPORTES
    
        //Reportar Trabajos Profesores
    public void i_Consultar_Prof(Date fech_li, Date fech_ls, int ord) {
        
    }
    
        //Reportar Trabajos Centros
    public void i_Consultar_Cent(String centro, Date fech_li, Date fech_ls) {
        
    }
    
        //
    
    
        //Consultar Trabajos profesores
    public void i_Consultar_Trab(String prof) {
        int i=0; 
        int j=0;
        int S = 0;//ConjuntoTrabajos.Tamanio();
        int total=0;
        /*
        for(;i<S ;++i) {
            if(ConjuntoTrabajos.listado[i].getCI == prof) {
              
                Lista[j] = ConjuntoTrabajos.listado[i].getTrabajo();
               ++total;  
               ++j; 
            }  
        }
     */   
    }
    
}
