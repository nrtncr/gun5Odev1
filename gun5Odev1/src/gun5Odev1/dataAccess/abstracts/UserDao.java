package gun5Odev1.dataAccess.abstracts;

import java.util.List;

import gun5Odev1.entity.concretes.User;

public interface UserDao {
	void addUser(User user);
	List<User> getUsers();
}
