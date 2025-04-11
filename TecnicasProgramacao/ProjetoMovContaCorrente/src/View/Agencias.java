/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DAO.Agencia;
import DAO.connectDAO;
import Uteis.DateParser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 *
 * @author Alunos
 */
public class Agencias extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public Agencias() {
        initComponents();
    }
    String operacaoAtivaGlobal = "Nenhum";
    
    
    Agencia dados_agencia = new Agencia();
    
    public Agencias(String operacaoAtiva){
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";
        //INCLUSÃO
        if(operacaoAtiva.equals(operacao)){
            SetFormVisible(true);
            jButton1.setText(operacaoAtivaGlobal);
        }
        operacao = "Alterar";
        if(operacaoAtiva.equals(operacao)){
            SetFormVisible(false);
            jButton1.setText("Pesquisar");
        }
        operacao = "Excluir";
        if(operacaoAtiva.equals(operacao)){
            SetFormVisible(false);
            jButton1.setText("Pesquisar");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTextField2 = new javax.swing.JTextField();
        JTextField3 = new javax.swing.JTextField();
        JTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_Ler = new javax.swing.JButton();
        JTextField5 = new javax.swing.JTextField();
        JTextField6 = new javax.swing.JTextField();
        JTextField7 = new javax.swing.JTextField();
        JTextField8 = new javax.swing.JTextField();
        btn_Limpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTextField11 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome da Agência");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Endereço da Agência");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, -1, -1));

        JTextField2.setBackground(new java.awt.Color(204, 204, 204));
        JTextField2.setForeground(new java.awt.Color(51, 51, 51));
        JTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(JTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 53, 171, -1));

        JTextField3.setBackground(new java.awt.Color(204, 204, 204));
        JTextField3.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(JTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 81, 171, -1));

        JTextField4.setBackground(new java.awt.Color(204, 204, 204));
        JTextField4.setForeground(new java.awt.Color(51, 51, 51));
        JTextField4.setToolTipText("");
        getContentPane().add(JTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 109, 171, -1));

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 348, -1, -1));

        btn_Ler.setText("Ler");
        btn_Ler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Ler, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 348, -1, -1));

        JTextField5.setBackground(new java.awt.Color(204, 204, 204));
        JTextField5.setForeground(new java.awt.Color(51, 51, 51));
        JTextField5.setToolTipText("");
        getContentPane().add(JTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 137, 171, -1));

        JTextField6.setBackground(new java.awt.Color(204, 204, 204));
        JTextField6.setForeground(new java.awt.Color(51, 51, 51));
        JTextField6.setToolTipText("");
        getContentPane().add(JTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 165, 171, -1));

        JTextField7.setBackground(new java.awt.Color(204, 204, 204));
        JTextField7.setForeground(new java.awt.Color(51, 51, 51));
        JTextField7.setToolTipText("");
        getContentPane().add(JTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 193, 171, -1));

        JTextField8.setBackground(new java.awt.Color(204, 204, 204));
        JTextField8.setForeground(new java.awt.Color(51, 51, 51));
        JTextField8.setToolTipText("");
        getContentPane().add(JTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 221, 171, -1));

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 348, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Número da Agência");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Complemento da Agência");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Bairro da Agência");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 168, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cidade da Agência");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 196, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CEP da Agência");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 224, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 249, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Estado da Agência");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 252, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id da Agência");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 28, -1, -1));

        JTextField1.setBackground(new java.awt.Color(204, 204, 204));
        JTextField1.setForeground(new java.awt.Color(51, 51, 51));
        JTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(JTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 25, 171, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Telefone da Agência");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        JTextField11.setBackground(new java.awt.Color(204, 204, 204));
        JTextField11.setForeground(new java.awt.Color(51, 51, 51));
        JTextField11.setToolTipText("");
        getContentPane().add(JTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 277, 171, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SetFormVisible(Boolean bool){
        jLabel1.setVisible(!bool);
        jLabel2.setVisible(bool);
        jLabel3.setVisible(bool);
        jLabel4.setVisible(bool);
        jLabel5.setVisible(bool);
        jLabel6.setVisible(bool);
        jLabel7.setVisible(bool);
        jLabel8.setVisible(bool);
        jLabel11.setVisible(bool);
        jLabel12.setVisible(bool);
        JTextField1.setVisible(!bool);
        JTextField2.setVisible(bool);
        JTextField3.setVisible(bool);
        JTextField4.setVisible(bool);
        JTextField5.setVisible(bool);
        JTextField6.setVisible(bool);
        JTextField7.setVisible(bool);
        JTextField8.setVisible(bool);
        JTextField11.setVisible(bool);
        jComboBox1.setVisible(bool);
    }
    
    private void ClearFormInputs(){
        JTextField1.setText("");
        JTextField2.setText("");
        JTextField3.setText("");
        JTextField4.setText("");
        JTextField5.setText("");
        JTextField6.setText("");
        JTextField7.setText("");
        JTextField8.setText("");
        JTextField11.setText("");
    }
    
    private void JTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Gravar os dados no objeto cliente c
        String operacao = "Incluir";
        if(operacaoAtivaGlobal.equals(operacao)){
            dados_agencia.setNome(JTextField2.getText());
            dados_agencia.setEndereco(JTextField3.getText());
            dados_agencia.setNumero(JTextField4.getText());
            dados_agencia.setComplemento(JTextField5.getText());
            dados_agencia.setBairro(JTextField6.getText());
            dados_agencia.setCidade(JTextField7.getText());
            dados_agencia.setCep(JTextField8.getText());
            dados_agencia.setUf(jComboBox1.getSelectedItem().toString());
            dados_agencia.setTelefone(JTextField11.getText());
            
            if(dados_agencia.isValidate()){
                //Inserção no banco de dados
                connectDAO objcon = new connectDAO();
                objcon.connectDB();
                objcon.insereRegistroJFBD("AGENCIAS", dados_agencia.dadosSQLValues());
                ClearFormInputs();
            }
            else{
                dados_agencia.ShowErrorValidateMessage("Campos preenchidos incorretamente");
                dados_agencia.setValidate(true);
            }
        }
        operacao = "Alteração";
        if(operacaoAtivaGlobal.equals((operacao))){
            connectDAO objcon = new connectDAO();
            /*Definindo os valores do objeto Agencia como os valores dos campos */
            dados_agencia.setNum_agencia(JTextField1.getText().isBlank() || JTextField1.getText().isEmpty() ? "0" : JTextField1.getText());
            dados_agencia.setNome(JTextField2.getText());
            dados_agencia.setEndereco(JTextField3.getText());
            dados_agencia.setNumero(JTextField4.getText());
            dados_agencia.setComplemento(JTextField5.getText());
            dados_agencia.setBairro(JTextField6.getText());
            dados_agencia.setCidade(JTextField7.getText());
            dados_agencia.setCep(JTextField8.getText());
            dados_agencia.setUf(jComboBox1.getSelectedItem().toString());
            dados_agencia.setTelefone(JTextField11.getText());

            //ALteração no banco de dados
            objcon.alteraRegistroJFDB("AGENCIAS", dados_agencia.alteraDadosSQLValues(), 
                "NUM_AGE=" +JTextField1.getText());

            //Limpando todos os textos
            ClearFormInputs();
            SetFormVisible(false);
            jButton1.setText("Pesquisar");
            operacaoAtivaGlobal = "Alterar";
            return;
        }
        
        operacao = "Alterar";
        if(operacaoAtivaGlobal.equals((operacao))){
            //Pesquisa o clinte com o ID especificado
            connectDAO objcon = new connectDAO();
            dados_agencia = objcon.pesquisaAgenciaJFDB("AGENCIAS", "NUM_AGE = '" + JTextField1.getText() + "'");
            
            if(dados_agencia != null){
                JTextField2.setText(dados_agencia.getNome());
                JTextField3.setText(dados_agencia.getEndereco());
                JTextField4.setText(dados_agencia.getNumero());
                JTextField5.setText(dados_agencia.getComplemento());
                JTextField6.setText(dados_agencia.getBairro());
                JTextField7.setText(dados_agencia.getCidade());
                JTextField8.setText(dados_agencia.getCep());
                JTextField11.setText(dados_agencia.getTelefone());
                jComboBox1.setSelectedItem(dados_agencia.getUf());

                //Mostrando os campos para que possam ser alterados

                jButton1.setText("Alterar");
                operacaoAtivaGlobal = "Alteração";
                SetFormVisible(true);
            }
            return;
        }
        
        operacao = "Exclusão";
        if(operacaoAtivaGlobal.equals((operacao))){
            connectDAO objcon = new connectDAO();
            objcon.excluiRegistroJFDB("AGENCIAS","NUM_AGE=" +JTextField1.getText());

            //Limpando todos os textos
            ClearFormInputs();
            SetFormVisible(false);
            JTextField1.setEditable(true);
            JTextField2.setEditable(true);
            JTextField3.setEditable(true);
            JTextField4.setEditable(true);
            JTextField5.setEditable(true);
            JTextField6.setEditable(true);
            JTextField7.setEditable(true);
            JTextField8.setEditable(true);
            JTextField11.setEditable(true);
            jComboBox1.setEnabled(true);
            jButton1.setText("Pesquisar");
            operacaoAtivaGlobal = "Excluir";
            return;
        }
        
        operacao = "Excluir";
        if(operacaoAtivaGlobal.equals((operacao))){
            //Pesquisa o cliente com o ID especificado
            connectDAO objcon = new connectDAO();
            dados_agencia = objcon.pesquisaAgenciaJFDB("AGENCIA", "NUM_AGE = '" + JTextField1.getText() + "'");
            
            if(dados_agencia != null){
                JTextField2.setText(dados_agencia.getNome());
                JTextField3.setText(dados_agencia.getEndereco());
                JTextField4.setText(dados_agencia.getNumero());
                JTextField5.setText(dados_agencia.getComplemento());
                JTextField6.setText(dados_agencia.getBairro());
                JTextField7.setText(dados_agencia.getCidade());
                JTextField8.setText(dados_agencia.getCep());
                JTextField11.setText(dados_agencia.getTelefone());
                jComboBox1.setSelectedItem(dados_agencia.getUf());

                //Mostrando os campos para que possam ser alterados
                jButton1.setText("Excluir");
                operacaoAtivaGlobal = "Exclusão";
                SetFormVisible(true);
                JTextField1.setEditable(false);
                JTextField2.setEditable(false);
                JTextField3.setEditable(false);
                JTextField4.setEditable(false);
                JTextField5.setEditable(false);
                JTextField6.setEditable(false);
                JTextField7.setEditable(false);
                JTextField8.setEditable(false);
                JTextField11.setEditable(false);
                jComboBox1.setEnabled(false);
            }
            return;
        }
        /*
        agencia_jframe.setNome(JTextField2.getText());
        agencia_jframe.setEndereco(JTextField3.getText());
        agencia_jframe.setNumero(JTextField4.getText());
        agencia_jframe.setComplemento(JTextField5.getText());
        agencia_jframe.setBairro(JTextField6.getText());
        agencia_jframe.setCidade(JTextField7.getText());
        agencia_jframe.setCep(JTextField8.getText());
        //agencia_jframe.setCnpj(JTextField9.getText());
        //agencia_jframe.setGerente(JTextField10.getText());
        agencia_jframe.setUf(jComboBox1.getSelectedItem().toString());
        agencia_jframe.setTelefone(JTextField11.getText());
        JOptionPane.showMessageDialog(null, "Cadastrado ");
         //Inserção no banco de dados
            connectDAO objcon = new connectDAO();
            objcon.connectDB();
            objcon.insereRegistroJFBD("AGENCIAS", agencia_jframe.dadosSQLValues());
            
            JTextField2.setText("");
            JTextField3.setText("");
            JTextField4.setText("");
            JTextField5.setText("");
            JTextField6.setText("");
            JTextField7.setText("");
            //JTextField9.setText("");
            JTextField8.setText("");
            //JTextField10.setText("");
            JTextField11.setText("");
            jComboBox1.setSelectedIndex(0); */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_LerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LerActionPerformed
//        JTextField2.setText(agencia_jframe.getNome()); 
//        JTextField3.setText(agencia_jframe.getEndereco()); 
//        JTextField4.setText(agencia_jframe.getNumero());
//        JTextField5.setText(agencia_jframe.getComplemento()); 
//        JTextField6.setText(agencia_jframe.getBairro()); 
//        JTextField7.setText(agencia_jframe.getCidade()); 
//        JTextField8.setText(agencia_jframe.getCep()); 
//        JTextField9.setText(agencia_jframe.getCnpj()); 
//        JTextField10.setText(agencia_jframe.getGerente()); 
//        jComboBox1.setSelectedItem(agencia_jframe.getUf());
    }//GEN-LAST:event_btn_LerActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
//       JTextField2.setText(""); 
//        JTextField3.setText(""); 
//        JTextField4.setText("");
//        JTextField5.setText(""); 
//        JTextField6.setText(""); 
//        JTextField7.setText(""); 
//        JTextField8.setText(""); 
//        JTextField9.setText(""); 
//        JTextField10.setText(""); 
//        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void JTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Agencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField1;
    private javax.swing.JTextField JTextField11;
    private javax.swing.JTextField JTextField2;
    private javax.swing.JTextField JTextField3;
    private javax.swing.JTextField JTextField4;
    private javax.swing.JTextField JTextField5;
    private javax.swing.JTextField JTextField6;
    private javax.swing.JTextField JTextField7;
    private javax.swing.JTextField JTextField8;
    private javax.swing.JButton btn_Ler;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
