package com.example.tpubpfe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long campaignId;

    private Long zoneId;

    private Long supportId;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    private String availabilityStatus;

    private String reservationStatus;

    private Long estimatedViews;

    private Double estimatedCost;
}
