package proyectojuego;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class memorama1 extends javax.swing.JFrame {

    private List<String> characters = new LinkedList<String>();
    private Character character1 = new Character();
    private Character character2 = new Character();
    private int hits = 0;
    
    /**
     * Creates new form GameFrame
     */
    public memorama1() {
        initComponents(); 
        this.setLocationRelativeTo(null);
        
        
        
        setTitle("Game Memory");
        setLocationRelativeTo(null);
        
        //layout
        jPanel1.setLayout(new GridLayout(4, 4));
        
        //se añaden las figuras al panel
        for(int i=0;i<16;i++){
            jPanel1.add( new cartas() );    
        }
        
        //se crea nuevo juego
        newGame();
        
        //se añade eventos para cada casilla
        for(int i=0;i<16;i++){
            
            final cartas button = (cartas) jPanel1.getComponent(i);
            
            button.addMouseListener( new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {                    
                    /* --------- controla el juego en si -------- */
                    if( button.isFront ){//si imagen esta tapada
                    
                        if( character1.isEmpty() ){
                            character1.setKey( button.getIndex() );
                            character1.setName( button.getNameCharacter() );                        
                        }else if( character2.isEmpty() ){
                            character2.setKey( button.getIndex() );
                            character2.setName( button.getNameCharacter() );     
                            
                            //si figuras de ambas casillas son iguales
                            if(character1.getName().equals( character2.getName() ) ){
                                character1.setKey( -1 );
                                character1.setName( "" ); 
                                character2.setKey( -1 );
                                character2.setName( "" ); 
                                hits +=1; 
                                //completo el juego?
                                if(hits==8){//si
                                    JOptionPane.showMessageDialog(null, "--------------------------- YOU WIN!!! ---------------------------", "Atención", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{//no son iguales
                                //se comienza un hilo que espera X tiempo hasta que la casilla de completamente la vuelta
                                new Thread(){
                                    @Override
                                    public void run()
                                    {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException ex) {}   
                                        //oculta figuras
                                        ((cartas) jPanel1.getComponent(character1.getKey())).flipAnimate();
                                        ((cartas) jPanel1.getComponent(character2.getKey())).flipAnimate();
                                        character1.setKey( -1 );
                                        character1.setName( "" ); 
                                        character2.setKey( -1 );
                                        character2.setName( "" ); 
                                    }                            
                                }.start();
                            }
                        }     

                    }else{                       
                       button.cancel();//se cancela animacion
                    }
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {/* nada q ver circulando jovenes... */}

                @Override
                public void mouseReleased(MouseEvent e) {/* nada q ver circulando jovenes... */}

                @Override
                public void mouseEntered(MouseEvent e) {/* nada q ver circulando jovenes... */}

                @Override
                public void mouseExited(MouseEvent e) {/* nada q ver circulando jovenes... */}
                
            });
        }
        //
    }
    public Image getIconImage(){
        Image retValue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
        return retValue;
    }
 
    
    /**
     * Nuevo juegos
     */
    private void newGame(){
        characters.clear();
        
        //personajes
        characters.add("baby");
        characters.add("ball");
        characters.add("bed");
        characters.add("bicycle");
        characters.add("boots");
        characters.add("bottle");
        characters.add("flag");
        characters.add("hair");
        
        characters.add("baby");
        characters.add("ball");
        characters.add("bed");
        characters.add("bicycle");
        characters.add("boots");
        characters.add("bottle");
        characters.add("flag");
        characters.add("hair");
                
        //asigna los personajes a cada casilla
        for(int i=0;i<16;i++){
            ((cartas) jPanel1.getComponent(i)).setNameCharacter(getCharacter());
            ((cartas) jPanel1.getComponent(i)).setIndex(i);               

            if( !((cartas) jPanel1.getComponent(i)).isFront )
                ((cartas) jPanel1.getComponent(i)).flipAnimate();
        }
        //reinicia variables
        character1 = new Character();
        character2 = new Character();
        hits=0;
    }
    
    /**
     * desordena lista y retorna un personaje
     * @return String Nombre del personaje
     */
    private String getCharacter(){        
        Collections.shuffle(characters);
        return characters.remove(0);        
    }
    
    /**
     * clase privada para manejar las 2 figuras que deben ser comparadas
     */
    private class Character{
        
        private int key=-1;
        private String name="";        

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }    
        
        public boolean isEmpty(){
            if(key==-1 && name.equals(""))
               return true;
            else 
               return false;
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("LOADING NEW GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 400, 41));

        jButton3.setBackground(new java.awt.Color(0, 0, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("NEXT-->");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REGRESAR A MENU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/columnas.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newGame();        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 juego1 formul = new  juego1();
        formul.setVisible(true);
        this.dispose();// para cerrar la otra ventana 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
pantalla formul = new  pantalla();
        formul.setVisible(true);
        this.dispose();// para cerrar la otra ventana 
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(memorama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memorama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memorama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memorama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memorama1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
