package com.afs.nats.dpsmh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_requisite")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Requisite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "requisite_id")
    private Long id;
    @NonNull
    @NotNull
    @NotBlank(message = "Indique nombre de requisito")
    private String name;
    @NonNull
    @NotNull
    @NotBlank(message = "Indique descripcion de requisito")
    private String description;
    @NonNull
    @ManyToMany(mappedBy = "requisites")
    @NotNull
    private Set<Procedure> procedures = new HashSet<Procedure>();
}
