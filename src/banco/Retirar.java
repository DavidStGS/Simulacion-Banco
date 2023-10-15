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
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import looadingPages.Loading11;


/**
 *
 * @author USER
 */
public class Retirar extends javax.swing.JFrame {
    ConexionBD con=new ConexionBD();
    Connection cn=con.Conexion();
    private int idUsuario;
    int xMouse, yMouse;
    
    public Retirar(int idUsuario) {
        
        initComponents();
        this.idUsuario = idUsuario;
        TextPrompt Prueba = new TextPrompt("Escribe el Monto a Retirar",montoTxt);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png")));

        ((AbstractDocument) montoTxt.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (!text.matches("\\D+")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (!text.matches("\\D+")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
});
        mostrarDatosCuenta2();
    }
    public int obtenerCodigoSucursal(int idUsuario) {
    try {
        String sql = "SELECT codigo_sucursal FROM usuarios WHERE id=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idUsuario);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("codigo_sucursala");
        }
    } catch (SQLException e) {
    }
    return -1; // Devuelve un valor por defecto si hay un error o no se encuentra el código de sucursal.
}

    
    public String obtenerNombreCiudad(int codigoSucursal) {
    try {
        String sql = "SELECT nombre_ciudad FROM sucursales WHERE codigo_ciudad=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, codigoSucursal);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getString("nombre_ciudad");
        }
    } catch (SQLException e) {
    }
    return ""; // Devuelve un valor por defecto si hay un error o no se encuentra la ciudad.
}

    private void mostrarDatosCuenta2() {
        try {
            String sql = "SELECT cb.*, u.identificacion " +
                         "FROM cuentas_bancarias cb " +
                         "INNER JOIN usuarios u ON cb.id_usuario = u.id " +
                         "WHERE cb.id_usuario=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nombreTitular = rs.getString("nombre_titular");
                String apellidosTitular = rs.getString("apellidos_titular");
                String numeroCuenta = rs.getString("numero_cuenta");
                String tipoCuenta = rs.getString("tipo_cuenta");
                double saldo = rs.getDouble("saldo");
                String ciudad = rs.getString("codigo_sucursal");
                int codigoSucursal = rs.getInt("codigo_sucursal");
                String nombreCiudad = obtenerNombreCiudad(codigoSucursal);

                String identificacion = rs.getString("identificacion"); // Obtener la identificacion

                jLabel1.setText(nombreTitular);
                jLabel2.setText(apellidosTitular);
                jLabel3.setText(numeroCuenta);
                jLabel18.setText(identificacion); // Mostrar la identificacion en jLabel17
            }
        } catch (SQLException e) {
        }
}
private void Retirar() {
    
        try {
        double monto = Double.parseDouble(montoTxt.getText());
        double saldoActual = obtenerSaldo(); // Obtener el saldo actual de la cuenta
        if (monto <= saldoActual) {
            String sql = "UPDATE cuentas_bancarias SET saldo = saldo - ? WHERE id_usuario = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setDouble(1, monto);
            pst.setInt(2, idUsuario);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                montoTxt.setText("");
                Loading11 ob = new Loading11();
                ob.setVisible(false);
                this.setVisible(true);
                // Actualizar los datos mostrados después del retiro
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el retiro."); 
                montoTxt.setText("");
                Loading11 ob = new Loading11();
                ob.setVisible(false);
                this.setVisible(true);  
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente."); 
            montoTxt.setText("");
            Loading11 ob = new Loading11();
            ob.setVisible(false);
            this.setVisible(true);              
        }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
        }
}
private double obtenerSaldo() {
    try {
        String sql = "SELECT saldo FROM cuentas_bancarias WHERE id_usuario = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idUsuario);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getDouble("saldo");
        }
        } catch (SQLException e) {
        }

    return 0; // En caso de error, retorna un saldo de 0 (o el valor que consideres apropiado)
}
    public Retirar() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel11 = new javax.swing.JLabel();
        logolabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitbtn = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        logolabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        montoTxt = new javax.swing.JTextField();
        UserLabel = new javax.swing.JLabel();
        rSButtonGradiente1 = new rsbuttongradiente.RSButtonGradiente();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 150, 20));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, 20));

        jLabel7.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel8.setText("Apellido");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Bk", 0, 16)); // NOI18N
        jLabel9.setText("N° Cuenta");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(102, 16, 141));
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

        jLabel14.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DEPOSITAR");
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
        rSPanelGradiente1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 290, 30));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CERRAR SESIÓN");
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
        rSPanelGradiente1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 290, 30));

        jLabel15.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MIRAR SALDO");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        rSPanelGradiente1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 30));

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

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 180, 160, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 220, 160, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 300, 160, 20));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel12.setText("RETIRAR DINERO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

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

        montoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        montoTxt.setBorder(null);
        montoTxt.setCaretColor(new java.awt.Color(204, 204, 204));
        montoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                montoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                montoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                montoTxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                montoTxtMousePressed(evt);
            }
        });
        montoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoTxtActionPerformed(evt);
            }
        });
        jPanel1.add(montoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 290, 30));

        UserLabel.setFont(new java.awt.Font("Roboto Bk", 1, 16)); // NOI18N
        UserLabel.setText("Retirar Monto");
        jPanel1.add(UserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        rSButtonGradiente1.setText("Retirar");
        rSButtonGradiente1.setToolTipText("");
        rSButtonGradiente1.setColorPrimario(new java.awt.Color(102, 16, 141));
        rSButtonGradiente1.setColorPrimarioHover(new java.awt.Color(148, 0, 153));
        rSButtonGradiente1.setColorSecundario(new java.awt.Color(0, 153, 204));
        rSButtonGradiente1.setColorSecundarioHover(new java.awt.Color(0, 194, 240));
        rSButtonGradiente1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        rSButtonGradiente1.setGradiente(rsbuttongradiente.RSButtonGradiente.Gradiente.HORIZONTAL);
        rSButtonGradiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradiente1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonGradiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 130, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 290, 10));

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

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Loading11 op = new Loading11();
        op.setVisible(true);
        this.dispose();
        Depositar ob= new Depositar(idUsuario);
        ob.setVisible(true);
        ob.setLocationRelativeTo(null);
        op.setVisible(false);
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

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Loading11 op = new Loading11();
        op.setVisible(true);
        this.dispose();
        Login ob= new Login();
        ob.setVisible(true);
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

    private void montoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoTxtMouseClicked

    }//GEN-LAST:event_montoTxtMouseClicked

    private void montoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoTxtMouseEntered
        /*if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }   */
    }//GEN-LAST:event_montoTxtMouseEntered

    private void montoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoTxtMouseExited
        /*if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_montoTxtMouseExited

    private void montoTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoTxtMousePressed
        /*if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_montoTxtMousePressed

    private void montoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTxtActionPerformed

    private void rSButtonGradiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradiente1ActionPerformed
        Loading11 ob = new Loading11();
        ob.setVisible(true);
        this.setVisible(false);
        Retirar();
    }//GEN-LAST:event_rSButtonGradiente1ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Loading11 op = new Loading11();
        op.setVisible(true);
        this.dispose();
        AccountData ob= new AccountData(idUsuario);
        ob.setVisible(true);
        ob.setLocationRelativeTo(null);
        op.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setForeground(new Color(172,153,204));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setForeground(Color.WHITE);
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel15MouseExited
    
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
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new Retirar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel exitbtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel logolabel;
    private javax.swing.JLabel logolabel1;
    private javax.swing.JTextField montoTxt;
    private rsbuttongradiente.RSButtonGradiente rSButtonGradiente1;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
