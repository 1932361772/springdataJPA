package cn.itmuch.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

@Entity//(name="myuser")可以指定实体名称和类名不一致.没必要.用缺省值就好
@Table//(name="userspringData")用缺省值就好
//@NamedQuery(name="byId",query="select u from UserSpringDataJpa u where u.id=?1")
@NamedQueries({
	@NamedQuery(name="byId",query="select u from UserSpringDataJpa u where u.id=?1"),
	@NamedQuery(name="byusername",query="select u from UserSpringDataJpa u where u.username=?1"),
	@NamedQuery(name="byList",query="select u from UserSpringDataJpa u"),
	@NamedQuery(name="pageList",query="select u from UserSpringDataJpa u where u.status=?1"),
	@NamedQuery(name="pageCount",query="select count(u.id) from UserSpringDataJpa u where u.status=?1")
	
	})
//@NamedNativeQuery(name="bySql",query="select * from userspringdatajpa u where u.id=?1",resultClass=UserSpringDataJpa.class)
@NamedNativeQueries({
	@NamedNativeQuery(name="bySql",query="select * from userspringdatajpa u where u.id=?1",resultClass=UserSpringDataJpa.class),
	@NamedNativeQuery(name="getUsernameAndPhone",query="select u.phone, u.username from userspringdatjpa u where id=?1",resultClass=PhoneSDJ.class),
	@NamedNativeQuery(name="bySort",query="select * from userspringdatajpa u",resultClass=UserSpringDataJpa.class),//可以映射到另外的实体类里面去.这个实体类必须是@Entity标注的类.注意查询的信息需要和映射的类的字段名称完全一致.
	@NamedNativeQuery(name="list",query="select * from userspringdatajpa",resultClass=UserSpringDataJpa.class),
	@NamedNativeQuery(name="count",query="select count(*) from userspringdatajpa",resultClass=UserSpringDataJpa.class),
	@NamedNativeQuery(name="listmapping",query="select id,username name from userspringdatajpa",resultSetMapping="result"),
	@NamedNativeQuery(name="phonemapping",query="select id,username name from userspringdatajpa",resultSetMapping="result2"),//这里是原生的sql语句.前一个是sql语句里面表里面字段的名称,第二个是别名.
	@NamedNativeQuery(name="phonemapping3",query="select id,username name from userspringdatajpa",resultSetMapping="result3"),//这里是原生的sql语句.前一个是sql语句里面表里面字段的名称,第二个是别名.
	@NamedNativeQuery(name="phonemapping4",query="select id,status,username name  from userspringdatajpa",resultSetMapping="result4"),//这里是原生的sql语句.前一个是sql语句里面表里面字段的名称,第二个是别名.
	@NamedNativeQuery(name="phonemapping5",query="select id,status,username name  from userspringdatajpa",resultSetMapping="result5")//这里是原生的sql语句.前一个是sql语句里面表里面字段的名称,第二个是别名.

	
})

@SqlResultSetMappings({
	@SqlResultSetMapping(name="result",
			entities={@EntityResult(entityClass=Phone.class,
					fields={@FieldResult(name="id",column="id"),@FieldResult(name="username",column="name")})}),//name指的是实体类里面的属性.column指的sql语句里面的名称.
	@SqlResultSetMapping(name="result2",
			entities={@EntityResult(entityClass=Phone2.class,
					fields={@FieldResult(name="id",column="id"),@FieldResult(name="name",column="name")})}),//name指的是实体类里面的属性.column指的sql语句里面别名.如果没有别名就是字段名.
	@SqlResultSetMapping(name="result3",
			classes={@ConstructorResult(targetClass=Phone3NoEntity.class,//用的是类映射,不是实体类.这个类必须有一个构造函数:里面的值需要和返回值一致.(构造函数有几个参数,@ColumnResult里面就要有几个完全一样的参数,参数名称完全一样.)
					columns={@ColumnResult(name="id",type=Integer.class),@ColumnResult(name="name",type=String.class)})}),//name指的是column指的sql语句里面别名.如果没有别名就是字段名.
	@SqlResultSetMapping(name="result4",//可以多个实体与多个对象组合构成一个object[]数组.
			entities={@EntityResult(entityClass=Phone.class,
					fields={@FieldResult(name="id",column="id"),@FieldResult(name="username",column="name")})},//name指的是实体类里面的属性.column指的sql语句里面别名.如果没有别名就是字段名.
			columns={@ColumnResult(name="status",type=Integer.class)}	),
	@SqlResultSetMapping(name="result5",
			classes={@ConstructorResult(targetClass=Phone3NoEntity.class,//用的是类映射,不是实体类.这个类必须有一个构造函数:里面的值需要和返回值一致.(构造函数有几个参数,@ColumnResult里面就要有几个完全一样的参数,参数名称完全一样.)
					columns={@ColumnResult(name="id",type=Integer.class),@ColumnResult(name="name",type=String.class)})},//name指的是column指的sql语句里面别名.如果没有别名就是字段名.
			columns={@ColumnResult(name="status",type=Integer.class)})
	
	

})
public class UserSpringDataJpa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String phone;
	private Integer status;

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

	@Override
	public String toString() {
		return "UserSpringDataJpa [id=" + id + ", username=" + username + ", phone=" + phone + ", status=" + status
				+ "]";
	}

}
