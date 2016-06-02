package com.demo.activity;

import com.demo.MainActivity;
import com.demo.R;
import com.demo.common.Configure;
import com.demo.presenter.LoginPresenter;
import com.demo.utils.SharedPreferenceUtil;
import com.demo.utils.ToastUtil;
import com.demo.view.LoginView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener, LoginView {
	private EditText et_name;
	private EditText et_password;
	private Button btn_login;
	private LoginPresenter loginPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initViews();
		loginPresenter = new LoginPresenter(this);
	}

	private void initViews() {
		et_name = (EditText) findViewById(R.id.et_name);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_login:
			boolean result = loginPresenter.login();
			if (result) {
				SharedPreferenceUtil.put(this, Configure.STAFF_ID, getName());
				SharedPreferenceUtil.put(this, Configure.PASSWORD, getPassword());
			}
			break;
		default:
			break;

		}
	}

	@Override
	public void moveToIndex() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return et_name.getText().toString().trim();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return et_password.getText().toString().trim();
	}

	@Override
	public void toast(String msg) {
		// TODO Auto-generated method stub
		ToastUtil.showShort(this, msg);
	}
}
