package cn.itmuch.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import cn.itmuch.entity.Book;
/*
 * 1,保证是repository,
 * 2,继承JpaSpecificationExecutor,
 * 3,调用的时候只需要传入specification实现类即可查询.
 */
public interface BookRepositoryextendsRe_S_Cri extends Repository<Book,Integer>,JpaSpecificationExecutor<Book> {
//	springdatajpa 详解(九):springdatajpa   JPA Criteria query------------------------			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
