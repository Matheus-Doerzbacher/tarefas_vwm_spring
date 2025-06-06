package com.example.tarefas_vwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.tarefas_vwm.model.Lembrete;
import com.example.tarefas_vwm.model.User;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByUsuario(User usuario);
}