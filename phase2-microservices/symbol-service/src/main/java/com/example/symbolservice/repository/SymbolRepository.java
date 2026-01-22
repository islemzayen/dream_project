package com.example.symbolservice.repository;

import com.example.symbolservice.entity.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolRepository extends JpaRepository<Symbol, Long> {
}
