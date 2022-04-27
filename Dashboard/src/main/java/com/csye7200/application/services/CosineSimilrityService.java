package com.csye7200.application.services;


import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.Tweet;
import com.csye7200.application.repository.SongRepository;
import com.csye7200.application.repository.TweetRepository;
import org.apache.commons.text.similarity.CosineDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

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

    public double cosine(Vector a, Vector b) {
        double[] aArr = a.toArray();
        double[] bArr = b.toArray();
        Double l1 = Math.sqrt(Arrays.stream(aArr).map(x -> x*x).sum());
        Double l2 = Math.sqrt(Arrays.stream(bArr).map(x -> x*x).sum());
        List<Double> x = Arrays.stream(IntStream.range(0, aArr.length).mapToObj(i -> aArr[i] * bArr[i]).toArray())
                .map(val -> (Double) val).collect(Collectors.toList());
        Double scalar = x.stream().reduce(0.0, Double::sum);
        return Double.valueOf(scalar/(l1*l2));
    }

    private void checkSimilarity(){
       Iterable<Song> songIter =  songRepository.findAll();
       List<Song> songList = new ArrayList<>();
        Iterator<Song> iterator = songIter.iterator();
//        songRepository.updateCount();
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
               Vector songVector = Vectors.parse(songList.get(j).getTf_vector());
               Vector tweetVector = Vectors.parse(tweetList.get(i).getTf_vector());
               temp = cosine(songVector, tweetVector);
               if(temp > cosineDistance){
                   title = songList.get(j).getTitle();
                   cosineDistance = temp;
               }
           }
           Tweet tempTweet = tweetList.get(i);
           tempTweet.setProcessed(title);
           tweetRepository.save(tempTweet);
           Optional<Song> songoptional = songRepository.findById(title);
           if (songoptional.isPresent()){
              Song song =  songoptional.get();
              song.setProcessed(song.getProcessed() +1);
              songRepository.save(song);
           }
            System.out.print("");
       }

    }
}
