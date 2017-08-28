package cn.itmuch.repository;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itmuch.Main;
import cn.itmuch.entity.UserSpring;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Main.class)
public class UserRepositoryTest {
	@Autowired
	private UserRepositoryextendscrud userRepositoryextendscrud;

	@Test
	public void testAdd() {
		UserSpring user = new UserSpring();
		user.setUsername("admin");
		user.setStatus(1);
		user.setPhone("121313");
		userRepositoryextendscrud.save(user);
		Assert.assertNotNull(user.getId());
		
	}
	@Test
	public void testDelete() {
		userRepositoryextendscrud.delete(3);
		Assert.assertNull(userRepositoryextendscrud.findOne(3));//和上面的一样才不报错.
	}
	
	@Test
	public void findAllTest() {
		Assert.assertTrue(userRepositoryextendscrud.findAll().iterator().hasNext());
	}
	
	@Test
	public void  getById() {
		Assert.assertNotNull(userRepositoryextendscrud.findById(4));
	}
	
	@Test
	public void list() {
		Assert.assertTrue(!(userRepositoryextendscrud.list().isEmpty()));
	}
	
	
	
	
	

}
