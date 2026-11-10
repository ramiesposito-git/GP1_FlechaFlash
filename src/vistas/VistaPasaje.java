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
    private Pasaje pasajeActual = null;
    
    public VistaPasaje() {
        initComponents();
        pd = new PasajeData(Principal.conexion);
        pjd = new PasajeroData(Principal.conexion);
        rvd = new RutaViajeData(Principal.conexion);
        ad = new AsientoData(Principal.conexion);
        
        cargarComboPasajeros();
        cargarComboAsientos();
        cargarComboRuta();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdPasaje = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREAR NUEVO PASAJE");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Crear Pasaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Pasajero:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Asiento:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Destino:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de venta:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Hora de venta:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Precio:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Estado:");

        btnCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(checkboxEstado)
                        .addComponent(comboxRuta, 0, 203, Short.MAX_VALUE)
                        .addComponent(comboxPasajero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboxAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(txtHoraVenta)
                        .addComponent(txtFechaVenta))
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboxPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboxAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkboxEstado)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Pasaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(65, 65, 65)
                        .addComponent(btnSalir))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }
 
        Pasaje pasaje = pd.buscarPasajePorId(id);
        if (pasaje == null) {
            return; 
        }
 
        pasajeActual = pasaje;
        txtFechaVenta.setText(pasaje.getFechaVenta().format(formatoFecha));
        txtHoraVenta.setText(pasaje.getHoraVenta().format(formatoHora));
        txtPrecio.setText(String.valueOf(pasaje.getPrecio()));
        checkboxEstado.setSelected(pasaje.getEstado());
        seleccionarPasajero(pasaje.getPasajero());
        seleccionarRuta(pasaje.getViaje());
        seleccionarAsiento(pasaje.getAsiento());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (pasajeActual == null) {
            JOptionPane.showMessageDialog(this, "Primero busque un pasaje por su ID.");
            return;
        }
        
        pd.borrarPasaje(pasajeActual.getIdPasaje());
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JComboBox<Asiento> comboxAsiento;
    private javax.swing.JComboBox<Pasajero> comboxPasajero;
    private javax.swing.JComboBox<RutaViaje> comboxRuta;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtHoraVenta;
    private javax.swing.JTextField txtIdPasaje;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void cargarComboPasajeros() {
        ArrayList<Pasajero> pasajero = (ArrayList<Pasajero>) pjd.listarPasajero();
        
        for (Pasajero p : pasajero) {
            comboxPasajero.addItem(p);
        }
    }
    
    private void cargarComboAsientos() {
        ArrayList<Asiento> asiento = (ArrayList<Asiento>) ad.listarAsientos();
        
        for (Asiento a : asiento) {
            comboxAsiento.addItem(a);
        }
    }
    
    private void cargarComboRuta(){
        ArrayList<RutaViaje> ruta = (ArrayList<RutaViaje>) rvd.listarRutaViaje();
        
        for (RutaViaje r : ruta) {
            comboxRuta.addItem(r);
        }
    }
    
    private void limpiar() {
        txtFechaVenta.setText("");
        txtHoraVenta.setText("");
        txtPrecio.setText("");
        checkboxEstado.setSelected(true);
        if (comboxPasajero.getItemCount() > 0) {
            comboxPasajero.setSelectedIndex(0);
        }
        if (comboxRuta.getItemCount() > 0) {
            comboxRuta.setSelectedIndex(0);
        }
    }
    
    private void seleccionarPasajero(Pasajero pasajero) {
        for (int i = 0; i < comboxPasajero.getItemCount(); i++) {
            if (comboxPasajero.getItemAt(i).getIdPasajero() == pasajero.getIdPasajero()) {
                comboxPasajero.setSelectedIndex(i);
                return;
            }
        }
        comboxPasajero.addItem(pasajero);
        comboxPasajero.setSelectedItem(pasajero);
    }
    
    private void seleccionarRuta(RutaViaje ruta) {
        for (int i = 0; i < comboxRuta.getItemCount(); i++) {
            if (comboxRuta.getItemAt(i).getIdRuta() == ruta.getIdRuta()) {
                comboxRuta.setSelectedIndex(i);
                return;
            }
        }
        comboxRuta.addItem(ruta);
        comboxRuta.setSelectedItem(ruta);
    }
    
    private void seleccionarAsiento(Asiento asiento) {
        for (int i = 0; i < comboxAsiento.getItemCount(); i++) {
            if (comboxAsiento.getItemAt(i).getIdAsiento() == asiento.getIdAsiento()) {
                comboxAsiento.setSelectedIndex(i);
                return;
            }
        }
        comboxAsiento.addItem(asiento);
        comboxAsiento.setSelectedItem(asiento);
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
        
        if (txtFechaVenta.getText().trim().isEmpty() || txtHoraVenta.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return null;
        }
        
        LocalDate fecha;
        LocalTime hora;
        try {
            fecha = LocalDate.parse(txtFechaVenta.getText().trim(), formatoFecha);
            hora = LocalTime.parse(txtHoraVenta.getText().trim(), formatoHora);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener formato dia/mes/anio (por ejemplo 7/11/2026) y la hora hora:minuto (por ejemplo 08:30).");
            return null;
        }
        
        if (!hora.isBefore(ruta.getHoraSalida())) {
            JOptionPane.showMessageDialog(this, "La hora de venta debe ser anterior a la hora de salida del viaje");
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
        pasaje.setPasajero(pasajero);
        pasaje.setAsiento(asiento);
        pasaje.setViaje(ruta);
        pasaje.setFechaVenta(fecha);
        pasaje.setHoraVenta(hora);
        pasaje.setPrecio(precio);
        pasaje.setEstado(checkboxEstado.isSelected());
        return pasaje;
    }
}
