package feelmusicbackend.demo.dto;

public class UserInformation {
    private Integer idUser;
    private Integer idPerson;

    public UserInformation(){

    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "idUser=" + idUser +
                ", idPerson=" + idPerson +
                '}';
    }
}
