/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package digitalsound;

import clases.DataSourceManager;
import clases.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AgregarCorreo extends javax.swing.JFrame {
    Empleados mEmpleados = new Empleados();
    ConsultaClientes mConsulta;
    DataSourceManager dsm = new DataSourceManager();
    /**
     * Creates new form AgregarCorreo
     */
    public AgregarCorreo(int idCliente,ConsultaClientes consulta, Empleados empleado) {
        empleado.setTipo("Gerente");
        initComponents();
        configurarVentana();
        mEmpleados = empleado;
        mConsulta = consulta;
        dsm.setTipo(mEmpleados.getTipo().trim());
        lbl_cliente.setText(""+idCliente);
        System.out.println("ID CLIENTE: "+lbl_cliente.getText());
    }
    private void configurarVentana(){
        this.setTitle("Digital Sound - Agregar correo");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_cliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();

        lbl_cliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_cliente.setText("Cliente:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(208, 31, 36));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Ingrese el correo a registrar");

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(btn_registrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_registrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        if(txt_correo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Es necesario ingresar un correo");
        }else{
            int id = Integer.parseInt(lbl_cliente.getText()); //obtener id del cliente
            System.out.println(""+id);
            try{
                registrarCorreo(id); //llamar al metodo para registrar el correo con la id del cliente
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_registrarActionPerformed
    private void registrarCorreo(int idCliente) throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
            try{
                con = dsm.getDataSource().getConnection();
                pst = con.prepareStatement("CALL agregar_correo(?,?);"); //llamada a la consulta de base de datos
                pst.setInt(1, idCliente); //ingresa el primer ? (idCliente)
                pst.setString(2, txt_correo.getText().trim()); //ingresa el segundo ? (correo)
                pst.executeUpdate(); //ejecutar query
                JOptionPane.showMessageDialog(null, "Correo registrado exitosamente");
                mConsulta.llenarCBCorreos();
                txt_correo.setText("");
                }catch(SQLException e){
                    e.printStackTrace();
                }finally{
                    if(pst != null){
                        pst.close();
                    }
                    if(con != null){
                        con.close();
                    }
                }
    }
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
            java.util.logging.Logger.getLogger(AgregarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados mEmpleados = new Empleados();
                ConsultaClientes mConsulta = new ConsultaClientes(mEmpleados);
                new AgregarCorreo(0,mConsulta, mEmpleados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JTextField txt_correo;
    // End of variables declaration//GEN-END:variables
}
