/**
 * 
 */
package com.smart.contracts.transaction;

import java.util.Date;

import com.smart.contracts.agent.Agent;
import com.smart.contracts.buyer.Buyer;
import com.smart.contracts.seller.Seller;

/**
 * @author Dhawal Patel
 *
 */
public class Transaction {
	
	private Buyer buyer;
	
	private Seller seller;
	
	private Agent agent;
	
	private double transactionFee;
	
	private Date maxDurationToCompleteTransaction;
	
	public Transaction(Buyer buyer, Seller seller, Agent agent, double transactionFee,
			Date maxDurationToCompleteTransaction) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.agent = agent;
		this.transactionFee = transactionFee;
		this.maxDurationToCompleteTransaction = maxDurationToCompleteTransaction;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public Date getMaxDurationToCompleteTransaction() {
		return maxDurationToCompleteTransaction;
	}

	public Agent getAgent() {
		return agent;
	}
}
