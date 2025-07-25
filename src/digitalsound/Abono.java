
package digitalsound;

import clases.DataSourceManager;
import clases.ProductoApartado;
import clases.Empleados;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Abono extends javax.swing.JFrame {
    DataSourceManager dsm = new DataSourceManager();
    ArrayList mListaProducto;
    int idApartado;
    Empleados mEmpleados;
    listapartados mLista;

    /**
     * Creates new form Abono
     * @param id
     * @param empleados
     */
    public Abono(int id, listapartados lista, Empleados empleados){
        initComponents();
        idApartado = id;
        mEmpleados = empleados;
        mLista = lista;
        configurarVentana();
        llenarCBProducto();
    }
    private void configurarVentana(){
        this.setLocationRelativeTo(null); //Iniciar ventana en el medio de la pantalla
        this.setResizable(false); //Quitar la opcion para cambiar el tamaño
        this.setSize(400, 300); //Establecer el tamaño predeterminado
        this.setTitle("Realizar abono"); //Establecer el titulo de la ventana
        dsm.setTipo(mEmpleados.getTipo());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cb_producto = new javax.swing.JComboBox<>();
        txt_abono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_abonar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cb_producto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        txt_abono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_abono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_abonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_abonoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("$");

        btn_abonar.setText("Abonar");
        btn_abonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btn_abonar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_abonar)
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

    private void txt_abonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_abonoKeyTyped
        //Verificar si el caracter ingresado es numero, punto o un espacio vacio
        char caracter = evt.getKeyChar();
        if(((!Character.isDigit(caracter))) 
            && (caracter != '.' || txt_abono.getText().contains(".")))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_abonoKeyTyped

    private void txt_abonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_abonoKeyPressed
        int tecla = evt.getKeyCode();
        if((tecla == KeyEvent.VK_BACK_SPACE)
            || (tecla == KeyEvent.VK_UP)
            || (tecla == KeyEvent.VK_DOWN)
            || (tecla == KeyEvent.VK_LEFT)
            || (tecla == KeyEvent.VK_RIGHT)
            || (tecla == KeyEvent.VK_SHIFT)){
            return;
        }
        evt.consume();
    }//GEN-LAST:event_txt_abonoKeyPressed

    private void btn_abonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abonarActionPerformed
        ProductoApartado mProductoApartado = null;
        double abono = Integer.parseInt( txt_abono.getText().trim());
        if(abono  > 1000000){
            JOptionPane.showMessageDialog(null, "El abono ingresado no puede ser mayor que $1,000,000");
        }else{
            Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet resultado = null;
        //obtener id del producto
        ProductoApartado productoSeleccionado = (ProductoApartado) cb_producto.getSelectedItem();
        String idProducto = productoSeleccionado.getId();
        
        try{
            con = dsm.getDataSource().getConnection();
            pst2 = con.prepareStatement("CALL buscar_producto_apartado(?);");
            pst2.setInt(1, idApartado);
            resultado = pst2.executeQuery();
            while(resultado.next()){
                if (resultado.getString("idProducto").equals(idProducto)) {
                    mProductoApartado = new ProductoApartado();
                    mProductoApartado.setIdProdApartado(resultado.getInt("idProdApartado"));
                    mProductoApartado.setId(resultado.getString("idProducto"));
                    mProductoApartado.setSaldo(resultado.getDouble("SALDO"));
                    break; // Salir del bucle una vez encontrado el producto
                }
            }
            System.out.println("ID Producto seleccionado: "+productoSeleccionado.getId());
            double saldoIngresado = Double.parseDouble(txt_abono.getText().trim());
            System.out.println("Saldo ingresado: "+saldoIngresado);
            double saldoGuardado = mProductoApartado.getSaldo();
            System.out.println("Saldo guardado: "+saldoGuardado);
            String fechaFormateada = obtenerFecha();
            if(saldoIngresado > saldoGuardado){
                double cambio = saldoIngresado - saldoGuardado;
                System.out.println("Cambio:"+cambio);
                JOptionPane.showMessageDialog(null, "El cambio es: "+cambio);
                double abonoIngresado = saldoIngresado - cambio;
                System.out.println("Abono ingresado: "+abonoIngresado);
                //si el numero ingresado es mayor
                pst = con.prepareStatement("CALL insercion_abono(?,?,?)");
                pst.setInt(1, mProductoApartado.getIdProdApartado());
                pst.setString(2, fechaFormateada);
                pst.setDouble(3, abonoIngresado); 
                pst.executeUpdate(); //ejecutar query
                JOptionPane.showMessageDialog(null, "Abono realizado exitosamente");
                mLista.llenarLApartados();
                mLista.llenarLProductos(idApartado);
            }else{
                //si el numero ingresado no es mayor
                pst = con.prepareStatement("CALL insercion_abono(?,?,?)");
                pst.setInt(1, mProductoApartado.getIdProdApartado());
                pst.setString(2, fechaFormateada);
                pst.setString(3, txt_abono.getText().trim());
                pst.executeUpdate(); //ejecutar query
                JOptionPane.showMessageDialog(null, "Abono realizado exitosamente");
                mLista.llenarLApartados();
                mLista.llenarLProductos(idApartado);
                txt_abono.setText("");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(resultado != null){
                try {
                    resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Abono.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Abono.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(pst2 != null){
                try{
                    pst2.close();
                }catch(SQLException ex){
                    Logger.getLogger(Abono.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Abono.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.dispose();
        }
        
    }//GEN-LAST:event_btn_abonarActionPerformed
   //Metodo para obtener la fecha actual
    private String obtenerFecha(){
        // Obtener la fecha y hora actuales
        LocalDateTime fechaActual = LocalDateTime.now();
        // Definir el formato de la fecha y hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Formatear la fecha y hora
        String fechaFormateada = fechaActual.format(formato);
        return fechaFormateada;
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
            java.util.logging.Logger.getLogger(Abono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Abono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Abono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Abono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados mEmpleados = new Empleados();
                listapartados mLista = new listapartados(mEmpleados);
                new Abono(2,mLista, mEmpleados).setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abonar;
    private javax.swing.JComboBox<ProductoApartado> cb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_abono;
    // End of variables declaration//GEN-END:variables
    public void llenarCBProducto(){
        System.out.println("Entrando a llenarCBProducto()");
            cb_producto.removeAllItems();
            try{
                mListaProducto = this.getListaProducto();
            }catch(SQLException e){
                e.printStackTrace();
            }
            Iterator iterador = mListaProducto.iterator();
            System.out.println("Agregando Productos: " + mListaProducto); // Comprobar que se esta llenando la combo box en consola
            while (iterador.hasNext()) {
                ProductoApartado mProductoApartado = (ProductoApartado) iterador.next();
                if (mProductoApartado != null) {
                    System.out.println("Agregando productos " + mProductoApartado); // Comprobar que se esta llenando la combo box en consola
                    cb_producto.addItem(mProductoApartado);
                }
            }
    }
    
    public ArrayList getListaProducto() throws SQLException{
        ArrayList mListaProducto = new ArrayList();
        ProductoApartado mProductoApartado = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultado = null;
        try{            
            con = dsm.getDataSource().getConnection();
            pst = con.prepareStatement("CALL buscar_producto_apartado(?);"); //falta implementar este procedimiento almacenado a la nueva base de datos
            pst.setInt(1, idApartado); //Obtiene el nombre para añadirlo a la consulta
            resultado = pst.executeQuery();
            System.out.println("ID: "+idApartado);
            while(resultado.next()){
                System.out.println("Procesando productos...");
                mProductoApartado = new ProductoApartado();
                mProductoApartado.setNombre(resultado.getString("NombreProducto"));
                mListaProducto.add(mProductoApartado);
                mProductoApartado.setId(resultado.getString("idProducto")); //implementar metodo a la clase clientes (checar en la compu) 
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
        return mListaProducto;
    }
}
