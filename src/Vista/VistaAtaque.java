/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MovimientoAprendido;
import Modelo.Pokemon;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author hp-
 */
public class VistaAtaque extends javax.swing.JFrame {

    /**
     * Creates new form VistaAtaque
     */
    public VistaAtaque() {
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

        jB_Ataque1 = new javax.swing.JButton();
        jB_Ataque2 = new javax.swing.JButton();
        jB_Ataque3 = new javax.swing.JButton();
        jB_Ataque4 = new javax.swing.JButton();
        jL_PP1 = new javax.swing.JLabel();
        jL_PP2 = new javax.swing.JLabel();
        jL_PP3 = new javax.swing.JLabel();
        jL_PP4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jL_Precision1 = new javax.swing.JLabel();
        jL_Potencia1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jL_Precision2 = new javax.swing.JLabel();
        jL_Potencia2 = new javax.swing.JLabel();
        jL_Precision3 = new javax.swing.JLabel();
        jL_Potencia3 = new javax.swing.JLabel();
        jL_Precision4 = new javax.swing.JLabel();
        jL_Potencia4 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jB_Ataque1.setText("Ataque1");

        jB_Ataque2.setText("Ataque2");
        jB_Ataque2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Ataque2ActionPerformed(evt);
            }
        });

        jB_Ataque3.setText("Ataque3");

        jB_Ataque4.setText("Ataque4");

        jL_PP1.setText("PP/PP");

        jL_PP2.setText("PP/PP");

        jL_PP3.setText("PP/PP");

        jL_PP4.setText("PP/PP");

        jLabel5.setText("Precision:");

        jLabel6.setText("Potencia:");

        jL_Precision1.setText("jLabel7");

        jL_Potencia1.setText("jLabel8");

        jLabel7.setText("Precision:");

        jLabel8.setText("Potencia:");

        jLabel9.setText("Precision:");

        jLabel10.setText("Potencia:");

        jLabel11.setText("Precision:");

        jLabel12.setText("Potencia:");

        jL_Precision2.setText("jLabel13");

        jL_Potencia2.setText("jLabel14");

        jL_Precision3.setText("jLabel15");

        jL_Potencia3.setText("jLabel16");

        jL_Precision4.setText("jLabel17");

        jL_Potencia4.setText("jLabel18");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jL_Precision1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_Ataque1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jL_PP1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jL_Potencia1))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jL_Precision2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jB_Ataque2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jL_PP2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jL_Potencia2)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jB_Ataque3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jL_PP3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jL_Precision3)
                                        .addComponent(jL_Potencia3))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_Ataque4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jL_PP4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jL_Precision4)
                                    .addComponent(jL_Potencia4))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Ataque1)
                    .addComponent(jL_PP1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jL_Precision1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jL_Potencia1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Ataque2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jL_PP2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jL_Precision2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jL_Potencia2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Ataque3)
                    .addComponent(jL_PP3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jL_Precision3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jL_Potencia3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Ataque4)
                    .addComponent(jL_PP4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jL_Precision4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jL_Potencia4))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_Ataque2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Ataque2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_Ataque2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAtaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAtaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAtaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAtaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAtaque().setVisible(true);
            }
        });
    }
    public void agregarListener(ActionListener al) {
       this.jB_Ataque1.addActionListener(al);
       this.jB_Ataque2.addActionListener(al);
       this.jB_Ataque3.addActionListener(al);
       this.jB_Ataque4.addActionListener(al);
    }
    public void setVistaAtaque(Pokemon pokemon){
        MovimientoAprendido[] movimientos = pokemon.getMovimientos();
        this.setjL_PP1(movimientos[0].getCantidad_pp(), movimientos[0].getPuntos_poder_restantes());
        this.setjL_PP2(movimientos[1].getCantidad_pp(), movimientos[1].getPuntos_poder_restantes());
        this.setjL_PP3(movimientos[2].getCantidad_pp(), movimientos[2].getPuntos_poder_restantes());
        this.setjL_PP4(movimientos[3].getCantidad_pp(), movimientos[3].getPuntos_poder_restantes());
        this.setjL_Potencia1(movimientos[0].getPotencia());
        this.setjL_Potencia2(movimientos[1].getPotencia());
        this.setjL_Potencia3(movimientos[2].getPotencia());
        this.setjL_Potencia4(movimientos[3].getPotencia());
        this.setjL_Precision1(movimientos[0].getPrecision());
        this.setjL_Precision2(movimientos[1].getPrecision());
        this.setjL_Precision3(movimientos[2].getPrecision());
        this.setjL_Precision4(movimientos[3].getPrecision());
        this.setjB_Ataque1(movimientos[0].getNombre());
        this.setjB_Ataque2(movimientos[1].getNombre());
        this.setjB_Ataque3(movimientos[2].getNombre());
        this.setjB_Ataque4(movimientos[3].getNombre());
    }
    public void desactivarAtaque(int posicion){
        if(posicion == 0) this.jB_Ataque1.setEnabled(false);
        if(posicion == 1) this.jB_Ataque2.setEnabled(false);
        if(posicion == 2) this.jB_Ataque3.setEnabled(false);
        if(posicion == 3) this.jB_Ataque4.setEnabled(false);
    }
    public void activarAtaques(){
        this.jB_Ataque1.setEnabled(true);
        this.jB_Ataque2.setEnabled(true);
        this.jB_Ataque3.setEnabled(true);
        this.jB_Ataque4.setEnabled(true);
    }
    public void setjL_PP1(int pp, int restante){
        jL_PP1.setText(Integer.toString(restante)+" / "+Integer.toString(pp));
    }
    public void setjL_PP2(int pp, int restante){
        jL_PP2.setText(Integer.toString(restante)+" / "+Integer.toString(pp));
    }
    public void setjL_PP3(int pp, int restante){
        jL_PP3.setText(Integer.toString(restante)+" / "+Integer.toString(pp));
    }
    public void setjL_PP4(int pp, int restante){
        jL_PP4.setText(Integer.toString(restante)+" / "+Integer.toString(pp));
    }
    public void setjL_Potencia1(int potencia){
        jL_Potencia1.setText(Integer.toString(potencia));
    }
    public void setjL_Potencia2(int potencia){
        jL_Potencia2.setText(Integer.toString(potencia));
    }
    public void setjL_Potencia3(int potencia){
        jL_Potencia3.setText(Integer.toString(potencia));
    }
    public void setjL_Potencia4(int potencia){
        jL_Potencia4.setText(Integer.toString(potencia));
    }
    public void setjL_Precision1(int precision){
        jL_Precision1.setText(Integer.toString(precision));
    }
    public void setjL_Precision2(int precision){
        jL_Precision2.setText(Integer.toString(precision));
    }
    public void setjL_Precision3(int precision){
        jL_Precision3.setText(Integer.toString(precision));
    }
    public void setjL_Precision4(int precision){
        jL_Precision4.setText(Integer.toString(precision));
    }
    public void setjB_Ataque1(String ataque){
        jB_Ataque1.setText(ataque);
    }
    public void setjB_Ataque2(String ataque){
        jB_Ataque2.setText(ataque);
    }
    public void setjB_Ataque3(String ataque){
        jB_Ataque3.setText(ataque);
    }
    public void setjB_Ataque4(String ataque){
        jB_Ataque4.setText(ataque);
    }
    public JButton getBotonAtaque1(){
        return this.jB_Ataque1;
    }
    public JButton getBotonAtaque2(){
        return this.jB_Ataque2;
    }
    public JButton getBotonAtaque3(){
        return this.jB_Ataque3;
    }
    public JButton getBotonAtaque4(){
        return this.jB_Ataque4;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Ataque1;
    private javax.swing.JButton jB_Ataque2;
    private javax.swing.JButton jB_Ataque3;
    private javax.swing.JButton jB_Ataque4;
    private javax.swing.JLabel jL_PP1;
    private javax.swing.JLabel jL_PP2;
    private javax.swing.JLabel jL_PP3;
    private javax.swing.JLabel jL_PP4;
    private javax.swing.JLabel jL_Potencia1;
    private javax.swing.JLabel jL_Potencia2;
    private javax.swing.JLabel jL_Potencia3;
    private javax.swing.JLabel jL_Potencia4;
    private javax.swing.JLabel jL_Precision1;
    private javax.swing.JLabel jL_Precision2;
    private javax.swing.JLabel jL_Precision3;
    private javax.swing.JLabel jL_Precision4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
