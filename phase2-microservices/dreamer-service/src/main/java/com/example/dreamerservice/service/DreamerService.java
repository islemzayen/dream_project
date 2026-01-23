package com.example.dreamerservice.service;

import com.example.dreamerservice.dto.DreamerDTO;
import com.example.dreamerservice.entity.Dreamer;
import com.example.dreamerservice.exception.ResourceNotFoundException;
import com.example.dreamerservice.mapper.DreamerMapper;
import com.example.dreamerservice.repository.DreamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreamerService {

    private final DreamerRepository repository;
    private final DreamerMapper mapper;

    public DreamerService(DreamerRepository repository, DreamerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // ✅ CREATE
    public DreamerDTO create(DreamerDTO dto) {
        Dreamer dreamer = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(dreamer));
    }

    // ✅ GET ALL
    public List<DreamerDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    // ✅ GET BY ID (USED BY FEIGN)
    public DreamerDTO getById(Long id) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));
        return mapper.toDTO(dreamer);
    }

    // ✅ UPDATE
    public DreamerDTO update(Long id, DreamerDTO dto) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));

        dreamer.setName(dto.getName());
        dreamer.setEmail(dto.getEmail());

        return mapper.toDTO(repository.save(dreamer));
    }

    // ✅ DELETE
    public void delete(Long id) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));
        repository.delete(dreamer);
    }
}
