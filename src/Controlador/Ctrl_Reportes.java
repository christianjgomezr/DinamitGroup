package Controlador;
import Modelo.ConjuntoProfesores;
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
        Profesor P;
        
       try {
            FileReader fr = new FileReader("profs_Centros.txt");
            BufferedReader br = new BufferedReader(fr);
                   
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                P = new Profesor();
                P.llenarCampos(linea);
                cp.agregar(P);              
            }    
        } catch(Exception e) {
            return 0;
        } finally {} 
        return cp.getTotal();
    }
    
     public int i_copiar_archivo_trab() {
        String linea;
        ConjuntoTrabajos ct = new ConjuntoTrabajos();        
        try {
            FileReader fr = new FileReader("trabajos.txt");
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                Trabajo T = new Trabajo();
                if (T.llenarCampos(linea) == -1) {
                  throw new IOException();  
                }
                ct.agregar(T);
            }
            
        } catch(IOException e) {
             return 0;
        } finally {} 
        return ct.getTotal();
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
        //falta como saber que prof del conjunto es el que tratamos
        /*
            Reporte.agregarProf(prof);
    for(int i=0;i<Size(ConjuntoTrabajos);i++){
             if (ConjuntoTrabajos.listado[i].getCi_t()==profesor.getCi){
                 Reporte.agregarT(ConjuntoTrabajos.listado[i]);
             }
              
             else if(ConjuntoTrabajos.listado[i].getCi_t2()==profesor.getCi){
                        Reporte.agregarT(ConjuntoTrabajos.listado[i]);
             }
    }
    
    Consulta.desplegarConsulta()
     */   
    }
    
}
