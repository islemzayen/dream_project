package com.example.dreamservice.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "dreamer_id", nullable = false)
    private Long dreamerId;
}
