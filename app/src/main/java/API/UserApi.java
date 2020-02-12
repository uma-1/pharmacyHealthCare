package API;

import model.LoginSignupResponse;
import model.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/signup")
    Call<LoginSignupResponse> registerUser(@Body Users users);

    @POST("user/login")
    Call<LoginSignupResponse> checkUser(@Body Users users);
}
