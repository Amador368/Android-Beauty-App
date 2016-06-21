package com.example.sanher.beautyapp.rest;

/**
 * Created by Amador on 06/02/2016.
 */
public class ApiConstants {

    public static final String API_KEY = "6a08b749af0477813c20ffe410e7439f";
    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String PATH_VERSION = "/2.0";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_API_KEY = "api_key";
    public static final String VALUE_JSON = "json";
    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.gettopartists";
    public static final String VALUE_TOP_ARTIST_METHOD = "chart.gettopartists";

    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "/?" +
            PARAM_METHOD + "=" + VALUE_HYPED_ARTIST_METHOD + "&" +
            PARAM_API_KEY + "=" + API_KEY + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;

    public static final String URL_TOP_ARTISTS = PATH_VERSION + "/?" +
            PARAM_METHOD + "=" + VALUE_TOP_ARTIST_METHOD + "&" +
            PARAM_API_KEY + "=" + API_KEY + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;

/**
http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=6a08b749af0477813c20ffe410e7439f&format=json
**/
}
