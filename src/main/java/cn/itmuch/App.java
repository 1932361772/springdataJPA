package cn.itmuch;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.Buffer;

import cn.itmuch.entity.Book;
import cn.itmuch.entity.IdCard;
import cn.itmuch.entity.Person;
import cn.itmuch.entity.School;
import cn.itmuch.entity.Student;
import cn.itmuch.entity.Studentttt;
import cn.itmuch.entity.Teacher;
import cn.itmuch.entity.UserSpring;
import cn.itmuch.entity.UserSpringdataLock;
import cn.itmuch.filter.IncludeTypeFilter;
import cn.itmuch.repository.BookRepositoryextendsRe_S_Cri;
import cn.itmuch.repository.IdCardRepositoryExtCRUD;
import cn.itmuch.repository.PersonRepositoryExtCRUD;
import cn.itmuch.repository.SchoolRepositoryExtCRUD;
import cn.itmuch.repository.StudentRepositoryExtCRUD;
import cn.itmuch.repository.StudenttttRepositoryExtCRUD;
import cn.itmuch.repository.TeacherRepositorytyExtCRUD;
import cn.itmuch.repository.Use2xtendscrud;
import cn.itmuch.repository.UserRepository;
import cn.itmuch.repository.UserRepositoryExtendspagingandsorting;
import cn.itmuch.repository.UserRepositoryextendsRe1_4;
import cn.itmuch.repository.UserRepositoryextendsRe5_8;
import cn.itmuch.repository.UserRepositoryextendscrud;
import cn.itmuch.repository.UserRepositoryextendsjparepository;
import cn.itmuch.repository.UserSpringdataLockEtendscrud;
import cn.itmuch.service.BookQueryService;
import cn.itmuch.service.PersonService;
import cn.itmuch.service.Userservice;

/**
 * @EnableJpaRepositories默认扫描此类所在的包及其子包.
 * value和basepackages默认扫描此类所在的包及其子包.如果满足此规则,可以不配置.数组,可以设置多个一样,是数组.
 * basePackageClasses指定class路径. IncludeTypeFilters
 * 包含5种:指定注释,类型,aspect表达式,正则表达式,自定义.
 * excludeFilters包含5种:指定注释,类型,aspect表达式,正则表达式,自定义.
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */

@ComponentScan//启用组件(哪些实体类)扫描.
/*
 * @EnableJpaRepositories(value={"cn.itmuch.repository",},includeFilters={
 * 
 * @Filter(type=FilterType.ASSIGNABLE_TYPE,value=UserRepositoryextendscrud.class
 * ),
 * 
 * @Filter(type=FilterType.CUSTOM,value=IncludeTypeFilter.class)}////
 * 里面可以写任意的逻辑控制.
 * // @Filter(type=FilterType.ANNOTATION,value=Use2xtendscrud.class)}
 * )//@EnableJpaRepositories默认扫描此类所在的包及其子包.如果满足此规则,可以不配置.数组,可以设置多个.
 */
/*
 * @EnableJpaRepositories(value="cn.itmuch.repository",excludeFilters={
 * 
 * @Filter(type=FilterType.ASSIGNABLE_TYPE,value=UserRepositoryextendscrud.class
 * ),
 * 
 * @Filter(type=FilterType.CUSTOM,value=IncludeTypeFilter.class)////
 * 里面可以写任意的逻辑控制. })
 */

public class App {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Hello springdataJPA...................");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);//App.class入口类
				// 1,extends CrudRepository<UserSpringDataJpa, Integer>----
		/*System.out.println("repository extendscrud接口1:" + context.getBean(UserRepositoryextendscrud.class));
		UserRepositoryextendscrud repository = context.getBean(UserRepositoryextendscrud.class);
		// 2,extends Repository<UserSpringDataJpa,Integer>---------
		System.out.println("repository extendsRe接口2:" + context.getBean(UserRepositoryextendsRe1_4.class));
		UserRepositoryextendsRe1_4 userRe = context.getBean(UserRepositoryextendsRe1_4.class);
			// 2,extends Repository<UserSpringDataJpa,Integer>---------
		System.out.println("repository extendsRe接口2:" + context.getBean(UserRepositoryextendsRe5_8.class));
		UserRepositoryextendsRe5_8 userRe5_ = context.getBean(UserRepositoryextendsRe5_8.class);
		
		// 3,extends PagingAndSortingRepository<UserSpringDataJpa, Integer>.....
		System.out.println("repository Extendspagingandsorting接口3:"
				+ context.getBean(UserRepositoryExtendspagingandsorting.class));
		UserRepositoryExtendspagingandsorting userpagingandsorting = context
				.getBean(UserRepositoryExtendspagingandsorting.class);
		// 4,extends JpaRepository<UserSpringDataJpa, Integer>
		System.out.println(
				"repository Extendsjparepository接口4:" + context.getBean(UserRepositoryextendsjparepository.class));
		UserRepositoryextendsjparepository userjparepository = context
				.getBean(UserRepositoryextendsjparepository.class);
		//// 此为第二种定义的方式： 注解 第一种为继承4个接口中的一个.
		System.out.println("repository 定义注解的的方式:@RepositoryDefinition " + context.getBean(UserRepository.class));
		UserRepository userRepository = context.getBean(UserRepository.class);
*/

		// 保存操作:
		// UserSpringDataJpa user = new UserSpringDataJpa();
		// user.setPhone("133131");
		// user.setUsername("a");
		// user.setStatus(1);
		// repository.save(user);

		// -------------------------------
		// 查询
		// System.err.println(repository.findOne(1));
		// --------------------------------------------

		//
		// ------------------------------------------------
		// 更新
		// UserSpringDataJpa user = repository.findOne(2);
		//
		// System.out.println(user);
		// user.setStatus(2);
		// repository.save(user);
		// context.close();

		// ------------------------------
		// 删除
		// repository.delete(1);

		// 查询所有
		// repository.findAll().forEach((u)->{
		// System.err.println(u);
		// });
		// ------------------------------------------------
		// UserRepositoryextendsRe中自定义的方法
		// System.err.println(userRe.findByUsername("zhagnsanzh2"));//查询结果只限一条否则报错
		// System.err.println(userRe.findById(3));//查询结果只限一条否则报错
		// System.err.println(userRe.findByStatus(1));//查询结果只限一条否则报错
		/*
		 * userRe.findByStatus(1).forEach(new Consumer<UserSpringDataJpa>() {
		 * public void accept(UserSpringDataJpa u) { System.out.println(u); }
		 * });//与下面的等价.s
		 */// 查询结果可以多条,也可以查询一条.
		// userRe.findByStatus(2).forEach(System.out::println);//// 与上面的等价.

		// 可以多个字段一起查询.只能返回一个结果.尽量不用.用下面的一个返回list的方法.
		// System.err.println(userRe.findByUsernameAndPhone("z","10010"));
		// System.err.println(userRe.findByUsernameOrPhone("zhagnsanzh7",
		// "10010"));

		// 11:19秒---详解2--------------------------------------
		// userRe.findByPhoneIn(Arrays.asList("10010","10011","10012")).forEach(System.out::println);;

		// userRe.findByIdBetween(1, 10).forEach(System.out::println);

		// userRe.findByPhoneInOrderByUsernameDesc(Arrays.asList("10010","10011","10012","12312345691")).forEach(System.out::println);

		// userRe.findByIdLessThan(10).forEach(System.out::println);
		// userRe.findByIdLessThanEqual(10).forEach(System.out::println);

		// userRe.findByPhoneIsNull().forEach(System.out::println);
		// userRe.findByPhoneIsNotNull().forEach(System.out::println);
		// userRe.findByPhoneNotNull().forEach(System.out::println);
		// userRe.findByPhoneNot("10010").forEach(System.out::println);//常用
		// userRe.findByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);

		// userRe.findByPhoneLike("10010").forEach(System.out::println);
		// userRe.findByPhoneContains("1001").forEach(System.out::println);
		// userRe.findByPhoneContaining("00").forEach(System.out::println);
		// userRe.findByPhoneStartingWith("10").forEach(System.out::println);
		// userRe.findByPhoneEndingWith("91").forEach(System.out::println);

		// queryBy ,readBy,getBy,遵循的规则和find一样.

		// userRe.queryByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
		// userRe.readByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
		// userRe.getByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);

		// userRe.findTop3ByPhoneIsNotNull().forEach(System.out::println);
		// userRe.findFirstByPhoneIsNotNull().forEach(System.out::println);
		// userRe.findTop3ByPhoneIsNotNullOrderByIdDesc().forEach(System.out::println);

		// -----------------------------jpql语句查询-------------------------------------------------------------------------
		// userRe.list().forEach(System.out::println);

		// System.out.println(userRe.takeByPhone("10012"));//只能有一个返回值.

		// System.out.println(userRe.takeByPhone("10012","zhagnsanzh22"));

		// userRe.takeByPhone("10012","zhagnsanzh").forEach(System.out::println);
		// userRe.takeByPhoneOrUsername("zhagnsanzh","10012").forEach(System.out::println);
		// userRe.takeByPhoneSort("10012",
		// "zhagnsanzh").forEach(System.out::println);

		// userRe.UpdateUser();//更新，
		// userRe.UpdateUser(4,2);//更新，
		// userRe.UpdateUser(3, 2);

		// userRe.deleteByUsername("zhagnsanzh");

		// springdatajpa 详解(四):
		// 排序,分页,方法的返回值--------------------------------------------

		// userRe.queryByStatusOrderByUsername(1).forEach(System.out::println);;
		// userRe.queryByStatusOrderByUsernameDesc(1).forEach(System.out::println);
		// userRe.queryByStatus(1).forEach(System.out::println);

		// userRe.queryByStatus(1,new Sort(new
		// Order(Direction.ASC,"username"))).forEach(System.out::println);

		// userRe.queryAll(1, new Sort(new
		// Order(Direction.ASC,"username"))).forEach(System.out::println);

		// 可以根据多个条件排序.根据status升序,根据username降序.传多个Order即可.
		// userRe.queryAll(1,new Sort(new Order(Direction.ASC,"status"),new
		// Order(Direction.DESC,"username"))).forEach(System.out::println);

		// userRe.queryAll(new Sort(new Order(Direction.ASC,"status"),new
		// Order(Direction.DESC,"username"))).forEach(System.out::println);

		// userRe.getByStatus(1,new PageRequest(1,
		// 3)).forEach(System.out::println);//第一页为0.每页显示3条数据.

		// Page<UserSpringDataJpa> page = userRe.getByStatus(1,new
		// PageRequest(10, 3));
		// System.err.println("总记录条数:"+page.getTotalElements());
		// System.err.println("总页数:"+page.getTotalPages());
		// page.getContent().forEach(System.out::println);

		// ////Page<UserSpringDataJpa> page1 = userRe.getByStatus(1, new
		// Sort(new Order(Direction.DESC,"username")), new PageRequest(1,
		// 3));//不支持这种
		// Page<UserSpringDataJpa> page1 = userRe.getByStatus(1, new
		// PageRequest(1, 3, new Sort(new
		// Order(Direction.DESC,"username"))));//支持这种
		// System.err.println("总记录条数:"+page1.getTotalElements());
		// System.err.println("总页数:"+page1.getTotalPages());
		// page1.getContent().forEach(System.out::println);

		// Page<UserSpringDataJpa> page2 = userRe.findAll(new PageRequest(0,
		// 3,new Sort(new Order(Direction.DESC,"username"))));
		// System.err.println("总记录条数:"+page2.getTotalElements());
		// System.err.println("总页数:"+page2.getTotalPages());
		// page2.getContent().forEach(System.out::println);

		// 详解4 21分钟.

		// Slice<UserSpringDataJpa> slice = userRe.getAll(new PageRequest(0,
		// 3,new Sort(new Order(Direction.DESC,"username"))));
		// slice.getContent().forEach(System.out::println);

		// userRe.set().forEach(System.out::println);

		// userRe.collection().forEach(System.out::println);
		// userRe.iterable().forEach(System.out::println);

		// Arrays.asList(userRe.array()).forEach(System.out::println);

		// userRe.stream().forEach(System.out::println);//失败:

		// String str =
		// userRe.stream().map((x)->x.getId()+"").collect(Collectors.joining(","));//失败:
		// System.out.println(str);//失败:
		//
		// System.err.println(userRe.readById(8));

		// 异步需要在此处启用异步

		// System.err.println(userRe.queryById(8).get());
		// System.err.println(userRe.getById(8).get());

		// springdatajpa 详解(五): 命名查询

		// System.err.println(userRe5_.byId(40));

		// System.err.println(userRe5_.byList());
		// userRe5_.byList().forEach(System.out::println);

		// userRe5_.byusername("zhagnsanzh7").forEach(System.out::println);

		// userRe5_.byPage(1, new PageRequest(1,
		// 5)).forEach(System.out::println);

		// userRe5_.pageByStatus(1, new PageRequest(1,
		// 5)).forEach(System.out::println);

		// System.err.println(userRe5_.byIdd(7));

		// System.err.println(userRe5_.byIdd2(7));

		// System.err.println(userRe5_.getUsernameAndPhone(7));

		// userRe5_.bySort(new Sort(new
		// Order(Direction.DESC,"username"))).forEach(System.out::println);
		// //失败.原因:不能和分页联合使用.因为,这是自定义的底层sql,jpql语句没有再参与解析.
		// userRe5_.bySort().forEach(System.out::println);//成功
		// userRe5_.byPage(1, new PageRequest(1,
		// 5)).forEach(System.out::println);//失败.原因:不能和分页联合使用.因为,这是自定义的底层sql,jpql语句没有再参与解析.
		// userRe5_.byPages().forEach(System.out::println);//失败

		// springdatajpa 详解(六): 本地命名查询的映射------------------------

		// userRe5_.listmapping().forEach(System.out::println);
		// userRe5_.phonemapping().forEach(System.out::println);

		// userRe5_.phonemapping3().forEach(System.out::println);

		// userRe5_.phonemapping4().forEach(System.out::println);
		/*
		 * for (Object o : userRe5_.phonemapping4()) {
		 * System.err.println(o.getClass());//显示对象 Object[] objects=(Object[])
		 * o; // System.err.println(objects.length); for (int i = 0; i <
		 * objects.length; i++) { // System.err.print(objects[i]);
		 * 
		 * }
		 * 
		 * // System.err.println(objects[0]+"\t"+objects[1]); }
		 */

		/*
		 * for (Object o : userRe5_.phonemapping4()) { //
		 * System.err.println(o.getClass());//显示对象 Object[] objects=(Object[])
		 * o; // System.err.println(objects.length);//显示对象长度.
		 * System.err.println(objects[0]+"\t"+objects[1]); }
		 */

		// springdatajpa 详解(七):使用原生的jpa api------------------------

		// context.getBean(Userservice.class).addUser();
		// context.getBean(Userservice.class).addUser2();

		// context.getBean(Userservice.class).queryAll();
		// context.getBean(Userservice.class).query();

		// context.getBean(Userservice.class).delete(1);
		// context.getBean(Userservice.class).update(3);

		// springdatajpa 详解(八):JPA Criteria query------------------------

		// context.getBean(BookQueryService.class).save();
		// context.getBean(BookQueryService.class).query();

		// context.getBean(BookQueryService.class).getById(2);

		// 12分钟

		// context.getBean(BookQueryService.class).like("java");

		// context.getBean(BookQueryService.class).in();

		// context.getBean(BookQueryService.class).between();

		// context.getBean(BookQueryService.class).betweenAndIn();

		// context.getBean(BookQueryService.class).order() ;

		// context.getBean(BookQueryService.class).orderbyMany();

		// context.getBean(BookQueryService.class).orderAndThen();

		// context.getBean(BookQueryService.class).orderReturn() ;
		// context.getBean(BookQueryService.class).GroupBy();

		// springdatajpa 详解(九):springdatajpa JPA Criteria=====================================
		// query------------------------

		/*
		 * BookRepositoryextendsRe_S_Cri br =
		 * context.getBean(BookRepositoryextendsRe_S_Cri.class); Book book =
		 * br.findOne(new Specification<Book>() {
		 * 
		 * @Override public Predicate toPredicate(Root<Book> root,
		 * CriteriaQuery<?> query, CriteriaBuilder cb) { // TODO Auto-generated
		 * method stub return cb.equal(root.get("id"), 1); } });
		 * System.err.println(book);
		 */

	/*	BookRepositoryextendsRe_S_Cri br = context.getBean(BookRepositoryextendsRe_S_Cri.class);
		List<Book> books = br.findAll(new Specification<Book>() {

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.equal(root.get("type"), 2);
			}
		});
		books.forEach(System.out::println);*/
		

		
/*		BookRepositoryextendsRe_S_Cri br = context.getBean(BookRepositoryextendsRe_S_Cri.class);
		List<Book> books = br.findAll(new Specification<Book>() {

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.orderBy(cb.desc(root.get("price")));
				return cb.equal(root.get("type"), 2);
			}
		});
		books.forEach(System.out::println);
		*/
		
	/*	List<Book> books = br.findAll(new Specification<Book>() {
		BookRepositoryextendsRe_S_Cri br = context.getBean(BookRepositoryextendsRe_S_Cri.class);

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isNotNull(root.get("title"));
			}
		},new Sort(new Order(Direction.ASC,"price"),new Order(Direction.ASC,"id")));
		books.forEach(System.out::println);
		*/
//		没有排序的分页
/*		BookRepositoryextendsRe_S_Cri br = context.getBean(BookRepositoryextendsRe_S_Cri.class);
		 Page<Book> pages = br.findAll(new Specification<Book>() {

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isNotNull(root.get("title"));
			}
		} ,new PageRequest(5, 3));
		pages.forEach(System.out::println);
			System.err.println("总页数:"+pages.getTotalPages()+"总记录数:"+pages.getTotalElements());
		*/
//			有排序的分页	
		
	/*		BookRepositoryextendsRe_S_Cri br = context.getBean(BookRepositoryextendsRe_S_Cri.class);
			 Page<Book> pages = br.findAll(new Specification<Book>() {

				@Override
				public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					return cb.isNotNull(root.get("title"));
				}
			} ,new PageRequest(0, 5,new Sort(new Order(Direction.ASC,"price"),new Order(Direction.ASC,"id"))));
			pages.forEach(System.out::println);
				System.err.println("总页数:"+pages.getTotalPages()+"总记录数:"+pages.getTotalElements());
	
				
		long count = br.count(new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				cb.between(root.get("price"), 11, 13);
				return cb.isNotNull(root.get("title"));
			}
		});
		System.err.println("count:"+count);
		
		*/
		
/*		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		IdCardRepositoryExtCRUD idr = context.getBean(IdCardRepositoryExtCRUD.class);
		IdCard id = new IdCard();
		id.setCardNum("411500198002000002");
		idr.save(id);//	保存person之前必须先保存idcard;	设置@OneToOne(cascade={CascadeType.PERSIST})之后可自动先保存.
		
		Person person2 = new Person();
		person2.setAge(22);
		person2.setName("zhangsss");
		person2.setIdCard(id);
		pr.save(person2);*/
		
/*		
//		设置@OneToOne(cascade={CascadeType.PERSIST})之后可自动先保存.
		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		IdCard id = new IdCard();
		id.setCardNum("411500198002000005");

		Person person2 = new Person();
		person2.setAge(22);
		person2.setName("zhangsss");
		person2.setIdCard(id);
		pr.save(person2);*/
		
/*		
//		级联删除 @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		pr.delete(4);*/
/*		
//		立即加载和懒加载
		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		Person p = pr.findOne(2);
		System.err.println(p.getName());
		System.err.println(p.getAge());
		System.err.println(p.getId());
//		System.out.println(p.getIdCard());
		
*/		
		
		/*PersonService personService = context.getBean(PersonService.class);
		personService.lazy();*/
		
		
/*		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		Person person2 = new Person();
		person2.setAge(22);
		person2.setName("zhangsss");
		pr.save(person2);
   		*/
		
		
/*	IdCardRepositoryExtCRUD idr = context.getBean(IdCardRepositoryExtCRUD.class);
		Person p = new Person();
		p.setAge(11);
		p.setName("zhagnss3");
		
		IdCard id = new IdCard();
		id.setCardNum("1234323123132123");
		id.setPerson(p);
		p.setIdCard(id);
		
		idr.save(id);*/
		
		
/*	IdCardRepositoryExtCRUD idr = context.getBean(IdCardRepositoryExtCRUD.class);
		PersonRepositoryExtCRUD pr = context.getBean(PersonRepositoryExtCRUD.class);
		System.err.println(idr.findOne(1));
//		System.err.println(pr.findOne(1));
		PersonService personService = new PersonService();
//		personService.delete(1);失败
		*/
		
		
//		
/*		
//一对多,多对一关联关系.	保存	
		Student st1 = new Student();
		st1.setAge(11);
		st1.setName("zh31");
		
		Student st2 = new Student();
		st2.setAge(11);
		st2.setName("zh32");
		
		
		School school = new School();
		school.setName("zhenzou1");
		school.setStudents(Arrays.asList(st1,st2));
		
		context.getBean(SchoolRepositoryExtCRUD.class).save(school);*/
		
		
/*//		一对多,多对一关联关系.	查询
		SchoolRepositoryExtCRUD sr = context.getBean(SchoolRepositoryExtCRUD.class);
		System.err.println(sr.findOne(1).toString());
		*/
		
	/*	一对多,多对一关联关系.	删除
	 * SchoolRepositoryExtCRUD sr = context.getBean(SchoolRepositoryExtCRUD.class);
		sr.delete(5);
		*/
		
		
/*		双向一对多保存,多一个中间表（执行ok语句）
 * SchoolRepositoryExtCRUD sr = context.getBean(SchoolRepositoryExtCRUD.class);
		StudentRepositoryExtCRUD str = context.getBean(StudentRepositoryExtCRUD.class);
		School sch = new School();
		sch.setName("gaojizhongxue");
		
		Student s2 = new Student();
		s2.setAge(12);
		s2.setName("admin");
		s2.setSchool(sch);
		sch.setStudents(Arrays.asList(s2));//若不设置这一行这在中间表中是空值,在一的一端查不出来多的一方.
		
		str.save(s2);
*/
		
//		双向一对多查询,多一个中间表（执行ok语句）
		
//		System.out.println(context.getBean(StudentRepositoryExtCRUD.class).findOne(2));
//		System.out.println(context.getBean(SchoolRepositoryExtCRUD.class).findOne(2));
		

/*		
		//维护表关系 由一的一端维护.(school<--===>student)
		SchoolRepositoryExtCRUD sch_re = context.getBean(SchoolRepositoryExtCRUD.class);
		StudentRepositoryExtCRUD stu_re = context.getBean(StudentRepositoryExtCRUD.class);
		
		School sc = new School();
		sc.setName("gaoji高级中学");
		
		Student st = new Student();
		st.setAge(111);
		st.setName("zhang3");
		st.setSchool(sc);
		Student st2 = new Student();
		st2.setAge(121);
		st2.setName("zhang2");
		st2.setSchool(sc);
		
		sc.setStudents(Arrays.asList(st,st2));
		
		sch_re.save(sc);		
	*/
		
/*
  //		springdatejpa  详解(十五): 多对多关联关系(理解成双向一对多关联关系.teacher<==>student)
//		没有使用级联操作
		TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
		StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
		
		Studentttt s1 = new Studentttt();
		s1.setName("s1");
		Studentttt s2 = new Studentttt();
		s2.setName("s2");
		Studentttt s3 = new Studentttt();
		s3.setName("s3");
		Studentttt s4 = new Studentttt();
		s4.setName("s4");
		
		Teacher t1 = new Teacher();
		t1.setName("T1");
		t1.setStudentttts(Arrays.asList(s2,s3));
		Teacher t2 = new Teacher();
		t2.setName("T2");
		t2.setStudentttts(Arrays.asList(s1));
		Teacher t3 = new Teacher();
		t3.setName("T3");
		t3.setStudentttts(Arrays.asList(s1,s2,s3));
		Teacher t4 = new Teacher();
		t4.setName("T4");
		t4.setStudentttts(Arrays.asList(s4,s1,s2,s3));
		stu_re.save(s1);	
		stu_re.save(s2);
		stu_re.save(s3);
		stu_re.save(s4);
		
		tea_re.save(t1);
		tea_re.save(t2);
		tea_re.save(t3);
		tea_re.save(t4);
		*/
/*
 * 
 //		使用级联操作后//(cascade=CascadeType.PERSIST)//在多对多的关联关系中不能使用级联删除和级联保存.(这一规则同样适用一对多的关联关系.)
//		解决方法是让对象单独实例化.持久化.
		TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
		StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
		
		Studentttt s1 = new Studentttt();
		s1.setName("s1");
		Studentttt s2 = new Studentttt();
		s2.setName("s2");
		Studentttt s3 = new Studentttt();
		s3.setName("s3");
		Studentttt s4 = new Studentttt();
		s4.setName("s4");
		
		Teacher t1 = new Teacher();
		t1.setName("T1");
		t1.setStudentttts(Arrays.asList(s2,s3));
		Teacher t2 = new Teacher();
		t2.setName("T2");
		t2.setStudentttts(Arrays.asList(s1));
		Teacher t3 = new Teacher();
		t3.setName("T3");
		t3.setStudentttts(Arrays.asList(s1,s2,s3));
		Teacher t4 = new Teacher();
		t4.setName("T4");
		t4.setStudentttts(Arrays.asList(s4,s1,s2,s3));
		
		tea_re.save(t1);
		tea_re.save(t2);
		tea_re.save(t3);
		tea_re.save(t4);
		*/
//		15分钟
/*		
//	查询.。。。。。。。。。
		TeacherRepositorytyExtCRUD tr = context.getBean(TeacherRepositorytyExtCRUD.class);		
		System.err.println(tr.findOne(3));
*/
	
	/*//1,双向manytomany中,在保存A方时先不设置关联关系.2,B方保存时设置关联关系.3.设置A方的关联关系,然后保存.
		TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
		StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
		
		Studentttt s1 = new Studentttt();
		s1.setName("s11");
		Studentttt s2 = new Studentttt();
		s2.setName("s21");
		Studentttt s3 = new Studentttt();
		s3.setName("s31");
		Studentttt s4 = new Studentttt();
		s4.setName("s41");
		
		stu_re.save(s1);	
		stu_re.save(s2);
		stu_re.save(s3);
		stu_re.save(s4);//保存的顺序很重要.否则会报错.现将需要引用的一方保存起来,之后再引用,则不会报错.
//		1,双向manytomany中,在保存A方时先不设置关联关系.(注意在保存前不能设置关联关系.否则会报错.)
		Teacher t1 = new Teacher();
		t1.setName("T1");
		t1.setStudentttts(Arrays.asList(s2,s3));
		Teacher t2 = new Teacher();
		t2.setName("T2");
		t2.setStudentttts(Arrays.asList(s1));
		Teacher t3 = new Teacher();
		t3.setName("T3");
		t3.setStudentttts(Arrays.asList(s1,s2,s3));
		Teacher t4 = new Teacher();
		t4.setName("T4");
		t4.setStudentttts(Arrays.asList(s4,s1,s2,s3));
		
		tea_re.save(t1);
		tea_re.save(t2);
		tea_re.save(t3);
		tea_re.save(t4);
//		2,B方保存时设置关联关系.(注意在保存前必须设置关联关系.否则信息会不全.)
//		只要在这里设置集合之前,将引用保存的到数据库即不会报异常.因为没有保存的话,都不会有id,更不会有类对id的引用必定失败.
		s1.setTeachers(Arrays.asList(t1,t2,t3));
		s2.setTeachers(Arrays.asList(t1,t2,t4));
		s3.setTeachers(Arrays.asList(t1,t3));
		s4.setTeachers(Arrays.asList(t1,t2,t3,t4));
	
		stu_re.save(s1);	
		stu_re.save(s2);
		stu_re.save(s3);
		stu_re.save(s4);
//		3.设置A方的关联关系,然后保存.
		*/
		
		//1,双向manytomany中,在保存A方时先不设置关联关系.2,B方保存时设置关联关系.3.设置A方的关联关系,然后保存.
				
/*			
				//保存的顺序很重要.否则会报错.现将需要引用的一方保存起来,之后再引用,则不会报错.
//				1,双向manytomany中,在保存A方时先不设置关联关系.(注意在保存前不能设置关联关系.否则会报错.)
//				2,B方保存时设置关联关系.(注意在保存前必须设置关联关系.否则信息会不全.)
//						只要在这里设置集合之前,将引用保存的到数据库即不会报异常.因为没有保存的话,都不会有id,更不会有类对id的引用必定失败.
//				3.设置A方的关联关系,然后保存.
				TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
				StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
				
				Studentttt s1 = new Studentttt();
				s1.setName("s11");
				Studentttt s2 = new Studentttt();
				s2.setName("s21");
				Studentttt s3 = new Studentttt();
				s3.setName("s31");
				Studentttt s4 = new Studentttt();
				s4.setName("s41");
			
				Teacher t1 = new Teacher();
				t1.setName("T1");
				Teacher t2 = new Teacher();
				t2.setName("T2");
				Teacher t3 = new Teacher();
				t3.setName("T3");
				Teacher t4 = new Teacher();
				t4.setName("T4");
				
				tea_re.save(t1);
				tea_re.save(t2);
				tea_re.save(t3);
				tea_re.save(t4);//A在设置关联以前先把一方保存了
				
				s1.setTeachers(Arrays.asList(t1,t2,t3));
				s2.setTeachers(Arrays.asList(t1,t2,t4));
				s3.setTeachers(Arrays.asList(t1,t3));
				s4.setTeachers(Arrays.asList(t1,t2,t3,t4));//B设置关联
				
				stu_re.save(s1);	//C把已经设置的关联保存了
				stu_re.save(s2);
				stu_re.save(s3);
				stu_re.save(s4);
				
				t1.setStudentttts(Arrays.asList(s2,s3));//D设置另一方的关联.
				t2.setStudentttts(Arrays.asList(s1));
				t3.setStudentttts(Arrays.asList(s1,s2,s3));
				t4.setStudentttts(Arrays.asList(s4,s1,s2,s3));
				
				tea_re.save(t1);//E保存这一方的关联.
				tea_re.save(t2);
				tea_re.save(t3);
				tea_re.save(t4);
			*/
		
//		System.out.println(tea_re.findOne(3));
		
//		System.out.println(stu_re.findOne(2));
		
		

/*
//在student类的private List<Teacher> teachers上设置@ManyToMany(mappedBy="studentttts") 由teacher来维护关系.		
		
		TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
		StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
		
				Studentttt s1 = new Studentttt();
				s1.setName("s11");
				Studentttt s2 = new Studentttt();
				s2.setName("s21");
				Studentttt s3 = new Studentttt();
				s3.setName("s31");
				Studentttt s4 = new Studentttt();
				s4.setName("s41");
	
				Teacher t1 = new Teacher();
				t1.setName("T1");
				Teacher t2 = new Teacher();
				t2.setName("T2");
				Teacher t3 = new Teacher();
				t3.setName("T3");
				Teacher t4 = new Teacher();
				t4.setName("T4");
				
				stu_re.save(s1);	//C把已经设置的关联保存了
				stu_re.save(s2);
				stu_re.save(s3);
				stu_re.save(s4);
				
				t1.setStudentttts(Arrays.asList(s2,s3));//关联关联关系已经设置了由teacher维护,此时的s1,s2,s3,等需要是已经保存的.
				t2.setStudentttts(Arrays.asList(s1));
				t3.setStudentttts(Arrays.asList(s1,s2,s3));
				t4.setStudentttts(Arrays.asList(s4,s1,s2,s3));
				
				tea_re.save(t1);//E保存这一方的关联.
				tea_re.save(t2);
				tea_re.save(t3);
				tea_re.save(t4);*/
			//////////////////////////////////	
	/*		//此时这样保存已经无效,设置无效.因为关联关联关系已经设置了由teacher维护,
	 	 		tea_re.save(t1);//E保存这一方的关联.
				tea_re.save(t2);
				tea_re.save(t3);
				tea_re.save(t4);
				
	   			s1.setTeachers(Arrays.asList(t1,t2,t3));
				s2.setTeachers(Arrays.asList(t1,t2,t4));
				s3.setTeachers(Arrays.asList(t1,t3));
				s4.setTeachers(Arrays.asList(t1,t2,t3,t4));//B设置关联
			
				stu_re.save(s1);	//C把已经设置的关联保存了
				stu_re.save(s2);
				stu_re.save(s3);
				stu_re.save(s4);
				*/
		
	/*	TeacherRepositorytyExtCRUD tea_re = context.getBean(TeacherRepositorytyExtCRUD.class);
		StudenttttRepositoryExtCRUD stu_re = context.getBean(StudenttttRepositoryExtCRUD.class);
//				虽然关系由单方维护,但每一方都可以查询到关联数据.	
//				System.out.println(tea_re.findOne(2));
		
				System.err.println(stu_re.findOne(1));
				
	*/			
				
//springdatajpa关联关系总结.(十六节.)
				

				//springdatajpa关联关系总结.(十六节.)
	/*			一<实现方式>
				1,oneToOne使用的是架子的的方式维护关联关系,默认立即加载,,配合joincolumn修改字段别名.
				2,oneToMany,manyTomany是通过增加中间表来实现关联关系.;配合joinTable修改表别名.

				二<级联>在操作当前对象的时候,关联对象一起操作.cascade,()
				1,oneToMany,manyTomany是通过增加中间表来实现关联关系.特别是:不要操作级联增加.删除(因为有重复保存和删除问题.)
				三<curdrepository.save>方法,在保存之前会执行查询方法,如果的已经存在,则会更新.
				四<fetch>立即加载和延迟加载.
					onetoone,manytoone:默认立即加载
					onetomany,manytomany:默认延迟加载.
					不能双方都是立即加载. 必须在事务范围之类访问对象.
				五onetoone中的<optional>
					为true,在加载对方表的时候,使用left join,否则使用inner join.
					
				mappedby 一般用在双向关联中,单项关联的关系中不要使用.1,把关系的维护方交给对方.2,交给对方之后,就不会增加表来维护关联关系了.3.不要和joinTable一起使用.		
*/				
				
				//springdatajpa.(十七节.) enablejpaRepository注解.
				
				
/*	Use2xtendscrud user = context.getBean(Use2xtendscrud.class);
//			user.listAllUser().forEach(System.out::println);
		user.listAlluser2().forEach(System.out::println);
		*/
		
/*		
		StudentRepositoryExtCRUD stu = context.getBean(StudentRepositoryExtCRUD.class);
		Student s = new Student();
				s.setAge(11);
				s.setName("zhaang2");
				stu.save(s);
//			stu.findOne(2);	
*/				
		
		
		
/*		StudentRepositoryExtCRUD stu = context.getBean(StudentRepositoryExtCRUD.class);
		Student s =stu.findOne(5);	
				s.setAge(12);
				s.setName("zhaang111111112");
				stu.save(s);*/
		
	/*	StudentRepositoryExtCRUD stu= context.getBean(StudentRepositoryExtCRUD.class);
		Student s = new Student();
		s.setAge(11);
		s.setName("zhaang2");
		s.setCreateDate(new Date());
		s.setCreator("boss");
		stu.save(s);
		*/
		
/*		StudentRepositoryExtCRUD stu= context.getBean(StudentRepositoryExtCRUD.class);
		Student s = stu.findOne(1);
		s.setName("zhang33");
		s.setEditDate(new Date());
		s.setEditor("hr");
		
		stu.save(s);
		第二种方法使用监听的方式实现.
		
		*/
/*		StudentRepositoryExtCRUD stu= context.getBean(StudentRepositoryExtCRUD.class);
//		Student s = stu.findOne(6);
		Student s = new Student();
		s.setName("zhang");
//		s.setEditDate(new Date());
//		s.setEditor("hr2");
		s.setAge(11);
		
		stu.save(s);
		*/
		
/*		StudentRepositoryExtCRUD str = context.getBean(StudentRepositoryExtCRUD.class);
		Object object = str.queryTimeoutByspringdate();
		System.out.println(object);
		*/
		
//	版本version管理乐观锁:	
//		UserSpringdataLockEtendscrud user_r = context.getBean(UserSpringdataLockEtendscrud.class);
//		UserSpringdataLock user = new UserSpringdataLock();
//		user.setUsername("zhangs3");
//		user.setStatus(1);
//		user.setPhone("12300");
//		user_r.save(user);
//	
		
/*		UserSpringdataLockEtendscrud user_r = context.getBean(UserSpringdataLockEtendscrud.class);
 * UserSpringdataLock userone = user_r.findOne(1);
	System.err.println(userone);
	userone.setUsername("zhangs3");
	TimeUnit.SECONDS.sleep(10);
	userone.setStatus(2);
	user_r.save(userone);*/
		
/*		UserSpringdataLockEtendscrud user_r = context.getBean(UserSpringdataLockEtendscrud.class);	
 * UserSpringdataLock userone = user_r.getById(1);
		System.err.println(userone);
		userone.setUsername("zhangs3");
		TimeUnit.SECONDS.sleep(10);
		user_r.save(userone);
		*/
		
//		乐观锁.
//		UserSpringdataLockEtendscrud user_r = context.getBean(UserSpringdataLockEtendscrud.class);
//		context.getBean(Userservice.class).lock();
		
		
	/*	UserSpringdataLockEtendscrud user_r = context.getBean(UserSpringdataLockEtendscrud.class);
		UserSpringdataLock user = user_r.gettById(1);
		System.out.println(user);
		TimeUnit.SECONDS.sleep(20);
		
		System.err.println("end");*/
		
		
//		悲观锁
		
//		context.getBean(Userservice.class).readlock();
		
//		context.getBean(Userservice.class).writelock();
		
		context.getBean(Userservice.class).writelock2();
		
		
		
		
		
		
		
		
		
		
		
		
		
		context.close();

	}
}
