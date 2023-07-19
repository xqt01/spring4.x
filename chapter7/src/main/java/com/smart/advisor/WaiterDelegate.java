package com.smart.advisor;

public class WaiterDelegate {

	private Waiter waiter;

	/**
	 * 切点方法
	 */
	public void service(String clientName) {
		waiter.greetTo(clientName);
		waiter.serveTo(clientName);
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
}
