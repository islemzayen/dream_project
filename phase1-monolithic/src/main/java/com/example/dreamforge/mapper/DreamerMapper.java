package com.example.dreamforge.mapper;

import com.example.dreamforge.dto.DreamerDTO;
import com.example.dreamforge.entity.Dreamer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DreamerMapper {

    DreamerDTO toDTO(Dreamer dreamer);

    Dreamer toEntity(DreamerDTO dto);
}
