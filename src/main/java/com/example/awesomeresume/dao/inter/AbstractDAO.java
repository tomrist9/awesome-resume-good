package com.example.awesomeresume.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {
    public static Connection connect() throws SQLException {


        String url="jdbc:mysql://localhost:3306/resume";
        String username="root";
        String password="postgres";
        Connection connection= DriverManager.getConnection(url, username, password);
        return connection;
    }
}
