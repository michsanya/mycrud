package crud.mycrud.dao;

import java.util.ArrayList;
import java.util.List;
import crud.mycrud.model.User;


public interface UserDao {
   void add(User user);
   User getUserById(int id);
   List<User> getAllUsers();
void save(User user);
}