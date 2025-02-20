package DAO; 
 
//import java.util.List;

//import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.logging.Level;

//import java.sql.ResultSet;

//import java.util.ArrayList;

// import javax.swing.table.AbstractTableModel;
 
/**

*

* @author Prof. Corredato - Controle de conexão com o banco de dados

*/

public class connectDAO {

    Connection con;

    public Connection connectDB(){

        //JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");
 
        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=MOV_CONTA_CORRENTE;"
                + "encrypt=true;trustServerCertificate=true;"; 
        String usuario = "sa";
        String senha = ".";

        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
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
}
 