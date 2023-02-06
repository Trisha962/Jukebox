package jukebox_project;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        login log = new login();
        SongsMethod songsMethod = new SongsMethod();
        InsertSong insertSong = new InsertSong();
        AudioInputStream audioInputStream = new AudioInputStream();
        DisplayMenu displayMenu = new DisplayMenu();
        searchPlaylist play = new searchPlaylist();
        playlistCreateView search = new playlistCreateView();
        DeleteSong deleteSong = new DeleteSong();

        int screenWidth = 120;
        //screenWidth is an integer value that sets the width of the screen.
        String welcomeMessage = "          Welcome to MuzicBox";
        String separator = "<------***********************------>";
        //leftPadding is calculated by subtracting totalMessageLength from screenWidth and dividing the result by 2
        int totalMessageLength = welcomeMessage.length() + separator.length();
        int leftPadding = (screenWidth - totalMessageLength) / 2;
        System.out.println(String.format("\033[32m%" + leftPadding + "s%s\033[0m", "", welcomeMessage));
        System.out.println(String.format("\033[32m%" + leftPadding + "s%s\033[0m", "", separator));
        System.out.println("\033[33m" + "To Continue, Log In/Sign Up to MusicBox" + "\033[0m");

        System.out.println("<--------------------------------------->");

        System.out.println("1. Existing user");
        System.out.println("2. New user");
        System.out.println("3. Use without Signing In");
        System.out.println("4. Exit");
        System.out.println("\033[33m" + "Enter your choice: " + "\033[0m");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice)
        {
            case 1:
                log.loginUser();

                break;
            case 2:
                log.registerNewUser();
                break;
            case 3:
                System.out.println("Hello User!!");
                songsMethod.displaySongs();
                audioInputStream.fetchSong();
                System.exit(0);
                break;

            case 4:
                System.out.println("Thank You for Choosing us!");
                System.out.println("You are Exited!");
                System.exit(0);
                break;

        }
        String option = "";
        while (!option.equals("7"))
        {

            int textLength = "Select Your Preference".length();
            System.out.println("\033[32m" + "         Select Your Preference" + "\033[0m");
            System.out.println("\033[32m" + "<------************************------>" + "\033[0m");
            displayMenu.Menu();
            System.out.print("Enter your choice: ");
            int ans = sc.nextInt();
            switch (ans)
            {
                case 1:
                    songsMethod.displaySongs();
                    audioInputStream.fetchSong();
                    songsMethod.mainMenu();
                    break;

                case 2:
                    insertSong.insertInSongTable();
                    songsMethod.mainMenu();
                    break;
                case 3:
                    songsMethod.displaySongs();
                    audioInputStream.fetchSong();

                   // songsMethod.mainMenu();
                    break;
                case 4:
                    System.out.println(" 1.Create Playlist");
                    System.out.println(" 2.View Playlist");
                    System.out.println(" Select Your Choice");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            search.createPlaylist();
                            songsMethod.mainMenu();
                            break;
                        case 2:
                            List<Playlist> viewPlaylist = search.viewPlaylist();
                            search.displayPlaylist(viewPlaylist);
                            break;

                    }
                         break;
                case 5:
                    songsMethod.displaySongs();
                    System.out.println("Enter the id of the song you want to delete: ");
                    int id = sc.nextInt();
                    deleteSong.deleteSong(id);
                    songsMethod.mainMenu();
                    break;

                case 6:

                     System.out.println("--------------------------------");
                     System.out.println("\033[33m" + "Select Your Choice" + "\033[0m");
                     System.out.println("--------------------------------");
                     System.out.println(" 1.Search from Playlist");
                     System.out.println(" 2.Search by Artist");
                     System.out.println(" 3.Search by Album");
                     System.out.println(" 4.Search by Genre");
                             int res = sc.nextInt();
                             switch (res)
                             {
                                      case 1:
                                      List<Playlist> playlists = play.search();
                                      play.printPlaylist(playlists);
                                      List<Songs> song=play.ListenplaylistSongs();
                                      play.printListenPlaylist(song);
                                      play.playPlaylistSongs();
                                      break;

                                      case 2:
                                      List<Artist> artists=play.searchByArtist();
                                      play.printArtist(artists);
                                      List<Songs> artistSongs=play.ListenArtistSongs();
                                      play.printListenArtist(artistSongs);
                                      play.playArtistSongs();
                                      break;

                                      case 3:
                                      List<Album> albums = play.searchByAlbum();
                                      play.printAlbum(albums);
                                      List<Songs> albums1 =play.ListenAlbumSongs();
                                      play.printListenAlbum(albums1);
                                      play.playAlbumSongs();
                                      break;
                                      case 4:
                                      List<Genre> genres= play.searchByGenre();
                                      play.printGenre(genres);
                                      List<Songs>songs=play.ListenGenreSongs();
                                      play.printListenGenre(songs);
                                      play.playGenreSongs();
                                      break;
                             }
                                     songsMethod.mainMenu();
                                     break;

                case 7:
                    System.out.println("Thank You for choosing us!");
                    System.out.println("You are Exited!");
                    System.exit(0);
                    break;

            }
        }
    }
}













