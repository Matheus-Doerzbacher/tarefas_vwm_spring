package com.example.tarefas_vwm.controller;

import com.example.tarefas_vwm.model.Lembrete;
import com.example.tarefas_vwm.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lembretes")
@CrossOrigin(origins = "*")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @GetMapping
    public List<Lembrete> getAllLembretes() {
        return lembreteService.findAll();
    }

    @PostMapping
    public Lembrete createLembrete(@RequestBody Lembrete lembrete) {
        return lembreteService.create(lembrete);
    }

    @GetMapping("/{id}")
    public Optional<Lembrete> getLembreteById(@PathVariable Long id) {
        return lembreteService.findById(id);
    }

    @PutMapping("/{id}")
    public Lembrete updateLembrete(@PathVariable Long id, @RequestBody Lembrete lembrete) {
        return lembreteService.update(id, lembrete);
    }

    @DeleteMapping("/{id}")
    public void deleteLembrete(@PathVariable Long id) {
        lembreteService.delete(id);
    }
}