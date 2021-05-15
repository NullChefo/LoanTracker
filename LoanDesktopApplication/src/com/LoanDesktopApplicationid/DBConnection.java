package com.LoanDesktopApplicationid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection connection=null;

    static Connection getConnection(){

        try {
            Class.forName("org.h2.Driver");
            // #TODO change the connection
            connection= DriverManager.getConnection("jdbc:h2:/Users/stefankehayov/code/H2 DATABASE/h2/bin/LoanApp","sa","1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
