package cn.itmuch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone2 {
	@Id
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Phone2 [id=" + id + ", name=" + name + "]";
	}




}
