package com.epam.webapp.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectionFactory {
    private static InitialContext ic;
    private static DataSource ds;

    private static final String URL = "jdbc:mysql://localhost:3306/fitnessdb";
    private static final String DB_NAME = "fitnessdb";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String unicode = "?useUnicode=yes&characterEncoding=UTF-8";

    public static ProxyConnection create() throws  SQLException {
        try {
            ic = new InitialContext();
            ds = (DataSource)
                    ic.lookup("java:/comp/env/jdbc/fitness");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection connection = ds.getConnection();

        return new ProxyConnection(connection, ConnectionPool.getInstance() );

    }
}
