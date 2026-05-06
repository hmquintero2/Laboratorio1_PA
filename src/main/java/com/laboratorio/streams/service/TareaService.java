package com.laboratorio.streams.service;

import com.laboratorio.streams.model.entity.Tarea;
import java.util.List;
import java.util.Map;

public interface TareaService {

    List<Tarea> listar();

    Tarea buscarPorId(Long id);

    Tarea crear(Tarea tarea);

    Tarea actualizar(Long id, Tarea tarea);

    void eliminar(Long id);

    Map<String, Long> resumen();
}