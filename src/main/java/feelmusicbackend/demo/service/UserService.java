package feelmusicbackend.demo.service;


import feelmusicbackend.demo.dto.UserDataRequest;
import feelmusicbackend.demo.dto.UserRequest;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.Person;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.util.JWTUtil;

import feelmusicbackend.demo.repository.PersonRepository;
import feelmusicbackend.demo.repository.TransactionRepository;
import feelmusicbackend.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ResponseStatus;



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

    @Autowired
    PasswordEncoder encoder;

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
        user.setPassword(encoder.encode(userResponse.getPassword()));
        userRepository.createUser(user);
        int userId=transactionRepository.getLastInsertId();
        userResponse.setIdUser(userId);
        userResponse.setIdPerson(personId);
        System.out.println("ASDDADSD    "+user.getPassword());
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



    public UserRequest SignUp(UserRequest userRequest){

        UserRequest userInfo=userRepository.findByEmail(userRequest.getEmail());
        if(userInfo==null){
            User user=new User();
            user.setEmail(userRequest.getEmail());
            user.setPassword(encoder.encode(userRequest.getPassword()));
            userRepository.createUserData(user);
            UserRequest userPerson=new UserRequest();
            Integer userId=transactionRepository.getLastInsertId();
            userPerson.setIdUser(userId);
            JWTUtil jwtUtil=new JWTUtil();
            String token = jwtUtil.getJWTToken(userPerson);
            userRequest.setToken(token);
            return userRequest;
        }
        else{
            throw new RuntimeException("Ya existe el usuario");
        }
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    class SignInFailed extends RuntimeException {
        public SignInFailed(String message) {
            super(message);
        }
    }

    public UserRequest SignIn(UserRequest userRequest){

        UserRequest userInfo=userRepository.findByEmail(userRequest.getEmail());
        System.out.println("asac  "+userInfo.getEmail());
        if(userInfo!=null){
            if(encoder.matches(userRequest.getPassword(),userInfo.getPassword())){
                UserRequest userPerson=personRepository.findByUserId(userInfo.getIdUser());
                System.out.println("asacppp  "+userPerson.getIdPerson());
                System.out.println("ENTROSAOSOAOS   ");
                userInfo.setIdPerson(userPerson.getIdPerson());
                userInfo.setPassword(userRequest.getPassword());
                JWTUtil jwtUtil=new JWTUtil();
                String token = jwtUtil.getJWTToken(userInfo);
                userInfo.setToken(token);
                return userInfo;
            }
            else{

                throw new SignInFailed("Credenciales incorrectas");
            }
        }
        else{
            throw new SignInFailed("No se encontró al usuario");
        }
    }
}
