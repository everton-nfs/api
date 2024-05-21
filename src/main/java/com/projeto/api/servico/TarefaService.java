package com.projeto.api.servico;

import com.projeto.api.modelo.Recurso;
import com.projeto.api.modelo.Tarefa;
import com.projeto.api.repositorio.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> buscarPorStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
}
