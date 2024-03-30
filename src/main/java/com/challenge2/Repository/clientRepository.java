package com.challenge2.Repository;

import com.challenge2.Entity.Clients;
import com.challenge2.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<Clients, Integer> {
}
