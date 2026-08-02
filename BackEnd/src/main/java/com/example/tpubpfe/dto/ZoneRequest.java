package com.example.tpubpfe.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneRequest {

    @NotBlank(message = "Zone name is required")
    private String name;

    private String description;

    private Double latitude;

    private Double longitude;

    private Double radiusKm;

    private String city;
}
