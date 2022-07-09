package com.assessment.userRegistration.Controller;

import com.assessment.userRegistration.dto.UserDTO;
import com.assessment.userRegistration.exception.ApiRequestException;
import com.assessment.userRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    //get all users
    @GetMapping("/getUsers")
    public List<UserDTO> get_User(){
        return userService.getAllUsers();
    }
    //save new user
    @PostMapping("/saveUser")
    public String save_User(@RequestBody UserDTO userDTO){

        if(userDTO.getEmail()==null){
            return "Email can not be empty";
        }else if(userDTO.getMobile_no()==null){
            return "Mobile no Can not be Empty";
        }else{
           UserDTO savedUser = userService.saveUser((userDTO));
               return "User Saved successfully";
           }

    }
    //update  user
    @PutMapping("/updateUser")
    public String update_User(@RequestBody UserDTO userDTO){

        UserDTO updatedUser = userService.updateUser(userDTO);
        if(updatedUser != null){
            return "User Updated successfully";
        }else{
            return "User can not be updated";
        }
    }
    //Delete User
    @DeleteMapping("deleteUser")
    public boolean delete_user(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    //GetUserByUserID
    @GetMapping("getUserByUserID/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
      UserDTO user = userService.getUserByUserID(userID);
      return user;
    }
}
