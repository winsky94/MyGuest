package com.demo.model;

import com.demo.listener.OnLoginListener;

/**
 * Description: 登录接口
 */
public interface LoginModel {

	public boolean login(String name, String password, OnLoginListener onLoginListener);
}
