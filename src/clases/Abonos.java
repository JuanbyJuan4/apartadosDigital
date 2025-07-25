/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
/**
 *
 * @author Usuario
 */
public class Abonos {
    //atributos
    private int idAbono;
    private String idProducto;
    private String nombreProducto;
    private String fecha;
    private double abono;
    //constructores
    public Abonos(){
        this.idAbono = 0;
        this.idProducto = "";
        this.nombreProducto = "";
        this.fecha = "";
        this.abono = 0.0;
    }
    public Abonos(int idAbono,String idProducto, String nombreProducto, String fecha, double abono){
        this.idAbono = idAbono;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fecha = fecha;
        this.abono = abono;
    }
    public Abonos(Abonos abonos){
        this.idAbono = abonos.idAbono;
        this.idProducto = abonos.idProducto;
        this.nombreProducto = abonos.nombreProducto;
        this.fecha = abonos.fecha;
        this.abono = abonos.abono;
    }

    public int getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }
    
}
