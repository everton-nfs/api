package com.projeto.api.controle;

import com.projeto.api.modelo.Projeto;
import com.projeto.api.servico.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projeto-controle")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/buscar/projeto/descricao/{descricao}")
    public ResponseEntity<List<Projeto>> buscarPorDescricao(@PathVariable String descricao) {
        List<Projeto> projetos = projetoService.buscarPorDescricao(descricao);
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/salvar/projeto")
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
      Projeto novoProjeto = projetoService.criarProjeto(projeto);
      return ResponseEntity.ok(novoProjeto);
    }
}
