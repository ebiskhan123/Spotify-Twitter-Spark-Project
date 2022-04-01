package com.csye7200.application.objects;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class Song {
    String trackName;
    String artistName;
}
