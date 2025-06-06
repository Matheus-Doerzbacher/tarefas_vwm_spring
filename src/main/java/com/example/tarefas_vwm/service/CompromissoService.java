package com.example.tarefas_vwm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefas_vwm.model.Compromisso;
import com.example.tarefas_vwm.model.User;
import com.example.tarefas_vwm.repository.CompromissoRepository;

@Service
public class CompromissoService {
    @Autowired
    private CompromissoRepository compromissoRepository;

    public List<Compromisso> findAll() {
        return compromissoRepository.findAll();
    }

    public List<Compromisso> findByUsuario(User usuario) {
        return compromissoRepository.findByUsuario(usuario);
    }

    public Optional<Compromisso> findById(Long id) {
        return compromissoRepository.findById(id);
    }

    public Compromisso create(Compromisso compromisso) {
        return compromissoRepository.save(compromisso);
    }

    public Compromisso update(Long id, Compromisso compromisso) {
        Compromisso compromissoExistente = compromissoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compromisso não encontrado"));

        compromissoExistente.setTitulo(compromisso.getTitulo());
        compromissoExistente.setDescricao(compromisso.getDescricao());
        compromissoExistente.setDataHoraInicio(compromisso.getDataHoraInicio());
        compromissoExistente.setDataHoraFim(compromisso.getDataHoraFim());
        compromissoExistente.setLocal(compromisso.getLocal());

        return compromissoRepository.save(compromissoExistente);
    }

    public void delete(Long id) {
        compromissoRepository.deleteById(id);
    }
}
