package com.example.symbolservice.mapper;

import com.example.symbolservice.dto.SymbolDTO;
import com.example.symbolservice.entity.Symbol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SymbolMapper {
    Symbol toEntity(SymbolDTO dto);
    SymbolDTO toDTO(Symbol entity);
}
