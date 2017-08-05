package cn.itmuch;

import java.util.Arrays;
import java.util.function.Consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import cn.itmuch.entity.UserSpringDataJpa;
import cn.itmuch.repository.UserRepository;
import cn.itmuch.repository.UserRepositoryExtendspagingandsorting;
import cn.itmuch.repository.UserRepositoryextendsRe;
import cn.itmuch.repository.UserRepositoryextendscrud;
import cn.itmuch.repository.UserRepositoryextendsjparepository;

/**
 * Hello world!
 *
 */
@ComponentScan
@EnableJpaRepositories
public class App {
	public static void main(String[] args) {
		System.out.println("Hello springdataJPA...................");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		// 1,extends CrudRepository<UserSpringDataJpa, Integer>----
		System.out.println("repository extendscrud接口1:" + context.getBean(UserRepositoryextendscrud.class));
		UserRepositoryextendscrud repository = context.getBean(UserRepositoryextendscrud.class);
		// 2,extends Repository<UserSpringDataJpa,Integer>---------
		System.out.println("repository extendsRe接口2:" + context.getBean(UserRepositoryextendsRe.class));
		UserRepositoryextendsRe userRe = context.getBean(UserRepositoryextendsRe.class);
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

		// 保存操作:
//		 UserSpringDataJpa user = new UserSpringDataJpa();
//		 user.setPhone("133131");
//		 user.setUsername("a");
//		 user.setStatus(1);
//		 repository.save(user);

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
//		userRe.findByStatus(2).forEach(System.out::println);//// 与上面的等价.
		
//		可以多个字段一起查询.只能返回一个结果.尽量不用.用下面的一个返回list的方法.
//		System.err.println(userRe.findByUsernameAndPhone("z","10010"));
//		System.err.println(userRe.findByUsernameOrPhone("zhagnsanzh7", "10010"));
		
//		11:19秒---详解2--------------------------------------
//		userRe.findByPhoneIn(Arrays.asList("10010","10011","10012")).forEach(System.out::println);;
		
		
//		userRe.findByIdBetween(1, 10).forEach(System.out::println);
		
//		userRe.findByPhoneInOrderByUsernameDesc(Arrays.asList("10010","10011","10012","12312345691")).forEach(System.out::println);
		
//		userRe.findByIdLessThan(10).forEach(System.out::println);
//		userRe.findByIdLessThanEqual(10).forEach(System.out::println);
		
//		userRe.findByPhoneIsNull().forEach(System.out::println);
//		userRe.findByPhoneIsNotNull().forEach(System.out::println);
//		 userRe.findByPhoneNotNull().forEach(System.out::println);
//		userRe.findByPhoneNot("10010").forEach(System.out::println);//常用
//		userRe.findByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
		
//		userRe.findByPhoneLike("10010").forEach(System.out::println);
//		userRe.findByPhoneContains("1001").forEach(System.out::println);
//		userRe.findByPhoneContaining("00").forEach(System.out::println);
//		userRe.findByPhoneStartingWith("10").forEach(System.out::println);
//		userRe.findByPhoneEndingWith("91").forEach(System.out::println);
		
		//queryBy ,readBy,getBy,遵循的规则和find一样.
		
//		userRe.queryByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
//		userRe.readByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
//		userRe.getByPhoneNotIn(Arrays.asList("10010","10012")).forEach(System.out::println);
		
//		userRe.findTop3ByPhoneIsNotNull().forEach(System.out::println);
//		userRe.findFirstByPhoneIsNotNull().forEach(System.out::println);
		userRe.findTop3ByPhoneIsNotNullOrderByIdDesc().forEach(System.out::println);
		
		
	}
}
