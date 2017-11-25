package com.padcmyanmar.helloandroidpadc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL = "abc@gmail.com";//Constant A
    private static final String CORRECT_PASSWORD = "Abcdefgh";//Constant Attribute

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassword;
    private TextView btnNewSellerOrRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forget_password);
        btnNewSellerOrRegister = findViewById(R.id.btn_new_seller_or_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();
                //if (TextUtils.isEmpty(emailOrPhone)) {
                if (TextUtils.isEmpty(emailOrPhone)) {
                    etEmailOrPhone.setError("Email or Phone cannot be empty");
                    Log.d("Valid_EmailOrPh_Empty", "Email Or Phone is Empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Password cannot be empty");
                    Log.d("Valid_Password_Empty", "Password is Empty");
                    return;
                }
                if (TextUtils.equals(emailOrPhone, CORRECT_EMAIL) && TextUtils.equals(password, CORRECT_PASSWORD)) {
                        Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                        startActivity(intent);
//                    Toast t_message = Toast.makeText(view.getContext(), "Login Success",
//                            Toast.LENGTH_LONG);
//                    t_message.getView().setBackgroundColor(Color.parseColor("#009688"));
//                    t_message.show();

                } else {
                    etEmailOrPhone.setText("");
                    etPassword.setText("");
                    etEmailOrPhone.requestFocus();
                    Snackbar errorSnack = Snackbar.make(view, "Incorrect email or password, Please Try agin.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null);
                    errorSnack.getView().setBackgroundColor(Color.RED);
                    errorSnack.show();

                }

            }
        });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //Intent intent = FullscreenActivity.newIntent(getApplicationContext());
                //startActivity(intent);

                Snackbar.make(view, "\"Forgot Password\" is Coming Soon", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null)
                        .show();
            }
        });

        btnNewSellerOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
//                Snackbar.make(view, "Register Screen is Coming Soon", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null)
//                        .show();
            }
        });
    }

    public static Intent newIntent(Context context) {
        Intent Intent = new Intent(context, LoginActivity.class);
        return Intent;
    }
}
