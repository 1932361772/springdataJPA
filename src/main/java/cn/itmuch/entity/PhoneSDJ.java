package cn.itmuch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneSDJ {
	@Id
	private String phone;
	private String username;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "PhoneSDJ [ phone=" + phone + ", username=" + username + "]";
	}
	
	
	
	

}
