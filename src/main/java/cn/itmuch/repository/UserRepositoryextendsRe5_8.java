package cn.itmuch.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.Phone;
import cn.itmuch.entity.Phone2;
import cn.itmuch.entity.Phone3NoEntity;
import cn.itmuch.entity.PhoneSDJ;
import cn.itmuch.entity.UserSpringDataJpa;
//Repository一般不使用这接口,因为没有任何方法.
public interface UserRepositoryextendsRe5_8 extends Repository<UserSpringDataJpa,Integer> {
//	springdatajpa 详解(五): 命名查询
	/*
	 * 注意:
	 * 	必须指定resultClass;
	 * 	resultClass必须是@Entity标注的类,且查询的字段和指定的字段名称必须完全一致.
	 */
	@Query(name="byId")
	public List<UserSpringDataJpa> byId(Integer id) ;	
	
	@Query(name="byList")
	public List<UserSpringDataJpa> byList() ;
	
	@Query(name="byusername")
	public List<UserSpringDataJpa> byusername(String username) ;
	
	@Query(value="select u from UserSpringDataJpa u where u.status=?1",countName="select count(u.id) from UserSpringDataJpa u where u.status=?1")
	public Page<UserSpringDataJpa> byPage(Integer status,Pageable pageable) ;
	@Query(name="pageList",countName="pageCount")//和byPage一样.这里上下两个是一样的.
	public Page<UserSpringDataJpa> pageByStatus(Integer status,Pageable pageable) ;
	
	@Query(value="select * from userspringdatajpa u where u.id=?1",nativeQuery=true)//nativeQuery=true表明里面的语句为底层sql语句,而不是jpql语句.
	public UserSpringDataJpa byIdd(Integer id) ;
	@Query(name="bySql",nativeQuery=true)//nativeQuery=true表明里面的语句为底层sql语句,而不是jpql语句.
	public UserSpringDataJpa byIdd2(Integer id) ;
	
	@Query(name="getUsernameAndPhone",nativeQuery=true)
	public PhoneSDJ	getUsernameAndPhone(Integer id) ;
	
//	@Query(name="bySort",nativeQuery=true)//打开后启动失败
//	public List<UserSpringDataJpa> bySort(Sort sort) ;//失败.原因:不能和分页联合使用.因为,这是自定义的底层sql,jpql语句没有再参与解析.
	@Query(name="bySort",nativeQuery=true)
	public List<UserSpringDataJpa> bySort() ;
//	
//	@Query(name="list",countName="count",nativeQuery=true)//打开后启动失败
//	public Page<UserSpringDataJpa> pages(Integer status,Pageable pageable) ;//失败.原因:不能和分页联合使用.因为,这是自定义的底层sql,jpql语句没有再参与解析.
//	@Query(name="list",countName="count",nativeQuery=true)//打开后启动失败
//	public Page<UserSpringDataJpa> byPages() ;//失败 打开后启动失败
	
//	springdatajpa 详解(六): 本地命名查询的映射=========================================
	/*
	 * 
	 */
	
	@Query(name="listmapping",nativeQuery=true)
	public List<Phone> listmapping();
	
	@Query(name="phonemapping",nativeQuery=true)
	public List<Phone2> phonemapping();
	
	@Query(name="phonemapping3",nativeQuery=true)
	public List<Phone3NoEntity> phonemapping3();
	
	@Query(name="phonemapping4",nativeQuery=true)
	public List<Object> phonemapping4();//由于返回结果是混合组成的,所有必须是Object
	
	
	@Query(name="phonemapping5",nativeQuery=true)
	public List<Object> phonemapping5();//由于返回结果是混合组成的,所有必须是Object
	
	
	
	
	
	
	
	
	
	
	
}
