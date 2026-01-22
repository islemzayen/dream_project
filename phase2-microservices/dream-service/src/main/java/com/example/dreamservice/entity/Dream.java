package com.example.dreamservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    // foreign key only
    @Column(nullable = false)
    private Long dreamerId;
}
