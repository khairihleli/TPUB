package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCheckResponse {
    private Long id;
    private Long campaignId;
    private String contentType;
    private Integer riskScore;
    private Integer qualityScore;
    private String detectedIssues;
    private String aiStatus;
    private String recommendation;
    private LocalDateTime checkedAt;
}
