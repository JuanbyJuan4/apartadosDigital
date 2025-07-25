/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class TipoEmpleado {
    //atributos
    private int idTipo;
    private String nombreTipo;
    //constructores
    public TipoEmpleado(){
        this.idTipo = 0;
        this.nombreTipo = "";
    }
    public TipoEmpleado(int idTipo, String nombreTipo){
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }
    public TipoEmpleado(TipoEmpleado tipo){
        this.idTipo = tipo.idTipo;
        this.nombreTipo = tipo.nombreTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return nombreTipo;
    }
    
}
