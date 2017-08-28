package cn.itmuch.listener;

import java.sql.Timestamp;

import javax.persistence.PreUpdate;

import cn.itmuch.entity.Student;

//每更新一次数据,更新记录一次时间.
public class UpdateListener {
	@PreUpdate//在触发update语句之前执行.
	public void update(Student s) {
		System.out.println("pre update设置更改时间:"+s);
		s.setEditTime(new Timestamp(System.currentTimeMillis()));
	}
	
	
	
	
	
	
}
