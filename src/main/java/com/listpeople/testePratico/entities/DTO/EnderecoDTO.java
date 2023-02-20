package com.listpeople.testePratico.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
}
