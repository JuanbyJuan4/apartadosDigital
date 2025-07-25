/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import digitalsound.ConsultasTransaccionalesDB;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

// Diferentes tipos de Parametros que una pregunta analitca puede tener
// 
// Objetivo: Verificar el contenido que tienen los textFields (inputs) que se crean
// de Forma dinamica
// 


/**
 * 
 * @author migue
 */

// Tipo Generico que retorne el tipo de Dato que se Ingreso
// Date - String | Precio - Double | Entero - Int

// Tipos perteneces a enteros, se tendra que verificar el dato que envie con una consulta a la base de datos
// ya que se pueden agregar X numero de Tipos

public class parametrosDisponibles {
    ArrayList<String> allowedStrings = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
    
    HashMap<String,String> valoresField = new HashMap<>(){{
        put("BotonFecha_Inicial","Fecha");
        put("BotonFecha_Final","Fecha");
        put("Tipos","Entero");
        put("Precio","Double");
        put("Longitud","Entero");
        put("BotonExportar","Exportar");
    }}; 
    // REUTILICE ESTO DE FORMA DINAMICA
    // DEBE DE FORMAR PARTE DE la clase preguntaMasReservado.
    // tambien esta en ConsultasTransaccionalesDB estatico
    
    HashMap<String, String> notValidData = new HashMap<>(); 
    // Cargar un HashMap que pase el nombre del Field
    // cargar success cuando el dato si este validado y sea correcto
    
    HashMap<String, String> validData = new HashMap<>();
    // cargar HashMap con datos validados listos para el query
    
    public void validateDatos(String nameQuestion,ConsultasTransaccionalesDB consulta,HashMap<String,JComponent> activePanelContent, ArrayList<String> currentParams){
        
        int quantityOfParams = currentParams.size() -1;
        // Le resto 1 porque BotonExportar no se valida
        
        for(int x=0; x < quantityOfParams; x++ ){
            String nameField = currentParams.get(x);
            
            
            if( activePanelContent.containsKey("checkBox_"+nameField) ){
                
                JCheckBox checkActive = (JCheckBox) activePanelContent.get("checkBox_"+nameField);
                if(checkActive.isSelected()){
                    switch(valoresField.get(nameField)){
                        case "Fecha"->{
//                            updateAllowedStrings("Fecha");
                        }
                        case "Entero" ->{
                            updateAllowedStrings("Entero");
                        }
                    }
                }
                
                if(activePanelContent.containsKey("input_"+nameField)){
                    String storedValue = "";
                    
                    switch(valoresField.get(nameField)){
                        case "Fecha"->{
                            JDateChooser content = (JDateChooser) activePanelContent.get("input_"+nameField);
                            
                            Date date = content.getDate();
                            if(date != null){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(date);
                            
                            //Dandole el formato de MySQL
                                storedValue += cal.get(Calendar.YEAR);
                                storedValue += cal.get(Calendar.MONTH);
                                storedValue += cal.get(Calendar.DAY_OF_MONTH);
                            }
                        }
                        case "Entero"->{
                            JTextField content = (JTextField) activePanelContent.get("input_"+nameField);
                            
                            String textContent = content.getText();
                            
                            if(textContent.equals("")){
                                break;
                            }
                            
                            String cleanData = ""; //
                            
                            System.out.println("Dato entrante: "+textContent);
                            char[] arrChar = textContent.trim().toCharArray();

                            for(int numChar = 0; numChar<textContent.trim().length(); numChar++){
                                String charAsString = ""+ arrChar[numChar];

                                if(!this.allowedStrings.contains(charAsString)){
                                    // NO esta permitido uno de los caracteres, por lo que es erroneo
                                    System.out.println("INCORRECTO!");
                                    String message = "Lo enviado "+textContent+" cuenta con caracteres no permitidos ["+arrChar[numChar]+"";
                                    
                                    cleanData = "";
                                    storedValue = "error";
                                    break;
                                    
                                }

                                // Solo un punto
                                if(charAsString.equals(".")){
                                    allowedStrings.remove(".");
                                }

                                // Aqui hace que todas las , se consideren como inexistentes
                                if(charAsString.equals(",")){
                                    charAsString = "";
                                }

                                //Solo se permiten uno en input
                                if(charAsString.equals("$") && numChar == 0){
                                    allowedStrings.remove("$");
                                    charAsString = "";
                                }

                                cleanData += charAsString;
                            }
                            
                            if(!cleanData.equals("")){
                                storedValue = cleanData;
                            }

                        }
                    }
                
                // Validacion = null
                if(storedValue.equals("")){
                    notValidData.put(nameField,"No hay texto registrado");
                }else if(storedValue.equals("error")){
                    notValidData.put(nameField,"Solo se aceptan numeros Enteros");
                }else{
                    validData.put(nameField,storedValue);
                }
                
               }
            }
        }
        
        //Manda a llamar una funcion que se encarga de cargar los mensajes de error
        consulta.Verificado(nameQuestion,notValidData, validData);
        
    }
        public void updateAllowedStrings(String tipoDeDato){
        switch(tipoDeDato){
            case "fecha" -> {
                if(allowedStrings.contains("$")){
                    allowedStrings.remove("$");
                    allowedStrings.remove(",");
                    allowedStrings.remove(".");
                }
                
                if(!allowedStrings.contains("-")){
                    allowedStrings.add("-");
                }
            }
            case "precio" -> {
                if(!allowedStrings.contains("$")){
                    allowedStrings.add("$");
                    allowedStrings.add(",");
                    allowedStrings.add(".");
                }
                
                if(allowedStrings.contains("-")){
                    allowedStrings.remove("-");
                }
            }
            case "enteros" -> {
                if(allowedStrings.contains("-")){
                    allowedStrings.remove("-");
                    allowedStrings.remove("$");
                    allowedStrings.remove(",");
                    allowedStrings.remove(".");
                }
            }
        }
    }
}
    



// 
// Crear una funcion de validaciones
// Libreria de datos en preguntas que contenga el tipo de dato que tiene

// Hacer una condicion que reciba un String donde dice el tipo de dato
// Pasar un objeto que contenga el dato almacenado dentro del
// Input / ComboBox / etc
// Dentro de esta funcion condicion IF que reciba el tipo de Dato

 