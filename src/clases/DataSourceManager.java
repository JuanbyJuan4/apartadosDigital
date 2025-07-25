package clases;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceManager {
    private String tipo;
    private HikariDataSource dataSource;

    public DataSourceManager() { //constructor vacio
    }

    public DataSourceManager(String tipo) { //
        this.tipo = tipo;
        initDataSource(); // Inicia el DataSource al crear la instancia
    }

    private void initDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/sistemaapartado");
        
        if("Gerente".equals(this.tipo) ){
            config.setUsername("gerente-ds");
            config.setPassword("admin12345");
        }else if("Empleado".equals(this.tipo)){
            config.setUsername("empleado-ds");
            config.setPassword("12345");
        }
        
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);
        config.setLeakDetectionThreshold(2000);
        dataSource = new HikariDataSource(config);
        System.out.println("Conexion exitosa!");
    }
    public HikariDataSource getDataSource() {
        if (dataSource == null) {
            initDataSource(); // Inicializa el DataSource si no está inicializado
            
        }
        return dataSource;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        initDataSource(); // Re-inicializa el DataSource si se cambia el tipo
    }
}