package com.example.sanher.beautyapp.rest.deserializer;

import com.example.sanher.beautyapp.domain.Artist;
import com.example.sanher.beautyapp.rest.model.HypedArtistsResponse;
import com.example.sanher.beautyapp.rest.model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Amador on 11/02/2016.
 */
public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistsResponse> {
    @Override
    public HypedArtistsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        HypedArtistsResponse response = gson.fromJson(json, HypedArtistsResponse.class);
        //obtain objeto artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
        //ontener array de artist
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);
        //convertir json arrray de artist a objetos de la clase Artist
        response.setArtists(extractArtistsFromJsonArray(artistArray));

        return response;
    }



    private ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();
            //get nombre
            String name = artistData.get(JsonKeys.ARTISTS_NAME).getAsString();
            //get images
            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGES);
            String[] images = extractArtistsImagesFromJsonArray(imagesArray);
            //artist con los datos seteados
            currentArtist.setName(name);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);
        }
        return artists;
    }

    private String[] extractArtistsImagesFromJsonArray(JsonArray imagesArray){
        String [] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++) {
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();
            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();

            if(url.isEmpty())
                url = null;
            else
                url = url.replaceAll("\\/", "/");

            if (size.matches(JsonKeys.IMAGE_MEDIUM)){
                images[0] = url;
            }

            else if(size.matches(JsonKeys.IMAGE_LARGE)) {
                images[1] = url;
            }
        }
        return images;
    }
}
