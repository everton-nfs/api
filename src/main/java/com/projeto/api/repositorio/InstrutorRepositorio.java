package com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.api.modelo.Instrutor;
import java.util.List;

public interface InstrutorRepositorio extends JpaRepository<Instrutor, Integer> {
    List<Instrutor> findByNome(String nome);

    List<Instrutor> findByRG(int rg);
}