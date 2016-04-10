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
public interface EthereumBroadCastService {

	public Notification broadcastMessage(Contract contract);
	
	public Notification sendExecuteContractToEthereum(Contract contract);
	
	public Notification sendCancelContractToEthereum(Contract contract);
	
	public Notification sendCreateContractToEthereum(Contract contract);
	
}
