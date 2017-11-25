package com.padcmyanmar.helloandroidpadc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etName;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private RadioGroup radioSex;
    private EditText etAddress;
    private CheckBox cbAddress;

    public static Intent newIntent(Context context) {
        Intent Intent = new Intent(context, RegisterActivity.class);
        return Intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addListenerOnButton();


    }

    private void addListenerOnButton() {
        btnRegister = findViewById(R.id.btn_register);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        radioSex = findViewById(R.id.radioSex);
        etAddress = findViewById(R.id.et_address);
        cbAddress = findViewById(R.id.cb_address);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String confirm_password = etConfirmPassword.getText().toString();
                int rd_sex = radioSex.getCheckedRadioButtonId();
                String address = etAddress.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    etEmail.requestFocus();
                    etEmail.setError("Email cannot be empty");
                    Log.d("Empty_email", "Email is Empty");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    etPhone.requestFocus();
                    etPhone.setError("Phone cannot be empty");
                    Log.d("Empty_phone", "Phone is Empty");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    etName.requestFocus();
                    etName.setError("Name cannot be empty");
                    Log.d("Empty_name", "Name is Empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.requestFocus();
                    etPassword.setError("Password cannot be empty");
                    Log.d("Empty_password", "Password is Empty");
                    return;

                }
                if (TextUtils.isEmpty(confirm_password)) {
                    etConfirmPassword.requestFocus();
                    etConfirmPassword.setError("Confirm Password cannot be empty");
                    Log.d("Empty_confirm_password", "Confirm Password is Empty");
                    return;

                }
                if (!TextUtils.equals(password, confirm_password)) {
                    etPassword.setError("Confirm Password must same with Password");
                    etPassword.requestFocus();
                    etPassword.setText("");
                    etConfirmPassword.setText("");
                    etConfirmPassword.setError("Confirm Password must same with Password");
                    Log.d("Confirm_password", "Confirm Password must same with Password");
                    return;
                }

                if (rd_sex == -1) {
                    Toast t_message = Toast.makeText(v.getContext(), "Radio Box Is Empty",
                            Toast.LENGTH_LONG);
                    t_message.getView().setBackgroundColor(Color.parseColor("#FF9800"));
                    t_message.show();
                    Log.d("Radio_Buton_Empty", "Radio Button is Empty");
                    return;
                }
                if (!cbAddress.isChecked()) {
                    cbAddress.setError("Checkbox cannot be empty");
                    Log.d("Empty_checkbox", "Checkbox is Empty");
                }
                if (TextUtils.isEmpty(address)) {
                    etAddress.requestFocus();
                    etAddress.setError("Address cannot be empty");
                    Log.d("Empty_address", "Address is Empty");
                    return;
                }
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }


}
