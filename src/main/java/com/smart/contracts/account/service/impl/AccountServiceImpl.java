/**
 * 
 */
package com.smart.contracts.account.service.impl;

import org.springframework.stereotype.Service;

import com.smart.contracts.account.Account;
import com.smart.contracts.account.service.AccountService;
import com.smart.contracts.contract.Contract;

/**
 * @author Dhawal Patel
 *
 */
@Service
public class AccountServiceImpl implements AccountService{

	/*
	 * (non-Javadoc)
	 * @see com.smart.contracts.account.service.AccountService#transact(com.smart.contracts.contract.Contract)
	 * 
	 * Process Actual Transaction here..
	 */
	@Override
	public double transact(Contract contract) {
		Account sellerAccount = contract.getSeller().getAccount();
		Account agentCount = contract.getAgent().getAccount();		
		sellerAccount.setAmount(sellerAccount.getAmount() + contract.getBuyer().getAmountToTransact());
		agentCount.setAmount(contract.getTransactionFee());
		return contract.getTransactionFee();
	}

}
