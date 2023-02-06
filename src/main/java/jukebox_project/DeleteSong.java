package jukebox_project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;
public class DeleteSong extends database{
        static Connection con = getConnection();
        static ArrayList<Songs> songs = new ArrayList<>();
        public static void deleteSong(int id) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM songs WHERE songid = " + id);
                System.out.println("Song with id " + id + " has been deleted from the database.");
                 }
            catch (SQLException e)
            {
                System.err.println("Error deleting song: " + e.getMessage());
            }
        }
    }





