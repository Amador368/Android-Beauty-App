package com.example.sanher.beautyapp.ui.fragmet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.example.sanher.beautyapp.rest.LastFmApiAdapter;
import com.example.sanher.beautyapp.rest.model.TopArtistResponse;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanher.beautyapp.R;
import com.example.sanher.beautyapp.ui.adapter.TopArtistAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends Fragment {

    private RecyclerView artistList;
    private TopArtistAdapter topArtistAdapter;


    public TopArtistFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topArtistAdapter = new TopArtistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_top_artist, container, false);
        View root = inflater.inflate(R.layout.fragment_top_artist, container, false);
        artistList = (RecyclerView) root.findViewById(R.id.top_artist_list);

        setupList();
        return root;
    }
    //Throwable error;
    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService().getTopArtists().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistResponse>() {
                    @Override
                    public void call(TopArtistResponse topArtistResponse) {
                        topArtistAdapter.addAll(topArtistResponse.getArtists());
                    }
                });
    }

    public void setupList() {
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(topArtistAdapter);
    }

}
