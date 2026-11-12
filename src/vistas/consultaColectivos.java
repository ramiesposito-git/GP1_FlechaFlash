package vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Colectivo;
import persistencia.ColectivoData;

public class consultaColectivos extends javax.swing.JInternalFrame {
    
    public DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        
    };
    
    ColectivoData cd;
    
    public consultaColectivos() {
        initComponents();
        
        cd = new ColectivoData(Principal.conexion);
        initTable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdColectivo = new javax.swing.JTextField();
        buscarID = new javax.swing.JButton();
        BTNlistarTodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), "Buscar por ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 14), new java.awt.Color(38, 52, 69))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 52, 69));
        jLabel2.setText("ID colectivo:");

        buscarID.setBackground(new java.awt.Color(45, 108, 223));
        buscarID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buscarID.setForeground(new java.awt.Color(255, 255, 255));
        buscarID.setText("Buscar");
        buscarID.addActionListener(this::buscarIDActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(buscarID)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarID))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        BTNlistarTodos.setBackground(new java.awt.Color(37, 99, 235));
        BTNlistarTodos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BTNlistarTodos.setForeground(new java.awt.Color(255, 255, 255));
        BTNlistarTodos.setText("LISTAR TODOS");
        BTNlistarTodos.addActionListener(this::BTNlistarTodosActionPerformed);

        jTable1.setForeground(new java.awt.Color(38, 52, 69));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(155, 197, 253));
        jTable1.setSelectionForeground(new java.awt.Color(38, 52, 69));
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(38, 52, 69));

        jLabel1.setBackground(new java.awt.Color(37, 99, 235));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTAR COLECTIVOS");

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
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNlistarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNlistarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarIDActionPerformed
        
        limpiarTable();
        int id = 0;
        
        try {
            
            id = Integer.valueOf(txtIdColectivo.getText());
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un vlaor numerico!");
            return;
        }
        
        Colectivo col = cd.buscarColectivoPorId(id);
        
        if (col == null) {
            JOptionPane.showMessageDialog(this, "No existe colectivo con ese ID!\nIntente uno diferente.");
            return;
        }
        
        modelo.addRow(new Object[]{col.getID_colectivo(), col.getMatricula(), col.getMarca(), col.getModelo(), col.getCapacidad(), col.getChofer()});

    }//GEN-LAST:event_buscarIDActionPerformed

    private void BTNlistarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNlistarTodosActionPerformed
        
        limpiarTable();
        
        for (Colectivo col : cd.listarColectivo()) {
            modelo.addRow(new Object[]{col.getID_colectivo(), col.getMatricula(), col.getMarca(), col.getModelo(), col.getCapacidad(), col.getChofer()});
        }

    }//GEN-LAST:event_BTNlistarTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNlistarTodos;
    private javax.swing.JButton buscarID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdColectivo;
    // End of variables declaration//GEN-END:variables

    public void initTable() {
        
        modelo.addColumn("ID");
        modelo.addColumn("Matricula");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Capacidad");
        modelo.addColumn("Chofer");
        
        jTable1.setModel(modelo);
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(73);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(69);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(135);
        

        jTable1.getTableHeader().setForeground(new Color(38, 52, 69));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }
    
    public void limpiarTable() {
        modelo.setRowCount(0);
    }
}
