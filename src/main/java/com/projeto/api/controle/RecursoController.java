package com.projeto.api.controle;

import com.projeto.api.modelo.Recurso;
import com.projeto.api.servico.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recurso-controller")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping("buscar/recurso/nome/{nome}")
    public ResponseEntity<List<Recurso>> buscarPorNome(@PathVariable String nome) {
        List<Recurso> recursos = recursoService.buscarPorNome(nome);
        return ResponseEntity.ok(recursos);
    }

    @PostMapping("/salvar/recurso")
    public ResponseEntity<Recurso> criarRecurso(@RequestBody Recurso recurso) {
      Recurso novoRecurso = recursoService.criarRecurso(recurso);
      return ResponseEntity.ok(novoRecurso);
    }

}
