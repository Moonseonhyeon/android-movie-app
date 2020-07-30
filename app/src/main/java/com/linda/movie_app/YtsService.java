package com.linda.movie_app;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface YtsService { //모델마다 만들기

    @GET("list_movies.json")
    Call<YtsData> 영화목록가져오기(
            @Query("sort_by") String sort_by,
            @Query("limit") int limit,
            @Query("page") int page
    );


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://yts.mx/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
