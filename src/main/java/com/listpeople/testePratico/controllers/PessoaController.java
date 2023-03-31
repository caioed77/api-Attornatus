package com.listpeople.testePratico.controllers;


import com.listpeople.testePratico.entities.DTO.PessoaDTO;
import com.listpeople.testePratico.entities.Pessoa;
import com.listpeople.testePratico.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas/")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<PessoaDTO>> listarTodasPessoas(){
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping(value = "/codigoPessoa/{codigo}")
    public ResponseEntity<PessoaDTO> PessoaPorCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok().body(pessoaService.BuscarPorCodigo(codigo));
    }
    
    @PostMapping(value = "/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody PessoaDTO pessoa) {
        return ResponseEntity.ok(pessoaService.criarPessoa(pessoa));
    }

    @PostMapping(value = "/atualizar/{codigo}")
    public ResponseEntity<Pessoa> atualizarPessoa(
            @PathVariable Long codigo,
            @RequestBody Pessoa obj) {
        obj = pessoaService.alterarPessoa(codigo, obj);
        return ResponseEntity.ok().body(obj);

    }

}
