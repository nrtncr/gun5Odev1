package gun5Odev1.core;

import gun5Odev1.google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService {

	@Override
	public void loginWithGoogleAccount(String gmail,String password) {
		GoogleManager googleManager=new GoogleManager();
		googleManager.googleAccount(gmail,password);
	}

}
