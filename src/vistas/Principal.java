package vistas;

import modelo.Conexion;

public class Principal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    static Conexion conexion;

    public Principal() {
        initComponents();
        conexion = new Conexion("jdbc:mysql://localhost:3306/flechaflashdb", "root", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jmbPrincipal = new javax.swing.JMenuBar();
        jmGestion = new javax.swing.JMenu();
        menuPasajero = new javax.swing.JMenuItem();
        menuColectivo = new javax.swing.JMenuItem();
        menuRuta = new javax.swing.JMenuItem();
        menuAsiento = new javax.swing.JMenuItem();
        jmiPasaje = new javax.swing.JMenuItem();
        jmConsultar = new javax.swing.JMenu();
        consultarAsiento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 966, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );

        jmGestion.setText("Gestion");

        menuPasajero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPasajero.setText("Pasajero");
        menuPasajero.addActionListener(this::menuPasajeroActionPerformed);
        jmGestion.add(menuPasajero);

        menuColectivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuColectivo.setText("Colectivo");
        menuColectivo.addActionListener(this::menuColectivoActionPerformed);
        jmGestion.add(menuColectivo);

        menuRuta.setText("Ruta");
        menuRuta.addActionListener(this::menuRutaActionPerformed);
        jmGestion.add(menuRuta);

        menuAsiento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuAsiento.setText("Asiento");
        menuAsiento.addActionListener(this::menuAsientoActionPerformed);
        jmGestion.add(menuAsiento);

        jmiPasaje.setText("Pasaje");
        jmiPasaje.addActionListener(this::jmiPasajeActionPerformed);
        jmGestion.add(jmiPasaje);

        jmbPrincipal.add(jmGestion);

        jmConsultar.setText("Consultar");

        consultarAsiento.setText("consultar Asientos");
        consultarAsiento.addActionListener(this::consultarAsientoActionPerformed);
        jmConsultar.add(consultarAsiento);

        jmbPrincipal.add(jmConsultar);

        setJMenuBar(jmbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPasajeroActionPerformed
        jdpPrincipal.removeAll();

        VistaPasajero vp = new VistaPasajero();
        jdpPrincipal.add(vp);
        vp.setVisible(true);

        jdpPrincipal.revalidate();
        jdpPrincipal.repaint();
    }//GEN-LAST:event_menuPasajeroActionPerformed

    private void menuColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuColectivoActionPerformed

        jdpPrincipal.removeAll();

        VistaColectivo va  = new VistaColectivo();
        jdpPrincipal.add(va);

        va.setVisible(true);

        jdpPrincipal.revalidate();
        jdpPrincipal.repaint();

    }//GEN-LAST:event_menuColectivoActionPerformed

    private void menuRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRutaActionPerformed
        jdpPrincipal.removeAll();

        VistaRutaViaje VR = new VistaRutaViaje();
        jdpPrincipal.add(VR);

        VR.setVisible(true);

        jdpPrincipal.revalidate();
        jdpPrincipal.repaint();
    }//GEN-LAST:event_menuRutaActionPerformed

    private void menuAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAsientoActionPerformed

        jdpPrincipal.removeAll();

        VistaAsiento va  = new VistaAsiento();
        jdpPrincipal.add(va);
        va.setVisible(true);

        jdpPrincipal.revalidate();
        jdpPrincipal.repaint();

    }//GEN-LAST:event_menuAsientoActionPerformed

    private void consultarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAsientoActionPerformed
        jdpPrincipal.removeAll();

        consultaAsientos ca = new consultaAsientos();

        jdpPrincipal.add(ca);
        ca.setVisible(true);

        jdpPrincipal.repaint();
        jdpPrincipal.revalidate();
    }//GEN-LAST:event_consultarAsientoActionPerformed

    private void jmiPasajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPasajeActionPerformed
        jdpPrincipal.removeAll();
        
        VistaPasaje va = new VistaPasaje();
        
        jdpPrincipal.add(va);
        va.setVisible(true);
        
        jdpPrincipal.repaint();
        jdpPrincipal.revalidate();
    }//GEN-LAST:event_jmiPasajeActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem consultarAsiento;
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JMenu jmConsultar;
    private javax.swing.JMenu jmGestion;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmiPasaje;
    private javax.swing.JMenuItem menuAsiento;
    private javax.swing.JMenuItem menuColectivo;
    private javax.swing.JMenuItem menuPasajero;
    private javax.swing.JMenuItem menuRuta;
    // End of variables declaration//GEN-END:variables
}
