package com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.api.modelo.Projeto;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    List<Projeto> findByDescricao(String descricao);
}