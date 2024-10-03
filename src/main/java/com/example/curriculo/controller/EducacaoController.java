package com.example.curriculo.controller;

import com.example.curriculo.model.Educacao;
import com.example.curriculo.services.EducacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educacoes")
public class EducacaoController {

    @Autowired
    private EducacaoService educacaoService;

    @GetMapping
    public List<Educacao> listarEducacoes() {
        return educacaoService.listarTodas();
    }

    @PostMapping
    public Educacao adicionarEducacao(@RequestBody Educacao educacao) {
        return educacaoService.criarEducacao(educacao);
    }

    @PutMapping("/{id}")
    public Educacao atualizarEducacao(@PathVariable Long id, @RequestBody Educacao educacao) {
        return educacaoService.atualizarEducacao(id, educacao);
    }

    @DeleteMapping("/{id}")
    public void deletarEducacao(@PathVariable Long id) {
        educacaoService.deletarEducacao(id);
    }

    @GetMapping("/{id}")
    public Educacao encontrarPorId(@PathVariable Long id) {
        return educacaoService.encontrarPorId(id);
    }
}
