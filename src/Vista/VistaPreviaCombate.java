/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCombate;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author hp-
 */
public class VistaPreviaCombate extends javax.swing.JFrame {

    /**
     * Creates new form VistarPreviaCombate
     */
    public VistaPreviaCombate() {
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

        jL_Jugador1 = new javax.swing.JLabel();
        jL_Jugador2 = new javax.swing.JLabel();
        jB_Iniciar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jL_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Jugador1.setText("Jugador 1");
        getContentPane().add(jL_Jugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 51, -1, -1));

        jL_Jugador2.setText("Jugador 2");
        getContentPane().add(jL_Jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 51, -1, -1));

        jB_Iniciar.setText("INICIAR");
        getContentPane().add(jB_Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 175, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pokemon1", "Pokemon2", "Pokemon3", "Pokemon4", "Pokemon5", "Pokemon6" }));
        jComboBox1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                pokemon3(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pokemon2(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                pokemon5(evt);
            }
        });
        jComboBox1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                pokemon4(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pokemon6(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon1(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 115, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pokemon1", "Pokemon2", "Pokemon3", "Pokemon4", "Pokemon5", "Pokemon6" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon1(evt);
            }
        });
        jComboBox2.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                pokemon4(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pokemon6(evt);
            }
        });
        jComboBox2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                pokemon3(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pokemon2(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                pokemon5(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 115, -1, -1));

        jLabel3.setText("Seleccionar Pokémon inicial ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 83, -1, -1));

        jLabel4.setText("Seleccionar Pokémon inicial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 83, -1, -1));

        jL_Titulo.setText("jLabel5");
        getContentPane().add(jL_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 418, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 557, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pokemon1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemon1
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon1

    private void pokemon2(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pokemon2
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon2

    private void pokemon3(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pokemon3
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon3

    private void pokemon4(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pokemon4
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon4

    private void pokemon5(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pokemon5
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon5

    private void pokemon6(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pokemon6
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemon6

   
    public void agregarListener(ActionListener al){
        this.jB_Iniciar.addActionListener(al);
        
    }
    
    public JButton getBotonIniciar(){
        return this.jB_Iniciar;
    }
    
    public VistaPreviaCombate(int tipo_combate){
        initComponents();
        switch(tipo_combate){
            case 0:
                jL_Titulo.setText("Combate Usuario vs Sistema Simulado");
                jComboBox2.setEnabled(false);
                break;
            case 1:
                jL_Titulo.setText("Combate Usuario vs Usuario por Turnos");
                break;
            case 2:
                jL_Titulo.setText("Combate Usuario vs Sistema por Turnos");
                jComboBox2.setEnabled(false);
                break;
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
            java.util.logging.Logger.getLogger(VistaPreviaCombate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPreviaCombate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPreviaCombate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPreviaCombate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPreviaCombate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Iniciar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jL_Jugador1;
    private javax.swing.JLabel jL_Jugador2;
    private javax.swing.JLabel jL_Titulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
