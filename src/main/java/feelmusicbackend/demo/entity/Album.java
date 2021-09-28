package feelmusicbackend.demo.entity;

public class Album {
    private Integer idAlbum;
    private String name;
    private String songName;

    public Album() {
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", name='" + name + '\'' +
                ", songName='" + songName + '\'' +
                '}';
    }
}
