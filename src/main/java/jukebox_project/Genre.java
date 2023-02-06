package jukebox_project;

public class Genre {
    private int genreid;
    private String genrename;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }

    @Override
    public String toString() {
        return String.format("Playlist%n" +
                        "%-12s%d%n" +
                        "%-12s%s",
                "playlistid=", genreid,
                "playlistname=", genrename);
    }

}
