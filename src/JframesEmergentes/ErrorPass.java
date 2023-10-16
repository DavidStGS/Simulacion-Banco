/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JframesEmergentes;

import banco.Register;
import java.awt.Toolkit;
import looadingPages.Loading11;
    
/**
 *
 * @author USER
 */
public class ErrorPass extends javax.swing.JFrame {

    private final Register op;
       
    public ErrorPass() {
        initComponents();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png")));
        // Crear una instancia de Register
        op = new Register();
        op.setVisible(true);
        op.setLocationRelativeTo(null);
        op.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonGradiente2 = new rsbuttongradiente.RSButtonGradiente();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("La contraseña no puede tener más de 25 caracteres.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 280, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-signo-de-exclamación-64.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        rSButtonGradiente2.setText("Ok");
        rSButtonGradiente2.setColorPrimario(new java.awt.Color(102, 16, 141));
        rSButtonGradiente2.setColorPrimarioHover(new java.awt.Color(148, 0, 153));
        rSButtonGradiente2.setColorSecundario(new java.awt.Color(0, 153, 204));
        rSButtonGradiente2.setColorSecundarioHover(new java.awt.Color(0, 194, 240));
        rSButtonGradiente2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        rSButtonGradiente2.setGradiente(rsbuttongradiente.RSButtonGradiente.Gradiente.HORIZONTAL);
        rSButtonGradiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradiente2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 60, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void rSButtonGradiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradiente2ActionPerformed
        op.setEnabled(true);
        Loading11 ob = new Loading11();
        ob.setVisible(true);
        this.dispose();
        ob.setVisible(false);
    }//GEN-LAST:event_rSButtonGradiente2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ErrorPass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private rsbuttongradiente.RSButtonGradiente rSButtonGradiente2;
    // End of variables declaration//GEN-END:variables
}
