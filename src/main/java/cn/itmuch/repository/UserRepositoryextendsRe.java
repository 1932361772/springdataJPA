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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
