package com.example.tarefas_vwm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isAdmin;

    
    public User() {}


    public User(Long idUsuario, String email, String password, String name, boolean isAdmin) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }


    public Long getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isAdmin() {
        return isAdmin;
    }


    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    


    
}
