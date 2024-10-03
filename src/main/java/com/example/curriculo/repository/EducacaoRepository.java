package com.example.curriculo.repository;

import com.example.curriculo.model.Educacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
}
