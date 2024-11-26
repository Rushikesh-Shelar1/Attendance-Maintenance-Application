package com.tl.kp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tl.kp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 @Query("select u from User u where u.userName = :userName and u.userPassword = :userPassword")
	    User getLogin(@Param("userName") String userName, @Param("userPassword") String userPassword);

}
