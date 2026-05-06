package com.laboratorio.streams.repository;

import com.laboratorio.streams.model.entity.Tarea;
import com.laboratorio.streams.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByEstado(Estado estado);

    @Query("SELECT t FROM Tarea t WHERE t.prioridad >= 3")
    List<Tarea> tareasPrioritarias();
}