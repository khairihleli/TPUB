package com.example.tpubpfe.controller;

import com.example.tpubpfe.dto.CampaignRequest;
import com.example.tpubpfe.dto.CampaignResponse;
import com.example.tpubpfe.service.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CampaignResponse> createCampaign(@Valid @RequestBody CampaignRequest request) {
        return new ResponseEntity<>(campaignService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CampaignResponse>> getAllCampaigns() {
        return ResponseEntity.ok(campaignService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignResponse> updateCampaign(@PathVariable Long id, @Valid @RequestBody CampaignRequest request) {
        return ResponseEntity.ok(campaignService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        campaignService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
