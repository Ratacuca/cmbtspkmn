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
public class VistaLobbyMedallas extends javax.swing.JFrame {

    /**
     * Creates new form VistaLobbyMedallas
     */
    public VistaLobbyMedallas() {
        initComponents();
    }
    public void agregarListener(ActionListener al) {
       this.jB_Aleatorio.addActionListener(al);
       this.jB_CombatirSeleccionPropia.addActionListener(al);
       this.jB_Hoenn.addActionListener(al);
       this.jB_Johto.addActionListener(al);
       this.jB_Kalos.addActionListener(al);
       this.jB_Kanto.addActionListener(al);
       this.jB_Sinnoh.addActionListener(al);
       this.jB_Teselia.addActionListener(al);
    }
    public JButton getjB_Aleatorio(){
        return this.jB_Aleatorio;
    }
    public JButton getjB_CombatirSeleccionPropia(){
        return this.jB_CombatirSeleccionPropia;
    }
    public JButton getjB_Hoenn(){
        return this.jB_Hoenn;
    }
    public JButton getjB_Johto(){
        return this.jB_Johto;
    }
    public JButton getjB_Kalos(){
        return this.jB_Kalos;
    }
    public JButton getjB_Kanto(){
        return this.jB_Kanto;
    }
    public JButton getjB_Sinnoh(){
        return this.jB_Sinnoh;
    }
    public JButton getjB_Teselia(){
        return this.jB_Teselia;
    }
    public String getJL_lider1(){
        return jL_Lider1.getSelectedValue().toString(); 
    }
    public String getJL_lider2(){
        return jL_Lider2.getSelectedValue().toString(); 
    }
    public String getJL_lider3(){
        return jL_Lider3.getSelectedValue().toString(); 
    }
    public String getJL_lider4(){
        return jL_Lider4.getSelectedValue().toString(); 
    }
    public String getJL_lider5(){
        return jL_Lider5.getSelectedValue().toString(); 
    }
    public String getJL_lider6(){
        return jL_Lider6.getSelectedValue().toString(); 
    }
    public String getJL_lider7(){
        return jL_Lider7.getSelectedValue().toString(); 
    }
    public String getJL_lider8(){
        return jL_Lider8.getSelectedValue().toString(); 
    }
    public int getJL_indexLider1(){
       return this.jL_Lider1.getSelectedIndex();
    }
    public int getJL_indexLider2(){
       return this.jL_Lider2.getSelectedIndex();
    }
    public int getJL_indexLider3(){
       return this.jL_Lider3.getSelectedIndex();
    }
    public int getJL_indexLider4(){
       return this.jL_Lider4.getSelectedIndex();
    }
    public int getJL_indexLider5(){
       return this.jL_Lider5.getSelectedIndex();
    }
    public int getJL_indexLider6(){
       return this.jL_Lider6.getSelectedIndex();
    }
    public int getJL_indexLider7(){
       return this.jL_Lider7.getSelectedIndex();
    }
    public int getJL_indexLider8(){
       return this.jL_Lider8.getSelectedIndex();
    }
    public void setJL_lider1(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider1.setModel(modelo);   
    }
    public void setJL_lider2(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider2.setModel(modelo);   
    }
    public void setJL_lider3(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider3.setModel(modelo);   
    }
    public void setJL_lider4(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider4.setModel(modelo);   
    }
    public void setJL_lider5(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider5.setModel(modelo);   
    }
    public void setJL_lider6(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider6.setModel(modelo);   
    }
    public void setJL_lider7(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider7.setModel(modelo);   
    }
    public void setJL_lider8(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Lider8.setModel(modelo);   
    }
    public void setJL_Kanto(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Kanto.setModel(modelo);   
    }
    public void setJL_Johto(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Johto.setModel(modelo);   
    }
    public void setJL_Hoenn(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Hoenn.setModel(modelo);   
    }
    public void setJL_Teselia(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Teselia.setModel(modelo);   
    }
    public void setJL_Sinnoh(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Sinnoh.setModel(modelo);   
    }
    public void setJL_Kalos(ArrayList<String> valor){
       DefaultListModel modelo = new DefaultListModel();
       for (int i = 0; i < valor.size(); i++) {
          modelo.addElement(valor.get(i)); 
       }
       this.jL_Kalos.setModel(modelo);   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jL_Lider1 = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jL_Lider2 = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        jL_Lider3 = new javax.swing.JList();
        jScrollPane10 = new javax.swing.JScrollPane();
        jL_Lider4 = new javax.swing.JList();
        jScrollPane11 = new javax.swing.JScrollPane();
        jL_Lider5 = new javax.swing.JList();
        jScrollPane12 = new javax.swing.JScrollPane();
        jL_Lider6 = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jL_Lider7 = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        jL_Lider8 = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jB_CombatirSeleccionPropia = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_Kanto = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jL_Johto = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jL_Hoenn = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jL_Sinnoh = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jL_Teselia = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jL_Kalos = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jB_Kanto = new javax.swing.JButton();
        jB_Johto = new javax.swing.JButton();
        jB_Hoenn = new javax.swing.JButton();
        jB_Sinnoh = new javax.swing.JButton();
        jB_Teselia = new javax.swing.JButton();
        jB_Kalos = new javax.swing.JButton();
        jB_Aleatorio = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Obtencion de Medallas");

        jLabel3.setText("Seleccione la forma de obtencion de las 8 medallas:");

        jL_Lider1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jL_Lider1);

        jLabel9.setText("Primer Lider");

        jL_Lider2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(jL_Lider2);

        jL_Lider3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(jL_Lider3);

        jL_Lider4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane10.setViewportView(jL_Lider4);

        jL_Lider5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane11.setViewportView(jL_Lider5);

        jL_Lider6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane12.setViewportView(jL_Lider6);

        jLabel10.setText("Segundo Lider");

        jLabel11.setText("Tercer Lider");

        jLabel12.setText("Cuarto Lider");

        jLabel13.setText("Quinto Lider");

        jLabel14.setText("Sexto Lider");

        jL_Lider7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane13.setViewportView(jL_Lider7);

        jL_Lider8.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane14.setViewportView(jL_Lider8);

        jLabel15.setText("Septimo Lider");

        jLabel16.setText("Octavo Lider");

        jB_CombatirSeleccionPropia.setText("Combatir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_CombatirSeleccionPropia)
                .addGap(423, 423, 423))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jB_CombatirSeleccionPropia)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Seleccion Propia", jPanel2);

        jScrollPane1.setViewportView(jL_Kanto);

        jLabel1.setText("Kanto");

        jScrollPane3.setViewportView(jL_Johto);

        jScrollPane4.setViewportView(jL_Hoenn);

        jScrollPane5.setViewportView(jL_Sinnoh);

        jScrollPane6.setViewportView(jL_Teselia);

        jScrollPane7.setViewportView(jL_Kalos);

        jLabel4.setText("Johto");

        jLabel5.setText("Hoenn");

        jLabel6.setText("Sinnoh");

        jLabel7.setText("Teselia");

        jLabel8.setText("Kalos");

        jB_Kanto.setText("Combatir");

        jB_Johto.setText("Combatir");

        jB_Hoenn.setText("Combatir");

        jB_Sinnoh.setText("Combatir");

        jB_Teselia.setText("Combatir");
        jB_Teselia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_TeseliaActionPerformed(evt);
            }
        });

        jB_Kalos.setText("Combatir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB_Kanto, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_Johto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_Hoenn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jB_Sinnoh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jB_Teselia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jB_Kalos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Kanto)
                    .addComponent(jB_Johto)
                    .addComponent(jB_Hoenn)
                    .addComponent(jB_Sinnoh)
                    .addComponent(jB_Teselia)
                    .addComponent(jB_Kalos))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Region", jPanel1);

        jB_Aleatorio.setText("Aleatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Aleatorio)
                .addGap(434, 434, 434))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_Aleatorio)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_TeseliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_TeseliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_TeseliaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaLobbyMedallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLobbyMedallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLobbyMedallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLobbyMedallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLobbyMedallas().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Aleatorio;
    private javax.swing.JButton jB_CombatirSeleccionPropia;
    private javax.swing.JButton jB_Hoenn;
    private javax.swing.JButton jB_Johto;
    private javax.swing.JButton jB_Kalos;
    private javax.swing.JButton jB_Kanto;
    private javax.swing.JButton jB_Sinnoh;
    private javax.swing.JButton jB_Teselia;
    private javax.swing.JList jL_Hoenn;
    private javax.swing.JList jL_Johto;
    private javax.swing.JList jL_Kalos;
    private javax.swing.JList jL_Kanto;
    private javax.swing.JList jL_Lider1;
    private javax.swing.JList jL_Lider2;
    private javax.swing.JList jL_Lider3;
    private javax.swing.JList jL_Lider4;
    private javax.swing.JList jL_Lider5;
    private javax.swing.JList jL_Lider6;
    private javax.swing.JList jL_Lider7;
    private javax.swing.JList jL_Lider8;
    private javax.swing.JList jL_Sinnoh;
    private javax.swing.JList jL_Teselia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
