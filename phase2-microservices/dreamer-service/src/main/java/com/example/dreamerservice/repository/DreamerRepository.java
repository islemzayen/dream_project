package com.example.dreamerservice.repository;

import com.example.dreamerservice.entity.Dreamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamerRepository extends JpaRepository<Dreamer, Long> {
}
