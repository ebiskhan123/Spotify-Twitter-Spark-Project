package com.csye7200.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ServiceManager {

    @Autowired
    SpotifyService spotifyService;

    @Autowired
    TwitterService twitterService;

    @PostConstruct
    public void scheduleBatchProcessing(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(() -> spotifyService.getData(),0,10, TimeUnit.MINUTES);
        service.scheduleAtFixedRate(() -> twitterService.getData(),0,1, TimeUnit.MINUTES);
    }


}
