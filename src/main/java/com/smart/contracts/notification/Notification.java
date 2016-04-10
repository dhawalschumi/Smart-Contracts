/**
 * 
 */
package com.smart.contracts.notification;

/**
 * @author Dhawal Patel
 *
 */
public class Notification {

	private boolean accepted;
	
	private boolean pending;

	public Notification(boolean accepted, boolean pending) {
		super();
		this.accepted = accepted;
		this.pending = pending;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public boolean isPending() {
		return pending;
	}
	
	
	
}
