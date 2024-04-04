package crud.mycrud.service;

import java.util.ArrayList;
import java.util.List;

import crud.mycrud.model.User;

public interface UserService {
    User getUserById(int id);

	List<User> getAllUsers();

	void save(User user);
}
