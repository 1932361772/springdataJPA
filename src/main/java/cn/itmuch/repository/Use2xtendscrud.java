package cn.itmuch.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import cn.itmuch.entity.UserSpring;
import cn.itmuch.entity.UserSpringJpa;
//@NoRepositoryBean添加此类即可不让springdatajpa接口生成实现类,一般不用.
@Repository
public interface Use2xtendscrud extends CrudRepository<UserSpringJpa, Integer> {
//	springdatajpa 详解(八):JPA Criteria query------------------------	
	
	public UserSpring findById(Integer id) ;
	
	@Query("select u from UserSpring u where u.id=?1")
	public UserSpring getById() ;
	
	@Query(name="listAlluser")
	public List<UserSpringJpa> listAllUser() ;
	@Query(name="listAlluser2")
	public List<UserSpringJpa> listAlluser2() ;
	

}
