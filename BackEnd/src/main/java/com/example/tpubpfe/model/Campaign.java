package com.example.tpubpfe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "campaigns")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String objective;

    private String description;

    private String mediaUrl;

    private Double budget;

    private Long estimatedViews;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private CampaignStatus status = CampaignStatus.DRAFT;

    @Enumerated(EnumType.STRING)
    private AiReviewStatus aiStatus = AiReviewStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private AdminApprovalStatus adminStatus = AdminApprovalStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus = ReservationStatus.DRAFT;

    private Integer priority = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
