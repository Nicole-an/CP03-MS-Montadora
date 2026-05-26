package com.github.nicolealves.montadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MontadoraRequestDTO {

    private Long id;
    private String nome;
    private String pais;
    private String ramo;
    private String sede;
}
