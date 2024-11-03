package org.webpro.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String namedatabase = "/home/tiago/IdeaProjects/webpro/webprodb";
    String[] database = namedatabase.split("/");
    private String url = "jdbc:sqlite:" + namedatabase;
    private Connection connection = null;

    File f = new File(namedatabase);

    public Connection getConnection() {
        return connection;
    }

    public ConnectionDB() {
        Connect();
    }

    public void Connect() {

        if (f.exists()) {

            if (connection == null) {

                try {
                    Class.forName("org.sqlite.JDBC");
                    try {
                        connection = DriverManager.getConnection(url);
                        connection.setAutoCommit(false);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }

        } else {

            System.out.println("database " + database[6] + " is not found");

        }

    }

}
