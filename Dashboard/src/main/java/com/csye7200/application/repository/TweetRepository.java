package com.csye7200.application.repository;

import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.Tweet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends CrudRepository<Song,Long> {

    @Query("SELECT t FROM Tweet t WHERE t.processed = 0")
    List<Tweet> findAllUncomputedTweets();

}

