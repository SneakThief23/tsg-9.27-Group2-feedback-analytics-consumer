package com.Group2.feedback_analytics_consumer.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FeedbackResponseDTO {
    private UUID id;
    private String memberId;
    private String providerName;
    private OffsetDateTime submittedAt;
    private int rating;
    private String comment;
}
