package com.github.nicolealves.montadora.mapper;

import com.github.nicolealves.montadora.dto.request.MontadoraRequestDTO;
import com.github.nicolealves.montadora.dto.response.MontadoraResponseDTO;
import com.github.nicolealves.montadora.model.Montadora;
import org.springframework.stereotype.Component;

@Component
public class MontadoraMapper {

    public Montadora toEntity(MontadoraRequestDTO dto) {
        Montadora montadora = new Montadora();
        montadora.setId(dto.getId());
        montadora.setNome(dto.getNome());
        montadora.setPais(dto.getPais());
        montadora.setRamo(dto.getRamo());
        montadora.setSede(dto.getSede());
        return montadora;
    }

    public MontadoraResponseDTO toResponse(Montadora montadora) {
        MontadoraResponseDTO dto = new MontadoraResponseDTO();
        dto.setId(montadora.getId());
        dto.setNome(montadora.getNome());
        dto.setPais(montadora.getPais());
        dto.setRamo(montadora.getRamo());
        dto.setSede(montadora.getSede());
        return dto;
    }
}
