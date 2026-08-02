package com.example.tpubpfe.dto;

import com.example.tpubpfe.model.AdminApprovalStatus;
import com.example.tpubpfe.model.AiReviewStatus;
import com.example.tpubpfe.model.CampaignStatus;
import com.example.tpubpfe.model.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignRequest {

    @NotBlank(message = "Campaign name is required")
    private String name;

    @NotBlank(message = "Objective is required")
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

    @NotNull(message = "Company id is required")
    private Long companyId;
}
