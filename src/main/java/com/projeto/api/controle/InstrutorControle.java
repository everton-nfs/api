package com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projeto.api.modelo.Instrutor;
import com.projeto.api.servico.InstrutorServico;

import java.util.List;

@RestController
public class InstrutorControle {

  @Autowired
  private InstrutorServico instrutorServico;

  @PostMapping("/api/salvar/instrutor")
  public ResponseEntity<Instrutor> criarInstrutor(@RequestBody Instrutor instrutor) {
    Instrutor novoInstrutor = instrutorServico.criarInstrutor(instrutor);
    return ResponseEntity.ok(novoInstrutor);
  }

  @GetMapping("/api/instrutores")
  public List<Instrutor> listarInstrutores() {
      return instrutorServico.listarTodos();
  }

  @GetMapping("/api/instrutor/{id}")
  public ResponseEntity<Instrutor> obterInstrutor(@PathVariable int id) {
    Instrutor instrutor = instrutorServico.obterPorId(id);
    if(instrutor == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(instrutor);
  }

  @PutMapping("/api/atualizar/instrutor/{id}")
  public ResponseEntity<Instrutor> atualizarInstrutor(@PathVariable int id, @RequestBody Instrutor instrutor) {
    Instrutor atualizado = instrutorServico.atualizarInstrutor(id, instrutor);
    if(atualizado == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(atualizado);
  }

  @DeleteMapping("/api/deletar/instrutor/{id}")
  public ResponseEntity<Void> deletarInstrutor(@PathVariable int id) {
    if (!instrutorServico.deletarInstrutor(id)) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().build();
  }

}
