package food_delivery.service;

import food_delivery.dto.LoginResult;

public interface AuthService {
	LoginResult login(String email,String password);

}
