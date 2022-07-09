package com.assessment.userRegistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogDTO {
    private int id;
    private String action_type;
    private Date date;
    private String error;
}
