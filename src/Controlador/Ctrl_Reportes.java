package Controlador;
mport Modelo.ConjuntoProfesores;
import Modelo.ConjuntoTrabajos;
import Modelo.Profesor;
import Modelo.Trabajo;
import java.io.*;
import Vista.*;
import javax.swing.JFrame;


public class Ctrl_Reportes {
    private static final Ctrl_Reportes INSTANCE = new Ctrl_Reportes();
    private Ctrl_Reportes() {
        ICargarProf=new ICargarProfesores(this);
        ICargarTrab = new ICargarTrabajos(this);
        IMen= new IMenu(this);
        ISelectUs = new ISelectUser(this);
        IConsultarTrab= new IConsultarTrabajos(this);
    } 
    public static Ctrl_Reportes getInstance() {
        return INSTANCE;
    }
    
    //atributos de interfaces graficas
    private IMenu IMen;
    private ISelectUser ISelectUs;
    private ICargarProfesores ICargarProf;
    private ICargarTrabajos ICargarTrab;
    private IConsultarTrabajos IConsultarTrab;
    
    private JFrame ventanaAnterior;
    
    public void ocultarTodo() {
        IMen.setVisible(false);
        ISelectUs.setVisible(false);
        
        ICargarProf.setVisible(false);
        IConsultarTrab.setVisible(false);
    }
    
    //MENU e ISelectUser
    public void i_Menu() {
        ocultarTodo();
        IMen.setVisible(true);
    }
    
    public void ventanaAnterior(int tipoUser) { //1 es comision
        if(tipoUser == 1) {
            ventanaAnterior = IMen;
        } else if(tipoUser ==0 ) {
            ventanaAnterior = ISelectUs;
        }
    }
    
    public void volver() {
        ocultarTodo();
        ventanaAnterior.setVisible(true);   
    }
    
    public void i_SelectUser() {
        ocultarTodo();
        ISelectUs.setVisible(true);
    }
    
        
    
    
    //METODOS DE LA CLASE CONTROLADORA
    public int i_copiar_archivo_prof() {
        String linea;
        ConjuntoProfesores cp = new ConjuntoProfesores();  //Prueba de carga de profesores en esta estructura
        Profesor prof;
        
       try {
            FileReader fr = new FileReader("profs_Centros.txt");
            BufferedReader br = new BufferedReader(fr);
                   
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                prof = new Profesor();
                prof.llenarCampos(linea);
                cp.agregar(prof);              
            }    
        } catch(Exception e) {
            return 0;
        } finally {} 
        return cp.getSize();
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
                     
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                //campos opcionales:
                
                //campos opcionales:
                //[apellido y nombre 1]
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                apellido = linea.substring(li_str, ls_str);
                
                 li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
               
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                nombre = linea.substring(li_str, ls_str);
                
                li_str = ls_str;
                    ++ls_str; 
                    ++li_str;
                
                    
                if(nivel.equalsIgnoreCase("TEG")) {
                    //[ci_2, nombre2 y apellido2]
                    
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
                    li_str = ls_str;
                ++ls_str; 
                ++li_str;
                } else {
                    apellido_2 = nombre_2 = " ";
                    ci_2 = " ";
                }
                //sem1erains
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                sem1erainsc = linea.substring(li_str, ls_str);
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                //fechaDefensa 
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                fechaDefensa = linea.substring(li_str, ls_str);
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                //ci t
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                ci_t = linea.substring(li_str, ls_str);
                 
                
                System.out.println("ci:"+ci);    
                 System.out.println("apellido1: "+apellido);
                System.out.println("nombre1: "+nombre);
                System.out.println("ci_2:"+ci_2);             
                 System.out.println("apellido2: "+apellido_2);       
                System.out.println("nombre2: "+nombre_2);
                System.out.println("sem1erainsc:"+sem1erainsc);
                System.out.println("fechaDefensa:"+fechaDefensa);
                System.out.println("ci_t: "+ci_t);
                //reiniciar apuntadores de subcadenas
                li_str = ls_str =4;
                }
            
        } catch(IOException e) {
            System.out.print("Archivo no valido.\n Detalles error: "+e.getMessage());
        } finally {} 
    }
    
    
    //METODOS DE INTERFACES
    public void i_CargarProfesores() {
        if(ICargarProf == null) {
            ICargarProf = new ICargarProfesores(this);
        }   
        ICargarProf.setVisible(true);
    }
    
    public void i_CargarTrabajos() {
        ICargarTrab.setVisible(true);
    }
    
    public void i_ConsultarTrabajos() {
        if(IConsultarTrab == null) {
            IConsultarTrab = new IConsultarTrabajos(this);
        }
        IConsultarTrab.setVisible(true);
    }
    
    //METODOS DE REPORTES
    
        //Reportar Trabajos Profesores
    public void i_Consultar_Prof(Date fech_li, Date fech_ls, int ord) {
        for (int i=0;i< Size(ConjuntoTrabajos); i++){
            if(ConjuntoTrabajos.listado[i].getFechaDefensa() <= fech_ls ^ ConjuntoTrabajos.listado[i].getFechaDefensa() >= fecha_li){ 
                if(ExisteProf(ConjuntoTrabajos.listado[i].getCi_t1)){
                    ReporteProfesores.Lista.ci_t1.cant_trab++;
                }
                if(ExisteProf(ConjuntoTrabajos.listado[i].getCi_t2)){
                    ReporteProfesores.Lista.ci_t2.cant_trab++;
                }
            }
        }
 ReporteProfesores.Ordenar(ord)
 desplegar(ReporteProfesores);
    }
    
        //Reportar Trabajos Centros
    public void i_Consultar_Cent(String centro, Date fech_li, Date fech_ls) {
           
        for(int i=0;i<Size(ConjuntoTrabajos);i++){
        if(Trabajo.getfechaDefensa() <= fech_ls ^ Trabajo.getFechaDefensa() >= fech_li)
            if(PerteneceMismoCentro(centro, ConjuntoTrabajos.listado[i].getCi_t1,ConjuntoTrabajos.listado[i].getCi_t2)){ 
                ReporteCentros.lista.Centro.add();
            }else{
                ReporteCentros.lista.Centro1.add();
                ReporteCentros.lista.Centro2.add()
            }
                    
        }
        desplegar(ReporteCentros)
    }
    
    public boolean PerteneceMismoCentro(String centro,int c1, int c2){
        for(int i=0; i<co.getSize(); i++){
            if (cp[i].getCi()== c1 || cp[i].getCi()== c2){
                if(cp[i].getCentro()==centro)
                    return true;
            }
        }
        return false;
     }
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
