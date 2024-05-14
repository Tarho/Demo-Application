package com.example.doctorapplication.services;


import com.example.doctorapplication.model.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PatientService {
    //List of patient
    @GET("doctor/patients")
    Call<List<Patient>> getPatients();


    //Patient detail (Information)
    @GET("doctor/patient/{PatientID}")
    Call<Patient> getPatientByID(@Path("PatientID") int patientId);
}
