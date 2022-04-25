package com.csye7200.application.services;


import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.Tweet;
import com.csye7200.application.repository.SongRepository;
import com.csye7200.application.repository.TweetRepository;
import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.CosineSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class CosineSimilrityService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    TweetRepository tweetRepository;

    @PostConstruct
    void init(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> checkSimilarity(),0,1, TimeUnit.MINUTES);
    }

    private void checkSimilarity(){
       Iterable<Song> songIter =  songRepository.findAll();
       List<Song> songList = new ArrayList<>();
       while(songIter.iterator().hasNext()){
           songList.add(songIter.iterator().next());
       }
       List<Tweet> tweetList = tweetRepository.findAllUncomputedTweets();
       CosineDistance dist = new CosineDistance();
        double cosineDistance = Double.MIN_VALUE;
        String title = "";
        double temp = 0d;
       for( int i = 0 ; i< tweetList.size();i++){
           title = "";
           for( int j =0 ; j < songList.size();j++){
               temp = dist.apply(songList.get(j).getLyrics(),tweetList.get(i).getTweets());
               if(temp > cosineDistance){
                   title = songList.get(j).getTitle();
               }
           }
           Tweet tempTweet = tweetList.get(i);
           tempTweet.setProcessed(title);

       }

    }
}
