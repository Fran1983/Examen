package Parte1;

import java.util.ArrayList;

public interface MathManager {


    public void realizarOperacion(Operacion o);

    public double procesarOperacion ();

    public ArrayList<Operacion> listadoOperacionesInstituto(String i);

    public ArrayList<Operacion> listadoOperacionesAlumno(Alumno u);

    public ArrayList<Instituto> institutosOrdenadosOperaciones();



}
