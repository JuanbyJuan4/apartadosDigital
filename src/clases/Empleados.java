/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Empleados {
    private int idEmpleado;
    private String nombre;
    private String contraseña;
    private int idTipoEmp;
    private String tipo;
    
    public Empleados(){
        this.idEmpleado = 0;
        this.nombre = "";
        this.contraseña = "";
        this.idTipoEmp = 0;
        this.tipo = "";
    }
    public Empleados(int idEmpleado, String nombre, String contraseña, int idTipoEmp, String tipo){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.idTipoEmp = idTipoEmp;
        this.tipo = tipo;
    }
    public Empleados(Empleados empleados){
        this.idEmpleado = empleados.idEmpleado;
        this.nombre = empleados.nombre;
        this.contraseña = empleados.contraseña;
        this.idTipoEmp = empleados.idTipoEmp;
        this.tipo = empleados.tipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdTipoEmp() {
        return idTipoEmp;
    }

    public void setIdTipoEmp(int idTipoEmp) {
        this.idTipoEmp = idTipoEmp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
