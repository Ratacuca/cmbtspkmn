/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 *
 * @author Mario Caceres
 */
public class VistaNuevosMovimientos extends javax.swing.JFrame {

    /**
     * Creates new form VistaNuevosMovimientos
     */
    public VistaNuevosMovimientos() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_Movimiento1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jL_Movimiento3 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jL_Movimiento2 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jL_Movimiento4 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jB_listo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Movimientos");

        jL_Movimiento1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jL_Movimiento1);

        jL_Movimiento3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jL_Movimiento3);

        jL_Movimiento2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jL_Movimiento2);

        jL_Movimiento4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jL_Movimiento4);

        jLabel2.setText("Movimiento 1");

        jLabel3.setText("Movimiento 2");

        jLabel4.setText("Movimiento 3");

        jLabel5.setText("Movimiento 4");

        jB_listo.setText("Listo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jB_listo)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jB_listo)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaNuevosMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaNuevosMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaNuevosMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaNuevosMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaNuevosMovimientos().setVisible(true);
            }
        });
    }
    public void agregarListener(ActionListener al) {
        this.jB_listo.addActionListener(al);
    }
    public void setJL_movimientos1(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Movimiento1.setModel(modelo);   
   }
   public void setJL_movimientos2(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Movimiento2.setModel(modelo);   
   }
   public void setJL_movimientos3(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Movimiento3.setModel(modelo);   
   }
   public void setJL_movimientos4(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Movimiento4.setModel(modelo);   
   }
   public String getJL_Movimiento1(){
       if (jL_Movimiento1.getSelectedIndex() == -1){
          return jL_Movimiento1.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Movimiento1.getSelectedValue().toString();  
       }
    }
   public String getJL_Movimiento2(){
       if (jL_Movimiento2.getSelectedIndex() == -1){
          return jL_Movimiento2.getModel().getElementAt(1).toString();
       }
       else{
         return jL_Movimiento2.getSelectedValue().toString();  
       }
    }
   public String getJL_Movimiento3(){
       if (jL_Movimiento3.getSelectedIndex() == -1){
          return jL_Movimiento3.getModel().getElementAt(2).toString();
       }
       else{
         return jL_Movimiento3.getSelectedValue().toString();  
       }
    }
   public String getJL_Movimiento4(){
       if (jL_Movimiento4.getSelectedIndex() == -1){
          return jL_Movimiento4.getModel().getElementAt(3).toString();
       }
       else{
         return jL_Movimiento4.getSelectedValue().toString();  
       }
    }
   public JButton getjB_Listo(){
        return this.jB_listo;
    }
   public void limpiarListas(){
       this.jL_Movimiento1.clearSelection();
       this.jL_Movimiento2.clearSelection();
       this.jL_Movimiento3.clearSelection();
       this.jL_Movimiento4.clearSelection();
   }
   
   public int getJL_indexMovimiento1(){
       return this.jL_Movimiento1.getSelectedIndex();
   }
   public int getJL_indexMovimiento2(){
       return this.jL_Movimiento2.getSelectedIndex();
   }
   public int getJL_indexMovimiento3(){
       return this.jL_Movimiento3.getSelectedIndex();
   }
   public int getJL_indexMovimiento4(){
       return this.jL_Movimiento4.getSelectedIndex();
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_listo;
    private javax.swing.JList jL_Movimiento1;
    private javax.swing.JList jL_Movimiento2;
    private javax.swing.JList jL_Movimiento3;
    private javax.swing.JList jL_Movimiento4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
