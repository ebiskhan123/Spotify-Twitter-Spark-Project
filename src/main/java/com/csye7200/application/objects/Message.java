package com.csye7200.application.objects;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class Message {
    private String songDetails;
    private String senderId;
}
