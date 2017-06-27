package com.rafaelarnosti.metro.api;

import com.rafaelarnosti.metro.model.Android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface AndroidAPI {

    @GET("/linhas")
    Call<List<Android>> getLinhas();
}