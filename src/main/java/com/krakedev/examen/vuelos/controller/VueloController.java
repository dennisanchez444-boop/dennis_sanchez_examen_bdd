package com.krakedev.examen.vuelos.controller;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.services.VueloService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService service;

    public VueloController(VueloService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Vuelo vuelo) {
        return service.guardar(vuelo);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @RequestBody Vuelo vuelo
    ) {
        return service.actualizar(id, vuelo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id);
    }
}