package com.challenge2.Repository;

import com.challenge2.Entity.Clients;
import com.challenge2.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface saleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
