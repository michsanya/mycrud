package crud.mycrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crud.mycrud.model.User;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}


	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(int id){
		TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(
				"from User where User.id = :id");
		query.setParameter("id", id);
		return query.getResultList().get(0);
	}
}
