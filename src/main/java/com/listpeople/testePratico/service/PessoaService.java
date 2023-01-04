package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.Pessoa;
import com.listpeople.testePratico.exception.ObjectNotFoundException;
import com.listpeople.testePratico.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarPessoas(){
        var lista = pessoaRepository.findAll();
        return lista;
    }

    @Transactional
    public Pessoa criarPessoas(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa BuscarPorCodigo(Long codigo){
        Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);
        return pessoa.orElseThrow(() -> new ObjectNotFoundException("Codigo de usuario não encontrado"));

    }
}
