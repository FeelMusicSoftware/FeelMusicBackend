package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.UserDataRequest;
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
    public User updateUser(@RequestBody User user, HttpServletRequest request){
        User userRes=userService.updateUser(user);
        return userRes;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestParam Integer userId, HttpServletRequest request){
        userService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDataRequest getUsers(@RequestParam Integer n, @RequestParam Integer i, @RequestParam(required = false) String search){
        return userService.getUsers(i,n,search);
    }

}
