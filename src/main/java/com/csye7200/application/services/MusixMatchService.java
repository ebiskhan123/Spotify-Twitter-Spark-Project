package com.csye7200.application.services;

import com.csye7200.application.objects.Message;
import com.csye7200.application.objects.Song;
import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusixMatchService  {
    private String title = "Heat Wave", artist = "Glass Animals";

    @Value("${musixmatch.api.token}")
    String musixmatchToken;


    @Autowired
    KafkaService kafkaService;

    public void setTitleAndArtist(String title, String artist) {
        this.artist = artist;
        this.title = title;
    }

    private String getLyrics() throws MusixMatchException {
        MusixMatch musixMatch = new MusixMatch(musixmatchToken);
        Track track = musixMatch.getMatchingTrack(title, artist);
        TrackData data = track.getTrack();
        Lyrics lyrics = musixMatch.getLyrics(data.getTrackId());
        return lyrics.getLyricsBody();
    }

    public void getData(List<Song> songList) {
        try {
            for( Song song : songList){
                setTitleAndArtist(song.getTrackName(),song.getArtistName());
                String lyrics = getLyrics();
                song.setLyrics(lyrics);
                System.out.println(lyrics);
            }
           kafkaService.publishMessage(new Message(songList.toString(),"DataCollectorService"),"songs-topic");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
