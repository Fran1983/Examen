package Parte1;

import java.util.ArrayList;

public class Instituto {

    private String nombre;
    private int cantidadOperaciones=0;
    private ArrayList<Operacion> operacionesTotales;
    private ArrayList<Alumno> alumno=new ArrayList<Alumno>();

    public Instituto(){}
    public Instituto(String nombre){
        this.nombre=nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadOperaciones() {
        return cantidadOperaciones;
    }

    public void setCantidadOperaciones(int cantidadOperaciones) {
        this.cantidadOperaciones = cantidadOperaciones;
    }

    public ArrayList<Operacion> getOperacionesTotales() {
        return operacionesTotales;
    }

    public void setOperacionesTotales(ArrayList<Operacion> operacionesTotales) {
        this.operacionesTotales = operacionesTotales;
    }

    public int buscarInstituto(String nombre, ArrayList<Instituto> institutos) {
        int resultado = -1;
        int i = 0;
        while (i < institutos.size()) {
            if (institutos.get(i).getNombre().equals(nombre)) {
                resultado = i;
            }
            i++;
        }
        return resultado;
    }



}
