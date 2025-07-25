/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Producto {
    private String idProducto;
    private int idTipo;
    private String nombre;
    private String descripcion;
    private double precio;
    private String fecha;
    private int estado;
    
    public Producto(){
        this.idProducto = "";
        this.idTipo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0.0;
        this.fecha = "";
        this.estado = 1;
    }
    public Producto(String idProducto, int idTipo, String nombre, String descripcion, double precio, String fecha, int estado){
        this.idProducto = idProducto;
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
    }
    public Producto(Producto producto){
        this.idProducto = producto.idProducto;
        this.idTipo = producto.idTipo;
        this.nombre = producto.nombre;
        this.descripcion = producto.descripcion;
        this.precio = producto.precio;
        this.fecha = producto.fecha;
        this.estado = producto.estado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
