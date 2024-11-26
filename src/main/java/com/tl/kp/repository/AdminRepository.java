package com.tl.kp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tl.kp.model.Admin;
import com.tl.kp.model.User;


@Repository
public interface AdminRepository  extends JpaRepository<Admin, Long>{

	
	@Query("select a from Admin a  where a.user=?1")
	public Admin getAdminByUser(User userId);
	
}
