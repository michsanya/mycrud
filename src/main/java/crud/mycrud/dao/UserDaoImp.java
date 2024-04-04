package crud.mycrud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.mycrud.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(int id){
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
}
