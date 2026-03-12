package com.creditagricole.risques.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GARANTIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collateral {

    @Id
    @SequenceGenerator(
            name = "garantie_seq",
            sequenceName = "GARANTIE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "garantie_seq"
    )
    private Long id;

    private String type;

    private Double valeur;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}