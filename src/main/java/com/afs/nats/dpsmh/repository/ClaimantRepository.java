package com.afs.nats.dpsmh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.dpsmh.model.Claimant;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource(collectionResourceRel = "claimants", path = "claimants")
public interface ClaimantRepository extends JpaRepository<Claimant, Long> {
    @RestResource(path = "by-name")
    List<Claimant> findAllByName(@Param("name") String name);

    @RestResource(path = "by-name-contain")
    List<Claimant> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
