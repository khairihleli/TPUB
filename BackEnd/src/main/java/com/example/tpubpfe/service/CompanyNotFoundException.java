package com.example.tpubpfe.service;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Long id) {
        super("Company not found with id: " + id);
    }
}
