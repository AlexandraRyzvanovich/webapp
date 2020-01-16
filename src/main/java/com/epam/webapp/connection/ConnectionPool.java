package com.epam.webapp.connection;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;

    private static ReentrantLock connectionsLock = new ReentrantLock();
    private static ConnectionPool conn;

    private ConnectionPool(){
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
    }

    public static ConnectionPool getInstance(){
        if( conn == null){
        connectionsLock.tryLock();
        ConnectionPool temp;
        try {
            if (conn == null) {
                temp = new ConnectionPool();
                conn = temp;
            }
        } finally {
            connectionsLock.unlock();
        }
    }
        return conn;
}

    public void returnConnection(ProxyConnection proxyConnection){
        connectionsLock.lock();
        try{
            if(connectionsInUse.contains(proxyConnection)){
                availableConnections.offer(proxyConnection);
            }
        }
        finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() throws SQLException {
        return ConnectionFactory.create();
    }
}
