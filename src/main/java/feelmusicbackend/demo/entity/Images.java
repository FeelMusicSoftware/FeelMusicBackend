package feelmusicbackend.demo.entity;

public class Images {
    private Integer idImage;
    private Integer idAlbum;
    private String name;

    public Images(){

    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
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

    @Override
    public String toString() {
        return "Images{" +
                "idImage=" + idImage +
                ", idAlbum=" + idAlbum +
                ", name='" + name + '\'' +
                '}';
    }
}
