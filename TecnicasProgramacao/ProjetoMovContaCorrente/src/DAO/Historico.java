/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Historico {
    private int id_his;
    private String historico;
    private boolean isValid = true;
    
    public Historico(int id_his, String historico){
        this.id_his = id_his;
        this.historico = historico;
        this.isValid = true;
    }
        
    public Historico(){}

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public int getId_his() {
        return id_his;
    }

    public void setId_his(int id_his) {
        try{
            if(id_his == 0){
                JOptionPane.showMessageDialog(null, "Digite um número de histórico");
            }
            else{
                this.id_his = id_his;
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite um número válido");
        }
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        historico = historico.trim();
        if(historico.isBlank() || historico.isEmpty() || historico == null){
            ShowErrorValidateMessage("Digite o histórico");
        }
        else{
            this.historico = historico;
        }
    }
    
    public void ShowErrorValidateMessage(String message){
        JOptionPane.showMessageDialog(null, message);
        setIsValid(false);
    }
    
    public String dadosSQLValues(){
        String dadosHistorico;
        dadosHistorico = 
            getSqlValue(getHistorico());
        return dadosHistorico;
    }
    
    public String alteraDadosSQLValues(){
    String dadosHistoricos;
    dadosHistoricos = 
        "DES_HIS=" + getSqlValue(getHistorico());
        return dadosHistoricos;
    }
    
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
