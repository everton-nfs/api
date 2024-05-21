package com.projeto.api.repositorio;

import com.projeto.api.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByStatus(String status);
}
