package feelmusicbackend.demo.entity;

public class Artist {
    private Integer idArtist;
    private Integer idUser;
    private String country;
    private String artistName;


    public Artist() {
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "idArtist=" + idArtist +
                ", idUser=" + idUser +
                ", country='" + country + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
