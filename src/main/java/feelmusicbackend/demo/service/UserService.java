package feelmusicbackend.demo.service;


import feelmusicbackend.demo.dto.UserDataRequest;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.Person;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.repository.PersonRepository;
import feelmusicbackend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PersonRepository personRepository;

    @Autowired
    public UserService(UserRepository userRepository, PersonRepository personRepository){
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    public User addUser(User user){

        return user;
    }

    public UserResponse createUser(UserResponse userResponse){
        User user = new User();
        Person person = new Person();
        person.setName(userResponse.getName());
        person.setFirstSurname(userResponse.getFirstSurname());
        person.setSecondSurname(userResponse.getSecondSurname());
        person.setPhone(userResponse.getPhone());
        personRepository.createPerson(person);
        int personId=personRepository.getLastInsertId();
        user.setIdPerson(personId);
        user.setUsername(userResponse.getUsername());
        user.setEmail(userResponse.getEmail());
        user.setPassword(userResponse.getPassword());
        userRepository.createUser(user);
        int userId=userRepository.getLastInsertUserId();
        userResponse.setIdUser(userId);
        userResponse.setIdPerson(personId);
        return userResponse;
    }


    public User updateUser(User user){
        User userAdd=new User();
        userAdd.setIdUser(user.getIdUser());
        userAdd.setUsername(user.getUsername());
        userAdd.setEmail(user.getEmail());
        if(user.getPassword()!=null&&user.getPassword()!=""&&user.getPassword().length()>6){
            //userAdd.setPassword(passwordEncoder.encode(user.getPassword()));
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
