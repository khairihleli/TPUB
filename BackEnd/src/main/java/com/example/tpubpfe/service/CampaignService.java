package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.CampaignRequest;
import com.example.tpubpfe.dto.CampaignResponse;
import com.example.tpubpfe.model.Campaign;
import com.example.tpubpfe.model.Company;
import com.example.tpubpfe.repository.CampaignRepository;
import com.example.tpubpfe.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final CompanyRepository companyRepository;

    public CampaignResponse create(CampaignRequest request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new CompanyNotFoundException(request.getCompanyId()));

        Campaign campaign = new Campaign();
        campaign.setName(request.getName());
        campaign.setObjective(request.getObjective());
        campaign.setDescription(request.getDescription());
        campaign.setMediaUrl(request.getMediaUrl());
        campaign.setBudget(request.getBudget());
        campaign.setEstimatedViews(request.getEstimatedViews());
        campaign.setStartDate(request.getStartDate());
        campaign.setEndDate(request.getEndDate());
        campaign.setStatus(request.getStatus() != null ? request.getStatus() : com.example.tpubpfe.model.CampaignStatus.DRAFT);
        campaign.setAiStatus(request.getAiStatus() != null ? request.getAiStatus() : com.example.tpubpfe.model.AiReviewStatus.PENDING);
        campaign.setAdminStatus(request.getAdminStatus() != null ? request.getAdminStatus() : com.example.tpubpfe.model.AdminApprovalStatus.PENDING);
        campaign.setReservationStatus(request.getReservationStatus() != null ? request.getReservationStatus() : com.example.tpubpfe.model.ReservationStatus.DRAFT);
        campaign.setPriority(request.getPriority() != null ? request.getPriority() : 1);
        campaign.setCompany(company);

        return toResponse(campaignRepository.save(campaign));
    }

    public List<CampaignResponse> findAll() {
        return campaignRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public CampaignResponse update(Long id, CampaignRequest request) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException(id));

        campaign.setName(request.getName());
        campaign.setObjective(request.getObjective());
        campaign.setDescription(request.getDescription());
        campaign.setMediaUrl(request.getMediaUrl());
        campaign.setBudget(request.getBudget());
        campaign.setEstimatedViews(request.getEstimatedViews());
        campaign.setStartDate(request.getStartDate());
        campaign.setEndDate(request.getEndDate());
        campaign.setStatus(request.getStatus() != null ? request.getStatus() : campaign.getStatus());
        campaign.setAiStatus(request.getAiStatus() != null ? request.getAiStatus() : campaign.getAiStatus());
        campaign.setAdminStatus(request.getAdminStatus() != null ? request.getAdminStatus() : campaign.getAdminStatus());
        campaign.setReservationStatus(request.getReservationStatus() != null ? request.getReservationStatus() : campaign.getReservationStatus());
        campaign.setPriority(request.getPriority() != null ? request.getPriority() : campaign.getPriority());

        if (request.getCompanyId() != null) {
            Company company = companyRepository.findById(request.getCompanyId())
                    .orElseThrow(() -> new CompanyNotFoundException(request.getCompanyId()));
            campaign.setCompany(company);
        }

        return toResponse(campaignRepository.save(campaign));
    }

    public void delete(Long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException(id));
        campaignRepository.delete(campaign);
    }

    private CampaignResponse toResponse(Campaign campaign) {
        return new CampaignResponse(
                campaign.getId(),
                campaign.getName(),
                campaign.getObjective(),
                campaign.getDescription(),
                campaign.getMediaUrl(),
                campaign.getBudget(),
                campaign.getEstimatedViews(),
                campaign.getStartDate(),
                campaign.getEndDate(),
                campaign.getStatus(),
                campaign.getAiStatus(),
                campaign.getAdminStatus(),
                campaign.getReservationStatus(),
                campaign.getPriority(),
                campaign.getCompany() != null ? campaign.getCompany().getId() : null
        );
    }
}
