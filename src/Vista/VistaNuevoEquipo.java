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
public class VistaNuevoEquipo extends javax.swing.JFrame {

    /**
     * Creates new form VistaNuevoEquipo
     */
    public VistaNuevoEquipo() {
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
        jL_Pokemon1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jL_Pokemon2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jL_Pokemon6 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jL_Pokemon4 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jL_Pokemon5 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jL_Pokemon3 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jB_movimientos1 = new javax.swing.JButton();
        jB_movimientos2 = new javax.swing.JButton();
        jB_movimientos3 = new javax.swing.JButton();
        jB_movimientos4 = new javax.swing.JButton();
        jB_movimientos5 = new javax.swing.JButton();
        jB_movimientos6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jB_Listo = new javax.swing.JButton();
        jS_Nivel1 = new javax.swing.JSpinner();
        jS_Nivel2 = new javax.swing.JSpinner();
        jS_Nivel3 = new javax.swing.JSpinner();
        jS_Nivel4 = new javax.swing.JSpinner();
        jS_Nivel5 = new javax.swing.JSpinner();
        jS_Nivel6 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jL_Pokemon1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jL_Pokemon1);

        jL_Pokemon2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jL_Pokemon2);

        jL_Pokemon6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jL_Pokemon6);

        jL_Pokemon4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jL_Pokemon4);

        jL_Pokemon5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jL_Pokemon5);

        jL_Pokemon3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jL_Pokemon3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Modificar Equipo");

        jB_movimientos1.setText("Movimientos");

        jB_movimientos2.setText("Movimientos");

        jB_movimientos3.setText("Movimientos");

        jB_movimientos4.setText("Movimientos");

        jB_movimientos5.setText("Movimientos");

        jB_movimientos6.setText("Movimientos");

        jLabel2.setText("Pokemon 1");

        jLabel3.setText("Pokemon 2");

        jLabel4.setText("Pokemon 3");

        jLabel5.setText("Pokemon 4");

        jLabel6.setText("Pokemon 5");

        jLabel7.setText("Pokemon 6");

        jB_Listo.setText("Listo");

        jS_Nivel1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jS_Nivel2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jS_Nivel3.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jS_Nivel4.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jS_Nivel5.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jS_Nivel6.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel8.setText("Nivel");

        jLabel9.setText("Nivel");

        jLabel10.setText("Nivel");

        jLabel11.setText("Nivel");

        jLabel12.setText("Nivel");

        jLabel13.setText("Nivel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jS_Nivel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jB_movimientos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jB_movimientos2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(jS_Nivel2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jB_movimientos3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(jS_Nivel3)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jB_movimientos4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jS_Nivel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB_movimientos5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(jS_Nivel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB_movimientos6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jS_Nivel6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jB_Listo)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_movimientos1)
                    .addComponent(jB_movimientos2)
                    .addComponent(jB_movimientos3)
                    .addComponent(jB_movimientos4)
                    .addComponent(jB_movimientos5)
                    .addComponent(jB_movimientos6))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jS_Nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_Nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_Nivel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_Nivel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_Nivel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jB_Listo)
                .addGap(46, 46, 46))
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
            java.util.logging.Logger.getLogger(VistaNuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaNuevoEquipo().setVisible(true);
            }
        });
    }
    public void agregarListener(ActionListener al) {
       this.getjB_Listo().addActionListener(al);
       this.getjB_movimientos1().addActionListener(al);
       this.getjB_movimientos2().addActionListener(al);
       this.getjB_movimientos3().addActionListener(al);
       this.getjB_movimientos4().addActionListener(al);
       this.getjB_movimientos5().addActionListener(al);
       this.getjB_movimientos6().addActionListener(al);
    }
    public int getjS_Nivel1(){
        return (Integer)jS_Nivel1.getValue();
    }
    public int getjS_Nivel2(){
        return (Integer)jS_Nivel2.getValue();
    }
    public int getjS_Nivel3(){
        return (Integer)jS_Nivel3.getValue();
    }
    public int getjS_Nivel4(){
        return (Integer)jS_Nivel4.getValue();
    }
    public int getjS_Nivel5(){
        return (Integer)jS_Nivel5.getValue();
    }
    public int getjS_Nivel6(){
        return (Integer)jS_Nivel6.getValue();
    }
    public JButton getjB_movimientos1(){
        return this.jB_movimientos1;
    }
    public JButton getjB_movimientos2(){
        return this.jB_movimientos2;
    }
    public JButton getjB_movimientos3(){
        return this.jB_movimientos3;
    }
    public JButton getjB_movimientos4(){
        return this.jB_movimientos4;
    }
    public JButton getjB_movimientos5(){
        return this.jB_movimientos5;
    }
    public JButton getjB_movimientos6(){
        return this.jB_movimientos6;
    }
    public JButton getjB_Listo(){
        return this.jB_Listo;
    }
    public String getJL_Pokemon1(){
       if (jL_Pokemon1.getSelectedIndex() == -1){
          return jL_Pokemon1.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon1.getSelectedValue().toString();  
       }
    }
   public String getJL_Pokemon2(){
       if (jL_Pokemon2.getSelectedIndex() == -1){
          return jL_Pokemon2.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon2.getSelectedValue().toString();  
       }
    }
   public String getJL_Pokemon3(){
       if (jL_Pokemon3.getSelectedIndex() == -1){
          return jL_Pokemon3.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon3.getSelectedValue().toString();  
       }
    }
   public String getJL_Pokemon4(){
       if (jL_Pokemon4.getSelectedIndex() == -1){
          return jL_Pokemon4.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon4.getSelectedValue().toString();  
       }
    }
   public String getJL_Pokemon5(){
       if (jL_Pokemon5.getSelectedIndex() == -1){
          return jL_Pokemon5.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon5.getSelectedValue().toString();  
       }
    }
   public String getJL_Pokemon6(){
       if (jL_Pokemon6.getSelectedIndex() == -1){
          return jL_Pokemon6.getModel().getElementAt(0).toString();
       }
       else{
         return jL_Pokemon6.getSelectedValue().toString();  
       }
    }
   public void setJL_Pokemon1(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon1.setModel(modelo);   
   }
   public void setJL_Pokemon2(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon2.setModel(modelo);   
   }
   public void setJL_Pokemon3(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon3.setModel(modelo);   
   }
   public void setJL_Pokemon4(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon4.setModel(modelo);   
   }
   public void setJL_Pokemon5(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon5.setModel(modelo);   
   }
   public void setJL_Pokemon6(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Pokemon6.setModel(modelo);   
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Listo;
    private javax.swing.JButton jB_movimientos1;
    private javax.swing.JButton jB_movimientos2;
    private javax.swing.JButton jB_movimientos3;
    private javax.swing.JButton jB_movimientos4;
    private javax.swing.JButton jB_movimientos5;
    private javax.swing.JButton jB_movimientos6;
    private javax.swing.JList jL_Pokemon1;
    private javax.swing.JList jL_Pokemon2;
    private javax.swing.JList jL_Pokemon3;
    private javax.swing.JList jL_Pokemon4;
    private javax.swing.JList jL_Pokemon5;
    private javax.swing.JList jL_Pokemon6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jS_Nivel1;
    private javax.swing.JSpinner jS_Nivel2;
    private javax.swing.JSpinner jS_Nivel3;
    private javax.swing.JSpinner jS_Nivel4;
    private javax.swing.JSpinner jS_Nivel5;
    private javax.swing.JSpinner jS_Nivel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
