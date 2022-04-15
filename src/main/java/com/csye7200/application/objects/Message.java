package com.csye7200.application.objects;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Message {
    private List<Song> songDetails;
    private String senderId;
}
