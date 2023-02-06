package jukebox_project;
import java.util.ArrayList;

public class Album {
    private String albumname;
   private int albumid;

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumName(String albumname) {
        this.albumname = albumname;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }


    @Override
    public String toString() {
        return String.format("Playlist%n" +
                        "%-12s%d%n" +
                        "%-12s%s",
                "playlistid=", albumid,
                "playlistname=", albumname);
    }


}
