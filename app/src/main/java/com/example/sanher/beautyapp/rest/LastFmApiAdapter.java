package com.example.sanher.beautyapp.rest;
import com.example.sanher.beautyapp.rest.deserializer.HypedArtistsDeserializer;
import com.example.sanher.beautyapp.rest.model.HypedArtistsResponse;
import com.example.sanher.beautyapp.rest.deserializer.TopArtistsDeserializer;
import com.example.sanher.beautyapp.rest.model.TopArtistResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Amador on 07/02/2016.
 */
public class LastFmApiAdapter {
    private static LastFmApiService API_SERVICE;
    public static LastFmApiService getApiService () {

        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);
        }

        return API_SERVICE;
    }
    private static GsonConverter buildLastFmApiGsonConverter (){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistsDeserializer())
                .registerTypeAdapter(TopArtistResponse.class, new TopArtistsDeserializer())
                .create();
        return new  GsonConverter(gsonConf);
    }
}
