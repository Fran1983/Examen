package Parte1;

public class Operacion {

    private String tipo;
    private Alumno u;

    public Operacion(){}
    public Operacion(String tipo, Alumno a){
        this.tipo=tipo;
        this.u=a;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Alumno getU() {
        return u;
    }

    public void setU(Alumno u) {
        this.u = u;
    }
}

