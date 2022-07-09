package com.assessment.userRegistration.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//Log Entity Class
public class Log {
    @Id
    private int id;
    private String action_type;
    private Date date;
    private String error;
}
