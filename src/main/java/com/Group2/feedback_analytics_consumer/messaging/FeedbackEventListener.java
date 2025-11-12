package com.Group2.feedback_analytics_consumer.messaging;

import com.Group2.feedback_analytics_consumer.model.FeedbackResponseDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FeedbackEventListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "feedback-submitted", groupId = "feedback-analytics-consumer")
    public void onMessage(FeedbackResponseDTO event) {
//        try {
            System.out.printf(
                    "Received feedback: id=%s | rating= %d | provider= %s | member= %s%n",
                    event.getId(), event.getRating(), event.getProviderName(), event.getMemberId()
            );
//        } catch (Exception e) {
//            System.err.println("Failed to process feedback event: " + e.getMessage());
//        }
    }

}
