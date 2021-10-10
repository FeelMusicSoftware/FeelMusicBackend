package feelmusicbackend.demo.service;


import feelmusicbackend.demo.dto.UserDataRequest;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User addUser(User user){
        return user;
    }

    public User updateUser(User user){
        User userAdd=new User();
        userAdd.setIdUser(user.getIdUser());
        userAdd.setUsername(user.getUsername());
        userAdd.setEmail(user.getEmail());
        if(user.getPassword()!=null&&user.getPassword()!=""&&user.getPassword().length()>6){
            userAdd.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        else{
            userAdd.setPassword(null);
        }
        userRepository.updateUser(userAdd);
        return user;
    }

    public UserDataRequest getUsers(Integer i, Integer n, String search){
        UserDataRequest userDataRequest=new UserDataRequest();
        userDataRequest.setUsers(userRepository.getUsers(i,n,search));
        userDataRequest.setTotal(userRepository.getTotalUser(search));
        return userDataRequest;
    }

    public void userDelete(Integer idUser){
        User userAdd=new User();
        userAdd.setIdUser(idUser);
        userRepository.deleteUser(userAdd);
    }
}
