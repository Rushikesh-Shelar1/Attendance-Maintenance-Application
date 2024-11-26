package com.tl.kp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_table")
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private long adminId;
	@Column(name="admin_name")
	private String adminName;
	@Column(name="admin_phone")
	private long phone;
	@Column(name="admin_emailId")
	private String emailId;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @param adminId
	 * @param adminName
	 * @param phone
	 * @param emailId
	 * @param user
	 */

	
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", phone=" + phone + ", emailId=" + emailId
				+ ", user=" + user + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param adminId
	 * @param adminName
	 * @param phone
	 * @param emailId
	 * @param user
	 */
	public Admin(long adminId, String adminName, long phone, String emailId, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.phone = phone;
		this.emailId = emailId;
		this.user = user;
	}
	
}
