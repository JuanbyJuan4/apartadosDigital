/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author migue
 */

import java.util.ArrayList;
import java.util.Arrays;


public class preguntaMasReservado {
    
    private String[] fechas = new String[2]; 
    private ArrayList<Integer> tipoProducto = new ArrayList<>();

    private final ArrayList<String> allParms = new ArrayList<>(Arrays.asList(
            "BotonFecha_Inicial", "BotonFecha_Final", "Tipos", "Longitud"));
    // Aqui se definen todos los Parametros disponibles en Pregunta1
    // Dentro de aqui ingresar todas las variables que re
    
    
    public preguntaMasReservado(){
        this.fechas = new String[2];
        this.tipoProducto = new ArrayList<>();
    }
    
    public void preguntaMasReservado(String[] fechas, ArrayList<Integer> tipoProducto){
        this.fechas = fechas;
        this.tipoProducto = tipoProducto;
    }
    
    public void preguntaMasReservado(String[] fechas){
        this.fechas = fechas;
    }
    
    public void preguntasMasReservado(ArrayList<Integer> tipoProducto){
        this.tipoProducto = tipoProducto;
    }
    
    public String[] getFechas() {
        return fechas;
    }

    public void setFechas(String[] fechas) {
        this.fechas = fechas;
    }

    public ArrayList<Integer> getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(ArrayList<Integer> tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
   
    public ArrayList<String> getAllParms() {
        return allParms;
    } 
}

