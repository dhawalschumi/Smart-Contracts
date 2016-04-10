/**
 * 
 */
package com.smart.contracts.broadcasting.service;

import com.smart.contracts.contract.Contract;
import com.smart.contracts.notification.Notification;

/**
 * @author Dhawal Patel
 *
 */
public interface BlockChainBroadCastService {

	public Notification sendExecuteContractToBlockChain(Contract contract);
	
	public Notification sendCancelContractToBlockChain(Contract contract);
	
	public Notification sendCreateContractToBlockChain(Contract contract);
	
}
