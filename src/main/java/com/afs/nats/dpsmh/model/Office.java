package com.afs.nats.dpsmh.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dps_office")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String shortName;
    @NonNull
    private String description;
    @NonNull
    private Boolean active;
}
