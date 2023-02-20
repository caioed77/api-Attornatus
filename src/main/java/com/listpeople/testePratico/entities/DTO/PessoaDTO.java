package com.listpeople.testePratico.entities.DTO;

import com.listpeople.testePratico.entities.Endereco;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PessoaDTO {

    private Long codigo;
    private String nome;
    private String dataNascimento;
    private List<EnderecoDTO> endereco;
}
