package jukebox_project;

public class Artist {
    private String artistname;
    private int artistid;

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistname='" + artistname + '\'' +
                ", artistid=" + artistid +
                '}';
    }
}
