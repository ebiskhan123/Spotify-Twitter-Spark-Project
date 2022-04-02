package com.csye7200.application.objects;

import lombok.*;

@NoArgsConstructor
@ToString
@Builder
@Getter
@AllArgsConstructor
@Setter
public class Song {
    public Song(String trackName,String artistName){
        this.trackName = trackName;
        this.artistName = artistName;
    }
    String trackName;
    String artistName;
    String lyrics;
}
