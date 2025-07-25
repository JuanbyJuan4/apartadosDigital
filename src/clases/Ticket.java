/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Ticket {
    //atributos
    private int idTicket;
    private String cliente;
    private String fecha;
    private String total;
    private String saldo;
    //constructores
    public Ticket(){
        this.idTicket = 0;
        this.cliente = "";
        this.fecha = "";
        this.total = "";
        this.saldo = "";
    }
    public Ticket(int id, String cliente, String fecha, String total, String saldo){
        this.idTicket = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.saldo = saldo;
    }
    public Ticket(Ticket ticket){
        this.idTicket = ticket.idTicket;
        this.cliente = ticket.cliente;
        this.fecha = ticket.fecha;
        this.total = ticket.total;
        this.saldo = ticket.saldo;
    }
    //encapsulamiento
    public int getIdTicket(){
        return idTicket;
    }
    
    public void setIdTicket(int idTicket){
        this.idTicket = idTicket;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
