package com.example.sanher.beautyapp.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sanher.beautyapp.R;
import com.example.sanher.beautyapp.domain.Artist;
import com.example.sanher.beautyapp.rest.LastFmApiAdapter;
import com.example.sanher.beautyapp.rest.model.HypedArtistsResponse;
import com.example.sanher.beautyapp.ui.ItemOffsetDecoration;
import com.example.sanher.beautyapp.ui.adapter.HypedArtistsAdapter;

import java.util.ArrayList;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amador on 30/01/2016.
 */
public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistsResponse> {

    public static final int NUM_COLUMNS = 2;

    private RecyclerView mHypedArtistsList;
    private HypedArtistsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistsAdapter(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mHypedArtistsList = (RecyclerView) root.findViewById(R.id.hyped_artists_list);
        setupArtistList();
        //setDummyContent();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService()
                .getHypedArtists(this);
    }

    //configuraciones
    private void setupArtistList () {
         mHypedArtistsList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
         mHypedArtistsList.setAdapter(adapter);
         mHypedArtistsList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }
/*
    public void setDummyContent(){
        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            artists.add(new Artist("Artist" + i));
        }
        adapter.addAll(artists);
    }
*/
    @Override
    public void success(HypedArtistsResponse hypedArtistsResponse, Response response) {
        //se agregan los artistas
        adapter.addAll(hypedArtistsResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
