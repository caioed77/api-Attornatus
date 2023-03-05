package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.Endereco;
import com.listpeople.testePratico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarEnderecos(){
        var enderecos = enderecoRepository.listarEnderecos();
        return enderecos;
    }

    @Transactional
    public Endereco criarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

}
