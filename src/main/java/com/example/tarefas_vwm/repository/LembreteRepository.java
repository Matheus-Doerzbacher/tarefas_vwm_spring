package com.example.tarefas_vwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarefas_vwm.model.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {}