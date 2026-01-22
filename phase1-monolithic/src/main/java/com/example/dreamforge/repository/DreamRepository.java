package com.example.dreamforge.repository;

import com.example.dreamforge.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream, Long> {
}
