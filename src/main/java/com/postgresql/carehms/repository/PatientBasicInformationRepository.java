package com.postgresql.carehms.repository;

import com.postgresql.carehms.PatientBasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface PatientBasicInformationRepository extends JpaRepository<PatientBasicInformation, Long> {

    Optional<PatientBasicInformation> findByMrNumber(String mrNumber);
}