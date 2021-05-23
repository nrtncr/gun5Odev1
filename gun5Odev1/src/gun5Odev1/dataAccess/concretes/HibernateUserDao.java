package gun5Odev1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import gun5Odev1.dataAccess.abstracts.UserDao;
import gun5Odev1.entity.concretes.User;

public class HibernateUserDao implements UserDao {
	private List<User> users=new ArrayList();
	
	
	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public void addUser(User user) {
		
		if(users.size()==0) {
			users.add(0, user);
		}
		
		else {
		users.add(user);
		}
	}

	

	
	
	

}
