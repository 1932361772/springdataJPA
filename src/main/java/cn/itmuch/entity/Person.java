package cn.itmuch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	/*
	 * OneToOne 默认对应的是对方的主键; 如果想改别名.可以加注解@JoinColumn(name="card_id")没什么实际意义.
	 * optional=false 使用的是inner join关联
	 * optional=true 使用的是left join关联
	 */
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY,optional=false)
//	@JoinColumn(name = "card_id")
	private IdCard idCard;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(Integer id, String name, Integer age, IdCard idCard) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.idCard = idCard;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", idCard=" + "]";
	}

}
