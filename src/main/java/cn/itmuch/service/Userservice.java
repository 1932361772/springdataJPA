package cn.itmuch.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.UserSpring;

@Service
public class Userservice {
	/*
	 * 使用spring容器中获取EntityManager对象,不需要手动管理事务
	 * insert update delete需要事务
	 * 使用事务,直接在方法上加 @Transactional 推荐这种方法,
*/
	@Autowired
//	@PersistenceUnit//jpa提供的注解.功能和上面一个一样
	private EntityManagerFactory emf;
	
	@PersistenceUnit//jpa提供的注解.功能和上面一个一样
	private EntityManagerFactory emf2;
	
//	@PersistenceContext//也可使用,jpa提供的注解.
	@Autowired
	private EntityManager em;
	
	public void addUser() {
		EntityManager em = emf.createEntityManager();//注释掉这一行,这个方法会报错.
		em.getTransaction().begin();
		UserSpring user = new UserSpring();
		user.setPhone("10010");
		user.setUsername("zhangsan");
		user.setStatus(1);
		em.persist(user);
		
		em.getTransaction().commit();
	}
	@Transactional
	public void addUser2() {
		System.err.println(emf==emf2);//true
//		EntityManager em = emf2.createEntityManager();//注释掉这一行,这个方法不会报错.
//		em.getTransaction().begin();//注释掉这一行,这个方法不会报错.
		UserSpring user = new UserSpring();
		user.setPhone("10011");
		user.setUsername("hibernate");
		user.setStatus(3);
		em.persist(user);
		
//		em.getTransaction().commit();
	}
	
	
	public void queryAll() {
		em.createQuery("select u from UserSpring u").getResultList().forEach(System.out::println);
	}
	
	public void query() {
		Query query = em.createQuery("select u from UserSpring u where u.status=?1 order by u.username");
		query.setParameter(1, 3);
		query.getResultList().forEach(System.out::println);
		
	}
	@Transactional
	public void delete(Integer id) {
		UserSpring user = em.find(UserSpring.class, id);
		em.remove(user);
	}
	
	@Transactional
	public void update(Integer id) {
		UserSpring user = em.find(UserSpring.class, id);
		user.setUsername("zhangsan3");
		em.merge(user);
	}
	
	
	
}
