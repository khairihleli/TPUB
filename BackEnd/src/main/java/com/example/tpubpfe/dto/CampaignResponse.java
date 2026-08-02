package com.example.tpubpfe.dto;

import com.example.tpubpfe.model.AdminApprovalStatus;
import com.example.tpubpfe.model.AiReviewStatus;
import com.example.tpubpfe.model.CampaignStatus;
import com.example.tpubpfe.model.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignResponse {
    private Long id;
    private String name;
    private String objective;
    private String description;
    private String mediaUrl;
    private Double budget;
    private Long estimatedViews;
    private LocalDate startDate;
    private LocalDate endDate;
    private CampaignStatus status;
    private AiReviewStatus aiStatus;
    private AdminApprovalStatus adminStatus;
    private ReservationStatus reservationStatus;
    private Integer priority;
    private Long companyId;
}
