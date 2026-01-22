package com.example.dreamservice.repository;

import com.example.dreamservice.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream, Long> {
}
