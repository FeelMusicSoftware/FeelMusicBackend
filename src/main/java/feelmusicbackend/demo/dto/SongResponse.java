package feelmusicbackend.demo.dto;

public class SongResponse {
    private Integer idSong;
    private Integer idAlbum;
    private Integer idGenre;
    private Integer idLanguage;
    private Integer idArtist;
    private String nameAlbum;
    private String songAlbum;
    private String nameGenre;
    private String description;
    private String language;
    private String nameSong;
    private Double durationSong;
    private Integer moodSong;

    public SongResponse(){

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

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Double getDurationSong() {
        return durationSong;
    }

    public void setDurationSong(Double durationSong) {
        this.durationSong = durationSong;
    }

    public Integer getMoodSong() {
        return moodSong;
    }

    public void setMoodSong(Integer moodSong) {
        this.moodSong = moodSong;
    }

    @Override
    public String toString() {
        return "SongResponse{" +
                "idSong=" + idSong +
                ", idAlbum=" + idAlbum +
                ", idGenre=" + idGenre +
                ", idLanguage=" + idLanguage +
                ", idArtist=" + idArtist +
                ", nameAlbum='" + nameAlbum + '\'' +
                ", songAlbum='" + songAlbum + '\'' +
                ", nameGenre='" + nameGenre + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", nameSong='" + nameSong + '\'' +
                ", durationSong=" + durationSong +
                ", moodSong=" + moodSong +
                '}';
    }
}
