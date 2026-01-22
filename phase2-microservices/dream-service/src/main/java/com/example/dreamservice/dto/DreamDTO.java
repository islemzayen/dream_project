package com.example.dreamservice.dto;

import lombok.Data;

@Data
public class DreamDTO {
    private Long id;
    private String title;
    private String description;
    private Long dreamerId;
}
