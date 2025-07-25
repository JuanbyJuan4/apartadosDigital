/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Clientes {
    private int idCliente;
    private String nombreCliente;
    private boolean estadoCliente;
    private String correoCliente;
    private String numeroCliente;
    private int comboBox;
    //constructores
    public Clientes(){
        this.idCliente = 0;
        this.nombreCliente = "";
        this.estadoCliente = true;
        this.correoCliente = "";
        this.numeroCliente = "";
        this.comboBox = 0;
    }
    public Clientes(int idCliente,String nombreCliente,boolean estadoCliente, String correoCliente, String numeroCliente, int comboBox){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.estadoCliente = estadoCliente;
        this.correoCliente = correoCliente;
        this.numeroCliente = numeroCliente;
        this.comboBox = comboBox;
    }
    public Clientes(Clientes clientes){
        this.idCliente = clientes.idCliente;
        this.nombreCliente = clientes.nombreCliente;
        this.estadoCliente = clientes.estadoCliente;
        this.correoCliente = clientes.correoCliente;
        this.numeroCliente = clientes.numeroCliente;
        this.comboBox = clientes.comboBox;
    }
    //encapsulamiento
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreoCliente(){
        return correoCliente;
    }
    
    public void setCorreoCliente(String correoCliente){
        this.correoCliente = correoCliente;
    }
    
    public String getNumeroCliente(){
        return numeroCliente;
    }
    
    public void setNumeroCliente(String numeroCliente){
        this.numeroCliente = numeroCliente;
    }
    
    public int getComboBox(){
        return comboBox;
    }
    
    public void setComboBox(int comboBox){
        this.comboBox = comboBox;
    }
    //metodos
    public boolean getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    @Override
    public String toString() {
        if(comboBox == 1){
            return correoCliente;
        }if(comboBox == 2){
            return numeroCliente;
        }else{
            return idCliente + "   |  " + nombreCliente;
        }
    }
}
