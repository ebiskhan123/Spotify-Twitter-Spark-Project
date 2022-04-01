package com.csye7200.application.services;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MusixMatchService implements ServiceInterface {
    private String title = "Heat Wave", artist = "Glass Animals";

    @Value("${musixmatch.api.token}")
    String musixmatchToken;

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

    @Override
    public void getData() {
        try {
            System.out.println(getLyrics());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
