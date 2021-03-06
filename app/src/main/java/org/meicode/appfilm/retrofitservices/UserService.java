package org.meicode.appfilm.retrofitservices;

import org.meicode.appfilm.retrofitresponse.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<UserResponse> register(@Field("name") String name, @Field("email") String email, @Field("password") String password);
}
