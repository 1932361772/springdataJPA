package cn.itmuch.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import cn.itmuch.entity.Student;


public class StudentListener2 {
	@PrePersist
	public void beforeAdd(Student s) {
		System.out.println("before2:" + s.toString());
	}

	@PostPersist
	public void afterAdd(Student s) {
		System.out.println("atfer2:" + s.toString());
	}
	
	
	
	
}
