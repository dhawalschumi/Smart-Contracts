/**
 * 
 */
package com.smart.contracts.contract;

import com.smart.contracts.account.Account;

/**
 * @author Dhawal Patel
 *
 */
public abstract class AbstractContractService implements ContractService{
	
	protected boolean isContractAmountProvided(Account account){
		return true;
	}

}
