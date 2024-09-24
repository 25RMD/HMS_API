package com.postgresql.carehms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "patient_basic_information")
public class PatientBasicInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mr_number", nullable = false, unique = true)
    private String mrNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    private String occupation;

    @Column(name = "mobile_number", nullable = false)
    private int mobileNumber;

    private String title;

    @Column(name = "additional_number")
    private int addtionalNumber;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String email;

    private String gender;

    @Column(name = "genotype", nullable = false)
    private String genotype;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_patient_contact")
    private PatientContact PatientContact;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_patient_mr_number", referencedColumnName = "mr_number")
    private List<SponsorInformation> SponsorInformation;
}
