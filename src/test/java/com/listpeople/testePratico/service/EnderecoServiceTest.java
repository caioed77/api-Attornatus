package com.listpeople.testePratico.service;


import com.listpeople.testePratico.entities.Endereco;
import com.listpeople.testePratico.entities.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class EnderecoServiceTest {

    @Test
    @DisplayName("Deve salvar um novo endereço")
    public void saveEnderecoTest() {
        Endereco endereco = Endereco.builder()
                .id(1L)
                .cep("35533079")
                .cidade("nova serrana")
                .logradouro("casa")
                .numero(368)
                .build();
        
        Assertions.assertThat(endereco.getId()).isNotNull();
        Assertions.assertThat(endereco.getCep()).isEqualTo("35533079");
        Assertions.assertThat(endereco.getLogradouro()).isEqualTo("casa");
        Assertions.assertThat(endereco.getCidade()).isEqualTo("nova serrana");
    }


}
