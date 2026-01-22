package com.example.dreamservice.mapper;

import com.example.dreamservice.dto.DreamDTO;
import com.example.dreamservice.entity.Dream;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DreamMapper {

    DreamDTO toDTO(Dream dream);

    Dream toEntity(DreamDTO dto);
}
