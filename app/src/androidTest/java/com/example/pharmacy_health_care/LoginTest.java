package com.example.pharmacy_health_care;


import org.junit.Test;

import API.API;
import model.LoginSignupResponse;
import model.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import reusable.Reusable;

import static junit.framework.TestCase.assertTrue;

public class LoginTest {
    @Test
    public  void testLogin()
    {
//        LoginBill bill = new LoginBill("bijay", "bijay");
//        boolean result = bill.checkUser();
//        assertEquals(true, result);




        Users user = new Users("anish", "anish");
        API api = Reusable.getInstance().create(API.class);
        Call<LoginSignupResponse> responseCall = api.loginUser(user);
        responseCall.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                LoginSignupResponse loginSignupResponse = response.body();
                assertTrue(response.isSuccessful()&& loginSignupResponse.getSuccess());
            }

            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {

            }
        });

    }

    @Test
    public void FailTest(){

        Users user = new Users("Ronaldo", "Ronaldo");
        API api = Reusable.getInstance().create(API.class);
        Call<LoginSignupResponse> responseCall = api.loginUser(user);
        responseCall.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                LoginSignupResponse loginSignupResponse = response.body();
                assertTrue(response.isSuccessful()&& loginSignupResponse.getSuccess());
            }

            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {

            }
        });



    }


}
