package com.afs.nats.dpsmh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "dps_tupa")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tupa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tupa_id")
	private Long id;
	@NonNull
	@NotEmpty(message ="Indique nombre")
	private String name;
	@NonNull
	@NotNull(message="Indique año")
	private Integer year;
	@NonNull
	@NotEmpty(message ="Indique resolución")
	private String resolution;
	@NotEmpty(message ="Indique TUPA")
	@NonNull
	private String pdfFile;
}
