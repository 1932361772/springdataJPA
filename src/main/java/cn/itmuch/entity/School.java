package cn.itmuch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
//	@JoinTable (name="mappings",joinColumns=@JoinColumn(name="school_id"),inverseJoinColumns=@JoinColumn(name="stu_id"))//给新建的表起别名(新名)没什么实际意义.
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Student> students;

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", students="+ "]";
	}
	

}
