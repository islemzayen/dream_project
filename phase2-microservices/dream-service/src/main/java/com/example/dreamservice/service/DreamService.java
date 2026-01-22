package com.example.dreamservice.service;

import com.example.dreamservice.dto.DreamDTO;
import com.example.dreamservice.entity.Dream;
import com.example.dreamservice.exception.ResourceNotFoundException;
import com.example.dreamservice.mapper.DreamMapper;
import com.example.dreamservice.repository.DreamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DreamService {

    private final DreamRepository repository;
    private final DreamMapper mapper;

    public DreamService(DreamRepository repository, DreamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DreamDTO create(DreamDTO dto) {
        Dream dream = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(dream));
    }

    public DreamDTO getById(Long id) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dream not found"));
        return mapper.toDTO(dream);
    }

    public List<DreamDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public DreamDTO update(Long id, DreamDTO dto) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dream not found"));

        dream.setTitle(dto.getTitle());
        dream.setDescription(dto.getDescription());
        dream.setDreamerId(dto.getDreamerId());

        return mapper.toDTO(repository.save(dream));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


