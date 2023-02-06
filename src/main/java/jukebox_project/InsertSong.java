package jukebox_project;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSong extends database
{
    Scanner sc = new Scanner(System.in);
    int choice;
    public int insertInSongTable() {
        Connection con = getConnection();
        do {
            System.out.println("please enter Song ID");
            int songId = sc.nextInt();
            System.out.println("please enter name of the song");
            String songName = sc.next();
            System.out.println("please enter id of the artist");
            int artistId = sc.nextInt();
            System.out.println("please enter id of the genre");
            int genreId = sc.nextInt();
            System.out.println("please enter id of the album");
            int albumId = sc.nextInt();
            System.out.println("please enter duration of the song");
            String songDuration = sc.next();
            //Give path of the songlist
            String path="C:\\My Drive\\NIIT\\Jukebox-1\\Jukebox\\SongsList";
            String pathName = path + songName;
            //executeUpdate method returns the number of rows affected by the update statement, which is stored in the res variable
            try {
                Statement st = con.createStatement();
                int res = st.executeUpdate("insert into songs values(" + songId + ",'" + songName + "','" + pathName + "','" + songDuration + "', " + artistId + "," + genreId + "," + albumId + ")");

                System.out.println("Record Inserted in songs table :" + res);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("if you want to add another song details then please enter 1 to continue or enter 0 to exit");
            choice = sc.nextInt();
            //if choice is 1 , repeat the process
        }while(choice ==1);
        System.out.println("your details have been saved in database");

        return 0;
    }

}