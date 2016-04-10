/**
 * 
 */
package com.smart.contracts.contract;

/**
 * @author Dhawal Patel
 *
 */
public interface ContractService{
	
	public Contract createContract(Contract contract);
	
	public double executeContract(Contract contract);
	
	public boolean validateContract(Contract contract);
	
	public boolean cancelContract(Contract contract);
	
	public Contract findContract(int contractId);

}
