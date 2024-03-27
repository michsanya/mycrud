package crud.mycrud.dao;

import java.util.List;
import crud.mycrud.model.User;


public interface UserDao {
   void add(User user);
   List<User> listUsers();
}