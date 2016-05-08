package com.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	private EditText et_username = null;
	private EditText et_password = null;
	private CheckBox cb_remeber_password = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		this.et_username = (EditText) this.findViewById(R.id.et_username);
//		this.et_password = (EditText) this.findViewById(R.id.et_password);
//		this.cb_remeber_password = (CheckBox) this.findViewById(R.id.cb_remember_psw);
//		HashMap<String, String> info = LoginService.getInfo(this);
//		if (info != null) {
//			this.et_username.setText(info.get("username"));
//			this.et_password.setText(info.get("password"));
//		}
	}

	// public void login(View view) {
	// String username = this.et_username.getText().toString().trim();
	// String password = this.et_password.getText().toString().trim();
	// if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
	// Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
	// } else {
	// if (this.cb_remeber_password.isChecked()) {
	// boolean result = LoginService.saveInfo(this, username, password);
	// if (result) {
	// Toast.makeText(this, "保存密码成功", Toast.LENGTH_SHORT).show();
	// }
	//
	// }
	// if ("weijie".equals(username) && "123".equals(password)) {
	// Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
	// } else {
	// Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
	//
	// }
	// }
	// }
}
