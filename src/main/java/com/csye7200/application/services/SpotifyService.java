package com.csye7200.application.services;

import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.TwitterData;
import com.google.gson.JsonParser;
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

    @Value("${spotify.api.token}")
    String spotifyToken;
    @Override
    public void getData() {

        String token = "";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody rbody = RequestBody.create(mediaType, "grant_type=client_credentials");
        String user = "5d3839e08cac449d9a4017e94d0f723b";
        String pwd = "e90f302344df460d8b1530a655a38aed";
        String encoding = Base64.getEncoder().encodeToString((user + ":" + pwd).getBytes());
        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .method("POST", rbody)
                .addHeader("Authorization", "Basic " + encoding)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "__Host-device_id=AQBIxe10NX4hib66cWtuSHTDvTNoWr2ua8ApK77G3TtcK8K8UfTvgimaTvT4mBANRZIoMZfTaNvQ724m9Zc8N72U0X_nmNo6yiQ; __Host-sp_csrf_sid=f684227fc449254268ae5df8e06a418fda87922bd4bcf6d318f7252e96e40e95; __Secure-TPASESSION=AQCFSWNLa+AtSDVKxd0wAe4+KfwnNcYjxUWUTMtccKH0KzOgXbs/eMCWpDWpmK1dhL5Bb2JbccLz8qlFEmRd1xVrD7NAIc8Bb0s=; inapptestgroup=; sp_sso_csrf_token=013acda719ffe2f1b1ca7cad2b0f22fe3cdcbdaad531363530333430373438353438; sp_tr=false")
                .build();
        try {
            Response response = client.newCall(request).execute();
//            token = String.valueOf(JsonParser.parseString(String.valueOf(response)).getAsJsonObject().getAsJsonObject("access_token"));
            String s = response.body().string();
            JSONObject jj = new JSONObject(s);
            token = jj.getString("access_token");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------------" + token);
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
//        JSONArray jsonArray = new JSONArray(artists);
        String name = artists.getJSONObject(0).getString("name");
        return name;
    }


    private void checkForAnyUpdate(){

    }

    private void queryForLyrics(List<Song> songList){
        musixMatchService.getData(songList);
    }


}
