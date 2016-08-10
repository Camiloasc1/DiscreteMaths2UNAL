package UI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UI.java
 *
 * Created on 26-may-2014, 11:29:01
 */


import image.ImageUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.Main;

/**
 *
 * @author sergiodiazpinilla
 */
public class UI extends javax.swing.JFrame {

    /** Creates new form UI */
    public UI() {
        
        initComponents();
        this.setResizable(false);
        
        
//

    }

    private String loadArchivo() {

        String texto = "";

        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);

        File abre = file.getSelectedFile();


        return texto = abre.getPath();
    }

    private String saveArchivo() {

        String texto = "";

        JFileChooser file = new JFileChooser();
        file.showSaveDialog(this);
        File guarda = file.getSelectedFile();


        return texto = guarda.getPath() + ".png";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        beginDirectory = new javax.swing.JTextField();
        file = new javax.swing.JButton();
        endDirectory = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        encrypt = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        decrypt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DisUn 2.0");

        file.setText("Open");
        file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        encrypt.setText("Encrypt");
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });

        decrypt.setText("Decript");
        decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptActionPerformed(evt);
            }
        });

        jLabel1.setText("Password");

        org.jdesktop.layout.GroupLayout menuLayout = new org.jdesktop.layout.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuLayout.createSequentialGroup()
                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(menuLayout.createSequentialGroup()
                        .add(131, 131, 131)
                        .add(encrypt)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 74, Short.MAX_VALUE)
                        .add(decrypt)
                        .add(35, 35, 35))
                    .add(menuLayout.createSequentialGroup()
                        .add(216, 216, 216)
                        .add(jLabel1))
                    .add(menuLayout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(password, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .add(menuLayout.createSequentialGroup()
                                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, endDirectory)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, beginDirectory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .add(46, 46, 46)
                                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(file)
                                    .add(save))))))
                .add(39, 39, 39))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuLayout.createSequentialGroup()
                .add(55, 55, 55)
                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(beginDirectory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(file))
                .add(18, 18, 18)
                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(endDirectory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(save))
                .add(26, 26, 26)
                .add(jLabel1)
                .add(12, 12, 12)
                .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                .add(menuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(encrypt)
                    .add(decrypt))
                .addContainerGap())
        );

        jMenu1.setText("File");

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        menuBar.add(jMenu1);

        jMenu2.setText("Help");

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        jMenu2.add(help);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileActionPerformed
    
    try {
        beginDirectory.setText(loadArchivo());
    } catch (java.lang.NullPointerException e) {
        beginDirectory.setText("");
    }
}//GEN-LAST:event_fileActionPerformed

private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try {
        endDirectory.setText(saveArchivo());
    } catch (java.lang.NullPointerException e) {
        beginDirectory.setText("");
    }
}//GEN-LAST:event_saveActionPerformed

private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed

    String begin = beginDirectory.getText();
    String end = endDirectory.getText();
    
    if (begin.length() != 0 && end.length() != 0) {
        try {
            password.setText(Main.encode(begin, end));
            password.setEditable(true);
            JOptionPane.showMessageDialog(null, "Encriptacion completa arcivo en " + end);
        } catch (java.lang.IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el el archivo\n" + begin);
        }

    } else {
        JOptionPane.showMessageDialog(null, "Los campos estan vacios");

    }
}//GEN-LAST:event_encryptActionPerformed

private void decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptActionPerformed
    String begin = beginDirectory.getText();
    String end = endDirectory.getText();

    if (begin.length() != 0 && end.length() != 0) {
        try {
            Main.decode(begin, end, password.getText());
            password.setText("");
            JOptionPane.showMessageDialog(null, "Desencriptacion completa arcivo en " + end);
        } catch (java.lang.IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el el archivo\n" + begin);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Los campos estan vacios");
    }
}//GEN-LAST:event_decryptActionPerformed

private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed

    try {
        beginDirectory.setText(loadArchivo());
    } catch (java.lang.NullPointerException e) {
        beginDirectory.setText("");
    }
}//GEN-LAST:event_openMenuActionPerformed

private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
    try {
        endDirectory.setText(saveArchivo());
    } catch (java.lang.NullPointerException e) {
        beginDirectory.setText("");
    }
}//GEN-LAST:event_saveMenuActionPerformed

private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
    System.exit(0);
}//GEN-LAST:event_exitMenuActionPerformed

private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
    JOptionPane.showMessageDialog(null, "En open elija el archivo que desea\nencriptar o desencriptar \nEn save el destino de la imagen final");
}//GEN-LAST:event_helpActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new UI().setVisible(true);
            }
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beginDirectory;
    private javax.swing.JButton decrypt;
    private javax.swing.JButton encrypt;
    private javax.swing.JTextField endDirectory;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JButton file;
    private javax.swing.JMenuItem help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JTextField password;
    private javax.swing.JButton save;
    private javax.swing.JMenuItem saveMenu;
    // End of variables declaration//GEN-END:variables
}
