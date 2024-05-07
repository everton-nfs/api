package com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projeto.api.modelo.Instrutor;
import com.projeto.api.servico.InstrutorServico;

@RestController
public class InstrutorControle {

  @Autowired
  private InstrutorServico instrutorServico;

  @PostMapping("/api/salvar/instrutor")
  public ResponseEntity<Instrutor> criarInstrutor(@RequestBody Instrutor instrutor) {
    Instrutor novoInstrutor = instrutorServico.criarInstrutor(instrutor);
    return ResponseEntity.ok(novoInstrutor);
  }

}
