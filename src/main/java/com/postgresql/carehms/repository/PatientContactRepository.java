package com.postgresql.carehms.repository;

import com.postgresql.carehms.PatientContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientContactRepository extends JpaRepository<PatientContact, Long> {
}