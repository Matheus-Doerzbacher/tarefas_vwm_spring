package com.example.tarefas_vwm.dto;

import java.time.LocalDateTime;

public class LembreteDTO {
    private Long idLembrete;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private boolean isConcluido;

    public LembreteDTO() {
    }

    public LembreteDTO(Long idLembrete, String titulo, String descricao, LocalDateTime dataHora,
            boolean isConcluido) {
        this.idLembrete = idLembrete;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.isConcluido = isConcluido;
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

    public boolean getIsConcluido() {
        return isConcluido;
    }

    public void setIsConcluido(boolean isConcluido) {
        this.isConcluido = isConcluido;
    }
}