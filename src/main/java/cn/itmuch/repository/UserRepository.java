package cn.itmuch.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.RepositoryDefinition;

import cn.itmuch.entity.UserSpringDataJpa;
//此为第二种定义的方式： 注解  第一种为继承4个接口中的一个.
@RepositoryDefinition(domainClass=UserSpringDataJpa.class,idClass=Integer.class)
//@NoRepositoryBean添加此类即可不让springdatajpa接口生成实现类一般不用.
public interface UserRepository {
	
}
