/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
//para el icono 
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author BARRUETA
 */
public class nuevousuario extends javax.swing.JFrame {
Connection conn=null;
PreparedStatement pst=null;
ResultSet rs=null;
    /**
     * Creates new form nuevousuario
     */
    public nuevousuario() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.dispose();
    }
    //para el icono en la barra
     public Image getIconImage(){
        Image retValue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        crearuser = new javax.swing.JLabel();
        crearcontraseña = new javax.swing.JLabel();
        usuarionuevo = new javax.swing.JTextField();
        contraseñanueva = new javax.swing.JPasswordField();
        salir = new javax.swing.JButton();
        im = new javax.swing.JLabel();
        altauser = new javax.swing.JButton();
        pant1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(0, 0, 102));
        titulo.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("CREATE NEW USER");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, -1));

        crearuser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        crearuser.setForeground(new java.awt.Color(255, 255, 255));
        crearuser.setText("NEU USER :");
        getContentPane().add(crearuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        crearcontraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        crearcontraseña.setForeground(new java.awt.Color(255, 255, 255));
        crearcontraseña.setText("NEU PASSWORD :");
        getContentPane().add(crearcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 100, 20));
        getContentPane().add(usuarionuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 190, -1));
        getContentPane().add(contraseñanueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 180, -1));

        salir.setBackground(new java.awt.Color(0, 0, 102));
        salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("EXIT");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        im.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/neuUser.png"))); // NOI18N
        getContentPane().add(im, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 270, 250));

        altauser.setBackground(new java.awt.Color(0, 0, 102));
        altauser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        altauser.setForeground(new java.awt.Color(255, 255, 255));
        altauser.setText("DONE");
        altauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altauserActionPerformed(evt);
            }
        });
        getContentPane().add(altauser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        pant1.setBackground(new java.awt.Color(0, 0, 102));
        pant1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pant1.setForeground(new java.awt.Color(255, 255, 255));
        pant1.setText("BACK");
        pant1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pant1ActionPerformed(evt);
            }
        });
        getContentPane().add(pant1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/map.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
 System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    private void pant1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pant1ActionPerformed
   acceso p1 = new  acceso();
        p1.setVisible(true);
          this.dispose();// para cerrar la otra ventana 
          // TODO add your handling code here:
    }//GEN-LAST:event_pant1ActionPerformed

    private void altauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altauserActionPerformed
conn =MysqlConnect.ConnectDB();
String Sql= "insert into tabusers values('"+usuarionuevo.getText()+ "','"+contraseñanueva.getText()+"')";
try{
    pst=conn.prepareStatement(Sql);
   if( pst.executeUpdate() != 0){

        JOptionPane.showMessageDialog(null,"USUARIO REGISTRADO ¡bien benido!");
        
         juego1 formul = new  juego1();
        formul.setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(null, "invalido usuario o pasword","acces denied",JOptionPane.ERROR_MESSAGE);
    } 
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
        
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_altauserActionPerformed

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
            java.util.logging.Logger.getLogger(nuevousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevousuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altauser;
    private javax.swing.JPasswordField contraseñanueva;
    private javax.swing.JLabel crearcontraseña;
    private javax.swing.JLabel crearuser;
    private javax.swing.JLabel im;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton pant1;
    private javax.swing.JButton salir;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField usuarionuevo;
    // End of variables declaration//GEN-END:variables
}
