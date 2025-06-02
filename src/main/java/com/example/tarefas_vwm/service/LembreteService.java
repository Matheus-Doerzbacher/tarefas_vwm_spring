package com.example.tarefas_vwm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefas_vwm.model.Lembrete;
import com.example.tarefas_vwm.repository.LembreteRepository;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    public List<Lembrete> findAll() {
        return lembreteRepository.findAll();
    }

    public Optional<Lembrete> findById(Long id) {
        return lembreteRepository.findById(id);
    }

    public Lembrete create(Lembrete lembrete) {
        return lembreteRepository.save(lembrete);
    }

    public Lembrete update(Long id, Lembrete lembrete) {
        Lembrete lembreteExistente = lembreteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Lembrete não encontrado"));

            lembreteExistente.setTitulo(lembrete.getTitulo());
            lembreteExistente.setDescricao(lembrete.getDescricao());
            lembreteExistente.setDataHora(lembrete.getDataHora());

            return lembreteRepository.save(lembreteExistente);
        }


    public void delete(Long id) {
        lembreteRepository.deleteById(id);
    }
}
