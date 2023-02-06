package jukebox_project;

public class Playlist {
    private int playlistid;
    private int userid;
    private String playlistname;


    public int getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(int playlistid) {
        this.playlistid = playlistid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }



    @Override
    public String toString() {
        return "Playlist{" +
                "playlistid=" + playlistid +
                ", userid=" + userid +
                ", playlistname='" + playlistname + '\'' +
                '}';
    }


}
