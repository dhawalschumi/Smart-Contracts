package com.smart.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(path="/create",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int createContract(@RequestBody Contract contract){
		Contract createdContract  = contractService.createContract(contract);
		return createdContract.getContractId();
	}
	
	@RequestMapping(path="/execute", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String executedContract(@RequestBody Contract contract){
		return "Your Contract is executed successfully";
	}
	
	@RequestMapping(path="/cancel", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String cancelContract(@RequestBody int contractId){		
		return "Your Contract is executed successfully";
	}
	
}
