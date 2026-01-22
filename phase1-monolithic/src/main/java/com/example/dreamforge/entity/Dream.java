package com.example.dreamforge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;

    private int emotionalScore;

    // Many dreams belong to one dreamer
    @ManyToOne
    @JoinColumn(name = "dreamer_id")
    private Dreamer dreamer;

    // One dream can have many symbols
    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL)
    private List<Symbol> symbols;
}
