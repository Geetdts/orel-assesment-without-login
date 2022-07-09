package com.assessment.userRegistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
//User Data Transfer Object class
public class UserDTO {
    private  int id;
    private String mobile_no;
    private String email;
    private Date date;
}
