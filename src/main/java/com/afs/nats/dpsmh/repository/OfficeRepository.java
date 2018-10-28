package com.afs.nats.dpsmh.repository;

import com.afs.nats.dpsmh.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface OfficeRepository extends JpaRepository<Office,Long> {
}
