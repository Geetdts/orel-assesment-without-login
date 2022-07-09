package com.assessment.userRegistration.service;

import com.assessment.userRegistration.dto.LogDTO;
import com.assessment.userRegistration.entity.Log;
import com.assessment.userRegistration.repo.LogRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LogService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LogRepo logRepo;

    public LogDTO saveLog(LogDTO logDTO){
        logRepo.save(modelMapper.map(logDTO, Log.class));
        return logDTO;
    }
}
