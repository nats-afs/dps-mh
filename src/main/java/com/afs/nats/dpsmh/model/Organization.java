package com.afs.nats.dpsmh.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_organization")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;
    @NonNull
    @NotBlank(message = "Indique nombre")
    private String name;
    @NonNull
    @NotBlank(message = "Indique abreviatura")
    private String shortName;
    @NonNull
    @NotBlank(message = "Indique slogan")
    private String slogan;
    @NonNull
    @NotNull
    private String ruc;
    @NonNull
    @NotNull
    private String img;
    @NonNull
    @NotNull
    private String phone;
    @NonNull
    @NotNull
    private String address;
    @NonNull
    @NotNull
    private String web;
}
