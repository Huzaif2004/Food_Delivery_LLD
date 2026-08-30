package food_delivery.dto;

import food_delivery.enums.AccountRole;

public class LoginResult {
	private String accountId;
	private String email;
	private AccountRole role;
	private String associatedId;
	public LoginResult(String accountId, String email, AccountRole role, String associatedId) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.role = role;
		this.associatedId = associatedId;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getEmail() {
		return email;
	}
	public AccountRole getRole() {
		return role;
	}
	public String getAssociatedId() {
		return associatedId;
	}
	
	

}
