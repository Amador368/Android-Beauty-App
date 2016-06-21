package com.example.sanher.beautyapp.rest;

import com.example.sanher.beautyapp.rest.model.HypedArtistsResponse;
import com.example.sanher.beautyapp.rest.model.TopArtistResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Amador on 06/02/2016.
 */
public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists (Callback<HypedArtistsResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ARTISTS)
        rx.Observable<TopArtistResponse> getTopArtists();

}

