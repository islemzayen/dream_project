package com.example.symbolservice.controller;

import com.example.symbolservice.dto.SymbolDTO;
import com.example.symbolservice.service.SymbolService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symbols")
public class SymbolController {

    private final SymbolService service;

    public SymbolController(SymbolService service) {
        this.service = service;
    }

    @PostMapping
    public SymbolDTO create(@Valid @RequestBody SymbolDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SymbolDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SymbolDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
