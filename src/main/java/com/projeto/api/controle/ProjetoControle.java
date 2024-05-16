package com.projeto.api.controle;

import com.projeto.api.modelo.Projeto;
import com.projeto.api.servico.ProjetoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projeto-controle")
public class ProjetoControle {

    @Autowired
    private ProjetoServico projetoServico;

    @GetMapping("/buscar/projeto/descricao/{descricao}")
    public ResponseEntity<List<Projeto>> buscarPorDescricao(@PathVariable String descricao) {
        List<Projeto> projetos = projetoServico.buscarPorDescricao(descricao);
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/salvar/projeto")
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
      Projeto novoProjeto = projetoServico.criarProjeto(projeto);
      return ResponseEntity.ok(novoProjeto);
    }
}
