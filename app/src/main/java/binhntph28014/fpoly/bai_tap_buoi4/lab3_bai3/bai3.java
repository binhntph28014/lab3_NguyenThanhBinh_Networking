package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import binhntph28014.fpoly.bai_tap_buoi4.R;
import binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.adapter.AlbumAdapter;
import binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.api.ApiService;
import binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.model.Contart;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bai3 extends AppCompatActivity {
    private RecyclerView rcv_Album;
    private List<Contart> mAlbums;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        rcv_Album = findViewById(R.id.card_recyler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Album.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_Album.addItemDecoration(itemDecoration);
        callApiGetAlbum();
    }

    private  void callApiGetAlbum(){
        ApiService.apiService.getListAlbum(1).enqueue(new Callback<List<Contart>>() {
            @Override
            public void onResponse(Call<List<Contart>> call, Response<List<Contart>> response) {
                mAlbums = response.body();
                AlbumAdapter albumAdapter = new AlbumAdapter(mAlbums);
                rcv_Album.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Contart>> call, Throwable t) {
                Toast.makeText(bai3.this, "onfaiure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}