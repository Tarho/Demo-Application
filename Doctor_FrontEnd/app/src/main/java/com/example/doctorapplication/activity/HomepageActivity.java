package com.example.doctorapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.doctorapplication.R;

public class HomepageActivity extends AppCompatActivity {

    LinearLayout firstlayoutrow, secondlayoutrow, firstlayoutsecondrow,
            secondlayoutsecondrow, firstlayoutthirdrow, secondlayouthirdtrow;
    ImageButton imageButtonPersonalInformation, imageAppointment,
            imageButtonPatientInformation, imagePatientHealthRecord,
            imageButtonPatientPrescriptionInformation, imageManageTherapeutic;
    Button ButtonPersonalInformation, ButtonAppointment,
            ButtonPatientInformation, PatientHealthRecord,
            ButtonPatientPrescriptionInformation, ButtonManageTherapeutic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //LinearLayout
        firstlayoutrow = (LinearLayout) findViewById(R.id.firstlayoutrow);
        secondlayoutrow = (LinearLayout) findViewById(R.id.secondlayoutrow);
        firstlayoutsecondrow = (LinearLayout) findViewById(R.id.firstlayoutsecondrow);
        secondlayoutsecondrow = (LinearLayout) findViewById(R.id.secondlayoutsecondrow);
        firstlayoutthirdrow = (LinearLayout) findViewById(R.id.firstlayoutthirdrow);
        secondlayouthirdtrow = (LinearLayout) findViewById(R.id.secondlayouthirdtrow);

        //ImageButton
        imageButtonPersonalInformation = (ImageButton) findViewById(R.id.imageButtonPersonalInformation);
        imageAppointment = (ImageButton) findViewById(R.id.imageAppointment);
        imageButtonPatientInformation = (ImageButton) findViewById(R.id.imageButtonPatientInformation);
        imagePatientHealthRecord = (ImageButton) findViewById(R.id.imagePatientHealthRecord);
        imageButtonPatientPrescriptionInformation = (ImageButton) findViewById(R.id.imageButtonPatientPrescriptionInformation);
        imageManageTherapeutic = (ImageButton) findViewById(R.id.imageManageTherapeutic);

        //Button
        ButtonPersonalInformation = (Button)findViewById(R.id.ButtonPersonalInformation);
        ButtonAppointment = (Button)findViewById(R.id.ButtonAppointment);
        ButtonPatientInformation = (Button)findViewById(R.id.ButtonPatientInformation);
        PatientHealthRecord = (Button)findViewById(R.id.PatientHealthRecord);
        ButtonPatientPrescriptionInformation = (Button)findViewById(R.id.ButtonPatientPrescriptionInformation);
        ButtonManageTherapeutic = (Button)findViewById(R.id.ButtonManageTherapeutic);

        //Intent manage patient
        firstlayoutrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, DoctorManagePatientList.class);
                startActivity(intent);
            }
        });
        imageButtonPatientInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, DoctorManagePatientList.class);
                startActivity(intent);
            }
        });
        ButtonPatientInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, DoctorManagePatientList.class);
                startActivity(intent);
            }
        });
    }
}