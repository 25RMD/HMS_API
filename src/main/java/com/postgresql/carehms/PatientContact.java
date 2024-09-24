package com.postgresql.carehms;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "patient_contact")
public class PatientContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String city;

    private String country;

    @Column(name = "home_address")
    private String homeAddress;

    private String nationality;

    @Column(name = "next_of_kin_address")
    private String nextOfKinAddress;

    @Column(name = "next_of_kin_name")
    private String nextOfKinName;

    @Column(name = "next_of_kin_phone_no")
    private String nextOfKinPhoneNo;

    @Column(name = "next_of_kin_relation")
    private String nextOfKinRelation;

    private String religion;

    private String state;


    @JsonIgnore
    @OneToOne(mappedBy = "PatientContact")
    private PatientBasicInformation patientBasicInformation;
}
