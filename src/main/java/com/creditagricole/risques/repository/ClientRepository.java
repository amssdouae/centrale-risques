package com.creditagricole.risques.repository;

import com.creditagricole.risques.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}