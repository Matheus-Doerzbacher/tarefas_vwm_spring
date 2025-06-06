package com.example.tarefas_vwm.controller;

import com.example.tarefas_vwm.model.Compromisso;
import com.example.tarefas_vwm.model.User;
import com.example.tarefas_vwm.service.CompromissoService;
import com.example.tarefas_vwm.service.UserService;
import com.example.tarefas_vwm.dto.CompromissoDTO;
import com.example.tarefas_vwm.exception.UsuarioNaoAutenticadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/compromissos")
@CrossOrigin(origins = "*")
public class CompromissoController {

    @Autowired
    private CompromissoService compromissoService;

    @Autowired
    private UserService userService;

    private CompromissoDTO convertToDTO(Compromisso compromisso) {
        return new CompromissoDTO(
                compromisso.getIdCompromisso(),
                compromisso.getTitulo(),
                compromisso.getDescricao(),
                compromisso.getDataHoraInicio(),
                compromisso.getDataHoraFim(),
                compromisso.getLocal());
    }

    @GetMapping
    public List<CompromissoDTO> getAllCompromissos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsuarioNaoAutenticadoException("Usuário não autenticado");
        }

        String email = authentication.getName();
        User usuario = userService.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoAutenticadoException("Usuário não encontrado"));

        return compromissoService.findByUsuario(usuario)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CompromissoDTO createCompromisso(@RequestBody Compromisso compromisso) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsuarioNaoAutenticadoException("Usuário não autenticado");
        }

        String email = authentication.getName();
        User usuario = userService.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoAutenticadoException("Usuário não encontrado"));
        compromisso.setUsuario(usuario);
        return convertToDTO(compromissoService.create(compromisso));
    }

    @GetMapping("/{id}")
    public Optional<CompromissoDTO> getCompromissoById(@PathVariable Long id) {
        return compromissoService.findById(id)
                .map(this::convertToDTO);
    }

    @PutMapping("/{id}")
    public CompromissoDTO updateCompromisso(@PathVariable Long id, @RequestBody Compromisso compromisso) {
        return convertToDTO(compromissoService.update(id, compromisso));
    }

    @DeleteMapping("/{id}")
    public void deleteCompromisso(@PathVariable Long id) {
        compromissoService.delete(id);
    }
}