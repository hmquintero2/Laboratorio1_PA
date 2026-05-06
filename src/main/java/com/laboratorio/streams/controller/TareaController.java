package com.laboratorio.streams.controller;

import com.laboratorio.streams.model.entity.Tarea;
import com.laboratorio.streams.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> listar() {
        return service.listar();
    }

    @GetMapping("/resumen")
    public Object resumen() {
        return service.resumen();
    }

    @GetMapping("/{id:\\d+}")
    public Tarea buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return service.crear(tarea);
    }

    @PutMapping("/{id:\\d+}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return service.actualizar(id, tarea);
    }

    @DeleteMapping("/{id:\\d+}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}