package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneResponse {
    private Long id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Double radiusKm;
    private String city;
}
