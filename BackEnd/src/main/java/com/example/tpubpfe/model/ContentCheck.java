package com.example.tpubpfe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "content_checks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long campaignId;

    private String contentType;

    private Integer riskScore;

    private Integer qualityScore;

    private String detectedIssues;

    private String aiStatus;

    private String recommendation;

    private LocalDateTime checkedAt = LocalDateTime.now();
}
