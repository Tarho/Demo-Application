package com.example.doctorapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Patient {
    @SerializedName("PatientID")
    @Expose
    private int PatientID;
    @SerializedName("PatientName")
    @Expose
    private String PatientName;
    @SerializedName("Phone")
    @Expose
    private String Phone;
    @SerializedName("Email")
    @Expose
    private String Email;
    @SerializedName("Address")
    @Expose
    private String Address;
    @SerializedName("Gender")
    @Expose
    private String Gender;
    @SerializedName("DateOfBirth")
    @Expose
    private String DateOfBirth;
    @SerializedName("CitizenIdentification")
    @Expose
    private String CitizenIdentification;

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCitizenIdentification() {
        return CitizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
        CitizenIdentification = citizenIdentification;
    }

    public Patient(int patientID, String patientName, String phone, String email, String address, String gender, String dateOfBirth, String citizenIdentification) {
        PatientID = patientID;
        PatientName = patientName;
        Phone = phone;
        Email = email;
        Address = address;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        CitizenIdentification = citizenIdentification;
    }
}
