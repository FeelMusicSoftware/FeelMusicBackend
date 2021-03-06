package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.dto.UserRequest;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public UserRequest findByEmail(String email);
    public void createUserData(User user);
    public Integer getLastInsertUserId();
    public UserResponse findByUserId(Integer userId);
    public UserResponse dataByUserId(Integer userId);
    public UserRequest findByUserIdPerson(Integer personId);
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer userId);
    public void addUser(User user);
    public List<User> getUsers(Integer i, Integer n, String search);
    public Integer getTotalUser(String search);


}
