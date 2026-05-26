package com.github.nicolealves.montadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloRequestDTO {

    private Long id;
    private String nome;
    private String franquia;
    private String classificacao;
    private String fabricante;
}
