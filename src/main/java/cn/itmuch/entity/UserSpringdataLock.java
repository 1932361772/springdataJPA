package cn.itmuch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity//(name="myuser")可以指定实体名称和类名不一致.没必要.用缺省值就好
@Table//(name="UserSpringdateLock")用缺省值就好
public class UserSpringdataLock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String phone;
	private Integer status;
	@Version
	private Integer version;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserSpringdateLock [id=" + id + ", username=" + username + ", phone=" + phone + ", status=" + status
				+ ", version=" + version + "]";
	}


}
