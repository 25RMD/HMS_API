package com.postgresql.carehms.repository;

import com.postgresql.carehms.SponsorInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorInformationRepository extends JpaRepository<SponsorInformation, Long> {
}