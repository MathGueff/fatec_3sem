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
public class ContaCorrente{
    private String num_conta;
    private String num_agencia;
    private int id_cli;
    private double saldo;
    private boolean isValid = true;
    
    public ContaCorrente(String num_conta, String num_agencia, int id_cli, double saldo, boolean isValid){
        this.num_conta = num_conta;
        this.num_agencia = num_agencia;
        this.id_cli = id_cli;
        this.saldo = saldo;
        this.isValid = isValid;
    }
    
    //Construtor vazio
    public ContaCorrente(){}

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public void ShowErrorValidateMessage(String message){
        JOptionPane.showMessageDialog(null, message);
        setIsValid(false);
    }
    
    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        if(num_conta == null || num_conta.isBlank() || num_conta.isEmpty()){
            ShowErrorValidateMessage("Digite o número da conta");
            return;
        }
        else{
            num_conta = num_conta.trim();
            if(num_conta.length() > 10) {
                ShowErrorValidateMessage("Número da conta deve ter até 10 caracteres");
                return;
            }
            this.num_conta = num_conta;
        }
    }

    public String getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(String num_agencia) {
        if(num_agencia == null || num_agencia.isBlank() || num_agencia.isEmpty()){
            ShowErrorValidateMessage("Digite o número da agência");
            return;
        }
        else{
            num_agencia = num_agencia.trim();
            if(num_agencia.length() > 5) {
                ShowErrorValidateMessage("Número da agencia deve ter até 5 caracteres");
                return;
            }
            this.num_agencia = num_agencia;
        }
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        try{
            if(id_cli == 0){
                ShowErrorValidateMessage("Digite um ID válido");
            }
            else{
                if(Integer.toString(id_cli).length() > 5) {
                    ShowErrorValidateMessage("Número do cliente deve ter até 5 caracteres");
                    return;
                }
                this.id_cli = id_cli;
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite um número válido");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        try{
            if(saldo < 0 || saldo == 0){
                JOptionPane.showMessageDialog(null, "Digite um saldo válido");
            }
            else{
                this.saldo = saldo;
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite um saldo válido");
        }
    }
    
    public String dadosSQLValues(){
        String dadosContaCorrente;
        dadosContaCorrente = 
            getSqlValue(this.getNum_agencia()) + "," +
            getSqlValue(Integer.toString(getId_cli())) + "," +
            getSqlValue(Double.toString(getSaldo()));
        return dadosContaCorrente;        
    }
    
    public String alteraDadosSQLValues(){
    String dadosAgencias;
    dadosAgencias = 
        "NUM_AGE=" + getSqlValue(this.getNum_agencia()) + "," +
        "ID_CLI=" +getSqlValue(Integer.toString(this.getId_cli())) + "," +
        "SALDO=" +getSqlValue(Double.toString(this.getSaldo()));
        return dadosAgencias;
    }
    
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
