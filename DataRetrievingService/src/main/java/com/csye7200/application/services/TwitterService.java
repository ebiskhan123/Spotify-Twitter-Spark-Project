package com.csye7200.application.services;

import com.csye7200.application.objects.Message;
import com.csye7200.application.objects.TweetMessage;
import com.csye7200.application.objects.TwitterData;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService implements ServiceInterface {

    @Value("${twitter.api.token}")
    String twitterToken;

    @Autowired
    KafkaService kafkaService;

    @Override
    public void getData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.twitter.com/2/tweets/search/recent?query=%23music")
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + twitterToken)
                .addHeader("Cookie", "guest_id=v1%3A164883870855697149; guest_id_ads=v1%3A164883870855697149; guest_id_marketing=v1%3A164883870855697149; personalization_id=\"v1_YCqtednQLZfgvw7isPLFdg==\"")
                .build();
        try {
            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
            List<TwitterData> list = getListOfTwitterData(response.body().string());

            kafkaService.publishMessage(new Message(null,"DataCollectorService",list),"tweets-topic");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TwitterData> getListOfTwitterData(String body) throws JSONException {

    List<TwitterData> twDataList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(body);
        String dataObject =  jsonObject.getString("data");
        JSONArray jsonArray = new JSONArray(dataObject);
        for( int i =0 ; i< jsonArray.length();i++){
            twDataList.add(getTwitterObject(jsonArray.getJSONObject(i)));
        }
        return twDataList;
    }

    public TwitterData getTwitterObject(JSONObject object) throws JSONException {
        return TwitterData.builder().id(object.getString("id")).text(object.getString("text")).build();
    }
}
