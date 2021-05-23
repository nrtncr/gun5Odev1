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
		//AD SOYAD KONTROL�
				String firstName=user.getFirsName();
				char[] cFirstName=firstName.toCharArray();
				
				String lastName=user.getLastName();
				char[] cLastName=lastName.toCharArray();
				
				if(cFirstName.length<2 || cLastName.length<2) {
					System.out.println("�yelik ger�ekle�tirilemedi.Ad ve soyad en az 2 karakterden olu�mal�d�r.");
					return;
				}		
				
				
		
		//E-POSTA FORMAT KONTROL�
		String regex="^(.+)@hotmail.com";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(user.getEmail());
		if(!matcher.matches()) {
			System.out.println("�yelik ger�ekle�tirilemedi.L�tfen ge�erli bir e-posta adresi giriniz.");
			return;
		}

		if(userDao.getUsers()!=null) {
		List<User> users=userDao.getUsers();
		
		
		//E-POSTA KULLANILIYOR MU?
		
		for(User USER:users) {
			if(USER.getEmail()==user.getEmail() ) {
				System.out.println("�yelik ger�ekle�tirilemedi.Bu e-posta adresine sahip bir kullan�c� zaten var.");
				return;
			}
		
		}
		
	}
		//��FRE KONTROL�
		
		String password=user.getPassword();
		char[] cPassword=password.toCharArray();
		if(cPassword.length<6) {
			System.out.println("�yelik ger�ekle�tirilemedi.�ifre en az 6 karakterden olu�mal�d�r.");
			return;
		}	
		
		System.out.println("E-mail adresinize do�rulama e-postas� g�nderildi.�yeli�inizin tamamlanabilmesi i�in l�tfen do�rulama linkine t�klay�n�z.");
	}
	
	 public void link(User user) {
			System.out.println("�yelik tamamland�: "+user.getFirsName()+" "+user.getLastName());
			userDao.addUser(user);

		}
	
	@Override
	public void login(String email,String password) {
	
		if(userDao.getUsers()!=null) {
		List<User> users=userDao.getUsers();
		for(User user:users) {
			if(user.getEmail()==email && user.getPassword()==password) {
				System.out.println("Sisteme giri� yap�ld�.");
				return;
			}
		}
			System.out.println("Kullan�c� bulunamad�.E-posta veya �ifre hatal�.");

		}
		
		/*else {
		System.out.println("Kullan�c� bulunamad�.E-posta veya �ifre hatal�.");
	
		}*/
	}

}
