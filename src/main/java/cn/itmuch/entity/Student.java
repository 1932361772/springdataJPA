package cn.itmuch.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.itmuch.listener.StudentListener;
import cn.itmuch.listener.StudentListener2;
import cn.itmuch.listener.UpdateListener;


@Entity
@Table
//@EntityListeners({UpdateListener.class})//({StudentListener2.class,StudentListener.class})//import javax.persistence.PreUpdate;注解
@EntityListeners(AuditingEntityListener.class)
@NamedNativeQuery(name="queryTimeout",query="select sleep(3)")
//@NamedNativeQuery(name="queryTimeout",query="select sleep(3)",hints=@QueryHint(name="org.hibernate.timeout",value="2"))
					
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	@CreatedBy//审计的创建者
	private String creator;
	@CreatedDate//审计的创建时间
	private Date createDate;
	@LastModifiedBy//修改者
	private String editor;
	@LastModifiedDate//修改时间.spring包里面的
	private Date editDate;
	private Timestamp editTime;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
//	@JoinColumn(name="sch_id")改变增加列的字段的名称.没必要更改.可以使用默认值.
	private School school;
	

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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}


	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", creator=" + creator + ", createDate="
				+ createDate + ", editor=" + editor + ", editDate=" + editDate + ", editTime=" + editTime + ", school="
				+ school + "]";
	}
	
//	@PrePersist
	public void beforAdd() {
		createDate = new Date();
		creator="boss";
	}
//	@PreUpdate
	public void beforeUpdate() {
		editDate=new Date();
		editor="hr2";
	}
	

}
