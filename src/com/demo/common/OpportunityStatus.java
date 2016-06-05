package com.demo.common;

import android.graphics.Color;

public enum OpportunityStatus {
	// 1:初步洽谈；2：需求确定；3：方案报价；4：谈判合同；5：赢单；6：输单
	error, // 出错了
	discussion, // 初步洽谈
	definition, // 需求确定
	price, // 方案报价
	contract, // 谈判合同
	win, // 赢单
	lose;// 输单
	/**
	 * 根据下标得到对应的状态
	 * 
	 * @param index
	 * @return
	 */
	public static OpportunityStatus getOpportunityStatus(int index) {
		switch (index) {
		case 1:
			return discussion;
		case 2:
			return definition;
		case 3:
			return price;
		case 4:
			return contract;
		case 5:
			return win;
		case 6:
			return lose;
		default:
			return error;
		}
	}

	public static int getIndex(CustomerStatus status) {
		return status.ordinal();
	}

	public static int getIndexByContent(String value) {
		switch (value) {
		case "初步洽谈":
			return 1;
		case "需求确定":
			return 2;
		case "方案报价":
			return 3;
		case "谈判合同":
			return 4;
		case "赢单":
			return 5;
		case "输单":
			return 6;
		default:
			return 0;
		}
	}

	public static String toString(OpportunityStatus status) {
		switch (status) {
		case discussion:
			return "初步洽谈";
		case definition:
			return "需求确定";
		case price:
			return "方案报价";
		case contract:
			return "谈判合同";
		case win:
			return " 赢 　单 ";
		case lose:
			return " 输 　单 ";
		default:
			return "error";
		}
	}

	public static int getColor(OpportunityStatus status) {

		switch (status) {
		case discussion:
			return Color.parseColor(ColorList.lightblue);
		case definition:
			return Color.parseColor(ColorList.darkblue);
		case price:
			return Color.parseColor(ColorList.purple);
		case contract:
			return Color.parseColor(ColorList.yellow);
		case win:
			return Color.parseColor(ColorList.red);
		case lose:
			return Color.parseColor(ColorList.gray);
		default:
			return Color.parseColor(ColorList.black);
		}
	}

}
