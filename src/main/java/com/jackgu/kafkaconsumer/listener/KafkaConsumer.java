package com.jackgu.kafkaconsumer.listener;

import com.jackgu.kafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
  public void consume(String message) {
    System.out.println("consumed: " + message);
  }

  @KafkaListener(
      topics = "Kafka_Example_json",
      groupId = "group_json",
      containerFactory = "userKafkaListenerFactory")
  public void consume_json(User user) {
  	System.out.println("Consumed JSON message: "+ user.getName());
  }
}
