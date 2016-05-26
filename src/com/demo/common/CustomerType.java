package com.demo.common;

public enum CustomerType {
	error, // 错误，只是为了占用下标0的位置
	important, // 重要客户
	normal, // 一般客户
	unImportant;// 低价值客户

	/**
	 * 根据下标得到类型
	 * 
	 * @param index下标
	 * @return
	 */
	public static CustomerType getCustomerType(int index) {
		switch (index) {
		case 1:
			return CustomerType.important;
		case 2:
			return CustomerType.normal;
		case 3:
			return CustomerType.unImportant;
		default:
			return CustomerType.error;
		}
	}

	/**
	 * 根据类型得到下标
	 * 
	 * @param customerType枚举类型
	 * @return
	 */
	public static int getIndex(CustomerType customerType) {
		return customerType.ordinal();
	}

	public static int getIndexByContent(String value) {
		switch (value) {
		case "重要客户":
			return 1;
		case "一般客户":
			return 2;
		case "低价值客户":
			return 3;
		default:
			return 0;
		}
	}
}
