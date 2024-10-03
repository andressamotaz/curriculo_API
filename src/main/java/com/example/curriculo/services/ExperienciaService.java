package com.example.curriculo.services;

import com.example.curriculo.model.Experiencia;
import com.example.curriculo.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> listarTodas() {
        return experienciaRepository.findAll();
    }

    public Experiencia criarExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia atualizarExperiencia(Long id, Experiencia experiencia) {
        if (!experienciaRepository.existsById(id)) {
            throw new RuntimeException("Experiência não encontrada");
        }
        experiencia.setId(id); // Define o id da entidade para ser atualizado
        return experienciaRepository.save(experiencia);
    }

    public void deletarExperiencia(Long id) {
        if (!experienciaRepository.existsById(id)) {
            throw new RuntimeException("Experiência não encontrada");
        }
        experienciaRepository.deleteById(id);
    }

    public Experiencia encontrarPorId(Long id) {
        return experienciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiência não encontrada"));
    }
}
