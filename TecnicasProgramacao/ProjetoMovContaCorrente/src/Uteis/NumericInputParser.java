/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uteis;

/**
 *
 * @author Alunos
 */
public class NumericInputParser {
    
    public static int ParseInt(String inputValue){
        if(NumericInputParser.IsValueValid(inputValue)) return 0;
        
        return Integer.parseInt(inputValue);
    }
    
    public static double ParseDouble(String inputValue){
        if(NumericInputParser.IsValueValid(inputValue)) return 0;
        
        return Double.parseDouble(inputValue);
    }
    
    static boolean IsValueValid(String inputValue){
        return (inputValue == null || inputValue.isBlank() || inputValue.isEmpty());
    }
}
