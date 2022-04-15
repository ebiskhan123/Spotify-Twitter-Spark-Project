package com.csye7200.application.services;

import com.csye7200.application.objects.Message;
import com.csye7200.application.objects.TweetMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, TweetMessage> kafkatweetTemplate;

//    @Value(value = "${kafka.topic_name}")
//    private String kafkaTopicName;

    public void publishMessage(Message message,String kafkaTopicName){
        ListenableFuture<SendResult<String, Message>> future = this.kafkaTemplate.send(kafkaTopicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failure");
            }
        });
    }


    public void publishTweetMessage(TweetMessage message, String kafkaTopicName){
        ListenableFuture<SendResult<String, TweetMessage>> future = this.kafkatweetTemplate.send(kafkaTopicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, TweetMessage>>() {

            @Override
            public void onSuccess(SendResult<String, TweetMessage> result) {
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failure");
            }
        });
    }

}
