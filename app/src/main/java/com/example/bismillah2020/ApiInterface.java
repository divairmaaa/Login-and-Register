package com.example.bismillah2020;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getCars.php")
    Call< List<Cars> > getCars (
            @Query("key") String keyword);

}
