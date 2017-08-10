package cn.itmuch.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itmuch.entity.Book;
import cn.itmuch.entity.BookInfo;

@Service
public class BookQueryService {
	/*
	 * jpa CriteriaBuilder原生的查询.
	 * CriteriaBuilder 负责创建CriteriaBuilder(查询),Predicate(过滤条件)的工厂 
	 * createQuery 查询主语句
	 * 支持多表查询.
	 * 只能做查询,不能做增删改的.
	 * 
	 */
	@Autowired
	private EntityManager em;
	public void name() {
		
	}
	@Transactional
	public void save() {
		Book book = new Book();
		book.setPrice(11);
		book.setTitle("java");
		book.setType(1);
		em.persist(book);
	}
	
	
	public void query() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		query.from(Book.class);
		em.createQuery(query).getResultList().forEach(System.out::println);;
	}
	
	public void getById(Integer id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(cb.equal(root.get("id"), id));
		em.createQuery(query).getResultList().forEach(System.out::println);;
	}
	
	public void like(String title) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(cb.like(root.get("title"), "%"+title+"%"));
		em.createQuery(query).getResultList().forEach(System.out::println);
		
	}
	
	public void in() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(root.get("type").in(2,6));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	
	public void between() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(cb.between(root.get("price"), 11, 15));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	
	public void betweenAndIn() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(cb.between(root.get("price"), 11, 15),root.get("type").in(2,6));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	public void order() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(cb.equal(root.get("type"), 1)).orderBy(cb.desc(root.get("price")));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	public void orderbyMany() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.where(root.get("type").in(1,2,3)).orderBy(cb.asc(root.get("price")),cb.desc(root.get("type")));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	public void orderAndThen() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> query = cb.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.multiselect(root.get("title"),root.get("price"));//注意where的条件不能和multiselect重复.
		query.where(cb.equal(root.get("type"),2));
		query.orderBy(cb.desc(root.get("price")));
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	public void orderReturn() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Book> root = query.from(Book.class);
		query.multiselect(root.get("title"),root.get("price"));//注意where的条件不能和multiselect重复.
		query.where(cb.equal(root.get("type"),2));
		query.orderBy(cb.desc(root.get("price")));
		List<Object[]> list = em.createQuery(query).getResultList();
		for (Object[] objects : list) {
			System.err.println(objects[0]+"\t"+objects[1]);
		}
		
//		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	/*
	 * select type ,max(price) maxPrice ,sum(price) totalPrice from books group by type;
	 */
	public void GroupBy() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class); //object 可行.
		CriteriaQuery<BookInfo> query = cb.createQuery(BookInfo.class);
		Root<Book> root = query.from(Book.class);
		query.multiselect(root.get("type"),cb.max(root.get("price")),cb.sum(root.get("price")));//此处的对象顺序要和,BookInfo的构造函数的顺序一致..
		query.groupBy(root.get("type"));
		
		em.createQuery(query).getResultList().forEach(System.out::println);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
