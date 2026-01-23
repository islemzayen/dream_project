package com.example.dreamerservice.mapper;

import com.example.dreamerservice.dto.DreamerDTO;
import com.example.dreamerservice.entity.Dreamer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DreamerMapper {

    Dreamer toEntity(DreamerDTO dto);

    DreamerDTO toDTO(Dreamer entity);
}
