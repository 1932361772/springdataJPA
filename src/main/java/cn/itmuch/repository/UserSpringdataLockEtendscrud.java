package cn.itmuch.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.UserSpring;
import cn.itmuch.entity.UserSpringdataLock;
//@NoRepositoryBean添加此类即可不让springdatajpa接口生成实现类,一般不用.
public interface UserSpringdataLockEtendscrud extends CrudRepository<UserSpringdataLock, Integer> {
//	springdatajpa 详解(八):JPA Criteria query------------------------	
	
	public UserSpring findById(Integer id) ;
	@Transactional//加锁的话需要事务.
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)//乐观锁LockModeType.OPTIMISTIC_FORCE_INCREMENT强制修改版本号.
	@Query("select u from UserSpringdataLock u where u.id=?")
	public UserSpringdataLock getById(Integer id) ;
	@Transactional
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select u from UserSpringdataLock u where u.id=?")
	public UserSpringdataLock gettById(Integer id) ;
	

}
