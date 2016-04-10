/**
 * 
 */
package com.smart.contracts.offer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.contracts.broadcasting.service.BlockChainBroadCastService;
import com.smart.contracts.contract.Contract;
import com.smart.contracts.notification.Notification;
import com.smart.contracts.offer.service.OfferService;

/**
 * @author Dhawal Patel
 *
 */
@Service
public class OfferServiceImpl implements OfferService{

	@Autowired
	private BlockChainBroadCastService broadcastService;
	
	@Override
	public boolean makeOffer(Contract contract) {
		Notification notification = broadcastService.sendCreateContractToBlockChain(contract);
		return notification.isAccepted();
	}

}
