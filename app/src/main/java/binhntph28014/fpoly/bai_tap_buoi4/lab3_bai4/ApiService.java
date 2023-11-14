package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai4;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/json_data.json")
    Call<ContactList> getMyJSON();
}
