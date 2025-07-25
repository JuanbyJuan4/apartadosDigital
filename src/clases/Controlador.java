//CLASE PARA ACTUALIZAR LISTAS
package clases;

public class Controlador {
    //parametros
    private int estadoAbono;
    //constructores
    public Controlador(){
        this.estadoAbono = 0;
    }
    public Controlador(int estadoAbono){
        this.estadoAbono = estadoAbono;
    }
    public Controlador(Controlador controlador){
        this.estadoAbono = controlador.estadoAbono;
    }
    //encapsulamiento
    public int getEstadoAbono() {
        return estadoAbono;
    }
    public void setEstadoAbono(int estadoAbono) {
        this.estadoAbono = estadoAbono;
    }
}
