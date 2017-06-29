package com.rafaelarnosti.metro.api;

import com.rafaelarnosti.metro.model.Linha;
import com.rafaelarnosti.metro.model.Estacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface AndroidAPI {

    @GET("/linhas")
    Call<List<Linha>> getLinhas();

    @GET("/linhas/{linhas}/estacoes")
    Call<List<Estacao>> getEstacoes(@Path("linhas") String linha);
}