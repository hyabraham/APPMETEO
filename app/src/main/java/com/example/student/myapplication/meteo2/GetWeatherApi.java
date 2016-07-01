package com.example.student.myapplication.meteo2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Student on 21/06/2016.
 */
public interface GetWeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherDataBean> getWeatherFromApiSyncAndAsync(
            @Query("q") String cityName,
            @Query("units") String units,
            @Query("APPID") String appId);

}
