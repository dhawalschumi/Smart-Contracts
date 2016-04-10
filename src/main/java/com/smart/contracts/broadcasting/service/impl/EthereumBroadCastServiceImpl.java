/**
 * 
 */
package com.smart.contracts.broadcasting.service.impl;

import org.springframework.stereotype.Service;

import com.smart.contracts.broadcasting.service.EthereumBroadCastService;
import com.smart.contracts.contract.Contract;
import com.smart.contracts.notification.Notification;

/**
 * @author Dhawal Patel
 *
 */
@Service
public class EthereumBroadCastServiceImpl implements EthereumBroadCastService{

	@Override
	public Notification broadcastMessage(Contract contract) {
		return new Notification(true, false);
	}

	@Override
	public Notification sendExecuteContractToEthereum(Contract contract) {
		return new Notification(true, false);
	}

	@Override
	public Notification sendCancelContractToEthereum(Contract contract) {
		return new Notification(true, false);
	}

	@Override
	public Notification sendCreateContractToEthereum(Contract contract) {
		return new Notification(true, false);
	}

}
