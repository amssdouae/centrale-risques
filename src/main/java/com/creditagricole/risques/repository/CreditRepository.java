package com.creditagricole.risques.repository;

import com.creditagricole.risques.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    List<Credit> findByClientCin(String cin);

}