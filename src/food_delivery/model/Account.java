package food_delivery.model;

import food_delivery.enums.AccountRole;

public class Account {
	private Long accountId;
	private String email;
	private String password;
	private AccountRole role;
	private int associatedId;
	public Account(Long accountId, String email, String password, AccountRole role, int associatedId) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.role = role;
		this.associatedId = associatedId;
	}
	public Long getAccountId() {
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
	public int getAssociatedId() {
		return associatedId;
	}
	

}
