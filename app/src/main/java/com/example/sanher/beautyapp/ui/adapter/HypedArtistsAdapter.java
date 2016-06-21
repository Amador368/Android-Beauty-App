package com.example.sanher.beautyapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanher.beautyapp.R;
import com.example.sanher.beautyapp.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Amador on 05/02/2016.
 */
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistsViewHolder > {

    ArrayList<Artist> artists;
    Context context;

    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_hyped_artist, parent, false);

        return new HypedArtistsViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistsViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());

        if(currentArtist.getUrlMediumImage() != null)
            holder.setArtistImage(currentArtist.getUrlMediumImage());
        else
            holder.setArtistDefaultImage();
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){
        if (artists == null)
            throw new NullPointerException("items cannot be null");

        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount() - 1, artists.size());
        notifyDataSetChanged();
    }

    public class HypedArtistsViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;

        public HypedArtistsViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name_artist);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }
        public void setArtistName (String name) {
            artistName.setText(name);
        }
        public void setArtistImage (String url) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.img_artist_placeholder)
                    .into(artistImage);
        }
        public void setArtistDefaultImage (){
            Picasso.with(context)
                    .load(R.drawable.img_artist_placeholder)
                    .into(artistImage);
        }

    }

}
