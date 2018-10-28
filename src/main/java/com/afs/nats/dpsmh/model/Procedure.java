package com.afs.nats.dpsmh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_procedure")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    @ManyToOne
    @NotNull
    private Tupa tupa;
    @NonNull
    @NotNull
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dps_procedure_requisite",
            joinColumns = {@JoinColumn(name = "procedure_id")},
            inverseJoinColumns = {@JoinColumn(name = "requisite_id")}
    )
    private Set<Requisite> requisites = new HashSet<Requisite>();

}
