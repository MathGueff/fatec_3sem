/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uteis;

/**
 *
 * @author Alunos
 */

//Função para converter a data para o banco e para visualização do usuário
public class DateParser {
   public static String parseAMD(String date){
       return date.substring(4, 8) + date.substring(2, 4) + date.substring(0, 2);
   }
   //Do formato do banco para visualização no formulário
   public static String parseDMA(String date){
       return date.substring(8, 10) + date.substring(5, 7) + date.substring(0, 4);
   }
}
