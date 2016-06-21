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
 * Created by Amador on 20/03/2016.
 */
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistHolder > {

    ArrayList<Artist> artists;
    Context context;

    public TopArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public TopArtistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_top_artist, parent, false);

        return new TopArtistHolder (itemView);
    }

    @Override
    public void onBindViewHolder(TopArtistHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());
        holder.setArtistPlaycount(currentArtist.getPlayCount());
        holder.setArtistListeners(currentArtist.getListeners());

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

    public class TopArtistHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        TextView artistPlaycount;
        TextView artistListeners;
        ImageView artistImage;

        public TopArtistHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name_artist_top);
            artistPlaycount = (TextView) itemView.findViewById(R.id.text_playcount);
            artistListeners = (TextView) itemView.findViewById(R.id.users_listeners);
            artistImage = (ImageView) itemView.findViewById(R.id.img_top_artist);
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
        public void setArtistPlaycount (String playcount) {
            artistPlaycount.setText(playcount);
        }
        public void setArtistListeners (String listeners) {
            artistListeners.setText(listeners);
        }
    }

}
