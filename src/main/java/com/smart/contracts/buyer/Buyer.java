/**
 * 
 */
package com.smart.contracts.buyer;

import com.smart.contracts.account.Account;
import com.smart.contracts.signature.AbstractValidateSignature;

/**
 * @author Dhawal Patel
 *
 */
public class Buyer extends AbstractValidateSignature{
	
	private String buyerName;
	
	private double amountToTransact;
	
	private double amountForContract;
	
	private String buyerEmail;

	private Account account;
	
	private String buyerSignature; 
	
	public Buyer(){}
	
	public Buyer(String buyerName, double amountToTransact, double amountForContract, String sellerEmail,Account account,
			String buyerSignature) {
		super();
		this.buyerName = buyerName;
		this.amountToTransact = amountToTransact;
		this.amountForContract = amountForContract;
		this.buyerEmail=sellerEmail;
		this.account=account;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public double getAmountToTransact() {
		return amountToTransact;
	}

	public double getAmountForContract() {
		return amountForContract;
	}

	public String getSellerEmail() {
		return buyerEmail;
	}

	public Account getAccount() {
		return account;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public String getBuyerSignature() {
		return buyerSignature;
	}
}
