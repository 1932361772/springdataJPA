package cn.itmuch.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.Person;
import cn.itmuch.entity.UserSpring;
import cn.itmuch.repository.PersonRepositoryExtCRUD;

@Service
public class PersonService {
	@Autowired
	private EntityManager em;
	@Transactional
	public void lazy() {
		Person p = em.find(Person.class, 6);
		System.err.println(p.getName());//@Transactional 在同一条事务之内,懒加载不会有异常.++++++++++++++++++++
		System.out.println("======================");
		System.err.println(p);
	}
	
	@Transactional
	public void delete(Integer id) {
		PersonRepositoryExtCRUD person = em.find(PersonRepositoryExtCRUD.class,1);
		em.remove(person);
	}
}
