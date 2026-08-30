package food_delivery.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
	private PasswordEncoder passwordEncoder;
	
	public PasswordUtil(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	public String hashPassword(String password) {
		return passwordEncoder.encode(password);
		
	}
	public boolean verifyPassword(String password,String hash) {
		return passwordEncoder.matches(password, hash);
	}

}
