package com.csye7200.application.services;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwitterServiceTest {

    @Test
    public void getTweetIDTest1(){
        try {
            TwitterService ts = new TwitterService();
            JSONObject jo = new JSONObject("{\n" +
                    "            \"id\": \"1509965824123097094\",\n" +
                    "            \"text\": \"Retro jukebox record player isolated on white @AGCuesta Stock Photo on #iStock #music #jukebox https://t.co/Qz2ocO9P9U\"\n" +
                    "        }");
            assertEquals("1509965824123097094",ts.getTwitterObject(jo).getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTweetTest1(){
        try {
            TwitterService ts = new TwitterService();
            JSONObject jo = new JSONObject("{\n" +
                    "            \"id\": \"1509965824123097094\",\n" +
                    "            \"text\": \"This is the tweet\"\n" +
                    "        }");
            assertEquals("This is the tweet",ts.getTwitterObject(jo).getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTweetIDTest2(){
        try {
            TwitterService ts = new TwitterService();
            JSONObject jo = new JSONObject("{\n" +
                    "            \"id\": \"112321341\",\n" +
                    "            \"text\": \"Retro jukebox record player isolated on white @AGCuesta Stock Photo on #iStock #music #jukebox https://t.co/Qz2ocO9P9U\"\n" +
                    "        }");
            assertEquals("112321341",ts.getTwitterObject(jo).getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTweetTest2(){
        try {
            TwitterService ts = new TwitterService();
            JSONObject jo = new JSONObject("{\n" +
                    "            \"id\": \"1509965824123097094\",\n" +
                    "            \"text\": \"New text \"\n" +
                    "        }");
            assertEquals("New text ",ts.getTwitterObject(jo).getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTweetList1(){
        try {
            TwitterService ts = new TwitterService();
            String st = "{\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"id\": \"1509965824123097094\",\n" +
                    "            \"text\": \"Retro jukebox record player isolated on white @AGCuesta Stock Photo on #iStock #music #jukebox https://t.co/Qz2ocO9P9U\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            assertEquals("1509965824123097094",ts.getListOfTwitterData(st).get(0).getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTweetList2(){
        try {
            TwitterService ts = new TwitterService();
            String st = "{\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"id\": \"1509965824123097094\",\n" +
                    "            \"text\": \"Check text" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            assertEquals("Check text",ts.getListOfTwitterData(st).get(0).getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}