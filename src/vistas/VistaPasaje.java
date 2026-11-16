package vistas;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

    public VistaPasaje() {

        initComponents();

        pd = new PasajeData(Principal.conexion);
        pjd = new PasajeroData(Principal.conexion);
        rvd = new RutaViajeData(Principal.conexion);
        ad = new AsientoData(Principal.conexion);

        cargarCombosPasajeros();
        cargarCombosRuta();

        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);

        limpiar();
        limpiarBuscar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        checkboxEstado = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        comboxAsiento = new javax.swing.JComboBox<>();
        comboxRuta = new javax.swing.JComboBox<>();
        comboxPasajero = new javax.swing.JComboBox<>();
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboxPasajeroBuscar = new javax.swing.JComboBox<>();
        comboxRutaBuscar = new javax.swing.JComboBox<>();
        txtHoraVentaBuscar = new javax.swing.JTextField();
        txtPrecioBuscar = new javax.swing.JTextField();
        checkboxEstadoBuscar = new javax.swing.JCheckBox();
        txtFechaVentaBuscar = new javax.swing.JTextField();
        comboxAsientoBuscar = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nuevo Pasaje", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 52, 69));
        jLabel2.setText("Pasajero:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 52, 69));
        jLabel3.setText("Viaje:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 52, 69));
        jLabel4.setText("Asiento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 52, 69));
        jLabel7.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(38, 52, 69));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 52, 69));
        jLabel8.setText("Estado:");

        btnCrear.setBackground(new java.awt.Color(52, 142, 110));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("NUEVO");
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        comboxAsiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxAsiento.setForeground(new java.awt.Color(38, 52, 69));
        comboxAsiento.setBorder(null);

        comboxRuta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxRuta.setForeground(new java.awt.Color(38, 52, 69));
        comboxRuta.setBorder(null);
        comboxRuta.addActionListener(this::comboxRutaActionPerformed);

        comboxPasajero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxPasajero.setForeground(new java.awt.Color(38, 52, 69));
        comboxPasajero.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboxAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboxPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboxAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(checkboxEstado))
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(38, 52, 69));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRAR PASAJES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Eliminar -  Editar Pasaje", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(311, 362));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Eliminar -  Editar Pasaje", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(38, 52, 69))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(46, 116, 189));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 52, 69));
        jLabel9.setText("Indique un ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(20, Short.MAX_VALUE))
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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 52, 69));
        jLabel10.setText("Pasajero:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(38, 52, 69));
        jLabel12.setText("Viaje:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(38, 52, 69));
        jLabel13.setText("Fecha de venta:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(38, 52, 69));
        jLabel14.setText("Hora de venta:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(38, 52, 69));
        jLabel15.setText("Precio:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(38, 52, 69));
        jLabel16.setText("Estado:");

        comboxPasajeroBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxPasajeroBuscar.setForeground(new java.awt.Color(38, 52, 69));
        comboxPasajeroBuscar.setBorder(null);

        comboxRutaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxRutaBuscar.setForeground(new java.awt.Color(38, 52, 69));
        comboxRutaBuscar.setBorder(null);
        comboxRutaBuscar.addActionListener(this::comboxRutaBuscarActionPerformed);

        txtHoraVentaBuscar.setEditable(false);
        txtHoraVentaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoraVentaBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtPrecioBuscar.setEditable(false);
        txtPrecioBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecioBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtFechaVentaBuscar.setEditable(false);
        txtFechaVentaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFechaVentaBuscar.setForeground(new java.awt.Color(38, 52, 69));

        comboxAsientoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxAsientoBuscar.setForeground(new java.awt.Color(38, 52, 69));
        comboxAsientoBuscar.setBorder(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(38, 52, 69));
        jLabel11.setText("Asiento:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboxAsientoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkboxEstadoBuscar)
                                .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHoraVentaBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(txtFechaVentaBuscar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(comboxPasajeroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboxRutaBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboxPasajeroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboxRutaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboxAsientoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFechaVentaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHoraVentaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(checkboxEstadoBuscar))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        Pasajero pasajero = (Pasajero) comboxPasajero.getSelectedItem();
        RutaViaje ruta = (RutaViaje) comboxRuta.getSelectedItem();
        Asiento asiento = (Asiento) comboxAsiento.getSelectedItem();

        if (pasajero == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un pasajero, si no hay ninguno cargue uno primero.");
            return;
        }
        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una ruta, si no hay ninguna cargue una primero.");
            return;
        }
        if (asiento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un asiento.");
            return;
        }

        Pasaje NuevoPasaje = new Pasaje();

        NuevoPasaje.setPasajero(pasajero);
        NuevoPasaje.setAsiento(asiento);
        NuevoPasaje.setViaje(ruta);
        NuevoPasaje.setPrecio(ruta.getPrecio()); //mismo precio que el de la ruta seleccionada...
        NuevoPasaje.setEstado(checkboxEstado.isSelected());
        NuevoPasaje.setFechaVenta(LocalDate.now());
        NuevoPasaje.setHoraVenta(LocalTime.now());

        if (pd.crearPasaje(NuevoPasaje)) {
            ad.bajaAsiento(NuevoPasaje.getAsiento().getIdAsiento()); //le damos de baja al asiento para que ya no se pueda comprar un boleto con ese asiento.
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error y no se pudo crear el pasaje.\nrevise los datos o cambie de asiento.");
        }
        limpiar();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtIdPasaje.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a cero");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }
        
        Pasaje anterior = pd.buscarPasajePorId(id);

        if (anterior == null) {
            JOptionPane.showMessageDialog(this, "El pasaje no existe.");
            return;
        }

        Pasajero pasajero = (Pasajero) comboxPasajeroBuscar.getSelectedItem();
        Asiento asiento = (Asiento) comboxAsientoBuscar.getSelectedItem();
        RutaViaje ruta = (RutaViaje) comboxRutaBuscar.getSelectedItem();

        if (pasajero == null || asiento == null || ruta == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un pasajero, una ruta y un asiento.");
            return;
        }

        boolean estado = checkboxEstadoBuscar.isSelected();

        if (esIgual(id)) {
            JOptionPane.showMessageDialog(this, "Debe modificar al menos uno de sus datos!");
            return;
        }

        Pasaje modificado = new Pasaje(id, pasajero, asiento, ruta, anterior.getFechaVenta(), anterior.getHoraVenta(), ruta.getPrecio(), estado);

        if (pd.actualizarPasaje(modificado)) {

            cargarComboAsientos(ruta);
            cargarComboAsientosBuscar(ruta);

            limpiarBuscar();

            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int a = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar el registro?");

        if (a == -1 || a == 1) {
            return;
        }

        if (txtIdPasaje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero ingrese un ID!");
            return;
        }

        try {

            int id = Integer.valueOf(txtIdPasaje.getText());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor valido para ID!");
                return;
            }
            
            Pasaje pasaje = pd.buscarPasajePorId(id);
            
            boolean aux = pd.borrarPasaje(pasaje);

            if (aux) {
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error y no se pudo eliminar el registro\nIntenta de nuevo.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un valor numerico en ID!");
            return;
        }

        limpiarBuscar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {
            int idPasaje = Integer.valueOf(txtIdPasaje.getText().trim());
            
            if (idPasaje <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID mayor que cero.");
                btnEliminar.setEnabled(false);
                btnEditar.setEnabled(false);
                return;
            }
            
            Pasaje pasaje = pd.buscarPasajePorId(idPasaje);

            if (pasaje == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron registros con el ID indicado\nIntente con otro.");
                btnEliminar.setEnabled(false);
                btnEditar.setEnabled(false);
                return;
            }

            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);


            comboxPasajeroBuscar.setSelectedItem(pasaje.getPasajero());
            comboxAsientoBuscar.setSelectedItem(pasaje.getAsiento());
            comboxRutaBuscar.setSelectedItem(pasaje.getViaje());

            txtFechaVentaBuscar.setText(pasaje.getFechaVenta().toString());
            txtHoraVentaBuscar.setText(pasaje.getHoraVenta().toString());

            checkboxEstadoBuscar.setSelected(pasaje.getEstado());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numerico!");
            return;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void comboxRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxRutaActionPerformed

        if (comboxRuta.getSelectedItem() == null) {
            return;
        }

        RutaViaje ruta = (RutaViaje) comboxRuta.getSelectedItem();
        txtPrecio.setText(ruta.getPrecio() + "");

        cargarComboAsientos(ruta);

    }//GEN-LAST:event_comboxRutaActionPerformed

    private void comboxRutaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxRutaBuscarActionPerformed

        if (comboxRutaBuscar.getSelectedItem() == null) {
            return;
        }

        RutaViaje ruta = (RutaViaje) comboxRutaBuscar.getSelectedItem();
        txtPrecioBuscar.setText(ruta.getPrecio() + "");
        cargarComboAsientosBuscar(ruta);
    }//GEN-LAST:event_comboxRutaBuscarActionPerformed


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtFechaVentaBuscar;
    private javax.swing.JTextField txtHoraVentaBuscar;
    private javax.swing.JTextField txtIdPasaje;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarCombosPasajeros() {

        comboxPasajero.removeAllItems();
        comboxPasajeroBuscar.removeAllItems();

        for (Pasajero p : pjd.listarPasajero()) {

            if (p.isEstado()) {
                comboxPasajero.addItem(p); //solo aquellos pasajeros que esten "activos"
                comboxPasajeroBuscar.addItem(p);
            }

        }
    }

    private void cargarComboAsientos(RutaViaje ruta) {
        comboxAsiento.removeAllItems();

        for (Asiento a : ad.listarAsientos()) {

            if (a.getEstado()) { //solo lista aquellos asientos "activos" o "no-ocupados"
                if (ruta.getColectivo().getID_colectivo() == a.getColectivo().getID_colectivo()) { //Solo carga aquellos asientos pertenecientes al colectivo que realiza la ruta, de esa manera evitamos vender un asiento de otro viaje
                    comboxAsiento.addItem(a);
                }
            }

        }
    }
    
    private void cargarComboAsientosBuscar(RutaViaje rutaBuscar){
        comboxAsientoBuscar.removeAllItems();

        if (rutaBuscar == null) {
            return;
        }

        int idAsientoActual = -1;

        try {
            int idPasaje = Integer.parseInt(txtIdPasaje.getText().trim());
            Pasaje pasaje = pd.buscarPasajePorId(idPasaje);

            if (pasaje != null && pasaje.getAsiento() != null) {
                idAsientoActual = pasaje.getAsiento().getIdAsiento();
            }
        } catch (NumberFormatException ex) {
            //No hay un pasaje seleccionado todavia.
        }

        for (Asiento a : ad.listarAsientos()) {
            boolean mismoColectivo = rutaBuscar.getColectivo().getID_colectivo() == a.getColectivo().getID_colectivo();
            boolean disponible = a.getEstado() || a.getIdAsiento() == idAsientoActual;

            if (mismoColectivo && disponible) {
                comboxAsientoBuscar.addItem(a);
            }
        }
    }

    private void cargarCombosRuta() {

        comboxRuta.removeAllItems();
        comboxRutaBuscar.removeAllItems();

        for (RutaViaje rutaViaje : rvd.listarRutaViaje()) {
            if (rutaViaje.isEstado() && rutaViaje.getColectivo().isEstado()) { //solo aquellas rutas activas y que los colectivos asignados a ellas tambein esten activos
                comboxRuta.addItem(rutaViaje);
                comboxRutaBuscar.addItem(rutaViaje);
            }
        }

    }

    private void limpiar() {
        txtPrecio.setText("");
        checkboxEstado.setSelected(false);
        comboxPasajero.setSelectedIndex(-1);
        comboxAsiento.setSelectedIndex(-1);
        comboxRuta.setSelectedIndex(-1);

    }

    private void limpiarBuscar() {
        txtIdPasaje.setText("");
        txtFechaVentaBuscar.setText("");
        txtHoraVentaBuscar.setText("");
        txtPrecioBuscar.setText("");
        checkboxEstadoBuscar.setSelected(false);
        comboxPasajeroBuscar.setSelectedIndex(-1);
        comboxAsientoBuscar.setSelectedIndex(-1);
        comboxRutaBuscar.setSelectedIndex(-1);
    }

    public boolean esIgual(int id) {

        Pasaje pasaje = pd.buscarPasajePorId(id);

        if (pasaje == null) {
            return true;
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
        
        if (Double.compare(pasaje.getPrecio(), ruta.getPrecio()) != 0) {
            return false;
        }

        if (pasaje.getEstado() != checkboxEstadoBuscar.isSelected()) {
            return false;
        }

        return true;
    }
}
