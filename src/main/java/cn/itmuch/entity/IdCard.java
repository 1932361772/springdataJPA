package cn.itmuch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class IdCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cardNum;
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="idCard")
	private Person person;
	/*
	 * 在双向一对一的关系中,需要注意的是
	 * 1,不能都是FetchType.eager 必须要有一方是LAZY,否则会陷入死循环.
	 * 2,设置lazy后不能再使用它,否则还会陷入死循环.
	 * 设置了mappedBy="idCard"就不会在表里面加字段了.会忽略@JoinColumn注解.
	 * mappedBy一般用在被拥有防.
	 * 
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Override
	public String toString() {
		return "IdCard [id=" + id + ", cardNum=" + cardNum + ", person=" + person + "]";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

}
