package com.krakedev.examen.vuelos.services;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    private final VueloRepository repository;

    public VueloService(VueloRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> guardar(Vuelo vuelo) {
        try {
            Vuelo nuevo = repository.save(vuelo);
            return new ResponseEntity<>(
                    nuevo,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error al guardar vuelo",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    public ResponseEntity<?> listar() {
        try {
            List<Vuelo> vuelos = repository.findAll();
            return new ResponseEntity<>(
                    vuelos,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error al listar vuelos",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    public ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Vuelo> vuelo = repository.findById(id);
        if(vuelo.isPresent()) {

            return new ResponseEntity<>(
                    vuelo.get(),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Vuelo no encontrado",
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<?> actualizar(Integer id, Vuelo vuelo) {
        Optional<Vuelo> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Vuelo actual = encontrado.get();
            actual.setCodigo(vuelo.getCodigo());
            actual.setPrecioBoleto(vuelo.getPrecioBoleto());
            actual.setAsientosDisponibles(vuelo.getAsientosDisponibles());
            actual.setDestino(vuelo.getDestino());
            repository.save(actual);
            return new ResponseEntity<>(
                    actual,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                "Vuelo no encontrado",
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<?> eliminar(Integer id) {

        Optional<Vuelo> vuelo = repository.findById(id);

        if(vuelo.isPresent()) {

            repository.deleteById(id);

            return new ResponseEntity<>(
                    "Vuelo eliminado",
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Vuelo no encontrado",
                HttpStatus.NOT_FOUND
        );
    }
}