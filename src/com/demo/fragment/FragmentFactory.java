package com.demo.fragment;

import com.demo.fragment.business.BusinessFragment;
import com.demo.fragment.customer.CustomerFragment;
import com.demo.fragment.work.WorkFragment;

import android.app.Fragment;

public class FragmentFactory {
	public static Fragment getInstanceByIndex(int index) {
		Fragment fragment = null;
		switch (index) {
		case 1:
			fragment = new BusinessFragment();
			break;
		case 2:
			fragment = new CustomerFragment();
			break;
		case 3:
			fragment = new WorkFragment();
			break;
		}
		return fragment;
	}
}
