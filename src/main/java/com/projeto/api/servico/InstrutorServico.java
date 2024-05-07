package com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.api.modelo.Instrutor;
import com.projeto.api.repositorio.InstrutorRepositorio;

@Service
public class InstrutorServico {

    @Autowired
    private InstrutorRepositorio instrutorRepositorio;

    public Instrutor criarInstrutor(Instrutor instrutor) {
        return instrutorRepositorio.save(instrutor);
    }
}