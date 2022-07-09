package com.assessment.userRegistration.service;

import com.assessment.userRegistration.dto.UserDTO;
import com.assessment.userRegistration.entity.User;
import com.assessment.userRegistration.exception.ApiRequestException;
import com.assessment.userRegistration.repo.LogRepo;
import com.assessment.userRegistration.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogRepo logRepo;
    //save User service
    public UserDTO saveUser(UserDTO userDTO){
        String email = userDTO.getEmail();
        String mobile =userDTO.getMobile_no();
        if(!checkUserAvailable(mobile,email)){
            userRepo.save(modelMapper.map(userDTO,User.class));
        }else{
//logRepo log ={}
            throw new ApiRequestException("User Already exist");
        }

        return userDTO;
    }
    //get All Users Service
    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return  modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    //Update User Service
    public  UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    //Delete User Service
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
    //get user by id
    public  UserDTO getUserByUserID(String userID){

      User user= userRepo.getUserByUserID(userID);
      if(user==null){
          throw new ApiRequestException("User not found");
      }
        return modelMapper.map(user,UserDTO.class);
    }
    //Check user availability
    public  boolean checkUserAvailable(String mobileNo , String email){
        User user= userRepo.CheckUserAvailability(mobileNo,email);
        if(user ==null){
            return false;
        }else{
            return true;
        }
    }
}
