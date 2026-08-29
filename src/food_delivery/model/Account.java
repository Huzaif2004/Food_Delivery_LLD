package food_delivery.model;

import java.util.UUID;

import food_delivery.enums.AccountRole;

public class Account {
	private String accountId;
	private String email;
	private String password;
	private AccountRole role;
	private String associatedId;
	public Account(String email, String password, AccountRole role, String associatedId) {
		super();
		this.accountId = UUID.randomUUID().toString();
		this.email = email;
		this.password = password;
		this.role = role;
		this.associatedId = associatedId;
	}
	public String getAccountId() {
		return accountId;
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
