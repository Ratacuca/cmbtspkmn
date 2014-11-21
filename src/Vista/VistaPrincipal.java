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
        jB_SimularTorneo = new javax.swing.JButton();
        jB_crear_entrenador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jC_TipoSimulacion = new javax.swing.JComboBox();
        jC_Entrenador1 = new javax.swing.JComboBox();
        jB_CargarEntrenador1 = new javax.swing.JButton();
        jC_Entrenador2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jC_TipoTorneo = new javax.swing.JComboBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Combates Pokémon");

        jB_SimularCombate.setText("Simular Combate");
        jB_SimularCombate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SimularCombateActionPerformed(evt);
            }
        });

        jB_SimularTorneo.setText("Simular Torneo");

        jB_crear_entrenador.setText("Crear Entrenador");

        jLabel2.setText("Entrenador Actual:");

        jLabel4.setText("Tipo:");

        jC_TipoSimulacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario/Sistema (Simulado)", "Usuario/Usuario (Turnos)", "Usuario/Sistema (Turnos)" }));

        jB_CargarEntrenador1.setText("Cargar Entrenadores");

        jLabel5.setText("Oponente (Segundo Jugador):");

        jLabel6.setText("Tipo:");

        jC_TipoTorneo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Participantes al azar", "Enfrentar mas fuertes", "Enfrentar mas debiles", "Simular ganador por region" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_SimularCombate)
                            .addComponent(jB_SimularTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jC_TipoTorneo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jC_TipoSimulacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jB_CargarEntrenador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jC_Entrenador2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jC_Entrenador1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB_crear_entrenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)
                        .addGap(0, 254, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_SimularCombate)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jC_TipoSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_SimularTorneo)
                            .addComponent(jLabel6)
                            .addComponent(jC_TipoTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jC_Entrenador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jC_Entrenador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jB_CargarEntrenador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_crear_entrenador)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_SimularCombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SimularCombateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_SimularCombateActionPerformed

   public void agregarListener(ActionListener al) {
       this.jB_SimularCombate.addActionListener(al);
       this.jB_crear_entrenador.addActionListener(al);
       this.jB_CargarEntrenador1.addActionListener(al);
       this.jB_SimularTorneo.addActionListener(al);
       
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
   public JButton getBotonCargarEntrenador1(){
       return jB_CargarEntrenador1;
   }
   public JButton getBotonSimularTorneo(){
       return jB_SimularTorneo;
   }
   
   
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_CargarEntrenador1;
    private javax.swing.JButton jB_SimularCombate;
    private javax.swing.JButton jB_SimularTorneo;
    private javax.swing.JButton jB_crear_entrenador;
    private javax.swing.JComboBox jC_Entrenador1;
    private javax.swing.JComboBox jC_Entrenador2;
    private javax.swing.JComboBox jC_TipoSimulacion;
    private javax.swing.JComboBox jC_TipoTorneo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox getjC_Entrenador1() {
        return jC_Entrenador1;
    }
    public javax.swing.JComboBox getjC_Entrenador2() {
        return jC_Entrenador2;
    }

    public void setjC_Entrenador1(String entrenador) {
        this.jC_Entrenador1.addItem(entrenador);
    }
    public void setjC_Entrenador2(String entrenador) {
        this.jC_Entrenador2.addItem(entrenador);
    }
    public void removerJc_Entrenador1(){
        this.jC_Entrenador1.removeAllItems();
    }
    public void removerJc_Entrenador2(){
        this.jC_Entrenador2.removeAllItems();
    }
    public String getjC_Nombre1(){
        return this.jC_Entrenador1.getSelectedItem().toString();
    }
    public String getjC_Nombre2(){
        return this.jC_Entrenador2.getSelectedItem().toString();
    }
    public int getjC_TipoTorneo(){
        return jC_TipoTorneo.getSelectedIndex();
    }
    public javax.swing.JButton getjB_SimularTorneo() {
        return jB_SimularTorneo;
    }
}

