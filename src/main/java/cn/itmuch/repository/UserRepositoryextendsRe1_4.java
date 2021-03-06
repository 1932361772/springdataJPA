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

import cn.itmuch.entity.UserSpring;
//Repository一般不使用这接口,因为没有任何方法.
public interface UserRepositoryextendsRe1_4 extends Repository<UserSpring,Integer> {
//查询结果只限一条否则报错
	public UserSpring findByUsername(String username) ;
	public UserSpring findById(Integer id) ;
//	public UserSpringDataJpa findByStatus(Integer id) ;
	//查询结果可以多条,也可以查询一条.
	public List<UserSpring> findByStatus(Integer status) ;
	
//	可以多个字段一起查询.只能返回一个结果.尽量不用.用下面的一个返回list的方法.
//	public UserSpringDataJpa findByUsernameAndPhone(String username,String phone) ;
	public List<UserSpring> findByUsernameAndPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.

//	public UserSpringDataJpa findByUsernameOrPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.
//	用这个代替上面一个.常用.
	public List<UserSpring> findByUsernameOrPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.

	public List<UserSpring> findByPhoneIn(List<String> phones) ;//也可以是set集合
	
	public List<UserSpring> findByIdBetween(Integer start,Integer end) ;//查询的字段应为数字.
	public List<UserSpring> findByIdLessThan(Integer id) ;
	public List<UserSpring> findByIdLessThanEqual(Integer id) ;
	public List<UserSpring> findByPhoneIsNull();//关键字IsNull大小必须正确
	public List<UserSpring> findByPhoneIsNotNull();//关键字IsNull大小必须正确
//	
	public List<UserSpring> findByPhoneNotNull();//关键字IsNull大小必须正确
	public List<UserSpring> findByPhoneNot(String phone); //常用全包含....
	public List<UserSpring> findByPhoneNotIn(List<String> phones); //常用全包含....
	
	
	public List<UserSpring> findByPhoneLike(String phone);//全匹配字符.
	public List<UserSpring> findByPhoneContains(String phone);//包含字符.
	public List<UserSpring> findByPhoneContaining(String phone);
	public List<UserSpring> findByPhoneStartingWith(String phone);
	public List<UserSpring> findByPhoneEndingWith(String phone);
	
//	
//	排序
	public List<UserSpring> findByPhoneInOrderByUsernameDesc(List<String> phones) ;//也可以是set集合
	public List<UserSpring> findByPhoneInOrderByUsername(List<String> phones) ;//也可以是set集合省略是asc
	
	//queryBy ,readBy,getBy,遵循的规则和find一样.
	public List<UserSpring> readByPhoneNotIn(List<String> phones); //常用全包含....
	public List<UserSpring> queryByPhoneNotIn(List<String> phones); //常用全包含....
	public List<UserSpring> getByPhoneNotIn(List<String> phones); //常用全包含....
	
	
	//查询前几条数据
	
	public List<UserSpring> findTop3ByPhoneIsNotNull() ;//Top3
	public List<UserSpring> findFirstByPhoneIsNotNull() ;//Top3
	public List<UserSpring> findTop3ByPhoneIsNotNullOrderByIdDesc() ;//Top3 不写Desc默认ASC从小到大
	
//-----------------------------jpql语句查询-------------------------------------------------------------------------
	@Query("select u from UserSpringDataJpa u ")
	public List<UserSpring> list() ;
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1")
	public UserSpring takeByPhone(String phone) ;//返回单个对象.
	
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1 or username=?2")
	public List<UserSpring> takeByPhone(String phone,String username) ;//建议写这种,位置对应好即可,简单
	
	@Query("select u from UserSpringDataJpa u where u.phone=:phone or username=:name")
	public List<UserSpring> takeByPhoneOrUsername(@Param("name")String username,@Param("phone")String phone) ;//返回单个对象.
	
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1 or username=?2 order by id desc")
	public List<UserSpring> takeByPhoneSort(String phone,String username) ;//建议写这种,位置对应好即可,简单
	
	
	@Query("update UserSpringDataJpa u set u.status=3 where id=24")
	@Modifying
	@Transactional
	public Integer UpdateUser() ;
	
	
	@Query("update UserSpringDataJpa u set u.status=?2 where id=?1")//写数字时.注意对应关系.------------------------
	@Modifying
	@Transactional
	public Integer UpdateUser(Integer id,Integer status) ;//位适应习惯,改变了参数的顺序.注意对应关系.
	
	@Query("delete from UserSpringDataJpa u where u.username=?1")
	@Modifying
	@Transactional
	public Integer deleteByUsername(String username) ;
	
//	springdatajpa 详解(四): 排序,分页,方法的返回值--------------------------------------------
//	三种排序方法 
	/*
//		1,自己在名称上加OrderBy ,
 * 		2,在jpql语句里面加Order By ,
 * 			3,使用参数.new Sort(new Order(Direction.ASC,"status"),new Order(Direction.DESC,"username"))
	 * 推荐使用第三种.
	 */
	public List<UserSpring> queryByStatusOrderByUsername(Integer status) ;
	public List<UserSpring> queryByStatusOrderByUsernameDesc(Integer status) ;
	
	@Query("select u from UserSpringDataJpa u where u.status=?1 order by u.username")
	public List<UserSpring> queryByStatus(Integer status) ;
//	
	public List<UserSpring> queryByStatus(Integer status,Sort sort) ;
	
	@Query("select u from UserSpringDataJpa u where u.status=?1")
	public List<UserSpring> queryAll(Integer status,Sort sort) ;//	可以根据多个条件排序.根据status升序,根据username降序.
	@Query("select u from UserSpringDataJpa u")
	public List<UserSpring> queryAll(Sort sort) ;//	可以根据多个条件排序.根据status升序,根据username降序.

/*
 * 返回值是Page的需要注意以下事项:
 * 		参数必须要有Pageable
 * 		Pageable不能和Sort同时使用.想要排序直接用pageable.
 */
//	分页...排序..............
	public Page<UserSpring> getByStatus(Integer status,Pageable pageable) ;
//	分页........排序..不支持这种方式........
//	public Page<UserSpringDataJpa> getByStatus(Integer status,Sort sort,Pageable pageable) ;
	
	@Query("select u from UserSpringDataJpa u order by u.status desc")//当次处添加排序,后面Pageable还有排序时会语句中的排序为大循环,pageable为小循环.
	public Page<UserSpring> findAll(Pageable pageable) ;
	
	
	@Query("select u from UserSpringDataJpa u order by u.status desc")//当次处添加排序,后面Pageable还有排序时会语句中的排序为大循环,pageable为小循环.
	public Slice<UserSpring> getAll(Pageable pageable) ;//page 在查询的基础上有查询的总记录数.slice只能查询分页后的内容.
	
	
	//方法的返回值有哪些
	/*
	 * Entity
	 * List
	 * Page
	 * Slice
	 * set
	 * Collection
	 * Array[]
	 * Stream
	 * Optional
	 * Future 异步
	 * CompletableFuture
	 */
	@Query("select u from UserSpringDataJpa u")
	public Set<UserSpring> set() ;//set里面的数据是不重复的,要求对象重新hashcode(),或equals()方法.
	
	@Query("select u from UserSpringDataJpa u")
	public Collection<UserSpring> collection() ;
	
	@Query("select u from UserSpringDataJpa u")
	public Iterable<UserSpring> iterable() ;
	
	@Query("select u from UserSpringDataJpa u")
	public UserSpring[] array() ;
	
	@Query("select u from UserSpringDataJpa u")//失败:
	public Stream<UserSpring> stream() ;//失败:
	
	
	Optional<UserSpring>readById(Integer id);//防止空指针的
	
	
//	37 异步 注意事项:1,异步注解2.全局需要启用异步
	
	@Async//1,异步注解2.全局需要启用异步
	Future<UserSpring>queryById(Integer id);
	
	@Async//1,异步注解2.全局需要启用异步
	CompletableFuture<UserSpring>getById(Integer id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
