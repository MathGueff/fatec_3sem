/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Uteis.DateParser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Movimentacao {
    private String num_conta;
    private String num_age;
    private String documento;
    private String data_mov;
    private String tipoCartao;
    private int id_his;
    private String compl_hist;
    private double valor;
    private double saldo;
    private boolean isValid = true;

    public Movimentacao(String num_conta, String num_age, String documento, String data_mov, String tipoCartao, int id_his, String compl_hist, double valor, double saldo) {
        this.num_conta = num_conta;
        this.num_age = num_age;
        this.documento = documento;
        this.data_mov = data_mov;
        this.tipoCartao = tipoCartao;
        this.id_his = id_his;
        this.compl_hist = compl_hist;
        this.valor = valor;
        this.saldo = saldo;
        this.isValid = true;
    }
    
    public Movimentacao(){}

    public void ShowErrorValidateMessage(String message){
        JOptionPane.showMessageDialog(null, message);
        setIsValid(false);
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        num_conta = num_conta.trim();
        if(num_conta == null || num_conta.isBlank() || num_conta.isEmpty()){
            ShowErrorValidateMessage("O número da conta é obrigatório");
        }
        else{
            this.num_conta = num_conta;
        }
    }

    public String getNum_age() {
        return num_age;
    }

    public void setNum_age(String num_age) {
        num_age = num_age.trim();
        if(num_age == null || num_age.isBlank() || num_age.isEmpty()){
            ShowErrorValidateMessage("O número da Agência é obrigatório");
        }
        else{
            this.num_age = num_age;
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        documento = documento.trim();
        if(documento == null || documento.isBlank() || documento.isEmpty()){
            ShowErrorValidateMessage("O número do documento é obrigatório");
        }
        else{
            if(documento.length() <= 6){  
                this.documento = documento;
            }
            else{
                ShowErrorValidateMessage("Tamanho do documento inválido");
            }
        }
    }

    public String getData_mov() {
        return data_mov;
    }

    public void setData_mov(String data_mov) {
        if(data_mov == null){
           ShowErrorValidateMessage("A data é obrigatória");
        }
        data_mov = data_mov.trim();
        
        if(validateDate(data_mov))
            this.data_mov = data_mov;
        else
            ShowErrorValidateMessage("Data inserida é inválida");
    }
    
    public boolean validateDate(String date){
        if(date.length() > 8){
            date = DateParser.parseDMA(date);
        }
        return (date != null 
            && !date.isBlank() 
            && !date.isEmpty()
            && date.length() == 8);
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        if(tipoCartao == null || tipoCartao.isBlank() || tipoCartao.isEmpty() ){
            ShowErrorValidateMessage("Escolha uma opção válida para o cartão");
            return;
        }
        tipoCartao = tipoCartao.trim();
        if(tipoCartao.equalsIgnoreCase("c") || tipoCartao.equalsIgnoreCase("d"))
            this.tipoCartao = tipoCartao;
        else
            ShowErrorValidateMessage("Escolha entre credito ou débito");
    }

    public int getId_his() {
        return id_his;
    }

    public void setId_his(int id_his) {
        if(id_his == 0){
            ShowErrorValidateMessage("Digite o número do histórico");
        }
        else{
            this.id_his = id_his;
        }
    }

    public String getCompl_hist() {
        return compl_hist;
    }

    public void setCompl_hist(String compl_hist) {
        if(compl_hist != null && !compl_hist.isBlank() && !compl_hist.isEmpty()){
            compl_hist = compl_hist.trim();
            if(compl_hist.length() > 30){
                ShowErrorValidateMessage("O complemento deve ser menor que 30 caracteres");
                return;
            }
            this.compl_hist = compl_hist;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor == 0 || valor < 0){
            ShowErrorValidateMessage("Digite um valor válido");
        }
        else{
            if(Double.toString(valor).length() > 15){
                ShowErrorValidateMessage("O valor do saldo deve ser abaixo de 15 caracteres");
                return;
            }
            this.valor = valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo == 0 || saldo < 0){
            ShowErrorValidateMessage("Digite um saldo válido");
        }
        else{
            if(Double.toString(saldo).length() > 9){
                ShowErrorValidateMessage("O valor do saldo deve ser abaixo de 9 caracteres");
                return;
            }
            this.saldo = saldo;
        }
    }
    
     public String dadosSQLValues(){
        String dadosMovimentacao;
        dadosMovimentacao = 
            getSqlValue(getNum_age()) + "," +
            getSqlValue(getNum_conta()) + "," + //Num conta
            getSqlValue(getData_mov()) + "," + //Data
            getSqlValue(getDocumento())+ "," + //Num doc
            getSqlValue(getTipoCartao()) + "," + //Debito_credito
            getSqlValue(Integer.toString(getId_his())) + "," + //id_his
            getSqlValue(getCompl_hist()) + "," + //compl
            getSqlValue(Double.toString(getValor())) + "," + //valor
            getSqlValue(Double.toString(getSaldo())); //saldo
        return dadosMovimentacao;
    }
     
    public String alteraDadosSQLValues(){
        String dadosMovimentacao;
        dadosMovimentacao = 
            "NUM_AGE=" + getSqlValue(getNum_age()) + "," +
            "NUM_CC=" + getSqlValue(getNum_conta()) + "," +
            "DATA_MOV=" + getSqlValue(getData_mov()) + "," +
            "NUM_DOCTO=" + getSqlValue(getDocumento()) + "," +
            "DEBITO_CREDITO=" + getSqlValue(getTipoCartao()) + "," +
            "ID_HIS=" + getSqlValue(Integer.toString(getId_his())) + "," +
            "COMPL_HIS=" + getSqlValue(getCompl_hist()) + "," +
            "VALOR=" + getSqlValue(Double.toString(getValor())) + "," +
            "SALDO=" + getSqlValue(Double.toString(getSaldo()));
            return dadosMovimentacao;
    }
     
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
