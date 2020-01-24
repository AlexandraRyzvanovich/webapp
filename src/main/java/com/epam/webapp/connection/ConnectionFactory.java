package com.epam.webapp.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectionFactory {
    private static InitialContext ic;
    private static DataSource ds;

    public static ProxyConnection create() throws  SQLException {
        try {
            ic = new InitialContext();
            ds = (DataSource)
                    ic.lookup("java:/comp/env/jdbc/fitness");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection connection = ds.getConnection();

        return new ProxyConnection(connection, ConnectionPool.getInstance());

    }
}
