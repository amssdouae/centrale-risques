package com.creditagricole.risques.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "INCIDENT_PAIEMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentIncident {

    @Id
    @SequenceGenerator(
            name = "incident_seq",
            sequenceName = "INCIDENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "incident_seq"
    )
    private Long id;

    private String cin;

    private String typeIncident;

    private LocalDate dateIncident;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}