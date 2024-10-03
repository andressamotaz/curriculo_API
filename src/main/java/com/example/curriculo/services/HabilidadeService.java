package com.example.curriculo.services;

import com.example.curriculo.model.Habilidade;
import com.example.curriculo.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public List<Habilidade> listarTodas() {
        return habilidadeRepository.findAll();
    }

    public Habilidade criarHabilidade(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public Habilidade atualizarHabilidade(Long id, Habilidade habilidade) {
        if (!habilidadeRepository.existsById(id)) {
            throw new RuntimeException("Habilidade não encontrada");
        }
        habilidade.setId(id); // Define o id da entidade para ser atualizado
        return habilidadeRepository.save(habilidade);
    }

    public void deletarHabilidade(Long id) {
        if (!habilidadeRepository.existsById(id)) {
            throw new RuntimeException("Habilidade não encontrada");
        }
        habilidadeRepository.deleteById(id);
    }

    public Habilidade encontrarPorId(Long id) {
        return habilidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
    }
}
