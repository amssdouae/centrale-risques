package com.creditagricole.risques.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CREDIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {

    @Id
    @SequenceGenerator(
            name = "credit_seq",
            sequenceName = "CREDIT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_seq"
    )
    private Long id;

    private Double montant;

    private String typeCredit;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Collateral> garanties;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Repayment> remboursements;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<PaymentIncident> incidents;
}