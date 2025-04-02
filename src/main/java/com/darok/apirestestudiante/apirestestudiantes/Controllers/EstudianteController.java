package com.darok.apirestestudiante.apirestestudiantes.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.darok.apirestestudiante.apirestestudiantes.Entities.Estudiante;
import com.darok.apirestestudiante.apirestestudiantes.Entities.dto.EstudianteDTO;
import com.darok.apirestestudiante.apirestestudiantes.Mappers.EstudianteMapper;
import com.darok.apirestestudiante.apirestestudiantes.Repositories.EstudianteRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@RestController
@RequestMapping("/Estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @GetMapping("/getAll")
    public List<EstudianteDTO> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteMapper.toDTOList(estudiantes);
    }

    @GetMapping("/getOne/{id}")
    public EstudianteDTO obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));
        return estudianteMapper.toDTO(estudiante);
    }

    @PostMapping("/postIt")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteDTO);
        Estudiante nuevoEstudiante = estudianteRepository.save(estudiante);

        return ResponseEntity.status(HttpStatus.CREATED).body(EstudianteMapper.INSTANCE.toDTO(nuevoEstudiante));
    }

    @PutMapping("updateIt/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id,
            @RequestBody EstudianteDTO detallesEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));

        estudiante.setNombre(detallesEstudiante.getNombre());
        estudiante.setApellido(detallesEstudiante.getApellido());
        estudiante.setGrado(detallesEstudiante.getGrado());

        estudianteRepository.save(estudiante);

        return ResponseEntity.ok(EstudianteMapper.INSTANCE.toDTO(estudiante)); // mandamos el codigo 200 OK
    }

    @DeleteMapping("deleteOne/{id}")
    public ResponseEntity<Void> borrarEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));

        estudianteRepository.delete(estudiante);

        return ResponseEntity.noContent().build(); // Devolvemos el codigo 204 como No Content
    }

    // INCISO A PUT CON GET
    @GetMapping("/getOneUpdated/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudianteYMostrar(@PathVariable Long id,
            @RequestBody EstudianteDTO detallesEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el estudiante con el ID " + id));

        estudiante.setNombre(detallesEstudiante.getNombre());
        estudiante.setApellido(detallesEstudiante.getApellido());
        estudiante.setGrado(detallesEstudiante.getGrado());

        estudianteRepository.save(estudiante);
        EstudianteMapper.INSTANCE.toDTO(estudiante);

        return ResponseEntity.ok(estudianteMapper.toDTO(estudiante)); // mandamos el codigo 200 OK
    }
    //

    //

}
