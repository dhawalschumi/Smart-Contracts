/**
 * 
 */
package com.smart.contracts.contract;

import java.util.Date;

import com.smart.contracts.agent.Agent;
import com.smart.contracts.buyer.Buyer;
import com.smart.contracts.seller.Seller;

/**
 * @author Dhawal Patel
 *
 */
public class Contract{
	
	private Buyer buyer;
	
	private Seller seller;
	
	private Agent agent;
	
	private double transactionFee;
	
	private Date maxDurationToCompleteTransaction;
	
	private int contractId;
	
	private String contractStatus;

	public Contract(){}
	
	public Contract(Buyer buyer, Seller seller, Agent agent, double transactionFee,
			Date maxDurationToCompleteTransaction,int contractId) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.agent = agent;
		this.transactionFee = transactionFee;
		this.maxDurationToCompleteTransaction = maxDurationToCompleteTransaction;
		this.contractId=contractId;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public Agent getAgent() {
		return agent;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public Date getMaxDurationToCompleteTransaction() {
		return maxDurationToCompleteTransaction;
	}

	public int getContractId() {
		return contractId;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
}
