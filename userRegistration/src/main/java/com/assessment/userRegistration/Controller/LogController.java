package com.assessment.userRegistration.Controller;

import com.assessment.userRegistration.dto.LogDTO;
import com.assessment.userRegistration.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
//Save error log if needed
@RestController
@CrossOrigin
public class LogController {
    @Autowired
    private LogService logService;
    //save log
    public String save_log(String action_type,String error ){
        LogDTO log =new LogDTO();
        log.setAction_type(action_type);
        log.setError(error);
        Date date =new Date();
        log.setDate(date);
        logService.saveLog(log);
        return "Log saved";
    }


}
