package com.example.dreamforge.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Symbol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Symbol name is required")
    private String name;


    private String meaning;


    @ManyToOne
    @JoinColumn(name = "dream_id")
    private Dream dream;
}