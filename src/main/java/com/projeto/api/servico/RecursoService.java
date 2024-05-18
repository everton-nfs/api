package com.projeto.api.servico;

import com.projeto.api.modelo.Recurso;
import com.projeto.api.repositorio.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> buscarPorNome(String nome) {
        return recursoRepository.findByNome(nome);
    }

    public Recurso criarRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }
}
