package com.listpeople.testePratico.controllers;

import com.listpeople.testePratico.entities.DTO.EnderecoDTO;
import com.listpeople.testePratico.entities.Pessoa;
import com.listpeople.testePratico.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    private PessoaService pessoaService;

    public EnderecoController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<EnderecoDTO>> listarTodosEnderecos(){
        return ResponseEntity.ok(pessoaService.listarEnderecos());
    }

    @PostMapping(value = "/novoEndereco")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> criarNovoEndereco(@RequestParam Long codigoEndereco, @RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok().body(pessoaService.criarEndereco(codigoEndereco, enderecoDTO));
    }

    @PostMapping(value = "/enderecoPadrao")
    public ResponseEntity<?> enderecoPrincipal(@RequestParam Long codigoPessoa, @RequestParam Long codigoEndereco){
      return ResponseEntity.ok(pessoaService.definirEnderecoPrincipal(codigoPessoa, codigoEndereco));

    }

}
