package com.afs.nats.dpsmh.model;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_work")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_id")
    private Long id;
    @NonNull
    @OneToOne
    @JoinColumn(name = "work_id", referencedColumnName = "organization_id")
    @NotNull(message = "Indique compañia")
    private Organization organization;
    @NonNull
    @OneToOne
    @JoinColumn(name = "work_id", referencedColumnName = "tupa_id")
    @NotNull(message = "Indique TUPA")
    private Tupa tupa;
    private String name;
    private Integer year;
    @NonNull
    @Digits(integer = 8, fraction = 2, message = "Numero fuera de estimacion")
    @DecimalMin(value = "0.00", inclusive = false, message = "Indique valor de UIT")
    private BigDecimal uit;
}
