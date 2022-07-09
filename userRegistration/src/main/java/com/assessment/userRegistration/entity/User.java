package com.assessment.userRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//User Entity Class
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;
    @NonNull
    private String mobile_no;
    @NonNull
    private String email;

    private Date date;

}
