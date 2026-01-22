package com.example.dreamerservice.service;

import com.example.dreamerservice.dto.DreamerDTO;
import com.example.dreamerservice.entity.Dreamer;
import com.example.dreamerservice.exception.ResourceNotFoundException;
import com.example.dreamerservice.mapper.DreamerMapper;
import com.example.dreamerservice.repository.DreamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DreamerService {

    private final DreamerRepository repository;
    private final DreamerMapper mapper;

    public DreamerService(DreamerRepository repository, DreamerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DreamerDTO create(DreamerDTO dto) {
        Dreamer dreamer = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(dreamer));
    }

    public List<DreamerDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ ADD THIS (for controller)
    public DreamerDTO getById(Long id) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));
        return mapper.toDTO(dreamer);
    }


    // ✅ KEEP THIS (for other services, e.g. DreamService)
    public Dreamer getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));
    }
    public void delete(Long id) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));
        repository.delete(dreamer);
    }
    public DreamerDTO update(Long id, DreamerDTO dto) {
        Dreamer dreamer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dreamer not found"));

        // update fields
        dreamer.setName(dto.getName());
        dreamer.setEmail(dto.getEmail());

        return mapper.toDTO(repository.save(dreamer));
    }

}
