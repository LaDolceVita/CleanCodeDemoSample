package com.fornalik.cleancode.setup.api;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

import com.fornalik.cleancode.setup.entity.SetupPostData;

/**
 * Created by seweryn fornalik.
 */
public interface SetupServiceApiType {

    @POST("demo/data")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Void> setupSetup(@Body SetupPostData setupPostData);
}
