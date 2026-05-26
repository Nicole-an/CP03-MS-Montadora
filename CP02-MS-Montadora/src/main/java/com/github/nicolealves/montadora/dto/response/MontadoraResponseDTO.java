package com.github.nicolealves.montadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MontadoraResponseDTO {

    private Long id;
    private String nome;
    private String pais;
    private String ramo;
    private String sede;
}
