/**
 * 
 */
package com.smart.contracts.account;

/**
 * @author Dhawal Patel
 *
 */
public class Account {

	private double amount;
	
	private String accountHolderName;
	
	private String accountHolderIdentity;

	public Account(){}
	
	public Account(double amount, String accountHolderName, String accountHolderIdentity) {
		super();
		this.amount = amount;
		this.accountHolderName = accountHolderName;
		this.accountHolderIdentity = accountHolderIdentity;
	}

	public double getAmount() {
		return amount;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountHolderIdentity() {
		return accountHolderIdentity;
	}
	
	
}
