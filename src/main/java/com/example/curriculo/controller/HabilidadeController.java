package com.example.curriculo.controller;

import com.example.curriculo.model.Habilidade;
import com.example.curriculo.services.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public List<Habilidade> listarHabilidades() {
        return habilidadeService.listarTodas();
    }

    @PostMapping
    public Habilidade adicionarHabilidade(@RequestBody Habilidade habilidade) {
        return habilidadeService.criarHabilidade(habilidade);
    }

    @PutMapping("/{id}")
    public Habilidade atualizarHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidade) {
        return habilidadeService.atualizarHabilidade(id, habilidade);
    }

    @DeleteMapping("/{id}")
    public void deletarHabilidade(@PathVariable Long id) {
        habilidadeService.deletarHabilidade(id);
    }

    @GetMapping("/{id}")
    public Habilidade encontrarPorId(@PathVariable Long id) {
        return habilidadeService.encontrarPorId(id);
    }
}
