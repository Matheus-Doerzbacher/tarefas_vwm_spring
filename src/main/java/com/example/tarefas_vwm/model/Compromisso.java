package com.example.tarefas_vwm.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "compromissos")
public class Compromisso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompromisso;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(nullable = false)
    private LocalDateTime dataHoraFim;

    @Column(nullable = false)
    private String local;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private User usuario;

    public Compromisso() {
    }

    public Compromisso(Long idCompromisso, String titulo, String descricao, LocalDateTime dataHoraInicio,
            LocalDateTime dataHoraFim, String local, User usuario) {
        this.idCompromisso = idCompromisso;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.local = local;
        this.usuario = usuario;
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


    public User getUsuario() {
        return usuario;
    }


    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    

    


}