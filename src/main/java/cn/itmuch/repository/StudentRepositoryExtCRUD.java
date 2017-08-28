package cn.itmuch.repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import cn.itmuch.entity.Student;

public interface StudentRepositoryExtCRUD extends CrudRepository<Student, Integer> {
	
	@Query(name="queryTimeout",nativeQuery=true)//默认是namequery,需要指定nativeQuery。
	public Object queryTimeout() ;

	@Query(name="queryTimeout",nativeQuery=true)//默认是namequery,需要指定nativeQuery。
	@QueryHints(@QueryHint(name="org.hibernate.timeout",value="2"))
	public Object queryTimeoutByspringdate() ;
	
	
	
	
	
}
