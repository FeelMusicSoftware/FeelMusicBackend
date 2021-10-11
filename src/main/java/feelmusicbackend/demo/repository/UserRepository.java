package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public Integer getLastInsertUserId();
    public void createUser(User user);
    public void addUser(User user);
    public List<User> getUsers(Integer i, Integer n, String search);
    public Integer getTotalUser(String search);
    public void deleteUser(User user);
    public void updateUser(User user);
}
