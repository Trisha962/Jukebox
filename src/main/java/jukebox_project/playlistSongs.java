package jukebox_project;

public class playlistSongs {
    private int psid;
    private int songid;
    private int playlistid;
    private String path;
    private String playlistname;

    public int getPsid() {
        return psid;
    }

    public void setPsid(int psid) {
        this.psid = psid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public int getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(int playlistid) {
        this.playlistid = playlistid;
    }

    @Override
    public String toString() {
        return "playlistSongs{" +
                "psid=" + psid +
                ", songid=" + songid +
                ", playlistid=" + playlistid +
                ", path='" + path + '\'' +
                ", playlistname='" + playlistname + '\'' +
                '}';
    }
}
