package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import crud.mycrud.dao.UserDaoImpl;

public class UserDaoTest {
	@Autowired
	UserDaoImpl userDao;

	@Test
	public void checkUserDao() {
		Assert.notNull(userDao);
	}
}
