package com.example.tpubpfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportResponse {
    private Long id;
    private String name;
    private String type;
    private Long zoneId;
    private String status;
    private Integer capacity;
}
