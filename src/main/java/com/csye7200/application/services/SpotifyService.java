package com.csye7200.application.services;

import com.csye7200.application.objects.Song;
import okhttp3.*;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class SpotifyService implements ServiceInterface {

    @Autowired
    MusixMatchService musixMatchService;

    @Value("${spotify.api.client_id}")
    String client_id;
    @Value("${spotify.api.client_secret}")
    String client_secret;

    @Override
    public void getData() {
        String token = "";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody rbody = RequestBody.create(mediaType, "grant_type=client_credentials");
        String encoding = Base64.getEncoder().encodeToString((client_id + ":" + client_secret).getBytes());
        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .method("POST", rbody)
                .addHeader("Authorization", "Basic " + encoding)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String s = response.body().string();
            JSONObject jObject = new JSONObject(s);
            token = jObject.getString("access_token");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        client = new OkHttpClient().newBuilder()
                .build();
        request = new Request.Builder()
                .url("https://api.spotify.com/v1/playlists/37i9dQZEVXbMDoHDwVN2tF/tracks")
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            List<Song> songList = extractData(body);
            queryForLyrics(songList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<Song> extractData(String body) throws JSONException {
        List<Song> songDataList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(body);
        String dataObject =  jsonObject.getString("items");
        JSONArray jsonArray = new JSONArray(dataObject);
        for( int i =0 ; i< jsonArray.length();i++){
            String trackName = getTrackName(jsonArray.getJSONObject(i));
            String artistName = getArtistName(jsonArray.getJSONObject(i));
            Song song = new Song(trackName,artistName);
            songDataList.add(song);
        }
        return songDataList;
    }

    private String getTrackName(JSONObject item) throws JSONException {

        JSONObject track = item.getJSONObject("track");
        String name = track.getString("name");
        return name;
    }

    private String getArtistName(JSONObject item) throws JSONException {

        JSONObject track = item.getJSONObject("track");
        JSONObject album = track.getJSONObject("album");
        JSONArray artists = album.getJSONArray("artists");
        String name = artists.getJSONObject(0).getString("name");
        return name;
    }


    private void checkForAnyUpdate(){

    }

    private void queryForLyrics(List<Song> songList){
        musixMatchService.getData(songList);
    }


}
