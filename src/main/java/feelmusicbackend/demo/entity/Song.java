package feelmusicbackend.demo.entity;

public class Song {
    private Integer idSong;
    private Integer idAlbum;
    private Integer idGenre;
    private Integer idLanguage;
    private Integer idArtist;
    private String name;
    private Double duration;
    private Integer mood;

    public Song() {
    }

    public Integer getIdSong() {
        return idSong;
    }

    public void setIdSong(Integer idSong) {
        this.idSong = idSong;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "Song{" +
                "idSong=" + idSong +
                ", idAlbum=" + idAlbum +
                ", idGenre=" + idGenre +
                ", idLanguage=" + idLanguage +
                ", idArtist=" + idArtist +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", mood=" + mood +
                '}';
    }
}
