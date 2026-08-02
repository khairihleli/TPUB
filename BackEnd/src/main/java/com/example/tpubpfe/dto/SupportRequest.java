package com.example.tpubpfe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportRequest {

    @NotBlank(message = "Support name is required")
    private String name;

    private String type;

    @NotNull(message = "Zone id is required")
    private Long zoneId;

    private String status;

    private Integer capacity;
}
