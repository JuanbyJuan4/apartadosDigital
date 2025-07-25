/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package digitalsound;

import clases.Clientes;
import clases.DataSourceManager;
import clases.Empleados;

import java.awt.Font;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConsultaClientes extends javax.swing.JFrame {
    Empleados mEmpleados = new Empleados();
    ConsultaClientes mConsulta;
    DataSourceManager dsm = new DataSourceManager();
    ArrayList mListaClientes;
    ArrayList mListaCorreos;
    ArrayList mListaTelefonos;
    /**
     * Creates new form ConsultaClientes
     * @param empleados
     */
    public ConsultaClientes(Empleados empleados) {
        initComponents();
        configurarVentana();
        mEmpleados = empleados;
        Usuarios();
        metodos();
    }
    
    private void configurarVentana(){
        this.setTitle("Digital Sound - Consulta de clientes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    private void metodos(){
        llenarLClientes();
    }
    private void Usuarios(){
        String usuario = mEmpleados.getNombre().trim();
        String tipo = mEmpleados.getTipo().trim(); 
        lbl_usuario.setText(usuario);
        lbl_tipo.setText(tipo);
        dsm.setTipo(tipo);
        if(mEmpleados.getIdTipoEmp() == 2){
            btn_eliminar_c.setEnabled(false);
            btn_eliminar_t.setEnabled(false);
            btn_eliminar.setEnabled(false);
            btn_modificar.setEnabled(false);
        }
    }
    public void actualizar(ConsultaClientes consulta){
         llenarLClientes();
         llenarCBCorreos();
         llenarCBTelefonos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_agregar_c = new javax.swing.JButton();
        btn_agregar_t = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_tipo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        btn_cerrar_sesion3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_correo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cb_telefono = new javax.swing.JComboBox<>();
        btn_menu = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_eliminar_c = new javax.swing.JButton();
        btn_eliminar_t = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tb_clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_clientes);

        btn_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_nuevo.setText("Nuevo cliente");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_agregar_c.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_agregar_c.setText("Agregar correo");
        btn_agregar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_cActionPerformed(evt);
            }
        });

        btn_agregar_t.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_agregar_t.setText("Agregar telefono");
        btn_agregar_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_tActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(208, 31, 36));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/soundchico.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Puesto:");

        lbl_tipo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_tipo.setForeground(new java.awt.Color(255, 255, 255));

        lbl_usuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));

        btn_cerrar_sesion3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btn_cerrar_sesion3.setText("Cerrar Sesion");
        btn_cerrar_sesion3.setFocusable(false);
        btn_cerrar_sesion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar_sesion3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_cerrar_sesion3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(lbl_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrar_sesion3)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cliente:");

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Correo:");

        cb_correo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Telefonos:");

        cb_telefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_menu.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btn_menu.setText("Menu");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_modificar.setText("Modificar Nombre");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_eliminar_c.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_eliminar_c.setText("Eliminar correo");
        btn_eliminar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_cActionPerformed(evt);
            }
        });

        btn_eliminar_t.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_eliminar_t.setText("Eliminar telefono");
        btn_eliminar_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_tActionPerformed(evt);
            }
        });

        txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(txt_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_telefono, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_agregar_c, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cb_correo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_agregar_t)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_t, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_menu)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_menu)
                        .addGap(33, 33, 33)
                        .addComponent(btn_nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(cb_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_agregar_c)
                            .addComponent(btn_eliminar_c))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_agregar_t)
                            .addComponent(btn_eliminar_t))
                        .addGap(18, 18, 18)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        int id = (int) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0);
        String nombre = (String) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 1);
        ModificarCliente modificar = new ModificarCliente(id, nombre, mEmpleados, this);
        modificar.setVisible(true);
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        MenuInicio menu = new MenuInicio(mEmpleados);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_agregar_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_tActionPerformed
        try{
            int id = (int) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0);
            AgregarTelefono telefono = new AgregarTelefono(id,this, mEmpleados);
            telefono.setVisible(true);
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para agregar su telefono");
        }
    }//GEN-LAST:event_btn_agregar_tActionPerformed

    private void btn_agregar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_cActionPerformed
        try{
            int id = (int) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0);
            AgregarCorreo correo = new AgregarCorreo(id,this, mEmpleados);
            correo.setVisible(true);
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para agregar su correo");
        }
    }//GEN-LAST:event_btn_agregar_cActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        RegistroCliente registro = new RegistroCliente(this, mEmpleados);
        registro.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        lbl_nombre.setText((String) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 1));
        llenarCBCorreos();
        llenarCBTelefonos();
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        llenarLClientes();
        Monitoreo();
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_eliminar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_cActionPerformed
        Connection con = null;
        PreparedStatement pst = null;
        try{
            
            if(cb_correo.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "El cliente no tiene ningun correo");
            }else{
                String correo = cb_correo.getSelectedItem().toString();
                con = dsm.getDataSource().getConnection();
                pst = con.prepareStatement("CALL eliminar_correo(?,?);");
                pst.setInt(1, (Integer) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0));
                pst.setString(2, correo);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Correo eliminado exitosamente");
                llenarCBCorreos();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_eliminar_cActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = dsm.getDataSource().getConnection();
            Object[] options = {"Sí", "No"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Esta seguro de que desea eliminar al cliente?", "Seleccione una opcion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(opcion == 0){
                pst = con.prepareStatement("CALL eliminar_cliente(?);");
            pst.setInt(1, (Integer) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");
            llenarLClientes();
            cb_correo.removeAllItems();
            cb_telefono.removeAllItems();
            lbl_nombre.setText("");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_eliminar_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_tActionPerformed
        Connection con = null;
        PreparedStatement pst = null;
        try{
            if(cb_telefono.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "El cliente no tiene ningun telefono");
            }else{
                String telefono = cb_telefono.getSelectedItem().toString();
                con = dsm.getDataSource().getConnection();
                pst = con.prepareStatement("CALL eliminar_telefono(?,?);");
                pst.setInt(1, (Integer) tb_clientes.getValueAt(tb_clientes.getSelectedRow(), 0));
                pst.setString(2, telefono);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Telefono eliminado exitosamente");
                llenarCBTelefonos();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_eliminar_tActionPerformed

    private void btn_cerrar_sesion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sesion3ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cerrar_sesion3ActionPerformed
   
    public void llenarLClientes() {

               // Crea un DefaultTableModel con los nombres de las columnas
               DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "CLIENTE"}, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Bloquea todas las celdas para que no sean editables
                    }
                };
                //Ajustar la tabla
                Font newFont = new Font("Segoe UI", Font.PLAIN, 14); // Crear una nueva fuente
                tb_clientes.setFont(newFont); // Establecer la nueva fuente en el tb_clientes
                tb_clientes.getTableHeader().setFont(newFont); // Establecer la nueva fuente en el nombre de las columnas de tb_clientes
                tb_clientes.setRowHeight(tb_clientes.getFont().getSize() + 10); // Ajustar el alto de las filas según la nueva fuente
                // Obtiene la lista de equipos de la base de datos
                try{
                    mListaClientes = getListaClientes();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                

                 // Itera sobre la lista de equipos y añade cada uno al tableModel
                 Iterator<Clientes> iterador = mListaClientes.iterator();
                 while (iterador.hasNext()) {
                    Clientes mClientes = iterador.next();
                    System.out.println("Agregando cliente: " + mClientes);
                    // Añade una fila con los datos de cada objeto Equipos
                    tableModel.addRow(new Object[]{mClientes.getIdCliente(), mClientes.getNombreCliente()});
                }
                // Asigna el DefaultTableModel a la JTable
                tb_clientes.setModel(tableModel);
                TableColumn columnaID = tb_clientes.getColumnModel().getColumn(0);
                columnaID.setPreferredWidth(120); // Ancho preferido para la columna "ID"
                columnaID.setMinWidth(120); // Ancho mínimo para la columna "ID"
                columnaID.setMaxWidth(120); // Ancho máximo para la columna "ID"
        }
        
    public ArrayList getListaClientes() throws SQLException{
            ArrayList<Clientes> mListaClientes = new ArrayList<>();
            Clientes mClientes;
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet resultado = null;
            try{
                con = dsm.getDataSource().getConnection();
                pst = con.prepareStatement("CALL buscar_cliente(?);");
                pst.setString(1, txt_buscar.getText().trim());
                resultado = pst.executeQuery();
                    while(resultado.next()){
                        System.out.println("Procesando fila...");
                        mClientes = new Clientes();
                        mClientes.setIdCliente(resultado.getInt("Id"));
                        mClientes.setNombreCliente(resultado.getString("Nombre"));
                        //mClientes.setEstadoCliente(resultado.getBoolean("EstadoCliente")); //descomentar en caso de necesitar estado del cliente
                        mListaClientes.add(mClientes);                
                    }
                    System.out.println("Se ha procesado todo el ResultSet");
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
        if (resultado != null) {
            try {
                resultado.close();
                System.out.println("resultado cerrado");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
                System.out.println("pst cerrado");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("con cerrado");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            }
        return mListaClientes;
        }
        
    public void llenarCBCorreos(){
            System.out.println("Entrando a llenarCBCorreos()");
            cb_correo.removeAllItems();
            try{
                mListaCorreos = this.getListaCorreos();
            }catch(SQLException e){
                e.printStackTrace();
            }
            Iterator iterador = mListaCorreos.iterator();
            System.out.println("Agregando correos: " + mListaCorreos); // Verifica la salida en la consola
            while (iterador.hasNext()) {
                Clientes mClientes = (Clientes) iterador.next();
                if (mClientes != null) {
                    System.out.println("Agregando correos: " + mClientes); // Verifica la salida en la consola
                    cb_correo.addItem(mClientes);
                }
            }
        }
        
    //METODOS PARA LLENAR LA COMBO BOX DE CORREOS
    public ArrayList getListaCorreos() throws SQLException{
                ArrayList mListaCorreos = new ArrayList();
                Clientes mClientes = null;
                Connection con = null;
                PreparedStatement pst = null;
                ResultSet resultado = null;
                try{
                    con = dsm.getDataSource().getConnection();
                    pst = con.prepareStatement("CALL consulta_correo(?);");
                    pst.setString(1, lbl_nombre.getText().trim()); //Obtiene el nombre para añadirlo a la consulta
                    resultado = pst.executeQuery();
                        while(resultado.next()){
                        System.out.println("Procesando fila...");
                        mClientes = new Clientes();
                        mClientes.setCorreoCliente(resultado.getString("correo"));
                        mListaCorreos.add(mClientes);
                        mClientes.setComboBox(1);
                        }
                        System.out.println("Se ha procesado todo el ResultSet");
                }catch(SQLException e){
                    e.printStackTrace();
                }finally{
                    if(resultado != null){
                        resultado.close();
                        System.out.println("Conexion resultado: "+resultado);
                    }
                    if(pst != null){
                        pst.close();
                        System.out.println("Conexion pst: "+pst);
                    }
                    if(con != null){
                        con.close();
                        System.out.println("Conexion con: "+con);
                    }
                }
        return mListaCorreos;
        }
        
    public void llenarCBTelefonos(){
            System.out.println("Entrando a llenarCBTelefonos()");
            cb_telefono.removeAllItems();
            try{
                mListaTelefonos = this.getListaTelefonos();
            }catch(SQLException e){
                e.printStackTrace();
            }
            Iterator iterador = mListaTelefonos.iterator();
            System.out.println("Agregando telefonos: " + mListaTelefonos); // Comprobar que se esta llenando la combo box en consola
            while (iterador.hasNext()){
                Clientes mClientes = (Clientes) iterador.next();
                if (mClientes != null) {
                    System.out.println("Agregando telefonos: " + mClientes); // Comprobar que se esta llenando la combo box en consola
                    cb_telefono.addItem(mClientes);
                }
            }
        }
        
        //METODOS PARA LLENAR LA COMBO BOX DE TELEFONO
    public ArrayList<Clientes> getListaTelefonos() throws SQLException{
        ArrayList<Clientes> mListaTelefonos = new ArrayList();
        Clientes mClientes = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultado = null;
        try{
            con = dsm.getDataSource().getConnection();
            pst = con.prepareStatement("CALL consulta_numero(?);");
            pst.setString(1, lbl_nombre.getText().trim()); //Obtiene el nombre para añadirlo a la consulta
            resultado = pst.executeQuery();
                    while(resultado.next()){
                        System.out.println("Procesando numero...");
                        mClientes = new Clientes();
                        mClientes.setNumeroCliente(resultado.getString("telefono"));
                        mClientes.setComboBox(2);
                        mListaTelefonos.add(mClientes);
                    }
                    System.out.println("Se ha procesado todo el ResultSet");         
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(resultado != null){
                resultado.close();
            }
            if(pst != null){
                pst.close();
            }
            if(con != null){
                con.close();
            }
        }
        return mListaTelefonos;
    }

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
            java.util.logging.Logger.getLogger(ConsultaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados mEmpleados = new Empleados();
                new ConsultaClientes(mEmpleados).setVisible(true);
            }
        });
    }
    
    private void Monitoreo(){
        HikariDataSource ds = dsm.getDataSource();
        HikariPoolMXBean poolBean = ds.getHikariPoolMXBean();

        System.out.println("Conexiones Totales: " + poolBean.getTotalConnections());
        System.out.println("Conexiones Activas: " + poolBean.getActiveConnections());
        System.out.println("Conexiones Inactivas: " + poolBean.getIdleConnections());
        System.out.println("Conexiones Esperando: " + poolBean.getThreadsAwaitingConnection());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_c;
    private javax.swing.JButton btn_agregar_t;
    private javax.swing.JButton btn_cerrar_sesion3;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_eliminar_c;
    private javax.swing.JButton btn_eliminar_t;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<Clientes> cb_correo;
    private javax.swing.JComboBox<Clientes> cb_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
