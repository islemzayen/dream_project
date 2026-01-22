package com.example.dreamforge.service;

import com.example.dreamforge.dto.DreamDTO;
import com.example.dreamforge.entity.Dream;
import com.example.dreamforge.entity.Dreamer;
import com.example.dreamforge.exception.ResourceNotFoundException;
import com.example.dreamforge.mapper.DreamMapper;
import com.example.dreamforge.repository.DreamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DreamService {

    private final DreamRepository repository;
    private final DreamMapper mapper;
    private final DreamerService dreamerService;

    public DreamService(
            DreamRepository repository,
            DreamMapper mapper,
            DreamerService dreamerService
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.dreamerService = dreamerService;
    }

    public DreamDTO create(DreamDTO dto) {
        Dream dream = mapper.toEntity(dto);

        // ✅ LOAD DREAMER SAFELY
        Dreamer dreamer = dreamerService.getEntity(dto.getDreamerId());
        dream.setDreamer(dreamer);

        return mapper.toDTO(repository.save(dream));
    }
    public DreamDTO getById(Long id) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dream not found"));
        return mapper.toDTO(dream);
    }
    public void delete(Long id) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dream not found"));
        repository.delete(dream);
    }




    public List<DreamDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    public DreamDTO update(Long id, DreamDTO dto) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dream not found"));

        // update fields
        dream.setTitle(dto.getTitle());
        dream.setDescription(dto.getDescription());

        // optional: update dreamer
        if (dto.getDreamerId() != null) {
            Dreamer dreamer = dreamerService.getEntity(dto.getDreamerId());
            dream.setDreamer(dreamer);
        }

        return mapper.toDTO(repository.save(dream));
    }

}
