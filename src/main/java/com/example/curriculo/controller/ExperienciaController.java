package com.example.curriculo.controller;

import com.example.curriculo.model.Experiencia;
import com.example.curriculo.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public List<Experiencia> listarExperiencias() {
        return experienciaService.listarTodas();
    }

    @PostMapping
    public Experiencia adicionarExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.criarExperiencia(experiencia);
    }

    @PutMapping("/{id}")
    public Experiencia atualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        return experienciaService.atualizarExperiencia(id, experiencia);
    }

    @DeleteMapping("/{id}")
    public void deletarExperiencia(@PathVariable Long id) {
        experienciaService.deletarExperiencia(id);
    }

    @GetMapping("/{id}")
    public Experiencia encontrarPorId(@PathVariable Long id) {
        return experienciaService.encontrarPorId(id);
    }
}
