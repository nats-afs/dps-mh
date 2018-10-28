package com.afs.nats.dpsmh.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_claimant")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Claimant  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claimant_id")
    private Long id;
    @NonNull
    @NotBlank(message = "Indique nombre de solicitante")
    private String name;
    @NonNull
    @NotBlank(message = "Indique direccion de solicitante")
    private String address;
    @NonNull
    @Size(min = 7, message = "Telefono debe contener al menos 7 caracteres")
    private String phone;
    @NonNull
    @Email(message = "Ingrese una direccion de email valida")
    @NotBlank(message = "Indique email de solicitante")
    private String email;
    @NonNull
    @NotNull(message = "Indique Documento")
    @Enumerated(EnumType.STRING)
    private DocumentType doc;
    @NonNull
    @NotBlank(message = "Indique numero de documento")
    @Size(min = 8, max = 11, message = "Indique numero de documento de 8 a 11 caracteres")
    private String nroDoc;
}
