import Parte1.*;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    MathManagerImpl matematicas;
    Alumno a1;
    Alumno a2;
    Operacion o1;
    Operacion o2;


    @org.junit.Before
    public void setUp() throws Exception {
        matematicas = MathManagerImpl.getInstance();
        Alumno a1= new Alumno("Fran", "I Barcelona");
        Alumno a2=new Alumno("Javi","I Casteldefels");
        Operacion o1=new Operacion ("PolacaInversa",a1);
        Operacion o2=new Operacion ("Suma",a2);
        o1.setU(a1);
        o2.setU(a2);


    }

    @org.junit.After
    public void tearDown() throws Exception {
        a1=null;
        a2=null;
        o1=null;
        o2=null;
        MathManagerImpl.clear();
    }

    @org.junit.Test
    public void realizaroperacion() throws Exception {
        assertNotEquals(1, matematicas.cola.size());
        matematicas.realizarOperacion(o1);
        assertEquals(1, matematicas.cola.size());
        matematicas.realizarOperacion(o2);
        assertEquals(2, matematicas.cola.size());

    }
   @org.junit.Test
    public void procesarOperacion() throws Exception {
       matematicas.realizarOperacion(o1);
        matematicas.procesarOperacion();
       assertEquals(2, matematicas.diccionarioInstitutos.get(2).getCantidadOperaciones());
            }

}


