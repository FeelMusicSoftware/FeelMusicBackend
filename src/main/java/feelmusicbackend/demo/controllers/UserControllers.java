package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.UserDataRequest;
import feelmusicbackend.demo.dto.UserRequest;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserControllers {
    private UserService userService;

    @Autowired
    public UserControllers(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody UserResponse userResponse) {
        return userService.createUser(userResponse);
    }

    /*
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user, HttpServletRequest request){
        User userRes = userService.addUser(user);
        return userRes;
    }
    */

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@RequestBody UserResponse userResponse){
        userService.updateUser(userResponse);
        return userResponse;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestParam Integer userId, HttpServletRequest request){
        userService.deleteUser(userId);
    }
/*
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDataRequest getUsers(@RequestParam Integer n, @RequestParam Integer i, @RequestParam(required = false) String search){
        return userService.getUsers(i,n,search);
    }
*/
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse findByUserId(@RequestParam Integer userId, HttpServletRequest request){
        return userService.findByUserId(userId);
    }

    @RequestMapping(path="profile",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse dataByUserId(HttpServletRequest request){
        return userService.dataByUserId();
    }
    @RequestMapping(path="signup",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest SignUp(@RequestBody UserRequest userRequest, HttpServletRequest request) {
         return userService.SignUp(userRequest);
    }

    @RequestMapping(path="signin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest SignIn(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        System.out.println(userRequest);
        return userService.SignIn(userRequest);
    }
}
