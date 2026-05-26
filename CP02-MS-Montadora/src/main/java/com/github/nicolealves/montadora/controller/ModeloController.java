package com.github.nicolealves.montadora.controller;

import com.github.nicolealves.montadora.dto.request.ModeloRequestDTO;
import com.github.nicolealves.montadora.dto.response.ModeloResponseDTO;
import com.github.nicolealves.montadora.mapper.ModeloMapper;
import com.github.nicolealves.montadora.model.Modelo;
import com.github.nicolealves.montadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository repository;

    @Autowired
    private ModeloMapper mapper;

    @PostMapping
    public ResponseEntity<ModeloResponseDTO> create(@RequestBody ModeloRequestDTO dto) {
        Modelo modelo = mapper.toEntity(dto);
        Modelo saved = repository.save(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponseDTO> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(modelo -> ResponseEntity.ok(mapper.toResponse(modelo)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ModeloResponseDTO>> findAll() {
        List<ModeloResponseDTO> response = repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloResponseDTO> update(@PathVariable Long id, @RequestBody ModeloRequestDTO dto) {
        Optional<Modelo> optModelo = repository.findById(id);

        if (optModelo.isPresent()) {
            Modelo modelo = mapper.toEntity(dto);
            modelo.setId(id);
            Modelo updated = repository.save(modelo);
            return ResponseEntity.ok(mapper.toResponse(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
