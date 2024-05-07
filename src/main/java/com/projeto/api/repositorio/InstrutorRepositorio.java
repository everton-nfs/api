package com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.api.modelo.Instrutor;

public interface InstrutorRepositorio extends JpaRepository<Instrutor, Integer> {

}