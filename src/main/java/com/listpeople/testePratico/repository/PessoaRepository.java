package com.listpeople.testePratico.repository;

import com.listpeople.testePratico.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Modifying
    @Query(value = "update tb_endereco_pessoa u set u.pessoa_id = :ps_id, u.endereco_id = :en_id;", nativeQuery = true)
    Pessoa PreencherTBPessoaEndereco(@Param("ps_id") Integer pessoa_id, @Param("en_id") Integer endereco_id);

}
