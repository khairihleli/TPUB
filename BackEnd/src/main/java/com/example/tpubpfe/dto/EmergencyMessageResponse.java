package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyMessageResponse {
    private Long id;
    private String title;
    private String message;
    private String zone;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer priority;
}
