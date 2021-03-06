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
        jC_Inicial1 = new javax.swing.JComboBox();
        jC_Inicial2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jL_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jB_Equipo1 = new javax.swing.JButton();
        jB_Equipo2 = new javax.swing.JButton();

        jL_Jugador1.setText("Jugador 1");

        jL_Jugador2.setText("Jugador 2");

        jB_Iniciar.setText("INICIAR");

        jC_Inicial1.addAncestorListener(new javax.swing.event.AncestorListener() {
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
        jC_Inicial1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                pokemon4(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pokemon6(evt);
            }
        });
        jC_Inicial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon1(evt);
            }
        });

        jC_Inicial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon1(evt);
            }
        });
        jC_Inicial2.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                pokemon4(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pokemon6(evt);
            }
        });
        jC_Inicial2.addAncestorListener(new javax.swing.event.AncestorListener() {
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

        jLabel3.setText("Seleccionar Pokémon inicial ");

        jLabel4.setText("Seleccionar Pokémon inicial");

        jL_Titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_Titulo.setText("jLabel5");

        jB_Equipo1.setText("Equipo Personalizado");

        jB_Equipo2.setText("Equipo Personalizado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jL_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jC_Inicial1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB_Equipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jL_Jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(149, 149, 149)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jB_Equipo2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jC_Inicial2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jL_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jB_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jL_Titulo)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Jugador1)
                    .addComponent(jL_Jugador2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jC_Inicial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jC_Inicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Equipo1)
                    .addComponent(jB_Equipo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jB_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

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
        this.jB_Equipo1.addActionListener(al);
        this.jB_Equipo2.addActionListener(al);
        
    }
    
    public JButton getBotonIniciar(){
        return this.jB_Iniciar;
    }
    public JButton getBotonEquipo1(){
        return this.jB_Equipo1;
    }
    public JButton getBotonEquipo2(){
        return this.jB_Equipo2;
    }
    
    public VistaPreviaCombate(int tipo_combate, String nombre1, String nombre2){
        initComponents();
        jL_Jugador1.setText(nombre1);
        jL_Jugador2.setText(nombre2);
        switch(tipo_combate){
            case 0:
                jL_Titulo.setText("Combate Usuario vs Sistema Simulado");
                jC_Inicial2.setEnabled(false);
                break;
            case 1:
                jL_Titulo.setText("Combate Usuario vs Usuario por Turnos");
                break;
            case 2:
                jL_Titulo.setText("Combate Usuario vs Sistema por Turnos");
                jC_Inicial2.setEnabled(false);
                break;
        }
}
    public void setjC_Equipo1(String[] equipo) {
        this.jC_Inicial1.addItem(equipo[0]);
        this.jC_Inicial1.addItem(equipo[1]);
        this.jC_Inicial1.addItem(equipo[2]);
        this.jC_Inicial1.addItem(equipo[3]);
        this.jC_Inicial1.addItem(equipo[4]);
        this.jC_Inicial1.addItem(equipo[5]);
    }
    public void setjC_Equipo2(String[] equipo) {
        this.jC_Inicial2.addItem(equipo[0]);
        this.jC_Inicial2.addItem(equipo[1]);
        this.jC_Inicial2.addItem(equipo[2]);
        this.jC_Inicial2.addItem(equipo[3]);
        this.jC_Inicial2.addItem(equipo[4]);
        this.jC_Inicial2.addItem(equipo[5]);
    }
    public String getjC_Inicial1(){
        return jC_Inicial1.getSelectedItem().toString();
    }
    public String getjC_Inicial2(){
        return jC_Inicial2.getSelectedItem().toString();
    }
    public int getIndexjC_Inicial1(){
        return jC_Inicial1.getSelectedIndex();
    }
    public int getIndexjC_Inicial2(){
        return jC_Inicial2.getSelectedIndex();
    }
    public void removerJc_Pokemons1(){
        this.jC_Inicial1.removeAllItems();
    }
    public void removerJc_Pokemons2(){
        this.jC_Inicial2.removeAllItems();
    }
    
    public void desactivarCambioSistema(){
        this.jB_Equipo2.setEnabled(false);
    }
    public void activarCambioSistema(){
        this.jB_Equipo2.setEnabled(true);
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
    private javax.swing.JButton jB_Equipo1;
    private javax.swing.JButton jB_Equipo2;
    private javax.swing.JButton jB_Iniciar;
    private javax.swing.JComboBox jC_Inicial1;
    private javax.swing.JComboBox jC_Inicial2;
    private javax.swing.JLabel jL_Jugador1;
    private javax.swing.JLabel jL_Jugador2;
    private javax.swing.JLabel jL_Titulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
}
