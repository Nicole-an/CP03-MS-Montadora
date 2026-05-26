package com.github.nicolealves.montadora.mapper;

import com.github.nicolealves.montadora.dto.request.ModeloRequestDTO;
import com.github.nicolealves.montadora.dto.response.ModeloResponseDTO;
import com.github.nicolealves.montadora.model.Modelo;
import org.springframework.stereotype.Component;

@Component
public class ModeloMapper {

    public Modelo toEntity(ModeloRequestDTO dto) {
        Modelo modelo = new Modelo();
        modelo.setId(dto.getId());
        modelo.setNome(dto.getNome());
        modelo.setFranquia(dto.getFranquia());
        modelo.setClassificacao(dto.getClassificacao());
        modelo.setFabricante(dto.getFabricante());
        return modelo;
    }

    public ModeloResponseDTO toResponse(Modelo modelo) {
        ModeloResponseDTO dto = new ModeloResponseDTO();
        dto.setId(modelo.getId());
        dto.setNome(modelo.getNome());
        dto.setFranquia(modelo.getFranquia());
        dto.setClassificacao(modelo.getClassificacao());
        dto.setFabricante(modelo.getFabricante());
        return dto;
    }
}
