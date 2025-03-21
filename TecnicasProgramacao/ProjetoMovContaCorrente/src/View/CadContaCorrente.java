/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DAO.ContaCorrente;
import DAO.connectDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author Alunos
 */
public class CadContaCorrente extends javax.swing.JFrame {

    /**
     * Creates new form CadContaCorrente
     */
    public CadContaCorrente() {
        initComponents();
    }
    
    String operacaoAtivaGlobal = "Nenhum";
    
    public CadContaCorrente(String operacaoAtiva){
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";
        
        if(operacaoAtiva.equals(operacao)){
            jLabel1.setVisible(false);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jTextField1.setVisible(false);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jButton1.setText(operacaoAtivaGlobal);
        }
        operacao = "Alterar";
        if(operacaoAtiva.equals(operacao)){
            jLabel1.setVisible(true);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jTextField1.setVisible(true);
            jTextField2.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jButton1.setText(operacaoAtivaGlobal);;
        }
    }
    
    ContaCorrente cc = new ContaCorrente();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        btn_Ler = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 271, -1, -1));

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 271, -1, -1));

        btn_Ler.setText("Ler");
        btn_Ler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Ler, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 271, -1, -1));

        jLabel1.setText("Número da Conta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 75, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 72, 71, -1));

        jLabel2.setText("Número da Agência");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 103, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 100, 88, -1));

        jLabel3.setText("ID do cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 131, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 128, 71, -1));

        jLabel4.setText("Saldo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 159, -1, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 156, 71, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //cc.setNum_conta(jTextField1.getText());
        cc.setNum_agencia(jTextField2.getText());
        cc.setId_cli(jTextField3.getText().isEmpty() || jTextField3.getText().isBlank()? 0 : Integer.parseInt(jTextField3.getText().trim()));
        cc.setSaldo(jTextField4.getText().isEmpty() || jTextField4.getText().isBlank() ? 0 : Double.parseDouble(jTextField4.getText().trim()));
        JOptionPane.showMessageDialog(null, "Cadastrado ");
        
        connectDAO objcon = new connectDAO();
        objcon.connectDB();
        objcon.insereRegistroJFBD("CONTACORRENTE", cc.dadosSQLValues());

        //jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
//        jTextField1.setText("");
//        jTextField2.setText("");
//        jTextField3.setText("");
//        jTextField4.setText("");
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void btn_LerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LerActionPerformed
//        jTextField1.setText(cc.getNum_conta());
//        jTextField2.setText(cc.getNum_agencia());
//        jTextField3.setText(Integer.toString(cc.getId_cli()));
//        jTextField4.setText(Double.toString(cc.getSaldo()));
    }//GEN-LAST:event_btn_LerActionPerformed

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
            java.util.logging.Logger.getLogger(CadContaCorrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadContaCorrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadContaCorrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadContaCorrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadContaCorrente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ler;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
