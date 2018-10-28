package com.afs.nats.dpsmh.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dps_role")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @ManyToMany(mappedBy = "roles")
    private  Set<User> users = new HashSet<>();
}
