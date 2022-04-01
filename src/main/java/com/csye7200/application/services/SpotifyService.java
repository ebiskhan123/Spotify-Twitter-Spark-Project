package com.csye7200.application.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SpotifyService implements ServiceInterface {

    @Autowired
    MusixMatchService musixMatchService;

    @Value("${spotify.api.token}")
    String spotifyToken;
    // ;SPOTIFY_TOKEN=BQC6FeM2cCjveg72oJ-IKKIRHLFPsraVRnAr4sIl_Zhvcg-DP3RElaVlkyzeTq-n1QgLOgYNXQtQ4HI2Hl9TaAKe7h6hWIO45VejeHRcpGD3dvLTX73_yIowwKTjBJeBq1iEG6x3GvmgIq_koM8x8zPm-13B-18UdRjEVkSquCKRA789lR79j3sjvA-jwQraO5rUVZqRHoNlzLvKQ0F-kAjEKdLN4orZlEWAfPkYmGL0TdSq
    @Override
    public void getData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/playlists/37i9dQZEVXbMDoHDwVN2tF/tracks")
                .method("GET", null)
                .addHeader("Authorization", "Bearer BQC6FeM2cCjveg72oJ-IKKIRHLFPsraVRnAr4sIl_Zhvcg-DP3RElaVlkyzeTq-n1QgLOgYNXQtQ4HI2Hl9TaAKe7h6hWIO45VejeHRcpGD3dvLTX73_yIowwKTjBJeBq1iEG6x3GvmgIq_koM8x8zPm-13B-18UdRjEVkSquCKRA789lR79j3sjvA-jwQraO5rUVZqRHoNlzLvKQ0F-kAjEKdLN4orZlEWAfPkYmGL0TdSq" + spotifyToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void queryData(){

    }

    private void checkForAnyUpdate(){

    }

    private void queryForLyrics(){

    }


}
