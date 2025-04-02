package com.darok.apirestestudiante.apirestestudiantes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darok.apirestestudiante.apirestestudiantes.Entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
