package com.darok.apirestestudiante.apirestestudiantes.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.darok.apirestestudiante.apirestestudiantes.Entities.Estudiante;
import com.darok.apirestestudiante.apirestestudiantes.Entities.dto.EstudianteDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "id", target = "id")
    EstudianteDTO toDTO(Estudiante estudiante);

    @Mapping(source = "id", target = "id")
    Estudiante toEntity(EstudianteDTO estudianteDTO);

    List<EstudianteDTO> toDTOList(List<Estudiante> estudiantes);

    List<Estudiante> toEntityList(List<EstudianteDTO> estudiantesDTO);
}
