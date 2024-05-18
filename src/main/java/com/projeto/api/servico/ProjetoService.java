package com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.api.modelo.Projeto;
import com.projeto.api.repositorio.ProjetoRepository;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> buscarPorDescricao(String descricao) {
        return projetoRepository.findByDescricao(descricao);
    }

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
}