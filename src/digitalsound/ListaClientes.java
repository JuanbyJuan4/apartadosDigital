package digitalsound;

import java.util.ArrayList;
//import clases.Conexion;
import clases.Clientes;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import clases.Clientes;
import clases.DataSourceManager;
import clases.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ListaClientes extends javax.swing.JFrame {
    DataSourceManager dsm = new DataSourceManager();
    Connection con;
    Clientes mClientes;
    Empleados mEmpleados = new Empleados();
    Clientes clienteSeleccionado = new Clientes();
    int idEmpleado;
    
    //ArrayList mListaClientes;
    public ListaClientes(Empleados empleados) {
        initComponents();
        mEmpleados = empleados;
        idEmpleado =  mEmpleados.getIdEmpleado();
        System.out.println("id empleado:"+idEmpleado);
        dsm.setTipo(mEmpleados.getTipo().trim());
        llenarTClientes();
        this.setSize(444, 559);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        lbl_nombre = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        bnt_menu = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        label1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        label1.setText("Cliente: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 240, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bnt_menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bnt_menu.setText("Regresar");
        bnt_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_menuActionPerformed(evt);
            }
        });

        txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_clientes);
        if (tb_clientes.getColumnModel().getColumnCount() > 0) {
            tb_clientes.getColumnModel().getColumn(0).setResizable(false);
            tb_clientes.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("BUSCAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(bnt_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_buscar))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bnt_menu)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 410, 560));

        jPanel2.setBackground(new java.awt.Color(208, 31, 36));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed

    }//GEN-LAST:event_txt_buscarKeyPressed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        llenarTClientes();
    }//GEN-LAST:event_txt_buscarKeyReleased
    
    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        Connection con = null;
        PreparedStatement pst = null;         
        try{        
            //obtener fecha actual
            LocalDateTime fechaActual = LocalDateTime.now(); // Obtener la fecha y hora actuales
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Definir el formato de la fecha y hora
            String fechaFormateada = fechaActual.format(formato); // Formatear la fecha y hora
            
            int id = (int) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0); //obtener id del cliente
            
            con = dsm.getDataSource().getConnection();
            pst = con.prepareStatement("CALL insercion_ticket(?, ?, ?);"); //falta implementar este procedimiento almacenado a la nueva base de datos
            pst.setInt(1, id); //Obtiene el nombre del cliente
            System.out.println("id: "+id);
            pst.setInt(2, idEmpleado); //Obtiene el correo del cliente
            System.out.println("id empleado: "+mEmpleados.getIdEmpleado());
            pst.setString(3, fechaFormateada); //Obtiene el telefono del cliente
            System.out.println("fecha: "+fechaFormateada);
            pst.executeUpdate(); //ejecutar query
            System.out.println("Ticket creado exitosamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al crear el ticket"+e);
            e.printStackTrace();
        }finally{
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        RegistroApartado registro = new RegistroApartado(mEmpleados);
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void bnt_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_menuActionPerformed
        SeleccionNuevo seleccion = new SeleccionNuevo(mEmpleados);
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bnt_menuActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados mEmpleados = new Empleados();
                new ListaClientes(mEmpleados).setVisible(true);
            }
        });
    }
    private void llenarTClientes(){
        try{
            DefaultTableModel datos = consultar("CALL buscar_cliente(?)");
            tb_clientes.setModel(datos);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private DefaultTableModel consultar(String query) throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Bloquea todas las celdas para que no sean editables
                    }
                };
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = dsm.getDataSource().getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, txt_buscar.getText().trim()); //Obtiene el nombre para añadirlo a la consulta;
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnas = rsMd.getColumnCount();
            for(int i = 1; i<=columnas; i++){
                dtm.addColumn(rsMd.getColumnName(i));
            }
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i = 0; i<columnas;i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
            return dtm;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la consulta");
            e.printStackTrace();
            return dtm;
        }finally{
            if(pst != null){
                pst.close();
            }
            if(con != null){
                con.close();
            }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label lbl_nombre;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
