package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import modelo.Asiento;
import modelo.Colectivo;
import persistencia.AsientoData;
import persistencia.ColectivoData;

public class VistaAsiento extends javax.swing.JInternalFrame {

    private AsientoData ad;
    SpinnerModel sm = new SpinnerNumberModel(1, 1, 80, 1);

    public VistaAsiento() {
        initComponents();
        ad = new AsientoData(Principal.conexion);

        SpinnerNroAsiento.setModel(sm);
        SpinnerNroAsientoEditar.setModel(sm);

        vaciarCampos();
        cargarCombo();

        modificarBTN.setEnabled(false);
        eliminarBTN.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkActivo = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        SpinnerNroAsiento = new javax.swing.JSpinner();
        ComboBoxColectivos = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        idAsientotxt = new javax.swing.JTextField();
        buscarBTN = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        modificarBTN = new javax.swing.JButton();
        eliminarBTN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        checkActivoEditar = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ComboBoxColectivosEditar = new javax.swing.JComboBox<>();
        SpinnerNroAsientoEditar = new javax.swing.JSpinner();

        jLabel2.setText("jLabel2");

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nuevo Asiento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 52, 69));
        jLabel3.setText("Colectivo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 52, 69));
        jLabel4.setText("Numero asiento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 52, 69));
        jLabel7.setText("Activo:");

        SpinnerNroAsiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ComboBoxColectivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnCargar.setBackground(new java.awt.Color(52, 142, 110));
        btnCargar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setText("CARGAR");
        btnCargar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCargar.addActionListener(this::btnCargarActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(ComboBoxColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(SpinnerNroAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkActivo)))
                        .addGap(92, 92, 92))))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SpinnerNroAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(checkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 52, 69));
        jPanel2.setPreferredSize(new java.awt.Dimension(329, 74));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE ASIENTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nuevo Asiento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Buscar Asiento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(38, 52, 69))); // NOI18N

        idAsientotxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        buscarBTN.setBackground(new java.awt.Color(46, 116, 189));
        buscarBTN.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buscarBTN.setForeground(new java.awt.Color(255, 255, 255));
        buscarBTN.setText("BUSCAR");
        buscarBTN.addActionListener(this::buscarBTNActionPerformed);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(38, 52, 69));
        jLabel15.setText("Indique un ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idAsientotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idAsientotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        modificarBTN.setBackground(new java.awt.Color(197, 140, 49));
        modificarBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        modificarBTN.setForeground(new java.awt.Color(255, 255, 255));
        modificarBTN.setText("EDITAR");
        modificarBTN.setPreferredSize(new java.awt.Dimension(90, 30));
        modificarBTN.addActionListener(this::modificarBTNActionPerformed);

        eliminarBTN.setBackground(new java.awt.Color(194, 76, 80));
        eliminarBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eliminarBTN.setForeground(new java.awt.Color(255, 255, 255));
        eliminarBTN.setText("ELIMINAR");
        eliminarBTN.setPreferredSize(new java.awt.Dimension(90, 30));
        eliminarBTN.addActionListener(this::eliminarBTNActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 52, 69));
        jLabel6.setText("Numero asiento:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 52, 69));
        jLabel8.setText("Activo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 52, 69));
        jLabel9.setText("Colectivo:");

        ComboBoxColectivosEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        SpinnerNroAsientoEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(modificarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxColectivosEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkActivoEditar)
                                    .addComponent(SpinnerNroAsientoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(eliminarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(ComboBoxColectivosEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(SpinnerNroAsientoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8))
                    .addComponent(checkActivoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed

        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos!");
            return;
        }

        Colectivo colectivo = (Colectivo) ComboBoxColectivos.getSelectedItem();
        int nroAsiento = (int) SpinnerNroAsiento.getValue();
        boolean activo = checkActivo.isSelected();

        if (colectivo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un colectivo!");
            return;
        }
        
        if (nroAsiento <= 0 || nroAsiento > colectivo.getCapacidad()) {
            JOptionPane.showMessageDialog(this, "El número de asiento debe estar entre 1 y " + colectivo.getCapacidad());
            return;
        }
        Asiento asiento = new Asiento(colectivo, nroAsiento, activo);
        ad.crearAsiento(asiento);

        vaciarCampos();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void modificarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBTNActionPerformed
        int id;

        try {
            id = Integer.parseInt(idAsientotxt.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor que cero.");
                return;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.");
            return;
        }
        
        Colectivo colectivo = (Colectivo) ComboBoxColectivosEditar.getSelectedItem();
        int nroAsiento = (Integer) SpinnerNroAsientoEditar.getValue();
        boolean activo = checkActivoEditar.isSelected();
        
        if (colectivo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un colectivo!");
            return;
        }

        if (nroAsiento <= 0 || nroAsiento > colectivo.getCapacidad()) {
            JOptionPane.showMessageDialog(this, "El número de asiento debe estar entre 1 y " + colectivo.getCapacidad());
            return;
        }
        
        if (ad.buscarAsiento(id) == null) {
            JOptionPane.showMessageDialog(this, "El asiento no existe.");
            return;
        }

        if (esIgual(id)) {
            JOptionPane.showMessageDialog(this, "Debe modificar al menos un campo!");
            return;
        }
        
        Asiento asientoModificado = new Asiento(Integer.parseInt(idAsientotxt.getText()), colectivo, nroAsiento, activo);

        boolean a = ad.actualizarAsiento(asientoModificado);

        if (a) {
            JOptionPane.showMessageDialog(this, "Asiento editado con éxito!");

            vaciarCampos();
            modificarBTN.setEnabled(false);
            eliminarBTN.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Asiento ya existente! intente otro diferente.");
        }
    }//GEN-LAST:event_modificarBTNActionPerformed

    private void eliminarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBTNActionPerformed
        int idAsiento;

        try {
            idAsiento = Integer.parseInt(idAsientotxt.getText().trim());

            if (idAsiento <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor que cero.");
                return;
            }

        }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.");
                return;
        }
        
        if (ad.buscarAsiento(idAsiento) == null) {
            JOptionPane.showMessageDialog(this, "No existe un asiento con ese ID.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar el asiento con ID: " + idAsiento + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }
        
        boolean a = ad.eliminarAsiento(idAsiento);

        if (a) {
            JOptionPane.showMessageDialog(this, "Asiento eliminado!");
            
            vaciarCampos();
            modificarBTN.setEnabled(false);
            eliminarBTN.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error y no se pudo editar el asiento.");
        }
    }//GEN-LAST:event_eliminarBTNActionPerformed

    private void buscarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBTNActionPerformed

        if (idAsientotxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID!");
            return;
        }

        try {
            int id = Integer.parseInt(idAsientotxt.getText());
            
            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor que cero.");
                modificarBTN.setEnabled(false);
                eliminarBTN.setEnabled(false);
                return;
            }
            
            Asiento asiento = ad.buscarAsiento(id);

            if (asiento == null) {
                JOptionPane.showMessageDialog(this, "No se encontraron asientos con ese ID, intente otro");
                modificarBTN.setEnabled(false);
                eliminarBTN.setEnabled(false);
                return;
            } else {
                modificarBTN.setEnabled(true);
                eliminarBTN.setEnabled(true);
            }
            
            ComboBoxColectivosEditar.setSelectedItem(asiento.getColectivo());
            SpinnerNroAsientoEditar.setValue(asiento.getNumeroAsiento());
            checkActivoEditar.setSelected(asiento.getEstado());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un numero en ID!", "Error", 2);
            return;
        }

    }//GEN-LAST:event_buscarBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Colectivo> ComboBoxColectivos;
    private javax.swing.JComboBox<Colectivo> ComboBoxColectivosEditar;
    private javax.swing.JSpinner SpinnerNroAsiento;
    private javax.swing.JSpinner SpinnerNroAsientoEditar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JCheckBox checkActivoEditar;
    private javax.swing.JButton eliminarBTN;
    private javax.swing.JTextField idAsientotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton modificarBTN;
    // End of variables declaration//GEN-END:variables

    public void cargarCombo() {

        ColectivoData cd = new ColectivoData(Principal.conexion);

        for (Colectivo colectivo : cd.listarColectivo()) {
            ComboBoxColectivos.addItem(colectivo);
            ComboBoxColectivosEditar.addItem(colectivo);
        }

    }

    public boolean camposVacios() {
        if (ComboBoxColectivos.getSelectedIndex() == -1 || (int) SpinnerNroAsiento.getValue() == 0) {
            return true;
        }

        return false;
    }

    public void vaciarCampos() {
        ComboBoxColectivos.setSelectedIndex(-1);
        ComboBoxColectivosEditar.setSelectedIndex(-1);
        SpinnerNroAsiento.setValue(0);
        SpinnerNroAsientoEditar.setValue(0);
        checkActivo.setSelected(false);
        checkActivoEditar.setSelected(false);
        idAsientotxt.setText("");
    }

    public boolean esIgual(int id) {

        Asiento asiento = ad.buscarAsiento(id);

        if (asiento == null) {
            return false;
        }

        Colectivo colectivo = (Colectivo) ComboBoxColectivosEditar.getSelectedItem();

        if (colectivo == null || asiento.getColectivo() == null) {
            return false;
        }

        if (asiento.getColectivo().getID_colectivo() != colectivo.getID_colectivo()) {
            return false;
        }

        if (asiento.getNumeroAsiento() != (Integer) SpinnerNroAsientoEditar.getValue()) {
            return false;
        }

        if (asiento.getEstado() != checkActivoEditar.isSelected()) {
            return false;
        }

        return true;
    }

}
