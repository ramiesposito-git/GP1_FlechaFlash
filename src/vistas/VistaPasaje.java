package vistas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Asiento;
import modelo.Pasaje;
import modelo.Pasajero;
import modelo.RutaViaje;
import persistencia.AsientoData;
import persistencia.PasajeData;
import persistencia.PasajeroData;
import persistencia.RutaViajeData;


public class VistaPasaje extends javax.swing.JInternalFrame {

    private PasajeData pd;
    private PasajeroData pjd;
    private RutaViajeData rvd;
    private AsientoData ad;
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
    
    public VistaPasaje() {
        initComponents();
        pd = new PasajeData(Principal.conexion);
        pjd = new PasajeroData(Principal.conexion);
        rvd = new RutaViajeData(Principal.conexion);
        ad = new AsientoData(Principal.conexion);
        
        txtFechaVenta.setEditable(false);
        txtHoraVenta.setEditable(false);
        txtFechaVentaBuscar.setEditable(false);
        txtHoraVentaBuscar.setEditable(false);
        
        cargarComboPasajeros();
        cargarComboAsientos();
        cargarComboRuta();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboxPasajero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboxAsiento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboxRuta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHoraVenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        checkboxEstado = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdPasaje = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboxPasajeroBuscar = new javax.swing.JComboBox<>();
        comboxAsientoBuscar = new javax.swing.JComboBox<>();
        comboxRutaBuscar = new javax.swing.JComboBox<>();
        txtHoraVentaBuscar = new javax.swing.JTextField();
        txtPrecioBuscar = new javax.swing.JTextField();
        checkboxEstadoBuscar = new javax.swing.JCheckBox();
        txtFechaVentaBuscar = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nuevo Pasaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 17))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Pasajero:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Asiento:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Destino:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de venta:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Hora de venta:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Precio:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Estado:");

        btnCrear.setBackground(new java.awt.Color(52, 142, 110));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("CARGAR");
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkboxEstado)
                            .addComponent(txtHoraVenta)
                            .addComponent(txtFechaVenta)
                            .addComponent(comboxRuta, 0, 140, Short.MAX_VALUE)
                            .addComponent(comboxAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboxPasajero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecio)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnCrear)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboxPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboxAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(checkboxEstado))
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(38, 52, 69));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARGAR NUEVO PASAJE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Eliminar -  Editar Pasaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 17))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Buscar Pasaje", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(46, 116, 189));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Indique el ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel9)
                    .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
        jLabel10.setText("Pasajero:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Asiento:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Destino:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Fecha de venta:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Hora de venta:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Precio:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Estado:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnEditar)
                            .addGap(71, 71, 71)
                            .addComponent(btnEliminar))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboxAsientoBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboxPasajeroBuscar, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboxRutaBuscar, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoraVentaBuscar)
                            .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(checkboxEstadoBuscar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtFechaVentaBuscar))))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboxPasajeroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboxAsientoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboxRutaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFechaVentaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHoraVentaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(checkboxEstadoBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        Pasaje pasaje = validarFormulario();
        if (pasaje == null) {
            return;
        }
 
        pd.crearPasaje(pasaje);
        limpiar();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdPasaje.getText().trim());
            
            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor que cero.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }
 
        Pasaje pasaje = pd.buscarPasajePorId(id);
        if (pasaje == null) {
            return; 
        }
 
        txtFechaVentaBuscar.setText(pasaje.getFechaVenta().format(formatoFecha));
        txtHoraVentaBuscar.setText(pasaje.getHoraVenta().format(formatoHora));
        txtPrecioBuscar.setText(String.valueOf(pasaje.getPrecio()));
        checkboxEstadoBuscar.setSelected(pasaje.getEstado());

        seleccionarPasajero(pasaje.getPasajero());
        seleccionarRuta(pasaje.getViaje());
        seleccionarAsiento(pasaje.getAsiento());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdPasaje.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a cero");
                return;
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }
    
        Pasaje pasajeEditado = validarFormularioEditar();

        if (pasajeEditado == null) {
            return;
        }

        if (esIgual(id)) {
            JOptionPane.showMessageDialog(this, "Debe modificar al menos uno de sus datos!");
            return;
        }
        
        pasajeEditado.setIdPasaje(id);

        pd.actualizarPasaje(pasajeEditado);
        limpiarBuscar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdPasaje.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a cero");
                return;
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }

        pd.borrarPasaje(id);
        limpiarBuscar();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JCheckBox checkboxEstadoBuscar;
    private javax.swing.JComboBox<Asiento> comboxAsiento;
    private javax.swing.JComboBox<Asiento> comboxAsientoBuscar;
    private javax.swing.JComboBox<Pasajero> comboxPasajero;
    private javax.swing.JComboBox<Pasajero> comboxPasajeroBuscar;
    private javax.swing.JComboBox<RutaViaje> comboxRuta;
    private javax.swing.JComboBox<RutaViaje> comboxRutaBuscar;
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
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtFechaVentaBuscar;
    private javax.swing.JTextField txtHoraVenta;
    private javax.swing.JTextField txtHoraVentaBuscar;
    private javax.swing.JTextField txtIdPasaje;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarComboPasajeros() {
        comboxPasajero.removeAllItems();
        comboxPasajeroBuscar.removeAllItems();

        for (Pasajero p : pjd.listarPasajero()) {
            comboxPasajero.addItem(p);
            comboxPasajeroBuscar.addItem(p);
        }
    }
    
    private void cargarComboAsientos() {
        comboxAsiento.removeAllItems();
        comboxAsientoBuscar.removeAllItems();

        for (Asiento a : ad.listarAsientos()) {
            comboxAsiento.addItem(a);
            comboxAsientoBuscar.addItem(a);
        }
    }
    
    private void cargarComboRuta(){
        comboxRuta.removeAllItems();
        comboxRutaBuscar.removeAllItems();

        for (RutaViaje r : rvd.listarRutaViaje()) {
            comboxRuta.addItem(r);
            comboxRutaBuscar.addItem(r);
        }
    }
    
    private void limpiar() {
        txtFechaVenta.setText("");
        txtHoraVenta.setText("");
        txtPrecio.setText("");
        checkboxEstado.setSelected(false);
        if (comboxPasajero.getItemCount() > 0) {
            comboxPasajero.setSelectedIndex(0);
        }
        if (comboxAsiento.getItemCount() > 0) {
            comboxAsiento.setSelectedIndex(0);
        }
        if (comboxRuta.getItemCount() > 0) {
            comboxRuta.setSelectedIndex(0);
        }
    }
    
    private void seleccionarPasajero(Pasajero pasajero) {
        if (pasajero == null) return;

        for (int i = 0; i < comboxPasajeroBuscar.getItemCount(); i++) {
            Pasajero p = comboxPasajeroBuscar.getItemAt(i);

            if (p.getIdPasajero() == pasajero.getIdPasajero()) {
                comboxPasajeroBuscar.setSelectedIndex(i);
                return;
            }
        }
        comboxPasajeroBuscar.addItem(pasajero);
        comboxPasajeroBuscar.setSelectedItem(pasajero);
    }
    
    private void seleccionarRuta(RutaViaje ruta) {
        if (ruta == null) return;

        for (int i = 0; i < comboxRutaBuscar.getItemCount(); i++) {
            RutaViaje r = comboxRutaBuscar.getItemAt(i);

            if (r.getIdRuta() == ruta.getIdRuta()) {
                comboxRutaBuscar.setSelectedIndex(i);
                return;
            }
        }
        comboxRutaBuscar.addItem(ruta);
        comboxRutaBuscar.setSelectedItem(ruta);
    }
    
    private void seleccionarAsiento(Asiento asiento) {
        if (asiento == null) return;

        for (int i = 0; i < comboxAsientoBuscar.getItemCount(); i++) {
            Asiento a = comboxAsientoBuscar.getItemAt(i);

            if (a.getIdAsiento() == asiento.getIdAsiento()) {
                comboxAsientoBuscar.setSelectedIndex(i);
                return;
            }
        }
        comboxAsientoBuscar.addItem(asiento);
        comboxAsientoBuscar.setSelectedItem(asiento);
    }
    
    private Pasaje validarFormulario() {
        Pasajero pasajero = (Pasajero) comboxPasajero.getSelectedItem();
        RutaViaje ruta = (RutaViaje) comboxRuta.getSelectedItem();
        Asiento asiento = (Asiento) comboxAsiento.getSelectedItem();
        
        if (pasajero == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un pasajero, si no hay ninguno cargue uno primero.");
            return null;
        }
        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una ruta, si no hay ninguna cargue una primero.");
            return null;
        }
        if (asiento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un asiento.");
            return null;
        }
        
        if (txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el precio del pasaje.");
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
        
        Pasaje pasaje = new Pasaje();
        
        // Fecha y hora automáticas
        pasaje.setFechaVenta(LocalDate.now());
        pasaje.setHoraVenta(LocalTime.now());
        pasaje.setPasajero(pasajero);
        pasaje.setAsiento(asiento);
        pasaje.setViaje(ruta);
        pasaje.setPrecio(precio);
        pasaje.setEstado(checkboxEstado.isSelected());
        
        return pasaje;
    }
    
    private void limpiarBuscar() {
        txtIdPasaje.setText("");
        txtFechaVentaBuscar.setText("");
        txtHoraVentaBuscar.setText("");
        txtPrecioBuscar.setText("");
        checkboxEstadoBuscar.setSelected(false);
        if (comboxPasajeroBuscar.getItemCount() > 0) {
            comboxPasajeroBuscar.setSelectedIndex(0);
        }
        if (comboxAsientoBuscar.getItemCount() > 0) {
            comboxAsientoBuscar.setSelectedIndex(0);
        }
        if (comboxRutaBuscar.getItemCount() > 0) {
            comboxRutaBuscar.setSelectedIndex(0);
        }
    }
    
    private Pasaje validarFormularioEditar() {
        Pasajero pasajero = (Pasajero) comboxPasajeroBuscar.getSelectedItem();
        RutaViaje ruta = (RutaViaje) comboxRutaBuscar.getSelectedItem();
        Asiento asiento = (Asiento) comboxAsientoBuscar.getSelectedItem();

        if (pasajero == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un pasajero.");
            return null;
        }

        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una ruta.");
            return null;
        }

        if (asiento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un asiento.");
            return null;
        }

        if (txtPrecioBuscar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el precio del pasaje.");
            return null;
        }

        double precio;

        try {
            precio = Double.parseDouble(txtPrecioBuscar.getText().trim().replace(',', '.'));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"El precio debe ser un número válido.");
            return null;
        }

        if (precio <= 0) {
        JOptionPane.showMessageDialog(this,"El precio debe ser mayor que cero.");
            return null;
        }

        Pasaje pasaje = new Pasaje();

        pasaje.setPasajero(pasajero);
        pasaje.setAsiento(asiento);
        pasaje.setViaje(ruta);
        pasaje.setPrecio(precio);
        pasaje.setEstado(checkboxEstadoBuscar.isSelected());

        return pasaje;
    }
    
    public boolean esIgual(int id) {
        Pasaje pasaje = pd.buscarPasajePorId(id);

        if (pasaje == null) {
            return false;
        }

        Pasajero pasajero = (Pasajero) comboxPasajeroBuscar.getSelectedItem();
        Asiento asiento = (Asiento) comboxAsientoBuscar.getSelectedItem();
        RutaViaje ruta = (RutaViaje) comboxRutaBuscar.getSelectedItem();

        if (pasajero == null || asiento == null || ruta == null) {
            return false;
        }
        if (pasaje.getPasajero().getIdPasajero() != pasajero.getIdPasajero()) {
            return false;
        }
        if (pasaje.getAsiento().getIdAsiento() != asiento.getIdAsiento()) {
            return false;
        }
        if (pasaje.getViaje().getIdRuta() != ruta.getIdRuta()) {
            return false;
        }
        
        double precio;
        try {
            precio = Double.parseDouble(txtPrecioBuscar.getText().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            return false;
        }

        if (Double.compare(pasaje.getPrecio(), precio) != 0) {
            return false;
        }
        if (pasaje.getEstado() != checkboxEstadoBuscar.isSelected()) {
            return false;
        }

        return true;
    }
}
