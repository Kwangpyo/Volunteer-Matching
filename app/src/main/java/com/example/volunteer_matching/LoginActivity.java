package com.example.volunteer_matching;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText idInput, passwordInput;
    Button btn_signup,btn_login;
    CheckBox autoLogin;
    Boolean loginChecked=false;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        autoLogin = (CheckBox) findViewById(R.id.checkBox);
        pref = getSharedPreferences("pref_loginInfo", MODE_PRIVATE);
        editor = pref.edit();

        btn_signup = (Button) findViewById(R.id.signupButton);
        btn_login = (Button) findViewById(R.id.loginButton);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignup = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(toSignup);
                finish();
            }
        });

        if (pref.getBoolean("autoLogin", false)) {//자동로그인으로 로그인 정보 저장되어있는 경우
            idInput.setText(pref.getString("id", ""));
            passwordInput.setText(pref.getString("pw", ""));
            Intent toSelectUser = new Intent(LoginActivity.this, SelectUserActivity.class);
            autoLogin.setChecked(true);
            startActivity(toSelectUser);
            finish();
        } else {//자동로그인 정보가 없는 경우
            btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if autoLogin unChecked
                String id = idInput.getText().toString();
                String password = passwordInput.getText().toString();
                Boolean validation = loginValidation(id, password);

                if (validation) {
                    Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();
                    Intent toSelectUser = new Intent(LoginActivity.this, SelectUserActivity.class);
                    startActivity(toSelectUser);
                    finish();
                    // save id, password to Database

                    if (loginChecked) {
                        // if autoLogin Checked, save values
                        editor.putString("id", id);
                        editor.putString("pw", password);
                        editor.putBoolean("autoLogin", true);
                        editor.commit();
                    }
                    // goto mainActivity

                } else {
                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_LONG).show();
                    // goto LoginActivity
                 }
                }
            });
        }

        // set checkBoxListener
        autoLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loginChecked = true;
                } else {
                    // if unChecked, removeAll
                    loginChecked = false;
                    editor.clear();
                    editor.commit();
                }
            }
        });
    }

    private boolean loginValidation(String id, String password) {
        if(id.equals(null)){
            Toast.makeText(LoginActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(password.equals(null)){
            Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
            return false;
        }
        if(pref.getString("id","").equals(id) && pref.getString("pw","").equals(password)) {//여기서 db뒤져서 맞는지 확인해야함 Pref대신 쿼리 날려서
            // login success
            return true;
        } else if (pref.getString("id","").equals(null)){
            // sign in first
            Toast.makeText(LoginActivity.this, "Please Sign in first", Toast.LENGTH_LONG).show();
            return false;
        } else {
            // login failed
            return false;
        }
    }

}
