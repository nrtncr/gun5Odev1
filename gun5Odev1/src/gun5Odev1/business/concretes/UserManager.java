package gun5Odev1.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import gun5Odev1.business.abstracts.UserService;
import gun5Odev1.dataAccess.abstracts.UserDao;
import gun5Odev1.entity.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	 
	@Override
	public void signUp(User user) {
		//AD SOYAD KONTROLÜ
				String firstName=user.getFirsName();
				char[] cFirstName=firstName.toCharArray();
				
				String lastName=user.getLastName();
				char[] cLastName=lastName.toCharArray();
				
				if(cFirstName.length<2 || cLastName.length<2) {
					System.out.println("Üyelik gerçekleþtirilemedi.Ad ve soyad en az 2 karakterden oluþmalýdýr.");
					return;
				}		
				
				
		
		//E-POSTA FORMAT KONTROLÜ
		String regex="^(.+)@hotmail.com";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(user.getEmail());
		if(!matcher.matches()) {
			System.out.println("Üyelik gerçekleþtirilemedi.Lütfen geçerli bir e-posta adresi giriniz.");
			return;
		}

		if(userDao.getUsers()!=null) {
		List<User> users=userDao.getUsers();
		
		
		//E-POSTA KULLANILIYOR MU?
		
		for(User USER:users) {
			if(USER.getEmail()==user.getEmail() ) {
				System.out.println("Üyelik gerçekleþtirilemedi.Bu e-posta adresine sahip bir kullanýcý zaten var.");
				return;
			}
		
		}
		
	}
		//ÞÝFRE KONTROLÜ
		
		String password=user.getPassword();
		char[] cPassword=password.toCharArray();
		if(cPassword.length<6) {
			System.out.println("Üyelik gerçekleþtirilemedi.Þifre en az 6 karakterden oluþmalýdýr.");
			return;
		}	
		
		System.out.println("E-mail adresinize doðrulama e-postasý gönderildi.Üyeliðinizin tamamlanabilmesi için lütfen doðrulama linkine týklayýnýz.");
	}
	
	 public void link(User user) {
			System.out.println("Üyelik tamamlandý: "+user.getFirsName()+" "+user.getLastName());
			userDao.addUser(user);

		}
	
	@Override
	public void login(String email,String password) {
	
		if(userDao.getUsers()!=null) {
		List<User> users=userDao.getUsers();
		for(User user:users) {
			if(user.getEmail()==email && user.getPassword()==password) {
				System.out.println("Sisteme giriþ yapýldý.");
				return;
			}
		}
			System.out.println("Kullanýcý bulunamadý.E-posta veya þifre hatalý.");

		}
		
		/*else {
		System.out.println("Kullanýcý bulunamadý.E-posta veya þifre hatalý.");
	
		}*/
	}

}
