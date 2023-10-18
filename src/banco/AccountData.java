/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import BDConexion.ConexionBD; // Asegúrate de que este sea el import correcto para tu clase de conexión a la base de datos.
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.NumberFormat;
import looadingPages.Loading11;


/**
 *
 * @author USER
 */
public class AccountData extends javax.swing.JFrame {
    ConexionBD con=new ConexionBD();
    Connection cn=con.Conexion();
    private int idUsuario;
    int xMouse, yMouse;
    
    public AccountData(int idUsuario) {
        
        initComponents();
        this.idUsuario = idUsuario;
        mostrarDatosCuenta();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png")));

    }
    
    public int obtenerCodigoSucursal(int idUsuario) {
        try {
            String sql = "SELECT codigo_sucursal FROM usuarios WHERE id=?";
            try (PreparedStatement pst = cn.prepareStatement(sql)) {
                pst.setInt(1, idUsuario);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("codigo_sucursal");
                    }
                }
            }
        } catch (SQLException e) { // Imprimir el error para debug
        }
        return -1;
}


    
    public String obtenerNombreCiudad(int codigoSucursal) {
        try {
            String sql = "SELECT nombre_ciudad FROM sucursales WHERE codigo_ciudad=?";
            try (PreparedStatement pst = cn.prepareStatement(sql)) {
                pst.setInt(1, codigoSucursal);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("nombre_ciudad");
                    }
                }
            }
        } catch (SQLException e) {
            // Imprimir el error para debug
            }
        return "";
}


    private void mostrarDatosCuenta() {
        try {
            String sql = "SELECT cb.*, u.identificacion, s.nombre_ciudad " +
                         "FROM cuentas_bancarias cb " +
                         "INNER JOIN usuarios u ON cb.id_usuario = u.id " +
                         "INNER JOIN sucursales s ON cb.codigo_sucursal = s.codigo_ciudad " +
                         "WHERE cb.id_usuario=?";
            try (PreparedStatement pst = cn.prepareStatement(sql)) {
                pst.setInt(1, idUsuario);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String nombreTitular = rs.getString("nombre_titular");
                        String apellidosTitular = rs.getString("apellidos_titular");
                        String numeroCuenta = rs.getString("numero_cuenta");
                        String tipoCuenta = rs.getString("tipo_cuenta");
                        int saldo = rs.getInt("saldo");
                        String nombreCiudad = rs.getString("nombre_ciudad");
                        String identificacion = rs.getString("identificacion");

                        NumberFormat formatoSaldo = NumberFormat.getIntegerInstance();
                        String saldoFormateado = formatoSaldo.format(saldo);

                        jLabel1.setText(nombreTitular);
                        jLabel2.setText(apellidosTitular);
                        jLabel3.setText(numeroCuenta);
                        jLabel4.setText(tipoCuenta);
                        jLabel5.setText("$" + saldoFormateado);
                        jLabel16.setText(nombreCiudad);
                        jLabel18.setText(identificacion);
                    }
                }
            }
        } catch (SQLException e) { // Imprimir el error para debug
            }
}



    public AccountData() {
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel11 = new javax.swing.JLabel();
        logolabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitbtn = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        logolabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 150, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 150, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 150, 20));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, 20));

        jLabel6.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel6.setText("Monto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel8.setText("Apellido");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel9.setText("N° Cuenta");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel10.setText("Tipo de  Cuenta");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(102, 0, 156));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(0, 255, 255));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DATOS DE LA CUENTA");
        rSPanelGradiente1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 290, -1));

        logolabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logolabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icons8-dinero-tuyo-96.png"))); // NOI18N
        rSPanelGradiente1.add(logolabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 290, 140));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DEPOSITAR");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        rSPanelGradiente1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 290, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CERRAR SESIÓN");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        rSPanelGradiente1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 290, 30));

        jLabel19.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("RETIRAR");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        rSPanelGradiente1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 290, 30));

        jPanel1.add(rSPanelGradiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 290, 500));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitbtn.setBackground(new java.awt.Color(255, 255, 255));
        exitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitbtn.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        exitbtn.setPreferredSize(new java.awt.Dimension(40, 40));

        btnExitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        btnExitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExitTxt.setText("X");
        btnExitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        btnExitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitbtnLayout = new javax.swing.GroupLayout(exitbtn);
        exitbtn.setLayout(exitbtnLayout);
        exitbtnLayout.setHorizontalGroup(
            exitbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitbtnLayout.createSequentialGroup()
                .addComponent(btnExitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        exitbtnLayout.setVerticalGroup(
            exitbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 380, 160, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 180, 160, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 220, 160, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 300, 160, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 340, 160, 20));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel12.setText("DATOS DE LA CUENTA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel15.setText("Ciudad");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel16.setText("jLabel5");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 150, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 420, 160, 20));

        logolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icons8-blockchain-technology-64.png"))); // NOI18N
        jPanel1.add(logolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, 60));

        jLabel17.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel17.setText("Cedula");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setText("jLabel6");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 150, 20));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 260, 160, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitTxtMouseClicked

    private void btnExitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseEntered
        exitbtn.setBackground(Color.red);
        btnExitTxt.setForeground(Color.white);

    }//GEN-LAST:event_btnExitTxtMouseEntered

    private void btnExitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseExited
        exitbtn.setBackground(Color.white);
        btnExitTxt.setForeground(Color.black);
    }//GEN-LAST:event_btnExitTxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Loading11 op = new Loading11();
        op.setVisible(true);
        this.dispose();
        Depositar ob= new Depositar(idUsuario);
        ob.setVisible(true);
        ob.setLocationRelativeTo(null);
        op.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jLabel13.setForeground(new Color(172,153,204));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        jLabel13.setForeground(Color.WHITE);
        setCursor(Cursor.getDefaultCursor());

    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Loading11 ob = new Loading11();
        ob.setVisible(true);
        this.dispose();
        Login op = new Login();
        op.setVisible(true);
        ob.setVisible(false);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jLabel14.setForeground(new Color(172,153,204));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jLabel14.setForeground(Color.WHITE);
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Loading11 op = new Loading11();
        op.setVisible(true);
        this.dispose();
        Retirar ob= new Retirar(idUsuario);
        ob.setVisible(true);
        ob.setLocationRelativeTo(null);
        op.setVisible(false);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setForeground(new Color(172,153,204));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setForeground(Color.WHITE);
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel19MouseExited

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
            java.util.logging.Logger.getLogger(AccountData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AccountData().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel exitbtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel logolabel;
    private javax.swing.JLabel logolabel1;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
