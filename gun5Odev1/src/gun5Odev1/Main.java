package gun5Odev1;


import gun5Odev1.business.concretes.UserManager;
import gun5Odev1.core.GoogleManagerAdapter;
import gun5Odev1.dataAccess.concretes.HibernateUserDao;
import gun5Odev1.entity.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User("Ayþe","KAN","ab_c@hotmail.com","xyztvlk");
		
		UserManager userManager1=new UserManager(new HibernateUserDao());
		userManager1.signUp(user1);
		userManager1.link(user1);
		userManager1.login("ab_c@hotmail.com", "xyztvlk");
		userManager1.login("abc@hotmail.com", "xyztvlk");
		
		GoogleManagerAdapter googleManagerAdapter=new GoogleManagerAdapter();
		googleManagerAdapter.loginWithGoogleAccount("xyz@gmail.com","12345");
		googleManagerAdapter.loginWithGoogleAccount("xyz@hotmail.com","12345");
		
		User user2=new User("Can","CAM","ab_c@hotmail.com","xlmhjh");
		userManager1.signUp(user2);

		User user3=new User("C","CAM","ab_k@hotmail.com","xlmhkdf");
		userManager1.signUp(user3);
		
		User user4=new User("Ayla","T","ab_k@hotmail.com","xlmhkx");
		userManager1.signUp(user4);
	
		User user5=new User("Tan","Kol","ab_k@hotmail.com","xlmhk");
		userManager1.signUp(user5);
		
		User user6=new User("Tan","Kol","ab_k@mail.com","xlmhkts");
		userManager1.signUp(user6);
	}

}
