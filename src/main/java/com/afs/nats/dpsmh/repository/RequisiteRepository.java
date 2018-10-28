package com.afs.nats.dpsmh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.dpsmh.model.Requisite;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface RequisiteRepository extends JpaRepository<Requisite, Long> {

}
