package com.example.doctorapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctorapplication.R;
import com.example.doctorapplication.model.Patient;
import com.example.doctorapplication.services.PatientService;
import com.example.doctorapplication.utils.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientDetail extends AppCompatActivity {

    TextView PatientName, DateOfBirth, Address, Gender, PhoneNumber;
    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        patientDetail();

        PatientName = (TextView) findViewById(R.id.PatientName);
        DateOfBirth = (TextView) findViewById(R.id.DateOfBirth);
        Address = (TextView) findViewById(R.id.Address);
        Gender = (TextView) findViewById(R.id.Gender);
        PhoneNumber = (TextView) findViewById(R.id.PhoneNumber);
    }

    public void patientDetail() {
        PatientService patientService = API.getPatientService();
        Integer PatientID = getIntent().getIntExtra("PatientID", 1);
        patientService.getPatientByID(PatientID).enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if (response.isSuccessful()) {
                    patient = response.body();
                    if (patient != null) {
                        PatientName.setText(patient.getPatientName());
                        DateOfBirth.setText(patient.getDateOfBirth());
                        Address.setText(patient.getAddress());
                        PhoneNumber.setText(patient.getPhone());
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {

            }
        });
    }
}