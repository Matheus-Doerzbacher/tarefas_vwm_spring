package com.example.tarefas_vwm.dto;

import java.time.LocalDateTime;

public class CompromissoDTO {
    private Long idCompromisso;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String local;

    public CompromissoDTO() {
    }

    public CompromissoDTO(Long idCompromisso, String titulo, String descricao, LocalDateTime dataHoraInicio,
            LocalDateTime dataHoraFim, String local) {
        this.idCompromisso = idCompromisso;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.local = local;
    }

    public Long getIdCompromisso() {
        return idCompromisso;
    }

    public void setIdCompromisso(Long idCompromisso) {
        this.idCompromisso = idCompromisso;
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

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}