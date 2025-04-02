package com.darok.apirestestudiante.apirestestudiantes.Mappers;

import com.darok.apirestestudiante.apirestestudiantes.Entities.Estudiante;
import com.darok.apirestestudiante.apirestestudiantes.Entities.dto.EstudianteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-02T03:26:05-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class EstudianteMapperImpl implements EstudianteMapper {

    @Override
    public EstudianteDTO toDTO(Estudiante estudiante) {
        if ( estudiante == null ) {
            return null;
        }

        EstudianteDTO estudianteDTO = new EstudianteDTO();

        estudianteDTO.setId( estudiante.getId() );
        estudianteDTO.setNombre( estudiante.getNombre() );
        estudianteDTO.setApellido( estudiante.getApellido() );
        estudianteDTO.setGrado( estudiante.getGrado() );

        return estudianteDTO;
    }

    @Override
    public Estudiante toEntity(EstudianteDTO estudianteDTO) {
        if ( estudianteDTO == null ) {
            return null;
        }

        Estudiante estudiante = new Estudiante();

        estudiante.setId( estudianteDTO.getId() );
        estudiante.setNombre( estudianteDTO.getNombre() );
        estudiante.setApellido( estudianteDTO.getApellido() );
        estudiante.setGrado( estudianteDTO.getGrado() );

        return estudiante;
    }

    @Override
    public List<EstudianteDTO> toDTOList(List<Estudiante> estudiantes) {
        if ( estudiantes == null ) {
            return null;
        }

        List<EstudianteDTO> list = new ArrayList<EstudianteDTO>( estudiantes.size() );
        for ( Estudiante estudiante : estudiantes ) {
            list.add( toDTO( estudiante ) );
        }

        return list;
    }

    @Override
    public List<Estudiante> toEntityList(List<EstudianteDTO> estudiantesDTO) {
        if ( estudiantesDTO == null ) {
            return null;
        }

        List<Estudiante> list = new ArrayList<Estudiante>( estudiantesDTO.size() );
        for ( EstudianteDTO estudianteDTO : estudiantesDTO ) {
            list.add( toEntity( estudianteDTO ) );
        }

        return list;
    }
}
