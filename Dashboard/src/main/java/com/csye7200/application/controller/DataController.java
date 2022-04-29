package com.csye7200.application.controller;

import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.SongSentiment;
import com.csye7200.application.objects.Tweet;
import com.csye7200.application.objects.TweetSentiment;
import com.csye7200.application.repository.SongRepository;
import com.csye7200.application.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RestController
@RequestMapping("/v1")
@CrossOrigin
public class DataController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping(value = "/getSongCount",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSongCount( ){

        System.out.println("req");
        try{
            Iterable<Song> songIter =  songRepository.findAll();
            List<Song> songList = new ArrayList<>();
            Iterator<Song> iterator = songIter.iterator();
            while(iterator.hasNext()){
                System.out.println(songList);
                songList.add(iterator.next());
            }
            return ResponseEntity.status(HttpStatus.OK).body(songList);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
        }

    }

    @GetMapping(value = "/getSongSentiment",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSongSentiment( ){

        try{
            Iterable<Song> songIter =  songRepository.findAll();
            List<Song> songList = new ArrayList<>();
            Iterator<Song> iterator = songIter.iterator();
            SongSentiment songSentiment = new SongSentiment();
            while(iterator.hasNext()){
                addSentimentCount(songSentiment,iterator.next());
            }

            return ResponseEntity.status(HttpStatus.OK).body(songSentiment);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
        }

    }

    @GetMapping(value = "/getTweetSentiment",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getTweetSentiment( ){

        try{
            Iterable<Tweet> tweetIter =  tweetRepository.findAll();
            List<Tweet> tweetList = new ArrayList<>();
            Iterator<Tweet> iterator = tweetIter.iterator();
            TweetSentiment tweetSentiment = new TweetSentiment();
            while(iterator.hasNext()){
                addTweetSentimentCount(tweetSentiment,iterator.next());
            }

            return ResponseEntity.status(HttpStatus.OK).body(tweetSentiment);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
        }

    }

    public void addSentimentCount(SongSentiment songSentiment, Song song){
        if(song.getSentiment() ==1)
            songSentiment.setPositive( songSentiment.getPositive()+1);
        else if(song.getSentiment() == -1)
            songSentiment.setNegative( songSentiment.getNegative()+1);
        else
            songSentiment.setNeutral( songSentiment.getNeutral()+1);
    }

    public void addTweetSentimentCount(TweetSentiment tweetSentiment, Tweet tweet){
        if(tweet.getSentiment() ==1)
            tweetSentiment.setPositive( tweetSentiment.getPositive()+1);
        else if(tweet.getSentiment() == -1)
            tweetSentiment.setNegative( tweetSentiment.getNegative()+1);
        else
            tweetSentiment.setNeutral( tweetSentiment.getNeutral()+1);
    }

}
