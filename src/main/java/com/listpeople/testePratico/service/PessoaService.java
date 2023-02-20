package com.listpeople.testePratico.service;

import com.listpeople.testePratico.entities.DTO.EnderecoDTO;
import com.listpeople.testePratico.entities.DTO.PessoaDTO;
import com.listpeople.testePratico.entities.Endereco;
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
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaDTO> listarPessoas(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList.stream().map(x -> PessoaDTO.builder()
                        .codigo(x.getCodigo())
                        .nome(x.getNome())
                        .dataNascimento(x.getDataNascimento())
                        .endereco(x.getEndereco().stream().map(item -> EnderecoDTO.builder()
                                .id(item.getId())
                                .cidade(item.getCidade())
                                .logradouro(item.getLogradouro())
                                .numero(item.getNumero())
                                .cep(item.getCep())
                                .build()).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }


    @Transactional
    public Pessoa criarPessoas(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public PessoaDTO BuscarPorCodigo(Long codigo){
        Optional<Pessoa> pessoaId = pessoaRepository.findById(codigo);
        if (pessoaId.isPresent()){
            Pessoa pessoa = pessoaId.get();
            return PessoaDTO.builder()
                    .codigo(pessoa.getCodigo())
                    .nome(pessoa.getNome())
                    .dataNascimento(pessoa.getDataNascimento())
                    .endereco(pessoa.getEndereco().stream().map(endereco -> new EnderecoDTO(
                            endereco.getId(),
                            endereco.getLogradouro(),
                            endereco.getCep(),
                            endereco.getNumero(),
                            endereco.getCidade()))
                    .collect(Collectors.toList())).build();

        } else {
            throw new ObjectNotFoundException("Codigo da pessoa não encontrado");
        }

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

    @Transactional
    private void updateData(Pessoa entity, Pessoa obj){
        entity.setNome(obj.getNome());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setEndereco(obj.getEndereco());
    }

}
