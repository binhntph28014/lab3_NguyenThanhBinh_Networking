package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import binhntph28014.fpoly.bai_tap_buoi4.R;
import binhntph28014.fpoly.bai_tap_buoi4.lab3_bai3.model.Contart;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private final List<Contart> mListAlbums;
    private Context context;
    URL uri;

    public AlbumAdapter(List<Contart> mListAlbums) {
        this.mListAlbums = mListAlbums;
    }

    public AlbumAdapter(List<Contart> mListAlbums, Context context) {
        this.mListAlbums = mListAlbums;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);

        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        final Contart album = mListAlbums.get(position);
        if (album == null){
            return;
        }

        holder.tv_name.setText(String.valueOf(album.getName()));
        holder.tv_ver.setText(album.getVer());
        holder.tv_api.setText(album.getApi());
        Picasso.get()
                .load(album.getUrl())
                .into(holder.ig_AlbumId);


   }

    @Override
    public int getItemCount() {
        if (mListAlbums!= null){
            return  mListAlbums.size();
        }
        return 0;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name, tv_ver, tv_api;
        private ImageView ig_AlbumId;
        private View onclick;

        public AlbumViewHolder(@NonNull View itemview) {
            super(itemview);
            tv_name = (TextView) itemview.findViewById(R.id.tv_name);
            tv_ver =(TextView) itemview.findViewById(R.id.tv_ver);
            ig_AlbumId =(ImageView) itemview.findViewById(R.id.AlbumId3);
            tv_api = (TextView) itemview.findViewById(R.id.tv_api);

            onclick = itemview.findViewById(R.id.AlbumId);
        }


    }

}
