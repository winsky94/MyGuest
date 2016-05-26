package com.demo.view;

import com.demo.domain.Customer;

public interface AddCustomerView {
	public void moveToCustomer();

	public Customer getCustomer();

	public void toast(String message);

}
