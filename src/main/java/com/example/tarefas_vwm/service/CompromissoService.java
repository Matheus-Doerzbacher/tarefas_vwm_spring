package com.example.tarefas_vwm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefas_vwm.model.Compromisso;
import com.example.tarefas_vwm.repository.CompromissoRepository;

@Service
public class CompromissoService {
    @Autowired
    private CompromissoRepository compromissoRepository;

    public List<Compromisso > findAll() {
        return compromissoRepository.findAll();
    }

    public Optional<Compromisso> findById(Long id) {
        return compromissoRepository.findById(id);
    }

    public Compromisso create(Compromisso Compromisso) {
        return compromissoRepository.save(Compromisso);
    }

    public Compromisso update(Long id, Compromisso Compromisso) {
        Compromisso CompromissoExistente = compromissoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Compromisso não encontrado"));

            CompromissoExistente.setTitulo(Compromisso.getTitulo());
            CompromissoExistente.setDescricao(Compromisso.getDescricao());
            CompromissoExistente.setDataHoraInicio(Compromisso.getDataHoraInicio());
            CompromissoExistente.setDataHoraFim(Compromisso.getDataHoraFim());
            CompromissoExistente.setLocal(Compromisso.getLocal());

            return compromissoRepository.save(CompromissoExistente);
        }


    public void delete(Long id) {
        compromissoRepository.deleteById(id);
    }
}
