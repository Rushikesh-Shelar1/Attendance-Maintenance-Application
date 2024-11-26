package com.tl.kp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="attendance_table_in")
public class AttendanceDTI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="attendance_id")
	private long attendanceId;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate localDate;
	private LocalTime localTimeIN;
	private LocalTime localTimeOUT;
//	@ManyToOne
//	@JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	public long getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTimeIN() {
		return localTimeIN;
	}
	public void setLocalTimeIN(LocalTime localTimeIN) {
		this.localTimeIN = localTimeIN;
	}
	public LocalTime getLocalTimeOUT() {
		return localTimeOUT;
	}
	public void setLocalTimeOUT(LocalTime localTimeOUT) {
		this.localTimeOUT = localTimeOUT;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param attendanceId
	 * @param localDate
	 * @param localTimeIN
	 * @param localTimeOUT
	 * @param user
	 */
	public AttendanceDTI(long attendanceId, LocalDate localDate, LocalTime localTimeIN, LocalTime localTimeOUT,
			User user) {
		super();
		this.attendanceId = attendanceId;
		this.localDate = localDate;
		this.localTimeIN = localTimeIN;
		this.localTimeOUT = localTimeOUT;
		this.user = user;
	}
	public AttendanceDTI() {
		super();
		// TODO Auto-generated constructor stub
	}




	

	

}