package org.scars.bookmanager.utils;

import java.sql.DriverManager;

import java.sql.Connection;

public class DbUtil {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
    private String dbUserName = "root";
    private String dbPassword = "password";

    public Connection getConnection() throws Exception {
        Class.forName(dbDriver);
        Connection con = (Connection) DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }

}
