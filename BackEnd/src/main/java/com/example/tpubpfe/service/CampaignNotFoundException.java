package com.example.tpubpfe.service;

public class CampaignNotFoundException extends RuntimeException {
    public CampaignNotFoundException(Long id) {
        super("Campaign not found with id: " + id);
    }
}
