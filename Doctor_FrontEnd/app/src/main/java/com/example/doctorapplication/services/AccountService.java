package com.example.doctorapplication.services;


import com.example.doctorapplication.model.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {
    @POST("register")
    Call<Account> Register(@Body Account account);
    @POST("login")
    Call<Account> Login(@Body Account account);
}
