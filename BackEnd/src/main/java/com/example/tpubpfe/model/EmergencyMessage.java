package com.example.tpubpfe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    private String zone;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer priority = 1;
}
