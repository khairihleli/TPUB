package com.example.tpubpfe.service;

public class ZoneNotFoundException extends RuntimeException {
    public ZoneNotFoundException(Long id) {
        super("Zone not found with id: " + id);
    }
}
