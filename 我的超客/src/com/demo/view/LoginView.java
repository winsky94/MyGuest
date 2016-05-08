package com.demo.view;

/**
 * Description: 登录View
 */
public interface LoginView {

	// 登录成功后跳转到首页
	public void moveToIndex();

	// 获取界面的姓名
	public String getName();

	// 获取界面的密码
	public String getPassword();

	public void toast(String msg);
}
