package com.example.tarefas_vwm.controller;

import com.example.tarefas_vwm.model.Compromisso;
import com.example.tarefas_vwm.service.CompromissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compromissos")
@CrossOrigin(origins = "*")
public class CompromissoController {

    @Autowired
    private CompromissoService compromissoService;

    @GetMapping
    public List<Compromisso> getAllCompromissos() {
        return compromissoService.findAll();
    }

    @PostMapping
    public Compromisso createCompromisso(@RequestBody Compromisso compromisso) {
        return compromissoService.create(compromisso);
    }

    @GetMapping("/{id}")
    public Optional<Compromisso> getCompromissoById(@PathVariable Long id) {
        return compromissoService.findById(id);
    }

    @PutMapping("/{id}")
    public Compromisso updateCompromisso(@PathVariable Long id, @RequestBody Compromisso compromisso) {
        return compromissoService.update(id, compromisso);
    }

    @DeleteMapping("/{id}")
    public void deleteCompromisso(@PathVariable Long id) {
        compromissoService.delete(id);
    }
}