package cn.itmuch.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.itmuch.entity.UserSpringJpa;

public class JPATest {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
	@Test
	public void testAdd() {
		EntityManager em = emf.createEntityManager();
		UserSpringJpa user = new UserSpringJpa();
		user.setPhone("12345678912");
		user.setUsername("admin");
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}
	@Test
	public void testQuer() {
		EntityManager em = emf.createEntityManager();
		List<?> list = em.createQuery("select u from UserSpringJpa u").getResultList();//hql语句
		for (Object object : list) {
			System.out.println(object);
		}
		
	}
	@Test
	public void testFind() {
		EntityManager em = emf.createEntityManager();
		UserSpringJpa user = em.find(UserSpringJpa.class, 4);//处理查询语句不需要事务之外,其余的都需要事务.
		System.err.println(user);
	}
	@Test
	public void testUpdate() {
		EntityManager em = emf.createEntityManager();
		UserSpringJpa user = em.find(UserSpringJpa.class, 4);
		em.getTransaction().begin();//正确的写法是需要try catch块包裹事务的.
		user.setPhone("15212345698");
		em.getTransaction().commit();
		em.merge(user);
		em.close();
	}
	@Test
	public void testDelete() {
		EntityManager em = emf.createEntityManager();
		UserSpringJpa user = em.find(UserSpringJpa.class, 2);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}

	
}
