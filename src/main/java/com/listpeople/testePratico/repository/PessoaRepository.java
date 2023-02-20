package com.listpeople.testePratico.repository;

import com.listpeople.testePratico.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("Select p from Pessoa p")
    List<Pessoa> listaTodos();

}
