package com.Group2.feedback_analytics_consumer.messaging;

import com.Group2.feedback_analytics_consumer.model.FeedbackResponseDTO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackEventListenerTest {

    @Test
    void shouldReturnStringRepresentationOfEvent() {
        // Arrange:
        FeedbackResponseDTO event = new FeedbackResponseDTO();
        event.setId(UUID.randomUUID());
        event.setRating(4);
        event.setProviderName("TestProvider");
        event.setMemberId("m-123");
        event.setComment("Great service!");

        FeedbackEventListener listener = new FeedbackEventListener();
        System.out.println(event.getMemberId() + " " + event.getRating() + " " + event.getProviderName() + " " + event.getComment());
        // Act:
        String result = listener.onMessage(event);

        // Assert:
        assertNotNull(result);
        assertTrue(result.contains("TestProvider"));
        assertTrue(result.contains("m-123"));
        assertTrue(result.contains("Great service!"));
    }

    @Test
    void shouldHandleNullEventGracefully() {
        // Arrange: instantiate the listener
        FeedbackEventListener listener = new FeedbackEventListener();

        // Act & Assert: ensures no exception is thrown when the event is null
        assertDoesNotThrow(() -> listener.onMessage(null));
    }
}
