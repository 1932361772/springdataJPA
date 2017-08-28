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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	//(cascade=CascadeType.PERSIST)//在多对多的关联关系中不能使用级联删除和级联保存.(这一规则同样适用一对多的关联关系.)
//	解决方法是让对象单独实例化.持久化.
//	@JoinTable(name = "teacherMapping",joinColumns=@JoinColumn(name="tid"),inverseJoinColumns=@JoinColumn(name="sid"))//给关联表起别名;给字段器别名
	private List<Studentttt> studentttts;

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


	public List<Studentttt> getStudentttts() {
		return studentttts;
	}

	public void setStudentttts(List<Studentttt> studentttts) {
		this.studentttts = studentttts;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name +  "]";
	}


}
