package com.laboratorio.streams.service.impl;

import com.laboratorio.streams.model.entity.Estado;
import com.laboratorio.streams.model.entity.Tarea;
import com.laboratorio.streams.repository.TareaRepository;
import com.laboratorio.streams.service.TareaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository repository;

    public TareaServiceImpl(TareaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tarea> listar() {
        return repository.findAll();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    @Override
    public Tarea crear(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    public Tarea actualizar(Long id, Tarea tarea) {
        Tarea existente = buscarPorId(id);

        existente.setTitulo(tarea.getTitulo());
        existente.setDescripcion(tarea.getDescripcion());
        existente.setEstado(tarea.getEstado());
        existente.setPrioridad(tarea.getPrioridad());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    //  AQUÍ ESTABA EL ERROR
    @Override
    public Map<String, Long> resumen() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        t -> t.getEstado().name(),
                        Collectors.counting()
                ));
    }
}