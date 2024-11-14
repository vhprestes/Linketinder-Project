package org.acczg.connection

import java.sql.DriverManager
import java.sql.Connection

class Connect {

    private static Connect instance
    private Connection connection

    private Connect() {
        try {
            Properties props = new Properties()
            props.setProperty("user", "postgres")
            props.setProperty("password", "postgres")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/postgres"
//            class.forName
            Class.forName("org.postgresql.Driver")
            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)
        } catch (Exception e) {
            e.printStackTrace()
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage())
        }
    }

    static Connect getInstance() {
        if (instance == null) {
            synchronized (Connect.class) {
                if (instance == null) {
                    instance = new Connect()
                }
            }
        }
        return instance
    }

    Connection connect() {
        return connection
    }
}