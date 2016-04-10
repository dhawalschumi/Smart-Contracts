/**
 * 
 */
package com.smart.contracts.agent;

import com.smart.contracts.account.Account;
import com.smart.contracts.signature.AbstractValidateSignature;

/**
 * @author Dhawal Patel
 *
 */
public class Agent extends AbstractValidateSignature{

	private double escrowAmount;
	
	private String escrowEmail;
	
	private Account account;

	public Agent(double escrowAmount, String escrowEmail,Account account) {
		super();
		this.escrowAmount = escrowAmount;
		this.escrowEmail = escrowEmail;
		this.account=account;
	}
	
	public double getEscrowAmount() {
		return escrowAmount;
	}

	public String getEscrowEmail() {
		return escrowEmail;
	}

	public Account getAccount() {
		return account;
	}	
}
