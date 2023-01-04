package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.Pessoa;
import com.listpeople.testePratico.exception.ObjectNotFoundException;
import com.listpeople.testePratico.exception.ResouceNotFoundException;
import com.listpeople.testePratico.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.persistence.EntityNotFoundException;
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

    @Transactional
    public Pessoa alterarPessoa(Long codigo, Pessoa obj){
        try {
            Pessoa dadosAtt = pessoaRepository.getReferenceById(codigo);
            updateData(dadosAtt, obj);
            return pessoaRepository.save(dadosAtt);
        } catch (EntityNotFoundException e){
            throw new ResouceNotFoundException(codigo);
        }
    }
    private void updateData(Pessoa entity, Pessoa obj){
        entity.setNome(obj.getNome());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setEndereco(obj.getEndereco());
    }

    public Pessoa AdicionarEndereco(Integer pessoa_id, Integer endereco_id){
        return pessoaRepository.PreencherTBPessoaEndereco(pessoa_id, endereco_id);
    }

}
