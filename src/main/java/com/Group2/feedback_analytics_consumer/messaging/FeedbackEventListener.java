package com.Group2.feedback_analytics_consumer.messaging;

import com.Group2.feedback_analytics_consumer.model.FeedbackResponseDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FeedbackEventListener {

    @KafkaListener(topics = "feedback-submitted", groupId = "feedback-analytics-consumer")
    public String onMessage(FeedbackResponseDTO event) {

        if (event == null) {
            System.err.println("Received null event");
            return null;
        }

        String result = event.toString();
        try {
            System.out.printf(
                    "Received feedback: id: %s | rating: %d | provider: %s | member: %s%n | comment: %s%n",
                    event.getId(), event.getRating(), event.getProviderName(), event.getMemberId(), event.getComment()
            );
        } catch (Exception e) {
            System.err.println("Failed to process feedback event: " + e.getMessage());
        }

        return result;
    }

}
