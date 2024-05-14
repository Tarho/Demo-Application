package com.example.patientapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patientapplication.R;


public class ValidateOTPActivity extends AppCompatActivity {

    EditText edtValidateOTP;
    Button btnValidateOTP;
    String confirmOTP = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_otpactivity);
        String receivedOTP = getIntent().getStringExtra("OTP");
        String receivedPhoneNumber = getIntent().getStringExtra("PHONENUMBER");
        Log.d("OTP", receivedOTP);
        Log.d("PHONENUMBER", receivedPhoneNumber);

        edtValidateOTP = findViewById(R.id.edtValidateOTP);
        btnValidateOTP  = findViewById(R.id.btnValidateOTP);

        btnValidateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredOTP = edtValidateOTP.getText().toString();
                if (enteredOTP.equals(receivedOTP)) {
                    // Correct OTP
                    Toast.makeText(getApplicationContext(), "Correct OTP", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ValidateOTPActivity.this, PasswordActivity.class);
                    intent.putExtra("PHONENUMBER", receivedPhoneNumber);
                    startActivity(intent);
                } else {
                    // Wrong OTP
                    Toast.makeText(getApplicationContext(), "Wrong OTP, enter again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}