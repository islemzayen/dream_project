package com.example.symbolservice.controller;

import com.example.symbolservice.dto.SymbolDTO;
import com.example.symbolservice.service.SymbolService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symbols")
public class SymbolController {

    private final SymbolService service;

    public SymbolController(SymbolService service) {
        this.service = service;
    }

    @PostMapping
    public SymbolDTO create(@RequestBody SymbolDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SymbolDTO> getAll() {
        return service.getAll();
    }
}
