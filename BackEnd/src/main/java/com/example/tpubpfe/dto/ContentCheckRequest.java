package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCheckRequest {
    private Long campaignId;
    private String contentType;
    private Integer riskScore;
    private Integer qualityScore;
    private String detectedIssues;
    private String aiStatus;
    private String recommendation;
}
