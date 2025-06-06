package com.example.tarefas_vwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.tarefas_vwm.model.Compromisso;
import com.example.tarefas_vwm.model.User;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {
    List<Compromisso> findByUsuario(User usuario);
}