/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DAO.Cliente;
import DAO.connectDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author Alunos
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
    }
    String operacaoAtivaGlobal = "Nenhum";
    public Clientes(String operacaoAtiva){
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";
        
        if(operacaoAtiva.equals(operacao)){
            jLabel1.setVisible(false);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            //jLabel11.setVisible(true);
            jLabel12.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            JTextField1.setVisible(false);
            JTextField2.setVisible(true);
            JTextField3.setVisible(true);
            JTextField4.setVisible(true);
            JTextField5.setVisible(true);
            JTextField6.setVisible(true);
            JTextField7.setVisible(true);
            JTextField8.setVisible(true);
            JTextField9.setVisible(true);
            JTextField10.setVisible(true);
            JTextField11.setVisible(true);
            JTextField12.setVisible(true);
            JComboBox.setVisible(true);
            //JRadioButton1.setVisible(true);
            //JRadioButton2.setVisible(true);
            jButton1.setText(operacaoAtivaGlobal);
        }
        operacao = "Alterar";
        if(operacaoAtiva.equals(operacao)){
            jLabel1.setVisible(true);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            //jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            JTextField1.setVisible(true);
            JTextField2.setVisible(false);
            JTextField3.setVisible(false);
            JTextField4.setVisible(false);
            JTextField5.setVisible(false);
            JTextField6.setVisible(false);
            JTextField7.setVisible(false);
            JTextField8.setVisible(false);
            JTextField9.setVisible(false);
            JTextField10.setVisible(false);
            JTextField11.setVisible(false);
            JTextField12.setVisible(false);
            JComboBox.setVisible(false);
            //JRadioButton1.setVisible(false);
            //JRadioButton2.setVisible(false);
            jButton1.setText("Pesquisar");;
        }
    }
    
    Cliente dados_cliente = new Cliente();
    String identificacao = "";
    
    char sexoSelecionado = ' ';
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextField2 = new javax.swing.JTextField();
        JTextField3 = new javax.swing.JTextField();
        JTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JTextField5 = new javax.swing.JTextField();
        JTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTextField10 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        JComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JTextField1 = new javax.swing.JTextField();
        JTextField11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JTextField12 = new javax.swing.JTextField();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 54, 117, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Endereço do Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 82, 117, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Número");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 117, -1));

        JTextField2.setBackground(new java.awt.Color(204, 204, 204));
        JTextField2.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(JTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 51, 192, -1));

        JTextField3.setBackground(new java.awt.Color(204, 204, 204));
        JTextField3.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(JTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 79, 192, -1));

        JTextField4.setBackground(new java.awt.Color(204, 204, 204));
        JTextField4.setForeground(new java.awt.Color(51, 51, 51));
        JTextField4.setToolTipText("");
        getContentPane().add(JTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 107, 90, -1));

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 314, -1, -1));

        jButton3.setText("Ler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 314, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Bairro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 138, 117, -1));

        JTextField5.setBackground(new java.awt.Color(204, 204, 204));
        JTextField5.setForeground(new java.awt.Color(51, 51, 51));
        JTextField5.setToolTipText("");
        getContentPane().add(JTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 135, 192, -1));

        JTextField6.setBackground(new java.awt.Color(204, 204, 204));
        JTextField6.setForeground(new java.awt.Color(51, 51, 51));
        JTextField6.setToolTipText("");
        getContentPane().add(JTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 163, 192, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cidade");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 166, 117, -1));

        JTextField7.setBackground(new java.awt.Color(204, 204, 204));
        JTextField7.setForeground(new java.awt.Color(51, 51, 51));
        JTextField7.setToolTipText("");
        getContentPane().add(JTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 191, 125, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CEP");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 194, 117, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 244, 117, -1));

        JTextField8.setBackground(new java.awt.Color(204, 204, 204));
        JTextField8.setForeground(new java.awt.Color(51, 51, 51));
        JTextField8.setToolTipText("");
        getContentPane().add(JTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 241, 171, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Telefone");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 272, 117, -1));

        JTextField9.setBackground(new java.awt.Color(204, 204, 204));
        JTextField9.setForeground(new java.awt.Color(51, 51, 51));
        JTextField9.setToolTipText("");
        getContentPane().add(JTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 269, 134, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CPF/CNPJ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 275, 117, -1));

        JTextField10.setBackground(new java.awt.Color(204, 204, 204));
        JTextField10.setForeground(new java.awt.Color(51, 51, 51));
        JTextField10.setToolTipText("");
        getContentPane().add(JTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 272, 171, -1));

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 314, -1, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Estado do Cliente");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 216, -1, -1));

        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 213, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id do Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 117, -1));

        JTextField1.setBackground(new java.awt.Color(204, 204, 204));
        JTextField1.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(JTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 17, 90, -1));

        JTextField11.setBackground(new java.awt.Color(204, 204, 204));
        JTextField11.setForeground(new java.awt.Color(51, 51, 51));
        JTextField11.setToolTipText("");
        getContentPane().add(JTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 213, 171, -1));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Complemento");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 216, 117, -1));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Data de Nascimento");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 247, 117, -1));

        JTextField12.setBackground(new java.awt.Color(204, 204, 204));
        JTextField12.setForeground(new java.awt.Color(51, 51, 51));
        JTextField12.setToolTipText("");
        getContentPane().add(JTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 244, 171, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Gravar os dados no objeto cliente c
        String operacao = "Incluir";
        if(operacaoAtivaGlobal.equals(operacao)){
            //c.setId_cli(JTextField1.getText().isBlank() || JTextField1.getText().isEmpty() ? 0 : Integer.parseInt(JTextField1.getText()));
            dados_cliente.setNome(JTextField2.getText());
            dados_cliente.setEndereco(JTextField3.getText());
            dados_cliente.setNumero(JTextField4.getText());
            dados_cliente.setBairro(JTextField5.getText());
            dados_cliente.setCidade(JTextField6.getText());
            dados_cliente.setCep(JTextField7.getText());
            dados_cliente.setEmail(JTextField8.getText());
            dados_cliente.setTelefone(JTextField9.getText());
            dados_cliente.setComplemento(JTextField11.getText());
            dados_cliente.setDataNascimento(JTextField12.getText());
            
            switch (JTextField10.getText().length()) {
                case 11:
                    //CPF
                    dados_cliente.setCpf(JTextField10.getText());
                    identificacao = "cpf";
                    break;
                case 14:
                    //CNPJ
                    dados_cliente.setCnpj(JTextField10.getText());
                    identificacao = "cnpj";
                    break;
            }
            if(JComboBox.getSelectedItem().toString() != "ESTADO"){
                dados_cliente.setUf(JComboBox.getSelectedItem().toString());
            }
            JOptionPane.showMessageDialog(null, "Cadastrado");
            
            //Inserção no banco de dados
            connectDAO objcon = new connectDAO();
            objcon.connectDB();
            objcon.insereRegistroJFBD("CLIENTES", dados_cliente.dadosSQLValues());
            
            JTextField2.setText("");
            JTextField3.setText("");
            JTextField4.setText("");
            JTextField5.setText("");
            JTextField6.setText("");
            JTextField7.setText("");
            JTextField9.setText("");
            JTextField8.setText("");
            JTextField10.setText("");
            JTextField11.setText("");
            JTextField12.setText("");
            JComboBox.setSelectedIndex(0);
        }
        
        operacao = "Alteração";
        if(operacaoAtivaGlobal.equals((operacao))){
            connectDAO objcon = new connectDAO();
            dados_cliente.setId_cli(JTextField1.getText().isBlank() || JTextField1.getText().isEmpty() ? 0 : Integer.parseInt(JTextField1.getText()));
            dados_cliente.setNome(JTextField2.getText());
            dados_cliente.setEndereco(JTextField3.getText());
            dados_cliente.setNumero(JTextField4.getText());
            dados_cliente.setBairro(JTextField5.getText());
            dados_cliente.setCidade(JTextField6.getText());
            dados_cliente.setCep(JTextField7.getText());
            dados_cliente.setEmail(JTextField8.getText());
            dados_cliente.setTelefone(JTextField9.getText());
            dados_cliente.setComplemento(JTextField11.getText());
            dados_cliente.setDataNascimento(JTextField12.getText());
            
            //objcon.alteraRegistroJFDB("CLIENTES", dados_cliente.alteraDadosSQLValues(), "ID_CLI=" +JTextField1.getText());
            
            JTextField2.setText("");
            JTextField3.setText("");
            JTextField4.setText("");
            JTextField5.setText("");
            JTextField6.setText("");
            JTextField7.setText("");
            JTextField9.setText("");
            JTextField8.setText("");
            JTextField10.setText("");
            JTextField11.setText("");
            JTextField12.setText("");
            JComboBox.setSelectedIndex(0);
        }
        
        operacao = "Alterar";
        if(operacaoAtivaGlobal.equals((operacao))){
            connectDAO objcon = new connectDAO();
            //dados_cliente = objcon.pesquisaClienteJFBD("CLIENTES", "Cod_Cliente = " + JTextField1.getText() + "'");
            
            JTextField2.setText(dados_cliente.getNome());
            JTextField3.setText(dados_cliente.getEndereco());
            JTextField4.setText(dados_cliente.getNumero());
            JTextField5.setText(dados_cliente.getBairro());
            JTextField6.setText(dados_cliente.getCidade());
            JTextField7.setText(dados_cliente.getCep());
            JTextField11.setText(dados_cliente.getComplemento());
            JTextField8.setText(dados_cliente.getEmail());
            JTextField9.setText(dados_cliente.getCpf());
            if(dados_cliente.getCpf() != null){
                JTextField10.setText(dados_cliente.getCpf());
            }
            else if(dados_cliente.getCnpj() != null){
                JTextField10.setText(dados_cliente.getCnpj());
            }
            JTextField12.setText(dados_cliente.getDataNascimento());
            JComboBox.setSelectedItem(dados_cliente.getUf());
            
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel12.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            JTextField1.setVisible(true);
            JTextField2.setVisible(true);
            JTextField3.setVisible(true);
            JTextField4.setVisible(true);
            JTextField5.setVisible(true);
            JTextField6.setVisible(true);
            JTextField7.setVisible(true);
            JTextField8.setVisible(true);
            JTextField9.setVisible(true);
            JTextField10.setVisible(true);
            JTextField11.setVisible(true);
            JTextField12.setVisible(true);
            JComboBox.setVisible(true);
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox;
    private javax.swing.JTextField JTextField1;
    private javax.swing.JTextField JTextField10;
    private javax.swing.JTextField JTextField11;
    private javax.swing.JTextField JTextField12;
    private javax.swing.JTextField JTextField2;
    private javax.swing.JTextField JTextField3;
    private javax.swing.JTextField JTextField4;
    private javax.swing.JTextField JTextField5;
    private javax.swing.JTextField JTextField6;
    private javax.swing.JTextField JTextField7;
    private javax.swing.JTextField JTextField8;
    private javax.swing.JTextField JTextField9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
