package com.listpeople.testePratico.Controllers;


import com.listpeople.testePratico.entities.Pessoa;
import com.listpeople.testePratico.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodasPessoas(){
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<Pessoa> PessoaPorCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok(pessoaService.BuscarPorCodigo(codigo));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoas(pessoa);
    }
}
