package com.smart.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.contracts.contract.Contract;
import com.smart.contracts.contract.ContractService;

/**
 * Handles requests for the application home page.
 */
@Controller("/contracts")
public class SmartContractsContoller {	
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(path="/create", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int createContract(@RequestBody Contract contract){
		Contract createdContract  = contractService.createContract(contract);
		return createdContract.getContractId();
	}
	
	@RequestMapping(path="/execute", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String executedContract(@RequestBody int contractId){
		return "Your Contract is executed successfully";
	}
	
	@RequestMapping(path="/execute", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String cancelContract(@RequestBody int contractId){
		
		return "Your Contract is executed successfully";
	}
	
}
