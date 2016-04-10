/**
 * 
 */
package com.smart.contracts.broadcasting.service.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.contracts.account.service.AccountService;
import com.smart.contracts.broadcasting.service.BlockChainBroadCastService;
import com.smart.contracts.contract.Contract;
import com.smart.contracts.contract.ContractService;
import com.smart.contracts.notification.Notification;

/**
 * @author Dhawal Patel
 *
 */
@Service
public class BlockChainBroadCastServiceImpl implements BlockChainBroadCastService{
	
	private static LinkedList<Contract> contractBlockChain = new LinkedList<>();
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ContractService contractService;

	@Override
	public Notification sendExecuteContractToBlockChain(Contract contract) {
		boolean isContractToBeExecuted = false;
		for(Contract contactToBeValidated : contractBlockChain){
			boolean validChain = contractService.validateContract(contactToBeValidated);
			if(!validChain){
				isContractToBeExecuted = false;
				break;
			}
		}
		if(isContractToBeExecuted){
			accountService.transact(contract);
			return new Notification(true, false);
		}
		return new Notification(false, false);
	}

	@Override
	public Notification sendCancelContractToBlockChain(Contract contract) {
		for(Contract contactToBeValidated : contractBlockChain){
			if(contract.getContractId() == contactToBeValidated.getContractId()){
				contract.setContractStatus("TO-BE-CANCELLED");
				break;
			}
		}
		return new Notification(true, false);
	}

	@Override
	public Notification sendCreateContractToBlockChain(Contract contract) {
		contractBlockChain.add(contract);
		return new Notification(true, false);
	}

}
