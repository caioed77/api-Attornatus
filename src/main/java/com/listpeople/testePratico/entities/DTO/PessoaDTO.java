package com.listpeople.testePratico.entities.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PessoaDTO {
    private Long codigo;
    private String nome;
    private String dataNascimento;
    private List<EnderecoDTO> endereco;

}
