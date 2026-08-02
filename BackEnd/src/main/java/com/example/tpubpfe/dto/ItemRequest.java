package com.example.tpubpfe.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @NotBlank(message = "Item name is required")
    private String name;

    private String description;
}
