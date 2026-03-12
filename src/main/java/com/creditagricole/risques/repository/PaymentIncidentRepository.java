package com.creditagricole.risques.repository;

import com.creditagricole.risques.entity.PaymentIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentIncidentRepository extends JpaRepository<PaymentIncident, Long> {

    List<PaymentIncident> findByCin(String cin);

}