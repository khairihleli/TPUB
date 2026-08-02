package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
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
