package com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.api.modelo.Instrutor;
import com.projeto.api.repositorio.InstrutorRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorServico {

    @Autowired
    private InstrutorRepositorio instrutorRepositorio;

    public Instrutor criarInstrutor(Instrutor instrutor) {
        return instrutorRepositorio.save(instrutor);
    }

    public List<Instrutor> listarTodos() {
      return instrutorRepositorio.findAll();
    }

    public Instrutor obterPorId(int id) {
        Optional<Instrutor> instrutor = instrutorRepositorio.findById(id);
        return instrutor.orElse(null);
    }

    public Instrutor atualizarInstrutor(int id, Instrutor detalhesInstrutor) {
        return instrutorRepositorio.findById(id).map(instrutor -> {
            instrutor.setNome(detalhesInstrutor.getNome());
            instrutor.setRG(detalhesInstrutor.getRG());
            instrutor.setNascimento(detalhesInstrutor.getNascimento());
            instrutor.setTitulacao(detalhesInstrutor.getTitulacao());
            return instrutorRepositorio.save(instrutor);
        }).orElse(null);
    }

    public boolean deletarInstrutor(int id) {
        return instrutorRepositorio.findById(id).map(instrutor -> {
            instrutorRepositorio.delete(instrutor);
            return true;
        }).orElse(false);
    }
}