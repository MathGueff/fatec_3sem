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
public class Usuario {
    private String senha;
    private int id_usuario;
    private int num_agencia;
    private int num_cc;
    private boolean isValid = true;
    
    public Usuario(String senha,int id_usuario, int num_agencia, int num_cc){
        this.senha = senha;
        this.id_usuario = id_usuario;
        this.num_agencia = num_agencia;
        this.num_cc = num_cc;
        this.isValid = true;
    }
    
    public Usuario(){}
    
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha != null && senha.isBlank() || senha.isEmpty()){
            ShowErrorValidateMessage("Digite uma senha válida");
            return;
        }
        
        senha = senha.trim();
        if(senha.length() < 10){
            ShowErrorValidateMessage("A senha deve ter pelo menos 10 caracteres");
        }
        else{
            this.senha = senha;
        }
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        if(id_usuario <= 0){
            ShowErrorValidateMessage("O id do usuário é obrigatório e não pode ser menor ou igual a 0");
        }
        else{
            this.id_usuario = id_usuario;
        }
    }

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        if(num_agencia <= 0){
            ShowErrorValidateMessage("Digite um valor válido para o número da agência");
        }
        else{
            this.num_agencia = num_agencia;
        }   
    }
    
    public int getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(int num_cc) {
        if(num_cc <= 0){
            ShowErrorValidateMessage("Digite um número de conta corrente válida");
        }
        else{
            this.num_cc = num_cc;
        }
    }
    
    public String dadosSQLValues(){
        String dadosUsuario;
        dadosUsuario = 
            getSqlValue(getSenha()) + "," +
            getSqlValue(Integer.toString(getNum_agencia())) + "," +
            getSqlValue(Integer.toString(getNum_cc()));   
        return dadosUsuario;        
    }
    
     public String alteraDadosSQLValues(){
        String dadosUsuario;
        dadosUsuario = 
            "SENHA=" + getSqlValue(getSenha()) + "," +
            "NUM_AGE=" + getSqlValue(Integer.toString(getNum_agencia())) + "," +
            "NUM_CC=" + getSqlValue(Integer.toString(getNum_cc()));
            return dadosUsuario;
    }
    
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
