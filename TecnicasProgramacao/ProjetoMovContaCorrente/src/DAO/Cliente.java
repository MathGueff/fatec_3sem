/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Uteis.DateParser;
import Validator.CpfCnpjValidator;
import Validator.UfValidator;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Cliente {
    
    private int id_cli;
    private String nome;
    private String cpf;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private boolean status;
    private String telefone;
    private String cnpj;
    private String complemento;
    private String DataNascimento;
    private boolean validate;
    
    public Cliente(){
        this.status = true;
        this.validate = true;
        //Construtor vazio para criação livre
    }
    
    public Cliente(int id_cli, String nome, String cpf, String endereco, String numero, String bairro, String cidade, String uf, String cep, String telefone, String cnpj, String dataNascimento, String complemento) {
        this.id_cli = id_cli;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.status = true;
        this.validate = true;
        this.DataNascimento = dataNascimento;
        this.complemento = complemento;
    }
    
    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        if(isStatus()){
            if(id_cli <= 0){
                JOptionPane.showMessageDialog(null, "Digite um ID válido");
            }
            else
            {
                this.id_cli = id_cli;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Para definir um ID a conta deve estar aberta");
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
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if(isStatus()){
            /*
                Validação do campo
            */
            if(complemento != null && !complemento.isBlank() && !complemento.isEmpty())
            {
                complemento = complemento.trim();
                this.complemento = complemento;
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o complemento a conta deve estar aberta");
        }
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        if(isStatus()){
           if(validateDate(DataNascimento)){
                DataNascimento = DataNascimento.trim();
                this.DataNascimento = DataNascimento;
            }
        }
        else{
            ShowErrorValidateMessage("Para definir o nome a conta deve estar aberta");
        }
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        if(isStatus()){
            /*
                Validação do campo
            */
            if(nome != null && !nome.isBlank() && !nome.isEmpty())
            {
                nome = nome.trim();
                this.nome = nome;
            }
            else
            { 
                ShowErrorValidateMessage("Digite seu nome");
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o nome a conta deve estar aberta");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(isStatus()){
            /*
                Validação do campo
            */
            if(endereco != null && !endereco.isBlank() && !endereco.isEmpty()){
                endereco = endereco.trim();
                this.endereco = endereco;
            }
            else{
                ShowErrorValidateMessage("Endereço não pode ser vazio");
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o endereco a conta deve estar aberta");
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        
        if(isStatus()){
            /*
                Validação do campo
            */
            if(numero != null && !numero.isBlank() && !numero.isEmpty())
            {
                numero = numero.trim();
                this.numero = numero;
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o número a conta deve estar aberta");
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if(isStatus()){
            /*
                Validação do campo
            */
            if(bairro != null && !bairro.isBlank() && !bairro.isEmpty())
            {
                bairro = bairro.trim();
                this.bairro = bairro;
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o bairro a conta deve estar aberta");
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(isStatus()){
            if(cidade != null && !cidade.isBlank() && !cidade.isEmpty()){
                cidade = cidade.trim();
                this.cidade = cidade;
            }
            else{
                ShowErrorValidateMessage("Digite sua cidade");
            }
        }
        else{
            ShowErrorValidateMessage("Para definir a cidade a conta deve estar aberta");
        }
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        if(isStatus()){
            /*
                Validação do campo
            */
            if(uf != null  && !uf.isBlank() && !uf.isEmpty()){
                uf = uf.trim();
                uf = uf.toUpperCase();
                if(UfValidator.isUf(uf))
                {
                    this.uf = uf;
                }
                else{
                    ShowErrorValidateMessage("Estado inválido");
                }    
            }
            else{
                ShowErrorValidateMessage("Escolha um Estado");
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir o Estado, a conta deve estar aberta");
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        
        if(isStatus()){
            if(cep != null && !cep.isBlank() && !cep.isEmpty()){
                if(cep.length() ==  8){
                    cep = cep.trim();
                    this.cep = cep;
                }
                else{
                    ShowErrorValidateMessage("CEP inválido");
                }  
            }
            else{
                ShowErrorValidateMessage("Digite seu CEP");
            }
        }
        else{
            ShowErrorValidateMessage("Para definir o CEP, a conta deve estar aberta");
        }
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
       
        if(isStatus()){
            /*
                Validação do campo
            */
            if(telefone != null && !telefone.isBlank() && !telefone.isEmpty())
            {
                if(telefone.length() != 11)
                {
                    ShowErrorValidateMessage("Tamanho de telefone inválido");
                }
                else{ 
                    telefone = telefone.trim();
                    this.telefone = telefone;
                }
            }
            /*
                Fim da validação do campo
            */
        }
        else{
            ShowErrorValidateMessage("Para definir telefone a conta deve estar aberta");
        }
    }
    
      public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(isStatus()){
            if(cpf != null && !cpf.isBlank() && !cpf.isEmpty()){
                cpf = cpf.trim();   
               if(CpfCnpjValidator.isCPF(cpf)){
                    this.cpf = cpf;
                }
                else{
                    ShowErrorValidateMessage("Digite um CPF válido");
                } 
            }
        }
        else{
            ShowErrorValidateMessage("Para definir o CPF a conta deve estar aberta");
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if(isStatus()){
            if(cnpj != null &&!cnpj.isBlank() && !cnpj.isEmpty()){
                cnpj = cnpj.trim();
               if(CpfCnpjValidator.isCNPJ(cnpj)){
                    this.cnpj = cnpj;
                }
                else{
                    ShowErrorValidateMessage("Digite um CNPJ válido");
                } 
            }
        }
        else{
            ShowErrorValidateMessage("Para definir o CNPJ a conta deve estar aberta");
        }
    }
    
    public String dadosSQLValues(){
    String dadosClientes;
    dadosClientes = 
        getSqlValue(this.getNome()) + "," +
        getSqlValue(this.getEndereco()) + "," +
        getSqlValue(this.getNumero()) + "," +
        getSqlValue(this.getComplemento()) + "," +
        getSqlValue(this.getBairro()) + "," +
        getSqlValue(this.getCidade()) + "," +
        getSqlValue(this.getUf()) + "," +
        getSqlValue(this.getCep()) + "," +
        getSqlValue(this.getTelefone()) + "," +
        getSqlValue(this.getCpf()) + "," +
        getSqlValue(this.getDataNascimento()) + "," +
        getSqlValue(this.getCnpj());
        return dadosClientes;
    }
    
    public String alteraDadosSQLValues(){
    String dadosClientes;
    dadosClientes = 
        "NOME_CLI=" + getSqlValue(this.getNome()) + "," +
        "ENDE_CLI=" + getSqlValue(this.getEndereco()) + "," +
        "NUME_CLI=" +getSqlValue(this.getNumero()) + "," +
        "COMPL_CLI=" +getSqlValue(this.getComplemento()) + "," +
        "BAIR_CLI=" +getSqlValue(this.getBairro()) + "," +
        "CIDA_CLI=" +getSqlValue(this.getCidade()) + "," +
        "UF_CLI=" + getSqlValue(this.getUf()) + "," +
        "CEP_CLI=" + getSqlValue(this.getCep()) + "," +
        "FONE_CLI=" + getSqlValue(this.getTelefone()) + "," +
        "CPF_CLI=" +  getSqlValue(this.getCpf()) + "," +
        "DATA_NASC=" + getSqlValue(this.getDataNascimento()) + "," +
        "CNPJ_CLI=" + getSqlValue(this.getCnpj());
        return dadosClientes;
    }
    
    // Função auxiliar para verificar se o valor é nulo ou vazio
    private String getSqlValue(String value) {
        String campo = (value == null || value.isEmpty()) ? "NULL" : "'" + value + "'";
        return campo;
    }
}
