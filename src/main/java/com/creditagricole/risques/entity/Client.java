package com.creditagricole.risques.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CLIENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_seq",
            sequenceName = "CLIENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_seq"
    )
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String prenom;

    @Column(unique = true)
    private String cin;

    private String typeClient; // PP ou PM

    private String adresse;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Credit> credits;
}