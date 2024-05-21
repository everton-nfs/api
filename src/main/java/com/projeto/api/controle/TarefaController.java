package com.projeto.api.controle;

import com.projeto.api.modelo.Recurso;
import com.projeto.api.modelo.Tarefa;
import com.projeto.api.servico.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefa-controller")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("buscar/tarefa/status/{status}")
    public ResponseEntity<List<Tarefa>> buscarPorStatus(@PathVariable String status) {
        List<Tarefa> tarefas = tarefaService.buscarPorStatus(status);
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping("/salvar/tarefa")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
      Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
      return ResponseEntity.ok(novaTarefa);
    }
}
