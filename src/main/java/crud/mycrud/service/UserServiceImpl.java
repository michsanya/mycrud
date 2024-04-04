package crud.mycrud.service;

import crud.mycrud.dao.UserDao;
import crud.mycrud.model.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
