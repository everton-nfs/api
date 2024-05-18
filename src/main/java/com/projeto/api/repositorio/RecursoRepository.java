package com.projeto.api.repositorio;

import com.projeto.api.modelo.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    List<Recurso> findByNome(String nome);
}