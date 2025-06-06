package com.example.tarefas_vwm.controller;

import com.example.tarefas_vwm.model.Lembrete;
import com.example.tarefas_vwm.model.User;
import com.example.tarefas_vwm.service.LembreteService;
import com.example.tarefas_vwm.service.UserService;
import com.example.tarefas_vwm.exception.UsuarioNaoAutenticadoException;
import com.example.tarefas_vwm.dto.LembreteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lembretes")
@CrossOrigin(origins = "*")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @Autowired
    private UserService userService;

    private LembreteDTO convertToDTO(Lembrete lembrete) {
        return new LembreteDTO(
                lembrete.getIdLembrete(),
                lembrete.getTitulo(),
                lembrete.getDescricao(),
                lembrete.getDataCriacao(),
                lembrete.getIsConcluido());
    }

    @GetMapping
    public List<LembreteDTO> getAllLembretes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsuarioNaoAutenticadoException("Usuário não autenticado");
        }

        String email = authentication.getName();
        User usuario = userService.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoAutenticadoException("Usuário não encontrado"));

        return lembreteService.findByUsuario(usuario)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public LembreteDTO createLembrete(@RequestBody Lembrete lembrete) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsuarioNaoAutenticadoException("Usuário não autenticado");
        }

        String email = authentication.getName();
        User usuario = userService.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoAutenticadoException("Usuário não encontrado"));
        lembrete.setUsuario(usuario);
        return convertToDTO(lembreteService.create(lembrete));
    }

    @GetMapping("/{id}")
    public Optional<LembreteDTO> getLembreteById(@PathVariable Long id) {
        return lembreteService.findById(id)
                .map(this::convertToDTO);
    }

    @PutMapping("/{id}")
    public LembreteDTO updateLembrete(@PathVariable Long id, @RequestBody Lembrete lembrete) {
        return convertToDTO(lembreteService.update(id, lembrete));
    }

    @DeleteMapping("/{id}")
    public void deleteLembrete(@PathVariable Long id) {
        lembreteService.delete(id);
    }
}