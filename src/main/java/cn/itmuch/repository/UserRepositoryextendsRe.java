package cn.itmuch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.UserSpringDataJpa;
//Repository一般不使用这接口,因为没有任何方法.
public interface UserRepositoryextendsRe extends Repository<UserSpringDataJpa,Integer> {
//查询结果只限一条否则报错
	public UserSpringDataJpa findByUsername(String username) ;
	public UserSpringDataJpa findById(Integer id) ;
//	public UserSpringDataJpa findByStatus(Integer id) ;
	//查询结果可以多条,也可以查询一条.
	public List<UserSpringDataJpa> findByStatus(Integer status) ;
	
//	可以多个字段一起查询.只能返回一个结果.尽量不用.用下面的一个返回list的方法.
//	public UserSpringDataJpa findByUsernameAndPhone(String username,String phone) ;
	public List<UserSpringDataJpa> findByUsernameAndPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.

//	public UserSpringDataJpa findByUsernameOrPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.
//	用这个代替上面一个.常用.
	public List<UserSpringDataJpa> findByUsernameOrPhone(String username,String phone) ;//	可以多个字段一起查询.只能返回一个结果.

	public List<UserSpringDataJpa> findByPhoneIn(List<String> phones) ;//也可以是set集合
	
	public List<UserSpringDataJpa> findByIdBetween(Integer start,Integer end) ;//查询的字段应为数字.
	public List<UserSpringDataJpa> findByIdLessThan(Integer id) ;
	public List<UserSpringDataJpa> findByIdLessThanEqual(Integer id) ;
	public List<UserSpringDataJpa> findByPhoneIsNull();//关键字IsNull大小必须正确
	public List<UserSpringDataJpa> findByPhoneIsNotNull();//关键字IsNull大小必须正确
//	
	public List<UserSpringDataJpa> findByPhoneNotNull();//关键字IsNull大小必须正确
	public List<UserSpringDataJpa> findByPhoneNot(String phone); //常用全包含....
	public List<UserSpringDataJpa> findByPhoneNotIn(List<String> phones); //常用全包含....
	
	
	public List<UserSpringDataJpa> findByPhoneLike(String phone);//全匹配字符.
	public List<UserSpringDataJpa> findByPhoneContains(String phone);//包含字符.
	public List<UserSpringDataJpa> findByPhoneContaining(String phone);
	public List<UserSpringDataJpa> findByPhoneStartingWith(String phone);
	public List<UserSpringDataJpa> findByPhoneEndingWith(String phone);
	
//	
//	排序
	public List<UserSpringDataJpa> findByPhoneInOrderByUsernameDesc(List<String> phones) ;//也可以是set集合
	public List<UserSpringDataJpa> findByPhoneInOrderByUsername(List<String> phones) ;//也可以是set集合省略是asc
	
	//queryBy ,readBy,getBy,遵循的规则和find一样.
	public List<UserSpringDataJpa> readByPhoneNotIn(List<String> phones); //常用全包含....
	public List<UserSpringDataJpa> queryByPhoneNotIn(List<String> phones); //常用全包含....
	public List<UserSpringDataJpa> getByPhoneNotIn(List<String> phones); //常用全包含....
	
	
	//查询前几条数据
	
	public List<UserSpringDataJpa> findTop3ByPhoneIsNotNull() ;//Top3
	public List<UserSpringDataJpa> findFirstByPhoneIsNotNull() ;//Top3
	public List<UserSpringDataJpa> findTop3ByPhoneIsNotNullOrderByIdDesc() ;//Top3 不写Desc默认ASC从小到大
	
//-----------------------------jpql语句查询-------------------------------------------------------------------------
	@Query("select u from UserSpringDataJpa u ")
	public List<UserSpringDataJpa> list() ;
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1")
	public UserSpringDataJpa takeByPhone(String phone) ;//返回单个对象.
	
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1 or username=?2")
	public List<UserSpringDataJpa> takeByPhone(String phone,String username) ;//建议写这种,位置对应好即可,简单
	
	@Query("select u from UserSpringDataJpa u where u.phone=:phone or username=:name")
	public List<UserSpringDataJpa> takeByPhoneOrUsername(@Param("name")String username,@Param("phone")String phone) ;//返回单个对象.
	
	
	@Query("select u from UserSpringDataJpa u where u.phone=?1 or username=?2 order by id desc")
	public List<UserSpringDataJpa> takeByPhoneSort(String phone,String username) ;//建议写这种,位置对应好即可,简单
	
	
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
	
	
	
	
	
	
	
}
