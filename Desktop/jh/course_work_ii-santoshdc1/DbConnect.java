package cw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

    public Statement connection(){
        Connection con;
        Statement stmt=null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3310/javacoursework2","root","");

            stmt=con.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stmt;
    }
}
