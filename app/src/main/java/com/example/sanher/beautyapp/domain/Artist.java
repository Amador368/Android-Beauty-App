package com.example.sanher.beautyapp.domain;
import com.google.gson.annotations.SerializedName;
import com.example.sanher.beautyapp.rest.model.JsonKeys;

/**
 * Created by Amador on 01/02/2016.
 */
public class Artist {
    @SerializedName(JsonKeys.ARTISTS_NAME)
    String name;
    String playCount;
    String listeners;
    String urlLargeImage;
    String urlMediumImage;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist(){
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
}

