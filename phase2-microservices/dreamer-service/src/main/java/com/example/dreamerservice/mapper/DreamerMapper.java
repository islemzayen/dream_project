package com.example.dreamerservice.mapper;

import com.example.dreamerservice.dto.DreamerDTO;
import com.example.dreamerservice.entity.Dreamer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DreamerMapper {

    DreamerDTO toDTO(Dreamer dreamer);

    Dreamer toEntity(DreamerDTO dto);
}
