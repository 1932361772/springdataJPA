package cn.itmuch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.itmuch.entity.UserSpring;
//@NoRepositoryBean添加此类即可不让springdatajpa接口生成实现类,一般不用.
public interface UserRepositoryextendscrud extends CrudRepository<UserSpring, Integer> {
//	springdatajpa 详解(八):JPA Criteria query------------------------	
	
	public UserSpring findById(Integer id) ;
	
	@Query("select u from UserSpring u where u.id=?1")
	public UserSpring getById() ;
	
	
	

}
