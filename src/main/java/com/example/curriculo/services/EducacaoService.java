package com.example.curriculo.services;

import com.example.curriculo.model.Educacao;
import com.example.curriculo.repository.EducacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacaoService {

    @Autowired
    private EducacaoRepository educacaoRepository;

    public List<Educacao> listarTodas() {
        return educacaoRepository.findAll();
    }

    public Educacao criarEducacao(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    public Educacao atualizarEducacao(Long id, Educacao educacao) {
        if (!educacaoRepository.existsById(id)) {
            throw new RuntimeException("Educação não encontrada");
        }
        educacao.setId(id); // Define o id da entidade para ser atualizado
        return educacaoRepository.save(educacao);
    }

    public void deletarEducacao(Long id) {
        if (!educacaoRepository.existsById(id)) {
            throw new RuntimeException("Educação não encontrada");
        }
        educacaoRepository.deleteById(id);
    }

    public Educacao encontrarPorId(Long id) {
        return educacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Educação não encontrada"));
    }
}