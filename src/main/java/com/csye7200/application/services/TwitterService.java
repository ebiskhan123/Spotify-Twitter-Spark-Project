package com.csye7200.application.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class TwitterService implements ServiceInterface {
    @Override
    public void getData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.twitter.com/2/tweets/search/recent?query=%23music")
                .method("GET", null)
                .addHeader("Authorization", "Bearer ")
                .addHeader("Cookie", "guest_id=v1%3A164883870855697149; guest_id_ads=v1%3A164883870855697149; guest_id_marketing=v1%3A164883870855697149; personalization_id=\"v1_YCqtednQLZfgvw7isPLFdg==\"")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
