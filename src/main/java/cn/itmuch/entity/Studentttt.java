package cn.itmuch.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Studentttt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(mappedBy="studentttts",fetch=FetchType.EAGER)//(对方表的哪一个字段,即类的属性.private List<Studentttt> studentttts;)
	//mappingBy设置关联关系由对方维护.只需要建立一张中间表.即可.
//	@JoinTable(name = "studenttttMapping",joinColumns=@JoinColumn(name="sid"),inverseJoinColumns=@JoinColumn(name="tid"))//给关联表起别名;给字段器别名
	private List<Teacher> teachers;

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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Studentttt [id=" + id + ", name=" + name + ", teachers=" + teachers + "]";
	}



}
