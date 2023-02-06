package jukebox_project;

import java.sql.*;
public class database {

    public static Connection getConnection(){
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           //  System.out.println("Driver Loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","trisha123");
           //  System.out.println("Connection Created!!");
        }
        catch (NullPointerException | SQLException e)
        {
            System.out.println("problem is "+e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


}
