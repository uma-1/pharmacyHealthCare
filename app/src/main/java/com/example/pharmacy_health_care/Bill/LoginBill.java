package com.example.pharmacy_health_care.Bill;

import com.example.pharmacy_health_care.url.url;

import java.io.IOException;

import API.UserApi;
import model.LoginSignupResponse;
import model.Users;
import retrofit2.Call;
import retrofit2.Response;

public class LoginBill {
    boolean isSuccess = false;

    public boolean checkUser(String email, String password){

        UserApi userApi = url.getInstance().create(UserApi.class);
        Users user = new Users(email,password);
        Call<LoginSignupResponse> userCall =userApi.checkUser(user);

        try {
            Response<LoginSignupResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful()) {
                if(loginResponse.body().getStatus()) {
                    isSuccess = true;
                }
//                else if(loginResponse.body().getStatus().equals("false") ){
//                    isSuccess = false;
//                }
            }
            else{
                isSuccess = false;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return isSuccess;
    }
}