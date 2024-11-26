package com.tl.kp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tl.kp.model.AttendanceDTI;
import com.tl.kp.repository.AttendanceRepository;
import com.tl.kp.service.AttendanceService;


@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepos;

	@Override
	public AttendanceDTI addCart(AttendanceDTI attendanceDTI) {
		
		return attendanceRepos.save(attendanceDTI);
	}
	
	public List<AttendanceDTI> viewReport()
	{
		return attendanceRepos.findAll();
	}
	
    public List<AttendanceDTI>  getAttendanceByUserId(long userId) {
        return attendanceRepos.findByUser_UserID(userId);
    }

}
