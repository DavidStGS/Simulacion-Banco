
package banco;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import BDConexion.ConexionBD;
import BCrypt.BCrypt;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Register extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    public Register() {
        initComponents();
        llenarComboBoxSucursales();
        TextPrompt Prueba4 = new TextPrompt("Cedula",userTxt3);
        TextPrompt Prueba2 = new TextPrompt("Nombre",userTxt1);
        TextPrompt Prueba3 = new TextPrompt("Apellido",userTxt2);
        TextPrompt Prueba = new TextPrompt("Email",userTxt);
        TextPrompt Prueba1 = new TextPrompt("Contraseña",passTxt);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png")));

        ((AbstractDocument) userTxt3.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (!text.matches("\\D+")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (!text.matches("\\D+")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
    });
        
((AbstractDocument) userTxt1.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (text.matches("\\p{Alpha}+")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("^[a-zA-Z ]+$")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
});

((AbstractDocument) userTxt2.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (text.matches("^[a-zA-Z ]+$")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("^[a-zA-Z ]+$")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
});


        this.setLocationRelativeTo(null);
        // Agregar un KeyListener al campo de texto userTxt para activar el botón rSButtonGradiente2
        passTxt.addKeyListener (new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                rSButtonGradiente2.doClick();
            }
        }
    });
        // Agregar un KeyListener al campo de texto userTxt para activar el botón rSButtonGradiente2
        userTxt.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                rSButtonGradiente2.doClick();
            }
        }
    });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        logolabel1 = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitbtn = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        PassLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        passTxt = new javax.swing.JPasswordField();
        rSButtonGradiente1 = new rsbuttongradiente.RSButtonGradiente();
        UserLabel1 = new javax.swing.JLabel();
        userTxt1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        PassLabel1 = new javax.swing.JLabel();
        userTxt2 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        rSButtonGradiente2 = new rsbuttongradiente.RSButtonGradiente();
        jLabel4 = new javax.swing.JLabel();
        UserLabel2 = new javax.swing.JLabel();
        rSComboBox1 = new rojerusan.RSComboBox();
        UserLabel3 = new javax.swing.JLabel();
        userTxt3 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(844, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(102, 16, 141));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(0, 255, 255));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logolabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logolabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icons8-dinero-tuyo-96.png"))); // NOI18N
        rSPanelGradiente1.add(logolabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 140));

        namelabel.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        namelabel.setForeground(new java.awt.Color(255, 255, 255));
        namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelabel.setText("BANCO DAVJAV");
        rSPanelGradiente1.add(namelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 290, -1));

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 810, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel5.setText("REGISTRASE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        UserLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        UserLabel.setText("CORREO ELECTRONICO");
        jPanel1.add(UserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setBorder(null);
        userTxt.setCaretColor(new java.awt.Color(204, 204, 204));
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 400, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 400, 10));

        PassLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        PassLabel.setText("CONTRASEÑA");
        jPanel1.add(PassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 400, 20));

        passTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passTxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        passTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTxtActionPerformed(evt);
            }
        });
        jPanel1.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 370, 30));

        rSButtonGradiente1.setText("Ingresar");
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
        jPanel1.add(rSButtonGradiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 130, -1));

        UserLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        UserLabel1.setText("CIUDAD");
        jPanel1.add(UserLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        userTxt1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt1.setBorder(null);
        userTxt1.setCaretColor(new java.awt.Color(204, 204, 204));
        userTxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTxt1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTxt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTxt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxt1MousePressed(evt);
            }
        });
        userTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxt1ActionPerformed(evt);
            }
        });
        jPanel1.add(userTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 180, 10));

        PassLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        PassLabel1.setText("APELLIDO");
        jPanel1.add(PassLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        userTxt2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt2.setBorder(null);
        userTxt2.setCaretColor(new java.awt.Color(204, 204, 204));
        userTxt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTxt2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTxt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTxt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxt2MousePressed(evt);
            }
        });
        userTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxt2ActionPerformed(evt);
            }
        });
        jPanel1.add(userTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 180, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 180, 10));

        rSButtonGradiente2.setText("Registrase");
        rSButtonGradiente2.setColorPrimario(new java.awt.Color(102, 16, 141));
        rSButtonGradiente2.setColorPrimarioHover(new java.awt.Color(148, 0, 153));
        rSButtonGradiente2.setColorSecundario(new java.awt.Color(0, 153, 204));
        rSButtonGradiente2.setColorSecundarioHover(new java.awt.Color(0, 194, 240));
        rSButtonGradiente2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        rSButtonGradiente2.setGradiente(rsbuttongradiente.RSButtonGradiente.Gradiente.HORIZONTAL);
        rSButtonGradiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradiente2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 130, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icons8-logotipo-de-java-coffee-cup-64.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        UserLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        UserLabel2.setText("NOMBRE");
        jPanel1.add(UserLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        rSComboBox1.setColorArrow(new java.awt.Color(102, 16, 141));
        rSComboBox1.setColorFondo(new java.awt.Color(102, 16, 141));
        rSComboBox1.setColorSeleccion(new java.awt.Color(102, 16, 141));
        rSComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        UserLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        UserLabel3.setText("CEDULA");
        jPanel1.add(UserLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        userTxt3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt3.setBorder(null);
        userTxt3.setCaretColor(new java.awt.Color(204, 204, 204));
        userTxt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTxt3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTxt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTxt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxt3MousePressed(evt);
            }
        });
        userTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxt3ActionPerformed(evt);
            }
        });
        jPanel1.add(userTxt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 180, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 180, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void passTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTxtActionPerformed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

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

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        /*if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_userTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        /*if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_passTxtMousePressed

    private void userTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMouseEntered
        /*if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }   */     
    }//GEN-LAST:event_userTxtMouseEntered

    private void userTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMouseExited
        /*if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_userTxtMouseExited

    private void passTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMouseEntered
       /* if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_passTxtMouseEntered

    private void passTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMouseExited
        /*if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        } */
    }//GEN-LAST:event_passTxtMouseExited

    private void userTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMouseClicked

    }//GEN-LAST:event_userTxtMouseClicked

    private void passTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMouseClicked

    }//GEN-LAST:event_passTxtMouseClicked

    private void rSButtonGradiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradiente1ActionPerformed
        Login ob= new Login();
        ob.setLocationRelativeTo(null);
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonGradiente1ActionPerformed
    
    private int obtenerCodigoCiudadPorNombre(String nombreCiudad) {
    int codigoCiudad = -1; // Valor por defecto si no se encuentra la ciudad

    ConexionBD con = new ConexionBD();
    Connection cn = con.Conexion();

    try {
        String sql = "SELECT codigo_ciudad FROM sucursales WHERE nombre_ciudad = ?";
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
        ps.setString(1, nombreCiudad);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            codigoCiudad = rs.getInt("codigo_ciudad");
        }

        rs.close();
        ps.close();
        cn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al obtener código de ciudad: " + e.getMessage());
        System.out.print("Error al obtener código de ciudad: " + e.getMessage());
    }

    return codigoCiudad;
}
    private boolean validarCampos() {
    // Verificar que ningún campo esté vacío
    if (userTxt1.getText().isEmpty() || userTxt2.getText().isEmpty() ||
            userTxt.getText().isEmpty() || String.valueOf(passTxt.getPassword()).isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        return false;
    }
    
    // Verificar el formato del correo electrónico
    String correo = userTxt.getText();
    if (!correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(null, "El correo electrónico no tiene un formato válido.");
        return false;
    }
    
    // Verificar la longitud de la contraseña
    if (String.valueOf(passTxt.getPassword()).length() > 25) {
        JOptionPane.showMessageDialog(null, "La contraseña no puede tener más de 25 caracteres.");
        return false;
    }
    
    String nombre = userTxt1.getText();
    String apellidos = userTxt2.getText();
    if (!nombre.matches("^[a-zA-Z ]+$") || !apellidos.matches("^[a-zA-Z ]+$")) {
        JOptionPane.showMessageDialog(null, "Los campos de nombre y apellidos solo deben contener letras.");
        return false;
    }
        if (String.valueOf(userTxt3.getText()).length() > 10) {
        JOptionPane.showMessageDialog(null, "La cedula no tiene un formato valido.");
        return false;
    }
    // Si todas las validaciones pasan, retornar true
    return true;
}
    private void registrarUsuario() {
    if (validarCampos()) {
        ConexionBD con = new ConexionBD();
        Connection cn = con.Conexion();
        String nombre = userTxt1.getText();
        String apellidos = userTxt2.getText();
        String cedula = String.valueOf(userTxt3.getText());
        String correo = userTxt.getText();
        String contrasena = new String(passTxt.getPassword()); // Obtener la contraseña como String

        // Encriptar la contraseña utilizando BCrypt
        String hashedContrasena = BCrypt.hashpw(contrasena, BCrypt.gensalt());

        String ciudadSeleccionada = (String) rSComboBox1.getSelectedItem(); // Obtener la ciudad seleccionada
        int codigoCiudad = obtenerCodigoCiudadPorNombre(ciudadSeleccionada);

        String sql = "INSERT INTO usuarios (identificacion, nombre, apellidos, correo_electronico, contrasena, codigo_sucursal) " +
                     "VALUES ('" + cedula + "','" + nombre + "', '" + apellidos + "', '" + correo + "', '" + hashedContrasena + "', " + codigoCiudad + ")";

        try {
            java.sql.Statement set = cn.createStatement();
            int filasAfectadas = set.executeUpdate(sql);

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                Login ob = new Login();
                ob.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario.");
            }

            set.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
            System.out.print("Error al registrar usuario: " + e.getMessage());
        }
    }
}



    private void userTxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1MouseClicked

    private void userTxt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1MouseEntered

    private void userTxt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1MouseExited

    private void userTxt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1MousePressed

    private void userTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1ActionPerformed

    private void userTxt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt2MouseClicked

    private void userTxt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt2MouseEntered

    private void userTxt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt2MouseExited

    private void userTxt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt2MousePressed

    private void userTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt2ActionPerformed

    private void rSButtonGradiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradiente2ActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_rSButtonGradiente2ActionPerformed

    private void userTxt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt3MouseClicked

    private void userTxt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt3MouseEntered

    private void userTxt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt3MouseExited

    private void userTxt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt3MousePressed

    private void userTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt3ActionPerformed

    private void rSComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSComboBox1ActionPerformed
    private boolean mostrarContrasena = false;
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        mostrarContrasena = !mostrarContrasena; // Cambiar el estado

        if (mostrarContrasena) {
            passTxt.setEchoChar((char) 0); // Mostrar Contraseña
            ImageIcon iconoClickeado = new ImageIcon(getClass().getResource("/img/ocultar.png"));
            jLabel2.setIcon(iconoClickeado);
        } else {
            passTxt.setEchoChar('*'); // Ocultar Contraseña
            ImageIcon iconoClickeado = new ImageIcon(getClass().getResource("/img/ver.png"));
            jLabel2.setIcon(iconoClickeado);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

// Agregar un método para llenar el ComboBox de sucursales
    private void llenarComboBoxSucursales() {
        
        rSComboBox1.removeAllItems();
        ConexionBD con = new ConexionBD();
        Connection cn = con.Conexion();
        
        try {
            String sql = "SELECT nombre_ciudad FROM sucursales";
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String nombreCiudad = rs.getString("nombre_ciudad");
                rSComboBox1.addItem(nombreCiudad);
            }
            
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar ComboBox de sucursales: " + e.getMessage());
        }
    }
    
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PassLabel;
    private javax.swing.JLabel PassLabel1;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel UserLabel1;
    private javax.swing.JLabel UserLabel2;
    private javax.swing.JLabel UserLabel3;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel exitbtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logolabel1;
    private javax.swing.JLabel namelabel;
    private javax.swing.JPasswordField passTxt;
    private rsbuttongradiente.RSButtonGradiente rSButtonGradiente1;
    private rsbuttongradiente.RSButtonGradiente rSButtonGradiente2;
    private rojerusan.RSComboBox rSComboBox1;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private javax.swing.JTextField userTxt;
    private javax.swing.JTextField userTxt1;
    private javax.swing.JTextField userTxt2;
    private javax.swing.JTextField userTxt3;
    // End of variables declaration//GEN-END:variables
}
