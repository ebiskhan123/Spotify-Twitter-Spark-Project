package com.csye7200.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotifyService implements ServiceInterface {

    @Autowired
    MusixMatchService musixMatchService;

    @Override
    public void getData() {

    }

    private void queryData(){

    }

    private void checkForAnyUpdate(){

    }

    private void queryForLyrics(){

    }


}
