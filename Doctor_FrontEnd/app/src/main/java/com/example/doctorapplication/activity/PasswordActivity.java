package com.example.doctorapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctorapplication.MainActivity;
import com.example.doctorapplication.R;
import com.example.doctorapplication.model.Account;
import com.example.doctorapplication.services.AccountService;
import com.example.doctorapplication.utils.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PasswordActivity extends AppCompatActivity {

    EditText edtPassword, edtConfirmPassword;
    Button btnRegister;
    private String receivedPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        receivedPhoneNumber = getIntent().getStringExtra("PHONENUMBER");
        Log.d("PHONENUMBER", receivedPhoneNumber);

        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();

                if (!password.equals(confirmPassword)) {
                    // Passwords don't match
                    Toast.makeText(PasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Account account = new Account(receivedPhoneNumber, password, true);
                account.setPhoneNumber(receivedPhoneNumber);
                account.setPassword(password);
                account.setRole(true);

                register(account);
            }
        });
    }



    private void register(Account account) {
        AccountService accountService = API.getAccountService();
        Call<Account> call = accountService.Register(account);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(PasswordActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    Log.e("ERROR: ", e.getMessage());
                    Toast.makeText(PasswordActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(PasswordActivity.this, "Registration successfully:", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
