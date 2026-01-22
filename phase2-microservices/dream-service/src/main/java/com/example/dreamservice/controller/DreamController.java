package com.example.dreamservice.controller;

import com.example.dreamservice.dto.DreamDTO;
import com.example.dreamservice.service.DreamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dreams")
public class DreamController {

    private final DreamService service;

    public DreamController(DreamService service) {
        this.service = service;
    }

    // ✅ POST dream
    @PostMapping
    public DreamDTO create(@Valid @RequestBody DreamDTO dto) {
        return service.create(dto);
    }

    // ✅ GET all dreams
    @GetMapping
    public List<DreamDTO> getAll() {
        return service.getAll();
    }

    // ✅ GET dream by ID (THIS FIXES YOUR PROBLEM)
    @GetMapping("/{id}")
    public DreamDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    // ✅ DELETE DREAM
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Dream deleted successfully");
    }
    @PutMapping("/{id}")
    public DreamDTO update(
            @PathVariable Long id,
            @RequestBody DreamDTO dto
    ) {
        return service.update(id, dto);
    }

}
