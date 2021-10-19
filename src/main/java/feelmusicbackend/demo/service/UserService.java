package feelmusicbackend.demo.service;


import feelmusicbackend.demo.dto.UserDataRequest;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.Person;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.repository.PersonRepository;
import feelmusicbackend.demo.repository.TransactionRepository;
import feelmusicbackend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PersonRepository personRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public UserService(UserRepository userRepository, PersonRepository personRepository, TransactionRepository transactionRepository){
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.transactionRepository = transactionRepository;
    }

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    public UserResponse findByUserId(Integer userId){
        return userRepository.findByUserId(userId);
    }

    public UserResponse createUser(UserResponse userResponse){
        //System.out.println(userResponse.getName()+" ENTOTOTO");
        User user = new User();
        Person person = new Person();
        person.setName(userResponse.getName());
        person.setFirstSurname(userResponse.getFirstSurname());
        person.setSecondSurname(userResponse.getSecondSurname());
        person.setPhone(userResponse.getPhone());
        personRepository.createPerson(person);
        //System.out.println(person.getName());
        int personId=transactionRepository.getLastInsertId();
        user.setIdPerson(personId);
        user.setUsername(userResponse.getUsername());
        user.setEmail(userResponse.getEmail());
        user.setPassword(userResponse.getPassword());
        userRepository.createUser(user);
        int userId=transactionRepository.getLastInsertId();
        userResponse.setIdUser(userId);
        userResponse.setIdPerson(personId);
        return userResponse;
    }


    public UserResponse updateUser(UserResponse userResponse){
        User user=new User();
        Person person = new Person();
        person.setIdPerson(userResponse.getIdPerson());
        person.setName(userResponse.getName());
        person.setFirstSurname(userResponse.getFirstSurname());
        person.setSecondSurname(userResponse.getSecondSurname());
        person.setPhone(userResponse.getPhone());
        personRepository.updatePerson(person);
        user.setIdUser(userResponse.getIdUser());
        user.setIdPerson(userResponse.getIdPerson());
        user.setUsername(userResponse.getUsername());
        user.setEmail(userResponse.getEmail());
        user.setPassword(userResponse.getPassword());
        userRepository.updateUser(user);
        return userResponse;
    }

    public UserDataRequest getUsers(Integer i, Integer n, String search){
        UserDataRequest userDataRequest=new UserDataRequest();
        userDataRequest.setUsers(userRepository.getUsers(i,n,search));
        userDataRequest.setTotal(userRepository.getTotalUser(search));
        return userDataRequest;
    }


    public void deleteUser(Integer userId) {
        userRepository.deleteUser(userId);
    }

}
