package com.example.dreamforge.repository;

import com.example.dreamforge.entity.Dreamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamerRepository extends JpaRepository<Dreamer, Long> {
}
