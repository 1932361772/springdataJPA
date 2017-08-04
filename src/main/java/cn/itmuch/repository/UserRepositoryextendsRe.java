package cn.itmuch.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import cn.itmuch.entity.UserSpringDataJpa;
//Repository一般不使用这接口,因为没有任何方法.
public interface UserRepositoryextendsRe extends Repository<UserSpringDataJpa,Integer> {
//查询结果只限一条否则报错
	public UserSpringDataJpa findByUsername(String username) ;
	public UserSpringDataJpa findById(Integer id) ;
//	public UserSpringDataJpa findByStatus(Integer id) ;
	//查询结果可以多条,也可以查询一条.
	public List<UserSpringDataJpa> findByStatus(Integer status) ;
	
//	可以多个字段一起查询.
	public UserSpringDataJpa findByUsernameAndPhone(String username,String phone) ;
	
}
