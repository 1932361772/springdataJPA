package cn.itmuch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	private Integer id;
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", username=" + username + "]";
	}

}
