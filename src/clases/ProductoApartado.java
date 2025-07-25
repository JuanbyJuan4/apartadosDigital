/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class ProductoApartado {
    //atributos
    private int idProdApartado;
    private int idReserva;
    private String nombre;
    private String id;
    private double precio;
    private int cantidad;
    private double total;
    private double saldo;
    //constructores
    public ProductoApartado(){
        this.idProdApartado = 0;
        this.idReserva = 0;
        this.nombre = "";
        this.id = "";
        this.precio = 0.0;
        this.cantidad = 0;
        this.total = 0.0;
        this.saldo = 0.0;
    }
    public ProductoApartado(int idProdApartado, int idReserva, String nombre, String id, double precio, int cantidad, double total, double saldo){
        this.idProdApartado = idProdApartado;
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.saldo = saldo;
    }
    public ProductoApartado(ProductoApartado productoApartado){
        this.idProdApartado = productoApartado.idProdApartado;
        this.idReserva = productoApartado.idReserva;
        this.nombre = productoApartado.nombre;
        this.id = productoApartado.id;
        this.precio = productoApartado.precio;
        this.cantidad = productoApartado.cantidad;
        this.total = productoApartado.total;
        this.saldo = productoApartado.saldo;
    }
    //encapsulamiento

    public int getIdProdApartado() {
        return idProdApartado;
    }

    public void setIdProdApartado(int idProdApartado) {
        this.idProdApartado = idProdApartado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //toString
    @Override
    public String toString() {
        return nombre;
    }
    
}
