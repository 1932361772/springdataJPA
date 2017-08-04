package cn.itmuch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.itmuch.entity.UserSpringDataJpa;
//@NoRepositoryBean添加此类即可不让springdatajpa接口生成实现类,一般不用.
public interface UserRepositoryextendscrud extends CrudRepository<UserSpringDataJpa, Integer> {

}
