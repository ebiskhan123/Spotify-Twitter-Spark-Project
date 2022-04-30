package com.csye7200.application.services;

import com.csye7200.application.objects.Song;
import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.jmusixmatch.entity.track.Track;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MusixMatchServiceTest {

    @Test
    public void processListTest(){
        try {
            MusixMatchService musixMatchService = new MusixMatchService();
            MusixMatch musixMatch =  Mockito.mock(MusixMatch.class);
            Song song = new Song();
            List<Song> songList = new ArrayList<Song>();
            song.setTrackName("Mytrack");
            songList.add(song);
            Track track = Mockito.mock(Track.class);
            Mockito.when(musixMatch.getMatchingTrack(Mockito.any(),Mockito.any())).thenReturn(track);
            Lyrics lyrics = Mockito.mock(Lyrics.class);
            Mockito.when(musixMatch.getLyrics(Mockito.any())).thenReturn(lyrics);
            Mockito.when(lyrics.getLyricsBody()).thenReturn("this is the lyrics");
            musixMatchService.processList(songList);
            assertEquals("this is the lyrics", songList.get(0).getLyrics());
        } catch (MusixMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void processListTest2(){
        try {
            MusixMatchService musixMatchService = new MusixMatchService();
            MusixMatch musixMatch =  Mockito.mock(MusixMatch.class);
            Song song = new Song();
            List<Song> songList = new ArrayList<Song>();
            song.setTrackName("Mytrack");
            songList.add(song);
            Track track = Mockito.mock(Track.class);
            Mockito.when(musixMatch.getMatchingTrack(Mockito.any(),Mockito.any())).thenReturn(track);
            Lyrics lyrics = Mockito.mock(Lyrics.class);
            Mockito.when(musixMatch.getLyrics(Mockito.any())).thenReturn(lyrics);
            Mockito.when(lyrics.getLyricsBody()).thenReturn("Check list ");
            musixMatchService.processList(songList);
            assertEquals("Check list ", songList.get(0).getLyrics());
        } catch (MusixMatchException e) {
            e.printStackTrace();
        }
    }
}