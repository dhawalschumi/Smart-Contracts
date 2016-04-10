/**
 * 
 */
package com.smart.contracts.contract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.contracts.broadcasting.service.EthereumBroadCastService;
import com.smart.contracts.contract.AbstractContractService;
import com.smart.contracts.contract.Contract;
import com.smart.contracts.notification.Notification;

/**
 * @author Dhawal Patel
 *
 */
@Service
public class ContractServiceImpl extends AbstractContractService{
	
	@Autowired
	private EthereumBroadCastService broadCastService;

	/*
	 * (non-Javadoc)
	 * @see com.smart.contracts.contract.ContractService#createContract(com.smart.contracts.contract.Contract)
	 * 
	 * Here we will create a contract which will drive the contract/transaction lifecycle. 
	 * 1. Buyer, Seller, Agent and respective signatures will be parties involved.
	 * 2. Terms and conditions agreed upon will be part of contract and validity will be checked.
	 * 3. Time to complete the execution will also be a factor.
	 * 4. Here we will generate a contract id. 
	 */
	@Override
	public Contract createContract(Contract contract) {		
		Notification creationNotification = null;
		if(validateContract(contract)){
			creationNotification = broadCastService.sendCreateContractToEthereum(contract);
		}
		if(creationNotification.isAccepted()){
			contract.setContractStatus("Successfully Placed");
		}else{
			contract.setContractStatus("Pending");
		}
		return contract;
	}

	/*
	 * (non-Javadoc)
	 * @see com.smart.contracts.contract.ContractService#executeContract(com.smart.contracts.contract.Contract)
	 * 
	 * Here we will only process valid contracts. 
	 * 
	 * 1. Here the buyer wil buy the items at amount agreed on contract with seller.
	 * 2. Actual transaction will take place where buyer will be deposited and seller will be credited and 
	 * 	  agent/escrow will receive the amount agreed.
	 * 3. Transaction Fee will be charged as per agreement in contract.
	 * 4. Once contract is excuted transaction fee will be returned from the method.
	 */
	@Override
	public double executeContract(Contract contract) {
		if(validateContract(contract)){
			Notification executeNotification = broadCastService.sendExecuteContractToEthereum(contract);
			if(executeNotification.isAccepted()){
				return contract.getTransactionFee();
			}else{
				return -1;
			}
		}		
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.smart.contracts.contract.ContractService#validateContract(com.smart.contracts.contract.Contract)
	 * 
	 * 1. The validation of the contract will be the enforcement to check whether the contract is adhered to terms agreed 
	 * by buyer and seller.
	 * 
	 * 2. Here We can check the signatures of the buyer,seller and agent. 
	 * 
	 * 3. Also we need to validate the has parties deposited amount for contract to proceed. 
	 * 
	 * 4. If all the above parameters are valid then its a valid contract, else its invalid and cannot proceed.
	 */
	@Override
	public boolean validateContract(Contract contract) {		
		if(contract.getBuyer().validateSignature() && contract.getSeller().validateSignature() && contract.getAgent().validateSignature()){
			boolean buyerAmountProvided = isContractAmountProvided(contract.getBuyer().getAccount());
			boolean sellerAmountProvided = isContractAmountProvided(contract.getSeller().getAccount());
			boolean agentAmountProvided = isContractAmountProvided(contract.getAgent().getAccount());
			
			if(buyerAmountProvided && sellerAmountProvided && agentAmountProvided){
				return true;
			}
		}else{
			return false;
		}
		return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.smart.contracts.contract.ContractService#cancelContract(com.smart.contracts.contract.Contract)
	 * 
	 * Here in case of any disagreement from any party(buyer/seller/agent) the contract will be cancelled. 
	 */
	@Override
	public boolean cancelContract(Contract contract) {
		if(contract.getBuyer().validateSignature() && contract.getSeller().validateSignature() && contract.getAgent().validateSignature()){
			Notification notification = broadCastService.sendCancelContractToEthereum(contract);
			if(notification.isAccepted()){
				contract.setContractStatus("CANCELLED");
				return true;
			}else{
				contract.setContractStatus("CANCEL-PENDING");
				return false;
			}			
		}
		return false;
	}

	@Override
	public Contract findContract(int contractId) {
		/*
		 * Call Database or get block from ethereum/blockchain.
		 */
		return new Contract();
	}

}
