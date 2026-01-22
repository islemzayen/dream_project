package com.example.dreamforge.mapper;

import com.example.dreamforge.dto.DreamDTO;
import com.example.dreamforge.entity.Dream;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DreamMapper {

    @Mapping(target = "dreamer", ignore = true)
    Dream toEntity(DreamDTO dto);

    @Mapping(source = "dreamer.id", target = "dreamerId")
    DreamDTO toDTO(Dream dream);
}
