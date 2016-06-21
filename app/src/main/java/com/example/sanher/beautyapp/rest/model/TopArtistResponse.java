package com.example.sanher.beautyapp.rest.model;
import com.example.sanher.beautyapp.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
/**
 * Created by Amador on 20/03/2016.
 */

public class TopArtistResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists(){
        return results.artists;
    }

    public void setArtists(ArrayList<Artist> artists){
        this.results.artists = artists;
    }

    private class HypedArtistsResults {


        ArrayList<Artist>artists;
    }
}
