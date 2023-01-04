package com.listpeople.testePratico.repository;

import com.listpeople.testePratico.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
