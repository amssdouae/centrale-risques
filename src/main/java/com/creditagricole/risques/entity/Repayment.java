package com.creditagricole.risques.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "REMBOURSEMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repayment {

    @Id
    @SequenceGenerator(
            name = "remboursement_seq",
            sequenceName = "REMBOURSEMENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "remboursement_seq"
    )
    private Long id;

    private Double montant;

    private LocalDate datePaiement;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}