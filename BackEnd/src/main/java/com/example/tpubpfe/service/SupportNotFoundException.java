package com.example.tpubpfe.service;

public class SupportNotFoundException extends RuntimeException {
    public SupportNotFoundException(Long id) {
        super("Support not found with id: " + id);
    }
}
