package com.example.dreamservice.service;

import com.example.dreamservice.client.DreamerClient;
import com.example.dreamservice.dto.DreamDTO;
import com.example.dreamservice.entity.Dream;
import com.example.dreamservice.exception.ResourceNotFoundException;
import com.example.dreamservice.mapper.DreamMapper;
import com.example.dreamservice.repository.DreamRepository;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreamService {

    private final DreamRepository repository;
    private final DreamMapper mapper;
    private final DreamerClient dreamerClient;

    public DreamService(
            DreamRepository repository,
            DreamMapper mapper,
            DreamerClient dreamerClient
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.dreamerClient = dreamerClient;
    }

    public DreamDTO create(DreamDTO dto) {

        if (dto.getDreamerId() == null) {
            throw new IllegalArgumentException("dreamerId is required");
        }

        // ✅ Check dreamer exists via Feign
      validateDreamer(dto.getDreamerId());

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

        if (dto.getDreamerId() == null) {
            throw new IllegalArgumentException("dreamerId is required");
        }

        // ✅ Validate dreamer again
        validateDreamer(dto.getDreamerId());

        dream.setTitle(dto.getTitle());
        dream.setDescription(dto.getDescription());
        dream.setDreamerId(dto.getDreamerId());

        return mapper.toDTO(repository.save(dream));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔒 Centralized Feign validation
    private void validateDreamer(Long dreamerId) {
        try {
            dreamerClient.checkDreamerExists(dreamerId);
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Dreamer not found with id " + dreamerId);
        }
    }
}
