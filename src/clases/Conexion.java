/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import digitalsound.listapartados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection Conection;
    private static Statement Sentencia;
    private static ResultSet Resultado;
    private final String bd;
    private final String user;
    private final String password;
    listapartados listaap;

public Conexion(String bd, String user, String password){
    Conection = null;
    Sentencia = null;
    Resultado = null;
    this.bd = bd;
    this.user = user;
    this.password = password;
}
    public boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Conection = DriverManager.getConnection("jdbc:mysql://localhost/"+bd,user,password);
            return Conection != null;
        }catch(Exception e){
            System.out.println("ERROR");
            return false;
        }
    }
    public void desconectar(){
        try{
            this.Conection.close();
        }catch(Exception e){
            
        }
    }
    public ArrayList getListaClientes(String nombre){
        ArrayList mListaClientes = new ArrayList();
        Clientes mClientes = null;
        Statement consulta;
        ResultSet resultado;
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/sistemaapartado","root","");
            PreparedStatement pst = cn.prepareStatement("CALL buscar_cliente(?)");
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Procesando fila...");
                mClientes = new Clientes();
                mClientes.setIdCliente(rs.getInt("idCliente"));
                mClientes.setNombreCliente(rs.getString("NombreCliente"));
                mListaClientes.add(mClientes);         
            }
            System.out.println("Se ha procesado todo el ResultSet");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Conexion fallida");
            e.printStackTrace();
        }
        return mListaClientes;
    }
        public ArrayList getListaApartados(){
        ArrayList mListaApartados = new ArrayList();
        Ticket mTicket = null;
        Statement consulta;
        ResultSet resultado;
        try{
            
            consulta = Conection.createStatement();
            resultado = consulta.executeQuery("CALL consulta_apartados();");
            
            while(resultado.next()){
                System.out.println("Procesando fila...");
                mTicket = new Ticket();
                mTicket.setIdTicket(resultado.getInt("ID"));
                mTicket.setCliente(resultado.getString("CLIENTE"));
                mTicket.setFecha(resultado.getString("FECHA"));
                mTicket.setTotal(resultado.getString("TOTAL"));
                mTicket.setSaldo(resultado.getString("SALDO"));
                mListaApartados.add(mTicket);                
            }
            System.out.println("Se ha procesado todo el ResultSet");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return mListaApartados;
    }
    }
    