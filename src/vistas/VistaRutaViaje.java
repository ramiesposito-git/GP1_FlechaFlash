package vistas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Colectivo;
import modelo.RutaViaje;
import persistencia.ColectivoData;
import persistencia.RutaViajeData;


public class VistaRutaViaje extends javax.swing.JInternalFrame {

    private RutaViajeData rvd; 
    private ColectivoData cd;
    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
    
    public VistaRutaViaje() {
        initComponents();
        rvd = new RutaViajeData(Principal.conexion);
        cd = new ColectivoData(Principal.conexion);
        cargarComboColectivos();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        comboxIdColectivo = new javax.swing.JComboBox<>();
        checkEstado = new javax.swing.JCheckBox();
        txtPrecio = new javax.swing.JTextField();
        txtHoraLlegada = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtIdRuta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtOrigenBuscar = new javax.swing.JTextField();
        txtDestinoBuscar = new javax.swing.JTextField();
        txtPrecioBuscar = new javax.swing.JTextField();
        txtHoraSalidaBuscar = new javax.swing.JTextField();
        txtHoraLlegadaBuscar = new javax.swing.JTextField();
        checkEstadoBuscar = new javax.swing.JCheckBox();
        comboxIdColectivoBuscar = new javax.swing.JComboBox<>();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nueva Ruta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 17))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Origen de Viaje:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Destino de Viaje:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Horario de Salida:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Horario de Llegada:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Activo:");

        btnGuardar.setBackground(new java.awt.Color(52, 142, 110));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("CARGAR");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        comboxIdColectivo.addActionListener(this::comboxIdColectivoActionPerformed);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Colectivo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoraLlegada)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHoraSalida)
                                    .addComponent(txtDestino)
                                    .addComponent(txtOrigen)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboxIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkEstado))))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(checkEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboxIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jPanel3.setBackground(new java.awt.Color(38, 52, 69));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARGAR NUEVA RUTA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Eliminar - Editar Ruta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 17))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Buscar Ruta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(46, 116, 189));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        txtIdRuta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Indique el ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnEditar.setBackground(new java.awt.Color(197, 140, 49));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(194, 76, 80));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Origen de Viaje:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Destino de Viaje:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Horario de Salida:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Horario de Llegada:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Precio:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Activo:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Colectivo:");

        comboxIdColectivoBuscar.addActionListener(this::comboxIdColectivoBuscarActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(4, 4, 4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestinoBuscar)
                            .addComponent(txtOrigenBuscar)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHoraSalidaBuscar)
                            .addComponent(txtHoraLlegadaBuscar)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkEstadoBuscar)
                                    .addComponent(comboxIdColectivoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtOrigenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDestinoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtHoraSalidaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHoraLlegadaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(checkEstadoBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboxIdColectivoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboxIdColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxIdColectivoActionPerformed
        
    }//GEN-LAST:event_comboxIdColectivoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        RutaViaje ruta = validarFormulario();
        if (ruta == null) {
            return; 
        }
        
        rvd.guardarRutaViaje(ruta);
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdRuta.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }
 
        RutaViaje ruta = rvd.buscarRutaViajePorId(id);
        if (ruta == null) {
            return;
        }
 
        
        txtOrigenBuscar.setText(ruta.getOrigen());
        txtDestinoBuscar.setText(ruta.getDestino());
        txtHoraSalidaBuscar.setText(ruta.getHoraSalida().format(formatoHora));
        txtHoraLlegadaBuscar.setText(ruta.getHoraLlegada().format(formatoHora));
        txtPrecioBuscar.setText(String.valueOf(ruta.getPrecio()));
        checkEstadoBuscar.setSelected(ruta.isEstado());
        if (ruta.getColectivo() != null) {
            seleccionarColectivo(ruta.getColectivo());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id; 
        try {
            id = Integer.parseInt(txtIdRuta.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido.");
                return;
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico.");
            return;
        }
        
        RutaViaje rutaExistente = rvd.buscarRutaViajePorId(id);

        if (rutaExistente == null) {
            return;
        }

        RutaViaje ruta = validarFormularioEditar();
        if (ruta == null) {
            return;
        }

        ruta.setIdRuta(id);

        rvd.actualizarRutaViaje(ruta);
        limpiarBuscar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdRuta.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico.");
            return;
        }
        
        rvd.borrarRutaViaje(id);
        limpiarBuscar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void comboxIdColectivoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxIdColectivoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxIdColectivoBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox checkEstado;
    private javax.swing.JCheckBox checkEstadoBuscar;
    private javax.swing.JComboBox<Colectivo> comboxIdColectivo;
    private javax.swing.JComboBox<Colectivo> comboxIdColectivoBuscar;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDestinoBuscar;
    private javax.swing.JTextField txtHoraLlegada;
    private javax.swing.JTextField txtHoraLlegadaBuscar;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtHoraSalidaBuscar;
    private javax.swing.JTextField txtIdRuta;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtOrigenBuscar;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioBuscar;
    // End of variables declaration//GEN-END:variables
    
    // Lee y valida el formulario. Devuelve la ruta armada, o null si hay un error
    private RutaViaje validarFormulario() {
        String origen = txtOrigen.getText().trim();
        String destino = txtDestino.getText().trim();
        
        if (origen.isEmpty() || destino.isEmpty() || txtHoraSalida.getText().isEmpty() || txtHoraLlegada.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return null;
        }
        
        if (origen.equalsIgnoreCase(destino)) {
            JOptionPane.showMessageDialog(this, "El origen y el destino no pueden ser iguales.");
            return null;
        }
        
        LocalTime salida;
        LocalTime llegada;
        try {
            salida = LocalTime.parse(txtHoraSalida.getText().trim());
            llegada = LocalTime.parse(txtHoraLlegada.getText().trim());
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Las horas deben tener formato Hora:Minuto (por ejemplo 08:30).");
            return null;
        }
        
        double precio;
        try {
            precio = Double.parseDouble(txtPrecio.getText().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número (por ejemplo 2500.50).");
            return null;
        }
        
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero.");
            return null;
        }
        
        Colectivo colectivo = (Colectivo) comboxIdColectivo.getSelectedItem();
        if (colectivo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un colectivo (si no hay ninguno, cargue uno primero).");
            return null;
        }
        
        RutaViaje ruta = new RutaViaje();
        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setHoraSalida(salida);
        ruta.setHoraLlegada(llegada);
        ruta.setColectivo(colectivo);
        ruta.setPrecio(precio);
        ruta.setEstado(checkEstado.isSelected());
        return ruta;
    }
    
    private void cargarComboColectivos() {
        comboxIdColectivo.removeAllItems();
        comboxIdColectivoBuscar.removeAllItems();

        for (Colectivo colectivo : cd.listarColectivo()) {
            comboxIdColectivo.addItem(colectivo);
            comboxIdColectivoBuscar.addItem(colectivo);
        }
    }
    
    private void limpiar() {
        txtIdRuta.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtHoraSalida.setText("");
        txtHoraLlegada.setText("");
        txtPrecio.setText("");
        checkEstado.setSelected(false);
        if (comboxIdColectivo.getItemCount() > 0) {
            comboxIdColectivo.setSelectedIndex(0);
        }
    }
    
    private void seleccionarColectivo(Colectivo colectivo) {
        for (int i = 0; i < comboxIdColectivoBuscar.getItemCount(); i++) {
            if (comboxIdColectivoBuscar.getItemAt(i).getID_colectivo() == colectivo.getID_colectivo()) {
                comboxIdColectivoBuscar.setSelectedIndex(i);
                return;
            }
        }
        comboxIdColectivo.addItem(colectivo); 
        comboxIdColectivo.setSelectedItem(colectivo);
    }
    
    public boolean esIgual(int id) {
        boolean esIgual = true;

        RutaViaje ruta = rvd.buscarRutaViajePorId(id);

        if (!ruta.getOrigen().equals(txtOrigenBuscar.getText())) {
            esIgual = false;
        } else if (!ruta.getDestino().equals(txtDestinoBuscar.getText())) {
            esIgual = false;
        } else if (!ruta.getHoraSalida().equals(txtHoraSalidaBuscar.getText())) {
            esIgual = false;
        } else if (!ruta.getHoraLlegada().equals(txtHoraLlegadaBuscar.getText())) {
            esIgual = false;
        } else if (ruta.getPrecio() != Double.parseDouble(txtPrecioBuscar.getText())) {
            esIgual = false;
        } else if (!ruta.isEstado() == checkEstadoBuscar.isSelected()) {
            esIgual = false;
        } else if (!ruta.getColectivo().equals(comboxIdColectivoBuscar.getSelectedItem())) {
            esIgual = false;
        }

        return esIgual;
    }
    
    private void limpiarBuscar() {
        txtOrigenBuscar.setText("");
        txtDestinoBuscar.setText("");
        txtHoraSalidaBuscar.setText("");
        txtHoraLlegadaBuscar.setText("");
        txtPrecioBuscar.setText("");
        checkEstadoBuscar.setSelected(false);
        if (comboxIdColectivoBuscar.getItemCount() > 0) {
            comboxIdColectivoBuscar.setSelectedIndex(0);
        }
    }
    
    private RutaViaje validarFormularioEditar() {
        String origen = txtOrigenBuscar.getText().trim();
        String destino = txtDestinoBuscar.getText().trim();

        if (origen.isEmpty() || destino.isEmpty() || txtHoraSalidaBuscar.getText().trim().isEmpty() || txtHoraLlegadaBuscar.getText().trim().isEmpty() || txtPrecioBuscar.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return null;
        }

        if (origen.equalsIgnoreCase(destino)) {
            JOptionPane.showMessageDialog(this, "El origen y el destino no pueden ser iguales.");
            return null;
        }

        LocalTime salida;
        LocalTime llegada;

        try {
            salida = LocalTime.parse(txtHoraSalidaBuscar.getText().trim(), formatoHora);

            llegada = LocalTime.parse(txtHoraLlegadaBuscar.getText().trim(), formatoHora);

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese horarios válidos. Ejemplo: 08:30.");
            return null;
        }

        double precio;

        try {
            precio = Double.parseDouble(txtPrecioBuscar.getText().trim().replace(',', '.'));

            if (!Double.isFinite(precio) || precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero.");
                return null;
            }   

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio numérico válido.");
            return null;
        }

        Colectivo colectivo = (Colectivo) comboxIdColectivoBuscar.getSelectedItem();

        if (colectivo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un colectivo.");
            return null;
        }

        RutaViaje ruta = new RutaViaje();

        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setHoraSalida(salida);
        ruta.setHoraLlegada(llegada);
        ruta.setPrecio(precio);
        ruta.setColectivo(colectivo);
        ruta.setEstado(checkEstadoBuscar.isSelected());

        return ruta;
    }
}
