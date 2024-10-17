package org.acczg.connection

import java.sql.DriverManager
import java.sql.Connection

class Connect {

    private Connection connection

    Connection connect() {
        try {
            Properties props = new Properties()
            props.setProperty("user", "postgres")
            props.setProperty("password", "postgres")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/postgres"
            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)
        } catch (Exception e) {
            e.printStackTrace()
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage())
        }
        return this.connection
    }
}