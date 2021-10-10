package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.User;

import java.util.List;

public interface UserRepository {
    public void addUser(User user);
    public List<User> getUsers(Integer i, Integer n, String search);
    public Integer getTotalUser(String search);
    public void deleteUser(User user);
    public void updateUser(User user);
}
