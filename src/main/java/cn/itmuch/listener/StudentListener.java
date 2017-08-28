package cn.itmuch.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import cn.itmuch.entity.Student;

public class StudentListener {//此listener可以是多个实体类公用,将参数改为object即可.
	@PrePersist
	public void beforeAdd(Student s) {
		System.out.println("before:" + s.toString());
	}

	@PostPersist
	public void afterAdd(Object s) {
		System.out.println("atfer:" + s.toString());
	}
	
	
	@PostLoad//有多少个实体bean就触发多少次或者说.多少条数据触发多少次.
	public void load(Student s) {
		System.out.println("load:"+s.toString());
	}
	
	
}
