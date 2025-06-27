package com.tienda.bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ConexionBD {
private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/tienda_inventario");
        config.setUsername("postgres");
        config.setPassword("jeff0831");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);


        dataSource = new HikariDataSource(config);
    }

    public static DataSource obtnerConexionBD() throws SQLException {
        return dataSource;
    }


}
