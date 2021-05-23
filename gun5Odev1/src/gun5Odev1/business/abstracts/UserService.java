package gun5Odev1.business.abstracts;

import gun5Odev1.entity.concretes.User;

public interface UserService {
	void signUp(User user);
	void login(String email,String password);
}
