package jukebox_project;

public class DisplayMenu  {
    public Object Menu(){
        System.out.printf("%2s. %-20s\n", "1", "Display Songs");
        System.out.printf("%2s. %-20s\n", "2", "Add songs in catalog");
        System.out.printf("%2s. %-20s\n", "3", "Search song and play");
        System.out.printf("%2s. %-20s\n", "4", "Create/View Playlist");
        System.out.printf("%2s. %-20s\n", "5", "Delete a song ");
        System.out.printf("%2s. %-20s\n", "6", "Search a playlist");
        System.out.printf("%2s. %-20s\n", "7", "Exit");
        return null;
    }
}
