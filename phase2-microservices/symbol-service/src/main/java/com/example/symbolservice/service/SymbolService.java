package com.example.symbolservice.service;

import com.example.symbolservice.dto.SymbolDTO;
import com.example.symbolservice.entity.Symbol;
import com.example.symbolservice.mapper.SymbolMapper;
import com.example.symbolservice.repository.SymbolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymbolService {

    private final SymbolRepository repository;
    private final SymbolMapper mapper;

    public SymbolService(SymbolRepository repository, SymbolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public SymbolDTO create(SymbolDTO dto) {
        Symbol symbol = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(symbol));
    }

    public List<SymbolDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public SymbolDTO getById(Long id) {
        Symbol symbol = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Symbol not found"));
        return mapper.toDTO(symbol);
    }
}
