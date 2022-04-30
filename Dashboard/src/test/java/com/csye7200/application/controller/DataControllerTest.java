package com.csye7200.application.controller;

import com.csye7200.application.objects.Song;
import com.csye7200.application.objects.SongSentiment;
import com.csye7200.application.repository.SongRepository;
import com.csye7200.application.services.CosineSimilrityService;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DataControllerTest {

    @Mock
    SongRepository songRepository;

    @InjectMocks
    DataController dc;

    @Test
    public void getSongCountTest(){
        Mockito.when(songRepository.findAll()).thenReturn(new Iterable<Song>() {
            @NotNull
            @Override
            public Iterator<Song> iterator() {
                return new Iterator<Song>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public Song next() {
                        Song song = new Song();
                        song.setProcessed(10);
                        return song;
                    }
                };
            }
        });
        assertEquals(HttpStatus.OK,dc.getSongCount().getStatusCode());
    }

    @Test
    public void getSongSentimentTest(){
        Mockito.when(songRepository.findAll()).thenReturn(new Iterable<Song>() {
            @NotNull
            @Override
            public Iterator<Song> iterator() {
                return new Iterator<Song>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }
                    @Override
                    public Song next() {
                        Song song = new Song();
                        song.setProcessed(10);
                        return song;
                    }
                };
            }
        });
        assertEquals(HttpStatus.OK,dc.getSongSentiment().getStatusCode());
    }

    @Mock
    Song song;

//    @Mock
//    SongSentiment st;
    @Test
    public void addSentimentCountTest(){
        SongSentiment st = new SongSentiment();
//        Song song = new Song();
        st.setPositive(0);
        Mockito.when(song.getSentiment()).thenReturn(1);
//        Mockito.when(st.getPositive()).thenReturn(1);
        dc.addSentimentCount(st,song);
        assertEquals(1,st.getPositive());
    }

    @Test
    public void addSentimentCountTest2(){
        SongSentiment st = new SongSentiment();
//        Song song = new Song();
        st.setNegative(0);
        Mockito.when(song.getSentiment()).thenReturn(-1);
        dc.addSentimentCount(st,song);
        assertEquals(1,st.getNegative());
    }

    @Test
    public void addSentimentCountTest3(){
        SongSentiment st = new SongSentiment();
//        Song song = new Song();
        st.setNeutral(0);
        Mockito.when(song.getSentiment()).thenReturn(0);
        dc.addSentimentCount(st,song);
        assertEquals(1,st.getNeutral());
    }
}