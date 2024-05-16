package com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.api.modelo.Projeto;
import com.projeto.api.repositorio.ProjetoRepositorio;

import java.util.List;

@Service
public class ProjetoServico {

    @Autowired
    private ProjetoRepositorio projetoRepositorio;

    public List<Projeto> buscarPorDescricao(String descricao) {
        return projetoRepositorio.findByDescricao(descricao);
    }

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepositorio.save(projeto);
    }
}