/**
 * 
 */
package com.smart.contracts.seller;

import com.smart.contracts.account.Account;
import com.smart.contracts.signature.AbstractValidateSignature;

/**
 * @author Dhawal Patel
 *
 */
public class Seller extends AbstractValidateSignature{

	private String sellerName;
	
	private String sellerEmail;
	
	private String sellerSignature;
	
	private double amountToTransact;
	
	private double amountForContract;	
	
	private Account account;
	
	public Seller(){}

	public Seller(String sellerName, double amountToTransact, double amountForContract,String sellerSignature,String sellerEmail,Account account) {
		super();
		this.sellerName = sellerName;
		this.amountToTransact = amountToTransact;
		this.amountForContract = amountForContract;
		this.sellerEmail=sellerEmail;
		this.sellerSignature=sellerSignature;
		this.account=account;
	}

	public String getSellerName() {
		return sellerName;
	}

	public double getAmountToTransact() {
		return amountToTransact;
	}

	public double getAmountForContract() {
		return amountForContract;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getSellerSignature() {
		return sellerSignature;
	}

	public Account getAccount() {
		return account;
	}	
}
