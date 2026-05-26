package com.github.nicolealves.montadora.controller;

import com.github.nicolealves.montadora.dto.request.MontadoraRequestDTO;
import com.github.nicolealves.montadora.dto.response.MontadoraResponseDTO;
import com.github.nicolealves.montadora.mapper.MontadoraMapper;
import com.github.nicolealves.montadora.model.Montadora;
import com.github.nicolealves.montadora.repository.MontadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/montadoras")
public class MontadoraController {

    @Autowired
    private MontadoraRepository repository;

    @Autowired
    private MontadoraMapper mapper;

    @PostMapping
    public ResponseEntity<MontadoraResponseDTO> create(@RequestBody MontadoraRequestDTO dto) {
        Montadora montadora = mapper.toEntity(dto);
        Montadora saved = repository.save(montadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MontadoraResponseDTO> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(montadora -> ResponseEntity.ok(mapper.toResponse(montadora)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MontadoraResponseDTO>> findAll() {
        List<MontadoraResponseDTO> response = repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MontadoraResponseDTO> update(@PathVariable Long id, @RequestBody MontadoraRequestDTO dto) {
        Optional<Montadora> optMontadora = repository.findById(id);

        if (optMontadora.isPresent()) {
            Montadora montadora = mapper.toEntity(dto);
            montadora.setId(id);
            Montadora updated = repository.save(montadora);
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
