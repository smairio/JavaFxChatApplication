package com.chatroom.chatroomfx.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseHandler {
    private Connection connection;

    public DatabaseHandler() throws SQLException, IOException {
        Properties properties = loadProperties();
        String jdbcUrl = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        this.connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
        if (inputStream == null) {
            throw new IOException("Properties file not found");
        }
        properties.load(inputStream);
        return properties;
    }


    public PreparedStatement prepareStatement(String query) throws SQLException{
        return this.connection.prepareStatement(query);
    } 
}
