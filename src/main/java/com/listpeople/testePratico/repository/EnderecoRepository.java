package com.listpeople.testePratico.repository;

import com.listpeople.testePratico.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "select e from Endereco e")
    List<Endereco> listarEnderecos();
}
