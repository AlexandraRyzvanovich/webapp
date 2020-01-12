package com.epam.webapp.connection;

import java.sql.*;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/fitnessdb";
    private static final String DB_NAME = "fitnessdb";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String unicode = "?useUnicode=yes&characterEncoding=UTF-8";

    public static ProxyConnection create() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection conn =  DriverManager.getConnection(URL, USER,
                PASS);
        return new ProxyConnection(conn, ConnectionPool.getInstance()) ;
    }
}
