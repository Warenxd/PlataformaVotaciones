package com.example.app.PlataformaVotaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusers;

    @Column(name = "email_user", nullable = false, unique = true)
    private String emailUser;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_registered")
    private Boolean isRegistered;

    @Column(name = "role_admin")
    private Boolean roleAdmin;

    public Boolean getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(Boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
