package com.example.studypartner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("students_doubts.php")
    Call<Doubts_Model> addDoubts(@Field("Doubts") String doubts);

    @GET("getDoubts.php")
    Call<List<Doubts_Model>> getDoubt();

    @DELETE("deleteDoubts.php")
    Call<List<Doubts_Model>> deleteDoubts();
}
