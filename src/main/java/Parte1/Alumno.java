package Parte1;

import java.util.ArrayList;

public class Alumno {
     private String nombre;
     private String instituto;
     private ArrayList<Operacion> operacionesAlumno=new ArrayList <Operacion>();

     public Alumno(String nombre, String instituto){
         this.nombre=nombre;
         this.instituto=instituto;
     }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
    public ArrayList<Operacion> getOperacionesAlumno() {
        return operacionesAlumno;
    }

    public void setOperacionesAlumno(ArrayList<Operacion> operacionesAlumno) {
        this.operacionesAlumno = operacionesAlumno;
    }


}
