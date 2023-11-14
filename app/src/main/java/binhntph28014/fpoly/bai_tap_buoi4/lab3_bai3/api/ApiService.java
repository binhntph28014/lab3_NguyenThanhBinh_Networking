package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.model.Contart;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd-mm-yyyy").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.3.104:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("contart")
    Call<List<Contart>> getListAlbum(@Query("contart")int userId);
}