package com.example.dreamerservice.controller;

import com.example.dreamerservice.dto.DreamerDTO;
import com.example.dreamerservice.service.DreamerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dreamers")
public class DreamerController {

    private final DreamerService service;

    public DreamerController(DreamerService service) {
        this.service = service;
    }

    @PostMapping
    public DreamerDTO create(@Valid @RequestBody DreamerDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<DreamerDTO> getAll() {
        return service.getAll();
    }

    // ✅ ADD THIS
    @GetMapping("/{id}")
    public DreamerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Dreamer deleted successfully");
    }
    @PutMapping("/{id}")
    public DreamerDTO update(
            @PathVariable Long id,
            @Valid @RequestBody DreamerDTO dto
    ) {
        return service.update(id, dto);
    }


}
