package com.afs.nats.dpsmh.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_user")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NonNull
    @NotEmpty(message = "Nombre de usuario requerido")
    private String username;
    @NonNull
    @NotEmpty(message = "Password requerido")
    private String password;
    @NonNull
    @NotEmpty(message = "Rol requerido")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dps_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @NonNull
    private Boolean active;
}
