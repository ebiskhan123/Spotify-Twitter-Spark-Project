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
import java.util.Iterator;
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
        Iterator<Song> iterator = songIter.iterator();
        songRepository.updateCount("Eminem sings");
       while(iterator.hasNext()){
           songList.add(iterator.next());
       }
       List<Tweet> tweetList = tweetRepository.findAllUncomputedTweets();
       CosineDistance dist = new CosineDistance();
        double cosineDistance ;
        String title = "";
        double temp = -1d;
       for( int i = 0 ; i< tweetList.size();i++){
           title = "";
           cosineDistance = Double.MIN_VALUE;

           for( int j =0 ; j < songList.size();j++){
               temp = 1- dist.apply(songList.get(j).getLyrics(),tweetList.get(i).getTweet_text());
               if(temp > cosineDistance){
                   title = songList.get(j).getTitle();
                   cosineDistance = temp;
               }
           }
           Tweet tempTweet = tweetList.get(i);
           tempTweet.setProcessed(title);
           tweetRepository.save(tempTweet);
           songRepository.updateCount(title);

       }

    }
}
