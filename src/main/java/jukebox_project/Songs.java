package jukebox_project;

public class Songs
{
    private int songid;
    private String songname ;
    private int  artistid ;
    private int genreid ;
    private int albumid ;
    private int duration ;
    private String path;
    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songid=" + songid +
                ", songname='" + songname + '\'' +
                ", artistid=" + artistid +
                ", genreid=" + genreid +
                ", albumid=" + albumid +
                ", duration=" + duration +
                ", path='" + path + '\'' +
                '}';
    }


}