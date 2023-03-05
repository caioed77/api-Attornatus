package com.listpeople.testePratico.controllers;

import com.listpeople.testePratico.entities.Endereco;
import com.listpeople.testePratico.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> criarNovoEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoService.criarEndereco(endereco));
    }

}
