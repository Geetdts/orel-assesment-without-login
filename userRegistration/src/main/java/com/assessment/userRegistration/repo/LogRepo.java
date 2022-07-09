package com.assessment.userRegistration.repo;

import com.assessment.userRegistration.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log,Integer> {
}
