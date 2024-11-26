package com.tl.kp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_Table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userID;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String userPassword;
	@Column(name="user_type")
	private String userType;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="fk_user_id",referencedColumnName = "user_id")
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceDTI> attendances;
//    @OneToOne(mappedBy = "user")
//    private Admin admin;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<AttendanceDTI> getAttendances() {
		return attendances;
	}
	public void setAttendances(List<AttendanceDTI> attendances) {
		this.attendances = attendances;
	}
//	public Admin getAdmin() {
//		return admin;
//	}
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * @param userID
 * @param userName
 * @param userPassword
 * @param userType
 * @param attendances
 */
public User(long userID, String userName, String userPassword, String userType, List<AttendanceDTI> attendances) {
	super();
	this.userID = userID;
	this.userName = userName;
	this.userPassword = userPassword;
	this.userType = userType;
	this.attendances = attendances;
}
	



}