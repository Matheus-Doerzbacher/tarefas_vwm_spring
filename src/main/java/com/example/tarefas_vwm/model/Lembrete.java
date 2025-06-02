package com.example.tarefas_vwm.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "lembretes")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLembrete;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private User usuario;

    public Lembrete() {
    }

    public Lembrete(Long idLembrete, String titulo, String descricao, LocalDateTime dataHora, User usuario) {
        this.idLembrete = idLembrete;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.usuario = usuario;
    }

    public Long getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(Long idLembrete) {
        this.idLembrete = idLembrete;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
    
