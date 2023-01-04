package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.Endereco;
import com.listpeople.testePratico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos(){
        var listaEndereco = enderecoRepository.findAll();
        return listaEndereco;
    }

    @Transactional
    public Endereco criarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

}
