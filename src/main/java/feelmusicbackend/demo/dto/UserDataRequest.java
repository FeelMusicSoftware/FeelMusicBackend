package feelmusicbackend.demo.dto;

import feelmusicbackend.demo.entity.User;

import java.util.List;

public class UserDataRequest {
    private List<User> users;
    private Integer total;

    public UserDataRequest(){

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "UserDataRequest{" +
                "users=" + users +
                ", total=" + total +
                '}';
    }
}
