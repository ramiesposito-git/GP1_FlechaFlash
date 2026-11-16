package vistas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        cargarComboRuta();
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
        jPanel2 = new javax.swing.JPanel();
        ComboBoxRuta = new javax.swing.JComboBox<>();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Nueva Ruta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(38, 52, 69));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 52, 69));
        jLabel2.setText("Origen :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 52, 69));
        jLabel3.setText("Destino:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 52, 69));
        jLabel4.setText("Hora de Salida:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(38, 52, 69));
        jLabel5.setText("Hora de Llegada:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 52, 69));
        jLabel6.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 52, 69));
        jLabel7.setText("Activo:");

        btnGuardar.setBackground(new java.awt.Color(52, 142, 110));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("CARGAR");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        comboxIdColectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxIdColectivo.setForeground(new java.awt.Color(38, 52, 69));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(38, 52, 69));

        txtHoraLlegada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoraLlegada.setForeground(new java.awt.Color(38, 52, 69));

        txtHoraSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoraSalida.setForeground(new java.awt.Color(38, 52, 69));

        txtDestino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDestino.setForeground(new java.awt.Color(38, 52, 69));

        txtOrigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrigen.setForeground(new java.awt.Color(38, 52, 69));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 52, 69));
        jLabel9.setText("Colectivo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtHoraSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(txtHoraLlegada, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(checkEstado)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(txtOrigen, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(checkEstado))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboxIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel3.setBackground(new java.awt.Color(38, 52, 69));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRAR RUTAS");

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Eliminar - Editar Ruta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 17), new java.awt.Color(38, 52, 69))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(38, 52, 69));

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
        jLabel10.setText("Origen:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(38, 52, 69));
        jLabel11.setText("Destino:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(38, 52, 69));
        jLabel12.setText("Hora de Salida:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(38, 52, 69));
        jLabel13.setText("Hora de Llegada:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(38, 52, 69));
        jLabel14.setText("Precio:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(38, 52, 69));
        jLabel15.setText("Activo:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(38, 52, 69));
        jLabel16.setText("Colectivo:");

        txtOrigenBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrigenBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtDestinoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDestinoBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtPrecioBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecioBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtHoraSalidaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoraSalidaBuscar.setForeground(new java.awt.Color(38, 52, 69));

        txtHoraLlegadaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoraLlegadaBuscar.setForeground(new java.awt.Color(38, 52, 69));

        comboxIdColectivoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboxIdColectivoBuscar.setForeground(new java.awt.Color(38, 52, 69));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Selecciona una Ruta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(38, 52, 69))); // NOI18N

        ComboBoxRuta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ComboBoxRuta.setForeground(new java.awt.Color(102, 102, 102));
        ComboBoxRuta.setBorder(null);
        ComboBoxRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComboBoxRuta.addActionListener(this::ComboBoxRutaActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(ComboBoxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ComboBoxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(checkEstadoBuscar)
                            .addComponent(txtHoraLlegadaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraSalidaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrigenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestinoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboxIdColectivoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtOrigenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDestinoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtHoraSalidaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHoraLlegadaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPrecioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(checkEstadoBuscar))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboxIdColectivoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        RutaViaje ruta = validarFormulario();

        if (ruta == null) {
            return;
        }

        rvd.guardarRutaViaje(ruta);

        cargarComboRuta();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        RutaViaje ruta = (RutaViaje) ComboBoxRuta.getSelectedItem();

        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una Ruta");
            return;
        }

        // Valida los campos antes de intentar editar.
        RutaViaje rutaEditado = validarFormularioEditar();

        if (rutaEditado == null) {
            return;
        }
        
        if (esIgual(ruta.getIdRuta())) {
            JOptionPane.showMessageDialog(this, "Debe modificar al menos un campo!");
            return;
        }

        // Conserva el ID de la ruta seleccionada.
        rutaEditado.setIdRuta(ruta.getIdRuta());

        boolean aux = rvd.actualizarRutaViaje(rutaEditado);

        if (aux) {
            JOptionPane.showMessageDialog(this, "Pasaje actualizado correctamente!");
            cargarComboRuta();
            limpiarBuscar();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el pasaje.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        RutaViaje rv = (RutaViaje) ComboBoxRuta.getSelectedItem();
        
        if (rv == null) {
            JOptionPane.showMessageDialog(this, "Primero selecciona una Ruta!");
            return;
        }

        
        int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar la ruta " + rv.toString() +"?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        
        if (respuesta == -1 || respuesta == 1) {
            return;
        }
        
        
        if (rvd.borrarRutaViaje(rv.getIdRuta())) {
            JOptionPane.showMessageDialog(this, "Registro eliminado con exito!");
        } else{
            JOptionPane.showMessageDialog(this, "Ocurrio un problema y no se pudo eliminar el registro\nIntenta de nuevo!");
        }

        limpiarBuscar();
        cargarComboRuta();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void ComboBoxRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxRutaActionPerformed

        RutaViaje ruta = (RutaViaje) ComboBoxRuta.getSelectedItem();

        if (ruta == null) {
            limpiarBuscar();
            return;
        }

        txtOrigenBuscar.setText(ruta.getOrigen());
        txtDestinoBuscar.setText(ruta.getDestino());
        txtHoraLlegadaBuscar.setText(ruta.getHoraLlegada().toString());
        txtHoraSalidaBuscar.setText(ruta.getHoraSalida().toString());
        txtPrecioBuscar.setText(ruta.getPrecio() + "");
        checkEstadoBuscar.setSelected(ruta.isEstado());
        comboxIdColectivoBuscar.setSelectedItem((Colectivo) ruta.getColectivo());
    }//GEN-LAST:event_ComboBoxRutaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<RutaViaje> ComboBoxRuta;
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
        txtOrigen.setText("");
        txtDestino.setText("");
        txtHoraSalida.setText("");
        txtHoraLlegada.setText("");
        txtPrecio.setText("");
        checkEstado.setSelected(false);
        comboxIdColectivo.setSelectedIndex(-1);
    }

    public boolean esIgual(int id) {

        RutaViaje ruta = rvd.buscarRutaViajePorId(id);
        Colectivo colectivo = (Colectivo) comboxIdColectivoBuscar.getSelectedItem();
        
        if (ruta == null) {
            return true;
        }
        
        if (colectivo == null || ruta.getColectivo() == null) {
            return false;
        }

        if (!ruta.getOrigen().equals(txtOrigenBuscar.getText().trim())) {
            return false;
        }

        if (!ruta.getDestino().equals(txtDestinoBuscar.getText().trim())) {
            return false;
        }

        if (!ruta.getHoraSalida().format(formatoHora).equals(txtHoraSalidaBuscar.getText().trim())) {
            return false;
        }

        if (!ruta.getHoraLlegada().format(formatoHora).equals(txtHoraLlegadaBuscar.getText().trim())) {
            return false;
        }

        double precio = Double.parseDouble(txtPrecioBuscar.getText().trim().replace(',', '.'));

        if (Double.compare(precio, ruta.getPrecio()) != 0) {
            return false;
        }

        if (ruta.isEstado() != checkEstadoBuscar.isSelected()) {
            return false;
        }
        
        if (ruta.getColectivo().getID_colectivo() != colectivo.getID_colectivo()) {
            return false;
        }

        return true;
    }

    private void limpiarBuscar() {

        txtOrigenBuscar.setText("");
        txtDestinoBuscar.setText("");
        txtHoraSalidaBuscar.setText("");
        txtHoraLlegadaBuscar.setText("");
        txtPrecioBuscar.setText("");
        checkEstadoBuscar.setSelected(false);
        comboxIdColectivoBuscar.setSelectedIndex(-1);

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

    public void cargarComboRuta() {

        ComboBoxRuta.removeAllItems();

        for (RutaViaje rutaViaje : rvd.listarRutaViaje()) {
            ComboBoxRuta.addItem(rutaViaje);
        }

        ComboBoxRuta.setSelectedIndex(-1);

    }
}
