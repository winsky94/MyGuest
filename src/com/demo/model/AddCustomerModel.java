package com.demo.model;

import com.demo.domain.Customer;

import android.content.Context;

public interface AddCustomerModel {
	public boolean add(Context context, Customer customer);

	public boolean delete(Context context, Customer customer);

	public boolean update(Context context, Customer customer);

	public Customer getById(Context context, int id);

}
