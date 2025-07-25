/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author juanm
 */
public class TipoProducto {
    private int idTipo;
    private String nombre;
    private boolean estado;
    
    public TipoProducto(){
        this.idTipo = 0;
        this.nombre = "";;
        this.estado = true;
    }
    public TipoProducto(int idTipo, String nombre, boolean estado){
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.estado = estado;
    }
    public TipoProducto(TipoProducto tipo){
        this.idTipo = tipo.idTipo;
        this.nombre = tipo.nombre;
        this.estado = tipo.estado;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
