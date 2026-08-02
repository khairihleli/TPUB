package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ContentCheckRequest;
import com.example.tpubpfe.dto.ContentCheckResponse;
import com.example.tpubpfe.model.ContentCheck;
import com.example.tpubpfe.repository.ContentCheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentCheckService {

    private final ContentCheckRepository contentCheckRepository;

    public ContentCheckResponse create(ContentCheckRequest request) {
        ContentCheck check = new ContentCheck();
        check.setCampaignId(request.getCampaignId());
        check.setContentType(request.getContentType());
        check.setRiskScore(request.getRiskScore());
        check.setQualityScore(request.getQualityScore());
        check.setDetectedIssues(request.getDetectedIssues());
        check.setAiStatus(request.getAiStatus());
        check.setRecommendation(request.getRecommendation());
        return toResponse(contentCheckRepository.save(check));
    }

    public List<ContentCheckResponse> findAll() {
        return contentCheckRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ContentCheckResponse update(Long id, ContentCheckRequest request) {
        ContentCheck check = contentCheckRepository.findById(id).orElseThrow(() -> new RuntimeException("Content check not found"));
        check.setCampaignId(request.getCampaignId());
        check.setContentType(request.getContentType());
        check.setRiskScore(request.getRiskScore());
        check.setQualityScore(request.getQualityScore());
        check.setDetectedIssues(request.getDetectedIssues());
        check.setAiStatus(request.getAiStatus());
        check.setRecommendation(request.getRecommendation());
        return toResponse(contentCheckRepository.save(check));
    }

    public void delete(Long id) {
        ContentCheck check = contentCheckRepository.findById(id).orElseThrow(() -> new RuntimeException("Content check not found"));
        contentCheckRepository.delete(check);
    }

    private ContentCheckResponse toResponse(ContentCheck check) {
        return new ContentCheckResponse(check.getId(), check.getCampaignId(), check.getContentType(), check.getRiskScore(), check.getQualityScore(), check.getDetectedIssues(), check.getAiStatus(), check.getRecommendation(), check.getCheckedAt());
    }
}
