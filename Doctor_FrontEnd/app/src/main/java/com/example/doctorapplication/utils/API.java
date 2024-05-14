package com.example.doctorapplication.utils;

import com.example.doctorapplication.apiClient.RetrofitClient;
import com.example.doctorapplication.services.AccountService;
import com.example.doctorapplication.services.PatientService;

public class API {
    private API(){};

    public static final String API_URL = "http://192.168.1.12:8080/api/";

    public static PatientService getPatientService(){
       return RetrofitClient.getClient(API_URL).create(PatientService.class);
    }

    public static AccountService getAccountService()
    {
        return RetrofitClient.getClient(API_URL).create(AccountService.class);
    }
}
