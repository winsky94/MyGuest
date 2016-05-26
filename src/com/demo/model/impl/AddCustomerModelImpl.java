package com.demo.model.impl;

import com.demo.domain.Customer;
import com.demo.model.AddCustomerModel;

import android.content.Context;

public class AddCustomerModelImpl implements AddCustomerModel {

	@Override
	public boolean add(final Context context, Customer customer) {
		// TODO Auto-generated method stub
		if (customer == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Context context, Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Context context, Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getById(Context context, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean success() {
		return true;
	}

	public boolean failure() {
		return false;
	}
}
