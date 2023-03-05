package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.DTO.EnderecoDTO;
import com.listpeople.testePratico.entities.Endereco;
import com.listpeople.testePratico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoDTO> listarEnderecos() {
        var enderecos  = enderecoRepository.listarEnderecos();
        return enderecos.stream().map(this::fromEndereco).collect(Collectors.toList());
    }

    @Transactional
    public Endereco criarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    protected EnderecoDTO fromEndereco(Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep()).build();
    }

}
