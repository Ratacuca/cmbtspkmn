/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Mario Caceres
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jB_SimularCombate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jB_crear_entrenador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jC_TipoSimulacion = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Combates Pokémon");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 11, -1, 31));

        jB_SimularCombate.setText("Simular Combate");
        jB_SimularCombate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SimularCombateActionPerformed(evt);
            }
        });
        getContentPane().add(jB_SimularCombate, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 60, -1, -1));

        jButton2.setText("Simular Torneo");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 101, 113, -1));

        jB_crear_entrenador.setText("Crear Entrenador");
        getContentPane().add(jB_crear_entrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 154, 143, -1));

        jLabel2.setText("Entrenador Actual:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 64, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 183, 90, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 546, 10));

        jLabel4.setText("Tipo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 64, -1, -1));

        jC_TipoSimulacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario/Sistema (Simulado)", "Usuario/Usuario (Turnos)", "Usuario/Sistema (Turnos)" }));
        getContentPane().add(jC_TipoSimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 61, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 88, 143, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_SimularCombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SimularCombateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_SimularCombateActionPerformed

   public void agregarListener(ActionListener al) {
       this.jB_SimularCombate.addActionListener(al);
       this.jB_crear_entrenador.addActionListener(al);
   }
   
   public JButton getBotonSimularCombate() { 
        return this.jB_SimularCombate;
    }
   
   public JButton getBotonCrearEntrenador() { 
        return this.jB_crear_entrenador;
    }
   
   public int getjC_TipoSimulacion() {
        return jC_TipoSimulacion.getSelectedIndex();
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_SimularCombate;
    private javax.swing.JButton jB_crear_entrenador;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jC_TipoSimulacion;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
