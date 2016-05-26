package com.demo.presenter;

import com.demo.listener.OnLoginListener;
import com.demo.model.LoginModel;
import com.demo.model.impl.LoginModelImpl;
import com.demo.view.LoginView;

public class LoginPresenter implements OnLoginListener {

	private LoginModel loginModel;
	private LoginView loginView;

	public LoginPresenter(LoginView loginView) {
		this.loginView = loginView;
		loginModel = new LoginModelImpl();
	}

	public boolean login() {
		String name = loginView.getName();
		String password = loginView.getPassword();
		return loginModel.login(name, password, this);
	}

	@Override
	public void onUsernameError() {
		// TODO Auto-generated method stub
		loginView.toast("用户名错误");
	}

	@Override
	public void onPasswordError() {
		// TODO Auto-generated method stub
		loginView.toast("密码错误");
	}

	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub
		loginView.moveToIndex();
	}

	@Override
	public void onFailure() {
		// TODO Auto-generated method stub
		loginView.toast("请求失败");
	}

}
