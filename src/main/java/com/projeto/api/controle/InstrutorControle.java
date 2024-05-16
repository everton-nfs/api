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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor-controle")
public class InstrutorControle {

  @Autowired
  private InstrutorServico instrutorServico;

  @GetMapping("")
  public String boasVindas(){
    return "Seja bem vindo(a) a Aplicação Spring Boot - Gestão de Turmas e Instrutores";
  }

  @PostMapping("/salvar/instrutor")
  public ResponseEntity<Instrutor> criarInstrutor(@RequestBody Instrutor instrutor) {
    Instrutor novoInstrutor = instrutorServico.criarInstrutor(instrutor);
    return ResponseEntity.ok(novoInstrutor);
  }

  @GetMapping("/listar/instrutores")
  public List<Instrutor> listarInstrutores() {
      return instrutorServico.listarTodos();
  }

  @GetMapping("/buscar/instrutor/{id}")
  public ResponseEntity<Instrutor> obterInstrutor(@PathVariable int id) {
    Instrutor instrutor = instrutorServico.obterPorId(id);
    if(instrutor == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(instrutor);
  }

  @PutMapping("/atualizar/instrutor/{id}")
  public ResponseEntity<Instrutor> atualizarInstrutor(@PathVariable int id, @RequestBody Instrutor instrutor) {
    Instrutor atualizado = instrutorServico.atualizarInstrutor(id, instrutor);
    if(atualizado == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(atualizado);
  }

  @DeleteMapping("/deletar/instrutor/{id}")
  public ResponseEntity<Void> deletarInstrutor(@PathVariable int id) {
    if (!instrutorServico.deletarInstrutor(id)) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().build();
  }

  @GetMapping("/buscar/instrutor/nome/{nome}")
  public ResponseEntity<List<Instrutor>> buscarPorNome(@PathVariable String nome) {
      List<Instrutor> instrutores = instrutorServico.buscarPorNome(nome);
      return ResponseEntity.ok(instrutores);
  }

  @GetMapping("/buscar/instrutor/rg/{rg}")
  public ResponseEntity<List<Instrutor>> buscarPorRG(@PathVariable int rg) {
      List<Instrutor> instrutores = instrutorServico.buscarPorRG(rg);
      return ResponseEntity.ok(instrutores);
  }

}
