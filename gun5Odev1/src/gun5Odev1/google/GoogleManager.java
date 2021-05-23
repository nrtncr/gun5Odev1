package gun5Odev1.google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleManager {
	
	public void googleAccount(String gmail,String password) {
	
	String regex="^(.+)@gmail.com";
	Pattern pattern=Pattern.compile(regex);
	Matcher matcher=pattern.matcher(gmail);
	if(matcher.matches()) {
		System.out.println("Google hesabý ile giriþ yapýldý.");
	}
	else {
		System.out.println("Google hesabý ile giriþ yapýlamadý.");
	}
	}
	
}
