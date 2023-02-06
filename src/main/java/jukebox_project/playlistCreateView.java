package jukebox_project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class playlistCreateView extends database {
    playlistSongs songs = new playlistSongs();
   // AudioInputStream audioInputStream = new AudioInputStream();
    static Scanner sc = new Scanner(System.in);
    public Object createPlaylist(String rock) {
        Connection con = getConnection();
        List<Integer> songIds = new ArrayList<>();
        System.out.println("Please Create ID for your Playlist");
        int playlistid = sc.nextInt();
        System.out.println("Please enter name of the playlist: ");
        String nameOfPlaylist = sc.next();
        System.out.println("User id");
        int userId = sc.nextInt();

        try (Statement stmt = con.createStatement()) {
            //for (int i = 0; i < songIds.size(); i++) {
            int result = stmt.executeUpdate("INSERT INTO playlist (playlistid, playlistname, userid) VALUES (" + playlistid + ", '" + nameOfPlaylist + "', " + userId + ");");
            //  int result = stmt.executeUpdate("INSERT INTO playlist (playlistname, songid, userid) VALUES ('" + nameOfPlaylist + "', " + songIds.get(i) + ",)");
            System.out.println(result + " row(s) affected. The song has been added to the playlist.");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static List<Playlist> viewPlaylist() {
        List<Playlist> viewplaylist = new ArrayList<>();
        System.out.println("Enter Your User ID ");
        int user = sc.nextInt();
        Connection con = getConnection();
        try {
            String playlist = "select * from playlist ";
            PreparedStatement pstmt = con.prepareStatement(playlist);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Playlist playlist1 = new Playlist();
                playlist1.setPlaylistid(rs.getInt("playlistid"));
                playlist1.setPlaylistname(rs.getString("playlistname"));
                playlist1.setUserid(rs.getInt("userid"));

                if (playlist1.getUserid() == user) {
                    viewplaylist.add(playlist1);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return viewplaylist;
    }

    public void displayPlaylist(List<Playlist> playlists) {
        System.out.println("------------------------------------------------");
        System.out.println("Playlist ID | Playlist Name | User ID");
        System.out.println("-------------------------------------------------");
        for (Playlist playlist : playlists) {
            System.out.printf("%12d | %15s | %8d\n", playlist.getPlaylistid(), playlist.getPlaylistname(),
                    playlist.getUserid());
        }
    }

}













