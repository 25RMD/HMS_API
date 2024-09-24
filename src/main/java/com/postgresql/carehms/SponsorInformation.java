package com.postgresql.carehms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "sponsor_information")
public class SponsorInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "authorization_number")
    private String authorizationNumber;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "health_plan_limit")
    private String healthPlanLimit;

    @Column(name = "health_plan_sponsor_type")
    private String healthPlanSponsorType;

    @Column(name = "health_plan_type")
    private String healthPlanType;

    @Column(name = "hmo_number")
    private String HMONumber;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "primary_sponsor")
    private String primarySponsor;

    @Column(name = "visit_deductible_amount")
    private String visitDeductibleAmount;

    @Column(name = "visit_sponsor_monthly_limit")
    private String visitSponsorMonthlyLimit;


}
