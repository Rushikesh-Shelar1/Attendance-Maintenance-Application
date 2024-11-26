package com.tl.kp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tl.kp.model.AttendanceDTI;



@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceDTI, Long>{
	 @Query("select a from AttendanceDTI a where a.user.userID = :userId")
	    List<AttendanceDTI> findByUser_UserID(@Param("userId") Long userId);

}
