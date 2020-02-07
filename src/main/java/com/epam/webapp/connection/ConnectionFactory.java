package com.epam.webapp.connection;

import com.epam.webapp.exception.ConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PROPERTIES_FILE_PATH = "src/main/webapp/jdbc.properties";

    public static ProxyConnection create(ConnectionPool connectionPool) {
        Path path = Paths.get(PROPERTIES_FILE_PATH);
        InputStream file;
        try {
            file = Files.newInputStream(path);
            Properties properties = new Properties();
            properties.load(file);
            String url = (String) properties.get(URL);
            String username = (String) properties.get(USERNAME);
            String password = (String) properties.get(PASSWORD);
            Connection connection = DriverManager.getConnection(url, username, password);
            return new ProxyConnection(connection, connectionPool);
        } catch (IOException | SQLException e) {
            throw new ConnectionException("Get connection failed");
        }
    }
}
