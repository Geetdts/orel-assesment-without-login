package com.assessment.userRegistration.repo;

import com.assessment.userRegistration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM USER WHERE ID =?1",nativeQuery = true)
    User getUserByUserID(String userID);

    @Query(value = "SELECT * FROM USER WHERE MOBILE_No =?1 AND EMAIL =?2",nativeQuery = true)
    User CheckUserAvailability(String mobileNo,String email);
}
