package com.github.nicolealves.montadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloResponseDTO {

    private Long id;
    private String nome;
    private String franquia;
    private String classificacao;
    private String fabricante;
}
