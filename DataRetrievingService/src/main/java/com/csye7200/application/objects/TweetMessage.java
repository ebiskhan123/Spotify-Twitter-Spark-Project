package com.csye7200.application.objects;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class TweetMessage {
    private List<TwitterData> tweets;
    private String senderId;
}
