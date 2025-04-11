package DAO; 

//import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.logging.Level;

// import javax.swing.table.AbstractTableModel;
 
/**

*

* @author Prof. Corredato - Controle de conexão com o banco de dados

*/

public class connectDAO {

    Connection con;

    public Connection connectDB(){

        //JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");
 
        /* NO NOTE DA FATEC */
        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=MOV_CONTA_CORRENTE;"
                + "encrypt=true;trustServerCertificate=true;"; 
        String usuario = "sa";
        String senha = ".";
        
        /* 
            Em casa
        
        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=MOV_CONTA_CORRENTE;"
                + "integratedSecurity=true;encrypt=true;trustServerCertificate=true;"; 

        String usuario = "";
        String senha = "";
        */
        
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
        }
        return con;
        // con.close();
    }
    
    public void insereRegistroJFBD(String tabela, String strDados){
        con = connectDB();
        Statement stmt;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO dbo." + tabela + " " + "VALUES (" + strDados + ")";
            JOptionPane.showMessageDialog(null, "String de insert: " + sql);
            
            try{
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso");
            } catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        } catch(SQLException ex){
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alteraRegistroJFDB(String tabela,String strDados, String pesquisaID){
        con = connectDB();
        Statement stmt;
        try{
            stmt = con.createStatement();
            String sql = "UPDATE dbo." + tabela +
                    " SET " + strDados +
                    " WHERE " + pesquisaID + ";";
                    
            JOptionPane.showMessageDialog(null, "String de Update: " + sql);
            
            try{
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Alteração executada com sucesso");
            } catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        } catch(SQLException ex){
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluiRegistroJFDB(String tabela, String pesquisaId){
        con = connectDB();
        Statement stmt;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM dbo." + tabela +
                    " WHERE " + pesquisaId + ";";
                    
            JOptionPane.showMessageDialog(null, "String de Delete: " + sql);
            
            try{
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso");
            } catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        } catch(SQLException ex){
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente pesquisaClienteJFDB(String tabela, String pesquisaId){
        Cliente clientesReturn = new Cliente();
        String tabelaSGBD = "CLIENTES";
        
        if(tabela.equals(tabelaSGBD)){
            con = connectDB();
            
            Statement stmt;
            
            try {
                stmt = con.createStatement();
                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;
                JOptionPane.showMessageDialog(null, "String de Select: " + sql);
                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if(dados.next() == false){
                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa");
                        return null;
                    }
                    else{
                        clientesReturn.setId_cli(dados.getInt(1));
                        clientesReturn.setNome(dados.getString(2));
                        clientesReturn.setEndereco(dados.getString(3));
                        clientesReturn.setNumero(dados.getString(4));
                        clientesReturn.setComplemento(dados.getString(5));
                        clientesReturn.setBairro(dados.getString(6));
                        clientesReturn.setCidade(dados.getString(7));
                        clientesReturn.setUf(dados.getString(8));
                        clientesReturn.setCep(dados.getString(9));
                        clientesReturn.setTelefone(dados.getString(10));
                        clientesReturn.setCpf(dados.getString(11));
                        clientesReturn.setDataNascimento(dados.getString(12));
                        clientesReturn.setCnpj(dados.getString(13));
                    }
                    con.close();
                    return clientesReturn;
                } catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
                con.close();
                return null;
            } catch(SQLException ex){
                Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientesReturn;
    }
    
    public Agencia pesquisaAgenciaJFDB(String tabela, String pesquisaId){
        Agencia agenciaReturn = new Agencia();
        String tabelaSGBD = "AGENCIAS";
        
        if(tabela.equals(tabelaSGBD)){
            con = connectDB();
            
            Statement stmt;
            
            try {
                stmt = con.createStatement();
                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;
                JOptionPane.showMessageDialog(null, "String de Select: " + sql);
                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if(dados.next() == false){
                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa");
                        return null;
                    }
                    else{
                        agenciaReturn.setNum_agencia(dados.getString(1));
                        agenciaReturn.setNome(dados.getString(2));
                        agenciaReturn.setEndereco(dados.getString(3));
                        agenciaReturn.setNumero(dados.getString(4));
                        agenciaReturn.setComplemento(dados.getString(5));
                        agenciaReturn.setBairro(dados.getString(6));
                        agenciaReturn.setCidade(dados.getString(7));
                        agenciaReturn.setUf(dados.getString(8));
                        agenciaReturn.setCep(dados.getString(9));
                        agenciaReturn.setTelefone(dados.getString(10));
                    }
                    con.close();
                    return agenciaReturn;
                } catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
                con.close();
                return null;
            } catch(SQLException ex){
                Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return agenciaReturn;
    }
}
 