package feelmusicbackend.demo.entity;

public class Playlist {
    private Integer idPlaylist;
    private Integer idUser;
    private String name;

    public Playlist() {
    }

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "idPlaylist=" + idPlaylist +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                '}';
    }
}
