package com.example.patientapplication.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.patientapplication.MainActivity;
import com.example.patientapplication.R;
import com.example.patientapplication.model.Account;
import com.example.patientapplication.services.AccountService;
import com.example.patientapplication.utils.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtPhoneNumber, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize EditText and Button
        edtPhoneNumber = findViewById(R.id.edtPhonenumber);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Set onClickListener for the login button
        btnLogin.setOnClickListener(v -> {
            // Get the phone number and password from EditText fields
            String phoneNumber = edtPhoneNumber.getText().toString();
            String password = edtPassword.getText().toString();

            // Validate if phone number and password are not empty
            if (phoneNumber.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter phone number and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create an Account object with the provided phone number and password
            Account account = new Account(phoneNumber, password, true);

            // Perform login
            login(account);
        });
    }

    private void login(Account account) {
        AccountService accountService = API.getAccountService();
        Call<Account> call = accountService.Login(account);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login failed: " + response.message(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    Log.e("ERROR: ", e.getMessage());
                    Toast.makeText(LoginActivity.this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(LoginActivity.this, "Login failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
