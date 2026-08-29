package food_delivery.dto;

import food_delivery.enums.AccountRole;

public class AccountCreationRequest {
	private final String email;
	private final String password;
	private final AccountRole role;
	private final String associatedId;
	public AccountCreationRequest(String email, String password, AccountRole role, String associatedId) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.associatedId = associatedId;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public AccountRole getRole() {
		return role;
	}
	public String getAssociatedId() {
		return associatedId;
	}
	

}
