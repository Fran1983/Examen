package Parte1;
import org.apache.log4j.Logger;

import java.util.*;

public class MathManagerImpl implements MathManager {

    private static Logger log = Logger.getLogger(MathManagerImpl.class);
    public Queue<Operacion> cola=new LinkedList<Operacion>();
    public ArrayList<Instituto> diccionarioInstitutos=new ArrayList<Instituto>();
    private static MathManagerImpl ourInstance;
    private ArrayList<Operacion> listado=new ArrayList<Operacion>();

    public static MathManagerImpl getInstance() {
        if (ourInstance==null)//Si es la primera vez que se llama al constructor crea la nueva isntancia si no devuelve la ya creada
            ourInstance = new MathManagerImpl();
        return ourInstance;
    }

    private MathManagerImpl() {
        //Carga el catálogo de productos.
        this.listado = this.generarListadoOperaciones();
    }

    @Override
    public void realizarOperacion(Operacion o){
        cola.add(o);
        log.info("Añadida la operación a la cola de operaciones");
    }

    public double procesarOperacion (){
        Operacion o=cola.poll();
        log.info("Extraida la operación de la cola de operaciones");
        double resultado=0;
        Instituto ins=new Instituto();
        o.getU().getOperacionesAlumno().add(o);
        log.info("Añadida la operación a la lista del alumno");
        String nombreInsti=o.getU().getInstituto();
        int i=ins.buscarInstituto(o.getU().getInstituto(),diccionarioInstitutos);
        diccionarioInstitutos.get(i).getOperacionesTotales().add(o);
        log.info("Añadida la operación del alumno en la lista de operaciones del instituto");
        diccionarioInstitutos.get(i).setCantidadOperaciones(diccionarioInstitutos.get(i).getCantidadOperaciones()+1);
        log.info("Sumada la operación al total de operaciones");
        cola.poll(); //Realmente no es necesario porque el método hasta que no resuelve la operación no termina
        log.info("Realizada la operación se saca de la cola");
        return resultado;
    }

    @Override
    public ArrayList<Operacion> listadoOperacionesInstituto(String instituto){
        Instituto ins=new Instituto();
        int i=ins.buscarInstituto(instituto,diccionarioInstitutos);
        return diccionarioInstitutos.get(i).getOperacionesTotales();

    }

    @Override
    public ArrayList<Operacion> listadoOperacionesAlumno(Alumno a){
        return a.getOperacionesAlumno();
    }

    @Override
    public ArrayList<Instituto> institutosOrdenadosOperaciones(){
        ArrayList<Instituto> listadoOrdenadoOperaciones=diccionarioInstitutos;
        Collections.sort(listadoOrdenadoOperaciones, new Comparator<Instituto>() {
            @Override
            public int compare(Instituto i1, Instituto i2) {
                return(i2.getCantidadOperaciones()-i1.getCantidadOperaciones());
                //return new Double(p1.getPrecio()).compareTo(p2.getPrecio());
            }
        });
        log.info("Institutos ordenados por operaciones");
        return listadoOrdenadoOperaciones;
    };

    //6.- Encargado de cargar el listado de operaciones permitidas

        public ArrayList<Operacion> generarListadoOperaciones(){
        Instituto i1= new Instituto("I Castelldefells");
        Instituto i2=new Instituto("I Barcelona");
        diccionarioInstitutos.add(i1);
        diccionarioInstitutos.add(i2);
        log.info("Institutos añadidos");
        return listado;
    }

    public static void clear(){
        ourInstance = new MathManagerImpl();}
}
