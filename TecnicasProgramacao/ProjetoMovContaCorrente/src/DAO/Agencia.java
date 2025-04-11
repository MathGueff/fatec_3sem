/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Validator.UfValidator;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Agencia {
    private String num_agencia;
    private String nome;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
    private boolean validate = true;
    
    public Agencia(){
        //Construtor vazio para o objeto Agencia
    }

    public Agencia(String num_agencia, String nome, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep, String telefone, boolean validate) {
        this.num_agencia = num_agencia;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.validate = true;
    }

    public String getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(String num_agencia) {
        if(num_agencia == null || num_agencia.isBlank() || num_agencia.isEmpty() || num_agencia == "0")
        {
            ShowErrorValidateMessage("Digite o número da agência");
        }
        else{
            num_agencia = num_agencia.trim();
            this.num_agencia = num_agencia;
        }
    }
    
    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
    
    public void ShowErrorValidateMessage(String message){
        JOptionPane.showMessageDialog(null, message);
        setValidate(false);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isBlank() || nome.isEmpty())
        {
            ShowErrorValidateMessage("Digite o nome");
        }
        else{
            nome = nome.trim();
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco == null ||endereco.isBlank() || endereco.isEmpty())
        {
            ShowErrorValidateMessage("Digite o Endereço");
        }
        else{
            endereco = endereco.trim();
            this.endereco = endereco;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if(numero != null && !numero.isBlank() && !numero.isEmpty()){
            numero = numero.trim();
            this.numero = numero;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if(complemento != null && !complemento.isBlank() && !complemento.isEmpty()){
            complemento = complemento.trim();
            this.complemento = complemento;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if(bairro != null && !bairro.isBlank() && !bairro.isEmpty()){
            bairro = bairro.trim();
            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade == null || cidade.isBlank() || cidade.isEmpty())
            ShowErrorValidateMessage("Digite a cidade");
        else{
            cidade = cidade.trim();
            this.cidade = cidade;
        }
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        /*
            Validação do campo
        */
        if(uf == null || uf.isBlank() || uf.isEmpty())
        {
            ShowErrorValidateMessage("Escolha um Estado");
        }
        else{
            uf = uf.trim().toUpperCase();
            if(UfValidator.isUf(uf))
            {
                this.uf = uf;
            }
            else
            {
                ShowErrorValidateMessage("Escolha um Estado válido");
            }
        }
        
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if(cep == null || cep.isEmpty() || cep.isBlank()){
            ShowErrorValidateMessage("Digite o CEP");
        }
        else{
            cep = cep.trim();
            this.cep = cep;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        
        if(telefone == null || telefone.isBlank() || telefone.isEmpty())
            return;
        
        telefone = telefone.trim();
        if(telefone.length() == 11){
            this.telefone = telefone;
        }
        else{
            ShowErrorValidateMessage("Digite um telefone válido ");
        }
    }
    
    public String dadosSQLValues(){
        String dadosAgencia;
        dadosAgencia = 
            getSqlValue(this.getNome()) + "," +
            getSqlValue(this.getEndereco()) + "," +
            getSqlValue(this.getNumero()) + "," +
            getSqlValue(this.getComplemento()) + "," +
            getSqlValue(this.getBairro()) + "," +
            getSqlValue(this.getCidade()) + "," +
            getSqlValue(this.getUf()) + "," +
            getSqlValue(this.getCep()) + "," +
            getSqlValue(this.getTelefone());
        return dadosAgencia;        
    }
    
    public String alteraDadosSQLValues(){
    String dadosAgencias;
    dadosAgencias = 
        "NOME_AGE=" + getSqlValue(this.getNome()) + "," +
        "ENDE_AGE=" + getSqlValue(this.getEndereco()) + "," +
        "NUME_AGE=" +getSqlValue(this.getNumero()) + "," +
        "COMPL_AGE=" +getSqlValue(this.getComplemento()) + "," +
        "BAIR_AGE=" +getSqlValue(this.getBairro()) + "," +
        "CIDA_AGE=" +getSqlValue(this.getCidade()) + "," +
        "UF_AGE=" +getSqlValue(this.getUf()) + "," +
        "CEP_AGE=" +getSqlValue(this.getCep()) + "," +
        "FONE_AGE=" +getSqlValue(this.getTelefone()) + "";
        return dadosAgencias;
    }
    
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
