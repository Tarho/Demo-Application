package com.example.patientapplication.utils;


import com.example.patientapplication.apiClient.RetrofitClient;
import com.example.patientapplication.services.AccountService;

public class API {
    private API(){};

    public static final String API_URL = "http://192.168.1.12:8080/api/";

    public static AccountService getAccountService()
    {
        return RetrofitClient.getClient(API_URL).create(AccountService.class);
    }
}
