package p02_OpenClosedPrinciple.p01_FileStream;

public class Music implements Sendable {
    private int length;
    private String Artist;
    private String Album;

    @Override
    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getArtist() {
        return this.Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return this.Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
