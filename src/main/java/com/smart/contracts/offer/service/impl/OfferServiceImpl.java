/**
 * 
 */
package com.smart.contracts.offer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.contracts.broadcasting.service.EthereumBroadCastService;
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
	private EthereumBroadCastService broadcastService;
	
	@Override
	public boolean makeOffer(Contract contract) {
		Notification notification = broadcastService.broadcastMessage(contract);
		return notification.isAccepted();
	}

}
