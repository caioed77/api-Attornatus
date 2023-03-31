package com.listpeople.testePratico.entities.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean enderecoPrincipal;

    public EnderecoDTO(Long id, String logradouro, String cep, Integer numero, String cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.numero = numero;
    }
}
