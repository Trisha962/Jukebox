package jukebox_project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class searchPlaylist extends database
{
    Scanner sc = new Scanner(System.in);

    public List<Playlist> search() {
        // The list is initialized as an ArrayList.
        List<Playlist> playlist = new ArrayList<>();
        Connection con = getConnection();
        System.out.println("Search Here:");
        String str = sc.next();
        try
        {
            String query = "select * from playlist where playlistname like '%" + str + "%';";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Playlist playlist1 = new Playlist();
                playlist1.setPlaylistid(rs.getInt("playlistid"));
                playlist1.setPlaylistname(rs.getString("playlistname"));
                playlist1.setUserid(rs.getInt("userid"));
                playlist.add(playlist1);
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return playlist;
    }

    public void printPlaylist(List<Playlist> playlists)
    {
        System.out.println("--------------------------------------------");
        System.out.println("Playlist ID    | Playlist Name    | User ID");
        System.out.println("--------------------------------------------");
        for (Playlist playlist : playlists)
        {
            System.out.printf("%12d  | %15s  | %8d\n", playlist.getPlaylistid(), playlist.getPlaylistname(), playlist.getUserid());

        }
    }
    public List<Songs> ListenplaylistSongs() throws SQLException
    {
        Connection con = getConnection();
        List<Songs> playlistSongs= new ArrayList<>();
      //  System.out.println("Which playlist you want to see: ");
        System.out.println("Enter Playlist ID: ");
        int choice= sc.nextInt();
        try
        {
            String Query = "   select s.songid,songname,s.path from songs s, playlist p, playlistsongs ps where ps.playlistid=" + choice + " and p.playlistid = ps.playlistid and s.songid = ps.songid";
            PreparedStatement stmt = con.prepareStatement(Query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
               Songs songs= new Songs();
               songs.setSongid(rs.getInt("songid"));
               songs.setSongname(rs.getString("songname"));
               playlistSongs.add(songs);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return playlistSongs;
    }
    public void printListenPlaylist(List<Songs>song)
    {
        System.out.println("--------------------------------------------");
        System.out.println("    Song ID     |    Song  Name    ");
        System.out.println("--------------------------------------------");
        for (Songs playlist :song)
        {
            System.out.printf("%12d  | %15s \n", playlist.getSongid(), playlist.getSongname());
        }


    }

    public List<Album> searchByAlbum()
    {
        List<Album> albums = new ArrayList<>();
        Connection con = getConnection();
        System.out.println("Search Here:");
        String str = sc.next();
        try {
            String query = "select * from album  where albumname like '%" + str + "%';";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Album album = new Album();
                album.setAlbumid(rs.getInt("albumid"));
                album.setAlbumName(rs.getString("albumname"));

                albums.add(album);
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return albums;
    }

    public void printAlbum(List<Album> albums)
    {
        System.out.println("--------------------------------------------");
        System.out.println("Album ID    | Album Name");
        System.out.println("--------------------------------------------");
        for (Album album : albums) {
            System.out.printf("%12d  | %15s\n", album.getAlbumid(), album.getAlbumname());
        }
    }
    public List<Songs> ListenAlbumSongs()  {
        Connection con = getConnection();
        List<Songs> albumSongs= new ArrayList<>();

        System.out.println("Enter Album ID: ");
        int choice= sc.nextInt();
        try {
            String Query = "select songid,songname  from songs where albumid="+choice;
            PreparedStatement stmt = con.prepareStatement(Query);
         //  stmt.setInt(1, choice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Songs song= new Songs();
                song.setSongid(rs.getInt("songid"));
                song.setSongname(rs.getString("songname"));
                albumSongs.add(song);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return albumSongs;
    }

    public void printListenAlbum(List<Songs>albums1) {
        System.out.println("--------------------------------------------");
        System.out.println("    Song ID     |    Song Name    ");
        System.out.println("--------------------------------------------");
        for (Songs album :albums1) {
            System.out.printf("%12d  | %15s \n", album.getSongid(), album.getSongname());
        }
    }


    public List<Artist> searchByArtist() {
        List<Artist> artist1 = new ArrayList<>();
        Connection con = getConnection();
        System.out.println("Search Here:");
        String str = sc.next();
        try {
            String query = "select * from artist where artistname like '%" + str + "%';";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Artist artist = new Artist();
                artist.setArtistid(rs.getInt("artistid"));
                artist.setArtistname(rs.getString("artistname"));

                artist1.add(artist);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return artist1;
    }

    public void printArtist(List<Artist> artists) {
        System.out.println("--------------------------------------------");
        System.out.println("Artist ID    | Artist Name");
        System.out.println("--------------------------------------------");
        for (Artist artist : artists) {
            System.out.printf("%12d  | %15s\n", artist.getArtistid(), artist.getArtistname());
        }
    }


    public List<Genre> searchByGenre() {
        List<Genre> genree = new ArrayList<>();
        Connection con = getConnection();
        System.out.println("Search Here:");
        String str = sc.next();
        try {
            String query = "select * from genre  where genrename like '%" + str + "%';";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setGenreid(rs.getInt("genreid"));
                genre.setGenrename(rs.getString("genrename"));

                genree.add(genre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genree;
    }

    public void printGenre(List<Genre> genre) {
        System.out.println("--------------------------------------------");
        System.out.println("Genre ID    | Genre Name");
        System.out.println("--------------------------------------------");
        for (Genre artist : genre) {
            System.out.printf("%12d  | %15s\n", artist.getGenreid(), artist.getGenrename());
        }
    }
    public List<Songs> ListenGenreSongs()  {
        Connection con = getConnection();
        List<Songs> genreplay= new ArrayList<>();
      //  System.out.println("Which playlist you want to see: ");
        System.out.println("Enter Genre ID: ");
        int choice= sc.nextInt();
        try {
            String Query = "select songid,songname  from songs where genreid="+choice;
            PreparedStatement stmt = con.prepareStatement(Query);
           // stmt.setInt(1, choice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Songs songs= new Songs();
                songs.setSongid(rs.getInt("songid"));
                songs.setSongname(rs.getString("songname"));
                genreplay.add(songs);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return genreplay;
    }

    public void printListenGenre(List<Songs>genre) {
        System.out.println("--------------------------------------------");
        System.out.println("    Song ID     |    Song  Name    ");
        System.out.println("--------------------------------------------");
        for (Songs genres :genre) {
            System.out.printf("%12d  | %15s \n", genres.getSongid(),genres.getSongname());
        }
    }
    public List<Songs> ListenArtistSongs()  {
        Connection con = getConnection();
        List<Songs> artistplay= new ArrayList<>();
       // System.out.println("Which playlist you want to see: ");
        System.out.println("Enter Artist ID: ");
        int choice= sc.nextInt();
        try {
            String Query = "select songid,songname from songs where artistid="+ choice;
            PreparedStatement stmt = con.prepareStatement(Query);
           // stmt.setInt(1, choice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Songs artist= new Songs();
                artist.setSongid(rs.getInt("songid"));
                artist.setSongname(rs.getString("songname"));
                artistplay.add(artist);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return artistplay;
    }

    public void printListenArtist(List<Songs>artists) {
        System.out.println("--------------------------------------------");
        System.out.println("    Song ID     |    Song  Name    ");
        System.out.println("--------------------------------------------");
        for (Songs artist :artists) {
            System.out.printf("%12d  | %15s \n", artist.getSongid(),artist.getSongname());
        }
    }

   public void playPlaylistSongs() {
       Scanner sc = new Scanner(System.in);
       Connection con = getConnection();

       System.out.println("\033[33m" + "--->Please Enter ID Of The Playlist You Want To Retrieve" + "\033[0m");
       int choice = sc.nextInt();

       try
       {
           String loginDet = "select s.songid,songname,s.path from songs s, playlist p, playlistsongs ps where ps.playlistid=" + choice + " and p.playlistid = ps.playlistid and s.songid = ps.songid";
           PreparedStatement Stmt = con.prepareStatement(loginDet);
           //  The ResultSet rs stores the results of the query.
           ResultSet rs = Stmt.executeQuery();

           int id =0;
           String path = "";

           while (rs.next()) {
               id = rs.getInt("songid");
               path = rs.getString("path");
               File file = new File(path);
               System.out.println("Please enter the id of the song that you want to play");
               int songId = sc.nextInt();

               if(songId==id)
               {
                   javax.sound.sampled.AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                   Clip clip = AudioSystem.getClip();
                   clip.open(audioStream);

                   String response = "";
                   // The method enters a loop that runs until the user enters 'Q' as the response.
                   while(!response.equals("Q")) {
                       System.out.println("P = play, S = Stop,  L =Loop, Q = Quit, N=Next");
                       System.out.print("--->Enter Your Choice: ");
                       response = sc.next();
                       response = response.toUpperCase();
                       switch(response) {
                           case ("P"): clip.start();  // to play the song
                               // clip.loop(1);    // to play song in a loop
                               break;
                           case ("S"): clip.stop();  // to stop the song
                               break;

                           case("L"):  clip.loop(1);       // to play song in the loop
                               break;
                           case("Q"):
                               System.out.println("Exiting the program...");
                               clip.stop();
                               break;
                           case("N"):
                               clip.close();  // close the current clip

                               // check if there is another song to play
                               //checks if there is a next record in the ResultSet
                               if (rs.next()) {
                                   id = rs.getInt("songid");
                                   path = rs.getString("path");
                                   //creates a new File object using the path obtained
                                   file = new File(path);
                                   //creates an AudioInputStream from the File object "file"
                                   audioStream = AudioSystem.getAudioInputStream(file);
                                   //creates a new Clip object from the default Clip
                                   clip = AudioSystem.getClip();
                                   clip.open(audioStream);
                                   clip.start();
                               } else {
                                   System.out.println("You have reached end of Queue");
                                   response = "Q";
                               }
                               break;


                       }
                   }

               }
           }

       }
       catch(Exception e)
       {
           System.out.println("Error is "+ e);
       }

   }
    public void playArtistSongs() {
        Scanner sc = new Scanner(System.in);
        Connection con = getConnection();

        System.out.println("\033[33m" + "--->Please Enter ID Of The Artist You Want To Retrieve" + "\033[0m");
        int choice = sc.nextInt();

        try
        {
            String loginDet = "select songid,songname ,path from songs where artistid="+ choice;
            PreparedStatement Stmt = con.prepareStatement(loginDet);
            ResultSet rs = Stmt.executeQuery();
            int id =0;
            String path = "";

            while (rs.next()) {
                id = rs.getInt("songid");
                path = rs.getString("path");
                File file = new File(path);
                System.out.println("Please enter the id of the song that you want to play");
                int songId = sc.nextInt();

                if(songId==id)
                {
                    javax.sound.sampled.AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    String response = "";
                    // The method enters a loop that runs until the user enters 'Q' as the response.
                    while(!response.equals("Q")) {
                        System.out.println("P = play, S = Stop,  L =Loop, Q = Quit, N=Next");
                        System.out.print("--->Enter Your Choice: ");
                        response = sc.next();
                        response = response.toUpperCase();
                        switch(response) {
                            case ("P"): clip.start();  // to play the song
                                // clip.loop(1);    // to play song in a loop
                                break;
                            case ("S"): clip.stop();  // to stop the song
                                break;

                            case("L"):  clip.loop(1);       // to play song in the loop
                                break;
                            case("Q"):
                                System.out.println("Exiting the program...");
                                clip.stop();
                                break;
                            case("N"):
                                clip.close();  // close the current clip

                                // check if there is another song to play
                                if (rs.next()) {
                                    id = rs.getInt("songid");
                                    path = rs.getString("path");
                                    file = new File(path);
                                    audioStream = AudioSystem.getAudioInputStream(file);
                                    clip = AudioSystem.getClip();
                                    clip.open(audioStream);
                                    clip.start();
                                } else {
                                    System.out.println("You have reached end of Queue");
                                    response = "Q";
                                }
                                break;


                        }
                    }

                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error is "+ e);
        }

    }
    public void playGenreSongs() {
        Scanner sc = new Scanner(System.in);
        Connection con = getConnection();

        System.out.println("\033[33m" + "--->Please Enter ID Of The Genre You Want To Retrieve" + "\033[0m");
        int choice = sc.nextInt();

        try
        {
            String loginDet = "select songid,songname, path from songs where genreid="+ choice;
            PreparedStatement Stmt = con.prepareStatement(loginDet);
            //  The ResultSet rs stores the results of the query.
            ResultSet rs = Stmt.executeQuery();

            int id =0;
            String path = "";

            while (rs.next()) {


                id = rs.getInt("songid");
                path = rs.getString("path");
                File file = new File(path);
                System.out.println("Please enter the id of the song that you want to play");
                int gId = sc.nextInt();

                if(gId==id)

                {
                    javax.sound.sampled.AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    String response = "";
                    // The method enters a loop that runs until the user enters 'Q' as the response.
                    while(!response.equals("Q")) {
                        System.out.println("P = play, S = Stop,  L =Loop, Q = Quit, N=Next");
                        System.out.print("--->Enter Your Choice: ");
                        response = sc.next();
                        response = response.toUpperCase();
                        switch(response) {
                            case ("P"): clip.start();  // to play the song
                                // clip.loop(1);    // to play song in a loop
                                break;
                            case ("S"): clip.stop();  // to stop the song
                                break;

                            case("L"):  clip.loop(1);       // to play song in the loop
                                break;
                            case("Q"):
                                System.out.println("Exiting the program...");
                                clip.stop();
                                break;
                            case("N"):
                                clip.close();  // close the current clip

                                // check if there is another song to play
                                if (rs.next()) {
                                    id = rs.getInt("songid");
                                    path = rs.getString("path");
                                    file = new File(path);


                                    audioStream = AudioSystem.getAudioInputStream(file);
                                    clip = AudioSystem.getClip();
                                    clip.open(audioStream);
                                    clip.start();
                                } else {
                                    System.out.println("You have reached end of Queue");
                                    response = "Q";
                                }
                                break;


                        }
                    }

                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error is "+ e);
        }

    }
    public void playAlbumSongs() {
        Scanner sc = new Scanner(System.in);
        Connection con = getConnection();

        System.out.println("\033[33m" + "--->Please Enter ID Of The Album You Want To Retrieve" + "\033[0m");
        int choice = sc.nextInt();

        try
        {
            String loginDet = "select songid,songname,path from songs where albumid="+choice;
            PreparedStatement Stmt = con.prepareStatement(loginDet);

            ResultSet rs = Stmt.executeQuery();
            int id =0;
            String path = "";

            while (rs.next()) {
                id = rs.getInt("songid");
                path = rs.getString("path");
                File file = new File(path);
                System.out.println("Please enter the id of the song that you want to play");
                int Id = sc.nextInt();
                javax.sound.sampled.AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);




                if(Id==id)
                {

                    String response = "";
                    // The method enters a loop that runs until the user enters 'Q' as the response.
                    while(!response.equals("Q")) {
                        System.out.println("P = play, S = Stop,  L =Loop, Q = Quit, N=Next");
                        System.out.print("--->Enter Your Choice: ");
                        response = sc.next();
                        response = response.toUpperCase();
                        switch(response) {
                            case ("P"): clip.start();  // to play the song
                                // clip.loop(1);    // to play song in a loop
                                break;
                            case ("S"): clip.stop();  // to stop the song
                                break;

                            case("L"):  clip.loop(1);       // to play song in the loop
                                break;
                            case("Q"):
                                System.out.println("Exiting the program...");
                                clip.stop();
                                break;
                            case("N"):
                                clip.close();  // close the current clip

                                // check if there is another song to play
                                if (rs.next()) {
                                    id = rs.getInt("songid");
                                    path = rs.getString("path");
                                    file = new File(path);
                                    audioStream = AudioSystem.getAudioInputStream(file);
                                    clip = AudioSystem.getClip();
                                    clip.open(audioStream);
                                    clip.start();
                                } else {
                                    System.out.println("You have reached end of Queue");
                                    response = "Q";
                                }
                                break;
                        }
                    }

                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error is "+ e);
        }

    }
}







